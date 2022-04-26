import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.*;
import uiTitles.AddTaskPageUITitles;
import utils.UserCreator;

public class AddTaskPageTest extends AbstractTest {

    @Test
    public void testUIAddTaskPage() {
        AddTaskPage addTaskPage = new UserLoginPage(driver).openPage()
                .fillFormRegistrationAndClickButtonRegistration(UserCreator.getUserName(), UserCreator.getEmail(), UserCreator.getPassword())
                .clickButtonTasks().addNewTask();

        Assert.assertEquals(addTaskPage.getHeadingAddTaskText(), AddTaskPageUITitles.EXPECTED_PAGE_ADD_HEADING_TITLE);
        Assert.assertEquals(addTaskPage.getLabelNameText(), AddTaskPageUITitles.EXPECTED_PAGE_ADD_TASK_NAME_TITLE);
        Assert.assertEquals(addTaskPage.getLabelResponsibleText(), AddTaskPageUITitles.EXPECTED_PAGE_ADD_RESPONSIBLE_TITLE);
        Assert.assertEquals(addTaskPage.getLabelDescriptionText(), AddTaskPageUITitles.EXPECTED_PAGE_ADD_TASK_DESCRIPTION_TITLE);
    }
}
