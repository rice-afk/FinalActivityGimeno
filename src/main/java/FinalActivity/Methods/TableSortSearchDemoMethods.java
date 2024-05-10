package FinalActivity.Methods;

import FinalActivity.demoPage.TableSortSearchDemoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TableSortSearchDemoMethods {
    private WebDriver driver;
    String url = "https://demo.seleniumeasy.com/table-sort-search-demo.html";

    public void testTableSortSearchDemo() {
        setUp();
        driver.get(url);

        TableSortSearchDemoPage page = new TableSortSearchDemoPage(driver);
        page.selectEntries(25);
        page.searchFor("a ramos");
        page.clearSearch();
        page.searchFor("a");
        page.clickPaginationLink("next");
        page.clickPaginationLink("previous");
        page.clickPaginationLink("2");
        tearDown();
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
