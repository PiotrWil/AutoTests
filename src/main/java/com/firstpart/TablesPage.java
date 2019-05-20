package com.firstpart;

import java.text.ParseException;
import java.util.List;
import java.util.StringJoiner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TablesPage extends BasePage {

	private String tempText;
	private String finalText;
	private String email;
	private String tempValue;
	private double result = 0;
	private double db = 0;
	private String strDouble;

	@FindBy(xpath = "//table[@id='table1']/tbody/tr[3]/td")
	List<WebElement> thirdRow;

	@FindBy(xpath = "//table[@id='table1']/tbody")
	WebElement rows;

	@FindBy(xpath = "//table[@id='table2']/tbody")
	WebElement rows1;

	public TablesPage(WebDriver driver) {
		super(driver);
	}

	public String getElements() {
		StringJoiner sj = new StringJoiner(" ");

		for (int i = 0; i < 3; i++) {
			tempText = thirdRow.get(i).getText();
			sj.add(tempText);
		}
		finalText = sj.toString();
		System.out.print(finalText);
		return finalText;
	}

	public String getEmails() {

		StringJoiner sj = new StringJoiner(" ");

		for (int i = 1; i <= 4; i += 3) {
			email = rows.findElement(By.xpath("//tr[" + i + "]/td[3]")).getText();

			sj.add(email);
		}
		String string = sj.toString();

		System.out.print(string);
		return string;

	}

	public String getValues() throws ParseException {
		List<WebElement> tempRows = rows1.findElements(By.tagName("tr"));
		int size = tempRows.size();
		
		for (int i = 0; i < size; i++) {
			tempValue = rows1.findElement(By.xpath("//tr[" + (i + 1) + "]/td[4]")).getText().substring(1);
			
			db = Double.parseDouble(tempValue);
			result += db;

		}
		strDouble = String.format("$%.2f", result);
		System.out.print(strDouble);
		return strDouble;
	}

}
