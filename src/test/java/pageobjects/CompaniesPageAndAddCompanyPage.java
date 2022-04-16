package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.SplittableRandom;

public class CompaniesPageAndAddCompanyPage extends AbstractPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id='main-menu']/ul/li[3]/a")
    private WebElement buttonCompanies;
    @FindBy(xpath = "/html/body/div[3]/div[1]/p[1]/a")
    private WebElement buttonAddCompany;
    @FindBy(xpath = "/html/body/div[3]/div[1]/form/table/tbody/tr[1]/td[2]/input")
    private WebElement inputNameCompany;
    @FindBy(xpath = "//*[@id='select2-type-4o-container']")
    private WebElement typeCompany;
    @FindBy(xpath = "/html/body/div[3]/div[1]/form/table/tbody/tr[3]/td[2]/input")
    private WebElement inputInnCompany;
    @FindBy(xpath = "/html/body/div[3]/div[1]/form/table/tbody/tr[4]/td[2]/input")
    private WebElement inputOgrnCompany;
    @FindBy(xpath = "/html/body/div[3]/div[1]/form/table/tbody/tr[5]/td[2]/input")
    private WebElement inputKppCompany;
    @FindBy(xpath = "/html/body/div[3]/div[1]/form/table/tbody/tr[6]/td[2]/input")
    private WebElement inputPhoneNumberCompany;
    @FindBy(xpath = "/html/body/div[3]/div[1]/form/table/tbody/tr[7]/td[2]/input")
    private WebElement inputAddressCompany;
    @FindBy(xpath = "/html/body/div[3]/div[1]/form/table/tbody/tr[8]/td[2]/span/span[1]/span/ul")
    private WebElement typeEmployeesCompany;
    @FindBy(xpath = " /html/body/div[3]/div[1]/form/table/tbody/tr[9]/td[2]/input")
    private WebElement pressButtonAddCompany;

    public CompaniesPageAndAddCompanyPage(WebDriver driver) {
        this.driver = driver;                                         // Если можно словами простыми пояснить описания конструктора
        PageFactory.initElements(driver, this);                 // на следующем занятии
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
        inputNameCompany.sendKeys(name);
        return this;
    }

    // Есть сомнения по этому методу
    public CompaniesPageAndAddCompanyPage chooseTypeCompany() {
        typeCompany.click();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(typeCompany))
                .sendKeys();
        typeCompany.sendKeys(Keys.ENTER);
        return this;
    }

    public CompaniesPageAndAddCompanyPage typeInnCompany(String inn){
        inputInnCompany.sendKeys(inn);
        return this;
    }

    public CompaniesPageAndAddCompanyPage typeOgrnCompany(String ogrn){
        inputOgrnCompany.sendKeys(ogrn);
        return this;
    }

    public CompaniesPageAndAddCompanyPage typeKppCompany(String kpp){
        inputKppCompany.sendKeys(kpp);
        return this;
    }

    public CompaniesPageAndAddCompanyPage typePhoneNumberCompany(String number){
        inputKppCompany.sendKeys(number);
        return this;
    }

    public CompaniesPageAndAddCompanyPage typeAddressCompany(String address){
        inputKppCompany.sendKeys(address);
        return this;
    }

    // Есть сомнения по этому методу
    public CompaniesPageAndAddCompanyPage chooseEmployeesCompany(){
        typeEmployeesCompany.click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(typeEmployeesCompany))
                .sendKeys();
        typeEmployeesCompany.sendKeys(Keys.ENTER);
        return this;
    }

    public CompaniesPageAndAddCompanyPage pressAddCompany(){
        pressButtonAddCompany.click();
        return this;
    }
}
