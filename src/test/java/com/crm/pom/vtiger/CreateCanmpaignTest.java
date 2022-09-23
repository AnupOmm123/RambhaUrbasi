package com.crm.pom.vtiger;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.ObjectRepository.CreateCampaignLookup;
import com.crm.ObjectRepository.CreateCampaignPage;
import com.crm.ObjectRepository.CreateHomePage;
import com.crm.ObjectRepository.CreateLoginPage;
import com.crm.utilityPackagee.ExcelUtility;
import com.crm.utilityPackagee.FileUtility;
import com.crm.utilityPackagee.IConstants;
import com.crm.utilityPackagee.JavaUtility;
import com.crm.utilityPackagee.WebDriverUtility;

public class CreateCanmpaignTest {

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
String campname = elib.getDataFromExcel("Campaign", 1, 0);

//open the page
driver.get(URL);
CreateLoginPage lp = new CreateLoginPage(driver);
lp.loginToApp(USERNAME, PASSWORD);

//click on menu 
CreateHomePage hp = new CreateHomePage(driver);
hp.more(driver);
//click on campaign
hp.getCampaignslink().click();

//click on campaign look up
CreateCampaignLookup camplook=new CreateCampaignLookup(driver);
camplook.getCampaignlookup().click();
//input data in campaign page
CreateCampaignPage fillcamp=new CreateCampaignPage(driver);
fillcamp.getCampaignname().sendKeys(campname);
fillcamp.getProductlookup().click();
fillcamp.SelectProduct(driver, campname);

//choose campigntype
WebElement ctype = driver.findElement(By.xpath("//select[@name='campaigntype']"));
wlib.getAllOptionsFromDropDownList(ctype);
elib.getDataFromExcel("Campaign", 1, 1);


//choose campaign status
WebElement cstatus=driver.findElement(By.xpath("//select[@name='campaignstatus']"));
wlib.getAllOptionsFromDropDownList(cstatus);
elib.getDataFromExcel("Campaign", 2, 2);

//save the campaign
fillcamp.getSavecampaignbtn().click();

//confirmation campaign is created or no
String conf=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
if(conf.contains(campname))
{
	System.out.println("Campaign created");
}
else
{
	System.out.println("campaign is not created");
}


		//click on signout
		hp.logout(driver);

	}

}
