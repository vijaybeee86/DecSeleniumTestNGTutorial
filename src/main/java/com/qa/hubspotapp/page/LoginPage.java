package com.qa.hubspotapp.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.utilities.AppConstants;
import com.qa.hubspot.utilities.Credentials;
import com.qa.hubspot.utilities.ElementUtil;
import com.qa.hubspot.utilities.JavaScriptUtil;
import com.qa.hubspotapp.base.BasePage;


public class LoginPage extends BasePage{
	
	 WebDriver driver;
	 ElementUtil elementUtil;
	 JavaScriptUtil jsUtil;
	
	
/*************************** Web Elements of Login Page ****************************/
	//locators- By
By username = By.xpath("//*[@id='username']");
By password = By.id("password");
By loginBtn = By.id("loginBtn");
By signUpLink = By.linkText("Sign up");



/**************************** Constructor to initialize the driver to access the locators and methods present in Login Page *********/

public LoginPage(WebDriver driver)
{
	this.driver=driver;
	elementUtil = new ElementUtil(driver);
	jsUtil = new JavaScriptUtil(driver);
}


/**************************** Page Actions/Methods present in Login Page 
 * @return ****************************/

/*public String getLoginPageTitle()
{
	elementUtil.waitForPageTitle(AppConstants.LOGIN_PAGE_TITLE);
	return elementUtil.doGetPageTitle();
}*/

public String getLoginPageTitleUsingJS()
{
	return jsUtil.getTitleByJS();
}

public boolean checkSignUpLink()
{
	elementUtil.waitForElementPresent(signUpLink);
	return elementUtil.doIsDisplayed(signUpLink);
}

public HomePage doLogin(Credentials userCredentials)
{
	elementUtil.waitForElementPresent(username);
	elementUtil.doSendKeys(username, userCredentials.getAppUserName());
	elementUtil.doSendKeys(password, userCredentials.getAppPassword());
	elementUtil.doClick(loginBtn);

    return new HomePage(driver);
}

}
