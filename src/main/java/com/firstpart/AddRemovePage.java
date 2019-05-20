package com.firstpart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddRemovePage extends BasePage{
	
	@FindBy(xpath = "//button[text() = 'Add Element']")
	WebElement buttonToAdd;
	
	@FindBy(xpath = "//button[text() = 'Delete']")
	WebElement buttonToDelete;
	
	
	public AddRemovePage(WebDriver driver) {
		super(driver);
				
	}
	
	public void addElement() {
		buttonToAdd.click();
			
	}
	
	public void removeElement() {
		buttonToDelete.click();
		
	}
}
