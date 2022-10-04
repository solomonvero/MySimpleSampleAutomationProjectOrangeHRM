package com.HRMAutomation.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.HRMAutomation.base.BaseClasss;

public class LoginPageClass extends BaseClasss{
	
	//PageFactory OR

	@FindBy(name="username")
	WebElement usernamebtn;
	@FindBy(name="password")
	WebElement passwordbtn;
	@FindBy(xpath="//*[@id=\'app\']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
	WebElement loginbtn;
	@FindBy(xpath="//*[@id=\'app\']/div[1]/div/div[1]/div/div[2]/div[1]/img")
	WebElement Logo;
	@FindBy(xpath="//*[@id=\'app\']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[4]/p")
	WebElement forgotpasswordbtn;
	@FindBy(xpath="//*[@id=\'app\']/div[1]/div[1]/div/form/div[1]/div/div[2]/input")
	WebElement resetbuttonenterusername;
	@FindBy(xpath="//*[@id=\'app\']/div[1]/div[1]/div/form/div[1]/div/div[2]/input")
	WebElement resetpasswordbutton;
	@FindBy(xpath="//*[@id=\'app\']/div[1]/div[1]/div/form/div[2]/button[1]")
	WebElement cancelbutton;
	@FindBy(xpath="//*[@id=\'app\']/div[1]/div[1]/div/h6")
	WebElement resetsuccessmessage;
	@FindBy(xpath="//*[@id=\'logInPanelHeading\']")
	WebElement loginpagepanel;
	
	public LoginPageClass()  {
		//super();
		PageFactory.initElements(driver,this);
	}
   
public boolean OrangeHRMLogo()
{
	return Logo.isDisplayed();
}

public String PageTitle()
{
	return driver.getTitle();
}

public WebElement Successful_Password_Reset(String usernametoreset)
{
	forgotpasswordbtn.click();
	resetbuttonenterusername.sendKeys(usernametoreset);
	resetpasswordbutton.click();
	return resetsuccessmessage; 
}



public HomePageClass LoginPage(String uname,String asword)
{
	usernamebtn.clear();
	usernamebtn.sendKeys(uname);
	passwordbtn.clear();
	passwordbtn.sendKeys(asword);
	loginbtn.click();
	return new HomePageClass();
}

public WebElement Cancel_Password_Reset() {
	// TODO Auto-generated method stub
	forgotpasswordbtn.click();
	resetbuttonenterusername.click();
	cancelbutton.click();
	return loginpagepanel;
}

}
