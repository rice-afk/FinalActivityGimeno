package FinalActivity.demoPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AjaxFormSubmitDemoPage {
    @FindBy(id = "title")
    private WebElement nameInput;

    @FindBy(id = "description")
    private WebElement commentInput;

    @FindBy(id = "btn-submit")
    private WebElement submitButton;

    @FindBy(id = "submit-control")
    private WebElement submitControl;

    public AjaxFormSubmitDemoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Method to fill out the form
    public void fillForm(String name, String comment) {
        nameInput.sendKeys(name);
        commentInput.sendKeys(comment);
    }

    // Method to submit the form
    public void submitForm() {
        submitButton.click();
    }

    // Method to wait for the success message to appear
    public void waitForSuccessMessageVisibiity(WebDriver driver) {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit-control")));
    }

    public String printInitialMessage(WebDriver driver){
        WebElement submitControl = driver.findElement(By.id("submit-control"));
        String initialMessage = submitControl.getText();
        return initialMessage;
    }

    public void waitForSuccessMessage(WebDriver driver) {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.textToBe(By.id("submit-control"), "Form submited Successfully!"));
    }

    public String printFinalMessage(){
        String successMessage = submitControl.getText();
        return successMessage;

    }




}
