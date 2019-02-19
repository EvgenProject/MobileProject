package mobile.pages;

import basic.TestDriver;
import basic.interfaces.pages.IMainUserPage;
import general.pages.MainUserPage;

public class MobileMainUserPage extends MainUserPage implements IMainUserPage {

    public MobileMainUserPage(TestDriver driver) {
        super(driver);
    }

    @Override
    public void hidePopUp() {
        successfulLogin.click();
    }

    @Override
    public void chooseAdvertisement(String choice) {
        if(choice.equals("yes"))
            System.out.println("Here");
            acceptAdvertisement.click();
        cancelAdvertisement.click();
    }
}
