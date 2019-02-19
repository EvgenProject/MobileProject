package basic;

import basic.constants.PagesName;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mobile.pages.*;
import org.openqa.selenium.support.PageFactory;
import utils.SupportActions;

import java.util.concurrent.TimeUnit;

public abstract class Page {

    protected TestDriver driver = null;
    protected SupportActions actions = null;

    public Page (TestDriver driver) {
        this.driver = driver;
        this.actions = driver.getActions();
        PageFactory.initElements(new AppiumFieldDecorator(driver.getDriver(), 20, TimeUnit.SECONDS), this);
    }

    protected abstract String getPageName();

    protected abstract MobileElement getPageElement();

    protected Page returnNextPage(PagesName page){
        switch (page){
            case WELCOME_PAGE: return new MobileWelcomePage(driver);
            case NEW_USER_PAGE: return new MobileNewUserPage(driver);
            case EXIST_USER_PAGE: return new MobileExistUserPage(driver);
            case FORGOT_PASSWORD_PAGE: return new MobileForgotPasswordPagePage(driver);
            case MAIN_USER_PAGE: return new MobileMainUserPage(driver);
            default: return null;
        }
    }
}
