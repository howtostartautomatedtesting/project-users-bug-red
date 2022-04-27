import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import pageobjects.AddCompanyPage;
import pageobjects.AuthorizedUserHomePage;
import pageobjects.UserLoginPage;
import uiTitles.AddCompanyPageUITitles;
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

        assertEquals(addCompanyPage.getHeaderTitle(), AddCompanyPageUITitles.EXPECTED_HEADER_TITLE);
        assertEquals(addCompanyPage.getFieldNameTitle(), AddCompanyPageUITitles.EXPECTED_FIELD_NAME_TITLE);
        assertEquals(addCompanyPage.getFieldTypeTitle(), AddCompanyPageUITitles.EXPECTED_FIELD_TYPE_TITLE);
        assertEquals(addCompanyPage.getFieldINNTitle(), AddCompanyPageUITitles.EXPECTED_FIELD_INN_TITLE);
        assertEquals(addCompanyPage.getFieldOGRNTitle(), AddCompanyPageUITitles.EXPECTED_FIELD_OGRN_TITLE);
        assertEquals(addCompanyPage.getFieldKPPTitle(), AddCompanyPageUITitles.EXPECTED_FIELD_KPP_TITLE);
        assertEquals(addCompanyPage.getFieldPhoneTitle(), AddCompanyPageUITitles.EXPECTED_FIELD_PHONE_TITLE);
        assertEquals(addCompanyPage.getFieldAddressTitle(), AddCompanyPageUITitles.EXPECTED_FIELD_ADDRESS_TITLE);
        assertEquals(addCompanyPage.getFieldUsersTitle(), AddCompanyPageUITitles.EXPECTED_FIELD_USERS_TITLE);
        assertEquals(addCompanyPage.getButtonClearFieldUsersName(), AddCompanyPageUITitles.EXPECTED_BUTTON_CLEAR_FIELD_USERS_NAME);
        assertEquals(addCompanyPage.getButtonAddCompanyName(), AddCompanyPageUITitles.EXPECTED_BUTTON_ADD_COMPANY_NAME);
    }

    @Test(groups = "authorizedUser", enabled = false)
    public void testAddCompanyPageFieldsTypes() {
        //надо ли проверять типы полей формы (text, button, select...)?
    }

    @Test(groups = "authorizedUser")
    public void testAddCompanyPageAddCompanyWithEmptyFields() {
        String emptyField = "";
        AddCompanyPage addCompanyPage = authorizedUser.clickButtonCompanies()
                .clickButtonAddCompany()
                .fillFormAddCompany(emptyField, emptyField, emptyField, emptyField, emptyField, emptyField, emptyField, emptyField);

        //проверка для русской локализации браузера
        assertEquals(addCompanyPage.getMessageIfFieldNameIsEmpty(), AddCompanyPageUITitles.EXPECTED_EMPTY_INPUT_FIELD_MESSAGE_RUS);

        //проверка для английской локализации браузера
        //assertEquals(addCompanyPage.getMessageIfFieldNameIsEmpty(), AddCompanyPageUITitles.EXPECTED_EMPTY_INPUT_FIELD_MESSAGE_ENG);
    }
}
