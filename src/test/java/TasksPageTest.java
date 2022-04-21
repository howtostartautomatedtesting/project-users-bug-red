import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.TasksPage;
import pageobjects.UserLoginPage;

public class TasksPageTest extends AbstractTest {

    @Test
    public void testUITaksPage() {
        TasksPage tasksPage = new UserLoginPage(driver).openPage()
                .fillFormLogin("barsov86@yandex.ru", "123")
                .clickButtonTasks();

        Assert.assertEquals(tasksPage.getPageTitle(), "Задачи");
        Assert.assertEquals(tasksPage.getColumnTitleTaskName(), "Название");
        Assert.assertEquals(tasksPage.getColumnTitleSchedule(), "Расписание");
        Assert.assertEquals(tasksPage.getButtonAddTaskName(), "Добавить задачу");
    }

}
