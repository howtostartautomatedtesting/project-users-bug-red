package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserFullProfilePage extends AbstractPage {
    public static final String LABEL_INITIALS = "ФИО";
    public static final String HEADING_PROFILE = "Профиль пользователя";
    public static final String LABEL_EMAIL = "Email";
    public static final String LABEL_GENDER = "Пол";
    public static final String LABEL_BIRTHDAY = "Дата рождения";
    public static final String LABEL_DATA_START = "Начал работать в компании";
    public static final String LABEL_HOBBY = "Хобби";
    public static final String LABEL_NAME_ONE = "имя1";
    public static final String LABEL_SURNAME_ONE = "фамилия1";
    public static final String LABEL_PATRONYMIC_ONE = "отчество1";
    public static final String LABEL_CAT = "Кошечка";
    public static final String LABEL_DOG = "Собачка";
    public static final String LABEL_PARROT = "Попугайчик";
    public static final String LABEL_CAVY = "Морская свинка";
    public static final String LABEL_HAMSTER = "Хомячок";
    public static final String LABEL_SQUIRREL = "Белочка";
    public static final String LABEL_PHONE = "Телефон";
    public static final String LABEL_ADDRESS = "Адрес";
    public static final String LABEL_INN = "ИНН";

    private final String USER_FULL_PROFILE_PAGE_URL = BASE_URL + "/user/login/index.html";

    private WebDriver driver;

    public UserFullProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[1]/h2")
    private WebElement headingProfile;
    @FindBy(xpath = "//tr[1]/td[1]")
    private WebElement labelEmail;
    @FindBy(xpath = "//tr[1]/td[2]")
    private WebElement enteredEmail;
    @FindBy(xpath = "//tr[2]/td[1]")
    private WebElement labelInitials;
    @FindBy(xpath = "//tr[2]/td[2]")
    private WebElement enteredInitials;
    @FindBy(xpath = "//tr[3]/td[1]")
    private WebElement labelGender;
    @FindBy(xpath = "//select[@name='gender']")
    private WebElement selectedGender;
    @FindBy(xpath = "//tr[4]/td[1]")
    private WebElement labelBirthday;
    @FindBy(xpath = "//tr[4]/td[2]")
    private WebElement enteredBirthday;
    @FindBy(xpath = "//tr[5]/td[1]")
    private WebElement labelDateStart;
    @FindBy(xpath = "//tr[5]/td[2]")
    private WebElement enteredDateStart;
    @FindBy(xpath = "//tr[6]/td[1]")
    private WebElement labelHobby;
    @FindBy(xpath = "//textarea[@name='hobby']")
    private WebElement enteredHobby;
    @FindBy(xpath = "//tr[18]/td[1]")
    private WebElement labelINN;
    @FindBy(xpath = "//tr[18]/td[2]")
    private WebElement enteredINN;

    @FindBy(xpath = "//input[@name='login']")
    private WebElement inputLogin;
    @FindBy(xpath = "//form[@action='/user/login/index.html']//input[@name='password']")
    private WebElement inputPassword;
    @FindBy(xpath = "//form[@action='/user/login/index.html']//input[@class='btn btn-danger']")
    private WebElement buttonAuthorization;

    @FindBy(xpath = "//a[@class='dropdown-toggle']")
    private WebElement menuUserName;
    @FindBy(xpath = "//a[@href='/user/profile/index.html']")
    private WebElement menuUserProfile;

    @FindBy(xpath = "//table[@class='table center']//tr[7]/td[1]")
    private WebElement labelNameOne;
    @FindBy(xpath = "//table[@class='table center']//tr[7]/td[2]")
    private WebElement inputNameOne;

    @FindBy(xpath = "//table[@class='table center']//tr[8]/td[1]")
    private WebElement labelSurnameOne;
    @FindBy(xpath = "//table[@class='table center']//tr[8]/td[2]")
    private WebElement inputSurnameOne;

    @FindBy(xpath = "//table[@class='table center']//tr[9]/td[1]")
    private WebElement labelPatronymicOne;
    @FindBy(xpath = "//table[@class='table center']//tr[9]/td[2]")
    private WebElement inputPatronymicOne;

    @FindBy(xpath = "//table[@class='table center']//tr[10]/td[1]")
    private WebElement labelCat;
    @FindBy(xpath = "//table[@class='table center']//tr[10]/td[2]")
    private WebElement inputCat;

    @FindBy(xpath = "//table[@class='table center']//tr[11]/td[1]")
    private WebElement labelDog;
    @FindBy(xpath = "//table[@class='table center']//tr[11]/td[2]")
    private WebElement inputDog;

    @FindBy(xpath = "//table[@class='table center']//tr[12]/td[1]")
    private WebElement labelParrot;
    @FindBy(xpath = "//table[@class='table center']//tr[12]/td[2]")
    private WebElement inputParrot;

    @FindBy(xpath = "//table[@class='table center']//tr[13]/td[1]")
    private WebElement labelCavy;
    @FindBy(xpath = "//table[@class='table center']//tr[13]/td[2]")
    private WebElement inputCavy;

    @FindBy(xpath = "//table[@class='table center']//tr[14]/td[1]")
    private WebElement labelHamster;
    @FindBy(xpath = "//table[@class='table center']//tr[14]/td[2]")
    private WebElement inputHamster;

    @FindBy(xpath = "//table[@class='table center']//tr[15]/td[1]")
    private WebElement labelSquirrel;
    @FindBy(xpath = "//table[@class='table center']//tr[15]/td[2]")
    private WebElement inputSquirrel;

    @FindBy(xpath = "//table[@class='table center']//tr[16]/td[1]")
    private WebElement labelPhone;
    @FindBy(xpath = "//table[@class='table center']//tr[16]/td[2]")
    private WebElement inputPhone;

    @FindBy(xpath = "//table[@class='table center']//tr[17]/td[1]")
    private WebElement labelAddress;
    @FindBy(xpath = "//table[@class='table center']//tr[17]/td[2]")
    private WebElement inputAddress;

    public UserFullProfilePage openUsersLoginPage() {
        driver.get(USER_FULL_PROFILE_PAGE_URL);
        return this;
    }

    public UserFullProfilePage fillFormLoginUser(String email, String password) {
        openUsersLoginPage();
        inputLogin.sendKeys(email);
        inputPassword.sendKeys(password);
        buttonAuthorization.click();
        menuUserName.click();
        menuUserProfile.click();
        return this;
    }

    public String getHeadingProfile() {
        return headingProfile.getText();
    }

    public String getLabelEmailText() {
        return labelEmail.getText();
    }

    public String getLabelInitialsText() {
        return labelInitials.getText();
    }

    public String getLabelGenderText() {
        return labelGender.getText();
    }

    public String getLabelBirthdayText() {
        return labelBirthday.getText();
    }

    public String getLabelDateStartText() {
        return labelDateStart.getText();
    }

    public String getLabelHobbyText() {
        return labelHobby.getText();
    }

    public String getLabelINNText() {
        return labelINN.getText();
    }

    public String getEnteredEmail() {
        return enteredEmail.getText();
    }

    public String getEnteredInitials() {
        return enteredInitials.getText();
    }

    public String getSelectedGender() {
        return selectedGender.getText();
    }

    public String getEnteredBirthday() {
        return enteredBirthday.getText();
    }

    public String getEnteredDateStart() {
        return enteredDateStart.getText();
    }

    public String getEnteredHobby() {
        return enteredHobby.getText();
    }

    public String getEnteredINN() {
        return enteredINN.getText();
    }

    public String getLabelNameOne() {
        return labelNameOne.getText();
    }

    public String getInputNameOne() {
        return inputNameOne.getText();
    }

    public String getLabelSurnameOne() {
        return labelSurnameOne.getText();
    }

    public String getInputSurnameOne() {
        return inputSurnameOne.getText();
    }

    public String getLabelPatronymicOne() {
        return labelPatronymicOne.getText();
    }

    public String getInputPatronymicOne() {
        return inputPatronymicOne.getText();
    }

    public String getLabelCat() {
        return labelCat.getText();
    }

    public String getInputCat() {
        return inputCat.getText();
    }

    public String getLabelDog() {
        return labelDog.getText();
    }

    public String getInputDog() {
        return inputDog.getText();
    }

    public String getLabelParrot() {
        return labelParrot.getText();
    }

    public String getInputParrot() {
        return inputParrot.getText();
    }

    public String getLabelCavy() {
        return labelCavy.getText();
    }

    public String getInputCavy() {
        return inputCavy.getText();
    }

    public String getLabelHamster() {
        return labelHamster.getText();
    }

    public String getInputHamster() {
        return inputHamster.getText();
    }

    public String getLabelSquirrel() {
        return labelSquirrel.getText();
    }

    public String getInputSquirrel() {
        return inputSquirrel.getText();
    }

    public String getLabelPhone() {
        return labelPhone.getText();
    }

    public String getInputPhone() {
        return inputPhone.getText();
    }

    public String getLabelAddress() {
        return labelAddress.getText();
    }

    public String getInputAddress() {
        return inputAddress.getText();
    }
}
