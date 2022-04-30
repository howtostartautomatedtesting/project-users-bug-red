import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.UserFullProfilePage;
import utils.UserCreator;

public class UserFullProfilePageTest extends AbstractTest {
/*
    UserLoginPage userLoginPage;
    UserFullProfilePage userFullProfilePage;
    UserProfilePage userProfilePage;
*/

    @Test
    public void testUserFullProfilePageUI() {
/*
        userFullProfilePage = new UserFullProfilePage(driver);
        userLoginPage = new UserLoginPage(driver);
        userProfilePage = new UserProfilePage(driver);
*/

        String name = UserCreator.getUserName();
        String email = UserCreator.getEmail();
        String password = UserCreator.getPassword();

        UserFullProfilePage userFullProfilePage = new HomePage(driver).openPage().clickButtonLogin()
                .fillFormRegistrationAndClickButtonRegistration(name, email, password)
                .clickLinkUser()
                .clickLinkUserProfile()
                .clickButtonFullProfile();

        Assert.assertEquals(userFullProfilePage.getHeadingProfile(), UserFullProfilePage.HEADING_PROFILE);
        Assert.assertEquals(userFullProfilePage.getLabelEmailText(), UserFullProfilePage.LABEL_EMAIL);
        //Assert.assertEquals(userFullProfilePage.getEnteredEmail(), UserCreator.getEmail().toLowerCase());
        Assert.assertEquals(userFullProfilePage.getLabelInitialsText(), UserFullProfilePage.LABEL_INITIALS);
        //Assert.assertEquals(userFullProfilePage.getEnteredInitials(), UserCreator.getUserName().toLowerCase());
        Assert.assertEquals(userFullProfilePage.getLabelGenderText(), UserFullProfilePage.LABEL_GENDER);
        // Assert.assertEquals(userFullProfilePage.getSelectedGender(), "Не определен"); не знаю пока, как сделать
        Assert.assertEquals(userFullProfilePage.getLabelBirthdayText(), UserFullProfilePage.LABEL_BIRTHDAY);
        Assert.assertEquals(userFullProfilePage.getEnteredBirthday(), "");
        Assert.assertEquals(userFullProfilePage.getLabelDateStartText(), UserFullProfilePage.LABEL_DATA_START);
        Assert.assertEquals(userFullProfilePage.getEnteredDateStart(), "");
        Assert.assertEquals(userFullProfilePage.getLabelHobbyText(), UserFullProfilePage.LABEL_HOBBY);
        Assert.assertEquals(userFullProfilePage.getEnteredHobby(), "");
        Assert.assertEquals(userFullProfilePage.getLabelNameOne(), UserFullProfilePage.LABEL_NAME_ONE);
        Assert.assertEquals(userFullProfilePage.getInputNameOne(), "");
        Assert.assertEquals(userFullProfilePage.getLabelSurnameOne(), UserFullProfilePage.LABEL_SURNAME_ONE);
        Assert.assertEquals(userFullProfilePage.getInputSurnameOne(), "");
        Assert.assertEquals(userFullProfilePage.getLabelPatronymicOne(), UserFullProfilePage.LABEL_PATRONYMIC_ONE);
        Assert.assertEquals(userFullProfilePage.getInputPatronymicOne(), "");
        Assert.assertEquals(userFullProfilePage.getLabelCat(), UserFullProfilePage.LABEL_CAT);
        Assert.assertEquals(userFullProfilePage.getInputCat(), "");
        Assert.assertEquals(userFullProfilePage.getLabelDog(), UserFullProfilePage.LABEL_DOG);
        Assert.assertEquals(userFullProfilePage.getInputDog(), "");
        Assert.assertEquals(userFullProfilePage.getLabelParrot(), UserFullProfilePage.LABEL_PARROT);
        Assert.assertEquals(userFullProfilePage.getInputParrot(), "");
        Assert.assertEquals(userFullProfilePage.getLabelCavy(), UserFullProfilePage.LABEL_CAVY);
        Assert.assertEquals(userFullProfilePage.getInputCavy(), "");
        Assert.assertEquals(userFullProfilePage.getLabelHamster(), UserFullProfilePage.LABEL_HAMSTER);
        Assert.assertEquals(userFullProfilePage.getInputHamster(), "");
        Assert.assertEquals(userFullProfilePage.getLabelSquirrel(), UserFullProfilePage.LABEL_SQUIRREL);
        Assert.assertEquals(userFullProfilePage.getInputSquirrel(), "");
        Assert.assertEquals(userFullProfilePage.getLabelPhone(), UserFullProfilePage.LABEL_PHONE);
        Assert.assertEquals(userFullProfilePage.getInputPhone(), "");
        Assert.assertEquals(userFullProfilePage.getLabelAddress(), UserFullProfilePage.LABEL_ADDRESS);
        Assert.assertEquals(userFullProfilePage.getInputAddress(), "");
        Assert.assertEquals(userFullProfilePage.getLabelINNText(), UserFullProfilePage.LABEL_INN);
        Assert.assertEquals(userFullProfilePage.getEnteredINN(), "");
    }
}
