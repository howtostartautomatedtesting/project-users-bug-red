import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.AuthorizedUserHomePage;
import pageobjects.TasksPage;
import pageobjects.UserLoginPage;
import title.TitleTaskPage;

public class AuthorizedUserHomePageCheckTest extends AbstractTest {

    @Test
    public void testAuthorizedUserHomePageCheckLinkButtonUserAccount() {

        AuthorizedUserHomePage userHomePage = new UserLoginPage(driver).openPage()
                .fillFormRegistration(CreatorNewUsers.getUserName(), CreatorNewUsers.getEmail(), CreatorNewUsers.getPassword())
                .openUserProfilePage();

        Assert.assertEquals(driver.getCurrentUrl(), TitleTaskPage.EXPECTED_OPEN_USER_PROFILE_PAGE);
    }

    @Test
    public void testAuthorizedUserHomePageCheckLinkButtonLogOut() {

        AuthorizedUserHomePage userHomePage = new UserLoginPage(driver).openPage()
                .fillFormRegistration(CreatorNewUsers.getUserName(), CreatorNewUsers.getEmail(), CreatorNewUsers.getPassword())
                .openUserProfilePage().logOutAuthorizedUserPage();

        Assert.assertEquals(driver.getCurrentUrl(), TitleTaskPage.EXPECTED_OPEN_LOG_OUT_USER_PAGE);
    }

    @Test
    public void testAuthorizedUserCheckButtonCompany() {

        AuthorizedUserHomePage userHomePage = new UserLoginPage(driver).openPage()
                .fillFormRegistration(CreatorNewUsers.getUserName(), CreatorNewUsers.getEmail(), CreatorNewUsers.getPassword())
                .clickButtonCompanies();

        Assert.assertEquals(driver.getCurrentUrl(), TitleTaskPage.EXPECTED_CLICK_BUTTON_COMPANY_PAGE);
    }

    @Test
    public void testAuthorizedUserCheckButtonTasks() {
        TasksPage userHomePage = new UserLoginPage(driver).openPage()
                .fillFormRegistration(CreatorNewUsers.getUserName(), CreatorNewUsers.getEmail(), CreatorNewUsers.getPassword())
                .clickButtonTasks();

        Assert.assertEquals(driver.getCurrentUrl(), TitleTaskPage.EXPECTED_CLICK_BUTTON_TASKS_PAGE);
    }
}