package com.firstpart;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckboxesPage extends BasePage{
	
	@FindBy(xpath = "//form[@id ='checkboxes']/input")
	List<WebElement> checkboxes;
	
		

	public CheckboxesPage(WebDriver driver) {
		super(driver);
	}
	
	public void deselectCheckbox(int numberOfCheckbox) {
		
		checkboxes.get(numberOfCheckbox-1).click();
				
		}
	
	public void selectCheckbox(int numberOfCheckbox) {
		
		checkboxes.get(numberOfCheckbox-1).click();
				
		}
	
	public boolean checkIfSelected(int numberOfCheckbox) {
		boolean isSelected = checkboxes.get(numberOfCheckbox-1).isSelected();
		return isSelected;
	}
		
	public boolean checkIfDeselected(int numberOfCheckbox) {
		boolean isSelected = checkboxes.get(numberOfCheckbox-1).isSelected();
		return isSelected;
	}
	
	}
	
	
	
	
	

