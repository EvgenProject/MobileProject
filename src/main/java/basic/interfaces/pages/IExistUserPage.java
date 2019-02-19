package basic.interfaces.pages;

import basic.Page;
import basic.constants.PagesName;
import io.appium.java_client.MobileElement;


public interface IExistUserPage {

    IForgotPasswordPage clickForgotPasLink();
    IWelcomePage returnToPreviousPage();
    MobileElement getVkBtn();
    MobileElement getFacebookBtn();
    MobileElement getGoogleBtn();
    Page clickOnLoginBtn(PagesName page);
    void clickOnSocialNetwork(MobileElement element);
    void setLogin(String login);
    void setPassword(String password);


}
