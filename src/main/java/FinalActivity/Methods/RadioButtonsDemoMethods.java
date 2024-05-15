package FinalActivity.Methods;

import FinalActivity.demoPage.RadioButtonDemoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class RadioButtonsDemoMethods {
    private WebDriver driver;
    String url = "https://demo.seleniumeasy.com/basic-radiobutton-demo.html";

    //Method to test radio buttons
    public void testRadioButtonDemo() {
        setUp();
        driver.get(url);

        RadioButtonDemoPage page = new RadioButtonDemoPage(driver);
        page.clickMaleRadioButton();
        page.clickCheckButton();
        String actualMessage = page.getRadioButtonMessageText();
        Assert.assertEquals("Radio button 'Male' is checked", actualMessage);
        System.out.println("testRadioButtonDemo Passed");
        tearDown();
    }

    //Method to test group radio buttons
    public void groupRadioButtonDemo(){
        setUp();
        driver.get(url);

        RadioButtonDemoPage page = new RadioButtonDemoPage(driver);
        page.clickFirstGenderRadioButton();
        page.clickAgeGroupRadioButton();
        page.clickSubmitButton();
        String actualMessage = page.getRadioButtonMessageText1();
        Assert.assertEquals("Sex : Male\n" +
                "Age group: 15 - 50", actualMessage);
        System.out.println("groupRadioButtonDemo Passed");
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
