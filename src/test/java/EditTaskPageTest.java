import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.TasksPage;
import pageobjects.UserLoginPage;
import utils.UserCreator;

import static org.testng.Assert.assertEquals;

public class EditTaskPageTest extends AbstractTest {
    public static final String TASK_NAME="Task";
    public static final String DESCRIPTION_TASK="Description task";
    public static final String RESPONSIBLE="1";
    public static final String NEW_TASK_NAME="Task1";
    public static final String NEW_DESCRIPTION_TASK="New description";
    public static final String NEW_RESPONSIBLE="2";
    public static final String EXPECTED_PAGE_TITLE="Задачи";
    public static final String EXPECTED_TOOLTIP_TITLE="Задача успешно обновлена";


    @Test
    public void tetEditTaskWithValidData() {
        TasksPage tasksPage = new UserLoginPage(driver).openPage()
                .fillFormRegistrationAndClickButtonRegistration(UserCreator.getUserName(), UserCreator.getEmail(), UserCreator.getPassword())
                .clickButtonTasks().addNewTask().fillFormTaskAddClickButtonAdd(TASK_NAME, DESCRIPTION_TASK, RESPONSIBLE)
                .editTask("Task").fillFormEditTaskClickChangeTask(NEW_TASK_NAME, NEW_DESCRIPTION_TASK, NEW_RESPONSIBLE);
        assertEquals(tasksPage.getPageTitle(),EXPECTED_PAGE_TITLE);
        assertEquals(tasksPage.getTaskName(NEW_TASK_NAME),NEW_TASK_NAME);
        assertEquals(tasksPage.getTooltipTitle(),EXPECTED_TOOLTIP_TITLE);
    }
    @Test
    public void tetEditTaskWithEmptyFieldTaskName() {
        TasksPage tasksPage = new UserLoginPage(driver).openPage()
                .fillFormRegistrationAndClickButtonRegistration(UserCreator.getUserName(), UserCreator.getEmail(), UserCreator.getPassword())
                .clickButtonTasks().addNewTask().fillFormTaskAddClickButtonAdd(TASK_NAME, DESCRIPTION_TASK, RESPONSIBLE)
                .editTask("Task").fillFormEditTaskClickChangeTask("", NEW_DESCRIPTION_TASK, NEW_RESPONSIBLE);

       // assertEquals(tasksPage.getTooltipTitle(),"Задача успешно добавлена");
    }

    @Test
    public void tetEditTaskWithEmptyFieldTaskDescription() {
        TasksPage tasksPage = new UserLoginPage(driver).openPage()
                .fillFormRegistrationAndClickButtonRegistration(UserCreator.getUserName(), UserCreator.getEmail(), UserCreator.getPassword())
                .clickButtonTasks().addNewTask().fillFormTaskAddClickButtonAdd(TASK_NAME, DESCRIPTION_TASK, RESPONSIBLE)
                .editTask("Task").fillFormEditTaskClickChangeTask(NEW_TASK_NAME, "", NEW_RESPONSIBLE);

    }


}
