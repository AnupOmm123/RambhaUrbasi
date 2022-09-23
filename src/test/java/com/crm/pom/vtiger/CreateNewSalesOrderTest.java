package com.crm.pom.vtiger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.crm.ObjectRepository.CreateSalesField;
import com.crm.ObjectRepository.CreateHomePage;
import com.crm.ObjectRepository.CreateLoginPage;
import com.crm.utilityPackagee.ExcelUtility;
import com.crm.utilityPackagee.FileUtility;
import com.crm.utilityPackagee.IConstants;
import com.crm.utilityPackagee.JavaUtility;
import com.crm.utilityPackagee.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNewSalesOrderTest {

	public static void main(String[] args) throws EncryptedDocumentException, FileNotFoundException, IOException, InterruptedException {
		WebDriver driver=null;
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
		String sub = elib.getDataFromExcel("SalesOrder",1, 0);
		String badd = elib.getDataFromExcel("SalesOrder",1, 0);
		String sadd = elib.getDataFromExcel("SalesOrder",1, 0);
		String qty = elib.getDataFromExcel("SalesOrder",1, 0);
		String prz = elib.getDataFromExcel("SalesOrder",1, 0);
		
		//maximize the browser
				wlib.maximizeTheWindow(driver);
				
				//wait till the page get load
				wlib.waitTillPageGetsLoad(driver);
				
				//fetch data from excel
				String subname = elib.getDataFromExcel("SalesOrder", 1,0);
				String billadd = elib.getDataFromExcel("SalesOrder", 1,1);
				String shipadd = elib.getDataFromExcel("SalesOrder", 1,2);
				
				String qnty = elib.getDataFromExcel("SalesOrder", 1,3);
				String oppertunity = elib.getDataFromExcel("SalesOrder", 1,5);
				String orgname = elib.getDataFromExcel("SalesOrder", 1,7);
				String contname = elib.getDataFromExcel("SalesOrder", 1,6);
				String price = elib.getDataFromExcel("SalesOrder", 1,4);
				String prodname = elib.getDataFromExcel("SalesOrder", 1,8);
				//elib.getDataFromExcel("SalesOrder", 0,1);
				
				
				
				
				//loginn to vtiger application
				driver.get(URL);
				CreateLoginPage lp= new CreateLoginPage(driver);
				lp.loginToApp(USERNAME, PASSWORD);
				
				//go to more option
				CreateHomePage hp= new CreateHomePage(driver);
				hp.more(driver);
				
				hp.getSalesOrderlink().click();
				
				SalesOrderLookup slook=new SalesOrderLookup(driver);
				slook.getSaleslookup().click();
				
				CreateSalesField fsale=new CreateSalesField(driver);
				fsale.salessubject(driver, subname);
				
				fsale.SelectOppertunity(driver, oppertunity);
				
				fsale.SelectContact(driver, contname);
				fsale.carrier(driver);
				fsale.StatusType(driver);
				
				fsale.SelectOrganization(driver, orgname);
				
				fsale.getBilladdr().sendKeys(billadd);
				fsale.getShipaddr().sendKeys(shipadd);
			
				fsale.SelectItem(driver, prodname);
				
				fsale.getQntty().sendKeys(qnty);
				
				fsale.SelectOppertunity(driver, price);
				
				fsale.savesales(driver);
				
				
			
				

			
				String conf = driver.findElement(By.xpath("")).getText();
				if(conf.contains(sub))
				{
					System.out.println("sales created");
				}
				else{
					System.out.println("sales not creates");
				}
				
				//click on signout
				hp.logout(driver);

		}}
