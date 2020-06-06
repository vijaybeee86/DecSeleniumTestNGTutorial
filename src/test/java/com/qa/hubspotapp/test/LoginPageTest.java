package com.qa.hubspotapp.test;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.utilities.AppConstants;
import com.qa.hubspot.utilities.Credentials;
import com.qa.hubspotapp.base.BasePage;
import com.qa.hubspotapp.page.HomePage;
import com.qa.hubspotapp.page.LoginPage;

public class LoginPageTest{
	BasePage basePage;
	LoginPage loginPage;
	HomePage homePage;
	Properties prop;
	WebDriver driver;
	Credentials userCredent;

   @BeforeTest
   public void setUp()
   {
	 basePage = new BasePage();
	 prop = basePage.init_properties();
	 driver = basePage.init_driver(prop.getProperty("browser"));
	 driver.get(prop.getProperty("url"));
	 loginPage = new LoginPage(driver);
	 userCredent = new Credentials(prop.getProperty("username"), prop.getProperty("password"));
	 System.out.println("Start Executing Login Page test cases");
   }
   
  /* @DataProvider
   public void getTestData()
   {
	   Object [] [] = 
   }
   */
   
   
   @Test(priority = 1)
   public void hubSpotPageLoginPageTitle()
   {
		 try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   String title = loginPage.getLoginPageTitleUsingJS();
	   System.out.println("Login Page title is: " + title);
	   Assert.assertEquals(title, AppConstants.LOGIN_PAGE_TITLE);
	   
   }
   
   @Test(priority = 2)
   public void hubSpotSignUpLink_IsPrfesent()
   {
	   Boolean isSignUpLinkPresent = loginPage.checkSignUpLink();
	   Assert.assertTrue(isSignUpLinkPresent, "Sign up Link is not displayed");
   }
   
   @Test(priority = 3)
   public void hubSpotLogin()
   {
	   homePage = loginPage.doLogin(userCredent);
	   String homePageTitle = homePage.getHomePageTitle();
	   System.out.println(homePageTitle);
	   Assert.assertEquals(homePageTitle, AppConstants.HomePage_PAGE_TITLE);
   }

   @AfterTest
   public void tearDown()
   {
	   System.out.println("End Executing Login Page test cases");
	   driver.close();
   }
}
