package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TasksPage extends AbstractPage {
    public static final String HEADING_TASKS = "Задачи";
    public static final String TABLE_HEADING_NAME = "Название";
    public static final String TABLE_HEADING_SCHEDULE = "Расписание";
    public static final String BUTTON_LABEL_ADD_TASK = "Добавить задачу";

    private final String TASKS_PAGE_URL = BASE_URL + "/tasks/index.html";

    private WebDriver driver;

    @FindBy(tagName = "h2")
    private WebElement pageTitle;
    @FindBy(xpath = "//table/thead//td[1]")
    private WebElement columnTitleTaskName;
    @FindBy(xpath = "//table/thead//td[2]")
    private WebElement columnTitleSchedule;
    @FindBy(xpath = "//a[@href='/tasks/add.html']")
    private WebElement buttonAddTask;
    @FindBy(xpath = "(//table[@class='table']//a[@class='btn btn-danger'])[1]")
    private WebElement buttonChangeTask;
    @FindBy(xpath = "//div[@class='notifications bottom-right']")
    private WebElement tooltip;

    public TasksPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public TasksPage openPage() {
        driver.get(TASKS_PAGE_URL);
        return this;
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public String getColumnTitleTaskName() {
        return columnTitleTaskName.getText();
    }

    public String getColumnTitleSchedule() {
        return columnTitleSchedule.getText();
    }

    public String getButtonAddTaskName() {
        return buttonAddTask.getText();
    }

    public String getTooltipTitle() {
        return tooltip.getText().replaceAll("[^А-Яа-я\" \"]", "");
    }

    public AddTaskPage addNewTask() {
        buttonAddTask.click();
        return new AddTaskPage(driver);
    }

    public EditTaskPage clickButtonChangeTask() {
        buttonChangeTask.click();
        return new EditTaskPage(driver);
    }

    public String getTaskName(String taskName) {
        WebElement taskNameInTable = driver.findElement(By.xpath(getTaskNameXPath(taskName)));
        return taskNameInTable.getText();
    }

    public String getButtonAddToScheduleName(String taskName) {
        WebElement buttonAddToSchedule = driver.findElement(By.xpath(getButtonAddToScheduleXPath(taskName)));
        return buttonAddToSchedule.getText();
    }

    public String getButtonEditTaskName(String taskName) {
        WebElement buttonEditTask = driver.findElement(By.xpath(getButtonEditTaskXPath(taskName)));
        return buttonEditTask.getText();
    }

    public String getButtonDeleteTaskName(String taskName) {
        WebElement buttonDeleteTask = driver.findElement(By.xpath(getButtonDeleteTaskXPath(taskName)));
        return buttonDeleteTask.getText();
    }

    public TasksPage deleteTask(String taskName) {
        WebElement buttonDeleteTask = driver.findElement(By.xpath(getButtonDeleteTaskXPath(taskName)));
        buttonDeleteTask.click();
        return this;
    }

    public EditTaskPage editTask(String taskName) {
        WebElement buttonEditTask = driver.findElement(By.xpath(getButtonEditTaskXPath(taskName)));
        buttonEditTask.click();
        return new EditTaskPage(driver);
    }

    //необходимо добавить PageObject AddTaskToSchedulePage
    /*public AddTaskToSchedulePage addTaskToSchedule(String taskName){
        WebElement buttonAddToSchedule = driver.findElement(By.xpath(getButtonAddToScheduleXPath(taskName)));
        buttonAddToSchedule.click();
        return new AddTaskToSchedulePage(driver);
    }*/

    private String getTaskXPathByTaskName(String taskName) {
        String defaultTaskNameLocator = "//table//a[text()='%s']//ancestor::tr";
        return String.format(defaultTaskNameLocator, taskName);
    }

    private String getTaskNameXPath(String taskName) {
        String xpathNamePart = "//td[1]//a";
        return getTaskXPathByTaskName(taskName).concat(xpathNamePart);
    }

    private String getButtonAddToScheduleXPath(String taskName) {
        String xpathButtonSchedulePart = "//td[2]//a";
        return getTaskXPathByTaskName(taskName).concat(xpathButtonSchedulePart);
    }

    private String getButtonEditTaskXPath(String taskName) {
        String xpathButtonEditTaskPart = "//td[3]//a";
        return getTaskXPathByTaskName(taskName).concat(xpathButtonEditTaskPart);
    }

    private String getButtonDeleteTaskXPath(String taskName) {
        String xpathButtonDeleteTaskPart = "//td[4]//a";
        return getTaskXPathByTaskName(taskName).concat(xpathButtonDeleteTaskPart);
    }
}
