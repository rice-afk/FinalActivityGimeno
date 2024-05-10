package FinalActivity.demoPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DataListFilterDemoPage {
    @FindBy(id = "input-search")
    private WebElement searchInput;

    @FindBy(xpath = "//h4[normalize-space()='Name: Brenda Tree']")
    private WebElement nameElement;

    public DataListFilterDemoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void searchByName(String name) {
        searchInput.sendKeys(name);
    }

    public boolean isNameDisplayed() {
        return nameElement.isDisplayed();
    }
}
