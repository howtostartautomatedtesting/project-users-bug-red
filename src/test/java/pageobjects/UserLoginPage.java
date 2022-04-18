package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginPage extends AbstractPage {
    private WebDriver driver;
    private final String USER_LOGIN_URL = BASE_URL + "/user/login/index.html";

    @FindBy(xpath = "//h2[text()='Вход']")
    private WebElement pageTitleLogin;

    @FindBy(xpath = "//input[@name='login']")
    private WebElement inputEmailLogin;

    @FindBy(xpath = "//form[@action='/user/login/index.html']//input[@name='password']")
    private WebElement inputPasswordLogin;

    @FindBy(xpath = "//input[@value='Авторизоваться']")
    private WebElement buttonAuthorizationLogin;

    @FindBy(xpath = "//h2[text()='Регистрация']")
    private WebElement titleRegistration;

    @FindBy(xpath = "//input[@name='name']")
    private WebElement inputNameRegistration;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement inputEmailRegistration;

    @FindBy(xpath = "//form[@action='/user/register/index.html']//input[@name='password']")
    private WebElement inputPasswordRegistration;

    @FindBy(xpath = "//input[@name='act_register_now']")
    private WebElement buttonAuthorizationRegistration;

    public UserLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public UserLoginPage openPage() {
        driver.get(USER_LOGIN_URL);
        return this;
    }

    public UserLoginPage getNameTitleLogin() {
        pageTitleLogin.getText();
        return this;
    }

    public UserLoginPage getNameTitleRegistration() {
        titleRegistration.getText();
        return this;
    }

    public UserLoginPage inputEmailLogin(String name) {
        inputEmailLogin.sendKeys(name);
        return this;
    }

    public UserLoginPage inputPasswordLogin(String name) {
        inputPasswordLogin.sendKeys(name);
        return this;
    }

    public UserLoginPage clickButtonAuthorizationLogin() {
        inputEmailLogin.click();
        return this;
    }

    public UserLoginPage inputNameRegistration(String name) {
        inputNameRegistration.sendKeys(name);
        return this;
    }

    public UserLoginPage inputEmailRegistration(String name) {
        inputEmailRegistration.sendKeys(name);
        return this;
    }

    public UserLoginPage inputPasswordRegistrationForm(String name) {
        inputPasswordRegistration.sendKeys(name);
        return this;
    }

    public UserLoginPage clickButtonAuthorizationRegistration() {
        buttonAuthorizationRegistration.click();
        return this;
    }
}
