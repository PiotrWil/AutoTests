package com.secondpart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainDashboardPage extends BasePage1 {

	@FindBy(xpath = "//div[@id= 'dock_item_0_title']")
	WebElement inBookmarks;

	@FindBy(xpath = "//ol[@class= 'list']/li[contains(.,'Manage organisations')]")	
	WebElement manageOrganisations;
	
	@FindBy(xpath = "//ol[@class= 'list']/li[contains(.,'Manage organisations')]/a")
	WebElement manage;
	

	public MainDashboardPage(WebDriver driver) {
		super(driver);
	}

	public void enterMO() {
		//inBookmarks.click();
		
		//manageOrganisations.click();

		manage.click();
	}

}
