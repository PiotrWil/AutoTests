package com.firstpart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	private final WebDriver wb;

	public BasePage(WebDriver driver) {

		this.wb = driver;

		PageFactory.initElements(wb, this);

	}

	public WebDriver getWb() {
		return wb;
	}
}
