package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyacademy.AbstractComponents.AbstractComponents;

import java.time.Duration;
import java.util.List;

public class ProductCatalog extends AbstractComponents {

    WebDriver driver;

    public ProductCatalog(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //WebElement userEmail = driver.findElement(By.xpath("//input[@id='userEmail']"));
    //PageFactory

    // List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

    @FindBy(css = ".mb-3")
    List<WebElement> products;

    @FindBy(css = ".ng-animating")
    WebElement spinner;

    By products1 = By.cssSelector(".mb-3");
    By addtocart = By.cssSelector(".card-body button:last-of-type");
    By toastmessage = By.cssSelector("#toast-container");
    public List<WebElement> getproductlist(){
        waitforelementtoappear(products1);
        return products;
    }

    public WebElement getproductbyname(String productName){
        WebElement prod = getproductlist().stream().filter(product-> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
        return prod;
    }

    public void addproducttocart(String productName) throws InterruptedException {
        WebElement prod = getproductbyname(productName);
        prod.findElement(addtocart).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(500));
        waitforelementtoappear(toastmessage);
        waitforelementtodisappear(spinner);
    }

}