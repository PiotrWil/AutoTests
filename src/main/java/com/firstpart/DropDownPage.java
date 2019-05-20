package com.firstpart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage extends BasePage{
	
	Select select;
	
	@FindBy(id = "dropdown")
	WebElement dropdown;
		

	public DropDownPage(WebDriver driver) {
		super(driver);
	}
	
	
	public void selectOption(String value) {
		select = new Select(dropdown);
		select.selectByValue(value);
				
	}
	
	public boolean checkIfSelected(String text) {
		boolean isSelected = select.getFirstSelectedOption().getText().equals(text);
		return isSelected;
	}
	
}
