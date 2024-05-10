package FinalActivity.demoPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DualListBoxDemoPage {
    private WebDriver driver;

    @FindBy(xpath = "//input[@placeholder='search'][1]")
    private WebElement searchInput;

    @FindBy(xpath = "(//li[@class='list-group-item'][normalize-space()='Morbi leo risus'])[1]")
    private WebElement firstResult;

    @FindBy(xpath = "//button[@class='btn btn-default btn-sm move-right'][1]")
    private WebElement moveRightButton;

    @FindBy(xpath = "(//li[@class='list-group-item active'])[1]")
    private List<WebElement> rightListItems;

    public DualListBoxDemoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Method to search and move the item to the right list
    public void searchAndMoveItem(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        searchInput.click();
        searchInput.sendKeys("Morbi leo risus");
        firstResult.click();
        moveRightButton.click();

        // Verify that the item appears in the right list
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//li[@class='list-group-item active'])[1]")));
        boolean itemFound = false;
        for (WebElement listItem : rightListItems) {
            if (listItem.getText().equals("Morbi leo risus")) {
                itemFound = true;
                break;
            }
        }

        if (itemFound) {
            assert itemFound : "Item 'Morbi leo risus' found in the right list.";
        } else {
            assert!itemFound : "Item 'Morbi leo risus' not found in the right list.";
        }
    }

    @FindBy(xpath = "//div[@class='well text-right']//a[@title='select all']")
    private WebElement selectAllLink;

    public void clickSelectAllLink(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement selectAllLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='well text-right']//a[@title='select all']")));
        selectAllLink.click();
    }

    // Method to click the 'Move Right' button
    public void clickMoveRightButton(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement moveRightButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-default btn-sm move-right'][1]")));
        moveRightButton.click();
    }

    // Method to verify that all items have been moved to the right list
    public boolean verifyItemsMovedToRightList(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> rightListActiveItems = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[@class='list-group-item active']")));
        return rightListActiveItems.size() == 5;
    }


    @FindBy(xpath = "(//button[@class='btn btn-default btn-sm move-left'])[1]")
    private WebElement moveLeftButton;

    public boolean verifyItemsMoved(List<WebElement> rightListActiveItems) {
        if (rightListActiveItems.size() == 5) {
            assert rightListActiveItems.size() == 5 : "All 5 items have been successfully moved to the left list.";
            return true;
        } else {
            assert rightListActiveItems.size()!= 5 : "Not all items were moved. Expected 5, but found " + rightListActiveItems.size();
            return false;
        }
    }




}
