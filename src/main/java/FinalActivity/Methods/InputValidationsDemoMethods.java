package FinalActivity.Methods;

import FinalActivity.demoPage.InputValidationsDemoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class InputValidationsDemoMethods {
    private WebDriver driver;
    String url = "https://demo.seleniumeasy.com/input-form-demo.html";

    public void successInputValidationsDemo() {
        setUp();
        driver.get(url);

        InputValidationsDemoPage page = new InputValidationsDemoPage(driver);
        page.fillFirstName("Louis");
        page.fillLastName("Gimeno");
        page.fillEmail("louisgimeno72@gmail.com");
        page.fillPhone("(845)555-1212");
        page.fillAddress("Cavite City");
        page.fillCity("Cavite");
        page.selectState("Alaska");
        page.fillZipCode("4100");
        page.fillProjectDescription("asdaasdfas");
        page.clickSendButton();
        tearDown();
    }
    public void unsuccessfulInputValidationsDemo(){
        setUp();
        driver.get(url);

        InputValidationsDemoPage page = new InputValidationsDemoPage(driver);
        page.clickSendButton();
        checkValidationMessages(driver);
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

    private static void checkValidationMessages(WebDriver driver) {
        // Example validation checks for each field
        String firstNameValidationMessage = driver.findElement(By.xpath("//small[normalize-space()='Please supply your first name']")).getText();
        Assert.assertEquals("Please supply your first name", firstNameValidationMessage);

        String lastNameValidationMessage = driver.findElement(By.xpath("//small[normalize-space()='Please supply your last name']")).getText();
        Assert.assertEquals("Please supply your last name", lastNameValidationMessage);

        String emailValidationMessage = driver.findElement(By.xpath("//small[normalize-space()='Please supply your email address']")).getText();
        Assert.assertEquals("Please supply your email address", emailValidationMessage);

        String phoneValidationMessage = driver.findElement(By.xpath("//small[normalize-space()='Please supply your phone number']")).getText();
        Assert.assertEquals("Please supply your phone number", phoneValidationMessage);

        String addressValidationMessage = driver.findElement(By.xpath("//small[normalize-space()='Please supply your street address']")).getText();
        Assert.assertEquals("Please supply your street address", addressValidationMessage);

        String cityValidationMessage = driver.findElement(By.xpath("//small[normalize-space()='Please supply your city']")).getText();
        Assert.assertEquals("Please supply your city", cityValidationMessage);

        String stateValidationMessage = driver.findElement(By.xpath("//small[normalize-space()='Please select your state']")).getText();
        Assert.assertEquals("Please select your state", stateValidationMessage);

        String zipCodeValidationMessage = driver.findElement(By.xpath("//small[normalize-space()='Please supply your zip code']")).getText();
        Assert.assertEquals("Please supply your zip code", zipCodeValidationMessage);

        String projectDescriptionValidationMessage = driver.findElement(By.xpath("//small[normalize-space()='Please supply a description of your project']")).getText();
        Assert.assertEquals("Please supply a description of your project", projectDescriptionValidationMessage);
    }
}
