package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOppertunityLookup {
	
	//initialization
	public CreateOppertunityLookup(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//declaration
	@FindBy(xpath="//img[@title='Create Opportunity...']")
	private WebElement oppertunitylookup;
	
	//utilization
	public WebElement getOppertunity()
	{
		return oppertunitylookup;
	}
	
	

}
