package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserProfilePage extends AbstractPage {
    private WebDriver driver;
    private final String USERS_PAGE_URL = BASE_URL + "/user/profile/index.html";

    public UserProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[1]/h2")
    private WebElement headingProfile;
    @FindBy(xpath = "//tr[1]/td[1]")
    private WebElement labelPhoto;
    @FindBy(xpath = "//input[@type='file']")
    private WebElement loadPhoto;
    @FindBy(xpath = "//tr[2]/td[1]")
    private WebElement labelName;
    @FindBy(xpath = "//input[@name='name']")
    private WebElement inputName;
    @FindBy(xpath = "//tr[3]/td[1]")
    private WebElement labelGender;
    @FindBy(xpath = "//select[@name='gender']")
    private WebElement inputGender;
    @FindBy(xpath = "//option[@value='m']")
    private WebElement inputGenderM;
    @FindBy(xpath = "//option[@value='f']")
    private WebElement inputGenderF;
    @FindBy(xpath = "//option[@value='none']")
    private WebElement inputGenderNone;
    @FindBy(xpath = "//tr[4]/td[1]")
    private WebElement labelBirthday;
    @FindBy(xpath = "//input[@type='date'][@name='birthday']")
    private WebElement inputBirthday;
    @FindBy(xpath = "//tr[5]/td[1]")
    private WebElement labelDateStart;
    @FindBy(xpath = "//input[@type='date'][@name='date_start']")
    private WebElement inputDateStart;
    @FindBy(xpath = "//tr[6]/td[1]")
    private WebElement labelHobby;
    @FindBy(xpath = "//textarea[@name='hobby']")
    private WebElement inputHobby;
    @FindBy(xpath = "//tr[7]/td[1]")
    private WebElement labelINN;
    @FindBy(xpath = "//input[@name='inn']")
    private WebElement inputINN;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement buttonSave;

    public UserProfilePage openUsersPage() {
        driver.get(USERS_PAGE_URL);
        return this;
    }

    public String headingProfile() {
        return headingProfile.getText();
    }

    public String getLabelPhotoText() {
        return labelPhoto.getText();
    }

    public String getLabelNameText() {
        return labelName.getText();
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

    public UserProfilePage changePhoto(String path) {
        loadPhoto.click();
        loadPhoto.sendKeys(path);
        return this;
    }

    public UserProfilePage typeName(String name) {
        inputName.clear();
        inputName.sendKeys(name);
        return this;
    }

    public UserProfilePage choseGenderM() {
        inputGender.click();
        inputGenderM.click();
        return this;
    }

    public UserProfilePage choseGenderF() {
        inputGender.click();
        inputGenderF.click();
        return this;
    }

    public UserProfilePage choseGenderNone() {
        inputGender.click();
        inputGenderNone.click();
        return this;
    }

    public UserProfilePage typeBirthday(String birthday) {
        inputBirthday.clear();
        inputBirthday.sendKeys(birthday);
        return this;
    }

    public UserProfilePage typeDateStart(String dateStart) {
        inputDateStart.clear();
        inputDateStart.sendKeys(dateStart);
        return this;
    }

    public UserProfilePage fillHobby(String hobby) {
        inputHobby.clear();
        inputHobby.sendKeys(hobby);
        return this;
    }

    public UserProfilePage fillINN(String inn) {
        inputINN.clear();
        inputINN.sendKeys(inn);
        return this;
    }

    public UserProfilePage clickButtonSave() {
        buttonSave.click();
        return this;
    }

    public UserProfilePage fillInProfilePageCompletely(String name, String path, String gender, String birthday,
                                                       String dateStart, String hobby, String inn) {
        typeName(name);
        changePhoto(path);
        switch (gender) {
            case "F":
                choseGenderF();
                break;
            case "M":
                choseGenderM();
                break;
            case "None":
                choseGenderNone();
                break;
        }
        typeBirthday(birthday);
        typeDateStart(dateStart);
        fillHobby(hobby);
        fillINN(inn);
        clickButtonSave();
        return new UserProfilePage(driver);
    }
}