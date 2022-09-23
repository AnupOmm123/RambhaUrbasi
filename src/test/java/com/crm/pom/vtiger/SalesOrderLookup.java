package com.crm.pom.vtiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesOrderLookup {
	
	//initialization
	public SalesOrderLookup(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//declaration
	@FindBy(xpath="//img[@alt='Create Sales Order...']")
	private WebElement saleslookup;
	
	//utilization
	public WebElement getSaleslookup()
	{
		return saleslookup;
		
	}

}
