import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pageobjects.AddCompanyPage;
import pageobjects.AuthorizedUserHomePage;
import pageobjects.HomePage;
import pageobjects.UserLoginPage;
import utils.UserCreator;

import static org.testng.Assert.assertEquals;

public class AddCompanyPageTest extends AbstractTest {

    AuthorizedUserHomePage authorizedUserHomePage;
    AddCompanyPage addCompanyPage;
    UserLoginPage userLoginPage;

    @Test
    public void testAddCompanyPageFormNames() {

        HomePage homePage = new HomePage(driver);
        homePage.openPage()
                .clickButtonLogin();

        userLoginPage = new UserLoginPage(driver);

        userLoginPage
                .openPage()
                .fillFormRegistrationAndClickButtonRegistration(
                        UserCreator.getUserName(),
                        UserCreator.getEmail(),
                        UserCreator.getPassword());

        authorizedUserHomePage = new AuthorizedUserHomePage(driver);

        addCompanyPage = authorizedUserHomePage.clickButtonCompanies()
                .clickButtonAddCompany();

        assertEquals(addCompanyPage.getHeaderTitle(), AddCompanyPage.expectedHeaderTitle);
        assertEquals(addCompanyPage.getFieldNameTitle(), AddCompanyPage.expectedFieldNameTitle);
        assertEquals(addCompanyPage.getFieldTypeTitle(), AddCompanyPage.expectedFieldTypeTitle);
        assertEquals(addCompanyPage.getFieldINNTitle(), AddCompanyPage.expectedFieldINNTitle);
        assertEquals(addCompanyPage.getFieldOGRNTitle(), AddCompanyPage.expectedFieldOGRNTitle);
        assertEquals(addCompanyPage.getFieldKPPTitle(), AddCompanyPage.expectedFieldKPPTitle);
        assertEquals(addCompanyPage.getFieldPhoneTitle(), AddCompanyPage.expectedFieldPhoneTitle);
        assertEquals(addCompanyPage.getFieldAddressTitle(), AddCompanyPage.expectedFieldAddressTitle);
        assertEquals(addCompanyPage.getFieldUsersTitle(), AddCompanyPage.expectedFieldUsersTitle);
        assertEquals(addCompanyPage.getButtonClearFieldUsersName(), AddCompanyPage.expectedButtonClearFieldUsersName);
        assertEquals(addCompanyPage.getButtonAddCompanyName(), AddCompanyPage.expectedButtonAddCompanyName);
    }

    @Ignore //TODO implement test
    @Test(groups = "authorizedUser")
    public void testAddCompanyPageFieldsTypes(){
        //надо ли проверять типы полей формы (text, button, select...)?
    }


}
