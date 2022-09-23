package com.crm.utilityPackagee;

import java.awt.event.ActionEvent;
import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	/**
	 * this method is used to maximize the browser 
	 * @param driver
	 */
	public void maximizeTheWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
		
	}
	
	/**
	 * this method is used minimize the browser
	 * @param driver
	 */
	public void minimizeTheBrowser(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * this method is used to refresh the page
	 * @param driver
	 */
	public void refreshTHeBrowser(WebDriver driver)
	{
		driver.navigate().refresh();
	}

	/**
	 * this method is use to get back to the previous page
	 * @param driver
	 */
	public void backToPreviousPage(WebDriver driver)
	{
		driver.navigate().back();
	}
	
	
	/**
	 * to get forward to the next page
	 * @param driver
	 */
	public void forwardToNextPage(WebDriver driver)
	{
		driver.navigate().forward();
	}
	
	/**
	 * this method will wait till the page gets loaded
	 * @param driver
	 */
	
	public void waitTillPageGetsLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IConstants.implicityWaitDuration));
		
	}
	
	/**
	 * this method will wait element to click
	 * @param driver
	 * @param element
	 */
	public void waitTillUntillElementTOVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(IConstants.explicitlyWaitDuration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * this method will wait till element is visible
	 * @param driver
	 * @param element
	 */
	public void waitTillElementToVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(IConstants.explicitlyWaitDuration));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
/**
 * this method will wait for tittle of the page
 * @param driver
 * @param title
 */
	public void waitTillPageLoadTitleDriver(WebDriver driver,String title)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(IConstants.explicitlyWaitDuration));
		wait.until(ExpectedConditions.titleContains(title));
	}
	
	/**
	 * this method will wait untill the page url is loaded
	 * @param driver
	 * @param URL
	 */
		public void waitTillPageLoadURL(WebDriver driver, String URL)
		{
			WebDriverWait wait= new WebDriverWait(driver,  Duration.ofSeconds(IConstants.explicitlyWaitDuration));
			wait.until(ExpectedConditions.urlContains(URL));
		}
		
		/**
		 * this method will ignore the nosuchelement exception for the particular webelement
		 * @param driver
		 */
		public void ignoreNoSuchElementException(WebDriver driver)
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IConstants.explicitlyWaitDuration));
			wait.ignoring(NoSuchElementException.class);
		}
		
		/**
		 * this method will wait till the alert message to be visible
		 * @param driver
		 */
		
		public void waitForAlertMsg(WebDriver driver)
		{
			WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(IConstants.explicitlyWaitDuration));
			wait.until(ExpectedConditions.alertIsPresent());
		}
		
		
		/**
		 * this method is used to switch to frame using index
		 * @param driver
		 * @param index
		 */
		public void switchToFrame(WebDriver driver,int index )
		{
			driver.switchTo().frame(index);
		}
		
		
		/**
		 * this method is use to switch to frame using id
		 * @param driver
		 * @param id
		 */
		public void switchToFrame(WebDriver driver, String id)
		{
			driver.switchTo().frame(id);
		}
		
		
		/**
		 * this method is used to switch to frame using index
		 * @param driver
		 * @param element
		 */
		public void switchToFrame(WebDriver driver,WebElement element)
		{
			driver.switchTo().frame(element);
		}
		
		/**
		 * this method is used to switch to the main frame
		 * @param driver
		 */
		public void switchToMainFrame(WebDriver driver)
		{
			driver.switchTo().defaultContent();		}
		
		/**
		 * this method is used to select a element in a dropdown using index
		 * @param element
		 * @param index
		 */
		public void select(WebElement element,int index)
		{
		Select select=new Select(element);
		select.selectByIndex(index);
		}
		
		
		/**
		 * this method is used to select an element by using value
		 * @param element
		 * @param value
		 */
		public void select(WebElement element,String value)
		{
			Select select = new Select(element);
			select.selectByValue(value);
		}
		
		/**
		 * this method is used to select element in na drop down list using visible text
		 * @param text
		 * @param element
		 */
		public void select(String text, WebElement element)
		{
			Select select = new Select(element);
			select.selectByVisibleText(text);
			
		}
		
		
		/**
		 * thisn method is used to fetch all the options from dropdown
		 * @param element
		 */
		public void getAllOptionsFromDropDownList(WebElement element)
		{
			Select select = new Select(element);
			
			List<WebElement> option = select.getOptions();
			for(WebElement webElement1 : option)
			{
				String text = webElement1.getText();
				System.out.println(text);
			}
				
		}
		
		
		/**
		 * this method is used to mouseover on element usingaction class
		 * @param driver
		 * @param element
		 */
		public void MouseOverOnElement(WebDriver driver,WebElement element)
		{
			Actions action =new Actions(driver);
			action.moveToElement(element).perform();
		}
		
		
		/**
		 * this method is used to right click on the element
		 * @param driver
		 * @param element
		 */
		public void rightClick(WebDriver driver, WebElement element) 
		{
		Actions action=new Actions(driver);
		action.contextClick(element).perform();
	}
		
		/**
		 * this method is used to click on the enter button
		 * @param driver
		 */
public void ClickOnEnterKey(WebDriver driver)
{
	Actions action =new Actions(driver);
	action.sendKeys(Keys.ENTER).perform();
}

 
/**
 * this method is used to take screen shots
 * @param driver
 * @param screenShotName
 */
public void takeScreenShot(WebDriver driver,String screenShotName)
{
	TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
	File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
	File dst=new File("./screenshots/"+screenShotName+".PNG");
	try {
		FileUtils.copyFile(src, dst);
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}

/**
 * this method is used to customized the wait
 * @param driver
 */

public void waitAndClickUsingcustomWait(WebDriver driver)
{
	FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver);
	wait.pollingEvery(Duration.ofSeconds(10));
	wait.ignoring(NoSuchElementException.class);
	try 
	{
		wait.wait(10);
	} catch (Exception e) 
	{
		e.printStackTrace();
	}
}
/**
 * this method is used for custom wait
 * @param element
 * @param duration
 * @param pollingTime
 */
public void waitAndClick(WebElement element,int duration,long pollingTime)
{
	int count=0;
	while(count<duration)
	{
		try 
		{
			element.click();
			break;

		} 
		catch (Exception e) 
		{

			try
			{
				Thread.sleep(pollingTime);	
			} catch (Exception e2) 
			{
				e2.printStackTrace();
			}
			count++;
		}
	}
}
/**
 * this method is used to switch to window using title
 * @param driver
 * @param actualTitle
 */
public void switchToWindow(WebDriver driver,String actualTitle)
{
	Set<String> set = driver.getWindowHandles();
	for (String string : set) 
	{
		driver.switchTo().window(string);
		String title = driver.getTitle();
		if(title.contains(actualTitle))
		{
			break;
		}
	}
}
/**
 * this method is used to switch to window using url
 * @param actualURL
 * @param driver
 */
public void switchToWindow(String actualURL,WebDriver driver)
{
	Set<String> set = driver.getWindowHandles();
	Iterator<String> it = set.iterator();
	while(it.hasNext())
	{
		String wid = it.next();
		driver.switchTo().window(wid);
		String url=driver.getCurrentUrl();
		if(url.contains(actualURL))
		{
			break;
		}
	}
}
/**
 * this method is used to switch alert popup and accept the popup
 * @param driver
 * @param expectedMsg
 */
public void switchToAlertPopupAndAccept(WebDriver driver,String expectedMsg)
{
	Alert alert = driver.switchTo().alert();
	if(alert.getText().trim().equalsIgnoreCase(expectedMsg.trim()))
	{
		System.out.println("alert msg is verified");
	}
	else
	{
		System.out.println("alert message is not verified");
	}
	alert.accept();
}
/**
 * this method is used to switch to alert msg and dismiss
 * @param driver
 * @param expectedMsg
 */
public void switchToAlertPopupAndDismiss(WebDriver driver,String expectedMsg)
{
	Alert alert = driver.switchTo().alert();
	if(alert.getText().trim().equalsIgnoreCase(expectedMsg.trim()))
	{
		System.out.println("alert msg is verified");
	}
	else
	{
		System.out.println("alert message is not verified");
	}
	alert.dismiss();
}



}



