import basic.TestFrame;
import basic.constants.PagesName;
import basic.interfaces.pages.*;
import org.testng.annotations.Test;

public class TestCase extends TestFrame {

    private IWelcomePage mainPage = null;
    private INewUserPage newUserPage = null;
    private IExistUserPage existUserPage = null;
    private IForgotPasswordPage forgotPasswordPage = null;
    private IMainUserPage mainUserPage = null;

    @Test
    public void test() throws InterruptedException{
        runDriver();
        mainPage = app.welcomePage();
        mainPage.swipe("left");
        mainPage.swipe("left");
        existUserPage = mainPage.clickExistUserBtn();
        existUserPage.setLogin("ev.garmash.pro@gmail.com");
        existUserPage.setPassword("test10");
        mainUserPage = (IMainUserPage) existUserPage.clickOnLoginBtn(PagesName.MAIN_USER_PAGE);
        mainUserPage.hidePopUp();
        //mainUserPage.chooseAdvertisement("no");

        Thread.sleep(10000);
    }
}

