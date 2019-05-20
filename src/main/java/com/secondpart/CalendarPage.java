package com.secondpart;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalendarPage extends BasePage1 {

	@FindBy(css = "dl.f2f > dt:nth-of-type(1) +dd")
	WebElement eventDateTime;

	@FindBy(css = "dl.f2f > dt:nth-of-type(2) +dd")
	WebElement eventDuration;

	@FindBy(css = "dl.f2f > dt:nth-of-type(3) +dd >span")
	WebElement eventRoom;

	@FindBy(xpath = "//a[contains(text(), 'Sign-up for this seminar event')]")
	WebElement signUp;

	public CalendarPage(WebDriver driver) {
		super(driver);
	}

	public List<String> getEventDetails() {
		String dateTime = eventDateTime.getText();
		String duration = eventDuration.getText();
		String room = eventRoom.getText();
		String roomWithoutTabs = room.replaceAll("\\n", " ");
		List<String> list = new ArrayList<String>();
		list.add(dateTime);
		list.add(duration);
		list.add(roomWithoutTabs.substring(0, roomWithoutTabs.length() - 15));

		return list;
	}

	public void signUp() {
		signUp.click();
	}

}
