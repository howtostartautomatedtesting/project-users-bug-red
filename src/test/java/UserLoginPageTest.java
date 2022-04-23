import org.testng.annotations.Test;
import pageobjects.UserLoginPage;
import uiTitles.UserLoginPageUITitles;

import static org.testng.Assert.assertEquals;

public class UserLoginPageTest extends AbstractTest {

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
}
