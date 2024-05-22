package FinalActivity.tests;

import FinalActivity.demoPage.SimpleFormDemoPage;
import FinalActivity.Methods.SimpleFormDemoMethods;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SimpleFormDemoTests {
    private WebDriver driver;
    String url = "https://demo.seleniumeasy.com/basic-first-form-demo.html";

    @DataProvider(name = "excelData")
    public Object[][] excelData() throws IOException {
        FileInputStream fis = new FileInputStream(new File("/Users/louisgimeno/IdeaProjects/MavenDependencies/testData/testSubmitFormExcel.xlsx"));
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);
        int rowCount = sheet.getLastRowNum();
        Object[][] data = new Object[rowCount][1];
        for (int i = 0; i < rowCount; i++) {
            Row row = sheet.getRow(i + 1);
            data[i][0] = row.getCell(0).getStringCellValue();
        }
        workbook.close();
        return data;
    }

    @Test(dataProvider = "excelData")
    public void testSubmitFormExcel(String expectedMessage) {
        SimpleFormDemoMethods page = new SimpleFormDemoMethods();
        page.testSubmitForm(expectedMessage);
    }
    @Test
    public void testSubmitFormWithJsonData() throws IOException {
        SimpleFormDemoMethods page = new SimpleFormDemoMethods();
        page.testSubmitFormWithJsonData();
    }
    @Test
    public void testCalculateandVerifywithJsonData() throws IOException {
        SimpleFormDemoMethods page = new SimpleFormDemoMethods();
        page.testCalculateandVerifywithJsonData();
    }
    @Test
    public void testNegativeScenario() throws IOException {
        SimpleFormDemoMethods page = new SimpleFormDemoMethods();
        page.testNegativeScenario();
    }

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        if (driver!= null) {
            driver.quit();
        }
    }
}
