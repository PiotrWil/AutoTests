package com.firstpart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicLoadingPage extends BasePage {

	@FindBy(xpath = "//a[@href='/dynamic_loading/1']")
	WebElement firstLink;

	@FindBy(xpath = "//a[@href='/dynamic_loading/2']")
	WebElement secondLink;

	public DynamicLoadingPage(WebDriver driver) {
		super(driver);
	}

	public void goToHiddenElement() {
		firstLink.click();
	}

	public void goToRenderedElement() {
		secondLink.click();
	}
}
