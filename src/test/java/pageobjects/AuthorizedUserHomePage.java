package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthorizedUserHomePage extends AbstractPage{

    private WebDriver driver;

    @FindBy(xpath = "//div[@id='main-menu']//*[text()='Пользователи']/parent::a")
    private WebElement buttonUsers;

    @FindBy(xpath = "//div[@id='main-menu']//a[@href='/tasks/index.html']")
    private WebElement buttonTasks;

    @FindBy(xpath = "//div[@id='main-menu']//a[@href='/companys/index.html']")
    private WebElement buttonCompanies;

    @FindBy(xpath = "//ul[@class='nav navbar-nav pull-right']//a[@href='/tasks/notify/index.html']")
    private WebElement buttonNotifications;

    @FindBy(xpath = "//ul[@class='nav navbar-nav pull-right']//a[@href='/tasks/my/index.html']")
    private WebElement buttonUserTasks;

    @FindBy(xpath = "//ul[@class='nav navbar-nav pull-right']//li[@id='fat-menu']/a")
    private WebElement dropdownMenuUserAccount;

    @FindBy(xpath = "//ul[@class='dropdown-menu']//a[text()='Личный кабинет']")
    private WebElement buttonUserAccount;

    @FindBy(xpath = "//ul[@class='dropdown-menu']//a[text()='Выход']")
    private WebElement buttonLogOutAccount;

    public AuthorizedUserHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AuthorizedUserHomePage openPage() {
        driver.get(BASE_URL);
        return this;
    }

    //необходимо добавить PageObject UsersPage
    /*public UsersPage clickButtonUsers(){
        buttonUsers.click();
        return new UsersPage(driver);
    }*/

    public TasksPage clickButtonTasks(){
        buttonTasks.click();
        return new TasksPage(driver);
    }

    public CompaniesPage clickButtonCompanies(){
        buttonCompanies.click();
        return new CompaniesPage(driver);
    }

    //необходимо добавить PageObject NotificationsPage
    /*public NotificationsPage clickButtonNotifications(){
        buttonNotifications.click();
        return new NotificationsPage(driver);
    }*/

    //необходимо добавить PageObject UserTasksPage
    /*public UserTasksPage clickButtonUserTasks(){
        buttonUserTasks.click();
        return new UserTasksPage(driver);
    }*/

    public String getAuthorizedUserName(){
        return dropdownMenuUserAccount.getText();
    }

    public UserProfilePage openUserProfilePage(){
        dropdownMenuUserAccount.click();
        buttonUserAccount.click();
        return new UserProfilePage(driver);
    }

    public HomePage logOutAuthorizedUserPage(){
        dropdownMenuUserAccount.click();
        buttonLogOutAccount.click();
        return new HomePage(driver);
    }
}
