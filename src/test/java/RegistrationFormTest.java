import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.AuthorizedUserHomePage;
import pageobjects.HomePage;
import utils.UserCreator;

public class RegistrationFormTest extends AbstractTest {
/*
    UserLoginPage userLoginPage;
    AuthorizedUserHomePage authorizedUserHomePage;


    @Ignore
    @Test
    public void testRegistrationWithEmptyPassword() throws InterruptedException {
        userLoginPage = new UserLoginPage(driver).openPage();
        userLoginPage.fillFormRegistrationAndClickButtonRegistration(UserCreator.getUserName(), UserCreator.getEmail(), "");

        // TODO add asserts! here

        // TODO remove sleep!
        //Thread.sleep(3000);
    }

    @Ignore
    @Test
    public void testRegistrationWithEmptyEmail() {
        userLoginPage = new UserLoginPage(driver).openPage();
        userLoginPage.fillFormRegistrationAndClickButtonRegistration(UserCreator.getUserName(), "", UserCreator.getPassword());

        // TODO add asserts! here
    }

    @Ignore
    @Test
    public void testRegistrationWithEmptyName() {
        userLoginPage = new UserLoginPage(driver).openPage();
        userLoginPage.fillFormRegistrationAndClickButtonRegistration("", UserCreator.getEmail(), UserCreator.getPassword());

        // TODO add asserts! here
    }
*/

    @Test
    public void testRegistrationWithValidData() {
/*
        userLoginPage = new UserLoginPage(driver).openPage();
        authorizedUserHomePage = new AuthorizedUserHomePage(driver);

        userLoginPage.fillFormRegistrationAndClickButtonRegistration(
                UserCreator.getUserName(),
                UserCreator.getEmail(),
                UserCreator.getPassword());
*/
        String name = UserCreator.getUserName();
        String email = UserCreator.getEmail();
        String password = UserCreator.getPassword();

        AuthorizedUserHomePage authorizedUserHomePage = new HomePage(driver).openPage().clickButtonLogin()
                .fillFormRegistrationAndClickButtonRegistration(name, email, password);

//        Assert.assertEquals(authorizedUserHomePage.getDropdownMenuUserAccountName(), UserCreator.getUserName().toLowerCase());
        Assert.assertEquals(authorizedUserHomePage.getDropdownMenuUserAccountName(), name.toLowerCase());

        // TODO remove sleep!
        //Thread.sleep(3000);
    }
}
