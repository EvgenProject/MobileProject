package basic;

import basic.interfaces.IApplication;
import com.beust.jcommander.ParameterException;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import mobile.MobileApplication;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import utils.SupportActions;
import utils.layers.ADB;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public abstract class TestFrame {


    protected TestDriver driver = null;
    protected AppiumDriverLocalService service = null;
    protected IApplication app = null;


    @Parameters({ "OSName", "deviceName", "platformVersion", "deviceType" })
    @BeforeClass
    public void init(String platform, String deviceName, String platformVersion, String deviceType){
        setMobileParameters(platform,deviceName, platformVersion, deviceType);
        this.driver.setActions(new SupportActions(driver));
    }

    private void setMobileParameters(String platform, String deviceName, String platformVersion,
                                     String deviceType) {
        this.driver = new TestDriver(platform, deviceName, platformVersion, deviceType);
        app = new MobileApplication(driver);
    }

    public void setCapabilities(){
        System.out.println("Inside initDriver method");

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Xiaomi 5plus");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
        //cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiAutomator2");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "10000");
        cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.englishdom.smartwords");
        cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "host.exp.exponent.LauncherActivity");
        //cap.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, "host.exp.exponent.experience.ShellAppActivity");

        try {
            driver.setAppiumDriver(new AndroidDriver<>(new URL("http://127.0.0.1:4725/wd/hub"), cap));//127.0.0.1:4725
            driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    public void runDriver() {
        if (driver.getDriver() == null){
            AppiumServiceBuilder appiumServiceBuilder = new AppiumServiceBuilder();
            appiumServiceBuilder.withIPAddress("127.0.0.1").usingAnyFreePort();
            appiumServiceBuilder.usingPort(4725);
            appiumServiceBuilder.withArgument(GeneralServerFlag.LOG_LEVEL, "info:warn")
                    .withAppiumJS(new File("/usr/lib/node_modules/appium/build/lib/main.js"))
                    .withArgument(GeneralServerFlag.LOG_LEVEL, "info:error")
                    .withArgument(GeneralServerFlag.LOG_LEVEL, "warn:info")
                    .withArgument(GeneralServerFlag.LOG_LEVEL, "warn:error")
                    .withArgument(GeneralServerFlag.LOG_LEVEL, "error");
            service = AppiumDriverLocalService.buildService(appiumServiceBuilder);
            service.start();

            if (service == null || !service.isRunning()){
                throw new AppiumServerHasNotBeenStartedLocallyException("An appium server node is not started!");
            }

            if (driver.getPlatform().equals("Android")){
                setCapabilities();
                driver.setAdb(new ADB(driver.getDeviceName()));
            }
            else{
                throw new ParameterException("Device name sets incorrectly!!!");
            }
        }
    }

    public void driverStop() {
        driver.getDriver().closeApp();
        driver.getDriver().quit();
        service.stop();
    }

    @AfterMethod
    public void close(){
        driverStop();
    }
}
