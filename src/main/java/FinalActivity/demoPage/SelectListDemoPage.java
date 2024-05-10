package FinalActivity.demoPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SelectListDemoPage {
    @FindBy(id = "select-demo")
    private WebElement dropdown;

    @FindBy(xpath = "//p[@class='selected-value']")
    private WebElement selectedValueText;

    @FindBy(id = "printMe")
    private WebElement printButton;

    @FindBy(id = "printAll")
    private WebElement printAllButton;

    @FindBy(xpath = "//p[@class='getall-selected']")
    private WebElement selectedValuesText;

    @FindBy(xpath = "(//option[@value='Florida'])[1]")
    private WebElement pickFlorida;


    public SelectListDemoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Method to select an option by visible text
    public void selectOptionByVisibleText(String optionText) {
        Select select = new Select(dropdown);
        select.selectByVisibleText(optionText);
    }

    // Method to get the text of the selected value
    public String getSelectedValueText() {
        return selectedValueText.getText();
    }

    public void selectOptionByValue(String optionValue) {
        Select select = new Select(dropdown);
        select.selectByValue(optionValue);
    }

    // Method to click the Print button
    public void clickPrintButton() {
        printButton.click();
    }

    public void clickFlorida(){
        pickFlorida.click();
    }

    // Method to click the Print All button
    public void clickPrintAllButton() {
        printAllButton.click();
    }

    // Method to get the text of the selected values
    public String getSelectedValuesText() {
        return selectedValuesText.getText();
    }



}
