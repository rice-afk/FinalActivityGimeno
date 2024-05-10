package FinalActivity.Methods;

import FinalActivity.demoPage.BootstrapModalDemoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BootstrapModalMethods
{
    private WebDriver driver;
    String url = "https://demo.seleniumeasy.com/bootstrap-modal-demo.html";

    public void testBootstrapModalDemo() {
        setUp();
        driver.get(url);

        BootstrapModalDemoPage page = new BootstrapModalDemoPage(driver);
        page.launchAndVerifyModal1(driver);
        page.closeModal(driver, By.xpath("(//a[@class='btn btn-primary'][normalize-space()='Save changes'])[2]"));
        page.launchAndVerifyModal1(driver);
        page.closeModal(driver, By.xpath("(//a[@class='btn'][normalize-space()='Close'])[2]"));
        page.launchAndVerifyModal1(driver);
        page.closeModal(driver, By.xpath("(//button[@type='button'][normalize-space()='×'])[2]"));

        page.launchAndVerifyModal2(driver);
        page.closeModal(driver, By.xpath("(//button[@type='button'][normalize-space()='×'])[3]"));
        page.launchAndVerifyModal1(driver);
        page.launchAndVerifyModal2(driver);
        page.closeModal(driver, By.xpath("(//a[@class='btn'][normalize-space()='Close'])[3]"));
        page.launchAndVerifyModal2(driver);
        page.closeModal(driver, By.xpath("(//a[@class='btn btn-primary'][normalize-space()='Save changes'])[3]"));

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
