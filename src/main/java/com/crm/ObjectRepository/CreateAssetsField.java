package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.utilityPackagee.WebDriverUtility;

public class CreateAssetsField extends WebDriverUtility {
	
	//initialization
	public CreateAssetsField(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//declaration
	@FindBy(xpath="//input[@name='serialnumber']")
	private WebElement srlnum;
	
	@FindBy(xpath="//select[@name='assetstatus']")
	private WebElement assetstatus;
	
	@FindBy(xpath="(//img[@title='Select'])[1]")
	private WebElement prodlookup;
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement prodsrch;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement prodsearchclick;
	
	@FindBy(xpath="(//img[@title='Select'])[2]")
	private WebElement invoicelookup;
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement invoicessrch;
	
	@FindBy(xpath="//input[@type='button']")
	private WebElement invoiceclck;
	
	@FindBy(xpath="(//img[@title='Select'])[3]")
	private WebElement custlookup;
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement custsrchtxt;
	
	@FindBy(xpath="//input[@type='button']")
	private WebElement custclick;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveasset;
	
	
	@FindBy(xpath="(//input[@class='detailedViewTextBox'])[6]")
	private WebElement assetname;
	
	//utilization
	public WebElement getsrlnum()
	{
		return srlnum;
	}
	
	public void assetstatus(WebDriver driver )
	{
		assetstatus.click();
		select("(//input[@title='Save [Alt+S]'])[1]", assetstatus);
	}
	
	public void SelectProduct(WebDriver driver, String proname)
	{
		prodlookup.click();
		switchToWindow(driver,"Products&action");
		prodsrch.sendKeys(proname);
		prodsearchclick.click();
		driver.findElement(By.xpath("(//a[.='mobile'])[2]")).click();
		switchToWindow(driver, "Assets&action");
	}
	
	public void Selectinvoicename(WebDriver driver, String invoname)
	{
		invoicelookup.click();
		switchToWindow(driver, "Invoice&action");
		invoicessrch.sendKeys(invoname);
		invoiceclck.click();
		driver.findElement(By.xpath("//a[.='001']")).click();
		switchToWindow(driver, "Assets&action");
	}
	
	public void Selectcustname(WebDriver driver, String custname)
	{
		custlookup.click();
		switchToWindow(driver,"Accounts&action");
		custsrchtxt.sendKeys(custname);
		custclick.click();
		driver.findElement(By.xpath("//a[.='Britania']")).click();
		switchToWindow(driver, "Assets&action");
	}
	
	public WebElement getAssetname()
	{
		return assetname;
	}
	
	public WebElement getSaveasset()
	{
		return saveasset;
	}

}
