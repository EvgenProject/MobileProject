package basic;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utils.SupportActions;
import utils.layers.ADB;


public class TestDriver {

    private AppiumDriver<MobileElement> appiumDriver = null;
    private String platform;
    private String deviceName;
    private String platformVersion;
    private String deviceType;
    private SupportActions actions = null;
    private ADB adb = null;

    public TestDriver(String platform, String deviceName, String platformVersion, String deviceType)
    {
        this.platform = platform;
        this.deviceName = deviceName;
        this.platformVersion = platformVersion;
        this.deviceType = deviceType;
    }

    public AppiumDriver<MobileElement> getDriver() {
        return appiumDriver;
    }

    public void setAppiumDriver(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getPlatformVersion() {
        return platformVersion;
    }

    public void setPlatformVersion(String platformVersion) {
        this.platformVersion = platformVersion;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public SupportActions getActions() {
        return actions;
    }

    public void setActions(SupportActions actions) {
        this.actions = actions;
    }

    public ADB getAdb() {
        return adb;
    }

    public void setAdb(ADB adb) {
        this.adb = adb;
    }
}
