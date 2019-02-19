package general.pages;

import basic.Page;
import basic.TestDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class WelcomePage extends Page {

    public WelcomePage(TestDriver driver) {
        super(driver);
    }

    @Override
    protected String getPageName() {
        return "Welcome page";
    }

    @Override
    protected MobileElement getPageElement() {
        return titleWelcomePage;
    }

    @AndroidFindBy(id = "android:id/content")
    protected MobileElement titleWelcomePage;

    @AndroidFindBy(xpath = "/hierarchy//android.view.ViewGroup[1]//" +
            "android.support.v4.view.ViewPager//android.widget.TextView")
    protected MobileElement elementForSwipe;

    @AndroidFindBy(xpath = "/hierarchy//android.view.ViewGroup[3]/android.view.ViewGroup[1]//android.widget.TextView")
    protected MobileElement newUserBtn;

    @AndroidFindBy(xpath = "/hierarchy//android.view.ViewGroup[3]/android.view.ViewGroup[2]//android.widget.TextView")
    protected MobileElement existUserBtn;

}
