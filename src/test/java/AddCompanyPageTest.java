import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import pageobjects.AddCompanyPage;
import pageobjects.AuthorizedUserHomePage;
import pageobjects.UserLoginPage;
import utils.UserCreator;

import static org.testng.Assert.assertEquals;

public class AddCompanyPageTest extends AbstractTest {

    private String userName;
    private String userMail;
    private String userPassword;
    private AuthorizedUserHomePage authorizedUser;

    @BeforeGroups("authorizedUser")
    public void logInAccount() {
        userName = UserCreator.getUserName();
        userMail = UserCreator.getEmail();
        userPassword = UserCreator.getPassword();
        authorizedUser = new UserLoginPage(driver).openPage()
                .fillFormRegistrationAndClickButtonRegistration(userName, userMail, userPassword);
    }

    @Test(groups = "authorizedUser")
    public void testAddCompanyPageFormNames() {
        AddCompanyPage addCompanyPage = authorizedUser.clickButtonCompanies()
                .clickButtonAddCompany();

        assertEquals(addCompanyPage.getHeaderTitle(), AddCompanyPage.HEADING_ADD_COMPANY);
        assertEquals(addCompanyPage.getFieldNameTitle(), AddCompanyPage.LABEL_NAME);
        assertEquals(addCompanyPage.getFieldTypeTitle(), AddCompanyPage.LABEL_TYPE);
        assertEquals(addCompanyPage.getFieldINNTitle(), AddCompanyPage.LABEL_INN);
        assertEquals(addCompanyPage.getFieldOGRNTitle(), AddCompanyPage.LABEL_OGRN);
        assertEquals(addCompanyPage.getFieldKPPTitle(), AddCompanyPage.LABEL_KPP);
        assertEquals(addCompanyPage.getFieldPhoneTitle(), AddCompanyPage.LABEL_PHONE);
        assertEquals(addCompanyPage.getFieldAddressTitle(), AddCompanyPage.LABEL_ADDRESS);
        assertEquals(addCompanyPage.getFieldUsersTitle(), AddCompanyPage.LABEL_USERS);
        assertEquals(addCompanyPage.getButtonClearFieldUsersName(), AddCompanyPage.BUTTON_LABEL_CLEAR_FIELD_USERS);
        assertEquals(addCompanyPage.getButtonAddCompanyName(), AddCompanyPage.BUTTON_LABEL_ADD_COMPANY);
    }

    @Test(groups = "authorizedUser", enabled = false)
    public void testAddCompanyPageFieldsTypes() {
        //надо ли проверять типы полей формы (text, button, select...)?
    }
}
