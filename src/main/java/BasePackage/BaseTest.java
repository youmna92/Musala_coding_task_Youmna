package BasePackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver;

    @BeforeTest
    @Parameters({"Browser","URL"})
    public void setup (String browser, String url) {
        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(150, TimeUnit.SECONDS);
            WebDriverWait explicitWait = new WebDriverWait(driver,50);
            driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(150,TimeUnit.SECONDS);
            driver.get(url);
        }

        else if (browser.equalsIgnoreCase("firefox")){

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(150, TimeUnit.SECONDS);
            WebDriverWait explicitWait = new WebDriverWait(driver,50);
            driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(150,TimeUnit.SECONDS);
            driver.get(url);
        }
        else if (browser.equalsIgnoreCase("Edge")){

            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(150, TimeUnit.SECONDS);
            WebDriverWait explicitWait = new WebDriverWait(driver,50);
            driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(150,TimeUnit.SECONDS);
            driver.get(url);
        }

    }

    @AfterTest
    public void teardown () {
        driver.quit();
    }
}