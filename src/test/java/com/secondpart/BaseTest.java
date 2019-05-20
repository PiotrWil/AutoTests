package com.secondpart;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

	protected WebDriver driver;

	@Before
	public void setup() {

		System.setProperty("webdriver.gecko.driver", "C:\\Users\\A694886\\Documents\\geckodriver.exe");

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.totaralearning.com/");
	}

	@After
	public void tearDown() {
		driver.quit();
	}

}
