package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utilities.Log;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass (description = "Class Level Setup!")
    public void setup () {
        //Write a Log when tests is starting
        Log.startLog("Test is starting!");

        initDriver("chrome");
        //Create a Chrome driver. All test classes use this.
        driver = new ChromeDriver();

        //Create a wait. All test classes use this.
        wait = new WebDriverWait(driver,15);

        //Maximize Window
        driver.manage().window().maximize();
    }

    @AfterClass(description = "Class Level Teardown!")
    public void teardown () {
        //Write a Log when tests are ending
        Log.endLog("Test is ending!");
        driver.quit();
    }
    private void initDriver(String browser){
        if (browser.toUpperCase().trim().equals("chrome".toUpperCase().trim())) {
            // using testProperties.properties
            WebDriverManager.chromedriver().setup();
            // System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
        } else if (browser.toUpperCase().trim().equals("firefox".toUpperCase().trim())) {
            // using testProperties.properties
            WebDriverManager.firefoxdriver().setup();
        } else if (browser.toUpperCase().trim().equals("opera".toUpperCase().trim())) {
            // using testProperties.properties
            WebDriverManager.operadriver().setup();
        } else if (browser.toUpperCase().trim().equals("phantom".toUpperCase().trim())) {
            // using testProperties.properties
            WebDriverManager.phantomjs().setup();
        } else if (browser.toUpperCase().trim().equals("edge".toUpperCase().trim())) {
            // using testProperties.properties
            WebDriverManager.edgedriver().setup();
        } else if (browser.toUpperCase().trim().equals("ie".toUpperCase().trim())) {
            // using testProperties.properties
            WebDriverManager.iedriver().setup();
        }
    }

}
