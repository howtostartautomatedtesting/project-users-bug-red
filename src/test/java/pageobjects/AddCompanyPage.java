package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCompanyPage extends AbstractPage {
    public static final String HEADING_ADD_COMPANY = "Добавление компании";
    public static final String LABEL_NAME = "Название";
    public static final String LABEL_TYPE = "ТИП";
    public static final String LABEL_INN = "ИНН";
    public static final String LABEL_OGRN = "ОГРН";
    public static final String LABEL_KPP = "КПП";
    public static final String LABEL_PHONE = "Телефон";
    public static final String LABEL_ADDRESS = "Адрес";
    public static final String LABEL_USERS = "Сотрудники";
    public static final String BUTTON_LABEL_CLEAR_FIELD_USERS = "Очистить поле";
    public static final String BUTTON_LABEL_ADD_COMPANY = "Добавить компанию";

    public static final String ADD_PAGE_COMPANY_URL = BASE_URL + "/companys/add.html";

    private WebDriver driver;

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
    private WebElement buttonAddCompany;

    public AddCompanyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AddCompanyPage addNewCompanyPage() {
        driver.get(ADD_PAGE_COMPANY_URL);
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

    private String getFieldTitleXPathByNameAttribute(String valueOfAttributeName){
        String defaultNameLocator = "//*[@name='%s']/../preceding-sibling::td";
        return String.format(defaultNameLocator, valueOfAttributeName);
    }

    public String getFieldNameTitle(){
        return driver.findElement(By.xpath(getFieldTitleXPathByNameAttribute("name"))).getText();
    }

    public String getFieldTypeTitle(){
        return driver.findElement(By.xpath(getFieldTitleXPathByNameAttribute("type"))).getText();
    }

    public String getFieldINNTitle(){
        return driver.findElement(By.xpath(getFieldTitleXPathByNameAttribute("inn"))).getText();
    }

    public String getFieldOGRNTitle(){
        return driver.findElement(By.xpath(getFieldTitleXPathByNameAttribute("ogrn"))).getText();
    }

    public String getFieldKPPTitle(){
        return driver.findElement(By.xpath(getFieldTitleXPathByNameAttribute("kpp"))).getText();
    }

    public String getFieldPhoneTitle(){
        return driver.findElement(By.xpath(getFieldTitleXPathByNameAttribute("phone"))).getText();
    }

    public String getFieldAddressTitle(){
        return driver.findElement(By.xpath(getFieldTitleXPathByNameAttribute("adress"))).getText();
    }

    public String getFieldUsersTitle(){
        return driver.findElement(By.xpath(getFieldTitleXPathByNameAttribute("users[]"))).getText();
    }

    public String getButtonClearFieldUsersName(){
        return buttonClearField.getText();
    }

    public String getButtonAddCompanyName(){
        return buttonAddCompany.getAttribute("value");
    }
}
