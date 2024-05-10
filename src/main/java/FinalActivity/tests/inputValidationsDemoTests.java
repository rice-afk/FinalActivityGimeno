package FinalActivity.tests;

import FinalActivity.Methods.InputValidationsDemoMethods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class inputValidationsDemoTests {

    private WebDriver driver;

    @Test
    public void successInputValidationsDemo() {
        InputValidationsDemoMethods page = new InputValidationsDemoMethods();
        page.successInputValidationsDemo();
    }

    @Test
    public void unsuccessfulInputValidationsDemo(){
        InputValidationsDemoMethods page = new InputValidationsDemoMethods();
        page.unsuccessfulInputValidationsDemo();
    }

    @AfterMethod
    public void tearDown() {
        if (driver!= null) {
            driver.quit();
        }
    }

}
