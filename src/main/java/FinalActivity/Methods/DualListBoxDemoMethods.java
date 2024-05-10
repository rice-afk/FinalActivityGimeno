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

    public void searchAndMoveItem() {
        setUp();
        driver.get(url);

        DualListBoxDemoPage page = new DualListBoxDemoPage(driver);
        page.searchAndMoveItem(driver);

        tearDown();
    }

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

        tearDown();
    }
    public void MovetoRightandLeft() {
        setUp();
        driver.get(url);


        DualListBoxDemoPage page = new DualListBoxDemoPage(driver);
        page.clickSelectAllLink(driver);
        page.clickMoveRightButton(driver);
        List<WebElement> rightListActiveItems = driver.findElements(By.xpath("//li[@class='list-group-item active']"));
        boolean itemsMoved = page.verifyItemsMoved(rightListActiveItems);

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
