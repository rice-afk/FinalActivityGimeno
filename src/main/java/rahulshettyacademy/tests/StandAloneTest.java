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
import rahulshettyacademy.pageobjects.LandingPage;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;

public class StandAloneTest {

    public static void main(String[] args) {

        String productName = "ZARA COAT 3";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/client/");
        LandingPage landingPage = new LandingPage(driver);
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("louisgimeno72@gmail.com");
        driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("ertmei08ABT731!");
        driver.findElement(By.xpath("//input[@id='login']")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector(".mb-3"))));
        List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement prod = products.stream().filter(product-> product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
        //ng-anmiating
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
        driver.findElement(By.cssSelector(".btn.btn-custom[routerlink='/dashboard/cart']")).click();

        List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));

        Boolean match = cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
        Assert.assertTrue(match);
        driver.findElement(By.cssSelector(".totalRow button")).click();

        Actions a = new Actions(driver);
        a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
        driver.findElement(By.xpath("(//button[contains(@class, 'ta-item')])[2]")).click();
        driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click();

        String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
        driver.close();

    }
}


