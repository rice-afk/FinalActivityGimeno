package FinalActivity.Methods;

import FinalActivity.demoPage.AjaxFormSubmitDemoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

public class AjaxFormDemoMethods {
    private WebDriver driver;
    String url = "https://demo.seleniumeasy.com/ajax-form-submit-demo.html";

    // Method to load JSON data from a file
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

    // Main method to test AJAX form submission
    public void testAjaxFormSubmit() throws IOException {
        JSONArray inputData = loadJsonData("/Users/louisgimeno/IdeaProjects/MavenDependencies/testData/AjaxSubmitForm.json");
        for (int i = 0; i < inputData.length(); i++) {
            setUp();
            driver.get(url);

            AjaxFormSubmitDemoPage page = new AjaxFormSubmitDemoPage(driver);
            JSONObject data = inputData.getJSONObject(i);
            String name = data.getString("name");
            String comment = data.getString("comment");
            System.out.println("Name: " + name + ", Comment: " + comment);

            page.fillForm(name, comment);
            page.submitForm();

            page.waitForSuccessMessageVisibiity(driver);
            String initialMessage = page.printInitialMessage(driver);
            try {
                Assert.assertEquals("Ajax Request is Processing!", initialMessage, "Initial message does not match.");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Test Passed: Initial Message");
            } catch (AssertionError e) {
                tearDown();
                System.out.println("Test Failed: Initial Message - " + e.getMessage());
                throw e; // Re-throw the exception to fail the test
            }
            page.waitForSuccessMessage(driver);
            String successMessage = page.printFinalMessage();
            try {
                Assert.assertEquals("Form submited Successfully!", successMessage, "Success message does not match.");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Test Passed: Success Message");
            } catch (AssertionError e) {
                tearDown();
                System.out.println("Test Failed: Success Message - " + e.getMessage());
                throw e; // Re-throw the exception to fail the test
            }
            tearDown();
        }
    }

    // Setup method to initialize WebDriver and set implicit wait time
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // Teardown method to quit the WebDriver session
    public void tearDown() {
        if (driver!= null) {
            driver.quit();
        }
    }
}
