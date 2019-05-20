package com.secondpart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManagerDashbordPage extends BasePage1{
	
	@FindBy(xpath = "//ul[@class = 'reportmanager']/li/a[1]")
	WebElement certification;

	public ManagerDashbordPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickOnCertificationCompletion() {
		certification.click();		
	}
	
}
