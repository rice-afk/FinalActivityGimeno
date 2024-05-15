package FinalActivity.Methods;

import FinalActivity.demoPage.JQuerySelectDemoPage;
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

public class JQuerySelectDemoMethods {
    private WebDriver driver;
    String url = "https://demo.seleniumeasy.com/jquery-dropdown-search-demo.html";
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

    public void runTestsFromJson() throws IOException {
        JSONArray inputData = loadJsonData("/Users/louisgimeno/IdeaProjects/MavenDependencies/testData/JQuerySelect.json");
        for (int i = 0; i < inputData.length(); i++) {
            setUp();
            driver.get(url);

            JSONObject data = inputData.getJSONObject(i);
            String testName = data.getString("testName");

            switch (testName) {
                case "dropdownwithSearchbox":
                    JQuerySelectDemoPage page = new JQuerySelectDemoPage(driver);
                    page.selectCountryBySearch(data.getString("country"));
                    String selectedCountry = page.getSelectedCountry();
                    Assert.assertEquals(data.getString("country"), selectedCountry);
                    break;
                case "dropdownwithDisabledValues":
                    page = new JQuerySelectDemoPage(driver);
                    page.selectDisabledValueFromDropdown(data.getString("country"), driver);
                    break;
                case "selectCategory":
                    page = new JQuerySelectDemoPage(driver);
                    page.selectCategoryOption(data.getString("category"), driver);
                    break;
                case "testMultipleJQueryDemo":
                    page = new JQuerySelectDemoPage(driver);
                    page.multiplevalues(driver);
                    break;
            }

            tearDown();
        }
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
