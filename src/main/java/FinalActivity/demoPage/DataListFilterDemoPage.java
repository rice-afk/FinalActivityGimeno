package FinalActivity.demoPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DataListFilterDemoPage {
    @FindBy(id = "input-search")
    private WebElement searchInput;

    private WebElement nameElement;

    public DataListFilterDemoPage(WebDriver driver, String name) {
        PageFactory.initElements(driver, this);
        String xpathExpression = String.format("//h4[normalize-space()='Name: %s']", name);
        nameElement = driver.findElement(By.xpath(xpathExpression));
    }

    public void searchByName(String name) {
        searchInput.sendKeys(name);
    }

    public boolean isNameDisplayed() {
        return nameElement.isDisplayed();
    }
}
