package FinalActivity.demoPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckboxDemoPage {

    @FindBy(id = "isAgeSelected")
    private WebElement ageCheckbox;

    @FindBy(id = "txtAge")
    private WebElement ageSuccessMessage;

    public CheckboxDemoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Method to click the age checkbox
    public void clickAgeCheckbox() {
        ageCheckbox.click();
    }

    // Method to wait for the success message to appear and verify its visibility
    // Now takes driver as a parameter
    public boolean isAgeSuccessMessageDisplayed(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtAge")));
        return successMessage.isDisplayed();
    }

    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    private WebElement defaultChecked;

    @FindBy(xpath = "(//input[@type='checkbox'])[3]")
    private WebElement defaultDisabled;

    public boolean isDefaultChecked() {
        return defaultChecked.isSelected();
    }

    public boolean isDefaultDisabled() {
        return!defaultDisabled.isEnabled();
    }

    @FindBy(xpath = "(//input[@id='check1'])")
    private WebElement checkAllButton;

    public void clickCheckAllButton() {
        checkAllButton.click();
    }

    // New method to verify all checkboxes from the 4th to the 8th are checked
    public boolean areAllCheckboxesCheckedFrom4To8(WebDriver driver) {
        for (int i = 4; i <= 7; i++) {
            WebElement checkbox = driver.findElement(By.xpath("(//input[@type='checkbox'])[position()=" + i + "]"));
            if (!checkbox.isSelected()) {
                return false;
            }
        }
        return true;
    }
    public boolean areAllCheckboxesUncheckedFrom4To8(WebDriver driver) {
        for (int i = 4; i < 8; i++) {
            WebElement checkbox = driver.findElement(By.xpath("(//input[@type='checkbox'])[position()=" + i + "]"));
            if (checkbox.isSelected()) {
                return false;
            }
        }
        return true;
    }

    public void clickSpecificCheckbox(int index, WebDriver driver) {
        WebElement checkbox = driver.findElement(By.xpath("(//input[@type='checkbox'])[" + index + "]"));
        checkbox.click();
    }
    public void clickUncheckAllButton() {
        checkAllButton.click();
    }

    // New method to verify the 'Check All' button changes to 'Uncheck All'
    public boolean isCheckAllButtonTextUncheckAll() {
        return checkAllButton.getAttribute("value").equals("Uncheck All");
    }

    public boolean isCheckAllButtonTextCheckAll() {
        return checkAllButton.getAttribute("value").equals("Check All");
    }
}
