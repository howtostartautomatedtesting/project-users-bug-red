import org.testng.annotations.Test;
import pageobjects.EditTaskPage;
import pageobjects.TasksPage;
import pageobjects.UserLoginPage;
import utils.UserCreator;

import static org.testng.Assert.assertEquals;

public class EditTaskPageTest extends AbstractTest {
    public static final String TASK_NAME = "Task";
    public static final String DESCRIPTION_TASK = "Description task";
    public static final String RESPONSIBLE = "1";
    public static final String NEW_TASK_NAME = "Task1";
    public static final String NEW_DESCRIPTION_TASK = "New description";
    public static final String NEW_RESPONSIBLE = "2";
    public static final String EXPECTED_PAGE_TITLE = "Задачи";
    public static final String EXPECTED_TOOLTIP_TITLE = "Задача успешно обновлена";
    public static final String EXPECTED_EMPTY_INPUT_TIP = "Заполните это поле.";
    public static final String EXPECTED_EMPTY_INPUT_TIP_ENG = "Please fill out this field.";


    @Test
    public void tetEditTaskWithValidData() {
        TasksPage tasksPage = new UserLoginPage(driver).openPage()
                .fillFormRegistrationAndClickButtonRegistration(UserCreator.getUserName(), UserCreator.getEmail(), UserCreator.getPassword())
                .clickButtonTasks().addNewTask()
                .fillFormTaskAddClickButtonAdd(TASK_NAME, DESCRIPTION_TASK, RESPONSIBLE)
                .editTask(TASK_NAME).fillFormEditTaskClickChangeTask(NEW_TASK_NAME, NEW_DESCRIPTION_TASK, NEW_RESPONSIBLE);
        assertEquals(tasksPage.getPageTitle(), EXPECTED_PAGE_TITLE);
        assertEquals(tasksPage.getTaskName(NEW_TASK_NAME), NEW_TASK_NAME);
        assertEquals(tasksPage.getTooltipTitle(), EXPECTED_TOOLTIP_TITLE);
    }

    @Test
    public void tetEditTaskWithEmptyFieldTaskName() {
        EditTaskPage editTaskPage = new UserLoginPage(driver).openPage()
                .fillFormRegistrationAndClickButtonRegistration(UserCreator.getUserName(), UserCreator.getEmail(), UserCreator.getPassword())
                .clickButtonTasks().addNewTask().fillFormTaskAddClickButtonAdd(TASK_NAME, DESCRIPTION_TASK, RESPONSIBLE)
                .editTask(TASK_NAME).fillFormEmptyInputEditTaskClickChangeTask("", NEW_DESCRIPTION_TASK, NEW_RESPONSIBLE);
        System.out.println(editTaskPage.emptyInputNameTip());
        assertEquals(editTaskPage.emptyInputNameTip(), EXPECTED_EMPTY_INPUT_TIP); // для RUS локали
        //assertEquals(editTaskPage.emptyInputNameTip(),EXPECTED_EMPTY_INPUT_TIP_ENG); // для ENG локали
        //на сайте меняется язык подсказок
    }

    @Test
    public void tetEditTaskWithEmptyFieldTaskDescription() {
        EditTaskPage editTaskPage = new UserLoginPage(driver).openPage()
                .fillFormRegistrationAndClickButtonRegistration(UserCreator.getUserName(), UserCreator.getEmail(), UserCreator.getPassword())
                .clickButtonTasks().addNewTask().fillFormTaskAddClickButtonAdd(TASK_NAME, DESCRIPTION_TASK, RESPONSIBLE)
                .editTask(TASK_NAME).fillFormEmptyInputEditTaskClickChangeTask(NEW_TASK_NAME, "", NEW_RESPONSIBLE);
        assertEquals(editTaskPage.emptyInputDescriptionTip(), EXPECTED_EMPTY_INPUT_TIP); // для RUS локали
        // assertEquals(editTaskPage.emptyInputDescriptionTip(),EXPECTED_EMPTY_INPUT_TIP_ENG); // для ENG локали
        //на сайте меняется язык подсказок

    }


}
