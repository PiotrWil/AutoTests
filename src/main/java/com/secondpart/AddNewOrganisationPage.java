package com.secondpart;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNewOrganisationPage extends BasePage1{
	
	@FindBy(xpath = "//input[@id= 'id_fullname']")
	WebElement nameField;

	@FindBy(xpath = "//input[@id= 'id_idnumber']")
	WebElement idField;

	@FindBy(xpath = "//div[@id= 'id_description_editoreditable']")
	WebElement descriptionField;

	@FindBy(xpath = "//input[@id= 'id_submitbutton']")
	WebElement saveBtn;
	
	public AddNewOrganisationPage(WebDriver driver) {
		super(driver);
	}
	
	public void insertName(String name) {
		nameField.sendKeys(name);
	}
	
	public void insertId() {
		
		int range = 100;
		Random random = new Random();
		String str = String.valueOf(random.nextInt(range)+1);		
		idField.sendKeys(str);
	}
	
	public void insertDescription(String description) {
		descriptionField.sendKeys(description);
	}
	
	public void saveChanges() {
		saveBtn.click();
		
	}
	

}
