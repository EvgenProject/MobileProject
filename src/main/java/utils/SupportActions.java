package utils;

import basic.TestDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class SupportActions {

    private StringBuilder log = new StringBuilder();
    private TestDriver driver;

    public SupportActions (TestDriver driver){
        this.driver = driver;
    }

    /**
     * 20 sec wait for appearing mobile element on page
     *
     * @param element
     *          {@link MobileElement}
     */
    public void waitForElement(MobileElement element){
        WebDriverWait wait = new WebDriverWait(driver.getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Check if element is presented in page
     *
     * @param element
     *            {@link MobileElement}
     * @return
     *             return true or false AS boolean
     */
    public boolean isElementPresent(MobileElement element){
        try{
            element.isDisplayed();
            return true;
        }catch(NoSuchElementException e){
            return false;
        }
    }

    //for iOS
    public void swipe(MobileElement element, String direction){
        JavascriptExecutor js = (JavascriptExecutor) driver.getDriver();
        Map<String, String> params = new HashMap<>();
        params.put("direction", direction);
        js.executeScript("mobile: swipe", params);
    }

    /**
     * Swipe or scroll to right or to left duration
     *
     * @param startX
     *             Start point horizontally
     * @param startY
     *             Start point vertically
     * @param endX
     *             End point horizontally
     * @param endY
     *             End point vertically
     * @param duration
     *             Length of swipe
     */
    public void scrollByCoordinates(int startX, int startY, int endX, int endY, int duration) {
        new TouchAction(driver.getDriver()).press(startX, startY).waitAction(Duration.ofMillis(duration))
                .moveTo(endX, endY).release().perform();
    }

    /**
     * Hide keyboard if it's present on the screen for specific device by device ID
     */
    public void hideKeyboard() {
        if (driver.getAdb().isKeyboardActivated()) {
            driver.getDriver().hideKeyboard();
        }
    }

    /**
     * Do step back - back button analog
     */
    public void returnToPreviousElement(){
        driver.getDriver().navigate().back();
    }
}
