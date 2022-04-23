package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthorizedUserHomePage extends AbstractPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@id='main-menu']//a[@href='/']")
    private WebElement buttonUsers;

    @FindBy(xpath = "//div[@id='main-menu']//a[@href='/tasks/index.html']")
    private WebElement buttonTasks;

    @FindBy(xpath = "//div[@id='main-menu']//a[@href='/companys/index.html']")
    private WebElement buttonCompanies;

    @FindBy(xpath = "//ul[@class='nav navbar-nav pull-right']//a[@href='/tasks/notify/index.html']")
    private WebElement buttonNotifications;

    @FindBy(xpath = "//ul[@class='nav navbar-nav pull-right']//a[@href='/tasks/my/index.html']")
    private WebElement buttonUserTasks;

    @FindBy(xpath = "//ul[@class='nav navbar-nav pull-right']//a[@class='dropdown-toggle']")
    private WebElement dropdownMenuUserAccount;

    @FindBy(xpath = "//ul[@class='dropdown-menu']//a[@href='/user/profile/index.html']")
    private WebElement buttonUserAccount;

    @FindBy(xpath = "//ul[@class='dropdown-menu']//a[@href='/user/logout.html']")
    private WebElement buttonLogOutAccount;

    public AuthorizedUserHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getButtonUsers() {
        return buttonUsers.getText();
    }

    public String getButtonTasks() {
        return buttonTasks.getText();
    }

    public String getButtonCompanies() {
        return buttonCompanies.getText();
    }

    public String getButtonNotifications() {
        return buttonNotifications.getText();
    }

    public String getButtonUserTasks() {
        return buttonUserTasks.getText();
    }

    public String getDropdownMenuUserAccount() {
        return dropdownMenuUserAccount.getText();
    }

    public TasksPage clickButtonTask() {
        buttonTasks.click();
        return new TasksPage(driver);
    }

    public TasksPage clickButtonTasks() {
        buttonTasks.click();
        return new TasksPage(driver);
    }

    public CompaniesPage clickButtonCompanies() {
        buttonCompanies.click();
        return new CompaniesPage(driver);
    }

    public String getAuthorizedUserName() {
        return dropdownMenuUserAccount.getText();
    }

    public UserProfilePage openUserProfilePage() {
        dropdownMenuUserAccount.click();
        buttonUserAccount.click();
        return new UserProfilePage(driver);
    }

    public HomePage logOutAuthorizedUserPage() {
        dropdownMenuUserAccount.click();
        buttonLogOutAccount.click();
        return new HomePage(driver);
    }
}