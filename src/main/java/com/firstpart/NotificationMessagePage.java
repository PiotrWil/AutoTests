package com.firstpart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NotificationMessagePage extends BasePage {
	
	String text;
	
	@FindBy(xpath = "//a[@href='/notification_message']")
	WebElement loadLink;
	
	@FindBy(xpath = "//div[@id='flash']")
	WebElement message;
	
	
	public NotificationMessagePage(WebDriver driver) {
		super(driver);
	}
	
	public void clickUntilUnsuccessful() {
		
		loadLink.click();
	}
	
	public String getMessage() {
		text = message.getText();
		return text;
	}
	
	

}
