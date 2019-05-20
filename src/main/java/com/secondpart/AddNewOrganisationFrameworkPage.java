package com.secondpart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNewOrganisationFrameworkPage extends BasePage1 {

	@FindBy(xpath = "//input[@id= 'id_fullname']")
	WebElement nameField;

	@FindBy(xpath = "//input[@id= 'id_idnumber']")
	WebElement idField;

	@FindBy(xpath = "//div[@id= 'id_description_editoreditable']")
	WebElement descriptionField;

	@FindBy(xpath = "//input[@id= 'id_submitbutton']")
	WebElement saveBtn;

	public AddNewOrganisationFrameworkPage(WebDriver driver) {
		super(driver);
	}

	public void insertName(String name) {
		nameField.sendKeys(name);
	}
	
	public void insertId(String id) {
		idField.sendKeys(id);
	}
	
	public void insertDescription(String description) {
		descriptionField.sendKeys(description);
	}
	
	public void saveChanges() {
		saveBtn.click();
		
	}
	
	

}
