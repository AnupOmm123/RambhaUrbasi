package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.utilityPackagee.WebDriverUtility;

public class ContactTextField extends WebDriverUtility {
	
	//initialization
	public ContactTextField(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//declaration
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement firstname;

	@FindBy(xpath="(//input[@type='text'])[4]")
	private WebElement lastname;
	
	@FindBy(xpath="(//img[@alt='Select'])[1]")
	private WebElement selorgname;
	
	@FindBy(xpath = "//select[@name='leadsource']")
	private WebElement leadsource;
	
	@FindBy(xpath = "(//input[@name='button'])[1]")
	private WebElement savebtn;
	
	//utilization
	
	public WebElement getFirstname()
	{
		return firstname;
	}
	
	public WebElement getLastname()
	{
		return lastname;
	}
	
	public WebElement getSElOrgname()
	{
		return selorgname;
	}
	
	public  WebElement getLeadsource()
	{
		return leadsource;
	}
	
	public WebElement  getSaveBtn()
	{
		return savebtn;
		
	}
	
	public void selorgnames(WebDriver driver)
	{
		switchToWindow(driver,"Accounts&action");
		
	}
	public void parent(WebDriver driver)
	{
		switchToWindow(driver,"Contacts&action");
	}
	public void leadsour(String ls1)
	{
		select(leadsource, ls1);
	}
	
	public void fn(String fn1)
	{
		firstname.sendKeys(fn1);
	}
	
	public void ln(String ln1)
	{
		lastname.sendKeys(ln1);
	}
}
