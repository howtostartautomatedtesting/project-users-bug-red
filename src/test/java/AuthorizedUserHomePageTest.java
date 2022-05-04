import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.AuthorizedUserHomePage;
import pageobjects.TasksPage;
import pageobjects.UserLoginPage;
import uiTitles.AuthorizedUserHomePageUITitles;
import utils.UserCreator;

import static org.testng.Assert.assertEquals;

public class AuthorizedUserHomePageTest extends AbstractTest {
    public static final String BUTTON_LABEL_USERS = "Пользователи";
    public static final String BUTTON_LABEL_TASKS = "Задачи";
    public static final String BUTTON_LABEL_COMPANIES = "Компании";

    public static final String LINK_VALUE_NOTIFICATIONS = " 0";
    public static final String LINK_VALUE_TASKS = "0 заданий";

    UserLoginPage userLoginPage;
    AuthorizedUserHomePage authorizedUserHomePage;
    TasksPage tasksPage;

    @BeforeMethod
    public void pathToPageAuthorizedUserHome() {
        userLoginPage = new UserLoginPage(driver);

        userLoginPage
                .openPage()
                .fillFormRegistrationAndClickButtonRegistration(
                        UserCreator.getUserName(),
                        UserCreator.getEmail(),
                        UserCreator.getPassword());
    }

    @Test
    public void testAuthorizedUserHomePageUI() {
        authorizedUserHomePage = new AuthorizedUserHomePage(driver);

        assertEquals(authorizedUserHomePage.getButtonUsers(), BUTTON_LABEL_USERS);
        assertEquals(authorizedUserHomePage.getButtonTasksName(), BUTTON_LABEL_TASKS);
        assertEquals(authorizedUserHomePage.getButtonCompanies(), BUTTON_LABEL_COMPANIES);
        assertEquals(authorizedUserHomePage.getButtonNotificationsName(), LINK_VALUE_NOTIFICATIONS);
        assertEquals(authorizedUserHomePage.getButtonUserTasksName(), LINK_VALUE_TASKS);
        assertEquals(authorizedUserHomePage.getDropdownMenuUserAccountName(), UserCreator.getUserName().toLowerCase());
    }

    @Test
    public void testAuthorizedUserCheckButtonTasks() {
        tasksPage = new AuthorizedUserHomePage(driver).clickButtonTasks();

        assertEquals(driver.getCurrentUrl(), AuthorizedUserHomePageUITitles.EXPECTED_CLICK_BUTTON_TASKS_PAGE);
    }

}
