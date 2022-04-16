package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TasksPage extends AbstractPage{

    private WebDriver driver;
    private final String TASKS_PAGE_URL = "http://users.bugred.ru/tasks/index.html";

    @FindBy(tagName = "h2")
    private WebElement pageTitle;

    @FindBy(xpath = "//table/thead//td[1]")
    private WebElement columnTitleTaskName;

    @FindBy(xpath = "//table/thead//td[2]")
    private WebElement columnTitleSchedule;

    @FindBy(xpath = "//a[@class='btn btn-warning']")
    private WebElement buttonAddTask;

    public TasksPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public TasksPage openPage() {
        driver.get(TASKS_PAGE_URL);
        return this;
    }

    public String getPageTitle(){
        return pageTitle.getText();
    }

    public String getColumnTitleTaskName(){
        return columnTitleTaskName.getText();
    }

    public String getColumnTitleSchedule(){
        return columnTitleSchedule.getText();
    }

    public String getButtonAddTaskName(){
        return buttonAddTask.getText();
    }

    public AddTaskPage addNewTask(){
        buttonAddTask.click();
        return new AddTaskPage(driver);
    }

    public String getTaskName(String taskName){
        WebElement taskNameInTable = driver.findElement(By.xpath(getTaskNameXPath(taskName)));
        return taskNameInTable.getText();
    }

    public String getButtonAddToScheduleName(String taskName){
        WebElement buttonAddToSchedule = driver.findElement(By.xpath(getButtonAddToScheduleXPath(taskName)));
        return buttonAddToSchedule.getText();
    }

    public String getButtonEditTaskName(String taskName){
        WebElement buttonEditTask = driver.findElement(By.xpath(getButtonEditTaskXPath(taskName)));
        return buttonEditTask.getText();
    }

    public String getButtonDeleteTaskName(String taskName){
        WebElement buttonDeleteTask = driver.findElement(By.xpath(getButtonDeleteTaskXPath(taskName)));
        return buttonDeleteTask.getText();
    }

    public TasksPage deleteTask(String taskName){
        WebElement buttonDeleteTask = driver.findElement(By.xpath(getButtonDeleteTaskXPath(taskName)));
        buttonDeleteTask.click();
        return this;
    }

    //необходимо добавить PageObject EditTaskPage
    /*public EditTaskPage editTask(String taskName){
        WebElement buttonEditTask = driver.findElement(By.xpath(getButtonEditTaskXPath(taskName)));
        buttonEditTask.click();
        return new EditTaskPage(driver);
    }*/

    //необходимо добавить PageObject AddTaskToSchedulePage
    /*public AddTaskToSchedulePage editTask(String taskName){
        WebElement buttonAddToSchedule = driver.findElement(By.xpath(getButtonAddToScheduleXPath(taskName)));
        buttonAddToSchedule.click();
        return new AddTaskToSchedulePage(driver);
    }*/

    private String getTaskXPathByTaskName(String taskName){
        String defaultTaskNameLocator = "//table//a[text()='%s']//ancestor::tr";
        return String.format(defaultTaskNameLocator, taskName);
    }

    private String getTaskNameXPath(String taskName){
        String xpathNamePart = "td[1]//a";
        return getTaskXPathByTaskName(taskName).concat(xpathNamePart);
    }

    private String getButtonAddToScheduleXPath(String taskName){
        String xpathButtonSchedulePart = "td[2]//a";
        return getTaskXPathByTaskName(taskName).concat(xpathButtonSchedulePart);
    }

    private String getButtonEditTaskXPath(String taskName){
        String xpathButtonEditTaskPart = "td[3]//a";
        return getTaskXPathByTaskName(taskName).concat(xpathButtonEditTaskPart);
    }

    private String getButtonDeleteTaskXPath(String taskName){
        String xpathButtonDeleteTaskPart = "td[4]//a";
        return getTaskXPathByTaskName(taskName).concat(xpathButtonDeleteTaskPart);
    }

}
