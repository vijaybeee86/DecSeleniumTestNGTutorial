package com.qa.hubspot.utilities;

public class Credentials {
	 String appUserName;
	 String appPassword;
	
	public Credentials(String appUserName, String appPassword)
	{
		this.appUserName=appUserName;
		this.appPassword=appPassword;
	}
	
	public String getAppUserName() {
		return appUserName;
	}
	public void setAppUserName(String appUserName) {
		this.appUserName = appUserName;
	}
	public String getAppPassword() {
		return appPassword;
	}
	public void setAppPassword(String appPassword) {
		this.appPassword = appPassword;
	}


}
