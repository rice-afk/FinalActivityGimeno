package FinalActivity.Methods;

import FinalActivity.demoPage.DataListFilterDemoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class DataListFilterDemoMethods {
    private WebDriver driver;
    String url = "https://demo.seleniumeasy.com/data-list-filter-demo.html";

    public void testSearchAndVerifyName() {
       setUp();

        try {
            // Navigate to the page
            driver.get(url);

            // Use the page object to interact with the page
            DataListFilterDemoPage page = new DataListFilterDemoPage(driver);
            page.searchByName("Brenda Tree");

            // Verify the name
            boolean isNameDisplayed = page.isNameDisplayed();
            Assert.assertTrue(isNameDisplayed, "Name: Brenda Tree is not displayed on the page.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser window
            driver.quit();
        }
    }

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    public void tearDown() {
        if (driver!= null) {
            driver.quit();
        }
    }
}
