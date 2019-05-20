package com.firstpart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SecureAreaPage extends BasePage {

	@FindBy(xpath = "//div[@id='flash']")
	WebElement alert;

	@FindBy(xpath = "//a[@href='/logout']")
	WebElement logout;

	public SecureAreaPage(WebDriver driver) {
		super(driver);
	}

	public String checkIfMessagePresent() {
		String text;
		text = alert.getText();
		return text;
	}

	public void logOut() {
		logout.click();

	}

}
