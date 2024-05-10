package FinalActivity.tests;

import FinalActivity.Methods.CheckboxDemoMethods;
import FinalActivity.Methods.TableSortSearchDemoMethods;
import FinalActivity.demoPage.TableSortSearchDemoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TableSortSearchDemoTests {

    private WebDriver driver;

    @Test
    public void testTableSortSearchDemo() {
        TableSortSearchDemoMethods page = new TableSortSearchDemoMethods();
        page.testTableSortSearchDemo();
    }

    @AfterMethod
    public void tearDown() {
        if (driver!= null) {
            driver.quit();
        }
    }
}
