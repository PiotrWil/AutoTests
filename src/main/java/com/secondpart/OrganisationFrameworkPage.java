package com.secondpart;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrganisationFrameworkPage extends BasePage1 {

	@FindBy(xpath = "//input[@type= 'submit' and @value = 'Add new organisation']")
	WebElement addNewOrganisation;

	@FindBy(xpath = "//div[@class= 'alert-message']")
	WebElement alert;

	@FindBy(xpath = "//input[@type= 'submit' and @value = 'Add Goal']")
	WebElement addGoal;

	@FindBy(xpath = "//a[@class = 'btn btn-primary btn-xs']")
	WebElement logOut;

	public OrganisationFrameworkPage(WebDriver driver) {
		super(driver);
	}

	public void clickAddNewOrganisation() {
		addNewOrganisation.click();

	}

	public String getAlertMessage() {
		String text = alert.getText().trim();
		return text;
	}

	public void addNewGoal() {
		addGoal.click();

	}

	public void logOut() {
		WebDriverWait wait = new WebDriverWait(getWb(), 20);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@id='ui-id-1']")));

		logOut.click();

	}

}
