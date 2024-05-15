package FinalActivity.tests;

import FinalActivity.Methods.BootStrapAlertMessagesDemoMethods;
import FinalActivity.Methods.BootstrapModalMethods;
import FinalActivity.Methods.CheckboxDemoMethods;
import FinalActivity.demoPage.BootstrapModalDemoPage;
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

public class BootstrapModalTests {
    private WebDriver driver;

    @Test
    public void testBootstrapModalDemo() {
        BootstrapModalMethods page = new BootstrapModalMethods();
        page.testBootstrapModalDemo();
    }
    @Test
    public void testBootstrapModal1Demo() {
        BootstrapModalMethods page = new BootstrapModalMethods();
        page.testBootstrapModal1Demo();
    }
    @AfterMethod
    public void tearDown() {
        if (driver!= null) {
            driver.quit();
        }
    }
}
