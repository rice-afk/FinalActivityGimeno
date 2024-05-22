package FinalActivity.Methods;

import FinalActivity.demoPage.DataListFilterDemoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

public class DataListFilterDemoMethods {
    private WebDriver driver;
    String url = "https://demo.seleniumeasy.com/data-list-filter-demo.html";

    //Method for testing search and verifying names
    public void testSearchAndVerifyNames() throws IOException {
        try {
            JSONArray namesData = loadNamesData("/Users/louisgimeno/IdeaProjects/MavenDependencies/testData/DataListFilter.json");
            for (int i = 0; i < namesData.length(); i++) {
                setUp();
                driver.get(url);

                // Assuming url is defined somewhere in your setup or passed as a parameter
                // Initialize the page object with the current name from the JSON array
                DataListFilterDemoPage page = new DataListFilterDemoPage(driver, namesData.getString(i));

                // Use the searchByName method to search for the current name
                page.searchByName(namesData.getString(i));

                // Wait for the name to appear after searching
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
                wait.until(ExpectedConditions.visibilityOf(page.nameElement));

                boolean isNameDisplayed = page.isNameDisplayed();
                Assert.assertTrue(isNameDisplayed, "Name: " + namesData.getString(i) + " is not displayed on the page.");

                System.out.println("Testing name: " + namesData.getString(i)); // Print the name being tested
                if (isNameDisplayed) {
                    System.out.println("Success: Name '" + namesData.getString(i) + "' is displayed."); // Print success message
                } else {
                    System.out.println("Failure: Name '" + namesData.getString(i) + "' is not displayed."); // Print failure message
                }
                Thread.sleep(3000);
                tearDown();
            }
        } catch (IOException | JSONException e) {
            System.err.println("Error occurred: " + e.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            if (driver!= null) {
                tearDown();
            }
        }
    }


    // Method for loading data from Json and putting into Array
    public JSONArray loadNamesData(String filePath) throws IOException {
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
    // Setup method to initialize WebDriver and set implicit wait time
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    // Teardown method to quit the WebDriver session
    public void tearDown() {
        if (driver!= null) {
            driver.quit();
        }
    }
}
