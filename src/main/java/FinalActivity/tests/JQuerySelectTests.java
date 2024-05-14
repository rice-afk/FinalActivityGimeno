package FinalActivity.tests;

import FinalActivity.Methods.CheckboxDemoMethods;
import FinalActivity.Methods.JQuerySelectDemoMethods;
import FinalActivity.demoPage.JQuerySelectDemoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.io.IOException;
import java.time.Duration;

public class JQuerySelectTests {
    private WebDriver driver;

    @Test
    public void runTestsFromJson() throws IOException {
        JQuerySelectDemoMethods page = new JQuerySelectDemoMethods();
        page.runTestsFromJson();
    }

    @AfterMethod
    public void tearDown() {
        if (driver!= null) {
            driver.quit();
        }
    }
}
