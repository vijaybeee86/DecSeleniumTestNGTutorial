package com.qa.hubspotapp.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	//WebDriver driver;
	Properties prop;
	//String configPath= "C://Users//Krithik/TestNGNewFramework//SeleniumAutomation//src//main//java//com//qa//hubspotapp//config//Config.Properties";
	public static boolean highlightElement;
	OptionsManager optionsManager;
	
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
	
	public static synchronized WebDriver getDriver()
	{
		return tldriver.get();
	}
	public WebDriver init_driver(String browserName)
	{
		highlightElement = prop.getProperty("highlight").equals("yes") ? true: false;
		System.out.println("Browser Name: " + browserName);
		optionsManager = new OptionsManager(prop);
		if(browserName.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver(optionsManager.chromeOptions());
			tldriver.set(new ChromeDriver(optionsManager.chromeOptions()));
		}
		
		else if(browserName.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver(optionsManager.fireFoxOptions());
			tldriver.set(new FirefoxDriver(optionsManager.fireFoxOptions()));
		}
		
		else if(browserName.equals("IE"))
		{
			WebDriverManager.iedriver().setup();
			//driver = new SafariDriver();
			tldriver.set(new SafariDriver());
		}
		else
		{
			System.out.println("browser name " + browserName + " is not found. Please pass the correct browser");
		}
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		return getDriver();
	}

	public Properties init_properties()
	{
		 prop = new Properties();
		 String path = null;
		 String env = null;
		 
		 try
		 {
			 env = System.getProperty("env");
			 if(env.equals("QA"))
			 {
				 path = ".//src//main//java//com//qa//hubspotapp//config//QA_Config.Properties";
			 }
			 else if(env.equals("STG"))
			 {
				 path = ".//src//main//java//com//qa//hubspotapp//config//STG_Config.Properties";
			 }
		 }
		 catch(Exception e){
			 path = ".//src//main//java//com//qa//hubspotapp//config//Config.Properties";
		 }
		 
		 try {
			FileInputStream file = new FileInputStream(path);
				prop.load(file);
			} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some Issue with the config.properties. Please fix that and retry");
		}

			return prop;
	}
	
	
	public String getScreenshot()
	{
	
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		//String path = System.getProperty("user.dir")+ "/TestScreenshots" + System.currentTimeMillis() + ".png";
		String path = "C:/Users/Krithik/TestNGNewFramework/SeleniumAutomation/TestScreenshots/"+System.currentTimeMillis()+".png";
		File destination = new File(path);
		try {
			FileUtils.copyDirectory(src, destination);
		} catch (IOException e) {
			System.out.println("Screenshot captured failed...");
		}
		return path;
	}

}
