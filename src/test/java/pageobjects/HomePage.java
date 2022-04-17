package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends AbstractPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"main-menu\"]/ul/li[1]")
    private WebElement buttonUsers;

    @FindBy(xpath = "//*[@id=\"main-menu\"]/ul/li[2]")
    private WebElement buttonLoginUser;

    @FindBy(xpath = "/html/body/div[3]/form/table/tbody/tr[2]/td[1]/input")
    private WebElement inputDateStart;

    @FindBy(xpath = "/html/body/div[3]/form/table/tbody/tr[2]/td[2]/input")
    private WebElement inputDateEnd;

    @FindBy(xpath = "/html/body/div[3]/form/table/tbody/tr[4]/td/input")
    private WebElement inputEmailOrName;

    @FindBy(xpath = "/html/body/div[3]/form/table/tbody/tr[5]/td[1]/button")
    private WebElement buttonSearch;

    @FindBy(xpath = "/html/body/div[3]/form/table/tbody/tr[5]/td[2]/a")
    private WebElement buttonResetFilter;

    @FindBy(xpath = "/html/body/div[3]/table")
    private WebElement tableUsers;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage openPage() {
        driver.get(BASE_URL);
        return this;
    }

    public UserLoginPage openUserLoginPage() {
        buttonLoginUser.click();
        return new UserLoginPage(driver);
    }

    // это для кнопки Пользователи.
   /* public UsersPage openUsersPage(){
        buttonLoginUser.click();
        return new UsersPage(driver);
    }*/


}
