import org.testng.annotations.Test;
import pageobjects.HomePage;

import static org.testng.Assert.assertEquals;

public class HomePageTest extends AbstractTest {
    @Test
    public void testUIHomePage() {
        HomePage homePage = new HomePage(driver).openPage();

        assertEquals(homePage.getTitleButtonUsers(), HomePage.BUTTON_LABEL_USERS);
        assertEquals(homePage.getTitleButtonLogin(), HomePage.BUTTON_LABEL_LOGIN);
        assertEquals(homePage.getTitleButtonSearch(), HomePage.BUTTON_LABEL_SEARCH);
        assertEquals(homePage.getFormTitleUsers(), HomePage.HEADING_USERS);
        assertEquals(homePage.getTitleDateOfChange(), HomePage.HEADING_DATE_OF_CHANGE);
        assertEquals(homePage.getTitleDateFrom(), HomePage.LABEL_DATE_FROM);
        assertEquals(homePage.getTitleDateTill(), HomePage.LABEL_DATE_TILL);
        assertEquals(homePage.getTitleInputDateStart(), HomePage.INPUT_DATE_START);
        assertEquals(homePage.getTitleInputDateEnd(), HomePage.INPUT_DATE_END);
        assertEquals(homePage.getTitleInputSearch(), HomePage.INPUT_VALUE_SEARCH);
        assertEquals(homePage.getTitleSearchString(), HomePage.HEADING_SEARCH);
        assertEquals(homePage.getTitleResetFilter(), HomePage.LINK_LABEL_RESET_FILTERS);
        assertEquals(homePage.getTitleHeaderTableEmail(), HomePage.TABLE_HEADING_EMAIL);
        assertEquals(homePage.getTitleHeaderTableFullName(), HomePage.TABLE_HEADING_FULL_NAME);
        assertEquals(homePage.getTitleHeaderTableAuthor(), HomePage.TABLE_HEADING_AUTHOR);
        assertEquals(homePage.getTitleHeaderTableDateOfChange(), HomePage.TABLE_HEADING_DATE_OF_CHANGE);
        assertEquals(homePage.getTitleHeaderTableChange(), HomePage.TABLE_HEADING_CHANGE);
        assertEquals(homePage.getTitleHeaderTableDelete(), HomePage.TABLE_HEADING_DELETE);
    }
}
