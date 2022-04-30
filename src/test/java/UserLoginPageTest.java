import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pageobjects.UserLoginPage;
import static org.testng.Assert.assertEquals;

public class UserLoginPageTest extends AbstractTest {
/*
    private String authorizedUserName;
    private String authorizedUserMail;
    private String authorizedUserPassword;
*/

    @Ignore
    @Test
    public void testUserLoginPageFormNames() {
        UserLoginPage userLoginPage = new UserLoginPage(driver).openPage();

        assertEquals(userLoginPage.getNameTitleLogin(), UserLoginPage.EXPECTED_FORM_LOGIN_TITLE);
        assertEquals(userLoginPage.getNameTitleRegistration(), UserLoginPage.EXPECTED_FORM_REGISTRATION_TITLE);
        assertEquals(userLoginPage.getTitleEmailLogin(), UserLoginPage.EXPECTED_FIELD_EMAIL_TITLE);
        assertEquals(userLoginPage.getTitlePasswordLogin(), UserLoginPage.EXPECTED_FIELD_PASSWORD_TITLE);
        assertEquals(userLoginPage.getTitleNameRegistration(), UserLoginPage.EXPECTED_FIELD_NAME_TITLE);
        assertEquals(userLoginPage.getTitleEmailRegistration(), UserLoginPage.EXPECTED_FIELD_EMAIL_TITLE);
        assertEquals(userLoginPage.getTitlePasswordRegistration(), UserLoginPage.EXPECTED_FIELD_PASSWORD_TITLE);
        assertEquals(userLoginPage.getButtonAuthorizationName(), UserLoginPage.EXPECTED_BUTTON_AUTHORIZATION_TITLE);
        assertEquals(userLoginPage.getButtonRegistrationName(), UserLoginPage.EXPECTED_BUTTON_REGISTRATION_TITLE);
    }

/*    @BeforeGroups("authorizedUser")
    public void registrationToAccount() {
        authorizedUserName = UserCreator.getUserName();
        authorizedUserMail = UserCreator.getEmail();
        authorizedUserPassword = UserCreator.getPassword();

        new UserLoginPage(driver).openPage()
                .fillFormRegistrationAndClickButtonRegistration(authorizedUserName, authorizedUserMail, authorizedUserPassword)
                .logOutAuthorizedUserPage();
    }

    @Test(groups = "authorizedUser")
    public void testUserLoginPageWithValidData() {
        AuthorizedUserHomePage authorizedUserHomePage = new HomePage(driver).openPage()
                .clickButtonLogin()
                .fillFormLoginAndClickButtonAuthorization(authorizedUserMail, authorizedUserPassword);

        // TODO implement method getAuthorizedUserName() in class AuthorizedUserHomePage
        // assertEquals(authorizedUserHomePage.getAuthorizedUserName(), authorizedUserName.toLowerCase());
    }

    @Test(groups = "authorizedUser")
    public void testUserLoginPageWithInvalidEmail() {
        new HomePage(driver).openPage()
                .clickButtonLogin()
                .fillFormLoginAndClickButtonAuthorization(" ", authorizedUserPassword);

        assertEquals(driver.getCurrentUrl(), UserLoginPage.USER_LOGIN_URL);
    }

    @Test(groups = "authorizedUser")
    public void testUserLoginPageWithInvalidPassword() {
        new HomePage(driver).openPage()
                .clickButtonLogin()
                .fillFormLoginAndClickButtonAuthorization(authorizedUserMail, " ");

        assertEquals(driver.getCurrentUrl(), UserLoginPage.USER_LOGIN_URL);
    }

    @Test(groups = "authorizedUser")
    public void testUserLoginPageWithInvalidData() {
        new HomePage(driver).openPage()
                .clickButtonLogin()
                .fillFormLoginAndClickButtonAuthorization(" ", " ");

        assertEquals(driver.getCurrentUrl(), UserLoginPage.USER_LOGIN_URL);
    }*/
}
