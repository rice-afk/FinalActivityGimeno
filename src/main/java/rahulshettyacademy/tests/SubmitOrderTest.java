package rahulshettyacademy.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.*;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class SubmitOrderTest extends BaseTest {
    String productName = "ZARA COAT 3";
    @Test(dataProvider = "getData",groups = {"Purchase"})
    public void submitOrder(String email, String password, String productName) throws IOException, InterruptedException {


        ProductCatalog productCatalog =  landingPage.loginApplication(email, password);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));

        List<WebElement> products = productCatalog.getproductlist();
        productCatalog.addproducttocart(productName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(99));
        CartPage cartPage = productCatalog.gotocartpage();

        Boolean match = cartPage.VerifyProductDisplay(productName);
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.selectCountry("India");
        ConfirmationPage confirmationPage = checkoutPage.submitOrder();


        String confirmMessage = confirmationPage.getConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

    }

    @Test(dependsOnMethods = {"submitOrder"})
    public void OrderHistoryTest() {
        ProductCatalog productCatalog =  landingPage.loginApplication("louisgimeno72@gmail.com", "ertmei08ABT731!");
        OrderPage orderPage = productCatalog.gotoorderspage();
        orderPage.VerifyOrderDisplay(productName);
        Assert.assertTrue(orderPage.VerifyOrderDisplay(productName));
    }

    @DataProvider
    public Object[][] getData(){
        return new Object [][] {{"louisgimeno72@gmail.com", "ertmei08ABT731!", "ZARA COAT 3"}, {"shetty@gmail.com","Iamking@000", "ADIDAS ORIGINAL"}};
    }

   /* public Object[][] getData(){
        HashMap<String, String> map = new HashMap();
        map.put("email","louisgimeno72@gmail.com");
        map.put("password","ertmei08ABT731!");
        map.put("product","ZARA COAT 3");

        HashMap<String, String> map1 = new HashMap();
        map1.put("email","shetty@gmail.com");
        map1.put("password","Iamking@000");
        map1.put("product","ADIDAS ORIGINAL");

        return new Object [][] {{map}, {map1}};
    }*/
}


