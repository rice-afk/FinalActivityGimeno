package FinalActivity.tests;

import FinalActivity.Methods.RadioButtonsDemoMethods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class RadioButtonsDemoTests {
    private WebDriver driver;

    @Test
    public void testRadioButtonDemo() {
        RadioButtonsDemoMethods page = new RadioButtonsDemoMethods();
        page.testRadioButtonDemo();
    }

    @Test
    public void groupRadioButtonDemo(){
        RadioButtonsDemoMethods page = new RadioButtonsDemoMethods();
        page.groupRadioButtonDemo();
    }

    @AfterMethod
    public void tearDown() {
        if (driver!= null) {
            driver.quit();
        }
    }
}
