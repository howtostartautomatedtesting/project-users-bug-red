import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

abstract class AbstractTest {
    static WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
