package com.firstpart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicControlsPage extends BasePage {

	@FindBy(xpath = "//button[text() = 'Enable']")
	WebElement buttonEnable;

	@FindBy(xpath = "//button[text() = 'Disable']")
	WebElement buttonDisable;

	@FindBy(xpath = "//button[text() = 'Remove']")
	WebElement buttonRemove;

	@FindBy(xpath = "//button[text() = 'Add']")
	WebElement buttonAdd;

	@FindBy(xpath = "//input[@type = 'text']")
	WebElement field;

	@FindBy(xpath = "//input[@type = 'checkbox']")
	WebElement checkboxA;

	@FindBy(css = "form#input-example > p#message")
	WebElement messageField;

	@FindBy(css = "form#checkbox-example > p#message")
	WebElement messageCheckbox;

	WebDriverWait wait = new WebDriverWait(getWb(), 20);

	public DynamicControlsPage(WebDriver driver) {
		super(driver);
	}

	public void typeSomething(String text) {
		buttonEnable.click();
		wait.until(ExpectedConditions.elementToBeClickable(field));
		field.sendKeys(text);

	}

	public void useCheckbox() {
		checkboxA.click();
	}

	public void removeCheckbox() {
		buttonRemove.click();

	}

	public void addCheckbox() {
		buttonAdd.click();
		wait.until(ExpectedConditions.textToBePresentInElement(messageCheckbox, "It's back!"));
	}

	public void disableField() {
		buttonDisable.click();
		wait.until(ExpectedConditions.textToBePresentInElement(messageField, "It's disabled!"));

	}

	public String getText() {
		String textBack = messageCheckbox.getText();
		return textBack;

	}

}
