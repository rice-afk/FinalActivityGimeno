package FinalActivity.Methods;

import FinalActivity.URL.webpageload;
import FinalActivity.demoPage.SimpleFormDemoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;

public class SimpleFormDemoMethods extends webpageload {
    private WebDriver driver;
    String url = "https://demo.seleniumeasy.com/basic-first-form-demo.html";
    public void testSubmitForm(String expectedMessage) {
        setUp();
        driver.get(url);
        SimpleFormDemoPage page = new SimpleFormDemoPage(driver);
        page.enterUserMessage(expectedMessage);
        String actualMessage = page.getMessage();
        Assert.assertEquals(actualMessage, expectedMessage, "The expected message does not match the actual message");
        tearDown();
    }
    public void testCalculateAndVerifyResult(int a, int b) {
        setUp();
        driver.get(url);
        SimpleFormDemoPage page = new SimpleFormDemoPage(driver);
        page.enterValues(a, b);
        int c = a+b;
        String actualResult = page.getResult();
        String expectedResult = Integer.toString(c);
        Assert.assertEquals(actualResult, expectedResult, "The expected result does not match the actual result");
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
