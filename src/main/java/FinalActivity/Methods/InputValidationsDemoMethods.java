package FinalActivity.Methods;

import FinalActivity.demoPage.InputValidationsDemoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

public class InputValidationsDemoMethods {
    private WebDriver driver;
    String url = "https://demo.seleniumeasy.com/input-form-demo.html";

    public JSONArray loadJsonData(String filePath) throws IOException {
        File file = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(file));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine())!= null) {
            sb.append(line);
        }
        br.close();
        return new JSONArray(sb.toString());
    }

    public void successInputValidationsDemo() throws IOException {
        JSONArray inputData = loadJsonData("/Users/louisgimeno/IdeaProjects/MavenDependencies/InputValidations.json");
        for (int i = 0; i < inputData.length(); i++) {
            this.setUp();
            this.driver.get(this.url);
            JSONObject data = inputData.getJSONObject(i);
            InputValidationsDemoPage page = new InputValidationsDemoPage(this.driver);
            page.fillFirstName(data.getString("firstName"));
            page.fillLastName(data.getString("lastName"));
            page.fillEmail(data.getString("email"));
            page.fillPhone(data.getString("phone"));
            page.fillAddress(data.getString("address"));
            page.fillCity(data.getString("city"));
            page.selectState(data.getString("state"));
            page.fillZipCode(data.getString("zipCode"));
            page.fillProjectDescription(data.getString("projectDescription"));
            page.clickSendButton();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tearDown();
        }
        tearDown();
    }

    public void unsuccessfulInputValidationsDemo() {
        this.setUp();
        this.driver.get(this.url);
        InputValidationsDemoPage page = new InputValidationsDemoPage(this.driver);
        page.clickSendButton();
        checkValidationMessages(this.driver);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.tearDown();
    }

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
    }

    public void tearDown() {
        if (this.driver != null) {
            this.driver.quit();
        }

    }

    private static void checkValidationMessages(WebDriver driver) {
        String firstNameValidationMessage = driver.findElement(By.xpath("//small[normalize-space()='Please supply your first name']")).getText();
        Assert.assertEquals("Please supply your first name", firstNameValidationMessage);
        String lastNameValidationMessage = driver.findElement(By.xpath("//small[normalize-space()='Please supply your last name']")).getText();
        Assert.assertEquals("Please supply your last name", lastNameValidationMessage);
        String emailValidationMessage = driver.findElement(By.xpath("//small[normalize-space()='Please supply your email address']")).getText();
        Assert.assertEquals("Please supply your email address", emailValidationMessage);
        String phoneValidationMessage = driver.findElement(By.xpath("//small[normalize-space()='Please supply your phone number']")).getText();
        Assert.assertEquals("Please supply your phone number", phoneValidationMessage);
        String addressValidationMessage = driver.findElement(By.xpath("//small[normalize-space()='Please supply your street address']")).getText();
        Assert.assertEquals("Please supply your street address", addressValidationMessage);
        String cityValidationMessage = driver.findElement(By.xpath("//small[normalize-space()='Please supply your city']")).getText();
        Assert.assertEquals("Please supply your city", cityValidationMessage);
        String stateValidationMessage = driver.findElement(By.xpath("//small[normalize-space()='Please select your state']")).getText();
        Assert.assertEquals("Please select your state", stateValidationMessage);
        String zipCodeValidationMessage = driver.findElement(By.xpath("//small[normalize-space()='Please supply your zip code']")).getText();
        Assert.assertEquals("Please supply your zip code", zipCodeValidationMessage);
        String projectDescriptionValidationMessage = driver.findElement(By.xpath("//small[normalize-space()='Please supply a description of your project']")).getText();
        Assert.assertEquals("Please supply a description of your project", projectDescriptionValidationMessage);
    }
}
