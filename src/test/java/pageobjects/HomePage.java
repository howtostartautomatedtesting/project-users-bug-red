package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@id='main-menu']/ul/li/a[@href='/']")
    private WebElement buttonUsers;

    @FindBy(xpath = "//div[@id='main-menu']/ul/li/a[@href='/user/login/index.html']")
    private WebElement buttonLogin;

    @FindBy(xpath = "//input[@name='date_start']")
    private WebElement inputDateStart;

    @FindBy(xpath = "//input[@name='date_end']")
    private WebElement inputDateEnd;

    @FindBy(xpath = "//input[@placeholder='Введите email или имя']")
    private WebElement inputEmailOrName;

    @FindBy(xpath = "//button[@class='btn btn-submit']")
    private WebElement buttonSearch;

    @FindBy(xpath = "//a[text()='Сбросить фильтры']")
    private WebElement buttonResetFilter;

    @FindBy(xpath = "//div[@class='content']/table[@class='table']")
    private WebElement tableUsers;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage openPage() {
        driver.get(BASE_URL);
        return this;
    }

    public UserLoginPage clickUserLoginPage() {
        buttonLogin.click();
        return new UserLoginPage(driver);
    }
}
