import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.TasksPage;
import pageobjects.UserLoginPage;
import uiTitles.TasksPageUITitles;
import utils.UserCreator;

public class TasksPageTest extends AbstractTest {

    @Test
    public void testUITasksPage() {
        TasksPage tasksPage = new UserLoginPage(driver).openPage()
                .fillFormRegistration(UserCreator.getUserName(),UserCreator.getEmail(),UserCreator.getPassword())
                .clickButtonTasks();
        Assert.assertEquals(tasksPage.getPageTitle(), TasksPageUITitles.EXPECTED_PAGE_TITLE);
        Assert.assertEquals(tasksPage.getColumnTitleTaskName(), TasksPageUITitles.EXPECTED_COLUMN_TASK_NAME_TITLE);
        Assert.assertEquals(tasksPage.getColumnTitleSchedule(), TasksPageUITitles.EXPECTED_COLUMN_SCHEDULE_TITLE);
        Assert.assertEquals(tasksPage.getButtonAddTaskName(), TasksPageUITitles.EXPECTED_BUTTON_ADD_TASK_TITLE);
    }
}
