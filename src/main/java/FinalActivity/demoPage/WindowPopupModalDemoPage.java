package FinalActivity.demoPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

import static org.testng.AssertJUnit.assertEquals;


public class WindowPopupModalDemoPage {

    private WebDriver driver;

    @FindBy(xpath = "//a[normalize-space()='Follow On Twitter']")
    private WebElement twitterLink;

    @FindBy(xpath = "//a[normalize-space()='Like us On Facebook']")
    private WebElement facebookLink;

    @FindBy(xpath = "//a[normalize-space()='Follow Twitter & Facebook']")
    private WebElement followLink;

    @FindBy(xpath = "//a[normalize-space()='Follow All'][1]")
    private WebElement followAllLink;

    public WindowPopupModalDemoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickTwitterLink() {
        twitterLink.click();
    }
    public void clickFacebookLink() {
        facebookLink.click();
    }

    public void followLinkAndSwitchWindows(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement followLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Follow Twitter & Facebook']")));
        followLink.click();

        Set<String> allWindowHandlesBeforeClick = driver.getWindowHandles();
        wait.until(ExpectedConditions.numberOfWindowsToBe(allWindowHandlesBeforeClick.size()));

        for (String handle : driver.getWindowHandles()) {
            if (!allWindowHandlesBeforeClick.contains(handle)) {
                driver.switchTo().window(handle);
                String currentUrl = driver.getCurrentUrl();
                if (currentUrl.equals("https://twitter.com/intent/follow?screen_name=seleniumeasy")) {
                    System.out.println("Twitter tab found and switched to.");
                } else if (currentUrl.equals("https://www.facebook.com/seleniumeasy")) {
                    System.out.println("Facebook tab found and switched to.");
                }
            }
        }
    }

    public void clickFollowAllLink() {
        followAllLink.click();
    }

    // Method to switch to a specific window by its URL
    public void switchToWindowByUrl(WebDriver driver) throws InterruptedException {
        followAllLink.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(4)); //

        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            String currentUrl = driver.getCurrentUrl();
            Thread.sleep(3000);

            // Check if the current URL matches the expected Facebook, Twitter, or Google Plus URL
            if (currentUrl.contains("facebook.com")) {
                // Perform actions on the Facebook tab if needed
                assertEquals("Expected Facebook Title", "Selenium Easy | Hyderabad | Facebook", driver.getTitle());
            } else if (currentUrl.contains("twitter.com")) {
                // Perform actions on the Twitter tab if needed
                assertEquals("Expected Twitter Title", "Selenium Easy (@seleniumeasy) / X", driver.getTitle());
            } else if (currentUrl.contains("https://workspaceupdates.googleblog.com/2023/04/new-community-features-for-google-chat-and-an-update-currents%20.html")) {
                // Perform actions on the Google Plus tab if needed
                assertEquals("Expected Google Plus Title", "Google Workspace Updates: New community features for Google Chat and an update on Currents", driver.getTitle());
            }
        }
    }

}
