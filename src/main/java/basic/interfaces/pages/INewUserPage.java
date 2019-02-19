package basic.interfaces.pages;

import io.appium.java_client.MobileElement;

public interface INewUserPage {

    INewUserPage returnToCurrentPage();
    IWelcomePage returnToPreviousPage();
    MobileElement getVkBtn();
    MobileElement getFacebookBtn();
    MobileElement getGoogleBtn();
    void clickOnSocialNetwork(MobileElement element);
    void clickSignUp();
    void setLogin(String login);
    void setPassword(String password);


}
