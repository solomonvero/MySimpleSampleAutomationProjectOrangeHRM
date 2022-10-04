package automatingHRMtests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

//import static org.testng.Assert.assertEquals;
//import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.HRMAutomation.base.BaseClasss;
import com.HRMAutomation.pages.HomePageClass;
import com.HRMAutomation.pages.LoginPageClass;
import com.aventstack.extentreports.Status;

public class LoginPageClassTest extends BaseClasss {
	public static LoginPageClass loginPage;
	public static HomePageClass homePage;
		
	public LoginPageClassTest()
	{
		super();
	}
	
	@BeforeMethod
	public void wee()
	{
		Initialization();
		loginPage=new LoginPageClass();
		homePage =new HomePageClass();
	}
	
	
	@Test(priority=1)
	public void LoginSuccessfully()
	{
		
		homePage=loginPage.LoginPage("Admin","admin123");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test(priority=2)
	public void verifytitleokay()
	{
		String title = loginPage.PageTitle();
		Assert.assertEquals(title,"OrangeHRM");
	}
		
	@Test(priority=3)
	public void LogoisVisible()
	{
		boolean logo = loginPage.OrangeHRMLogo();	
		assertTrue(logo, "logo is displayed");
	}
		
		@Test(priority=4)
		public void Successful_Password_Reset_Test()
		{
			WebElement  returnpositivestring=loginPage.Successful_Password_Reset("Admin");
			returnpositivestring.isDisplayed();
		}
		
		@Test(priority=5)
		public void Cancel_Password_Reset_Test()
		{
			WebElement  cancelling=loginPage.Cancel_Password_Reset();
			cancelling.isDisplayed();
		}
		
		
		@Test(priority=6)
		public void AdminMenu()
		{
			loginPage.LoginPage("Admin","admin123");
			homePage.accessadminmenu();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		/*
		@Test(priority=7)
		public void TestScrollFunction()
		{
			loginPage.LoginPage("Admin","admin123");
			homePage.accessadminmenu();
			homePage.ScrollandClickanElement();
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	*/
		  
	@AfterMethod
	public void terminate()
	{
		driver.quit();
	}
		}


