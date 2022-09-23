package com.crm.pom.vtiger;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.ObjectRepository.ContactTextField;
import com.crm.ObjectRepository.CreateContactLookUp;
import com.crm.ObjectRepository.CreateHomePage;
import com.crm.ObjectRepository.CreateLoginPage;
import com.crm.utilityPackagee.ExcelUtility;
import com.crm.utilityPackagee.FileUtility;
import com.crm.utilityPackagee.IConstants;
import com.crm.utilityPackagee.JavaUtility;
import com.crm.utilityPackagee.WebDriverUtility;

public class CreateContactTest {

	public static void main(String[] args) throws IOException {
		WebDriver driver=null;
		
		//create object of utility package
		JavaUtility jlib= new JavaUtility();
		ExcelUtility elib=new ExcelUtility();
FileUtility flib= new FileUtility();
WebDriverUtility wlib = new WebDriverUtility();

//fetch bdata from file utility
String BROWSER = flib.getPropertyValue("browser1");
String URL = flib.getPropertyValue("url");
String USERNAME = flib.getPropertyValue("username");
String PASSWORD = flib.getPropertyValue("password");

if(BROWSER.contains("chrome"))
{
	System.setProperty(IConstants.chromekeys, IConstants.chromevalue);
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
	{
		driver=new ChromeDriver();
	}
	
}

//maximize the browser
wlib.maximizeTheWindow(driver);

//implicitlywait
wlib.waitTillPageGetsLoad(driver);

//randum number
int rnum = jlib.getRandomNumber();

//login to application
driver.get(URL);


//fetch file from excel
String fn = elib.getDataFromExcel("Contact", 1, 0)+rnum;
String sn=elib.getDataFromExcel("Contact",1,1);
String ls=elib.getDataFromExcel("Contact",2, 2);
 
CreateLoginPage lp =new CreateLoginPage(driver);
lp.loginToApp(USERNAME, PASSWORD);

CreateHomePage hp= new CreateHomePage(driver);
hp.getContactlink();

CreateContactLookUp ccl=new CreateContactLookUp(driver);
ccl.getCreateContactLookUp();

ContactTextField ctf= new ContactTextField(driver);
ctf.fn(fn);

ctf.ln(sn);

ctf.leadsour(ls);


ctf.selorgnames(driver);
ctf.parent(driver);


String add = elib.getDataFromExcel("Contact",1,3);
driver.findElement(By.name("mailingstreet")).sendKeys(add);

driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();

String conf = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
if(conf.contains(sn))
{
	System.out.println("contact created");
	
}
else
{
	System.out.println("contact not created");
}
WebElement admin = driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
wlib.MouseOverOnElement(driver,admin);

///getting adminstration
hp.logout(driver);


	}

}
