package com.qa.hubspotapp.base;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {
	
	public Properties prop;
	public ChromeOptions chromeOption;
	public FirefoxOptions fireFoxOption;
	
	
	public OptionsManager(Properties prop)
	{
		this.prop=prop;
	}
	
	public ChromeOptions chromeOptions()
	{
		chromeOption = new ChromeOptions();
		if(prop.getProperty("incognito").equals("yes"))
			chromeOption.addArguments("--incognito");
		if(prop.getProperty("headless").equals("yes"))
			chromeOption.addArguments("--headless");
		
		return chromeOption;
	}
	
	public FirefoxOptions fireFoxOptions()
	{
		fireFoxOption = new FirefoxOptions();
		if(prop.getProperty("headless").equals("yes"))
			fireFoxOption.addArguments("--headless");
		
		return fireFoxOption;
	}

}
