package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCompanyPage extends AbstractPage {
    private WebDriver driver;
    public static final String ADD_PAGE_COMPANY_URL = BASE_URL + "/companys/add.html";

    @FindBy(xpath = "//input[@name='name']")
    private WebElement inputName;
    @FindBy(xpath = "//h2[text()='Добавление компании']")
    private WebElement labelHeaderTitle;
    @FindBy(xpath = "//span[@class='select2-selection__arrow']")
    private WebElement selectCompany;
    @FindBy(xpath = "//span/span[1]/input")
    private WebElement inputTypeCompany;
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
    @FindBy(xpath = "//input[@class='select2-search__field']")
    private WebElement selectEmployees;
    @FindBy(xpath = "//a[@class='clear_field']")
    private WebElement buttonClearField;
    @FindBy(xpath = "//input[@type='submit' ]")
    private WebElement buttonAddCompany;

    public AddCompanyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AddCompanyPage addNewCompanyPage() {
        driver.get(ADD_PAGE_COMPANY_URL);
        return this;
    }

    public String getHeaderTitle() {
        return labelHeaderTitle.getText();
    }

    public AddCompanyPage typeName(String name) {
        inputName.sendKeys(name);
        return this;
    }

    public AddCompanyPage chooseType(String type) {
        selectCompany.click();
        inputTypeCompany.sendKeys(type, Keys.ENTER);
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
        selectEmployees.sendKeys(user + Keys.ENTER);
        return this;
    }

    public AddCompanyPage clickAddCompany() {
        buttonAddCompany.click();
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

    public CompaniesPage fillFormAndClickAddCompany(String name, String type, String inn, String ogrn, String kpp, String number, String address, String user) {
        typeName(name);
        chooseType(type);
        typeInn(inn);
        typeOgrn(ogrn);
        typeKpp(kpp);
        typePhoneNumber(number);
        typeAddress(address);
        chooseEmployees(user);
        clickAddCompany();
        return new CompaniesPage(driver);
    }

    private String getFieldTitleXPathByNameAttribute(String valueOfAttributeName) {
        String defaultNameLocator = "//*[@name='%s']/../preceding-sibling::td";
        return String.format(defaultNameLocator, valueOfAttributeName);
    }

    public String getFieldNameTitle() {
        return driver.findElement(By.xpath(getFieldTitleXPathByNameAttribute("name"))).getText();
    }

    public String getFieldTypeTitle() {
        return driver.findElement(By.xpath(getFieldTitleXPathByNameAttribute("type"))).getText();
    }

    public String getFieldINNTitle() {
        return driver.findElement(By.xpath(getFieldTitleXPathByNameAttribute("inn"))).getText();
    }

    public String getFieldOGRNTitle() {
        return driver.findElement(By.xpath(getFieldTitleXPathByNameAttribute("ogrn"))).getText();
    }

    public String getFieldKPPTitle() {
        return driver.findElement(By.xpath(getFieldTitleXPathByNameAttribute("kpp"))).getText();
    }

    public String getFieldPhoneTitle() {
        return driver.findElement(By.xpath(getFieldTitleXPathByNameAttribute("phone"))).getText();
    }

    public String getFieldAddressTitle() {
        return driver.findElement(By.xpath(getFieldTitleXPathByNameAttribute("adress"))).getText();
    }

    public String getFieldUsersTitle() {
        return driver.findElement(By.xpath(getFieldTitleXPathByNameAttribute("users[]"))).getText();
    }

    public String getButtonClearFieldUsersName() {
        return buttonClearField.getText();
    }

    public String getButtonAddCompanyName() {
        return buttonAddCompany.getAttribute("value");
    }

    public String getMessageIfFieldNameIsEmpty() {
        return inputName.getAttribute("validationMessage");
    }
}
