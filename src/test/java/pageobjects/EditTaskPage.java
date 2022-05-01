package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditTaskPage extends AbstractPage {
    public static final String HEADING_EDIT_TASK = "Редактирование задачи";
    public static final String LABEL_NAME = "Название задачи";
    public static final String LABEL_DESCRIPTION = "Описание задачи";
    public static final String LABEL_RESPONSIBLE = "Ответственный";
    public static final String BUTTON_LABEL_EDIT_TASK = "Изменить задачу";

    private WebDriver driver;

    EditTaskPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[1]/h2")
    private WebElement headingEditTask;
    @FindBy(xpath = "//tr[1]/td[1]")
    private WebElement labelName;
    @FindBy(xpath = "//tr[2]/td[1]")
    private WebElement labelDescription;
    @FindBy(xpath = "//tr[3]/td[1]")
    private WebElement labelResponsible;
    @FindBy(xpath = "//input[@name='name']")
    private WebElement inputName;
    @FindBy(xpath = "//textarea[@name='description']")
    private WebElement inputDescription;
    @FindBy(xpath = "//select[@name='user']")
    private WebElement dropBoxResponsible;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement buttonAddNewTask;
    @FindBy(xpath = "(//table[@class='table']//a[@class='btn btn-danger'])[1]")
    private WebElement buttonChangeTask;

    public String getHeadingEditTaskText() {
        return headingEditTask.getText();
    }

    public String getLabelNameText() {
        return labelName.getText();
    }

    public String getLabelDescriptionText() {
        return labelDescription.getText();
    }

    public String getLabelResponsibleText() {
        return labelResponsible.getText();
    }

    public EditTaskPage fillName(String name) {
        inputName.clear();
        inputName.sendKeys(name);
        return this;
    }

    public String emptyInputNameTip() {
        return inputName.getAttribute("validationMessage");
    }

    public String emptyInputDescriptionTip() {
        return inputDescription.getAttribute("validationMessage");
    }

    public String getButtonEditTaskPageText() {
        return buttonAddNewTask.getAttribute("value");
    }

    public EditTaskPage fillDescription(String description) {
        inputDescription.clear();
        inputDescription.sendKeys(description);
        return this;
    }

    public EditTaskPage fillResponsible(String responsible) {
        dropBoxResponsible.click();
        dropBoxResponsible.sendKeys(responsible, Keys.ENTER);
        return this;
    }

    public EditTaskPage fillFormEditTask(String name, String description, String responsible) {
        fillName(name);
        fillDescription(description);
        fillResponsible(responsible);
        return this;
    }

    public EditTaskPage fillFormEditTaskAndClickButton(String name, String description, String responsible) {
        fillFormEditTask(name, description, responsible);
        buttonChangeTask.click();
        return new EditTaskPage(driver);
    }
}
