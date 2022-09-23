package com.crm.pom.vtiger;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.ObjectRepository.CreateVendorLookUp;
import com.crm.ObjectRepository.CreateVendorPage;
import com.crm.ObjectRepository.CreateHomePage;
import com.crm.ObjectRepository.CreateLoginPage;
import com.crm.utilityPackagee.ExcelUtility;
import com.crm.utilityPackagee.FileUtility;
import com.crm.utilityPackagee.IConstants;
import com.crm.utilityPackagee.JavaUtility;
import com.crm.utilityPackagee.WebDriverUtility;

public class CreateVendorTest {

	public static void main(String[] args) throws IOException {
		WebDriver driver = null;
		
		
		//create object of utility files
		JavaUtility jlib=new JavaUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		ExcelUtility elib=new ExcelUtility();
		FileUtility flib=new FileUtility();
		
		//fetch data from file utility
	String BROWSER = flib.getPropertyValue("browser1");
	String URL = flib.getPropertyValue("url");
	String USERNAME = flib.getPropertyValue("username");
	String PASSWORD = flib.getPropertyValue("password");
	
	if(BROWSER.contains("chrome"))
	{
		System.setProperty(IConstants.chromekeys,IConstants.chromevalue);
	driver=new ChromeDriver();
	}
	
	else
	{
		if(BROWSER.contains("firefox"))
		{
			System.setProperty(IConstants.firefoxkeys,IConstants.firefoxvalue);
			driver=new FirefoxDriver();
		}
		else
			{driver=new ChromeDriver();
	}
	}
		
		//get randomnumber
		int rnum = jlib.getRandomNumber();
		
		//FETCH DATA FROM Excel file
		String vendor = elib.getDataFromExcel("Vendor",1, 0);
		
		//maximize the browser
				wlib.maximizeTheWindow(driver);
				
				//wait till the page get load
				wlib.waitTillPageGetsLoad(driver);
				
				//login to application
				driver.get(URL);
				
				//loginn to vtiger application
				CreateLoginPage	 lp=new CreateLoginPage(driver);
				lp.loginToApp(USERNAME, PASSWORD);
				
				
				//go to more option
				CreateHomePage hp=new CreateHomePage(driver);
				hp.more(driver);
				
				//click on vendor
				hp.getVendorslink().click();
				
				//click on vendorlookup
				CreateVendorLookUp cvp=new CreateVendorLookUp(driver);
				cvp.getCreateVendorLookup().click();
				
				//input subjectname
				CreateVendorPage fvp=new CreateVendorPage(driver);
				fvp.vendornametxtfield(vendor);
				
			driver.findElement(By.name("button")).click();
			String title = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
			if(title.contains(vendor))
			{
				System.out.println("vendor is created");
			}
			else
			{
				System.out.println("vendor is not created");
			}
			
			hp.logout(driver);
			
	
	
		

	}

}
