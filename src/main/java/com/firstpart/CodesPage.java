package com.firstpart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CodesPage extends BasePage {

	
	@FindBy(xpath = "//a[@href='status_codes/200']")
	WebElement link200;
	
	@FindBy(xpath = "//a[@href='status_codes/301']")
	WebElement link301;
	
	@FindBy(xpath = "//a[@href='status_codes/404']")
	WebElement link404;
	
	@FindBy(xpath = "//a[@href='status_codes/500']")
	WebElement link500;
		
	public CodesPage(WebDriver driver) {
		super(driver);
	}
	
	public void enter200() {
		link200.click();
		}
	
	public void enter301() {
		link301.click();
		}
	
	public void enter404() {
		link404.click();
		}
	
	public void enter500() {
		link500.click();
		}
	
}
