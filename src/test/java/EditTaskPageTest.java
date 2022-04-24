import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.EditTaskPage;
import pageobjects.UserLoginPage;
import uiTitles.EditTaskPageUITitles;
import utils.UserCreator;

public class EditTaskPageTest extends AbstractTest{
    @Test
    public void testUIEditTaskPage() {
        String name="Task";
        String description = "New";
        String responsible = "Raman";

        EditTaskPage editTaskPage = new UserLoginPage(driver).openPage()
                .fillFormRegistrationAndClickButtonRegistration(UserCreator.getUserName(), UserCreator.getEmail(), UserCreator.getPassword())
                .clickButtonTasks().addNewTask().fillFormTaskAddClickButtonAdd(name,description,responsible).clickButtonChangeTask();

        Assert.assertEquals(editTaskPage.getHeadingEditTaskText(), EditTaskPageUITitles.EXPECTED_PAGE_EDIT_HEADING_TITLE);
        Assert.assertEquals(editTaskPage.getLabelNameText(), EditTaskPageUITitles.EXPECTED_FIELD_TASK_EDIT_NAME_TITLE);
        Assert.assertEquals(editTaskPage.getLabelDescriptionText(), EditTaskPageUITitles.EXPECTED_FIELD_TASK_EDIT_DESCRIPTION_TITLE);
        Assert.assertEquals(editTaskPage.getLabelResponsibleText(), EditTaskPageUITitles.EXPECTED_FIELD_TASK_EDIT_RESPONSIBLE_TITLE);
        Assert.assertEquals(editTaskPage.getButtonEditTaskPageText(), EditTaskPageUITitles.EXPECTED_BUTTON_AND_EDIT_TASK_TITLE);
    }
}

