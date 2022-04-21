import org.testng.annotations.Test;
import pageobjects.UserLoginPage;

import static org.testng.Assert.assertEquals;

public class UserLoginPageTest extends AbstractTest {

    @Test
    public void testUserLoginPageFormNames() {
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
    }
}
