package com.crm.pom.vtiger;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.ObjectRepository.CreateOppertunityPage;
import com.crm.ObjectRepository.CreateHomePage;
import com.crm.ObjectRepository.CreateLoginPage;
import com.crm.ObjectRepository.CreateOppertunityLookup;
import com.crm.utilityPackagee.ExcelUtility;
import com.crm.utilityPackagee.FileUtility;
import com.crm.utilityPackagee.IConstants;
import com.crm.utilityPackagee.JavaUtility;
import com.crm.utilityPackagee.WebDriverUtility;

public class CreateOppertunitiesTest {

	public static void main(String[] args) throws EncryptedDocumentException, FileNotFoundException, IOException {
		WebDriver driver = null;
		
		//create object of all utilities class
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		ExcelUtility elib = new ExcelUtility();
		FileUtility flib = new FileUtility();
		
		// fetch data from file path
		String BROWSER=flib.getPropertyValue("browser1");
		String URL = flib.getPropertyValue("url");
		String USERNAME = flib.getPropertyValue("username");	
		String PASSWORD = flib.getPropertyValue("password");
		
		//crossbrowser testing 
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
			
		
		//maximize the window
		wlib.maximizeTheWindow(driver);
		
		//implicitlywait
		wlib.waitTillPageGetsLoad(driver);
		
		//randomnumber
		int enumb = jlib.getRandomNumber();
		
		//fetch datafrom excelsheet
String opname = elib.getDataFromExcel("Oppertunity", 1, 0);

//open the page
driver.get(URL);
CreateLoginPage lp = new CreateLoginPage(driver);
lp.loginToApp(USERNAME, PASSWORD);
//click on oppertunitiy link
CreateHomePage hp = new CreateHomePage(driver);
hp.getOpportunitieslink().click();


//click on oppertunity look up image
CreateOppertunityLookup opplookup = new CreateOppertunityLookup(driver);
opplookup.getOppertunity().click();

//write org name
CreateOppertunityPage fop= new CreateOppertunityPage(driver);
fop.getOppname().sendKeys(opname);
fop.relatedtolookup(driver, opname);
fop.leadsource(driver);
fop.selecttype(driver);
fop.Selectcampaign(driver, opname);
fop.getSaveoppertunity().click();


//verify oppertumity is created or not
String conf = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
if(conf.contains(opname))
{
	System.out.println("oppertunity created");
}
else
{
	System.out.println("oppertunity is not created");
}


		
		//click on signout
hp.logout(driver);		


		}

}
