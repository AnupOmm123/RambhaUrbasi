package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.utilityPackagee.WebDriverUtility;

public class CreateProductLookupImage {
	
	//initialization
	public CreateProductLookupImage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	
	//declaration
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement productlookup;
	
	//utilization
	public WebElement getProductlookup(WebDriver driver)
	{
		
	return productlookup;
	}
}


