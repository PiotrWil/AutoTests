package com.secondpart;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.Select;

public class AddNewEventPage extends BasePage1 {

	@FindBy(xpath = "//span[@title='Delete']")
	WebElement clearSession;

	@FindBy(xpath = "//input[@name='registrationtimestart[enabled]']")
	WebElement enableRegStart;

	@FindBy(xpath = "//select[@name='registrationtimestart[day]']")
	WebElement regStartDay;

	@FindBy(xpath = "//select[@name='registrationtimestart[month]']")
	WebElement regStartMonth;

	@FindBy(xpath = "//select[@name='registrationtimestart[year]']")
	WebElement regStartYear;

	@FindBy(xpath = "//select[@name='registrationtimestart[hour]']")
	WebElement regStartHour;

	@FindBy(xpath = "//select[@name='registrationtimestart[minute]']")
	WebElement regStartMinute;

	@FindBy(xpath = "//select[@name='registrationtimestart[timezone]']")
	WebElement regStartZone;

	@FindBy(xpath = "//input[@name='registrationtimefinish[enabled]']")
	WebElement enableRegFinish;

	@FindBy(xpath = "//select[@name='registrationtimefinish[day]']")
	WebElement regFinishDay;

	@FindBy(xpath = "//select[@name='registrationtimefinish[month]']")
	WebElement regFinishMonth;

	@FindBy(xpath = "//select[@name='registrationtimefinish[year]']")
	WebElement regFinishYear;

	@FindBy(xpath = "//select[@name='registrationtimefinish[hour]']")
	WebElement regFinishHour;

	@FindBy(xpath = "//select[@name='registrationtimefinish[minute]']")
	WebElement regFinishMinute;

	@FindBy(xpath = "//select[@name='registrationtimefinish[timezone]']")
	WebElement regFinishZone;

	@FindBy(xpath = "//input[@id='id_capacity']")
	WebElement roomCapacity;

	@FindBy(xpath = "//input[@id='id_allowoverbook']")
	WebElement overbook;
	@FindBy(xpath = "//input[@id ='id_allowcancellations_1']")
	WebElement cancellation;

	@FindBy(xpath = "//input[@id ='id_mincapacity']")
	WebElement mincapacity;

	@FindBy(xpath = "//input[@id ='id_normalcost']")
	WebElement normalCost;

	@FindBy(xpath = "//input[@id ='id_discountcost']")
	WebElement discountCost;

	@FindBy(xpath = "//div[@id ='id_details_editoreditable']")
	WebElement details;

	@FindBy(xpath = "//input/following::label[contains(text(), 'Sally Proust')]")
	WebElement editingTrainer;

	@FindBy(xpath = "//input/following::label[contains(text(), 'Carl Course-Creator')]")
	WebElement trainer;
	@FindBy(xpath = "//input[@id ='id_submitbutton']")
	WebElement saveChanges;

	public AddNewEventPage(WebDriver driver) {
		super(driver);
	}

	public void clearSession() {
		clearSession.click();

	}

	public void selectStartDate() {
		enableRegStart.click();
		LocalDateTime time = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/M/dd HH:mm");
		String formattedTime = time.format(formatter);		
		//System.out.print(formattedTime);
		String year = formattedTime.substring(0, 4);
		String month = formattedTime.substring(5, 6);
		String day = formattedTime.substring(7, 9);

		String hour = formattedTime.substring(10, 12);

		String minute = formattedTime.substring(13);
		int min = Integer.parseInt(minute);

		while (min % 5 != 0) {
			min--;
		}

		minute = String.format("%02d", min);

		Select selectDay = new Select(regStartDay);
		selectDay.selectByVisibleText(day);
		Select selectMonth = new Select(regStartMonth);
		selectMonth.selectByValue(month);

		Select selectYear = new Select(regStartYear);
		selectYear.selectByVisibleText(year);
		Select selectHour = new Select(regStartHour);
		selectHour.selectByVisibleText(hour);
		Select selectMinute = new Select(regStartMinute);
		selectMinute.selectByVisibleText(minute);
		Select selectZone = new Select(regStartZone);
		selectZone.selectByVisibleText("Europe/Warsaw");

	}

	public void selectFinishDate(String day, String month, String year, String hour, String minute, String zone) {
		enableRegFinish.click();

		Select selectDay = new Select(regFinishDay);
		selectDay.selectByVisibleText(day);
		Select selectMonth = new Select(regFinishMonth);
		selectMonth.selectByVisibleText(month);

		Select selectYear = new Select(regFinishYear);
		selectYear.selectByVisibleText(year);
		Select selectHour = new Select(regFinishHour);
		selectHour.selectByVisibleText(hour);
		Select selectMinute = new Select(regFinishMinute);
		selectMinute.selectByVisibleText(minute);
		Select selectZone = new Select(regFinishZone);
		selectZone.selectByVisibleText(zone);

	}

	public void setCapacity(String capacity) {
		roomCapacity.clear();
		roomCapacity.sendKeys(capacity);
	}

	public void enableOverbook() {
		overbook.click();
	}

	public void allowCancellationsAtAnyTime() {
		cancellation.click();

	}

	public void setMinCapacity(String minCapacity) {
		mincapacity.clear();
		mincapacity.sendKeys(minCapacity);

	}

	public void setNormalCost(String cost) {
		normalCost.sendKeys(cost);

	}

	public void setDiscountCost(String cost) {
		discountCost.sendKeys(cost);
	}

	public void setDetails(String description) {
		details.sendKeys(description);
	}

	public void checkTrainers() {
		editingTrainer.click();
		trainer.click();

	}

	public void saveChanges() {
		saveChanges.click();
	}

}
