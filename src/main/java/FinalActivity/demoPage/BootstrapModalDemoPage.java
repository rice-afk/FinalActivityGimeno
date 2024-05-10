package FinalActivity.demoPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BootstrapModalDemoPage {
    @FindBy(xpath = "(//a[@class='btn btn-primary'][normalize-space()='Save changes'])[2]")
    private WebElement saveChangesButton;

    @FindBy(xpath = "(//a[@class='btn'][normalize-space()='Close'])[2]")
    private WebElement closeButton;

    @FindBy(xpath = "(//button[@type='button'][normalize-space()='×'])[2]")
    private WebElement closeIconButton;

    @FindBy(xpath = "(//button[@type='button'][normalize-space()='×'])[3]")
    private WebElement closeIconButton2;

    @FindBy(xpath = "(//a[@class='btn'][normalize-space()='Close'])[3]")
    private WebElement closeButton2;

    @FindBy(xpath = "(//a[@class='btn btn-primary'][normalize-space()='Save changes'])[3]")
    private WebElement saveChangesButton2;

    public BootstrapModalDemoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public static void closeModal(WebDriver driver, By closeButton) {
        WebElement closeBtn = driver.findElement(closeButton);
        closeBtn.click();
    }

    private static void launchAndVerifyModal(WebDriver driver) {
        // Click the button to launch the modal
        WebElement launchModalButton = driver.findElement(By.xpath("//a[@class='btn btn-primary'][normalize-space()='Launch modal']"));
        launchModalButton.click();

        // Wait for the modal to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("myModal0")));

        // Verify the modal title and body text
        WebElement modalTitle = driver.findElement(By.xpath("//h4[normalize-space()='Modal Title']"));
        WebElement modalBody = driver.findElement(By.xpath("//div[@class='modal-body'][contains(text(),'This is the place where the content for the modal')]"));

        // Assert modal title and body text
        assert modalTitle.getText().equals("Modal Title");
        assert modalBody.getText().contains("This is the place where the content for the modal");
    }
    public static void launchAndVerifyModal1(WebDriver driver) {
        // Click the button to launch the modal
        WebElement launchModalButton = driver.findElement(By.xpath("(//a[@href='#myModal'])[1]"));
        launchModalButton.click();

        // Wait for the modal to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='modal-content'])[2]")));

        // Verify the modal title and body text
        WebElement modalTitle = driver.findElement(By.xpath("(//h4[normalize-space()='First Modal'])[1]"));
        WebElement modalBody = driver.findElement(By.xpath("(//div[@class='modal-body'][contains(text(),'This is the place where the content for the modal ')])[2]"));

        // Assert modal title and body text
        assert modalTitle.getText().equals("First Modal");
        assert modalBody.getText().contains("This is the place where the content for the modal dialog displays.");
    }
    public static void launchAndVerifyModal2(WebDriver driver) {
        // Click the button to launch the modal
        WebElement launchModalButton = driver.findElement(By.xpath("(//a[@class='btn btn-primary'][normalize-space()='Launch modal'])[3]"));
        launchModalButton.click();

        // Wait for the modal to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='myModal2']//div[@class='modal-content']")));

        // Verify the modal title and body text
        WebElement modalTitle = driver.findElement(By.xpath("(//h4[normalize-space()='Modal 2'])[1]"));
        WebElement modalBody = driver.findElement(By.xpath("(//div[@class='modal-body'][contains(text(),'This is the place where the content for the modal ')])[3]"));

        // Assert modal title and body text
        assert modalTitle.getText().equals("Modal 2");
        assert modalBody.getText().contains("This is the place where the content for the modal");
    }
}
