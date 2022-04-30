import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.AuthorizedUserHomePage;
import pageobjects.HomePage;
import pageobjects.UserLoginPage;
import uiTitles.AuthorizedUserHomePageUITitles;
import utils.UserCreator;

import static org.testng.Assert.assertEquals;

public class AuthorizedUserHomePageTest extends AbstractTest{
    public static final String BUTTON_LABEL_USERS = "Пользователи";
    public static final String BUTTON_LABEL_TASKS = "Задачи";
    public static final String BUTTON_LABEL_COMPANIES = "Компании";

    public static final String LINK_VALUE_NOTIFICATIONS = " 0";
    public static final String LINK_VALUE_TASKS = "0 заданий";

    UserLoginPage userLoginPage;
    AuthorizedUserHomePage authorizedUserHomePage;
    HomePage homePage;

    @BeforeMethod
    public void pathToPageAuthorizedUserHome(){
        userLoginPage = new UserLoginPage(driver);

        userLoginPage
                .openPage()
                .fillFormRegistrationAndClickButtonRegistration(
                        UserCreator.getUserName(),
                        UserCreator.getEmail(),
                        UserCreator.getPassword());
    }

    @Test
    public void testAuthorizedUserHomePageUI(){
        authorizedUserHomePage = new AuthorizedUserHomePage(driver);

        Assert.assertEquals(authorizedUserHomePage.getButtonUsers(), BUTTON_LABEL_USERS);
        Assert.assertEquals(authorizedUserHomePage.getButtonTasksName(), BUTTON_LABEL_TASKS);
        Assert.assertEquals(authorizedUserHomePage.getButtonCompanies(), BUTTON_LABEL_COMPANIES);
        Assert.assertEquals(authorizedUserHomePage.getButtonNotificationsName(), LINK_VALUE_NOTIFICATIONS);
        Assert.assertEquals(authorizedUserHomePage.getButtonUserTasksName(), LINK_VALUE_TASKS);
        Assert.assertEquals(authorizedUserHomePage.getDropdownMenuUserAccountName(), UserCreator.getUserName().toLowerCase());
    }

    @Test
    public void testAuthorizedUserHomePageCheckLinkButtonLogOut() {
        homePage = new AuthorizedUserHomePage(driver).logOutAuthorizedUserPage();

        assertEquals(driver.getCurrentUrl(), AuthorizedUserHomePageUITitles.EXPECTED_OPEN_LOG_OUT_USER_PAGE);
    }

}
