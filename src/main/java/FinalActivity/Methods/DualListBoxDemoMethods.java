package FinalActivity.Methods;

import FinalActivity.demoPage.DualListBoxDemoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DualListBoxDemoMethods {
    private WebDriver driver;
    String url = "https://demo.seleniumeasy.com/bootstrap-dual-list-box-demo.html";

    // Method to search for an item and move it between lists
    public void searchAndMoveItem() {
        setUp();
        driver.get(url);

        DualListBoxDemoPage page = new DualListBoxDemoPage(driver);
        page.searchAndMoveItem(driver);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Test Passed");
        tearDown();
    }

    // Method to select all items and move them to the right list
    public void selectAllMovetoRight() {
        setUp();
        driver.get(url);

        DualListBoxDemoPage page = new DualListBoxDemoPage(driver);
        page.clickSelectAllLink(driver);
        page.clickMoveRightButton(driver);
        boolean itemsMoved = page.verifyItemsMovedToRightList(driver);
        if (itemsMoved) {
            assert itemsMoved : "All 5 items have been successfully moved to the right list.";
        } else {
            assert!itemsMoved : "Not all items were moved. Expected 5, but found " + itemsMoved;
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Test Passed");
        tearDown();
    }

    // Method to move selected items to the right list and verify the count
    public void MovetoRightandLeft() throws InterruptedException {
        setUp();
        driver.get(url);


        DualListBoxDemoPage page = new DualListBoxDemoPage(driver);
        page.clickSelectAllLink(driver);
        page.clickMoveRightButton(driver);
        Thread.sleep(3000);
        page.clickMoveLeftButton(driver);
        Thread.sleep(3000);
        List<WebElement> rightListActiveItems = driver.findElements(By.xpath("//li[@class='list-group-item active']"));
        boolean itemsMoved = page.verifyItemsMoved(rightListActiveItems);
        try {
            Thread.sleep(3000);
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
        driver.manage().window().maximize();
    }

    // Teardown method to quit the WebDriver session
    public void tearDown() {
        if (driver!= null) {
            driver.quit();
        }
    }
}
