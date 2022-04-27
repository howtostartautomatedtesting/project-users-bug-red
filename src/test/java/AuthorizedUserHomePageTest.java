import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.AuthorizedUserHomePage;
import pageobjects.UserLoginPage;
import uiTitles.AuthorizedUserHomePageUITitles;
import utils.UserCreator;

public class AuthorizedUserHomePageTest extends AbstractTest{
    UserLoginPage userLoginPage;
    AuthorizedUserHomePage authorizedUserHomePage;

    @BeforeMethod
    public void pathToPageAuthorizedUserHome(){
        userLoginPage = new UserLoginPage(driver);

        userLoginPage
                .openPage()
                .fillFormRegistrationAndClickButtonRegistration(UserCreator.getUserName(),UserCreator.getEmail(),UserCreator.getPassword());
    }

    @Test
    public void testUserAuthorizedUserHomePageUI(){
        authorizedUserHomePage = new AuthorizedUserHomePage(driver);

        Assert.assertEquals(authorizedUserHomePage.getButtonUsers(), AuthorizedUserHomePageUITitles.EXPECTED_BUTTON_USERS_TITLE);
        Assert.assertEquals(authorizedUserHomePage.getButtonTasksName(), AuthorizedUserHomePageUITitles.EXPECTED_BUTTON_TASKS_TITLE);
        Assert.assertEquals(authorizedUserHomePage.getButtonCompanies(), AuthorizedUserHomePageUITitles.EXPECTED_BUTTON_COMPANIES_TITLE);
        Assert.assertEquals(authorizedUserHomePage.getButtonNotificationsName(), AuthorizedUserHomePageUITitles.EXPECTED_BUTTON_NOTIFICATIONS_TITLE);
        Assert.assertEquals(authorizedUserHomePage.getButtonUserTasksName(), AuthorizedUserHomePageUITitles.EXPECTED_BUTTON_USER_TASKS_TITLE);
        Assert.assertEquals(authorizedUserHomePage.getDropdownMenuUserAccountName(), UserCreator.getUserName().toLowerCase());
    }
}
