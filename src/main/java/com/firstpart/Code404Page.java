package com.firstpart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Code404Page extends BasePage {
	
	@FindBy(xpath = "//div[@class='example']/p")
	WebElement statusText;
			
	public Code404Page(WebDriver driver) {
		super(driver);
	}
	
	public String getStatusCode() {
		String code = statusText.getText();
		return code;
	}
	
	public void goBack() {
		getWb().navigate().back();
	}
	
}


