package com.qa.hubspotapp.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.utilities.AppConstants;
import com.qa.hubspot.utilities.ElementUtil;
import com.qa.hubspot.utilities.JavaScriptUtil;
import com.qa.hubspotapp.base.BasePage;

public class ContactsPage extends BasePage{

	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil jsUtil;

	/**************** WebElements present on Home Page **********************/
	
	By createContactButton = By.xpath("//*[contains(text(),'Create contact')]");
	By email = By.xpath("//*[@data-field='email']");;
	By firstName = By.xpath("//*[@data-field='firstname']");
	By lastName = By.xpath("//*[@data-field='lastname']");
	By jobTitle = By.xpath("//*[@data-field='jobtitle']");
	By createContactFormButton = By.xpath("//*[@data-selenium-test='base-dialog-confirm-btn']");



/********************* Constructor to access the weblements and methods present on Contacts Page through driver reference **************/
	
	public ContactsPage(WebDriver driver)
	{
		this.driver=driver;
		elementUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
	}
	
/************************ Page Actions/Methods present on Home Page 
 * @return ************************/
	
	public String getContactsPageTitle()
	{
		elementUtil.waitForPageTitle(AppConstants.CONTACTS_PAGE_TITLE);
		return elementUtil.doGetPageTitle();
	}
	
	
	public void createContact(String emailId, String FN, String LN, String jobTitl)
	{
		elementUtil.waitForElementPresent(createContactButton);
		elementUtil.doClick(createContactButton);
		elementUtil.waitForElementPresent(email);
		elementUtil.doSendKeys(email, emailId);
		elementUtil.doSendKeys(firstName, FN);
		elementUtil.doSendKeys(lastName, LN);
		elementUtil.doSendKeys(jobTitle, jobTitl);
		elementUtil.doClick(createContactFormButton);
		
	}
}
