import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import pageobjects.*;
import uiTitles.AddTaskPageUITitles;
import utils.UserCreator;

import static org.testng.Assert.assertEquals;

public class AddTaskPageTest extends AbstractTest {

    private String userName;
    private String userMail;
    private String userPassword;

    @Test
    public void testUIAddTaskPage() {
        AddTaskPage addTaskPage = new UserLoginPage(driver).openPage()
                .fillFormRegistrationAndClickButtonRegistration(UserCreator.getUserName(), UserCreator.getEmail(), UserCreator.getPassword())
                .clickButtonTasks().addNewTask();

        assertEquals(addTaskPage.getHeadingAddTaskText(), AddTaskPageUITitles.EXPECTED_PAGE_ADD_HEADING_TITLE);
        assertEquals(addTaskPage.getLabelNameText(), AddTaskPageUITitles.EXPECTED_PAGE_ADD_TASK_NAME_TITLE);
        assertEquals(addTaskPage.getLabelResponsibleText(), AddTaskPageUITitles.EXPECTED_PAGE_ADD_RESPONSIBLE_TITLE);
        assertEquals(addTaskPage.getLabelDescriptionText(), AddTaskPageUITitles.EXPECTED_PAGE_ADD_TASK_DESCRIPTION_TITLE);
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
        assertEquals(addTaskPage.getMessageIfFieldDescriptionIsEmpty(), AddTaskPageUITitles.EXPECTED_EMPTY_INPUT_FIELD_MESSAGE_RUS);

        //проверка для английской локализации браузера
        //assertEquals(addTaskPage.getMessageIfFieldDescriptionIsEmpty(), AddTaskPageUITitles.EXPECTED_EMPTY_INPUT_FIELD_MESSAGE_ENG);
    }
}
