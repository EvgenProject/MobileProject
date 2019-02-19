package basic.interfaces;

import basic.interfaces.pages.*;

public interface IApplication {

    IWelcomePage welcomePage();
    INewUserPage newUserPage();
    IExistUserPage existUserPage();
    IForgotPasswordPage forgotPasswordPage();
    IMainUserPage mainUserPage();
}
