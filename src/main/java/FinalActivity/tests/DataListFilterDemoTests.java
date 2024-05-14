package FinalActivity.tests;

import FinalActivity.Methods.CheckboxDemoMethods;
import FinalActivity.Methods.DataListFilterDemoMethods;
import FinalActivity.demoPage.DataListFilterDemoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class DataListFilterDemoTests {
    @Test
    public void testSearchAndVerifyName() throws IOException {
        DataListFilterDemoMethods page = new DataListFilterDemoMethods();
        page.testSearchAndVerifyNames();
    }

    @AfterMethod
    public void tearDown() {
        DataListFilterDemoMethods page = new DataListFilterDemoMethods();
        page.tearDown();
    }
}