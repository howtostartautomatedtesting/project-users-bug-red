import org.testng.annotations.Test;
import pageobjects.HomePage;
import uiTitles.HomePageUITitles;

import static org.testng.Assert.assertEquals;

public class HomePageTest extends AbstractTest {
    @Test
    public void testUIHomePage() {

        HomePage homePage = new HomePage(driver).openPage();
        assertEquals(homePage.getFormTitleUsers(), HomePageUITitles.EXPECTED_FORM_USERS_TITLE);
        assertEquals(homePage.getTitleDateOfChange(), HomePageUITitles.EXPECTED_DATE_OF_CHANGE_TITLE);
        assertEquals(homePage.getTitleDateFrom(), HomePageUITitles.EXPECTED_DATE_FROM_TITLE);
        assertEquals(homePage.getTitleDateTill(), HomePageUITitles.EXPECTED_DATE_TILL_TITLE);
        assertEquals(homePage.getTitleSearchString(), HomePageUITitles.EXPECTED_SEARCH_STRING_TITLE);
        assertEquals(homePage.getTitleResetFilter(), HomePageUITitles.EXPECTED_RESET_FILTER_TITLE);
        assertEquals(homePage.getTitleHeaderTableEmail(), HomePageUITitles.EXPECTED_HEADER_TABLE_EMAIL_TITLE);
        assertEquals(homePage.getTitleHeaderTableFullName(), HomePageUITitles.EXPECTED_HEADER_TABLE_FULL_NAME_TITLE);
        assertEquals(homePage.getTitleHeaderTableAuthor(), HomePageUITitles.EXPECTED_HEADER_TABLE_AUTHOR_TITLE);
        assertEquals(homePage.getTitleHeaderTableDateOfChange(), HomePageUITitles.EXPECTED_HEADER_TABLE_DATE_OF_CHANGE_TITLE);


    }
}
