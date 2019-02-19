package basic.interfaces.pages;

import io.appium.java_client.MobileElement;

public interface IWelcomePage {

    void swipe(String duration);
    INewUserPage clickNewUserBtn();
    IExistUserPage clickExistUserBtn();
    String getText(MobileElement element);
}
