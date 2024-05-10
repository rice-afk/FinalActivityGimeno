package rahulshettyacademy.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.*;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class ErrorValidations extends BaseTest {

    @Test(groups = {"ErrorHandling"})
    public void LoginErrorValidation() throws IOException, InterruptedException {

        String productName = "ZARA COAT 3";
        landingPage.loginApplication("louisgimeno72@gmail.com", "ert");
        Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
    }

    @Test
    public void ProductErrorValidation() throws IOException, InterruptedException {

        String productName = "ZARA COAT 3";
        ProductCatalog productCatalog =  landingPage.loginApplication("louisgimeno72@gmail.com", "ertmei08ABT731!");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));

        List<WebElement> products = productCatalog.getproductlist();
        productCatalog.addproducttocart(productName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(99));
        CartPage cartPage = productCatalog.gotocartpage();

        Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 3");
        Assert.assertTrue(match);
    }
}


