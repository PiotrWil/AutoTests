package com.firstpart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	@FindBy(xpath = "//input[@id='username']")
	WebElement usernameField;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordField;
	
	@FindBy(xpath = "//button[@class='radius']")
	WebElement button;
	
	@FindBy(xpath = "//div[@id='flash']")
	WebElement alert;

	public LoginPage(WebDriver driver) {
		
		super(driver);
	}
	
	public void logIn(String username, String password) {
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		button.click();
	}
	
	public String checkIfMessagePresent() {
		String text;
		text = alert.getText();
		return text;		
	}
	
	
	
	
	
}

