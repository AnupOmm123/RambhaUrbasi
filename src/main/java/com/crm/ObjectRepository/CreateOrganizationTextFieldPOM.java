package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.utilityPackagee.WebDriverUtility;

public class CreateOrganizationTextFieldPOM extends WebDriverUtility {

	//initialization
	public CreateOrganizationTextFieldPOM(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//declaration

	@FindBy(xpath="//input[@name='accountname']")
	private WebElement accountnamee;


	@FindBy(xpath="//select[@name='industry']")
	private WebElement industry;

	@FindBy(xpath="//select[@name='accounttype']")
	private WebElement type;

	@FindBy(xpath="(//input[@class='crmbutton small save'])[1]")
	private WebElement savebtn;



	//utilization
	public WebElement getAccountnamee()
	{
		return accountnamee;
	}

	public WebElement getSavebtn()
	{
		return savebtn;
	}

	public WebElement getIndustry()
	{
		return industry;
	}

	public WebElement getType()
	{
		return type;
	}
	public void orgcreate(String orgname1)
	{
		accountnamee.sendKeys(orgname1);
	}
	public void industryDDL(String indname)

	{
		select(industry, indname);
	}
	public void typeDDL(String type1)
	{
		select(type, type1);
	}
}