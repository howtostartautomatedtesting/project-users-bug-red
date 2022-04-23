import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.*;
import title.TitleTaskPage;

public class AddTaskPageTest extends AbstractTest {

    @Test
    public void testUIAddTaskPage() {

        AddTaskPage addTaskPage = new UserLoginPage(driver).openPage()
                .fillFormRegistration(CreatorNewUsers.getUserName(), CreatorNewUsers.getEmail(), CreatorNewUsers.getPassword())
                .clickButtonTasks().addNewTask();

        Assert.assertEquals(addTaskPage.getHeadingAddTaskText(), TitleTaskPage.EXPECTED_PAGE_HEADING_TITLE);
        Assert.assertEquals(addTaskPage.getLabelNameText(), TitleTaskPage.EXPECTED_FIELD_TASK_NAME_TITLE);
        Assert.assertEquals(addTaskPage.getLabelResponsibleText(), TitleTaskPage.EXPECTED_FIELD_RESPONSIBLE_TITLE);
        Assert.assertEquals(addTaskPage.getLabelDescriptionText(), TitleTaskPage.EXPECTED_FIELD_DESCRIPTION_TITLE);
        Assert.assertEquals(addTaskPage.getButtonAddTaskPageText(), TitleTaskPage.EXPECTED_BUTTON_ADD_TASK_TITLE);

    }
}
