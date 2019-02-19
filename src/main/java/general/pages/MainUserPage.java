package general.pages;

import basic.Page;
import basic.TestDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MainUserPage extends Page {

    public MainUserPage(TestDriver driver) {
        super(driver);
    }

    @Override
    protected String getPageName() {
        return "Main User Page";
    }

    @Override
    protected MobileElement getPageElement() {
        return titleMainUserPage;
    }

    @AndroidFindBy(id = "android:id/content")
    protected MobileElement titleMainUserPage;

    @AndroidFindBy(xpath = "hierarchy//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/" +
            "/android.view.ViewGroup[1]/android.widget.ImageView")
    protected MobileElement successfulLogin;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout//android.view.ViewGroup[3]/" +
            "android.view.ViewGroup/android.widget.ImageView")
    protected MobileElement cancelAdvertisement;

    @AndroidFindBy(xpath = "/hierarchy//android.view.ViewGroup[2]//android.view.ViewGroup[10]/" +
            "android.view.ViewGroup/android.widget.TextView")
    protected MobileElement acceptAdvertisement;


}
