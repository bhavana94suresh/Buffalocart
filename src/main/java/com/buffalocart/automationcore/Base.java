package com.buffalocart.automationcore;

import com.buffalocart.constants.Constants;
import com.buffalocart.extentreport.ExtentManager;
import com.buffalocart.utilities.WaitUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Base {
    public WebDriver driver;
    public Properties prop;
    FileInputStream fs;
    public Base()  {
        prop=new Properties();
        try {
            fs=new FileInputStream(System.getProperty("user.dir")+ Constants.CONFIG_FILE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prop.load(fs);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void testIntialise(String browser,String url) {
        if (browser.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\pc\\IdeaProjects\\DemoWorkShop\\src\\main\\resources\\seleniumDriver\\chromedriver.exe");
            driver = new  ChromeDriver();
        } else if (browser.equals("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\pc\\IdeaProjects\\DemoWorkShop\\src\\main\\resources\\seleniumDriver\\geckodriver.exe");
            driver = new EdgeDriver();
        } else if (browser.equals("Edge")) {
            System.setProperty("webdriver.edge.driver", "C:\\Users\\pc\\IdeaProjects\\DemoWorkShop\\src\\main\\resources\\seleniumDriver\\msedgedriver.exe");
            driver = new FirefoxDriver();
        } else if (browser.equals("ie")) {
            System.setProperty("webdriver.ie.driver", "C:\\Users\\pc\\IdeaProjects\\DemoWorkShop\\src\\main\\resources\\seleniumDriver\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        } else {
            try {
                throw new Exception("Invalid browser");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(url);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(WaitUtility.PAGE_LOAD_WAIT));
    }

    @BeforeSuite
    public void setExtent(final ITestContext testContext){
        ExtentManager.createInstance().createTest(testContext.getName(), "TEST FAILED");
    }
    @BeforeMethod
    public void setUp() {
        String browserName=prop.getProperty("browser");
        String baseUrl=prop.getProperty("url");
        testIntialise(browserName,baseUrl);

    }
    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {

            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File("./Screenshots/" + result.getName() + ".png"));

        }
        driver.close();
    }
}
