import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.UserFullProfilePage;
import pageobjects.UserLoginPage;
import pageobjects.UserProfilePage;
import uiTitles.UserFullProfilePageUITitles;
import utils.UserCreator;

public class UserFullProfilePageTest extends AbstractTest {
    UserLoginPage userLoginPage;
    UserFullProfilePage userFullProfilePage;
    UserProfilePage userProfilePage;

    @Test
    public void testOpenPage() throws InterruptedException {
        userFullProfilePage = new UserFullProfilePage(driver);
        userLoginPage = new UserLoginPage(driver);
        userProfilePage = new UserProfilePage(driver);

        userLoginPage
                .openPage()
                .fillFormRegistrationAndClickButtonRegistration(UserCreator.getUserName(), UserCreator.getEmail(), UserCreator.getPassword());

        userProfilePage.openUsersPage().clickButtonFullProfile();
        Assert.assertEquals(userFullProfilePage.getHeadingProfile(), UserFullProfilePageUITitles.EXPECTED_HEADING_PROFILE_TITLE);
        Assert.assertEquals(userFullProfilePage.getLabelEmailText(), UserFullProfilePageUITitles.EXPECTED_LABEL_EMAIL_TITLE);
        Assert.assertEquals(userFullProfilePage.getEnteredEmail(), UserCreator.getEmail().toLowerCase());
        Assert.assertEquals(userFullProfilePage.getLabelInitialsText(), UserFullProfilePageUITitles.EXPECTED_LABEL_INITIALS_TITLE);
        Assert.assertEquals(userFullProfilePage.getEnteredInitials(), UserCreator.getUserName().toLowerCase());
        Assert.assertEquals(userFullProfilePage.getLabelGenderText(), UserFullProfilePageUITitles.EXPECTED_LABEL_GENDER_TITLE);
        // Assert.assertEquals(userFullProfilePage.getSelectedGender(), "Не определен"); не знаю пока, как сделать
        Assert.assertEquals(userFullProfilePage.getLabelBirthdayText(), UserFullProfilePageUITitles.EXPECTED_LABEL_BIRTHDAY_TITLE);
        Assert.assertEquals(userFullProfilePage.getEnteredBirthday(), "");
        Assert.assertEquals(userFullProfilePage.getLabelDateStartText(), UserFullProfilePageUITitles.EXPECTED_LABEL_DATA_START_TITLE);
        Assert.assertEquals(userFullProfilePage.getEnteredDateStart(), "");
        Assert.assertEquals(userFullProfilePage.getLabelHobbyText(), UserFullProfilePageUITitles.EXPECTED_LABEL_HOBBY_TITLE);
        Assert.assertEquals(userFullProfilePage.getEnteredHobby(), "");
        Assert.assertEquals(userFullProfilePage.getLabelNameOne(), UserFullProfilePageUITitles.EXPECTED_LABEL_NAME_ONE_TITLE);
        Assert.assertEquals(userFullProfilePage.getInputNameOne(), "");
        Assert.assertEquals(userFullProfilePage.getLabelSurnameOne(), UserFullProfilePageUITitles.EXPECTED_LABEL_SURNAME_ONE_TITLE);
        Assert.assertEquals(userFullProfilePage.getInputSurnameOne(), "");
        Assert.assertEquals(userFullProfilePage.getLabelPatronymicOne(), UserFullProfilePageUITitles.EXPECTED_LABEL_PATRONYMIC_ONE_TITLE);
        Assert.assertEquals(userFullProfilePage.getInputPatronymicOne(), "");
        Assert.assertEquals(userFullProfilePage.getLabelCat(), UserFullProfilePageUITitles.EXPECTED_LABEL_CAT_TITLE);
        Assert.assertEquals(userFullProfilePage.getInputCat(), "");
        Assert.assertEquals(userFullProfilePage.getLabelDog(), UserFullProfilePageUITitles.EXPECTED_LABEL_DOG_TITLE);
        Assert.assertEquals(userFullProfilePage.getInputDog(), "");
        Assert.assertEquals(userFullProfilePage.getLabelParrot(), UserFullProfilePageUITitles.EXPECTED_LABEL_PARROT_TITLE);
        Assert.assertEquals(userFullProfilePage.getInputParrot(), "");
        Assert.assertEquals(userFullProfilePage.getLabelCavy(), UserFullProfilePageUITitles.EXPECTED_LABEL_CAVY_TITLE);
        Assert.assertEquals(userFullProfilePage.getInputCavy(), "");
        Assert.assertEquals(userFullProfilePage.getLabelHamster(), UserFullProfilePageUITitles.EXPECTED_LABEL_HAMSTER_TITLE);
        Assert.assertEquals(userFullProfilePage.getInputHamster(), "");
        Assert.assertEquals(userFullProfilePage.getLabelSquirrel(), UserFullProfilePageUITitles.EXPECTED_LABEL_SQUIRREL_TITLE);
        Assert.assertEquals(userFullProfilePage.getInputSquirrel(), "");
        Assert.assertEquals(userFullProfilePage.getLabelPhone(), UserFullProfilePageUITitles.EXPECTED_LABEL_PHONE_TITLE);
        Assert.assertEquals(userFullProfilePage.getInputPhone(), "");
        Assert.assertEquals(userFullProfilePage.getLabelAddress(), UserFullProfilePageUITitles.EXPECTED_LABEL_ADDRESS_TITLE);
        Assert.assertEquals(userFullProfilePage.getInputAddress(), "");
        Assert.assertEquals(userFullProfilePage.getLabelINNText(), UserFullProfilePageUITitles.EXPECTED_LABEL_INN_TITLE);
        Assert.assertEquals(userFullProfilePage.getEnteredINN(), "");

        Thread.sleep(1000);
    }
}
