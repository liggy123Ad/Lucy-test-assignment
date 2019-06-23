package com.mudano.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mudano.loators.Locators;

public class UtilityActions {

	
	static By by;
	static Select select;
	static WebElement webElement;
	static List<WebElement> webElements;
	public static WebDriver webDriver;
	public static WebDriverWait webDriverWait;
	
	public static void enterDataIntoTextBox(Locators locators) {
		by = selectLocator(locators); 
		webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
		webElement = webDriver.findElement(by);
		webElement.sendKeys(locators.getDataValue());
	}
	
	public static String getText(Locators locators) {
		by = selectLocator(locators); 
		webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
		webElement = webDriver.findElement(by);
		return webElement.getText();
	}
	
	public static void selectFromDropDown(Locators locators) {
		by = By.id(locators.getLocator());	
		webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
		webElement = webDriver.findElement(by);
		select = new Select(webElement);
		select.selectByVisibleText(locators.getDataValue());
	}
	
	public static void pickFromRadioButtonGroup(Locators locators) {
		by = By.xpath(locators.getLocator());	
		webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
		webElements = webDriver.findElements(by);		
		for(WebElement element : webElements) {			
			if(element.getText().equals(locators.getDataValue())) {
				element.click();
				break;
			}
		}	
	}
	
	public static void clickButton(Locators locators) {
		by = selectLocator(locators);	
		webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
		webElement = webDriver.findElement(by);
		webElement.click();
	}
	public static void clickLable(Locators locators) {
		by = selectLocator(locators);	
		webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
		webElement = webDriver.findElement(by);
		webElement.click();
	}
	
	public static void checkCheckbox(Locators locators) {
		by = selectLocator(locators);	
		webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
		webElement = webDriver.findElement(by);
		webElement.click();
	}
	
	public static By selectLocator(Locators locators) {		
		String locator = locators.getLocator();
		//more conditions need to be added for other locators, here I used only id and xpath. Hence I used only two conditions.
		if(locator.startsWith("//")) {
			return By.xpath(locator);
		}else {
			return By.id(locator);
		}		
	}
	
}
