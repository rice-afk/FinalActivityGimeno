package FinalActivity.tests;

import FinalActivity.Methods.CheckboxDemoMethods;
import FinalActivity.Methods.DatePickerDemoMethods;
import FinalActivity.demoPage.DatePickerDemoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DatePickerTests {
    private WebDriver driver;
    @Test
    public void datePicker() {
        DatePickerDemoMethods page = new DatePickerDemoMethods();
        page.datePicker();
    }

    @Test
    public void testDateRangePickerDemo() {
        DatePickerDemoMethods page = new DatePickerDemoMethods();
        page.testDateRangePickerDemo();
    }

    @AfterMethod
    public void tearDown() {
        if (driver!= null) {
            driver.quit();
        }
    }
}
