import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.*;
import title.TitleAddTaskPage;

public class AddTaskPageTest extends AbstractTest {

    @Test
    public void testUIAddTaskPage() {

        AddTaskPage addTaskPage = new UserLoginPage(driver).openPage()
                .fillFormRegistration(CreatorNewUsers.getUserName(), CreatorNewUsers.getEmail(), CreatorNewUsers.getPassword())
                .clickButtonTasks().addNewTask();

        Assert.assertEquals(addTaskPage.getHeadingAddTaskText(), TitleAddTaskPage.EXPECTED_PAGE_HEADING_TITLE);
        Assert.assertEquals(addTaskPage.getLabelNameText(), TitleAddTaskPage.EXPECTED_FIELD_TASK_NAME_TITLE);
        Assert.assertEquals(addTaskPage.getLabelResponsibleText(), TitleAddTaskPage.EXPECTED_FIELD_RESPONSIBLE_TITLE);
        Assert.assertEquals(addTaskPage.getLabelDescriptionText(), TitleAddTaskPage.EXPECTED_FIELD_DESCRIPTION_TITLE);
        Assert.assertEquals(addTaskPage.getButtonAddTaskPageText(), TitleAddTaskPage.EXPECTED_BUTTON_ADD_TASK_TITLE);

    }
}
