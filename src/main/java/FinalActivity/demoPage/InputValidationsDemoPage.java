package FinalActivity.demoPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InputValidationsDemoPage {
    @FindBy(
            css = "input[placeholder='First Name']"
    )
    private WebElement firstNameInput;
    @FindBy(
            css = "input[placeholder='Last Name']"
    )
    private WebElement lastNameInput;
    @FindBy(
            css = "input[placeholder='E-Mail Address']"
    )
    private WebElement emailInput;
    @FindBy(
            css = "input[placeholder='(845)555-1212']"
    )
    private WebElement phoneInput;
    @FindBy(
            css = "input[placeholder='Address']"
    )
    private WebElement addressInput;
    @FindBy(
            css = "input[placeholder='city']"
    )
    private WebElement cityInput;
    @FindBy(
            name = "state"
    )
    private WebElement stateDropdown;
    @FindBy(
            css = "input[placeholder='Zip Code']"
    )
    private WebElement zipCodeInput;
    @FindBy(
            css = "textarea[placeholder='Project Description']"
    )
    private WebElement projectDescriptionInput;
    @FindBy(
            xpath = "//button[normalize-space()='Send']"
    )
    private WebElement sendButton;

    public InputValidationsDemoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fillFirstName(String firstName) {
        this.firstNameInput.sendKeys(new CharSequence[]{firstName});
    }

    public void fillLastName(String lastName) {
        this.lastNameInput.sendKeys(new CharSequence[]{lastName});
    }

    public void fillEmail(String email) {
        this.emailInput.sendKeys(new CharSequence[]{email});
    }

    public void fillPhone(String phone) {
        this.phoneInput.sendKeys(new CharSequence[]{phone});
    }

    public void fillAddress(String address) {
        this.addressInput.sendKeys(new CharSequence[]{address});
    }

    public void fillCity(String city) {
        this.cityInput.sendKeys(new CharSequence[]{city});
    }

    public void selectState(String state) {
        Select select = new Select(this.stateDropdown);
        this.stateDropdown.click();
        select.selectByVisibleText(state);
    }

    public void fillZipCode(String zipCode) {
        this.zipCodeInput.sendKeys(new CharSequence[]{zipCode});
    }

    public void fillProjectDescription(String description) {
        this.projectDescriptionInput.sendKeys(new CharSequence[]{description});
    }

    public void clickSendButton() {
        this.sendButton.click();
    }
}
