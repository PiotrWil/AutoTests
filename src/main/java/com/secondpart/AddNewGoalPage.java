package com.secondpart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNewGoalPage extends BasePage1{
	
	@FindBy(xpath = "//ul[@class= 'treeview filetree picker']/li/span/a[contains(text(), 'Create training manuals for new staff induction')]")	
	WebElement trainingLink;
	
	@FindBy(xpath = "//button[@type = 'button' and contains(., 'Save')]")
	WebElement saveBtn;
	
		
	
	public AddNewGoalPage(WebDriver driver) {
		super(driver);
	}
	
	public void chooseGoal() {
		trainingLink.click();
	}
	
	public void saveGoals() {
		saveBtn.click();
	}
	
	

}
