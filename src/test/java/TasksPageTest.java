import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.TasksPage;
import utils.UserCreator;

public class TasksPageTest extends AbstractTest {

    @Test
    public void testTasksPageUI() {
        String name = UserCreator.getUserName();
        String email = UserCreator.getEmail();
        String password = UserCreator.getPassword();

        TasksPage tasksPage = new HomePage(driver).openPage().clickButtonLogin()
                .fillFormRegistrationAndClickButtonRegistration(name, email, password)
                .clickButtonTasks();

        Assert.assertEquals(tasksPage.getPageTitle(), TasksPage.HEADING_TASKS);
        Assert.assertEquals(tasksPage.getColumnTitleTaskName(), TasksPage.TABLE_HEADING_NAME);
        Assert.assertEquals(tasksPage.getColumnTitleSchedule(), TasksPage.TABLE_HEADING_SCHEDULE);
        Assert.assertEquals(tasksPage.getButtonAddTaskName(), TasksPage.BUTTON_LABEL_ADD_TASK);
    }
}
