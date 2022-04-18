package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddTaskPage extends AbstractPage {
    private WebDriver driver;

    AddTaskPage(WebDriver driver) {
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

   /* public TasksPage clickButtonAddTask() {
        buttonAddTask.click();
        return new TasksPage(driver);
    } */

    public AddTaskPage fillFormTaskAdd(String name, String description, String responsible) {
        fillName(name);
        fillDescription(description);
        fillResponsible(responsible);
        return this;
    }

  /*  public TasksPage createNewTask(String name, String description, String responsible) {
        fillName(name);
        fillDescription(description);
        fillResponsible(responsible);
        clickButtonAddTask();
        return new TasksPage(driver);
}*/

}
