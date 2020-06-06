package com.qa.hubspotapp.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.utilities.AppConstants;
import com.qa.hubspot.utilities.ElementUtil;
import com.qa.hubspot.utilities.JavaScriptUtil;
import com.qa.hubspotapp.base.BasePage;

public class DealsPage extends BasePage{
	
	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil jsUtil;
	
	
	
	/*************************** Web Elements of Deals Page ****************************/
	//locators- By
		By username = By.xpath("//*[@id='username']");
		By password = By.id("password");
		By loginBtn = By.id("loginBtn");
		By signUpLink = By.linkText("Sign up");



	/**************************** Constructor to initialize the driver to access the locators and methods present in Login Page *********/
	public DealsPage(WebDriver driver)
	{
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
	}
	
	/**************************** Page Actions/Methods present in Deals Page ****************************/

}
