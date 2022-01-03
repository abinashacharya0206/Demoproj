package com.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.base.BaseClass;

public class LandingPage extends BaseClass{
	
	@FindBy(linkText="Login")
	WebElement login;
	
	@FindBy(xpath="//*[@id=\"mc-EMAIL\"]")
	WebElement popupvalue;

	@FindBy(xpath="//*[@id=\"SignupForm_0\"]/div[2]/form/div[2]/input")
	WebElement subscribenewsletter;
	
	//*[@id="SignupForm_0"]/div[2]/form/div[2]/input
	//Constructor
	public LandingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void Popupenter(String email) {
		WebDriverWait wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(popupvalue));
		popupvalue.sendKeys(email);
		subscribenewsletter.click();
	}
	
	//tobeedited
	public HomePage login(String username, String password) {
		login.click();
		
		
		return new HomePage();
		
	}
}
