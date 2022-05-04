import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import pageobjects.*;
import utils.UserCreator;

import static org.testng.Assert.assertEquals;

public class AddTaskPageTest extends AbstractTest {

    private String userName;
    private String userMail;
    private String userPassword;

    @Test
    public void testUIAddTaskPage() {
        AddTaskPage addTaskPage = new UserLoginPage(driver).openPage()
                .fillFormRegistrationAndClickButtonRegistration(
                        UserCreator.getUserName(),
                        UserCreator.getEmail(),
                        UserCreator.getPassword())
                .clickButtonTasks().addNewTask();

        assertEquals(addTaskPage.getHeadingAddTaskText(), AddTaskPage.HEADING_ADD_TASK);
        assertEquals(addTaskPage.getLabelNameText(), AddTaskPage.LABEL_NAME);
        assertEquals(addTaskPage.getLabelResponsibleText(), AddTaskPage.LABEL_RESPONSIBLE);
        assertEquals(addTaskPage.getLabelDescriptionText(), AddTaskPage.LABEL_DESCRIPTION);
    }


    @BeforeGroups("authorizedUser")
    public void registrationToAccount() {
        userName = UserCreator.getUserName();
        userMail = UserCreator.getEmail();
        userPassword = UserCreator.getPassword();
        new UserLoginPage(driver).openPage()
                .fillFormRegistrationAndClickButtonRegistration(userName, userMail, userPassword)
                .logOutAuthorizedUserPage();
    }

    @Test(groups = "authorizedUser")
    public void testAddTaskPageAddTaskWithEmptyFieldTaskDescription() {
        String taskName = "newTask";
        String taskDescription = "";
        String taskResponsible = userName;

        AddTaskPage addTaskPage = new HomePage(driver).openPage()
                .clickButtonLogin()
                .fillFormLoginAndClickButtonAuthorization(userMail, userPassword)
                .clickButtonTasks()
                .addNewTask();

        addTaskPage.fillFormTaskAddClickButtonAdd(taskName, taskDescription, taskResponsible);

        //проверка для русской локализации браузера
        assertEquals(addTaskPage.getMessageIfFieldDescriptionIsEmpty(), AddTaskPage.MESSAGE_EMPTY_INPUT_FIELD_RUS);

        //проверка для английской локализации браузера
        //assertEquals(addTaskPage.getMessageIfFieldDescriptionIsEmpty(), AddTaskPage.MESSAGE_EMPTY_INPUT_FIELD_ENG);
    }
}
