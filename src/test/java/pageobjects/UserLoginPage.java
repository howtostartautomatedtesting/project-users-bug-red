package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginPage extends AbstractPage {
    private WebDriver driver;
    private final String USER_LOGIN_URL = BASE_URL + "/user/login/index.html";

    @FindBy(xpath = "//div[@class='col-md-6'][1]/h2")
    private WebElement formTitleLogin;

    @FindBy(xpath = "//input[@name='login']")
    private WebElement inputEmailLogin;

    @FindBy(xpath = "//form[@action='/user/login/index.html']//input[@name='password']")
    private WebElement inputPasswordLogin;

    @FindBy(xpath = "//form[@action='/user/login/index.html']//input[@class='btn btn-danger']")
    private WebElement clickButtonAuthorization;

    @FindBy(xpath = "//div[@class='col-md-6'][2]/h2")
    private WebElement formTitleRegistration;

    @FindBy(xpath = "//input[@name='name']")
    private WebElement inputNameRegistration;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement inputEmailRegistration;

    @FindBy(xpath = "//form[@action='/user/register/index.html']//input[@name='password']")
    private WebElement inputPasswordRegistration;

    @FindBy(xpath = "//input[@name='act_register_now']")
    private WebElement clickButtonRegistration;

    @FindBy(xpath = "//form[@action='/user/login/index.html']//tr[1]/td[1]")
    private WebElement titleEmailLogin;

    @FindBy(xpath = "//form[@action='/user/login/index.html']//tr[2]/td[1]")
    private WebElement titlePasswordLogin;

    @FindBy(xpath = "//form[@action='/user/register/index.html']//tr[1]/td[1]")
    private WebElement titleNameRegistration;

    @FindBy(xpath = "//form[@action='/user/register/index.html']//tr[2]/td[1]")
    private WebElement titleEmailRegistration;

    @FindBy(xpath = "//form[@action='/user/register/index.html']//tr[3]/td[1]")
    private WebElement titlePasswordRegistration;

    public UserLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public UserLoginPage openPage() {
        driver.get(USER_LOGIN_URL);
        return this;
    }

    public UserLoginPage getNameTitleLogin() {
        formTitleLogin.getText();
        return this;
    }

    public UserLoginPage getNameTitleRegistration() {
        formTitleRegistration.getText();
        return this;
    }

    public UserLoginPage inputEmailLogin(String email) {
        inputEmailLogin.sendKeys(email);
        return this;
    }

    public UserLoginPage inputPasswordLogin(String password) {
        inputPasswordLogin.sendKeys(password);
        return this;
    }

    public UserLoginPage clickButtonAuthorization() {
        clickButtonAuthorization.click();
        return this;
    }

    public UserLoginPage inputNameRegistration(String name) {
        inputNameRegistration.sendKeys(name);
        return this;
    }

    public UserLoginPage inputEmailRegistration(String email) {
        inputEmailRegistration.sendKeys(email);
        return this;
    }

    public UserLoginPage inputPasswordRegistration(String password) {
        inputPasswordRegistration.sendKeys(password);
        return this;
    }

    public UserLoginPage clickButtonRegistration() {
        clickButtonRegistration.click();
        return this;
    }

    public UserLoginPage getTitleEmailLogin() {
        titleEmailLogin.getText();
        return this;
    }

    public UserLoginPage getTitlePasswordLogin() {
        titlePasswordLogin.getText();
        return this;
    }

    public UserLoginPage getTitleNameRegistration() {
        titleNameRegistration.getText();
        return this;
    }

    public UserLoginPage getTitleEmailRegistration() {
        titleEmailRegistration.getText();
        return this;
    }

    public UserLoginPage getTitlePasswordRegistration() {
        titlePasswordRegistration.getText();
        return this;
    }

    public AuthorizedUserHomePage fillFormLogin(String email, String password){
        inputEmailLogin(email);
        inputPasswordLogin(password);
        clickButtonAuthorization.click();
        return new AuthorizedUserHomePage(driver);
    }

    public AuthorizedUserHomePage fillFormRegistration(String name, String email, String password){
        inputNameRegistration(name);
        inputEmailRegistration(email);
        inputPasswordRegistration(password);
        clickButtonRegistration.click();
        return new AuthorizedUserHomePage(driver);
    }
}
