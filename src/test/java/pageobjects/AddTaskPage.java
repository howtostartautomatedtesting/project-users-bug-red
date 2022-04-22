package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddTaskPage extends AbstractPage {
    private WebDriver driver;
    public static final String ADD_TASK_PAGE_URL = BASE_URL + "/tasks/add.html";
    public static final String ADD_TASK_PAGE = BASE_URL + "/user/login/index.html";

    public AddTaskPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[1]/h2")
    private WebElement headingAddTask;
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
    @FindBy(xpath = "//span[@role='textbox']")
    private WebElement dropBoxResponsible;
    @FindBy(xpath = "//input[@class='select2-search__field']")
    private WebElement inputResponsible;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement buttonAddTask;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement buttonTask;
    @FindBy(xpath = "//input[@name='login']")
    private WebElement inputLogin;
    @FindBy(xpath = "//form[@action='/user/login/index.html']//input[@name='password']")
    private WebElement inputPassword;
    @FindBy(xpath = "//form[@action='/user/login/index.html']//input[@class='btn btn-danger']")
    private WebElement buttonAuthorization;
    @FindBy(xpath = "//form[@action='/tasks/do']//input[@value='Добавить задачу']")
    private WebElement selectButtonAddTask;


    public AddTaskPage fillFormLoginAndPassword(String name, String password) {
        openPageLogin();
        inputLogin.sendKeys(name);
        inputPassword.sendKeys(password);
        buttonAuthorization.click();
        return this;
    }

    public String getButtonAddTaskPage() {
        return selectButtonAddTask.getText();
    }

    public String getHeadingAddTaskText() {
        return headingAddTask.getText();
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


    public AddTaskPage openPageLogin() {
        driver.get(ADD_TASK_PAGE);
        return this;
    }

    public AddTaskPage fillName(String name) {
        inputName.sendKeys(name);
        return this;
    }

    public AddTaskPage fillDescription(String description) {
        inputDescription.sendKeys(description);
        return this;
    }

    public AddTaskPage fillResponsible(String responsible) {
        dropBoxResponsible.click();
        inputResponsible.sendKeys(responsible, Keys.ENTER);
        return this;
    }


    public TasksPage clickButtonAddTask() {
        buttonAddTask.click();
        return new TasksPage(driver);
    }

    public AddTaskPage fillFormTaskAdd(String name, String description, String responsible) {
        fillName(name);
        fillDescription(description);
        fillResponsible(responsible);
        return this;
    }

   public TasksPage createNewTask(String name, String description, String responsible) {
        fillName(name);
        fillDescription(description);
        fillResponsible(responsible);
        clickButtonAddTask();
        return new TasksPage(driver);
}

}
