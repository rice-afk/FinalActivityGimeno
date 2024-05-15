package FinalActivity.Methods;

import FinalActivity.demoPage.DataListFilterDemoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.JSONArray;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

public class DataListFilterDemoMethods {
    private WebDriver driver;
    String url = "https://demo.seleniumeasy.com/data-list-filter-demo.html";
    public void testSearchAndVerifyNames() throws IOException {
        JSONArray namesData = loadNamesData("/Users/louisgimeno/IdeaProjects/MavenDependencies/testData/DataListFilter.json");
        for (int i = 0; i < namesData.length(); i++) {
            setUp();
            driver.get(url);

            DataListFilterDemoPage page = new DataListFilterDemoPage(driver, namesData.getString(i));
            boolean isNameDisplayed = page.isNameDisplayed();
            Assert.assertTrue(isNameDisplayed, "Name: " + namesData.getString(i) + " is not displayed on the page.");

            tearDown();
        }
    }

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
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    public void tearDown() {
        if (driver!= null) {
            driver.quit();
        }
    }
}
