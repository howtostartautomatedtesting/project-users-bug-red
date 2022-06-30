import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import pageobjects.AuthorizedUserHomePage;
import pageobjects.HomePage;
import pageobjects.UserLoginPage;
import pageobjects.UserProfilePage;
import utils.UserCreator;

import static org.testng.Assert.assertEquals;

public class UserProfilePageTest extends AbstractTest {

    private String userName;
    private String userMail;
    private String userPassword;

    @BeforeGroups("authorizedUser")
    public void registrationToAccount() {
        userName = UserCreator.getUserName();
        userMail = UserCreator.getEmail();
        userPassword = UserCreator.getPassword();
        new UserLoginPage(driver).openPage()
                .fillFormRegistrationAndClickButtonRegistration(userName, userMail, userPassword)
                .logOutAuthorizedUserPage();
    }

    @Test(groups = "authorizedUser")
    public void testUserProfilePageChangeUsernameWithValidData() throws InterruptedException {
        String expectedName = "newName";
        UserProfilePage userProfilePage = new HomePage(driver).openPage()
                .clickButtonLogin()
                .fillFormLoginAndClickButtonAuthorization(userMail, userPassword)
                .openUserProfilePage()
                .typeName(expectedName)
                .clickButtonSave();
        assertEquals(userProfilePage.getUserName(), expectedName.trim());
    }
}
