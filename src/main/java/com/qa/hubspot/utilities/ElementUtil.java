package com.qa.hubspot.utilities;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspotapp.base.BasePage;

public class ElementUtil extends BasePage{
	WebDriver driver;
	WebDriverWait wait;
	JavaScriptUtil jsUtil;
	Properties prop;
	
	public ElementUtil(WebDriver driver)
	{
		this.driver=driver;
		wait = new WebDriverWait(driver, AppConstants.DEFAULT_TIME_OUT);
		jsUtil = new JavaScriptUtil(driver);
	}
	
	/**
	 * wait for an element to be present in the web page
	 * @param locator
	 * @return true if element is present else false
	 */
	public boolean waitForElementPresent(By locator)
	{
		try
		{
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return true;
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Some exception got occured while locating the web element");
		}
		return false;
	}
	
	public boolean waitForPageTitle(String title)
	{
		try
		{
		wait.until(ExpectedConditions.titleIs(title));
		return true;
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Some exception got occured while fetching the current web page title");
		}
		return false;
	}
	
	
	/**
	 * this method is used to create the web element using By locator
	 * @param locator
	 * @return "web element" if element is successfully created, if not will return "null"
	 */
	public WebElement getWebElement(By locator)
	{
		WebElement element = null;
		try{
			 element = driver.findElement(locator);	
			if(highlightElement){
				jsUtil.flash(element);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Some exception got occured while creating the web element");
		}
		return element;
		
	}
	
	/**
	 * this method is used to click any link/button
	 * @param locator
	 */
	public void doClick(By locator)
	{
		try{
		getWebElement(locator).click();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Some exception got occured while clicking the web element");
		}
	}
	
	/**
	 * this method is used to enter the text in the text field
	 * @param locator
	 * @param text
	 */
	public void doSendKeys(By locator, String text)
	{
		try
		{
		WebElement ele = getWebElement(locator);
		ele.clear();
		ele.sendKeys(text);
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("Some exception got occured while entering the text in the field");
	}
	}
	
	/**
	 * this method is used to check that the web element is displayed on the web page
	 * @param locator
	 * @return true if element is displayed else false
	 */
	public boolean doIsDisplayed(By locator)
	{
		boolean isDisplayed = false;
		try
		{
		 isDisplayed = getWebElement(locator).isDisplayed();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Some exception got occured when locate the web element");
		}
		return isDisplayed;
	}
	
	/**
	 * this method is used to check that the web element is enabled on the web page
	 * @param locator
	 * @return true if element is enabled else false
	 */
	public boolean doIsEnabled(By locator)
	{
		boolean isEnabled = false;
		try
		{
			isEnabled = getWebElement(locator).isEnabled();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Some exception got occured when locate the web element");
		}
		return isEnabled;
	}
	
	/**
	 * this method is used to check that the web element is selected on the web page
	 * @param locator
	 * @return true if element is selected else false
	 */
	public boolean doIsSelected(By locator)
	{
		boolean isSelected = false;
		try
		{
			isSelected = getWebElement(locator).isEnabled();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Some exception got occured when locate the web element");
		}
		return isSelected;
	}
	
	/**
	 * this method is used to fetch the content/text from the web element
	 * @param locator
	 * @return String(Text) of an element
	 */
	public String doGetText(By locator)
	{
		String eleText = null;
		try
		{
			 eleText = getWebElement(locator).getText();
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Some exception got occured while fetch the text from the web element");
		}
		return eleText;
	}

	/**
	 * this method is used to fetch the title of the web page
	 * @param locator
	 * @return title of the page
	 */
	public String doGetPageTitle()
	{
		String pageTitle = null;
		try{
		 pageTitle =  driver.getTitle();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Some exception got occured when fetch the title of the web page");
		}
		return pageTitle;
	}
}
