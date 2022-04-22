import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.*;
import title.TitleAddTaskPage;

public class AddTaskPageTest extends AbstractTest {
    private WebDriver driver;
    private AuthorizedUserHomePage authorizedUser;

    @BeforeTest
    public void logInAccount() {
        String testUserEmail = "qqqw@mail.com";
        String testUserPassword = "11111111";
        authorizedUser = new UserLoginPage(driver).openPage()
                .fillFormLoginAndClickButtonAuthorization(testUserEmail, testUserPassword);
    }

    @Test
    public void testUIAddTaskPage() {

        AddTaskPage addTaskPage = authorizedUser.clickButtonTasks().addNewTask();
        Assert.assertEquals(addTaskPage.getHeadingAddTaskText(), TitleAddTaskPage.EXPECTED_PAGE_HEADING_TITLE);
        Assert.assertEquals(addTaskPage.getLabelNameText(), TitleAddTaskPage.EXPECTED_FIELD_TASK_NAME_TITLE);
        Assert.assertEquals(addTaskPage.getLabelResponsibleText(), TitleAddTaskPage.EXPECTED_FIELD_RESPONSIBLE_TITLE);
        Assert.assertEquals(addTaskPage.getLabelDescriptionText(), TitleAddTaskPage.EXPECTED_FIELD_DESCRIPTION_TITLE);
        Assert.assertEquals(addTaskPage.getButtonAddTask(), TitleAddTaskPage.EXPECTED_BUTTON_ADD_TASK_TITLE);

    }


}
