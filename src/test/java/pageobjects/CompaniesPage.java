package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompaniesPage extends AbstractPage {

    private WebDriver driver;
    private final String PAGE_COMPANY_URL = BASE_URL + "/companys/index.html";

    @FindBy(xpath = "//a[@href='/companys/index.html']")
    private WebElement labelCompanies;
    @FindBy(xpath = "//span[text()='Пользователи']")
    private WebElement labelUsers;
    @FindBy(xpath = "//a[@href='/tasks/index.html']")
    private WebElement labelTasks;
    @FindBy(xpath = "//h2[text()='Компании']")
    private WebElement labelHeaderTitle;
    @FindBy(xpath = "//table[@class='table']")
    private WebElement tableCompanies;
    @FindBy(xpath = "//table/thead//td[1]")
    private WebElement columnTitleType;
    @FindBy(xpath = "//table/thead//td[2]")
    private WebElement columnTitleName;
    @FindBy(xpath = "//table/thead//td[3]")
    private WebElement columnTitleAuthor;
    @FindBy(xpath = "//table/thead//td[4]")
    private WebElement columnTitleDateOfChange;
    @FindBy(xpath = "//a[text()='Добавить компанию']")
    private WebElement buttonAddCompany;

    public CompaniesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CompaniesPage openCompaniesPage() {
        driver.get(PAGE_COMPANY_URL);
        return this;
    }

    public CompaniesPage getPageUsers() {
        labelUsers.click();
        return this;
    }

    public CompaniesPage getPageTasks() {
        labelTasks.click();
        return this;
    }

    public CompaniesPage getPageCompanies(){
        labelCompanies.click();
        return this;
    }

    public AddCompanyPage clickButtonAddCompany(){
        buttonAddCompany.click();
        return new AddCompanyPage(driver);
    }

    public String getHeaderCompanies(){
        return labelHeaderTitle.getText();
    }

    public String getTableCompanies(){
        return tableCompanies.getText();
    }

    public String getColumnTitleType(){
        return columnTitleType.getText();
    }

    public String getColumnTitleName(){
        return columnTitleName.getText();
    }

    public String getColumnTitleAuthor(){
        return columnTitleAuthor.getText();
    }

    public String getColumnTitleDateOfChange(){
        return columnTitleDateOfChange.getText();
    }

}
