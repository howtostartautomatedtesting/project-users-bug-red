import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.*;
import utils.UserCreator;

public class AddTaskPageTest extends AbstractTest {

    public static final String DESCRIPTION_TASK = "Description task";
    public static final String RESPONSIBLE = "1";
    public static final String EXPECTED_EMPTY_INPUT_TIP = "Заполните это поле.";
    public static final String EXPECTED_EMPTY_INPUT_TIP_ENG = "Please fill out this field.";

    @Test
    public void testUIAddTaskPage() {

        AddTaskPage addTaskPage = new UserLoginPage(driver).openPage()
                .fillFormRegistrationAndClickButtonRegistration(
                        UserCreator.getUserName(),
                        UserCreator.getEmail(),
                        UserCreator.getPassword())
                .clickButtonTasks().addNewTask();

        Assert.assertEquals(addTaskPage.getHeadingAddTaskText(), AddTaskPage.HEADING_ADD_TASK);
        Assert.assertEquals(addTaskPage.getLabelNameText(), AddTaskPage.LABEL_NAME);
        Assert.assertEquals(addTaskPage.getLabelResponsibleText(), AddTaskPage.LABEL_RESPONSIBLE);
        Assert.assertEquals(addTaskPage.getLabelDescriptionText(), AddTaskPage.LABEL_DESCRIPTION);
    }
    @Test
    public void testAddTaskWithEmptyFieldTaskName() {
        AddTaskPage addTaskPage = new UserLoginPage(driver).openPage()
                .fillFormRegistrationAndClickButtonRegistration(
                        UserCreator.getUserName(),
                        UserCreator.getEmail(),
                        UserCreator.getPassword())
                .clickButtonTasks().addNewTask();
        addTaskPage.fillFormTaskAddClickButtonAdd("", DESCRIPTION_TASK, RESPONSIBLE);
        Assert.assertEquals(addTaskPage.emptyInputNameTip(), EXPECTED_EMPTY_INPUT_TIP); // для RUS локали
        //assertEquals(editTaskPage.emptyInputNameTip(),EXPECTED_EMPTY_INPUT_TIP_ENG); // для ENG локали
        //на сайте меняется язык подсказок
    }

}
