package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractPage {
    public static final String BUTTON_LABEL_USERS = "Пользователи";
    public static final String BUTTON_LABEL_LOGIN = "Войти";

    public static final String HEADING_USERS = "Пользователи";
    public static final String HEADING_DATE_OF_CHANGE = "Дата изменения";
    public static final String LABEL_DATE_FROM = "C ";
    public static final String LABEL_DATE_TILL = "По ";
    public static final String INPUT_DATE_START = "date";
    public static final String INPUT_DATE_END = "date";
    public static final String HEADING_SEARCH = "Поисковая строка";
    public static final String INPUT_VALUE_SEARCH = "Введите email или имя";
    public static final String BUTTON_LABEL_SEARCH = "Найти";
    public static final String LINK_LABEL_RESET_FILTERS = "Сбросить фильтры";

    public static final String TABLE_HEADING_EMAIL = "Email   ";
    public static final String TABLE_HEADING_FULL_NAME = "ФИО   ";
    public static final String TABLE_HEADING_AUTHOR = "Автор   ";
    public static final String TABLE_HEADING_DATE_OF_CHANGE = "Дата изменения   ";
    public static final String TABLE_HEADING_CHANGE = "Изменить";
    public static final String TABLE_HEADING_DELETE = "Удалить";

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
    @FindBy(xpath = "//form[@action='/user/admin/index']//td[1]")
    private WebElement titleDateOfChange;
    @FindBy(xpath = "//form[@action='/user/admin/index']//tr[3]/td")
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
    @FindBy(xpath = "//a[@class='btn btn-success'])[1]")
    private WebElement buttonView;
    @FindBy(xpath = "//form[@action='/user/admin/index']//tr[2]/td[1]")
    private WebElement titleDateFrom;
    @FindBy(xpath = "//form[@action='/user/admin/index']//tr[2]/td[2]")
    private WebElement titleDateTill;
    @FindBy(xpath = "//table[@class='table']//th")
    private WebElement titleHeaderTableEmail;
    @FindBy(xpath = "//table[@class='table']//th[2]")
    private WebElement titleHeaderTableFullName;
    @FindBy(xpath = "//table[@class='table']//th[3]")
    private WebElement titleHeaderTableAuthor;
    @FindBy(xpath = "//table[@class='table']//th[4]")
    private WebElement titleHeaderTableDateOfChange;
    @FindBy(xpath = "//table[@class='table']//th[5]")
    private WebElement titleHeaderTableChange;
    @FindBy(xpath = "//table[@class='table']//th[6]")
    private WebElement titleHeaderTableDelete;
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

    public HomePage clickButtonUsers() {
        buttonUsers.click();
        return this;
    }

    public UserLoginPage clickButtonLogin() {
        buttonLogin.click();
        return new UserLoginPage(driver);
    }

    public HomePage clickButtonView() {
        buttonView.click();
        return this;
    }

    public String getFormTitleUsers() {
        return formTitleUsers.getText();
    }

    public String getTitleInputDateStart() {
        return inputDateStart.getAttribute("type");
    }

    public String getTitleInputDateEnd() {
        return inputDateEnd.getAttribute("type");
    }

    public String getTitleInputSearch() {
        return inputSearch.getAttribute("placeholder");
    }

    public String getTitleButtonUsers() {
        return buttonUsers.getText();
    }

    public String getTitleButtonSearch() {
        return buttonSearch.getText();
    }

    public String getTitleButtonLogin() {
        return buttonLogin.getText();
    }

    public String getTitleDateOfChange() {
        return titleDateOfChange.getText();
    }

    public String getTitleSearchString() {
        return titleSearchString.getText();
    }

    public String getTitleResetFilter() {
        return titleResetFilter.getText();
    }

    public String getFillEmailUser() {
        return fillEmailUser.getText();
    }

    public String getFillFullNameUser() {
        return fillFullNameUser.getText();
    }

    public String getFillAuthorUser() {
        return fillAuthorUser.getText();
    }

    public String getFillDateOfChangeUser() {
        return fillDateOfChangeUser.getText();
    }

    public String getFillChangeUser() {
        return fillChangeUser.getText();
    }

    public String getFillDeleteUser() {
        return fillDeleteUser.getText();
    }

    public String getTitleDateFrom() {
        return titleDateFrom.getText();
    }

    public String getTitleDateTill() {
        return titleDateTill.getText();
    }

    public String getTitleHeaderTableEmail() {
        return titleHeaderTableEmail.getText();
    }

    public String getTitleHeaderTableFullName() {
        return titleHeaderTableFullName.getText();
    }

    public String getTitleHeaderTableAuthor() {
        return titleHeaderTableAuthor.getText();
    }

    public String getTitleHeaderTableDateOfChange() {
        return titleHeaderTableDateOfChange.getText();
    }

    public String getTitleHeaderTableChange() {
        return titleHeaderTableChange.getText();
    }

    public String getTitleHeaderTableDelete() {
        return titleHeaderTableDelete.getText();
    }

    public HomePage clickSortDateOfChangeAscent() {
        sortDateOfChangeAscent.click();
        return this;
    }

    public HomePage clickSortDateOfChangeDescend() {
        sortDateOfChangeDescend.click();
        return this;
    }

    public HomePage clickTypePaginationNext() {
        typePaginationNext.click();
        return this;
    }
}
