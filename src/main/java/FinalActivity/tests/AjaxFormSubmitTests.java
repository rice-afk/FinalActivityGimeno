package FinalActivity.tests;

import FinalActivity.Methods.AjaxFormDemoMethods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class AjaxFormSubmitTests {
    private WebDriver driver;

    @Test
    public void testAjaxFormSubmit() throws IOException {
        AjaxFormDemoMethods page = new AjaxFormDemoMethods();
        page.testAjaxFormSubmit();
    }

    @Test
    public void noTextboxInput() throws IOException {
        AjaxFormDemoMethods page = new AjaxFormDemoMethods();
        page.noTextboxInput();
    }

    @AfterMethod
    public void tearDown() {
        if (driver!= null) {
            driver.quit();
        }
    }
}
