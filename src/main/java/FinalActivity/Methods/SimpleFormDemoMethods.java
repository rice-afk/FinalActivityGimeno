package  FinalActivity.Methods;

import FinalActivity.demoPage.SimpleFormDemoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

public class SimpleFormDemoMethods {
    private WebDriver driver;
    String url = "https://demo.seleniumeasy.com/basic-first-form-demo.html";
    private WebDriverWait wait;

    // Setup method to initialize WebDriver and WebDriverWait
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    // Teardown method to quit the WebDriver session
    public void tearDown() {
        if (driver!= null) {
            driver.quit();
        }
    }

    // Method to submit a form with a predefined message
    public void testSubmitForm(String expectedMessage) {
        setUp();
        driver.get(url);
        SimpleFormDemoPage page = new SimpleFormDemoPage(driver);
        page.enterUserMessage(expectedMessage);
        String actualMessage = page.getMessage();
        Assert.assertEquals(actualMessage, expectedMessage, "The expected message does not match the actual message");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tearDown();
    }
    // Method to submit forms based on JSON data
    public void testSubmitFormWithJsonData() throws IOException {
        String jsonFilePath = "/Users/louisgimeno/IdeaProjects/MavenDependencies/testData/testSubmitForm.json";
        JSONArray jsonArray = new JSONArray(new String(Files.readAllBytes(Paths.get(jsonFilePath))));
        SimpleFormDemoMethods page = new SimpleFormDemoMethods();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String expectedMessage = jsonObject.getString("expectedMessage");
            page.testSubmitForm(expectedMessage);
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tearDown();
    }
    // Method to calculate and verify results based on JSON data
    public void testCalculateAndVerifyResult(JSONArray testData) throws IOException {
        // Move setUp() here to ensure it only runs once before processing all test cases
        setUp();

        driver.get(url);
        SimpleFormDemoPage page = new SimpleFormDemoPage(driver);

        for (int i = 0; i < testData.length(); i++) {
            JSONObject test = testData.getJSONObject(i);
            int a = test.getInt("a");
            int b = test.getInt("b");
            page.enterValues(a, b);
            int c = a + b;
            String actualResult = page.getResult();
            String expectedResult = test.getString("expectedResult");
            Assert.assertEquals(actualResult, expectedResult, "The expected result does not match the actual result");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            page.clearValues();
        }

        tearDown();
    }
    // Test method to calculate and verify results with JSON data
    public void testCalculateandVerifywithJsonData() throws IOException {
        SimpleFormDemoMethods demoMethods = new SimpleFormDemoMethods();
        JSONArray testData = new JSONArray(new String(Files.readAllBytes(Paths.get("/Users/louisgimeno/IdeaProjects/MavenDependencies/testData/testCalculateandVerify.json"))));
        demoMethods.testCalculateAndVerifyResult(testData);
    }
    // Method to test the negative scenario where getTotalButton is clicked and displayResult is NaN
    public void testNegativeScenario() {
        setUp();
        driver.get(url);
        SimpleFormDemoPage page = new SimpleFormDemoPage(driver);

        // Click the getTotalButton
        page.getTotalButton.click();

        // Wait for the operation to complete and the result to be displayed
        try {
            Thread.sleep(2000); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Assert that displayResult is NaN
        try {
            double actualResult = Double.parseDouble(page.getResult());
            Assert.assertTrue(Double.isNaN(actualResult), "Expected displayResult to be NaN but got a valid number instead.");
            System.out.println("Test Passed: Expected NaN result received.");
        } catch (NumberFormatException e) {
            // Handle case where getDisplayResult() might not return a parsable string
            Assert.fail("getDisplayResult() did not return a parsable string.");
        }

        // Implementing try-catch around the entire block ensures that even if an error occurs during the test,
        // the WebDriver session is properly closed in the finally block.
        try {
            tearDown();
        } catch (Exception e) {
            System.err.println("An error occurred during the test cleanup: " + e.getMessage());
        }
    }
}
