package FinalActivity.demoPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadioButtonDemoPage {
    @FindBy(name = "optradio")
    private WebElement maleRadioButton;

    @FindBy(id = "buttoncheck")
    private WebElement checkButton;
    @FindBy(name = "gender")
    private WebElement genderRadioButton;

    @FindBy(xpath = "//input[@value='15 - 50']")
    private WebElement ageGroupRadioButton;

    @FindBy(css = "button[onclick='getValues();']")
    private WebElement submitButton;

    @FindBy(xpath = "(//p[@class='radiobutton'])[1]")
    private WebElement radioButtonMessage;

    @FindBy(xpath = "//p[@class='groupradiobutton']")
    private WebElement radioButtonMessage1;


    public RadioButtonDemoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Method to click the Male radio button
    public void clickMaleRadioButton() {
        maleRadioButton.click();
    }

    // Method to click the Check button
    public void clickCheckButton() {
        checkButton.click();
    }

    // Method to get the text of the radio button message
    public String getRadioButtonMessageText() {
        return radioButtonMessage.getText();
    }

    public void clickFirstGenderRadioButton() {
        genderRadioButton.click();
    }

    // Method to click the age group radio button
    public void clickAgeGroupRadioButton() {
        ageGroupRadioButton.click();
    }

    // Method to click the Submit button
    public void clickSubmitButton() {
        submitButton.click();
    }
    public String getRadioButtonMessageText1() {
        return radioButtonMessage1.getText();
    }
}
