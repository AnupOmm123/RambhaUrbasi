package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactLookUp {
	
	//initialization
	public CreateContactLookUp(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	
	//declaration
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement createcontactlookup;

	//utilization
	public WebElement getCreateContactLookUp()
	{
		return createcontactlookup;
	}
}


