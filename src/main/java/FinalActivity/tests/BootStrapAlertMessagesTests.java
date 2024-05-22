package FinalActivity.tests;

import FinalActivity.Methods.BootStrapAlertMessagesDemoMethods;
import FinalActivity.Methods.CheckboxDemoMethods;
import FinalActivity.demoPage.BootstrapAlertMessagesDemoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BootStrapAlertMessagesTests {

    private WebDriver driver;

    @Test
    public void autoCloseableSuccessButton() {
        BootStrapAlertMessagesDemoMethods page = new BootStrapAlertMessagesDemoMethods();
        page.autoCloseableSuccessButton();
    }

    @Test
    public void normalSuccessMessageButton() throws InterruptedException {
        BootStrapAlertMessagesDemoMethods page = new BootStrapAlertMessagesDemoMethods();
        page.normalSuccessMessageButton();
    }

    @Test
    public void autocloseableWarningButton() {
        BootStrapAlertMessagesDemoMethods page = new BootStrapAlertMessagesDemoMethods();
        page.autocloseableWarningButton();
    }

    @Test
    public void normalWarningButton() throws InterruptedException {
        BootStrapAlertMessagesDemoMethods page = new BootStrapAlertMessagesDemoMethods();
        page.normalWarningButton();
    }

    @Test
    public void autocloseableDangerButton() {
        BootStrapAlertMessagesDemoMethods page = new BootStrapAlertMessagesDemoMethods();
        page.autocloseableDangerButton();
    }

    @Test
    public void normalDangerButton() throws InterruptedException {
        BootStrapAlertMessagesDemoMethods page = new BootStrapAlertMessagesDemoMethods();
        page.normalDangerButton();
    }

    @Test
    public void autocloseableInfoButton() {
        BootStrapAlertMessagesDemoMethods page = new BootStrapAlertMessagesDemoMethods();
        page.autocloseableInfoButton();
    }

    @Test
    public void normalInfoButton() throws InterruptedException {
        BootStrapAlertMessagesDemoMethods page = new BootStrapAlertMessagesDemoMethods();
        page.normalInfoButton();
    }

    @AfterMethod
    public void tearDown() {
        if (driver!= null) {
            driver.quit();
        }
    }

}
