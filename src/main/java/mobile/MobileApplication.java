package mobile;

import basic.TestDriver;
import basic.interfaces.IApplication;
import basic.interfaces.pages.*;
import mobile.pages.*;

public class MobileApplication implements IApplication {

    private TestDriver driver;

    public MobileApplication (TestDriver driver) {
        this.driver = driver;
    }

    @Override
    public IWelcomePage welcomePage() {
        return new MobileWelcomePage(driver);
    }

    @Override
    public INewUserPage newUserPage() {
        return new MobileNewUserPage(driver);
    }

    @Override
    public IExistUserPage existUserPage() {
        return new MobileExistUserPage(driver);
    }

    @Override
    public IForgotPasswordPage forgotPasswordPage() {
        return new MobileForgotPasswordPagePage(driver);
    }

    @Override
    public IMainUserPage mainUserPage() {
        return new MobileMainUserPage(driver);
    }
}
