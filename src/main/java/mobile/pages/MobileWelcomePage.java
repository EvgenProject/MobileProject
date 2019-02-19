package mobile.pages;

import basic.TestDriver;
import basic.constants.PagesName;
import basic.interfaces.pages.IExistUserPage;
import basic.interfaces.pages.IWelcomePage;
import basic.interfaces.pages.INewUserPage;
import general.pages.WelcomePage;
import io.appium.java_client.MobileElement;

public class MobileWelcomePage extends WelcomePage implements IWelcomePage {

    public MobileWelcomePage(TestDriver driver){
        super(driver);
    }

    /**
     * Wait until element appears
     *
     * @param element
     *              element which must be appeared
     */
    private void waitElement(MobileElement element) {
        actions.waitForElement(element);
    }

    /**
     * Wait needed element and swipe in left or right duration
     *
     * @param duration
     *          input needed duration as String
     *          <li>left or right</li>
     */
    @Override
    public void swipe(String duration) {
        waitElement(elementForSwipe);
        if(duration.equals("left"))
            actions.scrollByCoordinates(1079, 500, 100, 500, 1000);
        else
            actions.scrollByCoordinates(100, 500, 1079, 500, 1000);
    }

    /**
     *
     * @param element
     *          input needed element
     * @return
     *          Get name element as String
     */
    @Override
    public String getText(MobileElement element) {
        return element.getText();
    }

    /**
     * Click on "I am new user" button
     *
     * @return
     *          Expected page as {@link INewUserPage} page
     */
    @Override
    public INewUserPage clickNewUserBtn() {
        newUserBtn.click();
        return (INewUserPage) returnNextPage(PagesName.NEW_USER_PAGE);
    }

    /**
     * Click on "I already have account Englishdom" button
     *
     * @return
     *          Expected page as {@link IExistUserPage} page
     */
    @Override
    public IExistUserPage clickExistUserBtn() {
        existUserBtn.click();
        return (IExistUserPage) returnNextPage(PagesName.EXIST_USER_PAGE);
    }
}
