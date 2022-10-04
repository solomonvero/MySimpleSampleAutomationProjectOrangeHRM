package com.HRMAutomation.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.HRMAutomation.pages.HomePageClass;
import com.HRMAutomation.pages.LoginPageClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClasss {
	
public static WebDriver driver;
public static Properties prop;
public static FileInputStream infile;
public ExtentHtmlReporter htmlReporter;
public ExtentReports extent;
public ExtentTest test;
public static LoginPageClass loginPage;
public static HomePageClass homePage;



public BaseClasss() //throws IOException
{
	prop=new Properties();
FileInputStream infile;
try 
{
	infile = new FileInputStream("C:\\Users\\sngichuki\\Downloads\\automatingHRM\\automatingHRM\\propertyfile\\propert.properties");
	prop.load(infile);
} 
catch (FileNotFoundException e) 
{
	e.printStackTrace();	
} catch (IOException e) 
{
	e.printStackTrace();
}
}

@BeforeMethod
public void Initialization()
{
	
	if (prop.getProperty("browser").equalsIgnoreCase("chrome"))
	{
	WebDriverManager.chromedriver().setup();
	ChromeOptions opt = new ChromeOptions();
	opt.setAcceptInsecureCerts(true);
	driver=new ChromeDriver(opt);
	}
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	//loginPage=new LoginPageClass();
	//homePage =new HomePageClass();
}

/*
public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException 
{
    String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
    TakesScreenshot ts = (TakesScreenshot) driver;
    File source = ts.getScreenshotAs(OutputType.FILE);

    String destination = System.getProperty("user.dir") + "/TestResults/FailedTestScreenshots/" + screenshotName + dateName + ".png";
    File finalDestination = new File(destination);
    FileUtils.copyFile(source, finalDestination);

    String screenshotShortPath = "../FailedTestScreenshots/" + screenshotName + dateName + ".png";
    System.out.println(screenshotShortPath);
    return screenshotShortPath;
}



@BeforeTest
public void setExtent() {
    String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
    String testSuiteName = getClass().getSimpleName(); //returns name only
    htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/TestResults/TestReports/" + testSuiteName + "Report" + dateName + ".html");
    htmlReporter.config().setDocumentTitle("QA Report"); // Tile of report
    htmlReporter.config().setReportName(testSuiteName); // Name of the report
    htmlReporter.config().setTheme(Theme.DARK);
   // String css = ".r-img {width: 100%;}";
    //htmlReporter.config().setCSS(css);
    extent = new ExtentReports();
    extent.attachReporter(htmlReporter);
    //String os = System.getProperty("os.name").toLowerCase();
    //extent.setSystemInfo("OS", os);
}

 
@AfterMethod
public void tearDown(ITestResult result)throws IOException  {

    if (result.getStatus() == ITestResult.FAILURE) {
        test.log(Status.FAIL, "FAILED TEST CASE: " + result.getName()); // to add name in extent report
        test.log(Status.FAIL, "FAIL LOG DETAILS: " + result.getThrowable()); // to add error/exception in extent report
  //String screenshotPath = getScreenshot(driver,  "Failed"+ result.getName());
        //String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
       // System.out.println(screenshotPath);
        //test.fail("Click image to view SCREENSHOT: ", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());//save screenshot to report
    }
    
    else if (result.getStatus() == ITestResult.SKIP) {
        test.log(Status.SKIP, "TEST CASE SKIPPED: " + result.getName());
    }
    else if (result.getStatus() == ITestResult.SUCCESS) {
        test.log(Status.PASS,"TEST CASE PASSED: " + result.getName());
    }
    System.out.println("Application run complete.");
    driver.quit();
    

}



@AfterClass
public void setReportBrowserName(){
   // extent.setSystemInfo("Browser", CheckBrowser());
    extent.setSystemInfo("Department", "QA");
    String username = System.getProperty("user.name");
    extent.setSystemInfo("Tester Name", username);
}


@AfterTest
public void endReport() {
    extent.flu*/

}

