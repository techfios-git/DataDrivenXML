package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddContactPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class AddContactTest {
	
WebDriver driver;


	@Test (priority = 1)
	@Parameters({"userName", "password", "fullName", "CompanyName", "email", "phone", "address", "city", "state", "zip"})
	public void userShouldBeAbleAddContact(String userName, String passWord, String fullName, String CompanyName, String email, String phone, String address, String city, String state, String zip) throws InterruptedException {
		driver = BrowserFactory.init();
		
		LoginPage loginPage =  PageFactory.initElements(driver, LoginPage.class);
		
		loginPage.enterUserName(userName);
		loginPage.enterPassword(passWord);
		loginPage.clickOnSignInButton();
		
		DashboardPage dashboardPage =  PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.verifyDashboardPage();
		
		AddContactPage addContact = PageFactory.initElements(driver, AddContactPage.class);
		
		addContact.crmButton();
		addContact.addContactButton();
		
		addContact.fullNameField(fullName);
		addContact.companyField(CompanyName);
		addContact.emailField(email);
		addContact.phoneField(phone);
		addContact.addressField(address);
		addContact.cityField(city);
		addContact.stateField(state);
		addContact.zipField(zip);
		addContact.submitButtonClick();
		addContact.clickListContacts();
		
		addContact.verifyEnteredContactAndDelete();
		Thread.sleep(2000);
		
		BrowserFactory.tearDown();
		
	}
	
	@Test (priority = 2)
	@Parameters({"userName", "password", "fullName", "CompanyName", "email", "phone", "address", "city", "state", "zip"})
	public void userShouldBeAbleUseSearchBarOfListContact(String userName, String passWord, String fullName, String CompanyName, String email, String phone, String address, String city, String state, String zip) throws InterruptedException {
		driver = BrowserFactory.init();
		
		LoginPage loginPage =  PageFactory.initElements(driver, LoginPage.class);
		
		loginPage.enterUserName(userName);
		loginPage.enterPassword(passWord);
		loginPage.clickOnSignInButton();
		
		DashboardPage dashboardPage =  PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.verifyDashboardPage();
		
		AddContactPage addContact = PageFactory.initElements(driver, AddContactPage.class);
		
		addContact.crmButton();
		addContact.addContactButton();
		
		addContact.fullNameField(fullName);
		addContact.companyField(CompanyName);
		addContact.emailField(email);
		addContact.phoneField(phone);
		addContact.addressField(address);
		addContact.cityField(city);
		addContact.stateField(state);
		addContact.zipField(zip);
		addContact.submitButtonClick();
		addContact.clickListContacts();
		addContact.listContactSearchBarTest();
		addContact.listContactViewButtonTest();
		
		
		
		BrowserFactory.tearDown();
		
	}

}
