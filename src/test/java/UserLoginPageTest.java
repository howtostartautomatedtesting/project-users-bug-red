import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import pageobjects.AuthorizedUserHomePage;
import pageobjects.HomePage;
import pageobjects.UserLoginPage;
import uiTitles.UserLoginPageUITitles;
import utils.UserCreator;

import static org.testng.Assert.assertEquals;

public class UserLoginPageTest extends AbstractTest {

    private String authorizedUserName;
    private String authorizedUserMail;
    private String authorizedUserPassword;

    @Test
    public void testUserLoginPageFormNames() {
        UserLoginPage userLoginPage = new UserLoginPage(driver).openPage();

        assertEquals(userLoginPage.getNameTitleLogin(), UserLoginPageUITitles.EXPECTED_FORM_LOGIN_TITLE);
        assertEquals(userLoginPage.getNameTitleRegistration(), UserLoginPageUITitles.EXPECTED_FORM_REGISTRATION_TITLE);
        assertEquals(userLoginPage.getTitleEmailLogin(), UserLoginPageUITitles.EXPECTED_FIELD_EMAIL_TITLE);
        assertEquals(userLoginPage.getTitlePasswordLogin(), UserLoginPageUITitles.EXPECTED_FIELD_PASSWORD_TITLE);
        assertEquals(userLoginPage.getTitleNameRegistration(), UserLoginPageUITitles.EXPECTED_FIELD_NAME_TITLE);
        assertEquals(userLoginPage.getTitleEmailRegistration(), UserLoginPageUITitles.EXPECTED_FIELD_EMAIL_TITLE);
        assertEquals(userLoginPage.getTitlePasswordRegistration(), UserLoginPageUITitles.EXPECTED_FIELD_PASSWORD_TITLE);
        assertEquals(userLoginPage.getButtonAuthorizationName(), UserLoginPageUITitles.EXPECTED_BUTTON_AUTHORIZATION_TITLE);
        assertEquals(userLoginPage.getButtonRegistrationName(), UserLoginPageUITitles.EXPECTED_BUTTON_REGISTRATION_TITLE);
    }

    @BeforeGroups("authorizedUser")
    public void registrationToAccount() {
        authorizedUserName = UserCreator.getUserName();
        authorizedUserMail = UserCreator.getEmail();
        authorizedUserPassword = UserCreator.getPassword();
        new UserLoginPage(driver).openPage()
                .fillFormRegistrationAndClickButtonRegistration(authorizedUserName,authorizedUserMail, authorizedUserPassword)
                .logOutAuthorizedUserPage();
    }

    @Test(groups = "authorizedUser")
    public void testUserLoginPageWithValidData() {
        AuthorizedUserHomePage authorizedUserHomePage = new HomePage(driver).openPage()
                .clickButtonLogin()
                .fillFormLoginAndClickButtonAuthorization(authorizedUserMail, authorizedUserPassword);
        assertEquals(authorizedUserHomePage.getAuthorizedUserName(), authorizedUserName.toLowerCase());
    }

    @Test
    public void testUserLoginPageWithInvalidEmail(){

    }

    @Test
    public void testUserLoginPageWithInvalidPassword(){

    }

    @Test
    public void testUserLoginPageWithInvalidData(){

    }


}
