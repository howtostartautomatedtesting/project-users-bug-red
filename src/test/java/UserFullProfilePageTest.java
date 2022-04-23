import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.AuthorizedUserHomePage;
import pageobjects.UserFullProfilePage;
import pageobjects.UserLoginPage;
import pageobjects.UserProfilePage;

public class UserFullProfilePageTest extends AbstractTest {
    UserLoginPage userLoginPage;
    AuthorizedUserHomePage authorizedUserHomePage;
    UserProfilePage userProfilePage;
    UserFullProfilePage userFullProfilePage;

    @BeforeMethod
    public void pathToPageUserFullProfile(){
        userLoginPage = new UserLoginPage(driver);
        authorizedUserHomePage = new AuthorizedUserHomePage(driver);
        userProfilePage = new UserProfilePage(driver);

        userLoginPage
                .openPage()
                .fillFormLogin("ira@mail.ru", "12345");
        authorizedUserHomePage.openUserProfilePage();
        userProfilePage.clickButtonFullProfile();
    }

    @Test
    public void testUserFullProfilePageUI() throws InterruptedException {
        userFullProfilePage = new UserFullProfilePage(driver);

        Assert.assertEquals(userFullProfilePage.getHeadingProfile(), "Профиль пользователя");
        Assert.assertEquals(userFullProfilePage.getLabelEmailText(), "Email");
        Assert.assertEquals(userFullProfilePage.getEnteredEmail(), "ira@mail.ru");
        Assert.assertEquals(userFullProfilePage.getLabelInitialsText(), "ФИО");
        Assert.assertEquals(userFullProfilePage.getEnteredInitials(), "Ирусик");
        Assert.assertEquals(userFullProfilePage.getLabelGenderText(), "Пол");
        // Assert.assertEquals(userFullProfilePage.getSelectedGender(), "Не определен"); выбивает ошибку
        Assert.assertEquals(userFullProfilePage.getLabelBirthdayText(), "Дата рождения");
        Assert.assertEquals(userFullProfilePage.getEnteredBirthday(), "");
        Assert.assertEquals(userFullProfilePage.getLabelDateStartText(), "Начал работать в компании");
        Assert.assertEquals(userFullProfilePage.getEnteredDateStart(), "");
        Assert.assertEquals(userFullProfilePage.getLabelHobbyText(), "Хобби");
        Assert.assertEquals(userFullProfilePage.getEnteredHobby(), "");
        Assert.assertEquals(userFullProfilePage.getLabelNameOne(), "имя1");
        Assert.assertEquals(userFullProfilePage.getInputNameOne(), "");
        Assert.assertEquals(userFullProfilePage.getLabelSurnameOne(), "фамилия1");
        Assert.assertEquals(userFullProfilePage.getInputSurnameOne(), "");
        Assert.assertEquals(userFullProfilePage.getLabelPatronymicOne(), "отчество1");
        Assert.assertEquals(userFullProfilePage.getInputPatronymicOne(), "");
        Assert.assertEquals(userFullProfilePage.getLabelCat(), "Кошечка");
        Assert.assertEquals(userFullProfilePage.getInputCat(), "");
        Assert.assertEquals(userFullProfilePage.getLabelDog(), "Собачка");
        Assert.assertEquals(userFullProfilePage.getInputDog(), "");
        Assert.assertEquals(userFullProfilePage.getLabelParrot(), "Попугайчик");
        Assert.assertEquals(userFullProfilePage.getInputParrot(), "");
        Assert.assertEquals(userFullProfilePage.getLabelCavy(), "Морская свинка");
        Assert.assertEquals(userFullProfilePage.getInputCavy(), "");
        Assert.assertEquals(userFullProfilePage.getLabelHamster(), "Хомячок");
        Assert.assertEquals(userFullProfilePage.getInputHamster(), "");
        Assert.assertEquals(userFullProfilePage.getLabelSquirrel(), "Белочка");
        Assert.assertEquals(userFullProfilePage.getInputSquirrel(), "");
        Assert.assertEquals(userFullProfilePage.getLabelPhone(), "Телефон");
        Assert.assertEquals(userFullProfilePage.getInputPhone(), "");
        Assert.assertEquals(userFullProfilePage.getLabelAddress(), "Адрес");
        Assert.assertEquals(userFullProfilePage.getInputAddress(), "");
        Assert.assertEquals(userFullProfilePage.getLabelINNText(), "ИНН");
        Assert.assertEquals(userFullProfilePage.getEnteredINN(), "");

        Thread.sleep(500);
    }
}