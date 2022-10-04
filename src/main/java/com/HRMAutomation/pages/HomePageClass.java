package com.HRMAutomation.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRMAutomation.base.BaseClasss;

public class HomePageClass extends BaseClasss {
	
	public static Actions action;
	public static JavascriptExecutor scroll= (JavascriptExecutor) driver;
	
	@FindBy(xpath="//*[@id=\'menu_admin_viewAdminModule\']/b")
	WebElement adminonmainmenubtn ;
	@FindBy(xpath="//*[@id=\'menu_admin_UserManagement\']")
	WebElement usermanagementsubmenubtn;
	@FindBy(xpath="//*[@id=\'menu_admin_viewSystemUsers\']")
	WebElement usersubsubmenubtn ;
	
	@FindBy(xpath="//*[@id=\'menu_admin_Job\']")
	WebElement jobonmainmenubtn;
	@FindBy(xpath="//*[@id=\'menu_admin_viewJobTitleList\']")
	WebElement jobtitleonsubmenu ;
	
	@FindBy(xpath="//*[@id=\'menu_admin_viewPayGrades\']")
	WebElement viewpaygrade ;
	
	@FindBy(xpath="//*[@id='menu_admin_employmentStatus']")
	WebElement employmentstatusbtn ;
	
	@FindBy(xpath="//*[@id=\"menu_admin_jobCategory\"]")
	WebElement jobcategoriesbtn ;
	
	@FindBy(xpath="//*[@id=\"menu_admin_workShift\"]")
	WebElement workshiftsbtn ;
	
	@FindBy(xpath="//*[@id='resultTable']/thead/tr/th[2]/a")
	WebElement usernamebtn;
	
	@FindBy(xpath="//*[@id=\'resultTable\']/tbody/tr[43]/td[2]/a")
	WebElement Rahulview;
	
	public HomePageClass()
	{
		//super();
		PageFactory.initElements(driver,this);
	}
	
	public void accessadminmenu()
	{
	action=new Actions(driver);
	action.moveToElement(adminonmainmenubtn).click().build().perform();
	//.moveToElement(usermanagementsubmenubtn).click().moveToElement(usersubsubmenubtn).click()
	try {
		Thread.sleep(4000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public void ScrollandClickanElement()
	{
		scroll.executeScript("arguments[0].scrollIntoView();",Rahulview );
		Rahulview.click();
	}
	
}
