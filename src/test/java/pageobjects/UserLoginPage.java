package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginPage extends AbstractPage {
    private WebDriver driver;
    public static final String USER_LOGIN_URL = BASE_URL + "/user/login/index.html";

    @FindBy(xpath = "//div[@class='col-md-6'][1]/h2")
    private WebElement formTitleLogin;

    @FindBy(xpath = "//input[@name='login']")
    private WebElement inputEmailLogin;

    @FindBy(xpath = "//form[@action='/user/login/index.html']//input[@name='password']")
    private WebElement inputPasswordLogin;

    @FindBy(xpath = "//form[@action='/user/login/index.html']//input[@class='btn btn-danger']")
    private WebElement buttonAuthorization;

    @FindBy(xpath = "//div[@class='col-md-6'][2]/h2")
    private WebElement formTitleRegistration;

    @FindBy(xpath = "//input[@name='name']")
    private WebElement inputNameRegistration;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement inputEmailRegistration;

    @FindBy(xpath = "//form[@action='/user/register/index.html']//input[@name='password']")
    private WebElement inputPasswordRegistration;

    @FindBy(xpath = "//input[@name='act_register_now']")
    private WebElement buttonRegistration;

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

    public String getNameTitleLogin() {
        return formTitleLogin.getText();
    }

    public String getNameTitleRegistration() {
        return formTitleRegistration.getText();
    }

    public UserLoginPage inputEmailLogin(String email) {
        inputEmailLogin.sendKeys(email);
        return this;
    }

    public UserLoginPage inputPasswordLogin(String password) {
        inputPasswordLogin.sendKeys(password);
        return this;
    }

    public AuthorizedUserHomePage clickButtonAuthorization() {
        buttonAuthorization.click();
        return new AuthorizedUserHomePage(driver);
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

    public AuthorizedUserHomePage clickButtonRegistration() {
        buttonRegistration.click();
        return new AuthorizedUserHomePage(driver);
    }

    public String getTitleEmailLogin() {
        return titleEmailLogin.getText();
    }

    public String getTitlePasswordLogin() {
        return titlePasswordLogin.getText();
    }

    public String getButtonAuthorizationName(){
        return buttonAuthorization.getAttribute("value");
    }

    public String getTitleNameRegistration() {
        return titleNameRegistration.getText();
    }

    public String getTitleEmailRegistration() {
        return titleEmailRegistration.getText();
    }

    public String getTitlePasswordRegistration() {
        return titlePasswordRegistration.getText();
    }

    public String getButtonRegistrationName(){
        return buttonRegistration.getAttribute("value");
    }

    public AuthorizedUserHomePage fillFormLoginAndClickButtonAuthorization(String email, String password) {
        inputEmailLogin(email);
        inputPasswordLogin(password);
        clickButtonAuthorization.click();
        return new AuthorizedUserHomePage(driver);
    }

    public AuthorizedUserHomePage fillFormLoginAndClickButtonAuthorization(String email, String password){
        inputEmailLogin(email);
        inputPasswordLogin(password);
        buttonAuthorization.click();
        return new AuthorizedUserHomePage(driver);
    }
    
    public AuthorizedUserHomePage fillFormRegistrationAndClickButtonRegistration(String name, String email, String password) {
        inputNameRegistration(name);
        inputEmailRegistration(email);
        inputPasswordRegistration(password);
        buttonRegistration.click();
        return new AuthorizedUserHomePage(driver);
    }
}
