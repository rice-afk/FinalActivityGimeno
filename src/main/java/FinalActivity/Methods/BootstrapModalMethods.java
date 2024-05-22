package FinalActivity.Methods;

import FinalActivity.demoPage.BootstrapModalDemoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BootstrapModalMethods
{
    private WebDriver driver;
    String url = "https://demo.seleniumeasy.com/bootstrap-modal-demo.html";

    // Main method to test launching and closing modals using different buttons
    public void testBootstrapModalDemo() {
        setUp();
        try {
            driver.get(url);
            BootstrapModalDemoPage page = new BootstrapModalDemoPage(driver);
            page.launchAndVerifyModal1(driver);
            System.out.println("Passed: Launched and verified Modal 1");
            page.closeModal(driver, By.xpath("(//a[@class='btn btn-primary'][normalize-space()='Save changes'])[2]"));
            System.out.println("Passed: Closed Modal 1 with Save Changes button");
            page.launchAndVerifyModal1(driver);
            System.out.println("Passed: Launched and verified Modal 1 again");
            page.closeModal(driver, By.xpath("(//a[@class='btn'][normalize-space()='Close'])[2]"));
            System.out.println("Passed: Closed Modal 1 with Close button");
            page.launchAndVerifyModal1(driver);
            System.out.println("Passed: Launched and verified Modal 1 yet again");
            page.closeModal(driver, By.xpath("(//button[@type='button'][normalize-space()='×'])[2]"));
            System.out.println("Passed: Closed Modal 1 with X button");

            page.launchAndVerifyModal2(driver);
            System.out.println("Passed: Launched and verified Modal 2");
            page.closeModal(driver, By.xpath("(//button[@type='button'][normalize-space()='×'])[3]"));
            System.out.println("Passed: Closed Modal 2 with X button");
            page.launchAndVerifyModal1(driver);
            System.out.println("Passed: Launched and verified Modal 1 once more");
            page.launchAndVerifyModal2(driver);
            System.out.println("Passed: Launched and verified Modal 2 once more");
            page.closeModal(driver, By.xpath("(//a[@class='btn'][normalize-space()='Close'])[3]"));
            System.out.println("Passed: Closed Modal 2 with Close button");
            page.launchAndVerifyModal2(driver);
            System.out.println("Passed: Launched and verified Modal 2 twice more");
            page.closeModal(driver, By.xpath("(//a[@class='btn btn-primary'][normalize-space()='Save changes'])[3]"));
            System.out.println("Passed: Closed Modal 2 with Save Changes button");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (TimeoutException | NoSuchElementException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            tearDown();
        }
    }

    public void testBootstrapModal1Demo() {
        setUp();
        try {
            driver.get(url);
            BootstrapModalDemoPage page = new BootstrapModalDemoPage(driver);
            page.launchAndVerifyModal(driver);
            System.out.println("Passed: Launched and verified Modal");
            page.closeModal(driver, By.xpath("(//a[@class='btn btn-primary'][normalize-space()='Save changes'])[1]"));
            System.out.println("Passed: Closed Modal with Save Changes button");
            page.launchAndVerifyModal(driver);
            System.out.println("Passed: Launched and verified Modal");
            page.closeModal(driver, By.xpath("(//a[@class='btn'][normalize-space()='Close'])[1]"));
            System.out.println("Passed: Closed Modal with Close button");
            page.launchAndVerifyModal(driver);
            System.out.println("Passed: Launched and verified Modal");
            page.closeModal(driver, By.xpath("(//button[@type='button'][normalize-space()='×'])[1]"));
            System.out.println("Passed: Closed Modal with X button");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (TimeoutException | NoSuchElementException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            tearDown();
        }
    }

    // Setup method to initialize WebDriver and set implicit wait time
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    // Teardown method to quit the WebDriver session
    public void tearDown() {
        if (driver!= null) {
            driver.quit();
        }
    }

}
