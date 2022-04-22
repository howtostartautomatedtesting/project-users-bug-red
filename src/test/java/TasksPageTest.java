import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.TasksPage;
import pageobjects.UserLoginPage;
import uiTitles.TasksPageUITitles;

public class TasksPageTest extends AbstractTest {

    @Test
    public void testUITaksPage() {
        TasksPage tasksPage = new UserLoginPage(driver).openPage()
                .fillFormLogin("barsov86@yandex.ru", "123")
                .clickButtonTasks();

        Assert.assertEquals(tasksPage.getPageTitle(), TasksPageUITitles.EXPECTED_PAGE_TITLE);
        Assert.assertEquals(tasksPage.getColumnTitleTaskName(), TasksPageUITitles.EXPECTED_COLUMN_TASK_NAME_TITLE);
        Assert.assertEquals(tasksPage.getColumnTitleSchedule(), TasksPageUITitles.EXPECTED_COLUMN_SCHEDULE_TITLE);
        Assert.assertEquals(tasksPage.getButtonAddTaskName(), TasksPageUITitles.EXPECTED_BUTTON_ADD_TASK_TITLE);
    }

}
