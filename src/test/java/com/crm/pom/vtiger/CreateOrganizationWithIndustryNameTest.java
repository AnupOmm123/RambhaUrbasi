package com.crm.pom.vtiger;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.crm.ObjectRepository.CreateOrganizationPOM;
import com.crm.ObjectRepository.CreateOrganizationTextFieldPOM;
import com.crm.ObjectRepository.CreateHomePage;
import com.crm.ObjectRepository.CreateLoginPage;
import com.crm.utilityPackagee.ExcelUtility;
import com.crm.utilityPackagee.FileUtility;
import com.crm.utilityPackagee.IConstants;
import com.crm.utilityPackagee.JavaUtility;
import com.crm.utilityPackagee.WebDriverUtility;

public class CreateOrganizationWithIndustryNameTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver=null;
		
		//crete object of utility package
		JavaUtility jlib= new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		ExcelUtility elib = new ExcelUtility();
		FileUtility flib = new FileUtility();
		
		//fetch data from fileutility 
		String BROWSER=flib.getPropertyValue("browser1");
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
			
			//fetch data from excel file
			String org = elib.getDataFromExcel("Organization", 1, 0)+rnum;
			String indt = elib.getDataFromExcel("Organization",3, 1);
			String tddl = elib.getDataFromExcel("Organization", 4, 2);
			
		
			
			//maximize the browser
		wlib.maximizeTheWindow(driver);
		
		//wait till the page get load
		wlib.waitTillPageGetsLoad(driver);
		
		//login to application
		driver.get(URL);
		
		
		//loginn to vtiger application
		CreateLoginPage loginpage=new CreateLoginPage(driver);
		loginpage.loginToApp(USERNAME, PASSWORD);
		
		//create organization
		CreateHomePage homepage = new CreateHomePage(driver);
		homepage.getOrganisationlink();
		
		//click on org lookup
		CreateOrganizationPOM cop = new CreateOrganizationPOM(driver);
		cop.getOrganizationLookup();
		
		//fill the data in org field
		CreateOrganizationTextFieldPOM coptfield=new CreateOrganizationTextFieldPOM(driver);
		
		// select industry ddl
		coptfield.industryDDL(indt);
		
		// select type
		coptfield.typeDDL(tddl);
		
		
	
		//save btn
		coptfield.getSavebtn().click();
		
		
		
		
		String conf = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(conf.contains(org))
		{
			System.out.println("organization created");
			
		}
		else
		{
			System.out.println("organization is not created");
			
		}
		//getting adminstration
		homepage.logout(driver);
	}
	

}
