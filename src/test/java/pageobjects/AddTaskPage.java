package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddTaskPage extends AbstractPage {
    private WebDriver driver;

    AddTaskPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/div[3]/div[1]/h2")
    WebElement textHeadingAddTask;
    @FindBy(xpath = "/html//tbody/tr[1]/td[1]")
    WebElement textFieldNameTask;
    @FindBy(xpath = "/html//tbody/tr[1]/td[1]")
    WebElement textFieldDescriptionTask;
    @FindBy(xpath = "/html//tbody/tr[3]/td[1]")
    WebElement textFieldResponsible;
    @FindBy(xpath = "//input[@name=\"name\"]")
    WebElement fieldInputName;
    @FindBy(xpath = "//textarea[@name=\"description\"]")
    WebElement fieldInputDescriptionTask;
    @FindBy(xpath = "//span[@id=\"textbox\"]")
    WebElement dropBoxDown;
    @FindBy(xpath = "/html/body/span/span/span[1]/input")
    WebElement fieldInputResponsible;
    @FindBy(xpath = "//input[@type='submit']")
    WebElement buttonAddTask;


    public boolean getNameHeadingAddTask(String value) {
        return textHeadingAddTask.getText().equals(value);
    }

    public boolean getNameFieldNameTask(String value) {
        return textFieldNameTask.getText().equals(value);
    }

    public boolean getNameFieldDescriptionTask(String value) {
        return textFieldDescriptionTask.getText().equals(value);
    }

    public boolean getNameFieldResponsible(String value) {
        return textFieldResponsible.getText().equals(value);
    }

    public AddTaskPage InputNameTask(String name) {
        fieldInputName.sendKeys(name);
        return this;
    }

    public AddTaskPage InputDescriptionTask(String description) {
        fieldInputDescriptionTask.sendKeys(description);
        return this;
    }

    public AddTaskPage InputResponsible(String responsible) {
        fieldInputResponsible.click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(fieldInputResponsible))
                .sendKeys(responsible);
        fieldInputResponsible.sendKeys(Keys.ENTER);
        return this;
    }

    public AddTaskPage ClickButtonAddTask() {
        buttonAddTask.click();
        return this;     //new TasksPage(driver)
    }

    public AddTaskPage fillForm(String name, String description, String responsible) {
        InputNameTask(name);
        InputDescriptionTask(description);
        InputResponsible(responsible);
        return this;
    }


}
