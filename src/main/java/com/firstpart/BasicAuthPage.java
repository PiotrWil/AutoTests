package com.firstpart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasicAuthPage extends BasePage {
	
	@FindBy(xpath = "//div[@class='example']/p")
	WebElement wb1;
	
	public BasicAuthPage(WebDriver driver) {
		super(driver);
	}
	
	public String getText() {
		String actualString = wb1.getText();
		 return actualString;
		 
		}

}
