package FinalActivity.tests;

import FinalActivity.Methods.InputValidationsDemoMethods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class inputValidationsDemoTests {

    private WebDriver driver;
    @Test
    public void successInputValidationsDemo() throws IOException {
        InputValidationsDemoMethods page = new InputValidationsDemoMethods();
        page.successInputValidationsDemo();
    }

    @Test
    public void unsuccessfulInputValidationsDemo() {
        InputValidationsDemoMethods page = new InputValidationsDemoMethods();
        page.unsuccessfulInputValidationsDemo();
    }

    @AfterMethod
    public void tearDown() {
        if (this.driver != null) {
            this.driver.quit();
        }

    }

}
