import org.testng.annotations.Test;
import pageobjects.AuthorizedUserHomePage;
import pageobjects.CompaniesPage;
import pageobjects.TasksPage;
import pageobjects.UserLoginPage;
import uiTitles.AuthorizedUserHomePageTestSmokeTitles;
import utils.UserCreator;

import static org.testng.Assert.assertEquals;

public class AuthorizedUserHomePageSmokeTest extends AbstractTest {

    @Test
    public void testAuthorizedUserHomePageCheckLinkButtonUserAccount() {

        AuthorizedUserHomePage userHomePage = new UserLoginPage(driver).openPage()
                .fillFormRegistrationAndClickButtonRegistration(UserCreator.getUserName(), UserCreator.getEmail(), UserCreator.getPassword())
                .openUserProfilePage();

        assertEquals(driver.getCurrentUrl(), AuthorizedUserHomePageTestSmokeTitles.EXPECTED_OPEN_USER_PROFILE_PAGE);
    }

    @Test
    public void testAuthorizedUserHomePageCheckLinkButtonLogOut() {

        AuthorizedUserHomePage userHomePage = new UserLoginPage(driver).openPage()
                .fillFormRegistrationAndClickButtonRegistration(UserCreator.getUserName(), UserCreator.getEmail(), UserCreator.getPassword())
                .openUserProfilePage().logOutAuthorizedUserPage();

        assertEquals(driver.getCurrentUrl(), AuthorizedUserHomePageTestSmokeTitles.EXPECTED_OPEN_LOG_OUT_USER_PAGE);
    }

    @Test
    public void testAuthorizedUserCheckButtonCompany() {

        CompaniesPage userHomePage = new UserLoginPage(driver).openPage()
                .fillFormRegistrationAndClickButtonRegistration(UserCreator.getUserName(), UserCreator.getEmail(), UserCreator.getPassword())
                .clickButtonCompanies();

        assertEquals(driver.getCurrentUrl(), AuthorizedUserHomePageTestSmokeTitles.EXPECTED_CLICK_BUTTON_COMPANY_PAGE);
    }

    @Test
    public void testAuthorizedUserCheckButtonTasks() {
        TasksPage userHomePage = new UserLoginPage(driver).openPage()
                .fillFormRegistrationAndClickButtonRegistration(UserCreator.getUserName(), UserCreator.getEmail(), UserCreator.getPassword())
                .clickButtonTasks();

        assertEquals(driver.getCurrentUrl(), AuthorizedUserHomePageTestSmokeTitles.EXPECTED_CLICK_BUTTON_TASKS_PAGE);
    }
}

