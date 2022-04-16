package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthorizedUserHomePage extends AbstractPage{

    private WebDriver driver;

    @FindBy(xpath = "//div[@id='main-menu']//li[1]/a")
    private WebElement buttonUsers;

    @FindBy(xpath = "//div[@id='main-menu']//li[2]/a")
    private WebElement buttonTasks;

    @FindBy(xpath = "//div[@id='main-menu']//li[3]/a")
    private WebElement buttonCompanies;

    @FindBy(xpath = "//div[@class='hidden-xs']//li[1]/a")
    private WebElement buttonNotifications;

    @FindBy(xpath = "//div[@class='hidden-xs']//li[2]/a")
    private WebElement buttonUserTasks;

    @FindBy(xpath = "//div[@class='hidden-xs']//li[3]/a")
    private WebElement dropdownMenuUserAccount;

    @FindBy(xpath = "//ul[@class='dropdown-menu']/li[1]/a")
    private WebElement buttonUserAccount;

    @FindBy(xpath = "//ul[@class='dropdown-menu']/li[3]/a")
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
    /*public UsersPage openUsersPage(){
        buttonUsers.click();
        return new UsersPage(driver);
    }*/

    public TasksPage openTasksPage(){
        buttonTasks.click();
        return new TasksPage(driver);
    }

    public CompaniesPage openCompaniesPage(){
        buttonCompanies.click();
        return new CompaniesPage(driver);
    }

    //необходимо добавить PageObject NotificationsPage
    /*public NotificationsPage openUsersPage(){
        buttonNotifications.click();
        return new NotificationsPage(driver);
    }*/

    //необходимо добавить PageObject UserTasksPage
    /*public UserTasksPage openUserTasksPage(){
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

    public HomePage logOutUserProfilePage(){
        dropdownMenuUserAccount.click();
        buttonLogOutAccount.click();
        return new HomePage(driver);
    }

}
