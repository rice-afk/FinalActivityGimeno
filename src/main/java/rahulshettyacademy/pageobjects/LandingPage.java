package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {

    WebDriver driver;
    public LandingPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    //WebElement userEmail = driver.findElement(By.xpath("//input[@id='userEmail']"));
    //PageFactory

    @FindBy(id="userEmail")
    WebElement userEmail;

    @FindBy(id="userPassword")
    WebElement passwordE;

    @FindBy(id="login")
    WebElement submit;

    @FindBy(css="[class*='flyInOut'")
    WebElement errorMessage;

    public ProductCatalog loginApplication(String email, String password){
        userEmail.sendKeys(email);
        passwordE.sendKeys(password);
        submit.click();
        ProductCatalog productCatalog = new ProductCatalog(driver);
        return productCatalog;
    }

    public String getErrorMessage(){
        waitforwebelementtoappear(errorMessage);
        return errorMessage.getText();
    }

    public void goTo(){
        driver.get("https://rahulshettyacademy.com/client/");
    }
}
