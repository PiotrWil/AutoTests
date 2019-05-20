package com.secondpart;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CertificationCompletionPage extends BasePage1 {

	@FindBy(id = "id_user-fullname_op")
	WebElement selectValue;

	@FindBy(id = "id_user-fullname")
	WebElement nameField;

	@FindBy(xpath = "//input[@type='submit' and @id ='id_submitgroupstandard_addfilter'] ")
	WebElement searchBtn;

	@FindBy(xpath = "//table[@id='report_certification_completion']/tbody ")
	WebElement table;

	@FindBy(xpath = "//input[@type='submit' and @value = 'Save this search']")
	WebElement saveBtn;

	@FindBy(xpath = "//input[@type='submit' and @value = 'Clear']")
	WebElement clearBtn;

	@FindBy(id = "id_certcompletion-status_op")
	WebElement selectStatus;

	@FindBy(id = "id_certcompletion-status")
	WebElement selectStatusType;

	@FindBy(name = "sid")
	WebElement selectViewSearch;

	@FindBy(xpath = "//a[@class = 'btn btn-primary btn-xs']")
	WebElement logOut;

	public CertificationCompletionPage(WebDriver driver) {
		super(driver);
	}

	public void setSelectProperty(String value) {
		Select select = new Select(selectValue);
		select.selectByVisibleText(value);

	}

	public void enterName(String name) {
		nameField.sendKeys(name);

	}

	public void searchResults() {
		searchBtn.click();

	}

	public List<String> checkValuesFromTable() {
		JavascriptExecutor js = (JavascriptExecutor) getWb();

		js.executeScript("arguments[0].scrollIntoView(true);", table);

		List<String> valuesList = new ArrayList<String>();
		List<WebElement> list = table.findElements(By.tagName("tr"));
		int size = list.size();

		for (int i = 0; i < size; i++) {
			String date = table.findElement(By.xpath("//tr[" + (i + 1) + "]/td[3]")).getText();
			if (date.equals("27 Jul 2018 at 09:55")) {
				valuesList.add(date);
				String positionName = table.findElement(By.xpath("//tr[" + (i + 1) + "]/td[6]")).getText();
				valuesList.add(positionName);
				String organisationName = table.findElement(By.xpath("//tr[" + (i + 1) + "]/td[7]")).getText();
				valuesList.add(organisationName);

				break;
			}

		}

		return valuesList;
	}

	public void saveSearch() {
		saveBtn.click();

	}

	public void clearSearch() {
		clearBtn.click();

	}

	public void setSelectStatusProperty(String value) {
		Select select = new Select(selectStatus);
		select.selectByVisibleText(value);

	}

	public void setStatusType(String value) {
		Select select = new Select(selectStatusType);
		select.selectByVisibleText(value);

	}

	public List<String> getNamesFromTable() {
		JavascriptExecutor js = (JavascriptExecutor) getWb();
		js.executeScript("arguments[0].scrollIntoView(true);", table);

		List<String> namesList = new ArrayList<String>();

		List<WebElement> list = table.findElements(By.tagName("tr"));

		int size = list.size();
		for (int i = 0; i < size; i++) {
			String name = table.findElement(By.xpath("//tr[" + (i + 1) + "]/td[1]")).getText();
			namesList.add(name);

		}

		return namesList;
	}

	public void setViewSearch(String value) {
		Select select = new Select(selectViewSearch);
		select.selectByVisibleText(value);

	}

	public boolean verifyIfNamePresent(String name) {
		JavascriptExecutor js = (JavascriptExecutor) getWb();
		js.executeScript("arguments[0].scrollIntoView(true);", table);
		List<WebElement> list = table.findElements(By.tagName("tr"));
		int size = list.size();
		for (int i = 0; i < size; i++) {
			String nameInTable = table.findElement(By.xpath("//tr[" + (i + 1) + "]/td[1]")).getText();
			if (name.equals(nameInTable)) {
				return true;

			}

		}
		return false;
	}

	public void logOut() {
		logOut.click();

	}

}
