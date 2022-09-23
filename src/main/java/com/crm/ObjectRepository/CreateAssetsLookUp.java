package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAssetsLookUp {
	
	//initialization
	public CreateAssetsLookUp(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//declaration
	@FindBy(xpath="//img[@title='Create Asset...']")
	private WebElement assetslookup;
	
	//utilization
	public WebElement getAssetslookup()
	{
		return assetslookup;
	}
	
	
	

}
