package FinalActivity.Methods;

import FinalActivity.demoPage.TableSortSearchDemoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TableSortSearchDemoMethods {
    private WebDriver driver;
    String url = "https://demo.seleniumeasy.com/table-sort-search-demo.html";

    // Method to test sorting, searching, and pagination in a table
    public void testTableSortSearchDemo() {
        setUp();
        try {
            driver.get(url);

            TableSortSearchDemoPage page = new TableSortSearchDemoPage(driver);
            page.selectEntries(25);
            page.searchFor("a ramos");
            page.clearSearch();
            page.searchFor("a");
            page.clickPaginationLink("next");
            page.clickPaginationLink("previous");
            page.clickPaginationLink("2");
            System.out.println("Test completed successfully.");
            Thread.sleep(2000);
        }catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            tearDown();
        }
    }

    // Setup method to initialize WebDriver and set implicit wait time
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    // Teardown method to quit the WebDriver session
    public void tearDown() {
        if (driver!= null) {
            driver.quit();
        }
    }
}
