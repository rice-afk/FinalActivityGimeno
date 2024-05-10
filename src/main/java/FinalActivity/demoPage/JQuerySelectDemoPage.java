package FinalActivity.demoPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class JQuerySelectDemoPage {
    @FindBy(xpath = "(//span[@role='combobox'])[1]")
    private WebElement countryDropdown;

    @FindBy(xpath = "(//input[@role='textbox'])[2]")
    private WebElement countrySearchBox;

    @FindBy(xpath = "//li[normalize-space()='Australia']")
    private WebElement australiaOption;

    @FindBy(id = "select2-country-container")
    private WebElement countryContainer;

    public JQuerySelectDemoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Method to select a country by typing in the search box
    public void selectCountryBySearch(String countryName) {
        countryDropdown.click();
        countrySearchBox.sendKeys(countryName);
        australiaOption.click();
    }

    // Method to get the selected country
    public String getSelectedCountry() {
        return countryContainer.getText();
    }

    public void multiplevalues(WebDriver driver){
        try {
            WebElement inputField = driver.findElement(By.xpath("//input[@placeholder='Select state(s)']"));

            // Type the state names
            String[] states = {"Alabama", "Alaska", "Arizona"};
            for (String state : states) {
                inputField.sendKeys(state + Keys.ENTER);
            }
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='select2-selection select2-selection--multiple']")));

            List<WebElement> selectedItems = driver.findElements(By.xpath("//span[@class='select2-selection select2-selection--multiple']"));
            List<String> expectedStates = Arrays.asList("×Alabama", "×Alaska", "×Arizona");
            for (int i = 0; i < expectedStates.size(); i++) {
                assertEquals(expectedStates.get(i).trim(), selectedItems.get(i).getText().trim(),expectedStates+"\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
    public void selectDisabledValueFromDropdown(String valueToSelect, WebDriver driver) {
        WebElement dropdown = driver.findElement(By.xpath("(//span[@class='selection'])[3]"));
        dropdown.click();

        // Wait for the search field to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='select2-search select2-search--dropdown']//input[@role='textbox']")));

        // Type in the search field
        searchField.sendKeys(valueToSelect);
        searchField.sendKeys(Keys.ENTER);
    }

    public void selectCategoryOption(String optionToSelect, WebDriver driver) {
        // Find the dropdown element by its ID
        WebElement dropdown = driver.findElement(By.id("files"));

        // Find the option element by its text
        WebElement option = driver.findElement(By.xpath("//option[normalize-space()='" + optionToSelect + "']"));
        option.click();

        // Create a Select object for the dropdown
        Select select = new Select(dropdown);

        // Retrieve the selected option's text
        String selectedOptionText = select.getFirstSelectedOption().getText();

        // Define the expected value
        String expectedValue = optionToSelect;

        assertEquals(selectedOptionText, expectedValue, optionToSelect);
    }

}
