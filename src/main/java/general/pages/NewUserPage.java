package general.pages;

import basic.Page;
import basic.TestDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class NewUserPage extends Page {

    public NewUserPage(TestDriver driver) {
        super(driver);
    }

    @Override
    protected String getPageName() {
        return "New User Page";
    }

    @Override
    protected MobileElement getPageElement() {
        return titleNewUserPage;
    }

    @AndroidFindBy(id = "android:id/content")
    protected MobileElement titleNewUserPage;

    @AndroidFindBy(xpath = "/hierarchy//android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.ImageView")
    protected MobileElement backBtn;

    @AndroidFindBy(xpath = "/hierarchy//android.view.ViewGroup[2]//android.view.ViewGroup[1]" +
            "//android.view.ViewGroup[1]/android.widget.EditText")
    protected MobileElement fieldEmail;

    @AndroidFindBy(xpath = "/hierarchy//android.view.ViewGroup[2]//android.view.ViewGroup[1]" +
            "//android.view.ViewGroup[2]/android.widget.EditText")
    protected MobileElement fieldPassword;

    @AndroidFindBy(xpath = "/hierarchy//android.view.ViewGroup[2]//android.view.ViewGroup[1]" +
            "//android.view.ViewGroup[3]//android.widget.TextView")
    protected MobileElement registerBtn;

    @AndroidFindBy(xpath = "/hierarchy//android.view.ViewGroup[2]//android.view.ViewGroup[2]" +
            "/android.view.ViewGroup[1]/android.widget.ImageView")
    protected MobileElement vkBtn;

    @AndroidFindBy(xpath = "/hierarchy//android.view.ViewGroup[2]//android.view.ViewGroup[2]" +
            "/android.view.ViewGroup[2]/android.widget.ImageView")
    protected MobileElement facebookBtn;

    @AndroidFindBy(xpath = "/hierarchy//android.view.ViewGroup[2]//android.view.ViewGroup[2]" +
            "/android.view.ViewGroup[3]/android.widget.ImageView")
    protected MobileElement googleBtn;
}
