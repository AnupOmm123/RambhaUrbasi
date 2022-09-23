package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateVendorLookUp {
	
	//initialization
	public CreateVendorLookUp(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//declaration
	@FindBy(xpath="//img[@title='Create Vendor...']")
			private WebElement createvendorlookup;
	
	//utilization
	public WebElement getCreateVendorLookup()
	{
		return createvendorlookup;
	}
}
