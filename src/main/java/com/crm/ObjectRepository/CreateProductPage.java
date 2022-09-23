package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.utilityPackagee.WebDriverUtility;

public class CreateProductPage extends WebDriverUtility {
	
	//initialization
	public CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	//declaration
	@FindBy(xpath="//input[@name='productname']")
	private WebElement productname;
	
	@FindBy(xpath="(//img[@title='Select'])[1]")
	private WebElement vendorlookup;
	
	@FindBy(name="search_text")
	private WebElement searchname;
	
	@FindBy(xpath="//input[@type='button']")
	private WebElement clickonsearchbtn;
	
	@FindBy(xpath="(//input[@class='crmbutton small save'])[1]")
	private WebElement savetheproduct;
	
	
	//utilization
	public WebElement getProductname()
	{
		return productname;
	}
	
	
	public WebElement getVendorlookup()
	{
		return vendorlookup;
	}
	
	
	public WebElement getSearchname()
	{
		return searchname;
	}
	
	public WebElement getClickonsearchbtn()
	{
		return clickonsearchbtn;
	}
	
	public WebElement getSavetheproduct()
	{
		return savetheproduct;
	}
	
	
	public void SelectVendor(WebDriver driver, String vname)
	{
		vendorlookup.click();
		switchToWindow(driver,"Vendors&action");
		searchname.sendKeys(vname);
	clickonsearchbtn.click();
	driver.findElement(By.xpath("(//a[.='Mahendra'])[3]")).click();
	switchToWindow(driver,"Products&action");
	}
	
	
	
	
	
	
}




