package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateLoginPage {
	
	//initialisation
	public CreateLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//declaration
	@FindBy(xpath="//input[@type='text']")
	private WebElement usernameedit;
	
	@FindBy(xpath="//input[@name='user_password']")
	private WebElement passwordedit;
	
	
	@FindBy(id="submitButton")
	private WebElement submitbtn;
	
	//utilization (create business libraries)
public WebElement getusernameeditElement()
{
	return usernameedit;
	
}

public WebElement getpasswordedit()
{
	return passwordedit;
}

public WebElement getsubmitbtn()
{
	return submitbtn;
}

public void loginToApp(String username,String password)
{
	usernameedit.sendKeys(username);
	passwordedit.sendKeys(password);
	submitbtn.click();
	
}


}
