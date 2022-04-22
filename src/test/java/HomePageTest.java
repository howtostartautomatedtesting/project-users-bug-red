import org.testng.annotations.Test;
import pageobjects.HomePage;
import uiTitles.HomegPageUITitles;

import static org.testng.Assert.assertEquals;

public class HomePageTest extends AbstractTest {
    @Test
    public void testUIHomePage() {

        HomePage homePage = new HomePage(driver).openPage();
        assertEquals(homePage.getFormTitleUsers(), HomegPageUITitles.EXPECTED_FORM_USERS_TITLE);
        assertEquals(homePage.getTitleDateOfChange(), HomegPageUITitles.EXPECTED_DATE_OF_CHANGE_TITLE);
        assertEquals(homePage.getTitleSearchString(), HomegPageUITitles.EXPECTED_SEARCH_STRING_TITLE);
        assertEquals(homePage.getTitleResetFilter(), HomegPageUITitles.EXPECTED_RESET_FILTER_TITLE);
        assertEquals(homePage.getTitleHeaderTableEmail(), HomegPageUITitles.EXPECTED_HEADER_TABLE_EMAIL_TITLE);
        assertEquals(homePage.getTitleHeaderTableFullName(), HomegPageUITitles.EXPECTED_HEADER_TABLE_FULL_NAME_TITLE);
        assertEquals(homePage.getTitleHeaderTableAuthor(), HomegPageUITitles.EXPECTED_HEADER_TABLE_AUTHOR_TITLE);
        assertEquals(homePage.getTitleHeaderTableDateOfChange(), HomegPageUITitles.EXPECTED_HEADER_TABLE_DATE_OF_CHANGE_TITLE);


    }
}
