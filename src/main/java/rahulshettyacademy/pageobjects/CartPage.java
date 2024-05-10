package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import rahulshettyacademy.AbstractComponents.AbstractComponents;

import java.util.List;

public class CartPage extends AbstractComponents {

    WebDriver driver;

    @FindBy(css = ".totalRow button")
    WebElement checkoutEle;
    @FindBy(css = ".cartSection h3")
    private List<WebElement> productTitles;

    public CartPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public boolean VerifyProductDisplay(String productName){
        Boolean match = productTitles.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
        return match;
    }

    public CheckoutPage goToCheckout(){
        checkoutEle.click();
        return new CheckoutPage(driver);
    }



}
