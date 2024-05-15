package FinalActivity.Methods;

import FinalActivity.demoPage.ProgressBarDemoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ProgressBarDemoMethods {
    private WebDriver driver;
    String url = "https://demo.seleniumeasy.com/bootstrap-download-progress-demo.html";

    //Method to press button and run Progress Bar
    public void testProgressBarDemo() {
        setUp();
        driver.get(url);

        ProgressBarDemoPage page = new ProgressBarDemoPage(driver);
        page.checkInitialProgress();
        page.clickDownloadButton();
        try {
            page.waitForProgressToComplete();
            page.checkFinalProgress();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Test Passed");
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
