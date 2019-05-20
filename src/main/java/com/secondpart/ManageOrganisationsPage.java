package com.secondpart;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManageOrganisationsPage extends BasePage1 {

	@FindBy(xpath = "//input[@value= 'Add new organisation framework']")
	WebElement buttonOF;

	@FindBy(xpath = "//div[@class= 'alert-message']")
	WebElement alert;

	@FindBy(xpath = "//table[@class='generaltable fullwidth editorganisation']/tbody")
	WebElement rows;

	public ManageOrganisationsPage(WebDriver driver) {
		super(driver);
	}

	public void addNewOF() {
		buttonOF.click();
	}

	public String getAlertMessage() {
		String text = alert.getText().trim();
		return text;
	}

	public void selectFramework(String name) {
		List<WebElement> list = rows.findElements(By.xpath("//tr"));
		int size = list.size();
		//System.out.print(size);
		for (int i = 0; i < size; i++) {
			WebElement temp = rows.findElement(By.xpath("//tr[" + (i + 1) + "]/td[1]"));
			//System.out.print(temp.getText());
			if (temp.getText().equals(name)) {
				rows.findElement(By.xpath("//tr[" + (i + 1) + "]/td[1]/a")).click();

				break;

			}

		}

	}

}
