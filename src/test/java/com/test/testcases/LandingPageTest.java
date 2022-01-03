package com.test.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.base.BaseClass;
import com.test.pages.LandingPage;

public class LandingPageTest extends BaseClass{
	
	LandingPage lp;

	public LandingPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialize();
		lp=new LandingPage();
	}
	
	@Test
	public void landingpagetest() {
		
		lp.Popupenter(prop.getProperty("email"));
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
}
