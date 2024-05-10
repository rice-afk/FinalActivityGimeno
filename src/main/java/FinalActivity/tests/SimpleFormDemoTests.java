package FinalActivity.tests;

import FinalActivity.Methods.SimpleFormDemoMethods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SimpleFormDemoTests{
    private WebDriver driver;

    @Test
    public void testSubmitForm() {
        SimpleFormDemoMethods page = new SimpleFormDemoMethods();
        page.testSubmitForm("abc");
    }

    @Test
    public void testCalculateAndVerifyResult() {
        SimpleFormDemoMethods page = new SimpleFormDemoMethods();
        page.testCalculateAndVerifyResult(8,5);
    }
    @AfterMethod
    public void tearDown() {
        SimpleFormDemoMethods page = new SimpleFormDemoMethods();
        page.tearDown();
    }
}
