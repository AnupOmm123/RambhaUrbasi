package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.WebDriverListener;

import com.crm.utilityPackagee.WebDriverUtility;

public class CreateHomePage extends WebDriverUtility {

	//initialisation
	public CreateHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//declaration
	@FindBy(xpath="(//a[.='Organizations'])[1]")
	private WebElement organisationlink;
	
	@FindBy(xpath="//a[.='Contacts']")
	private WebElement contactlink;
	
	@FindBy(xpath="//a[.='Products']")
	private WebElement productslink;
	
	@FindBy(xpath="//a[.='Email']")
	private WebElement emaillink;
	
	@FindBy(xpath="(//a[.='Opportunities'])[1]")
	private WebElement opportunitieslink;
	
	@FindBy(xpath="//a[.='Documents']")
	private WebElement documentslink;
	
	@FindBy(xpath="(//a[@href='javascript:;'])[1]")
	private WebElement morelink;
	
	@FindBy(xpath="//a[.='Sales Order']")
	private WebElement salesorderlink;
	
	@FindBy(xpath="//a[.='Invoice']")
	private WebElement invoicelink;
	
	@FindBy(xpath="//a[.='Vendors']")
	private WebElement vendorslink;
	
	@FindBy(xpath="//a[.='Assets']")
	private WebElement assetslink;
	
	@FindBy(xpath="//a[.='Campaigns']")
	private WebElement campaignslink;
	

	
	@FindBy(xpath="(//img[@style='padding: 0px;padding-left:5px'])[1]")
	private WebElement administatorlink;
	
	@FindBy(xpath="//a[.='Sign Out']")
	private WebElement signoutlink;
	
	
	//utilization
	public WebElement getOrganisationlink()
	{
		return organisationlink;
	}
	
	public WebElement getContactlink()
	{
		return contactlink;
	
	}
	
	public WebElement getProductslink()
	{
		return productslink;
	}
	public WebElement getEmaillink()
	{
		return emaillink;
	}
	
	public WebElement getOpportunitieslink()
	{
		return opportunitieslink;
	}
	
	public WebElement getDocumentslink()
	{
		return documentslink;
	}
	
	public WebElement getMorelink()
	{
		return morelink;
	}
	
	public WebElement getSalesOrderlink()
	{
		return salesorderlink;
	
	}
	
	public WebElement getInvoicelink()
	{
		return invoicelink;
	}
	
	public WebElement getVendorslink()
	{
		return vendorslink;
	}
	
	public WebElement getAssetslink()
	{
		return assetslink;
	}
	
	public WebElement getCampaignslink()
	{
		return campaignslink;
	}
	
	public WebElement getAdministrationlink()
	{
		return administatorlink;
	}
	
	public WebElement getsignoutlink()
	{
		return signoutlink;
	}
	
	//utilization in nonstatic method
	public void more(WebDriver driver)
	{
		MouseOverOnElement(driver,morelink);
	}
	
	public void logout(WebDriver driver)
	{
		MouseOverOnElement(driver , administatorlink);
		signoutlink.click();
		
	}
}
