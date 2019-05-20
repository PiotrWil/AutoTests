package com.secondpart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage extends BasePage1 {

	@FindBy(xpath = "//a[@href= 'https://demo.totaralearning.com/login/index.php']")
	WebElement loginLink;


	
	public StartPage(WebDriver driver) {
		super(driver);
	}

	public void goTologinPage() {
		loginLink.click();
	

	}
	
	public boolean verifyTextPresent(String text) {
		return getWb().getPageSource().contains(text);
	}

}
