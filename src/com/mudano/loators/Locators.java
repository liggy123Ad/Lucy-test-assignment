package com.mudano.loators;

public enum Locators {
	USER_NAME_TEXT_BOX("login","admin"),
	PASSWORD_TEXT_BOX("password","123456"),
	LOGIN_BUTTON("//input[@value='Log In']"),
	USERS_DROPDOWN("//a[text()='Users']"),
	TIME_RECORDS_DROPDOWN("//a[text()='Time Records']"),
	CREAT_OPTION("//a[text()='Create']"),
	TIMERECORDS_CREATE_OPTION("//a[contains(@href,'timeRecord') and text()='Create']"),
	LIST_OPTION("//a[text()='list']"),
	CREATEUSER_USER_NAME_TEXT_BOX("name","Test Name"),
	CREATEUSER_LOGIN_TEXT_BOX("login","TestLogin"),
	CREATEUSER_ROLE_DROPDOWN("role","Regular User"),
	CREATEUSER_PASSWORD_TEXT_BOX("password","TestPassword"),
	CREATEUSER_PASSWORD_CONFIRMATION_TEXT_BOX("passwordConfirmation","TestPassword"),
	CREATEUSER_SAVE_BUTTON("//input[@value='Save']"),
	CREATEUSER_SUCCESS_MESSAGE("//div[@role='alert']","User created."),
	REGISTERTIMERECORDS_HOURS_TEXT_BOX("hours","12"),
	REGISTERTIMERECORDS_NOTE_TEXT_BOX("note","TESTnOTE"),
	REGISTERTIMERECORDS_SAVE_BUTTON("//input[@value='Save']"),
	REGISTERTIMERECORDS_SUCCESS_MESSAGE("//div[@role='alert']","Time record created."),
	LOGOUT_BUTTON("//a[text()='Logout']")	
	;
	
	String locator,dataValue;

	private Locators(String locator) {
		this.locator = locator;
	}
	
	private Locators(String locator,String dataValue) {
		this.locator = locator;
		this.dataValue = dataValue;
	}

	public String getLocator() {
		return locator;
	}
	
	public String getDataValue() {
		return dataValue;
	}

}
