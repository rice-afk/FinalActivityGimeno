package FinalActivity.tests;

import FinalActivity.Methods.CheckboxDemoMethods;
import FinalActivity.Methods.ProgressBarDemoMethods;
import FinalActivity.demoPage.ProgressBarDemoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProgressBarDemoTests {

    private WebDriver driver;

    @Test
    public void testProgressBarDemo() {
        ProgressBarDemoMethods page = new ProgressBarDemoMethods();
        page.testProgressBarDemo();
    }

    @AfterMethod
    public void tearDown() {
        if (driver!= null) {
            driver.quit();
        }
    }


}

