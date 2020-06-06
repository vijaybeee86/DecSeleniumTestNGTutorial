package com.qa.hubspotapp.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.utilities.AppConstants;
import com.qa.hubspot.utilities.Credentials;
import com.qa.hubspot.utilities.ExcelUtil;
import com.qa.hubspotapp.base.BasePage;
import com.qa.hubspotapp.page.ContactsPage;
import com.qa.hubspotapp.page.HomePage;
import com.qa.hubspotapp.page.LoginPage;

public class ContactsPageTest {
	
	WebDriver driver;
	LoginPage loginPage;
	Properties prop;
	BasePage basePage;
	HomePage homePage;
	ContactsPage contactsPage;
	Credentials userCredent;
	
	
	@BeforeMethod
	public void setUp()
	{
		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.init_driver(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loginPage = new LoginPage(driver);
		userCredent = new Credentials(prop.getProperty("username"), prop.getProperty("password"));
		homePage = loginPage.doLogin(userCredent);
		contactsPage = homePage.goToContactsPage();
		 System.out.println("Start Executing Contacts Page test cases");
	}
	
	@DataProvider
		public Object[][] getTestdata()
		{
		Object[][] testData = ExcelUtil.getTestDataFromExcel(AppConstants.CONTACTS_SHEET_NAME);
		return testData;
		}
	

	@Test(priority = 1, enabled = true)
	public void verifyHomePageTitle()
	{
		System.out.println("Start execute Test Case 1");
		String contactsPageTitle = contactsPage.getContactsPageTitle();
		System.out.println("Contacts Page Title is: " + contactsPageTitle);
		Assert.assertEquals(contactsPageTitle, AppConstants.CONTACTS_PAGE_TITLE);
		System.out.println("End execute Test Case 1");
	}
	
	@Test(priority = 2, dataProvider="getTestdata")
	public void verifyCreateAccount(String email, String firstName, String lastName, String jobTitle)
	{
		
		System.out.println("Start execute Test Case 2");
		contactsPage.createContact(email, firstName, lastName, jobTitle);
		System.out.println("End execute Test Case 2");
	}
	
	@AfterMethod
	public void tearDown()
	{
		 System.out.println("End Executing Contacts Page test cases");
		 driver.quit();
	}
	
	
}
