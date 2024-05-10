package FinalActivity.Methods;

import FinalActivity.demoPage.AjaxFormSubmitDemoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class AjaxFormDemoMethods {
    private WebDriver driver;
    String url = "https://demo.seleniumeasy.com/ajax-form-submit-demo.html";

    public void testAjaxFormSubmit() {
        setUp();
        driver.get(url);

        AjaxFormSubmitDemoPage page = new AjaxFormSubmitDemoPage(driver);
        page.fillForm("John Doe", "This is a test comment.");
        page.submitForm();

        page.waitForSuccessMessageVisibiity(driver);
        String initialMessage = page.printInitialMessage(driver);
        Assert.assertEquals("Ajax Request is Processing!", initialMessage, "Initial message does not match.");
        page.waitForSuccessMessage(driver);
        String successMessage = page.printFinalMessage();
        Assert.assertEquals("Form submitted Successfully!", successMessage, "Success message does not match.");
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
