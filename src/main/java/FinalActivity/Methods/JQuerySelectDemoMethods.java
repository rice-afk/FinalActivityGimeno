package FinalActivity.Methods;

import FinalActivity.demoPage.JQuerySelectDemoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class JQuerySelectDemoMethods {
    private WebDriver driver;
    String url = "https://demo.seleniumeasy.com/jquery-dropdown-search-demo.html";

    public void dropdownwithSearchbox() {
        setUp();
        driver.get(url);

        JQuerySelectDemoPage page = new JQuerySelectDemoPage(driver);
        page.selectCountryBySearch("Australia");
        String selectedCountry = page.getSelectedCountry();
        Assert.assertEquals("Australia", selectedCountry);
        tearDown();
    }

    public void dropdownwithDisabledValues() {
        setUp();
        driver.get(url);

        JQuerySelectDemoPage page = new JQuerySelectDemoPage(driver);
        page.selectDisabledValueFromDropdown("Puerto Rico",driver);
        tearDown();
    }

    public void testMultipleJQueryDemo() {
        setUp();
        driver.get(url);

        JQuerySelectDemoPage page = new JQuerySelectDemoPage(driver);
        page.multiplevalues(driver);
        tearDown();
    }

    public void selectCategory() {
        setUp();
        driver.get(url);

        JQuerySelectDemoPage page = new JQuerySelectDemoPage(driver);
        page.selectCategoryOption("C",driver);
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
