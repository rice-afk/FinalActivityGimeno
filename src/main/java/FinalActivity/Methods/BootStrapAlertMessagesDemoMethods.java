package FinalActivity.Methods;

import FinalActivity.demoPage.BootstrapAlertMessagesDemoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class BootStrapAlertMessagesDemoMethods {
    private WebDriver driver;
    String url = "https://demo.seleniumeasy.com/bootstrap-alert-messages-demo.html";

    public void autoCloseableSuccessButton() {
        setUp();
        driver.get(url);

        BootstrapAlertMessagesDemoPage page = new BootstrapAlertMessagesDemoPage(driver);
        page.clickAutoCloseableSuccessButton();
        Assert.assertEquals("I'm an autocloseable success message. I will hide in 5 seconds.", page.getAutoCloseableSuccessAlertText());

        tearDown();
    }

    public void normalSuccessMessageButton() {
        setUp();
        driver.get(url);

        BootstrapAlertMessagesDemoPage page = new BootstrapAlertMessagesDemoPage(driver);
        page.clickNormalSuccessMessageButton();
        Assert.assertEquals("×\nI'm a normal success message. To close use the appropriate button.", page.getNormalSuccessMessageAlertText());
        page.clickCloseButton();

        tearDown();
    }

    public void autocloseableWarningButton() {
        setUp();
        driver.get(url);

        BootstrapAlertMessagesDemoPage page = new BootstrapAlertMessagesDemoPage(driver);
        page.clickAutocloseableWarningButton();
        Assert.assertEquals("I'm an autocloseable warning message. I will hide in 3 seconds.", page.getAutocloseableWarningMessage());

       tearDown();
    }

    public void normalWarningButton() {
        setUp();
        driver.get(url);

        BootstrapAlertMessagesDemoPage page = new BootstrapAlertMessagesDemoPage(driver);
        page.clickNormalWarningButton();
        Assert.assertEquals("×\nI'm a normal warning message. To close use the appropriate button.",  page.getNormalWarningAlertMessage());
        page.clickCloseButton1();

        tearDown();
    }

    public void autocloseableDangerButton() {
        setUp();
        driver.get(url);

        BootstrapAlertMessagesDemoPage page = new BootstrapAlertMessagesDemoPage(driver);
        page.clickAutocloseableDangerButton();
        Assert.assertEquals("I'm an autocloseable danger message. I will hide in 5 seconds.", page.getAutocloseableDangerAlertMessage());

        tearDown();
    }

    public void normalDangerButton() {
        setUp();
        driver.get(url);

        BootstrapAlertMessagesDemoPage page = new BootstrapAlertMessagesDemoPage(driver);
        page.clickNormalDangerMessageButton();
        Assert.assertEquals("×\nI'm a normal danger message. To close use the appropriate button.", page.getNormalDangerMessageAlertText());
        page.clickCloseButton3();

        tearDown();
    }

    public void autocloseableInfoButton() {
        setUp();
        driver.get(url);

        BootstrapAlertMessagesDemoPage page = new BootstrapAlertMessagesDemoPage(driver);
        page.clickAutocloseableInfoMessageButton();
        Assert.assertEquals("I'm an autocloseable info message. I will hide in 6 seconds.", page.getAutocloseableInfoMessageAlertText());

        tearDown();
    }

    public void normalInfoButton() {
        setUp();
        driver.get(url);

        BootstrapAlertMessagesDemoPage page = new BootstrapAlertMessagesDemoPage(driver);
        page.clickNormalInfoMessageButton();
        Assert.assertEquals("×\nI'm a normal info message. To close use the appropriate button.", page.getNormalInfoMessageAlertText());
        page.clickCloseButton4();

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
