package com.mudano.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mudano.loators.Locators;
import com.mudano.utils.UtilityActions;

public class LoginPage {

	WebDriver webDriver;
	
	public LoginPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		UtilityActions.webDriver = webDriver;
		UtilityActions.webDriverWait = new WebDriverWait(webDriver,20);
	}

	public void enterUserName() {		
		UtilityActions.enterDataIntoTextBox(Locators.USER_NAME_TEXT_BOX);
	}

	public void enterPassword() {	
		UtilityActions.enterDataIntoTextBox(Locators.PASSWORD_TEXT_BOX);
	}

	public void clickLoginButton() {		
		UtilityActions.clickButton(Locators.LOGIN_BUTTON);
	}
	
	public HomePage populateAndSubmitLoginPage() {
		enterUserName();		
		enterPassword();		
		clickLoginButton();
		return new HomePage(webDriver);
	}

}
