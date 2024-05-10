package FinalActivity.demoPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BootstrapAlertMessagesDemoPage {
    @FindBy(xpath = "//button[normalize-space()='Autocloseable success message']")
    private WebElement autoCloseableSuccessButton;

    @FindBy(xpath = "//div[@class='alert alert-success alert-autocloseable-success']")
    private WebElement autoCloseableSuccessAlert;

    private WebDriver driver;

    public BootstrapAlertMessagesDemoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAutoCloseableSuccessButton() {
        autoCloseableSuccessButton.click();
    }

    public String getAutoCloseableSuccessAlertText() {
        return autoCloseableSuccessAlert.getText();
    }

    @FindBy(xpath = "//button[normalize-space()='Normal success message']")
    private WebElement normalSuccessMessageButton;

    @FindBy(xpath = "//div[@class='alert alert-success alert-normal-success']")
    private WebElement normalSuccessMessageAlert;

    @FindBy(xpath = "//button[@type='button'][normalize-space()='×']")
    private WebElement closeButton;

    public void clickNormalSuccessMessageButton() {
        normalSuccessMessageButton.click();
    }

    public String getNormalSuccessMessageAlertText() {
        return normalSuccessMessageAlert.getText().trim();
    }

    public void clickCloseButton() {
        closeButton.click();
    }

    @FindBy(xpath = "//button[normalize-space()='Autocloseable warning message']")
    private WebElement autocloseableWarningButton;

    @FindBy(xpath = "//div[@class='alert alert-warning alert-autocloseable-warning']")
    private WebElement autocloseableWarningAlert;

    public void clickAutocloseableWarningButton() {
        autocloseableWarningButton.click();
    }

    public String getAutocloseableWarningMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.visibilityOf(autocloseableWarningAlert));
        return autocloseableWarningAlert.getText();
    }

    @FindBy(xpath = "//button[normalize-space()='Normal warning message']")
    private WebElement normalWarningButton;

    @FindBy(xpath = "//div[@class='alert alert-warning alert-normal-warning']")
    private WebElement normalWarningAlert;

    @FindBy(xpath = "(//button[@type='button'][normalize-space()='×'])[2]")
    private WebElement closeButton1;

    public void clickNormalWarningButton() {
        normalWarningButton.click();
    }

    public String getNormalWarningAlertMessage() {
        return normalWarningAlert.getText().trim();
    }

    public void clickCloseButton1() {
        closeButton1.click();
    }

    @FindBy(xpath = "//button[normalize-space()='Autocloseable danger message']")
    private WebElement autocloseableDangerButton;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-autocloseable-danger']")
    private WebElement autocloseableDangerAlert;

    public void clickAutocloseableDangerButton() {
        autocloseableDangerButton.click();
    }

    public String getAutocloseableDangerAlertMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.visibilityOf(autocloseableDangerAlert));
        return autocloseableDangerAlert.getText();
    }

    @FindBy(xpath = "//button[normalize-space()='Normal danger message']")
    private WebElement normalDangerMessageButton;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-normal-danger']")
    private WebElement normalDangerMessageAlert;

    @FindBy(xpath = "(//button[@type='button'][normalize-space()='×'])[3]")
    private WebElement closeButton3;

    public void clickNormalDangerMessageButton() {
        normalDangerMessageButton.click();
    }

    public String getNormalDangerMessageAlertText() {
        return normalDangerMessageAlert.getText().trim();
    }

    public void clickCloseButton3() {
        closeButton3.click();
    }

    @FindBy(xpath = "//button[normalize-space()='Autocloseable info message']")
    private WebElement autocloseableInfoMessageButton;

    @FindBy(xpath = "//div[@class='alert alert-info alert-autocloseable-info']")
    private WebElement autocloseableInfoMessageAlert;

    public void clickAutocloseableInfoMessageButton() {
        autocloseableInfoMessageButton.click();
    }

    public String getAutocloseableInfoMessageAlertText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.visibilityOf(autocloseableInfoMessageAlert));
        return autocloseableInfoMessageAlert.getText();
    }

    @FindBy(xpath = "//button[normalize-space()='Normal info message']")
    private WebElement normalInfoMessageButton;

    @FindBy(xpath = "//div[@class='alert alert-info alert-normal-info']")
    private WebElement normalInfoMessageAlert;

    @FindBy(xpath = "(//button[@type='button'][normalize-space()='×'])[4]")
    private WebElement closeButton4;

    public void clickNormalInfoMessageButton() {
        normalInfoMessageButton.click();
    }

    public String getNormalInfoMessageAlertText() {
        return normalInfoMessageAlert.getText().trim();
    }

    public void clickCloseButton4() {
        closeButton4.click();
    }


}
