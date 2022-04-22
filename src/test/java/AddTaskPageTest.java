import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.*;

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
        Assert.assertEquals(addTaskPage.getHeadingAddTaskText(), "Добавление задачи");
        Assert.assertEquals(addTaskPage.getLabelNameText(), "Название задачи");
        Assert.assertEquals(addTaskPage.getLabelResponsibleText(), "Ответственный");
        Assert.assertEquals(addTaskPage.getLabelDescriptionText(), "Описание задачи");

    }


}
