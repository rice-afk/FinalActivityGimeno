package FinalActivity.demoPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SimpleFormDemoPage {
    @FindBy(xpath = "//input[@id='user-message']")
    private WebElement userMessageInput;

    @FindBy(xpath = "//button[normalize-space()='Show Message']")
    private WebElement showMessageButton;

    @FindBy(xpath = "//span[@id='display']")
    private WebElement messageLabel;

    @FindBy(id = "display")
    private WebElement displayMessage;

    @FindBy(xpath = "//input[@id='value1']")
    private WebElement value1Input;

    @FindBy(xpath = "//input[@id='value2']")
    private WebElement value2Input;

    @FindBy(xpath = "//button[normalize-space()='Get Total']")
    private WebElement getTotalButton;

    @FindBy(xpath = "//span[@id='displayvalue']")
    private WebElement displayResult;

    public SimpleFormDemoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Methods to interact with the page
    public void enterUserMessage(String message) {
        userMessageInput.sendKeys(message);
        showMessageButton.click();
    }

    public String getMessage() {
        return messageLabel.getText();
    }

    public void enterValues(int value1, int value2) {
        value1Input.sendKeys(Integer.toString(value1));
        value2Input.sendKeys(Integer.toString(value2));
        getTotalButton.click();
    }
    // Method to clear values
    public void clearValues() {
        value1Input.clear();
        value2Input.clear();
    }
    // Method to get results
    public String getResult() {
        return displayResult.getText();
    }
}
