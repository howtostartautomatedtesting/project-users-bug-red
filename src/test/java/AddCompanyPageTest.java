import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import pageobjects.AddCompanyPage;
import pageobjects.AuthorizedUserHomePage;
import pageobjects.UserLoginPage;

import static org.testng.Assert.assertEquals;

public class AddCompanyPageTest extends AbstractTest {

    private AuthorizedUserHomePage authorizedUser;

    @BeforeGroups("authorizedUser")
    public void logInAccount() {
        String testUserEmail = "testUser@mail.ru";
        String testUserPassword = "test";
        authorizedUser = new UserLoginPage(driver).openPage()
                .fillFormLoginAndClickButtonAuthorization(testUserEmail, testUserPassword);
    }

    @Test(groups = "authorizedUser")
    public void testAddCompanyPageFormNames() {
        String expectedHeaderTitle = "Добавление компании";
        String expectedFieldNameTitle = "Название";
        String expectedFieldTypeTitle = "ТИП";
        String expectedFieldINNTitle = "ИНН";
        String expectedFieldOGRNTitle = "ОГРН";
        String expectedFieldKPPTitle = "КПП";
        String expectedFieldPhoneTitle = "Телефон";
        String expectedFieldAddressTitle = "Адрес";
        String expectedFieldUsersTitle = "Сотрудники";
        String expectedButtonClearFieldUsersName = "Очистить поле";
        String expectedButtonAddCompanyName = "Добавить компанию";

        AddCompanyPage addCompanyPage = authorizedUser.clickButtonCompanies()
                .clickButtonAddCompany();

        assertEquals(addCompanyPage.getHeaderTitle(), expectedHeaderTitle);
        assertEquals(addCompanyPage.getFieldNameTitle(), expectedFieldNameTitle);
        assertEquals(addCompanyPage.getFieldTypeTitle(), expectedFieldTypeTitle);
        assertEquals(addCompanyPage.getFieldINNTitle(), expectedFieldINNTitle);
        assertEquals(addCompanyPage.getFieldOGRNTitle(), expectedFieldOGRNTitle);
        assertEquals(addCompanyPage.getFieldKPPTitle(), expectedFieldKPPTitle);
        assertEquals(addCompanyPage.getFieldPhoneTitle(), expectedFieldPhoneTitle);
        assertEquals(addCompanyPage.getFieldAddressTitle(), expectedFieldAddressTitle);
        assertEquals(addCompanyPage.getFieldUsersTitle(), expectedFieldUsersTitle);
        assertEquals(addCompanyPage.getButtonClearFieldUsersName(), expectedButtonClearFieldUsersName);
        assertEquals(addCompanyPage.getButtonAddCompanyName(), expectedButtonAddCompanyName);
    }

    @Test(groups = "authorizedUser")
    public void testAddCompanyPageFieldsTypes() {
        //надо ли проверять типы полей формы (text, button, select...)?
    }

}
