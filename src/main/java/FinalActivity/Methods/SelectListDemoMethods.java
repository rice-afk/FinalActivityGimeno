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

    public void singleSelectListDemo() {
        setUp();
        driver.get(url);

        SelectListDemoPage page = new SelectListDemoPage(driver);
        page.selectOptionByVisibleText("Sunday");
        String selectedValue = page.getSelectedValueText();
        Assert.assertEquals("Day selected :- Sunday", selectedValue);

        tearDown();
    }

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
