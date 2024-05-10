package FinalActivity.tests;

import FinalActivity.Methods.CheckboxDemoMethods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CheckBoxDemoTests {
    private WebDriver driver;

    @Test
    public void singleCheckboxDemo() {
        CheckboxDemoMethods page = new CheckboxDemoMethods();
        page.singleCheckboxDemo();
    }

    @Test
    public void multipleCheckboxDemo(){
        CheckboxDemoMethods page = new CheckboxDemoMethods();
        page.multipleCheckboxDemo();
    }

    @AfterMethod
    public void tearDown() {
        CheckboxDemoMethods page = new CheckboxDemoMethods();
        page.tearDown();
    }
}
