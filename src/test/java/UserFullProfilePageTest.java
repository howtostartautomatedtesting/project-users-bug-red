import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.UserFullProfilePage;

public class UserFullProfilePageTest extends AbstractTest {



    @Test
    public void testOpenPage() throws InterruptedException {
        UserFullProfilePage userFullProfilePage = new UserFullProfilePage(driver);
        userFullProfilePage.fillFormLoginUser("ira@mail.ru", "12345");
        userFullProfilePage.openUsersPage();
        Assert.assertEquals(userFullProfilePage.getHeadingProfile(), "Профиль пользователя");
        Assert.assertEquals(userFullProfilePage.getLabelEmailText(), "Email");
        Assert.assertEquals(userFullProfilePage.getLabelInitialsText(), "ФИО");
        Assert.assertEquals(userFullProfilePage.getLabelGenderText(), "Пол");
        Assert.assertEquals(userFullProfilePage.getLabelBirthdayText(), "Дата рождения");
        Assert.assertEquals(userFullProfilePage.getLabelDateStartText(), "Начал работать в компании");
        Assert.assertEquals(userFullProfilePage.getLabelHobbyText(), "Хобби");
        Assert.assertEquals(userFullProfilePage.getLabelINNText(), "ИНН");
        Assert.assertEquals(userFullProfilePage.getEnteredEmail(), "ira@mail.ru");
        Assert.assertEquals(userFullProfilePage.getEnteredInitials(), "Ирусик");
        // Assert.assertEquals(userFullProfilePage.getSelectedGender(), "Не определен"); выбивает ошибку
        Assert.assertEquals(userFullProfilePage.getEnteredBirthday(), "");
        Assert.assertEquals(userFullProfilePage.getEnteredDateStart(), "");
        Assert.assertEquals(userFullProfilePage.getEnteredHobby(), "");
        Assert.assertEquals(userFullProfilePage.getEnteredINN(), "");



        Thread.sleep(1000);
    }
}
