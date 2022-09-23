package com.crm.pom.vtiger;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.ObjectRepository.CreateProductLookupImage;
import com.crm.ObjectRepository.CreateProductPage;
import com.crm.ObjectRepository.CreateHomePage;
import com.crm.ObjectRepository.CreateLoginPage;
import com.crm.utilityPackagee.ExcelUtility;
import com.crm.utilityPackagee.FileUtility;
import com.crm.utilityPackagee.IConstants;
import com.crm.utilityPackagee.JavaUtility;
import com.crm.utilityPackagee.WebDriverUtility;

//import net.bytebuddy.implementation.bind.annotation.FieldProxy.Binder.FieldResolver.ForGetter;

public class CreateProductTest {

	public static void main(String[] args) throws IOException {
		WebDriver driver = null;
		//create object of all utility files
		JavaUtility jlib=new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		ExcelUtility elib =new ExcelUtility();
		FileUtility flib = new FileUtility();
		
		//fetchdata from properties file
		String BROWSER = flib.getPropertyValue("browser1");
		String URL = flib.getPropertyValue("url");
		String USERNAME = flib.getPropertyValue("username");
		String PASSWORD = flib.getPropertyValue("password");
		
	//cross browser checking
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
				driver = new FirefoxDriver();
				
			}
			else
			{
				driver= new ChromeDriver();
			}
		}
		
		//maximize the window
		wlib.maximizeTheWindow(driver);
		
		//impicitlywait
		wlib.waitTillPageGetsLoad(driver);
		
		//randumnumber
		int rnum = jlib.getRandomNumber();
		
		//fetch data from excelsheet
		String pname = elib.getDataFromExcel("Product", 1,0);
		String vendor=elib.getDataFromExcel("Product",1, 0);
		
		//open the application
		
		driver.get(URL);
		//login to application
		CreateLoginPage lp = new CreateLoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
	//click on product 
		CreateHomePage hp = new CreateHomePage(driver);
		hp.getProductslink().click();
		
		//click on product lookup 
		CreateProductLookupImage cpl=new CreateProductLookupImage(driver);
		cpl.getProductlookup(driver).click();
	
		
		//input data into product 
		CreateProductPage fp = new CreateProductPage(driver);
		fp.getProductname().sendKeys(pname);
		//switch to vendorpage (child page)
		fp.SelectVendor(driver, vendor);
		
		fp.getSavetheproduct().click();
		//verify the product
		String verif = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if(verif.contains(pname))
		{
			System.out.println("product is created");
		}
		else
		{
			System.out.println("product is not created");
		}
		
		hp.logout(driver);
		//click on signout
		
	}

}
