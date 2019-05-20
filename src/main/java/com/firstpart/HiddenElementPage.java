package com.firstpart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HiddenElementPage extends BasePage {

	@FindBy(xpath = "//button[text() = 'Start']")
	WebElement button;

	@FindBy(xpath = "//div[@id = 'finish']/h4")
	WebElement textElement;

	public HiddenElementPage(WebDriver driver) {
		super(driver);
	}

	public void clickButton() {
		button.click();

	}

	public boolean verifyIfTextPresent(String text) {
		WebDriverWait wait = new WebDriverWait(getWb(), 20);
		return wait.until(ExpectedConditions.textToBePresentInElement(textElement, text));

	}

}
