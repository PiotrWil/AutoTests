package com.secondpart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SaveSearchPage extends BasePage1 {

	@FindBy(id = "id_name")
	WebElement nameField;

	@FindBy(id = "id_submitbutton")
	WebElement submitBtn;

	public SaveSearchPage(WebDriver driver) {
		super(driver);
	}

	public void enterName(String name) {
		nameField.sendKeys(name);

	}

	public void saveChanges() {
		submitBtn.click();

	}
	
	

}
