package com.mudano.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mudano.loators.Locators;
import com.mudano.utils.UtilityActions;

public class HomePage {

	WebDriver webDriver;
		
	public HomePage(WebDriver webDriver) {
		this.webDriver = webDriver;
		UtilityActions.webDriver = webDriver;
		UtilityActions.webDriverWait = new WebDriverWait(webDriver,20);
	}

	public void clickUsersDropDown(){
		UtilityActions.clickLable(Locators.USERS_DROPDOWN);
	}
	
	public void clickTimeRecordsDropDown(){
		UtilityActions.clickLable(Locators.TIME_RECORDS_DROPDOWN);
	}
	
	public void clickCreateOption(){
		UtilityActions.clickLable(Locators.CREAT_OPTION);
	}
	
	public void clickRecordTimeCreateOption(){
		UtilityActions.clickLable(Locators.TIMERECORDS_CREATE_OPTION);
	}
	
	public void enterCreateuserUserName() {		
		UtilityActions.enterDataIntoTextBox(Locators.CREATEUSER_USER_NAME_TEXT_BOX);
	}

	public void enterCreateuserLogin() {		
		Locators locators = Locators.CREATEUSER_LOGIN_TEXT_BOX;
		String login = locators.getDataValue()+Math.random();
		webDriver.findElement(By.id(locators.getLocator())).sendKeys(login);
	}
	
	public void selectRoleFromDropdown() {		
		UtilityActions.selectFromDropDown(Locators.CREATEUSER_ROLE_DROPDOWN);
	}
	
	public void enterCreateuserPassword() {	
		UtilityActions.enterDataIntoTextBox(Locators.CREATEUSER_PASSWORD_TEXT_BOX);
	}
	
	public void enterCreateuserPasswordConfirmation() {	
		UtilityActions.enterDataIntoTextBox(Locators.CREATEUSER_PASSWORD_CONFIRMATION_TEXT_BOX);
	}
	
	public void clickCreateuserSaveButton() {		
		UtilityActions.clickButton(Locators.CREATEUSER_SAVE_BUTTON);
	}
	
	public void enterRecordtimeHours() {	
		UtilityActions.enterDataIntoTextBox(Locators.REGISTERTIMERECORDS_HOURS_TEXT_BOX);
	}
	
	public void enterRecordtimeNote() {	
		UtilityActions.enterDataIntoTextBox(Locators.REGISTERTIMERECORDS_NOTE_TEXT_BOX);
	}
	
	public void clickRecodtimeSaveButton() {		
		UtilityActions.clickButton(Locators.REGISTERTIMERECORDS_SAVE_BUTTON);
	}
	
	public void clickLogoutButton() {		
		UtilityActions.clickButton(Locators.LOGOUT_BUTTON);
	}
	
	public boolean verifyUsercreateMessage(){
		String actualMessage = UtilityActions.getText(Locators.CREATEUSER_SUCCESS_MESSAGE);
		String expectedMessage = Locators.CREATEUSER_SUCCESS_MESSAGE.getDataValue();
		return actualMessage.equals(expectedMessage);
	}
	
	public boolean verifyTimeRecordMessage(){
		String actualMessage = UtilityActions.getText(Locators.REGISTERTIMERECORDS_SUCCESS_MESSAGE);
		String expectedMessage = Locators.REGISTERTIMERECORDS_SUCCESS_MESSAGE.getDataValue();
		return actualMessage.equals(expectedMessage);
	}
	
	public HomePage populateAndSubmitCreateuserForm() {
		clickUsersDropDown();
		clickCreateOption();
		enterCreateuserUserName();
		enterCreateuserLogin();
		selectRoleFromDropdown();
		enterCreateuserPassword();
		enterCreateuserPasswordConfirmation();
		clickCreateuserSaveButton();
		return this;
	}
	
	public HomePage populateAndSubmiteRecordTimeForm(){
		clickTimeRecordsDropDown();
		clickRecordTimeCreateOption();
		enterRecordtimeHours();
		enterRecordtimeNote();
		clickRecodtimeSaveButton();
		return this;
	}

}
