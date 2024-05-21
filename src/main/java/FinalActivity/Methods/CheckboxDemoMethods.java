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

    // Test method for single checkbox
    public void singleCheckboxDemo() {
        setUp();
        try {
            driver.get(url);
            CheckboxDemoPage page = new CheckboxDemoPage(driver);
            page.clickAgeCheckbox();

            boolean ageSuccessMessageDisplayed = page.isAgeSuccessMessageDisplayed(driver);
            Assert.assertTrue(ageSuccessMessageDisplayed, "Age success message not displayed.");
            System.out.println("Age success message displayed: " + ageSuccessMessageDisplayed);

            boolean defaultChecked = page.isDefaultChecked();
            Assert.assertTrue(defaultChecked, "Default checkbox should be checked.");
            System.out.println("Default checkbox checked: " + defaultChecked);

            boolean defaultDisabled = page.isDefaultDisabled();
            Assert.assertTrue(defaultDisabled, "Default checkbox should be disabled.");
            System.out.println("Default checkbox disabled: " + defaultDisabled);
        } catch (Exception e) {
            System.err.println("Error occurred: " + e.getMessage());
        } finally {
            tearDown();
        }
    }
    // Test method for multiple checkboxes
    public void multipleCheckboxDemo(){
        setUp();
        try {
            driver.get(url);
            CheckboxDemoPage page = new CheckboxDemoPage(driver);
            page.clickCheckAllButton();

            boolean allCheckboxesChecked = page.areAllCheckboxesCheckedFrom4To8(driver);
            Assert.assertTrue(allCheckboxesChecked, "All checkboxes from the 4th to the 8th should be checked.");
            System.out.println("All checkboxes from the 4th to the 8th checked: " + allCheckboxesChecked);

            boolean isCheckAllButtonUncheckAll = page.isCheckAllButtonTextUncheckAll();
            Assert.assertTrue(isCheckAllButtonUncheckAll, "Check All button should display 'Uncheck All'.");
            System.out.println("Check All button displays 'Uncheck All': " + isCheckAllButtonUncheckAll);

            page.clickSpecificCheckbox(4, driver);

            boolean isCheckAllButtonCheckAll = page.isCheckAllButtonTextCheckAll();
            Assert.assertTrue(isCheckAllButtonCheckAll, "Check All button should display 'Check All'.");
            System.out.println("Check All button displays 'Check All': " + isCheckAllButtonCheckAll);

            page.clickCheckAllButton();
            page.clickCheckAllButton();

            boolean allCheckboxesUnchecked = page.areAllCheckboxesUncheckedFrom4To8(driver);
            Assert.assertTrue(allCheckboxesUnchecked, "All checkboxes from the 4th to the 8th should be unchecked.");
            System.out.println("All checkboxes from the 4th to the 8th unchecked: " + allCheckboxesUnchecked);

            Assert.assertTrue(isCheckAllButtonCheckAll, "Check All button should display 'Check All'.");
            System.out.println("Check All button still displays 'Check All': " + isCheckAllButtonCheckAll);
        } catch (Exception e) {
            System.err.println("Error occurred: " + e.getMessage());
        } finally {
            tearDown();
        }
    }

    // Setup method to initialize WebDriver and set implicit wait time
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    // Teardown method to quit the WebDriver session
    public void tearDown() {
        if (driver!= null) {
            driver.quit();
        }
    }
}
