package FinalActivity.tests;

import FinalActivity.Methods.CheckboxDemoMethods;
import FinalActivity.Methods.WindowPopupModalDemoMethods;
import FinalActivity.demoPage.WindowPopupModalDemoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class WindowPopupModalTests {
   @Test
    public void twitterButton() {
       WindowPopupModalDemoMethods page = new WindowPopupModalDemoMethods();
       page.twitterButton();
    }
    @Test
    public void facebookButton() {
        WindowPopupModalDemoMethods page = new WindowPopupModalDemoMethods();
        page.facebookButton();
    }
   @Test
   public void multiwindowPage() {
       WindowPopupModalDemoMethods page = new WindowPopupModalDemoMethods();
       page.multiwindowPage();
   }
   @Test
   public void threeWindowPage() {
       WindowPopupModalDemoMethods page = new WindowPopupModalDemoMethods();
       page.threeWindowPage();
   }
}
