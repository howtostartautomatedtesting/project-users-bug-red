import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.TasksPage;
import pageobjects.UserLoginPage;
import utils.UserCreator;

public class TasksPageTest extends AbstractTest {

    @Test
    public void testUITasksPage() {
        TasksPage tasksPage = new UserLoginPage(driver).openPage()
                .fillFormRegistrationAndClickButtonRegistration(
                        UserCreator.getUserName(),
                        UserCreator.getEmail(),
                        UserCreator.getPassword())
                .clickButtonTasks();

        Assert.assertEquals(tasksPage.getPageTitle(), TasksPage.HEADING_TASKS);
        Assert.assertEquals(tasksPage.getColumnTitleTaskName(), TasksPage.TABLE_HEADING_NAME);
        Assert.assertEquals(tasksPage.getColumnTitleSchedule(), TasksPage.TABLE_HEADING_SCHEDULE);
        Assert.assertEquals(tasksPage.getButtonAddTaskName(), TasksPage.BUTTON_LABEL_ADD_TASK);
    }
}
