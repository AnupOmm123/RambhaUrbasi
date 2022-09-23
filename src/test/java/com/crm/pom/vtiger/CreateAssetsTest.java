package com.crm.pom.vtiger;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.crm.ObjectRepository.CreateAssetsLookUp;
import com.crm.ObjectRepository.CreateAssetsField;
import com.crm.ObjectRepository.CreateHomePage;
import com.crm.ObjectRepository.CreateLoginPage;
import com.crm.utilityPackagee.ExcelUtility;
import com.crm.utilityPackagee.FileUtility;
import com.crm.utilityPackagee.IConstants;
import com.crm.utilityPackagee.JavaUtility;
import com.crm.utilityPackagee.WebDriverUtility;

public class CreateAssetsTest {

	public static void main(String[] args) throws IOException {
		WebDriver driver = null;
		
		//create object of all utility
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		FileUtility flib = new FileUtility();
		ExcelUtility elib = new ExcelUtility();
		
		//take data from properties file
		String URL = flib.getPropertyValue("url");
		String BROWSER = flib.getPropertyValue("browser1");
		String USERNAME = flib.getPropertyValue("username");
		String PASSWORD = flib.getPropertyValue("password");
		//cross browser checking 
		if(BROWSER.contains("chrome"))
		{
			System.setProperty(IConstants.chromekeys, IConstants.chromevalue);
			driver = new ChromeDriver();
			
		}
		else
		{
			if(BROWSER.contains("firefox"))
			{
				System.setProperty(IConstants.firefoxkeys, IConstants.firefoxvalue);
				driver = new FirefoxDriver();
			}
			else
			{
				driver= new ChromeDriver();
				
			}
		}
			
		//maximaize  the window 
		wlib.maximizeTheWindow(driver);
		
		//implicitywait
		wlib.waitTillPageGetsLoad(driver);
		
		//random number
		int rnum = jlib.getRandomNumber();
		
		//fetch data from excel file 
		String slno = elib.getDataFromExcel("ASSET", 1, 0);
		String asetname = elib.getDataFromExcel("ASSET", 1, 1);
		String prname=elib.getDataFromExcel("ASSET", 1, 0);
		String invoname=elib.getDataFromExcel("ASSET", 1, 0);
		String custname=elib.getDataFromExcel("ASSET", 1, 0);
		
		//login to application 
		driver.get(URL);
		CreateLoginPage lp= new CreateLoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		//click on more option
		CreateHomePage hp=new CreateHomePage(driver);
		hp.more(driver);
		hp.getAssetslink().click();
		
		CreateAssetsLookUp al= new CreateAssetsLookUp(driver);
		al.getAssetslookup().click();
		
		CreateAssetsField fillaset = new CreateAssetsField(driver);
		fillaset.getAssetname().sendKeys(asetname);
		fillaset.getsrlnum().sendKeys(slno);
		
		fillaset.SelectProduct(driver,prname);
		fillaset.Selectinvoicename(driver, invoname);
		fillaset.Selectcustname(driver, custname);
		
		fillaset.getSaveasset().click();
		

		
		String conf = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
//		if(conf.contains(asetname))
//		{
//			System.out.println("Asset created");
//		}
//		else{
//			System.out.println("Asset not creates");
//		}
//		
		//Assert.assertTrue(conf.contains(asetname));
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(conf.contains(asetname));
		sa.assertAll();
		
		//signout
		hp.logout(driver);
		
	}

}
