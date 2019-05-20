package com.secondpart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import java.util.List;

import org.junit.Test;

import com.secondpart.AddNewEventPage;
import com.secondpart.AddNewGoalPage;
import com.secondpart.AddNewOrganisationFrameworkPage;
import com.secondpart.AddNewOrganisationPage;
import com.secondpart.CalendarPage;
import com.secondpart.CertificationCompletionPage;
import com.secondpart.LoginPage;
import com.secondpart.MainDashboardPage;
import com.secondpart.ManageOrganisationsPage;
import com.secondpart.ManagerDashbordPage;
import com.secondpart.OrganisationFrameworkPage;
import com.secondpart.ResuscitationTraining;
import com.secondpart.SaveSearchPage;
import com.secondpart.StartPage;
import com.secondpart.TrainerDashboardPage;



public class Tests extends BaseTest {

	private StartPage startPage;
	
	@Test
	public void shouldAddNewOrganisationFramework() throws InterruptedException {
		
		final String nameFramework = "New Test Organisation";
		final String idFramework = "310";
		final String descriptionFramework = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum";
		final String nameOrganisation = "Automation";				
		final String descriptionOrganisation = "Morbi luctus, nisi eget tempus faucibus, justo massa iaculis odio, eget sollicitudin lectus justo ut neque. Aliquam ornare urna sed vestibulum vestibulum. Donec at enim arcu. Aenean volutpat aliquam maximus. Aenean id scelerisque dolor, eget congue eros. Integer a mi non velit cursus aliquam vitae eu libero. Aliquam rutrum lorem eu vehicula feugiat. In hac habitasse platea dictumst. Aliquam erat volutpat.";
		final String messageAfterLoggingOut = "Welcome to the Totara Learn Demo site!";
		
		
		startPage = new StartPage(driver);
		startPage.goTologinPage();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginIn("demoadmin", "demoadmin");
		MainDashboardPage mainDashboardPage = new MainDashboardPage(driver);
		mainDashboardPage.enterMO();
		ManageOrganisationsPage manageOrganisationsPage = new ManageOrganisationsPage(driver);
		manageOrganisationsPage.addNewOF();
		AddNewOrganisationFrameworkPage addNewOrganisationFrameworkPage = new AddNewOrganisationFrameworkPage(driver);
		addNewOrganisationFrameworkPage.insertName(nameFramework);
		addNewOrganisationFrameworkPage.insertId(idFramework);
		addNewOrganisationFrameworkPage.insertDescription(descriptionFramework);
		addNewOrganisationFrameworkPage.saveChanges();
		assertEquals("The organisation framework \"" + nameFramework + "\" has been added" , manageOrganisationsPage.getAlertMessage());
		manageOrganisationsPage.selectFramework(nameFramework);
		OrganisationFrameworkPage organisationFrameworkPage = new OrganisationFrameworkPage(driver);
		organisationFrameworkPage.clickAddNewOrganisation();
		AddNewOrganisationPage addNewOrganisationPage = new AddNewOrganisationPage(driver);
		addNewOrganisationPage.insertName(nameOrganisation);
		addNewOrganisationPage.insertId();
		addNewOrganisationPage.insertDescription(descriptionOrganisation);
		addNewOrganisationPage.saveChanges();
		assertEquals("The organisation \"" + nameOrganisation + "\" has been added" , organisationFrameworkPage.getAlertMessage());
		organisationFrameworkPage.addNewGoal();
		AddNewGoalPage addNewGoalPage = new AddNewGoalPage(driver);
		addNewGoalPage.chooseGoal();
		Thread.sleep(1000);
		addNewGoalPage.saveGoals();
		organisationFrameworkPage.logOut();
		assertTrue(startPage.verifyTextPresent(messageAfterLoggingOut));		
		Thread.sleep(2000);
	}
	
	@Test
	public void shouldFindCertificationCompletionList() throws InterruptedException {
		startPage = new StartPage(driver);
		startPage.goTologinPage();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginIn("manager", "manager");
		ManagerDashbordPage managerDashbord = new ManagerDashbordPage(driver);
		managerDashbord.clickOnCertificationCompletion();
		CertificationCompletionPage certificationCompletion = new CertificationCompletionPage(driver);
		certificationCompletion.setSelectProperty("starts with");		
		certificationCompletion.enterName("Jason");
		certificationCompletion.searchResults();		
		assertEquals("27 Jul 2018 at 09:55", certificationCompletion.checkValuesFromTable().get(0));
		assertEquals("Supervisor", certificationCompletion.checkValuesFromTable().get(1));
		assertEquals("Internal Helpdesk", certificationCompletion.checkValuesFromTable().get(2));
		certificationCompletion.saveSearch();
		SaveSearchPage saveSearchPage = new SaveSearchPage(driver);
		saveSearchPage.enterName("Search Jason");
		saveSearchPage.saveChanges();
		certificationCompletion.clearSearch();
		certificationCompletion.setSelectStatusProperty("is equal to");
		certificationCompletion.setStatusType("Expired");
		certificationCompletion.searchResults();
		List<String> listOfMembers = certificationCompletion.getNamesFromTable();
		certificationCompletion.setViewSearch("Search Jason");
		assertTrue(certificationCompletion.verifyIfNamePresent("Jason Cochran"));
	
		Thread.sleep(2000);
		
		for (String str : listOfMembers) {
			System.out.println(str);
			
		}
	}
	
	@Test
	public void shouldAddANewEvent() throws InterruptedException {
		startPage = new StartPage(driver);
		startPage.goTologinPage();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginIn("coursecreator", "coursecreator");
		TrainerDashboardPage trainerDashboardPage = new TrainerDashboardPage(driver);
		trainerDashboardPage.selectEvent();
		CalendarPage calendar = new CalendarPage(driver);
		List<String> eventMai = calendar.getEventDetails();
		calendar.signUp();
		ResuscitationTraining resuscitationTraining = new ResuscitationTraining(driver);		
		assertEquals("The signup user has conflicting signups", resuscitationTraining.getAlertMessage());		
		resuscitationTraining.selectResuscitation();
		List<String> eventDecember = resuscitationTraining.getEventDetails();
		resuscitationTraining.addNewEvent();
		AddNewEventPage addNewEventPage = new AddNewEventPage(driver);
		addNewEventPage.clearSession();
		addNewEventPage.selectStartDate();		
		addNewEventPage.selectFinishDate("29", "June", "2019", "14", "00", "Europe/Warsaw");
		addNewEventPage.setCapacity("9");
		addNewEventPage.enableOverbook();
		addNewEventPage.allowCancellationsAtAnyTime();
		addNewEventPage.setMinCapacity("2");
		addNewEventPage.setNormalCost("200zł");
		addNewEventPage.setDiscountCost("150zł");
		addNewEventPage.setDetails("This is a simple test to add new events.");
		addNewEventPage.checkTrainers();
		addNewEventPage.saveChanges();
		Thread.sleep(10000);
		resuscitationTraining.logOut();
	
		System.out.println("### Resuscitation training ###");
		System.out.println("Event date/time: " + eventMai.get(0));
		System.out.println("Duration:  " + eventMai.get(1));
		System.out.println("Room: " + eventMai.get(2));
		System.out.println();
		System.out.println("### December Event ###");
		System.out.println("The event will be on " + eventDecember.get(0) + " at " + eventDecember.get(1) + " in " + eventDecember.get(2));
		
	}
	

}
