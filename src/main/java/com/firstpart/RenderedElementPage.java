package com.firstpart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RenderedElementPage extends BasePage{
	
	private String text;
	
	@FindBy(xpath = "//button[text() = 'Start']")
	WebElement button;
	
	@FindBy(xpath = "//div[@id = 'finish']/h4")
	WebElement textElement;	
	
	public RenderedElementPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickButton() {
		button.click();
		
	}
	
	public String getTextFromElement() {
		WebDriverWait wait=new WebDriverWait(getWb(), 20);
		wait.until(ExpectedConditions.visibilityOf(textElement));
		text = textElement.getText().trim();
		return text;		
	}

}
