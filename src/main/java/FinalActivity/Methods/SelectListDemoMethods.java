package FinalActivity.Methods;

import FinalActivity.demoPage.SelectListDemoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class SelectListDemoMethods {
    private WebDriver driver;
    String url = "https://demo.seleniumeasy.com/basic-select-dropdown-demo.html";

    // Method to test single selection from a dropdown list
    public void singleSelectListDemo() {
        setUp();
        driver.get(url);

        SelectListDemoPage page = new SelectListDemoPage(driver);
        page.selectOptionByVisibleText("Sunday");
        String selectedValue = page.getSelectedValueText();
        Assert.assertEquals("Day selected :- Sunday", selectedValue);
        System.out.println("singleSelectListDemo Test Passed");

        tearDown();
    }

    // Method to test multi-selection from a dropdown list
    public void multiSelectListDemo() {
        setUp();
        driver.get(url);

        SelectListDemoPage page = new SelectListDemoPage(driver);
        page.clickFlorida();
        page.clickPrintButton();
        String selectedValue1 = page.getSelectedValuesText();
        Assert.assertEquals("First selected option is : Florida", selectedValue1);

        page.clickPrintAllButton();
        String selectedValue2 = page.getSelectedValuesText();
        Assert.assertEquals("Options selected are : Florida", selectedValue2);

        System.out.println("multiSelectListDemo Test Passed");
        tearDown();
    }

    // Setup method to initialize WebDriver and set implicit wait time
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    // Teardown method to quit the WebDriver session
    public void tearDown() {
        if (driver!= null) {
            driver.quit();
        }
    }
}
