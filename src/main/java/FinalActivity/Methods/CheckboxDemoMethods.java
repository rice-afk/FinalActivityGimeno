package FinalActivity.Methods;

import FinalActivity.demoPage.CheckboxDemoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class CheckboxDemoMethods {
    private WebDriver driver;
    String url = "https://demo.seleniumeasy.com/basic-checkbox-demo.html";
    public void singleCheckboxDemo() {
        setUp();
        driver.get(url);
        CheckboxDemoPage page = new CheckboxDemoPage(driver);
        page.clickAgeCheckbox();

        Assert.assertTrue(page.isAgeSuccessMessageDisplayed(driver), "Age success message not displayed.");
        Assert.assertTrue(page.isDefaultChecked(), "Default checkbox should be checked.");
        Assert.assertTrue(page.isDefaultDisabled(), "Default checkbox should be disabled.");

        tearDown();
    }
    public void multipleCheckboxDemo(){
        setUp();
        driver.get(url);
        CheckboxDemoPage page = new CheckboxDemoPage(driver);
        page.clickCheckAllButton();

        boolean allCheckboxesChecked = page.areAllCheckboxesCheckedFrom4To8(driver);
        Assert.assertTrue(allCheckboxesChecked, "All checkboxes from the 4th to the 8th should be checked.");

        boolean isCheckAllButtonUncheckAll = page.isCheckAllButtonTextUncheckAll();
        Assert.assertTrue(isCheckAllButtonUncheckAll, "Check All button should display 'Uncheck All'.");

        page.clickSpecificCheckbox(4, driver);

        boolean isCheckAllButtonCheckAll = page.isCheckAllButtonTextCheckAll();
        Assert.assertTrue(isCheckAllButtonCheckAll, "Check All button should display 'Check All'.");

        page.clickCheckAllButton();
        page.clickCheckAllButton();

        boolean allCheckboxesUnchecked = page.areAllCheckboxesUncheckedFrom4To8(driver);
        Assert.assertTrue(allCheckboxesUnchecked, "All checkboxes from the 4th to the 8th should be unchecked.");
        Assert.assertTrue(isCheckAllButtonCheckAll, "Check All button should display 'Check All'.");

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
