import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.UserLoginPage;
import pageobjects.UserProfilePage;
import utils.UserCreator;

public class UserProfilePageTest extends AbstractTest {
    private static final String EXPECTED_GENDER = "Мужской";

    @Test
    public void testChangingGenderUserWithValidData() {
        UserProfilePage userProfilePage = new UserLoginPage(driver).openPage()
                .fillFormRegistrationAndClickButtonRegistration(UserCreator.getUserName(), UserCreator.getEmail(), UserCreator.getPassword())
                .openUserProfilePage()
                .choseGender("M").clickButtonSave();
        Assert.assertEquals(userProfilePage.getInputGender(),EXPECTED_GENDER);
    }
}
