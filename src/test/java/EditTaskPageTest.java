import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.EditTaskPage;
import pageobjects.UserLoginPage;
import utils.UserCreator;

public class EditTaskPageTest extends AbstractTest{

    @Test
    public void testUIEditTaskPage() throws InterruptedException {
        String name="Task";
        String description = "New";
        String responsible = "";

        EditTaskPage editTaskPage = new UserLoginPage(driver).openPage()
                .fillFormRegistrationAndClickButtonRegistration(
                        UserCreator.getUserName(),
                        UserCreator.getEmail(),
                        UserCreator.getPassword())
                .clickButtonTasks()
                    .addNewTask()
                    .fillFormTaskAddClickButtonAdd(name,description,responsible)
                    .clickButtonChangeTask();

        Assert.assertEquals(editTaskPage.getHeadingEditTaskText(), EditTaskPage.HEADING_EDIT_TASK);
        Assert.assertEquals(editTaskPage.getLabelNameText(), EditTaskPage.LABEL_NAME);
        Assert.assertEquals(editTaskPage.getLabelDescriptionText(), EditTaskPage.LABEL_DESCRIPTION);
        Assert.assertEquals(editTaskPage.getLabelResponsibleText(), EditTaskPage.LABEL_RESPONSIBLE);
        Assert.assertEquals(editTaskPage.getButtonEditTaskPageText(), EditTaskPage.BUTTON_LABEL_EDIT_TASK);
    }
}
