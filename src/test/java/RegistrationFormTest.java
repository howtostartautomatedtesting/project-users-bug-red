import org.testng.annotations.Test;
import pageobjects.UserLoginPage;
import utils.UserCreator;

public class RegistrationFormTest extends AbstractTest {
    UserLoginPage userLoginPage;

    @Test
    public void testRegistrationWithEmptyPassword() throws InterruptedException {
        userLoginPage = new UserLoginPage(driver).openPage();
        userLoginPage.fillFormRegistrationAndClickButtonRegistration(UserCreator.getUserName(), UserCreator.getEmail(), "");
        userLoginPage.clickButtonRegistration();

        Thread.sleep(3000);
    }

    @Test
    public void testRegistrationWithEmptyEmail() {
        userLoginPage = new UserLoginPage(driver).openPage();
        userLoginPage.fillFormRegistrationAndClickButtonRegistration(UserCreator.getUserName(), "", UserCreator.getPassword());
        userLoginPage.clickButtonRegistration();
    }

    @Test
    public void testRegistrationWithEmptyName() {
        userLoginPage = new UserLoginPage(driver).openPage();
        userLoginPage.fillFormRegistrationAndClickButtonRegistration("", UserCreator.getEmail(), UserCreator.getPassword());
        userLoginPage.clickButtonRegistration();
    }


}
