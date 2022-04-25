import org.testng.annotations.Test;
import pageobjects.UserLoginPage;
import utils.UserCreator;

public class RegistrationFormTest extends AbstractTest {
    UserLoginPage userLoginPage;

    @Test
    public void testRegistrationWithEmptyPassword() throws InterruptedException {
        userLoginPage = new UserLoginPage(driver).openPage();
        userLoginPage.fillFormRegistrationAndClickButtonRegistration(UserCreator.getUserName(), UserCreator.getEmail(), "" );
        userLoginPage.clickButtonRegistration();

        Thread.sleep(3000);
    }
}
