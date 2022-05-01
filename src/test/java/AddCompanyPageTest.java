import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import pageobjects.AddCompanyPage;
import pageobjects.AuthorizedUserHomePage;
import pageobjects.CompaniesPage;
import pageobjects.UserLoginPage;
import utils.UserCreator;

import static org.testng.Assert.assertEquals;

public class AddCompanyPageTest extends AbstractTest {

    private AuthorizedUserHomePage authorizedUser;
    String companyName = "Truck";
    String companyType = "ООО";
    String companyINN = "1234567890";
    String companyOGRN = "1233333333333";
    String companyKPP = "123456789";
    String companyPhone = "123";
    String companyAddress = "street";
    String companyEmployee = "A";

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
    public void testAddCompanyPageFieldsTypes(){
        //надо ли проверять типы полей формы (text, button, select...)?
    }

    @Test
    public void tetAddCompanyPageAddCompanyWithValidData() throws InterruptedException {
        CompaniesPage companiesPage = new UserLoginPage(driver).openPage()
                .fillFormRegistrationAndClickButtonRegistration(UserCreator.getUserName(), UserCreator.getEmail(), UserCreator.getPassword())
                .clickButtonCompanies()
                .clickButtonAddCompany().fillFormAndClickAddCompany(companyName, companyType, companyINN, companyOGRN,
                        companyKPP, companyPhone, companyAddress, companyEmployee);
        Thread.sleep(3000);
        assertEquals(companiesPage.getCompanyName(), companyName);


    }

}
