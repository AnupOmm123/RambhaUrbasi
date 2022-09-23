package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateVendorPage {


	//initialization
	public CreateVendorPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//declaration
	@FindBy(xpath="//input[@name='vendorname']")
	private WebElement vendornamesubject;

	//utilization
	public void vendornametxtfield(String sub1)
	{
		vendornamesubject.sendKeys(sub1);
	}
}
