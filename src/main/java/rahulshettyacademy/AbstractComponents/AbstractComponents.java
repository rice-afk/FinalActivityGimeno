package rahulshettyacademy.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.OrderPage;

import java.time.Duration;

public class AbstractComponents {

    WebDriver driver;
    public AbstractComponents (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//button[@routerlink='/dashboard/cart']")
    WebElement cartHeader;

    @FindBy (xpath = "//button[@routerlink='/dashboard/myorders']")
    WebElement orderHeader;

    public void waitforelementtoappear(By findBy){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }
    public void waitforwebelementtoappear(WebElement findBy){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(findBy));
    }

    public void waitforelementtodisappear(WebElement ele) throws InterruptedException {
        Thread.sleep(1000);
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //wait.until(ExpectedConditions.invisibilityOf(ele));
    }

    public CartPage gotocartpage(){
        cartHeader.click();
        CartPage cartPage = new CartPage(driver);
        return cartPage;
    }

    public OrderPage gotoorderspage(){
        orderHeader.click();
        OrderPage orderPage = new OrderPage(driver);
        return orderPage;
    }

}
