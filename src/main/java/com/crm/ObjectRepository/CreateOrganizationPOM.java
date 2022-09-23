package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPOM {

	
	//initialization 
	public CreateOrganizationPOM(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//declaration
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement organizationlookup;
	
	
	//utilization
	public WebElement getOrganizationLookup()
	{
		return organizationlookup;
	}
	
	
	
}
