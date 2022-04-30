import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.*;
import utils.UserCreator;

public class AddTaskPageTest extends AbstractTest {

    @Test
    public void testUIAddTaskPage() {
        AddTaskPage addTaskPage = new UserLoginPage(driver).openPage()
                .fillFormRegistrationAndClickButtonRegistration(
                        UserCreator.getUserName(),
                        UserCreator.getEmail(),
                        UserCreator.getPassword())
                .clickButtonTasks().addNewTask();

        Assert.assertEquals(addTaskPage.getHeadingAddTaskText(), AddTaskPage.HEADING_ADD_TASK);
        Assert.assertEquals(addTaskPage.getLabelNameText(), AddTaskPage.LABEL_NAME);
        Assert.assertEquals(addTaskPage.getLabelResponsibleText(), AddTaskPage.LABEL_RESPONSIBLE);
        Assert.assertEquals(addTaskPage.getLabelDescriptionText(), AddTaskPage.LABEL_DESCRIPTION);
    }
}
