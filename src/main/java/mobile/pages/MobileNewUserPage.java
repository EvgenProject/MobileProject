package mobile.pages;

import basic.TestDriver;
import basic.constants.PagesName;
import basic.interfaces.pages.IWelcomePage;
import basic.interfaces.pages.INewUserPage;
import general.pages.NewUserPage;
import io.appium.java_client.MobileElement;

public class MobileNewUserPage extends NewUserPage implements INewUserPage {

    public MobileNewUserPage(TestDriver driver) {
        super(driver);
    }

    @Override
    public IWelcomePage returnToPreviousPage() {
        actions.returnToPreviousElement();
        return (IWelcomePage) returnNextPage(PagesName.WELCOME_PAGE);
    }

    @Override
    public INewUserPage returnToCurrentPage() {
        actions.returnToPreviousElement();
        return (INewUserPage) returnNextPage(PagesName.NEW_USER_PAGE);
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
    public void clickSignUp() {
        registerBtn.click();
    }

    @Override
    public void clickOnSocialNetwork(MobileElement element) {
        element.click();
    }

    @Override
    public MobileElement getVkBtn(){
        return vkBtn;
    }

    @Override
    public MobileElement getFacebookBtn(){
        return facebookBtn;
    }

    @Override
    public MobileElement getGoogleBtn(){
        return googleBtn;
    }
}
