package FinalActivity.demoPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TableSortSearchDemoPage {
    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchTextBox;

    @FindBy(xpath = "//select[@name='example_length']")
    private WebElement entriesSelect;

    @FindBy(xpath = "//option[@value='25']")
    private WebElement entriesOption;

    @FindBy(xpath = "//a[@id='example_next']")
    private WebElement nextPageLink;

    @FindBy(xpath = "//a[@id='example_previous']")
    private WebElement previousPageLink;

    @FindBy(xpath = "(//a[normalize-space()='2'])[1]")
    private WebElement secondPageLink;

    private WebDriver driver;

    public TableSortSearchDemoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchFor(String searchTerm) {
        searchTextBox.sendKeys(searchTerm);
    }

    public void clearSearch() {
        searchTextBox.clear();
    }

    public void selectEntries(int numberOfEntries) {
        entriesSelect.click();
        for (int i = 0; i < numberOfEntries; i++) {
            entriesOption.click();
        }
    }

    public void clickPaginationLink(String linkText) {
        if ("next".equals(linkText)) {
            nextPageLink.click();
        } else if ("previous".equals(linkText)) {
            previousPageLink.click();
        } else if ("2".equals(linkText)) {
            secondPageLink.click();
        }
    }
}
