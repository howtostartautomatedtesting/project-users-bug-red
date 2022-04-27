import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.AuthorizedUserHomePage;
import pageobjects.UserLoginPage;
import utils.UserCreator;

public class RegistrationFormTest extends AbstractTest {
    UserLoginPage userLoginPage;
    AuthorizedUserHomePage authorizedUserHomePage;


    @Test
    public void testRegistrationWithEmptyPassword() throws InterruptedException {
        userLoginPage = new UserLoginPage(driver).openPage();
        userLoginPage.fillFormRegistrationAndClickButtonRegistration(UserCreator.getUserName(), UserCreator.getEmail(), "");

        Thread.sleep(3000);
    }

    @Test
    public void testRegistrationWithEmptyEmail() {
        userLoginPage = new UserLoginPage(driver).openPage();
        userLoginPage.fillFormRegistrationAndClickButtonRegistration(UserCreator.getUserName(), "", UserCreator.getPassword());
    }

    @Test
    public void testRegistrationWithEmptyName() {
        userLoginPage = new UserLoginPage(driver).openPage();
        userLoginPage.fillFormRegistrationAndClickButtonRegistration("", UserCreator.getEmail(), UserCreator.getPassword());
    }

    @Test
    public void testRegistrationWithValidData() throws InterruptedException {
        userLoginPage = new UserLoginPage(driver).openPage();
        authorizedUserHomePage = new AuthorizedUserHomePage(driver);

        userLoginPage.fillFormRegistrationAndClickButtonRegistration(UserCreator.getUserName(), UserCreator.getEmail(), UserCreator.getPassword());
        Assert.assertEquals(authorizedUserHomePage.getDropdownMenuUserAccountName(), UserCreator.getUserName().toLowerCase());

        Thread.sleep(3000);
    }

}
