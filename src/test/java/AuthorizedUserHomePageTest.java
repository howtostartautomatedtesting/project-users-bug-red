import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.AuthorizedUserHomePage;
import pageobjects.UserLoginPage;

public class AuthorizedUserHomePageTest extends AbstractTest{
    UserLoginPage userLoginPage;
    AuthorizedUserHomePage authorizedUserHomePage;

    @BeforeMethod
    public void pathToPageAuthorizedUserHome(){
        userLoginPage = new UserLoginPage(driver);

        userLoginPage
                .openPage()
                .fillFormLogin("ira@mail.ru", "12345");
    }

    @Test
    public void testUserAuthorizedUserHomePageUI(){
        authorizedUserHomePage = new AuthorizedUserHomePage(driver);

        Assert.assertEquals(authorizedUserHomePage.getButtonUsers(), "Пользователи");
        Assert.assertEquals(authorizedUserHomePage.getButtonTasks(), "Задачи");
        Assert.assertEquals(authorizedUserHomePage.getButtonCompanies(), "Компании");
        Assert.assertEquals(authorizedUserHomePage.getButtonNotifications(), " 6");
        Assert.assertEquals(authorizedUserHomePage.getButtonUserTasks(), "0 заданий");
        Assert.assertEquals(authorizedUserHomePage.getDropdownMenuUserAccount(), "Ирусик");
    }
}
