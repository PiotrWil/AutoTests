package com.secondpart;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResuscitationTraining extends BasePage1 {
	
	@FindBy(xpath = "//div[@class='alert-message']")
	WebElement alert;	
	
	@FindBy(xpath = "//span[@class='item-content-wrap' and text() = 'Resuscitation training']")
	WebElement resuscitationLink;

	@FindBy(xpath = "//div[@class='upcomingsessionlist']/table/tbody")
	WebElement table;
	
	@FindBy(xpath = "//h3[contains(text(), 'Previous events')]")
	WebElement previousEvents;
	
	//h3[contains(text(), 'Previous events')]
	
	@FindBy(xpath = "//a[contains(text(), 'Add a new event')]")
	WebElement addEvent;
	
	@FindBy(xpath = "//a[@class = 'btn btn-primary btn-xs']")
	WebElement logOut;
	
	
	public ResuscitationTraining(WebDriver driver) {
		super(driver);
	}
	
	
	public String getAlertMessage() {
		WebDriverWait wait = new WebDriverWait(getWb(), 20);
		wait.until(ExpectedConditions.visibilityOf(alert));
		String alertMsg = alert.getText().trim();
		return alertMsg;
		
	}
	
	public void selectResuscitation() {
		resuscitationLink.click();
		
	}
	
	public List<String> getEventDetails() {
		
		JavascriptExecutor js = (JavascriptExecutor) getWb();

		js.executeScript("arguments[0].scrollIntoView(true);", previousEvents);
		
		List<String> eventDetails = new ArrayList<String>();
		List<WebElement> list = table.findElements(By.tagName("tr"));
		int size = list.size();
		for (int i=0; i<size; i++) {
			String date = table.findElement(By.xpath("//tr[" + (i+1) + "]/td[1]")).getText();
			if(date.contains("December")) {
				eventDetails.add(date);
				String time = table.findElement(By.xpath("//tr[" + (i+1) + "]/td[2]")).getText();
				eventDetails.add(time);
				String room = table.findElement(By.xpath("//tr[" + (i+1) + "]/td[3]")).getText();
				eventDetails.add(room.substring(0, room.length()-15));
				break;
			}
			
			
		}
//		System.out.println(eventDetails.size());
//		for(String str : eventDetails) {
//			System.out.println(str);
			
		//}
		return eventDetails;
		
	}
	
	public void addNewEvent() {
		addEvent.click();
	}
	
	
	public void logOut() {
	//WebDriverWait wait = new WebDriverWait(getWb(), 20);
	//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@id='ui-id-1']")));
		
		//JavascriptExecutor js = (JavascriptExecutor) getWb();

	//	js.executeScript("arguments[0].scrollIntoView(true);", logOut);
		logOut.click();
		
	}
	
	
	
	
	
	
}
