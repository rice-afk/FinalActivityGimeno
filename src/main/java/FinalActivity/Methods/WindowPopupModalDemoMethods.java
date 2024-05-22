package FinalActivity.Methods;

import FinalActivity.demoPage.WindowPopupModalDemoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Set;

public class WindowPopupModalDemoMethods {
    private WebDriver driver;
    String url = "https://demo.seleniumeasy.com/window-popup-modal-demo.html";

    // Method to test clicking the Twitter link and asserting the URL of the opened popup
    public void twitterButton() {
        setUp();
        try {
            driver.get(url);

            WindowPopupModalDemoPage page = new WindowPopupModalDemoPage(driver);
            page.clickTwitterLink();

            // Wait for the new window to open
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));

            // Switch to the new window
            Set<String> windowHandles = driver.getWindowHandles();
            for (String handle : windowHandles) {
                if (!driver.getWindowHandle().equals(handle)) {
                    driver.switchTo().window(handle);
                    break;
                }
            }
            // Perform the assertion on the current window's URL
            String expectedTwitterUrl = "https://x.com/intent/follow?screen_name=seleniumeasy&mx=2";
            Assert.assertEquals(driver.getCurrentUrl(), expectedTwitterUrl, "Twitter URL assertion failed");

            // Close the new window and switch back to the original window
            driver.close();
            driver.switchTo().window(windowHandles.iterator().next());

            System.out.println("twitterButton Test Passed");
            Thread.sleep(2000);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            tearDown();
        }
    }

    // Method to test clicking the Facebook link and asserting the URL of the opened popup
    public void facebookButton() {
        setUp();
        try {
            driver.get(url);

            WindowPopupModalDemoPage page = new WindowPopupModalDemoPage(driver);
            page.clickFacebookLink();

            // Wait for the new window to open
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));

            // Switch to the new window
            Set<String> windowHandles = driver.getWindowHandles();
            for (String handle : windowHandles) {
                if (!driver.getWindowHandle().equals(handle)) {
                    driver.switchTo().window(handle);
                    break;
                }
            }
            // Perform the assertion on the current window's URL
            String expectedFacebookUrl = "https://www.facebook.com/seleniumeasy";
            Assert.assertEquals(driver.getCurrentUrl(), expectedFacebookUrl, "Facebook URL assertion failed");

            // Close the new window and switch back to the original window
            driver.close();
            driver.switchTo().window(windowHandles.iterator().next());

            System.out.println("facebookButton Test Passed");
            Thread.sleep(2000);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            tearDown();
        }
    }

    // Method to test following a link and switching windows
    public void multiwindowPage() throws InterruptedException {
        setUp();
        driver.get(url);

        WindowPopupModalDemoPage page = new WindowPopupModalDemoPage(driver);
        page.followLinkAndSwitchWindows(driver);

        tearDown();
        System.out.println("multiwindowPage Test Passed");
        Thread.sleep(2000);
    }

    // Method to test opening multiple windows and switching between them
    public void threeWindowPage() throws InterruptedException {
        setUp();
        driver.get(url);

        WindowPopupModalDemoPage page = new WindowPopupModalDemoPage(driver);
        page.clickFollowAllLink();
        page.switchToWindowByUrl(driver);

        tearDown();
        System.out.println("threeWindowPage Test Passed");
        Thread.sleep(2000);
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
