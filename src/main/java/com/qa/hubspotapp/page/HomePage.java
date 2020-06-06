package com.qa.hubspotapp.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.utilities.AppConstants;
import com.qa.hubspot.utilities.ElementUtil;
import com.qa.hubspot.utilities.JavaScriptUtil;
import com.qa.hubspotapp.base.BasePage;


public class HomePage extends BasePage{

	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil jsUtil;

	/**************** WebElements present on Home Page **********************/
	
	By contactsPrimaryLink = By.xpath("//ul//li[2]//a[contains(text(),'Contacts')]");
	By conversationsLink = By.linkText("Conversations");;
	By marketingLink = By.linkText("Marketing");
	By salesLink = By.linkText("Sales");
	By serviceLink = By.linkText("Service");
	By automationLink = By.linkText("Automation");
	By reportsLink = By.linkText("Reports");
	By contactsSecondaryLink = By.xpath("//*[@id='nav-secondary-contacts']");


/********************* Constructor to access the weblements and methods present on Home Page through driver reference **************/
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		elementUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
	}
	
/************************ Page Actions/Methods present on Home Page 
 * @return ************************/
	
	public String getHomePageTitle()
	{
		elementUtil.waitForPageTitle(AppConstants.HomePage_PAGE_TITLE);
		return elementUtil.doGetPageTitle();
	}
	
	public String getContactsLinkText()
	{
		elementUtil.waitForElementPresent(contactsPrimaryLink);
		return elementUtil.doGetText(contactsPrimaryLink);
	}
	
	public String getConversationsLinkText()
	{
		elementUtil.waitForElementPresent(conversationsLink);
		return elementUtil.doGetText(conversationsLink);
	}
	
	public void clickContactsLink()
	{
		elementUtil.waitForElementPresent(contactsPrimaryLink);
		elementUtil.doClick(contactsPrimaryLink);
		elementUtil.waitForElementPresent(contactsSecondaryLink);
		elementUtil.doClick(contactsSecondaryLink);
	}
	
	public ContactsPage goToContactsPage(){
		clickContactsLink();
		return new ContactsPage(driver);
	}
	
}
