import org.testng.annotations.Test;
import pageobjects.EditTaskPage;
import pageobjects.UserLoginPage;
import utils.UserCreator;
import title.TitleTaskPage;

import static org.testng.Assert.assertEquals;

public class EditTaskPageTest extends AbstractTest {
    @Test
    public void testUIEditTaskPage() {
        String name = "Task";
        String description = "New";
        String responsible = "Raman";

        EditTaskPage editTaskPage = new UserLoginPage(driver).openPage()
                .fillFormRegistrationAndClickButtonRegistration(UserCreator.getUserName(), UserCreator.getEmail(), UserCreator.getPassword())
                .clickButtonTasks().addNewTask().fillFormTaskAdd(name, description, responsible).getButtonAddTaskPage().getButtonChangeTask();

        assertEquals(editTaskPage.getHeadingEditTaskText(), TitleTaskPage.EXPECTED_PAGE_EDIT_HEADING_TITLE);
        assertEquals(editTaskPage.getLabelNameText(), TitleTaskPage.EXPECTED_FIELD_TASK_EDIT_NAME_TITLE);
        assertEquals(editTaskPage.getLabelDescriptionText(), TitleTaskPage.EXPECTED_FIELD_TASK_EDIT_DESCRIPTION_TITLE);
        assertEquals(editTaskPage.getLabelResponsibleText(), TitleTaskPage.EXPECTED_FIELD_TASK_EDIT_RESPONSIBLE_TITLE);
    }
}

