package com.firstpart;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage extends BasePage {

	@FindBy(xpath = "//a[@href='/basic_auth']")
	WebElement firstLink;

	@FindBy(xpath = "//a[@href='/add_remove_elements/']")
	WebElement secondLink;

	@FindBy(xpath = "//a[@href='/checkboxes']")
	WebElement thirdLink;

	@FindBy(xpath = "//a[@href='/dropdown']")
	WebElement fourthLink;

	@FindBy(xpath = "//a[@href='/login']")
	WebElement fifthLink;

	@FindBy(xpath = "//a[@href='/status_codes']")
	WebElement sixthLink;

	@FindBy(xpath = "//a[@href='/tables']")
	WebElement seventhLink;

	@FindBy(xpath = "//a[@href='/notification_message']")
	WebElement eighthLink;

	@FindBy(xpath = "//a[@href='/dynamic_loading']")
	WebElement ninthLink;

	@FindBy(xpath = "//a[@href='/dynamic_controls']")
	WebElement tenthLink;

	public StartPage(WebDriver driver) {
		super(driver);
	}

	public void logIn(String username, String password) {
		firstLink.click();
		Alert alert = getWb().switchTo().alert();
		alert.sendKeys(username + Keys.TAB + password);
		alert.accept();

	}

	public void enterAddRemovePage() {
		secondLink.click();

	}

	public void enterCheckboxes() {
		thirdLink.click();

	}

	public void enterDropdown() {
		fourthLink.click();

	}

	public void enterLogIn() {
		fifthLink.click();

	}

	public void enterCodes() {
		sixthLink.click();

	}

	public void enterTables() {
		seventhLink.click();

	}

	public void enterNotificationMessage() {
		eighthLink.click();

	}

	public void enterDynamincLoading() {
		ninthLink.click();
	}

	public void enterDynamicControls() {
		tenthLink.click();

	}

}
