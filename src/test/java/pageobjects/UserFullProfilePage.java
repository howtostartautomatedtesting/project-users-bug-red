package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserFullProfilePage extends AbstractPage {
    private WebDriver driver;
    private final String USER_FULL_PROFILE_PAGE_URL = BASE_URL + "/user/admin/view/668315";
    private final String USER_LOGIN_PAGE_URL = BASE_URL + "/user/login/index.html";

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

    public UserFullProfilePage openUsersLoginPage() {
        driver.get(USER_LOGIN_PAGE_URL);
        return this;
    }

    public UserFullProfilePage fillFormLoginUser(String email, String password){
        openUsersLoginPage();
        inputLogin.sendKeys(email);
        inputPassword.sendKeys(password);
        buttonAuthorization.click();
        menuUserName.click();
        menuUserProfile.click();
        return this;
    }

    public UserFullProfilePage openUsersPage() {
        driver.get(USER_FULL_PROFILE_PAGE_URL);
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
}

