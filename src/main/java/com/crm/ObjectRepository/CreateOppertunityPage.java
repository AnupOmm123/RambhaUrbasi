
package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.utilityPackagee.WebDriverUtility;

public class CreateOppertunityPage extends WebDriverUtility {

	//initialization
	public CreateOppertunityPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	//declaration
	
	@FindBy(xpath="//input[@name='potentialname']")
	private WebElement oppname;
	
	@FindBy(xpath="//select[@name='related_to_type']")
	private WebElement relatedto;
	
	@FindBy(xpath="(//img[@title='Select'])[1]")
	private WebElement relatedlookup;
	
	@FindBy(xpath="(//input[@type='text'])[1]")
	private WebElement searchtxt;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement clicksrchtxt;
	
	@FindBy(xpath="//select[@name='opportunity_type']")
	private WebElement selecttype;
	
	@FindBy(xpath = "//select[@name='leadsource']")
	private WebElement leadsource;
	
	@FindBy(xpath="(//img[@title='Select'])[2]")
	private WebElement campaignlookup;
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement camptextfield;
	
	@FindBy(xpath="//input[@type='button']")
	private WebElement campclick;
	
	@FindBy(xpath="(//input[@class='crmbutton small save'])[1]")
	private WebElement saveoppertunity;
	
	//utilization
	public void relatedtolookup(WebDriver driver, String cname)
	{
		select(relatedto, "Contacts" );
		relatedlookup.click();
		switchToWindow(driver,"Contacts&action");
		searchtxt.sendKeys(cname);
		clicksrchtxt.click();
		driver.findElement(By.xpath("(//a[.='Indranull moharana'])[2]")).click();
		switchToWindow(driver,"Potentials&action");
		
	}
	
	
	
	public WebElement getOppname()
	{
		return oppname;
	
	}
	
	public void selecttype(WebDriver driver)
	{
		select(selecttype, "New Business");
	}
	
	public void leadsource(WebDriver driver)
	{
		select(leadsource, "Employee");
	}
	
	public void Selectcampaign(WebDriver driver , String lastname)
	{
		campaignlookup.click();
		switchToWindow(driver,"Campaigns&action");
		camptextfield.sendKeys(lastname);
		campclick.click();
		driver.findElement(By.xpath("(//a[.='marketing'])[1]")).click();
		switchToWindow(driver,"Potentials&action");
	}
	
	public WebElement getSaveoppertunity()
	{
		return saveoppertunity;
		
	}
	
	
	
	
	
}
