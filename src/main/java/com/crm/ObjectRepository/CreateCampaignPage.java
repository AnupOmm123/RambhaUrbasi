package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.utilityPackagee.WebDriverUtility;

public class CreateCampaignPage extends WebDriverUtility{

	//initialization
	public CreateCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//declaration
	@FindBy(xpath="//input[@name='campaignname']")
	private WebElement campaignname;
	
	@FindBy(xpath="//img[@title='Select']")
	private WebElement productlookup;
	
	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement searchbox;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement clickonsearchbox;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement savecampaignbtn;
	
	//utilization
	public WebElement getCampaignname()
	{
		return campaignname;
	
	}
	
	public WebElement getProductlookup()
	{
		return productlookup;
	}
	
	public WebElement getSearchbox()
	{
		return searchbox;
	}
	
	public WebElement getClickonsearchbox()
	{
		return clickonsearchbox;
	}
	
	public WebElement getSavecampaignbtn()
	{
		return savecampaignbtn;
	}
	
	public void SelectProduct(WebDriver driver, String pname)
	{
		productlookup.click();
		switchToWindow(driver,"Products&action");
		searchbox.sendKeys(pname);
		clickonsearchbox.click();
		driver.findElement(By.xpath("(//a[.='mobile'])[2]")).click();
		switchToWindow(driver,"Campaigns&action");
		
	}
	
	
	
	
}
