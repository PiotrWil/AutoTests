package com.secondpart;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrainerDashboardPage extends BasePage1{
	
	@FindBy(xpath = "//a[contains(text(), '15')]")
	WebElement events;
	
	
	
	
	public TrainerDashboardPage(WebDriver driver) {
		super(driver);
	}
	
	public void selectEvent() {
		
		events.click();
	}
	


}
