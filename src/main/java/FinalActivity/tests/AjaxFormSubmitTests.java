package FinalActivity.tests;

import FinalActivity.Methods.AjaxFormDemoMethods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class AjaxFormSubmitTests {
    private WebDriver driver;

    @Test
    public void testAjaxFormSubmit() {
        AjaxFormDemoMethods page = new AjaxFormDemoMethods();
        page.testAjaxFormSubmit();
    }

    @AfterMethod
    public void tearDown() {
        if (driver!= null) {
            driver.quit();
        }
    }
}
