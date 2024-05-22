package FinalActivity.tests;

import FinalActivity.Methods.CheckboxDemoMethods;
import FinalActivity.Methods.DualListBoxDemoMethods;
import FinalActivity.demoPage.DualListBoxDemoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class DualListBoxDemoTests {

    private WebDriver driver;

   @Test
    public void searchAndMoveItem() {
       DualListBoxDemoMethods page = new DualListBoxDemoMethods();
       page.searchAndMoveItem();
    }

   @Test
    public void selectAllMovetoRight() {
       DualListBoxDemoMethods page = new DualListBoxDemoMethods();
       page.selectAllMovetoRight();
    }

    @Test
    public void MovetoRightandLeft() throws InterruptedException {
        DualListBoxDemoMethods page = new DualListBoxDemoMethods();
        page.MovetoRightandLeft();
    }

    @AfterMethod
    public void tearDown() {
        if (driver!= null) {
            driver.quit();
        }
    }

}
