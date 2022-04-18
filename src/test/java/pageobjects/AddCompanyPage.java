package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.SecureRandom;

public class AddCompanyPage extends AbstractPage {
    private WebDriver driver;
    private final String ADD_PAGE_COMPANY = BASE_URL + "/companys/add.html";

    @FindBy(xpath = "//input[@name='name']")
    private WebElement inputName;
    @FindBy(xpath = "//h2[text()='Добавление компании']")
    private WebElement labelHeaderTitle;
    @FindBy(xpath = "//select[@name='type']")
    private WebElement selectCompany;
    @FindBy(xpath = "//input[@name='inn']")
    private WebElement inputInn;
    @FindBy(xpath = "//input[@name='ogrn']")
    private WebElement inputOgrn;
    @FindBy(xpath = "//input[@name='kpp']")
    private WebElement inputlKpp;
    @FindBy(xpath = "//input[@name='phone']")
    private WebElement inputPhoneNumber;
    @FindBy(xpath = "//input[@name='adress']")
    private WebElement inputAddress;
    @FindBy(xpath = "//ul[@class='select2-selection__rendered']")
    private WebElement selectEmployees;
    @FindBy(xpath = "//a[@class='clear_field']")
    private WebElement buttonClearField;
    @FindBy(xpath = "//input[@type='submit' ]")
    private WebElement ButtonAddCompany;

    public AddCompanyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AddCompanyPage AddNewCompanyPage() {
        driver.get(ADD_PAGE_COMPANY);
        return this;
    }

    public String getHeaderTitle(){
        return labelHeaderTitle.getText();
    }

    public AddCompanyPage typeName(String name) {
        inputName.sendKeys(name);
        return this;
    }

    public AddCompanyPage chooseType(String type) {
        selectCompany.click();
        selectCompany.sendKeys(type);
        selectCompany.sendKeys(Keys.ENTER);
        return this;
    }

    public AddCompanyPage typeInn(String inn) {
        inputInn.sendKeys(inn);
        return this;
    }

    public AddCompanyPage typeOgrn(String ogrn) {
        inputOgrn.sendKeys(ogrn);
        return this;
    }

    public AddCompanyPage typeKpp(String kpp) {
        inputlKpp.sendKeys(kpp);
        return this;
    }

    public AddCompanyPage typePhoneNumber(String number) {
        inputPhoneNumber.sendKeys(number);
        return this;
    }

    public AddCompanyPage typeAddress(String address) {
        inputAddress.sendKeys(address);
        return this;
    }

    public AddCompanyPage chooseEmployees(String user) {
        buttonClearField.click();
        selectEmployees.sendKeys(user);
        selectEmployees.sendKeys(Keys.ENTER);
        return this;
    }

    public AddCompanyPage clickAddCompany() {
        ButtonAddCompany.click();
        return this;
    }

    public AddCompanyPage fillFormAddCompany(String name, String type, String inn, String ogrn, String kpp, String number, String address, String user) {
        typeName(name);
        chooseType(type);
        typeInn(inn);
        typeOgrn(ogrn);
        typeKpp(kpp);
        typePhoneNumber(number);
        typeAddress(address);
        chooseEmployees(user);
        return this;
    }

    public AddCompanyPage fillFormAndClickAddCompany(String name, String type, String inn, String ogrn, String kpp, String number, String address, String user) {
        typeName(name);
        chooseType(type);
        typeInn(inn);
        typeOgrn(ogrn);
        typeKpp(kpp);
        typePhoneNumber(number);
        typeAddress(address);
        chooseEmployees(user);
        clickAddCompany();
        return this;
    }
}
