import org.testng.annotations.Test;
import pageobjects.UserLoginPage;
<<<<<<< HEAD
import uiTitles.UserLoginPageUITitles;
=======
>>>>>>> 35915db2d6a4a19426cde63e8e95d7e79e4464ce

import static org.testng.Assert.assertEquals;

public class UserLoginPageTest extends AbstractTest {

    @Test
    public void testUserLoginPageFormNames() {
<<<<<<< HEAD
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
=======
        String expectedFormLoginTitle = "Вход";
        String expectedFormRegistrationTitle = "Регистрация";
        String expectedButtonAuthorizationTitle = "Авторизоваться";
        String expectedButtonRegistrationTitle = "Зарегистрироваться";
        String expectedFieldNameTitle = "Имя";
        String expectedFieldEmailTitle = "Email";
        String expectedFieldPasswordTitle = "Пароль";

        UserLoginPage userLoginPage = new UserLoginPage(driver).openPage();

        assertEquals(userLoginPage.getNameTitleLogin(), expectedFormLoginTitle);
        assertEquals(userLoginPage.getNameTitleRegistration(), expectedFormRegistrationTitle);
        assertEquals(userLoginPage.getTitleEmailLogin(), expectedFieldEmailTitle);
        assertEquals(userLoginPage.getTitlePasswordLogin(), expectedFieldPasswordTitle);
        assertEquals(userLoginPage.getTitleNameRegistration(), expectedFieldNameTitle);
        assertEquals(userLoginPage.getTitleEmailRegistration(), expectedFieldEmailTitle);
        assertEquals(userLoginPage.getTitlePasswordRegistration(), expectedFieldPasswordTitle);
        assertEquals(userLoginPage.getButtonAuthorizationName(), expectedButtonAuthorizationTitle);
        assertEquals(userLoginPage.getButtonRegistrationName(), expectedButtonRegistrationTitle);
>>>>>>> 35915db2d6a4a19426cde63e8e95d7e79e4464ce
    }
}
