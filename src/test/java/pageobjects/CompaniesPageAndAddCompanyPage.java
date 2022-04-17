package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompaniesPageAndAddCompanyPage extends AbstractPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id='main-menu']/ul/li[3]/a")
    private WebElement buttonCompanies;
    @FindBy(xpath = "/html/body/div[3]/div[1]/p[1]/a")
    private WebElement buttonAddCompany;
    @FindBy(xpath = "/html/body/div[3]/div[1]/form/table/tbody/tr[1]/td[2]/input")
    private WebElement inputName;
    @FindBy(xpath = "//*[@id='select2-type-4o-container']")
    private WebElement selectCompany;
    @FindBy(xpath = "/html/body/div[3]/div[1]/form/table/tbody/tr[3]/td[2]/input")
    private WebElement inputInn;
    @FindBy(xpath = "/html/body/div[3]/div[1]/form/table/tbody/tr[4]/td[2]/input")
    private WebElement inputOgrn;
    @FindBy(xpath = "/html/body/div[3]/div[1]/form/table/tbody/tr[5]/td[2]/input")
    private WebElement inputKpp;
    @FindBy(xpath = "/html/body/div[3]/div[1]/form/table/tbody/tr[6]/td[2]/input")
    private WebElement inputPhoneNumber;
    @FindBy(xpath = "/html/body/div[3]/div[1]/form/table/tbody/tr[7]/td[2]/input")
    private WebElement inputAddress;
    @FindBy(xpath = "/html/body/div[3]/div[1]/form/table/tbody/tr[8]/td[2]/span/span[1]/span/ul")
    private WebElement selectEmployees;
    @FindBy(xpath = " /html/body/div[3]/div[1]/form/table/tbody/tr[9]/td[2]/input")
    private WebElement pressButtonAddCompany;

    public CompaniesPageAndAddCompanyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CompaniesPageAndAddCompanyPage openPageCompanies() {
        buttonCompanies.click();
        return this;
    }

    public CompaniesPageAndAddCompanyPage addPageCompanies() {
        buttonAddCompany.click();
        return this;
    }

    public CompaniesPageAndAddCompanyPage typeNameCompany(String name) {
        inputName.sendKeys(name);
        return this;
    }

    public CompaniesPageAndAddCompanyPage chooseTypeCompany() {
        selectCompany.click();
        return this;
    }

    public CompaniesPageAndAddCompanyPage typeInnCompany(String inn){
        inputInn.sendKeys(inn);
        return this;
    }

    public CompaniesPageAndAddCompanyPage typeOgrnCompany(String ogrn){
        inputOgrn.sendKeys(ogrn);
        return this;
    }

    public CompaniesPageAndAddCompanyPage typeKppCompany(String kpp){
        inputKpp.sendKeys(kpp);
        return this;
    }

    public CompaniesPageAndAddCompanyPage typePhoneNumberCompany(String number){
        inputPhoneNumber.sendKeys(number);
        return this;
    }

    public CompaniesPageAndAddCompanyPage typeAddressCompany(String address){
        inputAddress.sendKeys(address);
        return this;
    }

    public CompaniesPageAndAddCompanyPage chooseEmployeesCompany(){
        selectEmployees.click();
        return this;
    }

    public CompaniesPageAndAddCompanyPage pressAddCompany(){
        pressButtonAddCompany.click();
        return this;
    }
}
