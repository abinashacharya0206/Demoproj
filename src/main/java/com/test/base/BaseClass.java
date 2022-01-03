package com.test.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.test.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;

	
	//Constructor
	public BaseClass() {
		try {
			prop=new Properties();
			FileInputStream fi=new FileInputStream("C:\\Users\\JAJNASENI ACHARYA\\eclipse-workspace\\Demoproj\\src\\main\\java\\com\\test\\config\\config.file");
			prop.load(fi);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}

	}

	public static void initialize() {

		String browser=prop.getProperty("browser");
		
		if(browser.equals("chrome")) {
		WebDriverManager.chromedriver().browserVersion("88.0.4324.104").setup();
		
		driver=new ChromeDriver();
		}
//		else if(browser.equals("IE")) {
//			WebDriverManager.iedriver().browserVersion("").setup();
//			
//			driver=new InternetExplorerDriver();
//			}
//		else if(browser.equals("FF")) {
//			WebDriverManager.firefoxdriver().browserVersion("").setup();
//			
//			driver=new FirefoxDriver();
//			}
//		else {
//			System.out.println("Error!! Please provide a compatible browser");
//		}
		driver.manage().timeouts().pageLoadTimeout(TestUtil.pageloadtime, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicitwaittime,TimeUnit.SECONDS );
		
		driver.get(prop.getProperty("url")) ;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.pageloadtime, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicitwaittime,TimeUnit.SECONDS );
		
	}
	



}
