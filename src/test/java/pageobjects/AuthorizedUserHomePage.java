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

    @FindBy(xpath = "/html/body/div[3]/div[1]/div[2]/form/table/tbody/tr[1]/td[2]/input")
    private WebElement inputNameRegistration;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement inputEmailRegistration;

    @FindBy(xpath = "//form[@action='/user/register/index.html']//input[@name='password']")
    private WebElement inputPasswordRegistration;

    @FindBy(xpath = "//input[@name='act_register_now']")
    private WebElement clickButtonRegistration;


    public AuthorizedUserHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AuthorizedUserHomePage openPage() {
        driver.get(BASE_URL);
        return this;
    }

    public AuthorizedUserHomePage inputNameRegistration(String name) {
        inputNameRegistration.sendKeys(name);
        return this;
    }

    public AuthorizedUserHomePage inputEmailRegistration(String email) {
        inputEmailRegistration.sendKeys(email);
        return this;
    }

    public AuthorizedUserHomePage inputPasswordRegistration(String password) {
        inputPasswordRegistration.sendKeys(password);
        return this;
    }

    public AuthorizedUserHomePage clickButtonRegistration() {
        clickButtonRegistration.click();
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

    public AuthorizedUserHomePage clickButtonCompanies(){
        buttonCompanies.click();
        return new AuthorizedUserHomePage(driver);
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

    public AuthorizedUserHomePage openUserProfilePage(){
        dropdownMenuUserAccount.click();
        buttonUserAccount.click();
        return new AuthorizedUserHomePage(driver);
    }

    public AuthorizedUserHomePage logOutAuthorizedUserPage(){
        dropdownMenuUserAccount.click();
        buttonLogOutAccount.click();
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
