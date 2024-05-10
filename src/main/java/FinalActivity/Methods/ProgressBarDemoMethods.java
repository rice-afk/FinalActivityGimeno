package FinalActivity.Methods;

import FinalActivity.demoPage.ProgressBarDemoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ProgressBarDemoMethods {
    private WebDriver driver;
    String url = "https://demo.seleniumeasy.com/basic-checkbox-demo.html";

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
