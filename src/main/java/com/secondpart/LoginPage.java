package com.secondpart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage1{
	
	@FindBy(xpath = "//input[@id= 'username']")
	WebElement usernameField;

	@FindBy(xpath = "//input[@id= 'password']")
	WebElement passwordField;

	@FindBy(xpath = "//input[@id= 'loginbtn']")
	WebElement loginBtn;
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void loginIn(String username, String password) {		
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginBtn.click();

	}

}
