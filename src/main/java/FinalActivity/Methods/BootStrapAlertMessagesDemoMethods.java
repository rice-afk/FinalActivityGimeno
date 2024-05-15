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

    // Test method for auto-closeable success button
    public void autoCloseableSuccessButton() {
        setUp();
        driver.get(url);

        BootstrapAlertMessagesDemoPage page = new BootstrapAlertMessagesDemoPage(driver);
        page.clickAutoCloseableSuccessButton();
        Assert.assertEquals("I'm an autocloseable success message. I will hide in 5 seconds.", page.getAutoCloseableSuccessAlertText());
        System.out.println("Test Passed");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        tearDown();
    }
    // Test method for normal success button
    public void normalSuccessMessageButton() {
        setUp();
        driver.get(url);

        BootstrapAlertMessagesDemoPage page = new BootstrapAlertMessagesDemoPage(driver);
        page.clickNormalSuccessMessageButton();
        Assert.assertEquals("×\nI'm a normal success message. To close use the appropriate button.", page.getNormalSuccessMessageAlertText());
        page.clickCloseButton();
        System.out.println("Test Passed");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        tearDown();
    }

    // Test method for auto-closable warning button
    public void autocloseableWarningButton() {
        setUp();
        driver.get(url);

        BootstrapAlertMessagesDemoPage page = new BootstrapAlertMessagesDemoPage(driver);
        page.clickAutocloseableWarningButton();
        Assert.assertEquals("I'm an autocloseable warning message. I will hide in 3 seconds.", page.getAutocloseableWarningMessage());
        System.out.println("Test Passed");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       tearDown();
    }

    // Test method for normal warning button
    public void normalWarningButton() {
        setUp();
        driver.get(url);

        BootstrapAlertMessagesDemoPage page = new BootstrapAlertMessagesDemoPage(driver);
        page.clickNormalWarningButton();
        Assert.assertEquals("×\nI'm a normal warning message. To close use the appropriate button.",  page.getNormalWarningAlertMessage());
        page.clickCloseButton1();
        System.out.println("Test Passed");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        tearDown();
    }

    // Test method for auto-closeable danger button
    public void autocloseableDangerButton() {
        setUp();
        driver.get(url);

        BootstrapAlertMessagesDemoPage page = new BootstrapAlertMessagesDemoPage(driver);
        page.clickAutocloseableDangerButton();
        Assert.assertEquals("I'm an autocloseable danger message. I will hide in 5 seconds.", page.getAutocloseableDangerAlertMessage());
        System.out.println("Test Passed");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        tearDown();
    }

    // Test method for normal danger button
    public void normalDangerButton() {
        setUp();
        driver.get(url);

        BootstrapAlertMessagesDemoPage page = new BootstrapAlertMessagesDemoPage(driver);
        page.clickNormalDangerMessageButton();
        Assert.assertEquals("×\nI'm a normal danger message. To close use the appropriate button.", page.getNormalDangerMessageAlertText());
        page.clickCloseButton3();
        System.out.println("Test Passed");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        tearDown();
    }

    // Test method for auto-closeable information button
    public void autocloseableInfoButton() {
        setUp();
        driver.get(url);

        BootstrapAlertMessagesDemoPage page = new BootstrapAlertMessagesDemoPage(driver);
        page.clickAutocloseableInfoMessageButton();
        Assert.assertEquals("I'm an autocloseable info message. I will hide in 6 seconds.", page.getAutocloseableInfoMessageAlertText());
        System.out.println("Test Passed");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        tearDown();
    }

    // Test  method for normal information button
    public void normalInfoButton() {
        setUp();
        driver.get(url);

        BootstrapAlertMessagesDemoPage page = new BootstrapAlertMessagesDemoPage(driver);
        page.clickNormalInfoMessageButton();
        Assert.assertEquals("×\nI'm a normal info message. To close use the appropriate button.", page.getNormalInfoMessageAlertText());
        page.clickCloseButton4();
        System.out.println("Test Passed");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        tearDown();
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
