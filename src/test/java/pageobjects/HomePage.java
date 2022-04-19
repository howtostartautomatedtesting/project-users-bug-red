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

    @FindBy(xpath = "//input[@name='q']")
    private WebElement inputSearch;

    @FindBy(xpath = "//button[@class='btn btn-submit']")
    private WebElement buttonSearch;

    @FindBy(xpath = "//form[@action='/user/admin/index']//a[@href='/']")
    private WebElement buttonResetFilter;

    @FindBy(xpath = "//div[@class='content']/table[@class='table']")
    private WebElement tableUsers;

    @FindBy(xpath = "//div[@class='content']/h2")
    private WebElement formTitleUsers;

    @FindBy(xpath = "(//form[@action='/user/admin/index'']//td)[1]")
    private WebElement titleDateOfChange;

    @FindBy(xpath = "(//form[@action='/user/admin/index']//tr)[3]/td")
    private WebElement titleSearchString;

    @FindBy(xpath = "//form[@action='/user/admin/index']//a[@href='/']")
    private WebElement titleResetFilter;

    @FindBy(xpath = "//tbody[@class='ajax_load_row']/tr[1]/td[1]")
    private WebElement fillEmailUser;

    @FindBy(xpath = "//tbody[@class='ajax_load_row']/tr[1]/td[2]")
    private WebElement fillFullNameUser;

    @FindBy(xpath = "//tbody[@class='ajax_load_row']/tr[1]/td[3]")
    private WebElement fillAuthorUser;

    @FindBy(xpath = "//tbody[@class='ajax_load_row']/tr[1]/td[4]")
    private WebElement fillDateOfChangeUser;

    @FindBy(xpath = "//tbody[@class='ajax_load_row']/tr[1]/td[5]")
    private WebElement fillChangeUser;

    @FindBy(xpath = "//tbody[@class='ajax_load_row']/tr[1]/td[6]")
    private WebElement fillDeleteUser;

    @FindBy(xpath = "(//a[@class='btn btn-success'])[1]")
    private WebElement buttonView;

    @FindBy(xpath = "//form[@action='/user/admin/index']//tr[2]/td[1]/text()")
    private WebElement titleDateFrom;

    @FindBy(xpath = "//form[@action='/user/admin/index']//tr[2]/td[2]/text()")
    private WebElement titleDateTill;

    @FindBy(xpath = "(//table[@class='table']//th/text())[1]")
    private WebElement titleHeaderTableEmail;

    @FindBy(xpath = "(//table[@class='table']//th[2]/text())[1]")
    private WebElement titleHeaderTableFullName;

    @FindBy(xpath = "(//table[@class='table']//th[3]/text())[1]")
    private WebElement titleHeaderTableAuthor;

    @FindBy(xpath = "(//table[@class='table']//th[4]/text())[1]")
    private WebElement titleHeaderTableDateOfChange;

    @FindBy(xpath = "//a[@href='?sort_type=asc&sort_field=date_updated']")
    private WebElement sortDateOfChangeAscent;

    @FindBy(xpath = "//a[@href='?sort_type=desc&sort_field=date_updated']")
    private WebElement sortDateOfChangeDescend;

    @FindBy(xpath = "//ul[@class='pagination']/li[@class='next']")
    private WebElement typePaginationNext;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage openPage() {
        driver.get(BASE_URL);
        return this;
    }

    public HomePage clickButtonUsers(){
        buttonUsers.click();
        return this;
    }

    public HomePage clickButtonLogin(){
        buttonLogin.click();
        return this;
    }

    public HomePage clickButtonView(){
        buttonView.click();
        return this;
    }

    public HomePage getFormTitleUsers() {
        formTitleUsers.getText();
        return this;
    }

    public HomePage getTitleDateOfChange() {
        titleDateOfChange.getText();
        return this;
    }

    public HomePage getTitleSearchString() {
        titleSearchString.getText();
        return this;
    }

    public HomePage getTitleResetFilter() {
        titleResetFilter.getText();
        return this;
    }

    public HomePage getFillEmailUser() {
       fillEmailUser.getText();
        return this;
    }

    public HomePage getFillFullNameUser() {
        fillFullNameUser.getText();
        return this;
    }

    public HomePage getFillAuthorUser() {
        fillAuthorUser.getText();
        return this;
    }

    public HomePage getFillDateOfChangeUser() {
        fillDateOfChangeUser.getText();
        return this;
    }

    public HomePage getFillChangeUser() {
        fillChangeUser.getText();
        return this;
    }

    public HomePage getFillDeleteUser() {
        fillDeleteUser.getText();
        return this;
    }

    public HomePage getTitleDateFrom() {
        titleDateFrom.getText();
        return this;
    }

    public HomePage getTitleDateTill() {
        titleDateTill.getText();
        return this;
    }

    public HomePage getTitleHeaderTableEmail() {
        titleHeaderTableEmail.getText();
        return this;
    }

    public HomePage getTitleHeaderTableFullName() {
        titleHeaderTableFullName.getText();
        return this;
    }

    public HomePage getTitleHeaderTableAuthor() {
        titleHeaderTableAuthor.getText();
        return this;
    }

    public HomePage getTitleHeaderTableDateOfChange() {
        titleHeaderTableDateOfChange.getText();
        return this;
    }

    public HomePage clickSortDateOfChangeAscent(){
        sortDateOfChangeAscent.click();
        return this;
    }

    public HomePage clickSortDateOfChangeDescend(){
        sortDateOfChangeDescend.click();
        return this;
    }

    public HomePage clickTypePaginationNext(){
        typePaginationNext.click();
        return this;
    }
}
