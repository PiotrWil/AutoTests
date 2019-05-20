package com.firstpart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;

import org.junit.Test;

import com.firstpart.AddRemovePage;
import com.firstpart.BasicAuthPage;
import com.firstpart.CheckboxesPage;
import com.firstpart.Code200Page;
import com.firstpart.Code301Page;
import com.firstpart.Code404Page;
import com.firstpart.Code500Page;
import com.firstpart.CodesPage;
import com.firstpart.DropDownPage;
import com.firstpart.DynamicControlsPage;
import com.firstpart.DynamicLoadingPage;
import com.firstpart.HiddenElementPage;
import com.firstpart.LoginPage;
import com.firstpart.NotificationMessagePage;
import com.firstpart.RenderedElementPage;
import com.firstpart.SecureAreaPage;
import com.firstpart.StartPage;
import com.firstpart.TablesPage;

public class Tests extends BaseTest {

	private StartPage startPage;

	@Test
	public void shouldLogSuccessfully() {
		startPage = new StartPage(driver);
		startPage.logIn("admin", "admin");
		BasicAuthPage basicAuthPage = new BasicAuthPage(driver);
		String actualString = basicAuthPage.getText();
		assertEquals("Congratulations! You must have the proper credentials.", actualString);
	
	}

	@Test
	public void shouldAddAndRemoveElements() throws InterruptedException {
		startPage = new StartPage(driver);
		startPage.enterAddRemovePage();
		AddRemovePage addRemovePage = new AddRemovePage(driver);
		addRemovePage.addElement();
		addRemovePage.addElement();
		Thread.sleep(2000);
		addRemovePage.removeElement();
		addRemovePage.removeElement();
	}

	@Test
	public void shouldSelectSecondCheckbox() throws InterruptedException {
		startPage = new StartPage(driver);
		startPage.enterCheckboxes();
		CheckboxesPage checkboxesPage = new CheckboxesPage(driver);
		checkboxesPage.deselectCheckbox(2);
		checkboxesPage.selectCheckbox(1);
		Thread.sleep(2000);
		assertTrue(checkboxesPage.checkIfSelected(1));
		assertFalse(checkboxesPage.checkIfSelected(2));

	}

	@Test
	public void shouldSelectDropDown() throws InterruptedException {
		startPage = new StartPage(driver);
		startPage.enterDropdown();
		DropDownPage dropDownPage = new DropDownPage(driver);
		dropDownPage.selectOption("2");
		Thread.sleep(2000);
		dropDownPage.selectOption("1");
		assertTrue(dropDownPage.checkIfSelected("Option 1"));

	}

	@Test
	public void shouldLogInAndOut() {
		startPage = new StartPage(driver);
		startPage.enterLogIn();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.logIn("tomsmith", "SuperSecretPassword!");
		SecureAreaPage secureAreaPage = new SecureAreaPage(driver);
		
		assertTrue(secureAreaPage.checkIfMessagePresent().contains("You logged into a secure area!"));
		secureAreaPage.logOut();
		assertTrue(loginPage.checkIfMessagePresent().contains("You logged out of the secure area!"));
		

	}

	@Test
	public void shouldCheckCodes() throws InterruptedException {
		startPage = new StartPage(driver);
		startPage.enterCodes();
		CodesPage codesPage = new CodesPage(driver);
		codesPage.enter200();
		Code200Page code200Page = new Code200Page(driver);
		assertTrue(code200Page.getStatusCode().contains("This page returned a 200 status code."));
		code200Page.goBack();
		codesPage.enter301();
		Code301Page code301Page = new Code301Page(driver);
		assertTrue(code301Page.getStatusCode().contains("This page returned a 301 status code."));
		code200Page.goBack();
		codesPage.enter404();
		Code404Page code404Page = new Code404Page(driver);
		assertTrue(code404Page.getStatusCode().contains("This page returned a 404 status code."));
		code200Page.goBack();
		codesPage.enter500();
		Code500Page code500Page = new Code500Page(driver);
		assertTrue(code500Page.getStatusCode().contains("This page returned a 500 status code."));
	}

	@Test
	public void shouldPrintValuesFrom3Row() {
		startPage = new StartPage(driver);
		startPage.enterTables();
		TablesPage tablesPage = new TablesPage(driver);
		assertEquals("Doe Jason jdoe@hotmail.com", tablesPage.getElements());

	}

	@Test
	public void shouldPrintEmails() {
		startPage = new StartPage(driver);
		startPage.enterTables();
		TablesPage tablesPage = new TablesPage(driver);
		assertEquals("jsmith@gmail.com tconway@earthlink.net", tablesPage.getEmails());
	}

	@Test
	public void shouldPrintSumOfValues() throws ParseException {
		startPage = new StartPage(driver);
		startPage.enterTables();
		TablesPage tablesPage = new TablesPage(driver);
		assertTrue(tablesPage.getValues().equals("$251,00"));

	}

	@Test
	public void shouldVerifyMessage() {
		startPage = new StartPage(driver);
		startPage.enterNotificationMessage();
		NotificationMessagePage notificationMessagePage = new NotificationMessagePage(driver);
		String message = "";
		while (!message.contains("Action unsuccesful, please try again")) {
			notificationMessagePage.clickUntilUnsuccessful();
			message = notificationMessagePage.getMessage();
		}
		assertTrue(message.contains("Action unsuccesful, please try again"));
	}

	@Test
	public void shouldWaitForText() {
		startPage = new StartPage(driver);
		startPage.enterDynamincLoading();
		DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(driver);
		dynamicLoadingPage.goToHiddenElement();
		HiddenElementPage hiddenElementPage = new HiddenElementPage(driver);
		hiddenElementPage.clickButton();
		assertTrue(hiddenElementPage.verifyIfTextPresent("Hello World!"));

	}

	@Test
	public void shouldVerifyTextInElement() {
		startPage = new StartPage(driver);
		startPage.enterDynamincLoading();
		DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(driver);
		dynamicLoadingPage.goToRenderedElement();
		RenderedElementPage renderedElementPage = new RenderedElementPage(driver);
		renderedElementPage.clickButton();
	
		assertEquals("Hello World!", renderedElementPage.getTextFromElement());
	}

	@Test
	public void shouldWaitForCheckboxToBeBack() {
		startPage = new StartPage(driver);
		startPage.enterDynamicControls();
		DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(driver);
		dynamicControlsPage.typeSomething("TEST");
		dynamicControlsPage.useCheckbox();
		dynamicControlsPage.removeCheckbox();
		dynamicControlsPage.disableField();
		dynamicControlsPage.addCheckbox();
		assertEquals("It's back!", dynamicControlsPage.getText());

	}

}
