package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.utilityPackagee.WebDriverUtility;

public class CreateSalesField extends WebDriverUtility{
//initialization
	public CreateSalesField(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//declaration
	@FindBy(xpath="//input[@name='subject']")
	private WebElement salessubject;
	
	@FindBy(xpath="(//img[@title='Select'])[1]")
	private WebElement opplookup;
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement oppsrhtxt;
	
	@FindBy(xpath="//input[@type='button']")
	private WebElement oppclick;
	
	@FindBy(xpath="(//img[@title='Select'])[3]")
	private WebElement contlookup;
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement contsrchtxt;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement contclick;
	
	@FindBy(xpath="//select[@name='carrier']")
	private WebElement carrier;
	
	@FindBy(xpath="//select[@name='sostatus']")
	private WebElement statustype;
	
	@FindBy(xpath="(//img[@title='Select'])[4]")
	private WebElement orglookup;
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement orgsrchtxt;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement orgclick;
	
	@FindBy(xpath="//textarea[@name='bill_street']")
	private WebElement billadd;
	
	@FindBy(xpath="//textarea[@name='ship_street']")
	private WebElement shipadd;
	
	@FindBy(xpath="//img[@id='searchIcon1']")
	private WebElement itmlookup;
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement itmsrchtxt;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement itmclck;
	
	@FindBy(xpath="//input[@style='width:50px']")
	private WebElement qnty;
	
	@FindBy(xpath="(//input[@style='width:70px'])[3]")
	private WebElement price;
	
	@FindBy(xpath="(//input[@style='width:70px'])[1]")
	private WebElement savesales;
	
	//utilization
	public void salessubject(WebDriver driver,String salname)
	{
		salessubject.sendKeys(salname);
	}
	
	public void SelectOppertunity(WebDriver driver, String oppname) throws InterruptedException
	{
		opplookup.click();
		Thread.sleep(3000);
		switchToWindow(driver,"Potentials&action");
		oppsrhtxt.sendKeys(oppname);
		oppclick.click();
		driver.findElement(By.xpath("//a[@href='javascript:window.close();']")).click();
		switchToWindow(driver,"SalesOrder&action");
	}
	
	public void SelectContact(WebDriver driver,String conname) throws InterruptedException
	{
		contlookup.click();
		Thread.sleep(3000);
		switchToWindow(driver,"Contacts&action");
		contsrchtxt.sendKeys(conname);
		contclick.click();
		driver.findElement(By.xpath("(//a[@href='javascript:window.close();'])[1]")).click();
		switchToWindow(driver,"SalesOrder&action");
		
	}
	
	public void SelectOrganization(WebDriver driver,String orgname) throws InterruptedException
	{
		orglookup.click();
		Thread.sleep(3000);
		switchToWindow(driver,"Accounts&action");
		orgsrchtxt.sendKeys(orgname);
		orgclick.click();
		driver.findElement(By.xpath("//a[@href='javascript:window.close();']")).click();
		switchToWindow(driver,"SalesOrder&action");
	}
	
	public void SelectItem(WebDriver driver,String itmname ) throws InterruptedException
	{
		itmlookup.click();
		Thread.sleep(3000);
		switchToWindow(driver,"Products&action");
		itmsrchtxt.sendKeys(itmname);
		itmclck.click();
		driver.findElement(By.xpath("//a[@href='javascript:window.close();']")).click();
		switchToWindow(driver,"SalesOrder&action");
	}

	public void carrier(WebDriver driver)
	{
		
		select(carrier, 2);
	}
	public void StatusType(WebDriver driver)
	{
		select(statustype, 1);
	}
	public WebElement getBilladdr()
	{
		return billadd;
	}
	
	public WebElement getShipaddr()
	{
		return shipadd;
	}
	
	public WebElement getQntty()
	{
		return qnty;
	}
	
	public void prize(WebDriver driver,String prices)
	{
		price.sendKeys(prices);
		
	}
	
	public void savesales(WebDriver driver)
	{
		savesales.click();
	}
	
	
	
	}
	

