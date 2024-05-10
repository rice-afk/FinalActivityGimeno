package FinalActivity.Methods;

import FinalActivity.demoPage.DatePickerDemoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DatePickerDemoMethods {
    private WebDriver driver;
    String url = "https://demo.seleniumeasy.com/bootstrap-date-picker-demo.html";

    public void datePicker() {
        setUp();
        driver.get(url);

        DatePickerDemoPage page = new DatePickerDemoPage(driver);
        page.selectToday(driver);
        String selectedDate = driver.findElement(By.xpath("//input[@placeholder='dd/mm/yyyy']")).getAttribute("value");
        LocalDate selectedLocalDate = LocalDate.parse(selectedDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate today = LocalDate.now();
        Assert.assertEquals(selectedLocalDate, today, "The selected date is not today");

        page.clearDatePicker(driver);
        Assert.assertTrue(driver.findElement(By.xpath("//input[@placeholder='dd/mm/yyyy']")).getAttribute("value").isEmpty(), "The date picker is not empty after clearing");
        tearDown();
    }

    public void testDateRangePickerDemo() {
        setUp();
        driver.get(url);

        DatePickerDemoPage page = new DatePickerDemoPage(driver);
        LocalDate startDate = LocalDate.of(2023, 5, 1);
        LocalDate endDate = LocalDate.of(2023, 5, 31);
        page.selectDateRange(startDate, endDate, driver);
        Assert.assertTrue(page.validateDateRange(), "Start date is not less than end date.");

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
