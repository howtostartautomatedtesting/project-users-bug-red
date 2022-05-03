import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.AddCompanyPage;
import pageobjects.AuthorizedUserHomePage;
import pageobjects.UserLoginPage;
import utils.UserCreator;

import static org.testng.Assert.assertEquals;

public class AddCompanyPageTest extends AbstractTest {

    AuthorizedUserHomePage authorizedUserHomePage;
    AddCompanyPage addCompanyPage;
    UserLoginPage userLoginPage;

    public static final String expectedHeaderTitle = "Добавление компании";
    public static final String expectedFieldNameTitle = "Название";
    public static final String expectedFieldTypeTitle = "ТИП";
    public static final String expectedFieldINNTitle = "ИНН";
    public static final String expectedFieldOGRNTitle = "ОГРН";
    public static final String expectedFieldKPPTitle = "КПП";
    public static final String expectedFieldPhoneTitle = "Телефон";
    public static final String expectedFieldAddressTitle = "Адрес";
    public static final String expectedFieldUsersTitle = "Сотрудники";
    public static final String expectedButtonClearFieldUsersName = "Очистить поле";
    public static final String expectedButtonAddCompanyName = "Добавить компанию";

    @BeforeGroups("registrationUser")
    public void pathToPageRegistrationUserHome() {
        userLoginPage = new UserLoginPage(driver);

        userLoginPage
                .openPage()
                .fillFormRegistrationAndClickButtonRegistration(
                        UserCreator.getUserName(),
                        UserCreator.getEmail(),
                        UserCreator.getPassword());
    }

    @BeforeGroups("authorizationUser")
    public void pathToPageAuthorizationUserHome() {
        userLoginPage = new UserLoginPage(driver);

        userLoginPage
                .openPage()
                .fillFormLoginAndClickButtonAuthorization(
                        UserCreator.getEmail(),
                        UserCreator.getPassword());
    }

    @AfterMethod
    public void closePage() throws InterruptedException {
        authorizedUserHomePage = new AuthorizedUserHomePage(driver);
        authorizedUserHomePage.logOutAuthorizedUserPage();
        Thread.sleep(2000);
    }

   /* @BeforeGroups("authorizedUser")
    public void logInAccount() {
        String testUserEmail = "testUser@mail.ru";
        String testUserPassword = "test";
        authorizedUserHomePage = new UserLoginPage(driver).openPage()
                .fillFormLoginAndClickButtonAuthorization(testUserEmail, testUserPassword);
    }*/

    @Test(groups = "registrationUser")
    public void testAddCompanyPageFormNames(){
        authorizedUserHomePage = new AuthorizedUserHomePage(driver);
        addCompanyPage = authorizedUserHomePage.clickButtonCompanies()
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

   /* @Test(groups = "authorizedUser")
    public void testAddCompanyPageFieldsTypes() {
        //надо ли проверять типы полей формы (text, button, select...)?
    }*/

    @Test(groups = "authorizationUser")
    public void testAddCompanyWithInvalidData() throws InterruptedException {
        authorizedUserHomePage = new AuthorizedUserHomePage(driver);
        addCompanyPage = authorizedUserHomePage.clickButtonCompanies()
                .clickButtonAddCompany();

        addCompanyPage.typeName("Компания 2")
                .typeInn("12345")
                .clickAddCompany();
        String message = driver.findElement(By.name("inn")).getAttribute("message");
        //String message = driver.findElement(By.className("bottom-right")).getAttribute("message"); не знаю как проверить, нет значения атрибута validationMessage
        System.out.println(message);
       // assertEquals(message, "Поле ИНН должно состоять из 12 цифр");

        addCompanyPage
                .typeInn("")
                .typeOgrn("12345")
                .clickAddCompany();

        addCompanyPage
                .typeInn("")
                .typeOgrn("")
                .typeKpp("12345")
                .clickAddCompany();

        addCompanyPage
                .typeInn("")
                .typeOgrn("")
                .typeKpp("")
                .typePhoneNumber("text")
                .clickAddCompany();

        Thread.sleep(3000);

    }
}
