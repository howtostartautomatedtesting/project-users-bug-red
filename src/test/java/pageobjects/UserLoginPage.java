package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginPage extends AbstractPage {
    private WebDriver driver;
    private final String TASK_PAGE_URL = "http://users.bugred.ru/user/login/index.html";


    @FindBy(xpath = "/html/body/div[3]/div[1]/div[1]/h2")
    private WebElement pageTitleLoginForm;

    @FindBy(xpath = "/html/body/div[3]/div[1]/div[1]/form/table/tbody/tr[1]/td[2]/input")
    private WebElement inputEmailLoginForm;

    @FindBy(xpath = "/html/body/div[3]/div[1]/div[1]/form/table/tbody/tr[2]/td[2]/input")
    private WebElement inputPasswordLoginForm;

    @FindBy(xpath = "/html/body/div[3]/div[1]/div[1]/form/table/tbody/tr[3]/td[2]/input")
    private WebElement buttonAuthorizationLoginForm;


    @FindBy(xpath = "/html/body/div[3]/div[1]/div[2]/h2")
    private WebElement pageTitleRegistrationForm;

    @FindBy(xpath = "/html/body/div[3]/div[1]/div[2]/form/table/tbody/tr[1]/td[2]/input")
    private WebElement inputNameRegistrationForm;

    @FindBy(xpath = "/html/body/div[3]/div[1]/div[2]/form/table/tbody/tr[2]/td[2]/input")
    private WebElement inputEmailRegistrationForm;

    @FindBy(xpath = "/html/body/div[3]/div[1]/div[2]/form/table/tbody/tr[3]/td[2]/input")
    private WebElement inputPasswordRegistrationForm;

    @FindBy(xpath = "/html/body/div[3]/div[1]/div[2]/form/table/tbody/tr[4]/td[2]/input")
    private WebElement buttonAuthorizationRegistrationForm;

    public UserLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public UserLoginPage openPage() {
        driver.get(TASK_PAGE_URL);
        return this;
    }

    public boolean getNameTitleLoginForm(String value) {
        return pageTitleLoginForm.getText().equals(value);
    }

    public boolean getNameTitleRegistrationForm(String value) {
        return pageTitleRegistrationForm.getText().equals(value);
    }

    public UserLoginPage inputEmailLoginForm(String name) {
        inputEmailLoginForm.sendKeys(name);
        return this;
    }

    public UserLoginPage inputPasswordLoginForm(String name) {
        inputPasswordLoginForm.sendKeys(name);
        return this;
    }

    public UserLoginPage clickButtonAuthorizationLoginForm() {
        inputEmailLoginForm.click();
        return this;
    }

    public UserLoginPage inputNameRegistrationForm(String name) {
        inputNameRegistrationForm.sendKeys(name);
        return this;
    }


    public UserLoginPage inputEmailRegistrationForm(String name) {
        inputEmailRegistrationForm.sendKeys(name);
        return this;
    }

    public UserLoginPage inputPasswordRegistrationForm(String name) {
        inputPasswordRegistrationForm.sendKeys(name);
        return this;
    }

    public UserLoginPage clickButtonAuthorizationRegistrationForm() {
        buttonAuthorizationLoginForm.click();
        return this;
    }

}
