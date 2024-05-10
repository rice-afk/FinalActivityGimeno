package FinalActivity.demoPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DatePickerDemoPage {
    @FindBy(xpath = "//div[@class='input-group date']//span[@class='input-group-addon']")
    private WebElement datePickerInput;

    @FindBy(xpath = "(//th[@class='today'][normalize-space()='Today'])[1]")
    private WebElement todayButton;

    @FindBy(xpath = "(//th[@class='clear'][normalize-space()='Clear'])[1]")
    private WebElement clearButton;

    public DatePickerDemoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Method to select today's date
    public void selectToday(WebDriver driver) {
        datePickerInput.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        todayButton.click();
        wait.until(ExpectedConditions.attributeToBe(By.xpath("//input[@placeholder='dd/mm/yyyy']"), "value", LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
    }

    // Method to clear the date picker
    public void clearDatePicker(WebDriver driver) {
        datePickerInput.click();
        clearButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBe(By.xpath("//input[@placeholder='dd/mm/yyyy']"), "value", ""));
    }

    @FindBy(xpath = "//input[@placeholder='Start date']")
    private WebElement startDateInput;

    @FindBy(xpath = "//input[@placeholder='End date']")
    private WebElement endDateInput;

    public void selectDateRange(LocalDate startDate, LocalDate endDate, WebDriver driver) {
        startDateInput.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@class='day'][normalize-space()='" + startDate.getDayOfMonth() + "']")));
        driver.findElement(By.xpath("//td[@class='day'][normalize-space()='" + startDate.getDayOfMonth() + "']")).click();
        startDateInput.click();
        endDateInput.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@class='day'][normalize-space()='" + endDate.getDayOfMonth() + "']")));
        driver.findElement(By.xpath("//td[@class='day'][normalize-space()='" + endDate.getDayOfMonth() + "']")).click();
        endDateInput.click();
    }

    // Method to validate the date range
    public boolean validateDateRange() {
        String startDateValue = startDateInput.getAttribute("value");
        String endDateValue = endDateInput.getAttribute("value");
        LocalDate startDateLocal = LocalDate.parse(startDateValue, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate endDateLocal = LocalDate.parse(endDateValue, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return startDateLocal.isBefore(endDateLocal);
    }
}
