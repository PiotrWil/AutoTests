package com.secondpart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage1 {
	
	private final WebDriver wb;

	public BasePage1(WebDriver driver) {

		this.wb = driver;

		PageFactory.initElements(wb, this);

	}

	public WebDriver getWb() {
		return wb;
	}

}
