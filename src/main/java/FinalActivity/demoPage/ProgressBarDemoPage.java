package FinalActivity.demoPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProgressBarDemoPage {
    @FindBy(xpath = "//div[@class='prog-circle']")
    private WebElement progressBar;

    @FindBy(xpath = "//div[@class='percenttext']")
    private WebElement progressText;

    private WebDriver driver;

    public ProgressBarDemoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkInitialProgress() {
        String progressTextValue = progressText.getText();
        Assert.assertEquals("0%", progressTextValue, "Initial progress is not 0%");
    }

    public void clickDownloadButton() {
        driver.findElement(By.id("cricle-btn")).click();
    }

    public void waitForProgressToComplete() throws InterruptedException {
        Thread.sleep(25000); // Adjust the sleep time based on your network speed
    }

    public void checkFinalProgress() {
        String progressTextValue = progressText.getText();
        Assert.assertEquals("100%", progressTextValue, "Final progress is not 100%");
        System.out.println("Progress Bar Percentage: " + progressTextValue);
    }
}
