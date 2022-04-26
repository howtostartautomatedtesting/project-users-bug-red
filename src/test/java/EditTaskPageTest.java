import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.EditTaskPage;
import pageobjects.UserLoginPage;
import title.TitleTaskPage;

public class EditTaskPageTest extends AbstractTest{
    @Test
    public void testUIEditTaskPage() {
        String name="Task";
        String description = "New";
        String responsible = "Raman";

        EditTaskPage editTaskPage = new UserLoginPage(driver).openPage()
                .fillFormRegistration(CreatorNewUsers.getUserName(), CreatorNewUsers.getEmail(), CreatorNewUsers.getPassword())
                .clickButtonTasks().addNewTask().fillFormTaskAdd(name,description,responsible).getButtonAddTaskPage().getButtonChangeTask();


        Assert.assertEquals(editTaskPage.getHeadingEditTaskText(), TitleTaskPage.EXPECTED_PAGE_EDIT_HEADING_TITLE);
        Assert.assertEquals(editTaskPage.getLabelNameText(), TitleTaskPage.EXPECTED_FIELD_TASK_EDIT_NAME_TITLE);
        Assert.assertEquals(editTaskPage.getLabelDescriptionText(), TitleTaskPage.EXPECTED_FIELD_TASK_EDIT_DESCRIPTION_TITLE);
        Assert.assertEquals(editTaskPage.getLabelResponsibleText(), TitleTaskPage.EXPECTED_FIELD_TASK_EDIT_RESPONSIBLE_TITLE);
        Assert.assertEquals(editTaskPage.getButtonEditTaskPageText(), TitleTaskPage.EXPECTED_BUTTON_AND_EDIT_TASK_TITLE);
    }
}

