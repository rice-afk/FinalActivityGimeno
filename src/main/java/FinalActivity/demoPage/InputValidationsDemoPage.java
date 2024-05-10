package FinalActivity.demoPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InputValidationsDemoPage {
    @FindBy(css = "input[placeholder='First Name']")
    private WebElement firstNameInput;

    @FindBy(css = "input[placeholder='Last Name']")
    private WebElement lastNameInput;

    @FindBy(css = "input[placeholder='E-Mail Address']")
    private WebElement emailInput;

    @FindBy(css = "input[placeholder='(845)555-1212']")
    private WebElement phoneInput;

    @FindBy(css = "input[placeholder='Address']")
    private WebElement addressInput;

    @FindBy(css = "input[placeholder='city']")
    private WebElement cityInput;

    @FindBy(name = "state")
    private WebElement stateDropdown;

    @FindBy(css = "input[placeholder='Zip Code']")
    private WebElement zipCodeInput;

    @FindBy(css = "textarea[placeholder='Project Description']")
    private WebElement projectDescriptionInput;

    @FindBy(xpath = "//button[normalize-space()='Send']")
    private WebElement sendButton;

    public InputValidationsDemoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Methods to fill out the form
    public void fillFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void fillLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void fillEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void fillPhone(String phone) {
        phoneInput.sendKeys(phone);
    }

    public void fillAddress(String address) {
        addressInput.sendKeys(address);
    }

    public void fillCity(String city) {
        cityInput.sendKeys(city);
    }

    public void selectState(String state) {
        Select select = new Select(stateDropdown);
        stateDropdown.click();
        select.selectByVisibleText(state);
    }

    public void fillZipCode(String zipCode) {
        zipCodeInput.sendKeys(zipCode);
    }

    public void fillProjectDescription(String description) {
        projectDescriptionInput.sendKeys(description);
    }

    public void clickSendButton() {
        sendButton.click();
    }
}
