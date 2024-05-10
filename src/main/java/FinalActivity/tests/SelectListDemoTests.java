package FinalActivity.tests;

import FinalActivity.Methods.SelectListDemoMethods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SelectListDemoTests {

    private WebDriver driver;

    @Test
    public void singleSelectListDemo() {
        SelectListDemoMethods page = new SelectListDemoMethods();
        page.singleSelectListDemo();
    }
    @Test
    public void multiSelectListDemo() {
        SelectListDemoMethods page = new SelectListDemoMethods();
        page.multiSelectListDemo();
    }
    @AfterMethod
    public void tearDown() {
        if (driver!= null) {
            driver.quit();
        }
    }
}
