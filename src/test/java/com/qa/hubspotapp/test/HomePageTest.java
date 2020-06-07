package com.qa.hubspotapp.test;


import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.hubspot.utilities.AppConstants;
import com.qa.hubspot.utilities.Credentials;
import com.qa.hubspotapp.base.BasePage;
import com.qa.hubspotapp.page.HomePage;
import com.qa.hubspotapp.page.LoginPage;



public class HomePageTest{
	BasePage basePage;
	LoginPage loginPage;
	Properties prop;
	WebDriver driver;
	HomePage homePage;
	Credentials userCredent;
	
	@BeforeTest
	@Parameters(value={"browser"})
	public void setUp(String browser)
	{
		 String browserName = null;
		 basePage = new BasePage();
		 prop = basePage.init_properties();
		 if(browser.equals(null))
		 {
			 browserName = prop.getProperty("browser");
		 }
		 else
		 {
			 browserName = browser;
		 }
		 driver = basePage.init_driver(browserName);
		 driver.get(prop.getProperty("url"));
		 loginPage = new LoginPage(driver);
		 userCredent = new Credentials(prop.getProperty("username"), prop.getProperty("password"));
		 homePage = loginPage.doLogin(userCredent);
		 System.out.println("Start Executing Home Page test cases");
	}


	@Test(priority = 1)
	public void verifyHomePageTitle()
	{
		System.out.println("Start execute Test Case 1");
		String homePageTitle = homePage.getHomePageTitle();
		System.out.println("Home Page Title is: " + homePageTitle);
		Assert.assertEquals(homePageTitle, AppConstants.HomePage_PAGE_TITLE);
		System.out.println("End execute Test Case 1");
	}
	
	@Test(priority = 2)
	public void verifyContactsLinkText()
	{
		System.out.println("Start execute Test Case 2");
		String contactsLinkText = homePage.getContactsLinkText();
		System.out.println(contactsLinkText);
		Assert.assertEquals(contactsLinkText, AppConstants.CONTACTS_LINK_TEXT); 
		System.out.println("End execute Test Case 2");
	}
	
	@Test(priority = 3)
	public void verifyConversationsLinkText()
	{
		System.out.println("Start execute Test Case 3");
		String conversationsLinkText = homePage.getConversationsLinkText();
		System.out.println(conversationsLinkText);
		Assert.assertEquals(conversationsLinkText, AppConstants.CONVERSATIONS_LINK_TEXT); 
		System.out.println("End execute Test Case 3");
	}
	
	@AfterTest
	public void tearDown()
	{
		 System.out.println("End Executing Home Page test cases");
		 driver.close();
	}
	
}