package com.mudano.tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mudano.pages.HomePage;
import com.mudano.pages.LoginPage;

public class CreateUserAndRecordTimeTest {
	WebDriver webDriver;
		
	@BeforeMethod
	public void setUp() throws FileNotFoundException, IOException {
		
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");		
		webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
		webDriver.get("http://lucy.recruitment.v2.mudano.com:3000/");
	}
	
	@Test
	public void recordTime(){
		LoginPage loginPage = new LoginPage(webDriver);		
		
		HomePage homePage = loginPage
				.populateAndSubmitLoginPage()
				.populateAndSubmiteRecordTimeForm();
		
		boolean isTimeRecorded = homePage.verifyTimeRecordMessage();		
		Assert.assertTrue(isTimeRecorded, "Time is not recorded");
		
		homePage.clickLogoutButton();
	}
	
	@Test
	public void createUser() {		
		LoginPage loginPage = new LoginPage(webDriver);	
		
		HomePage homePage = loginPage
				.populateAndSubmitLoginPage()
				.populateAndSubmitCreateuserForm();
		
		boolean isUserCeated = homePage.verifyUsercreateMessage();		
		Assert.assertTrue(isUserCeated, "User is not created");
		
		homePage.clickLogoutButton();
	}
	
	
	@AfterMethod
	public void tearDown() {
		webDriver.quit();
	}
	
}
