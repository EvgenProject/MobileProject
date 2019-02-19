package mobile.pages;

import basic.Page;
import basic.TestDriver;
import basic.constants.PagesName;
import basic.interfaces.pages.IExistUserPage;
import basic.interfaces.pages.IForgotPasswordPage;
import basic.interfaces.pages.IWelcomePage;
import general.pages.ExistUserPage;
import io.appium.java_client.MobileElement;

public class MobileExistUserPage extends ExistUserPage implements IExistUserPage {

    public MobileExistUserPage(TestDriver driver) {
        super(driver);
    }

    @Override
    public IWelcomePage returnToPreviousPage() {
        actions.returnToPreviousElement();
        return (IWelcomePage) returnNextPage(PagesName.WELCOME_PAGE);
    }

    @Override
    public void setLogin(String login) {
        fieldEmail.sendKeys(login);
        actions.hideKeyboard();
    }

    @Override
    public void setPassword(String password) {
        fieldPassword.sendKeys(password);
        actions.hideKeyboard();
    }

    @Override
    public Page clickOnLoginBtn(PagesName page) {
        inputBtn.click();
        return getExpectedPage(page);
    }

    private Page getExpectedPage(PagesName expectedPage){
        switch (expectedPage) {
            case EXIST_USER_PAGE:
                return returnNextPage(PagesName.EXIST_USER_PAGE);
            case MAIN_USER_PAGE:
                return returnNextPage(PagesName.MAIN_USER_PAGE);
            default:
                return null;
        }
    }

    @Override
    public IForgotPasswordPage clickForgotPasLink() {
        forgotPassLink.click();
        return (IForgotPasswordPage) returnNextPage(PagesName.FORGOT_PASSWORD_PAGE);
    }

    @Override
    public void clickOnSocialNetwork(MobileElement element) {
        element.click();
    }

    @Override
    public MobileElement getVkBtn() {
        return vkBtn;
    }

    @Override
    public MobileElement getFacebookBtn() {
        return facebookBtn;
    }

    @Override
    public MobileElement getGoogleBtn() {
        return googleBtn;
    }
}
