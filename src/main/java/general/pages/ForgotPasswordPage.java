package general.pages;

import basic.Page;
import basic.TestDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ForgotPasswordPage extends Page {

    public ForgotPasswordPage(TestDriver driver) {
        super(driver);
    }

    @Override
    protected String getPageName() {
        return "Forgot Password Page";
    }

    @Override
    protected MobileElement getPageElement() {
        return titleNewUserPage;
    }

    @AndroidFindBy(id = "android:id/content")
    protected MobileElement titleNewUserPage;
}
