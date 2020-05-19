package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class LoginTest {
	
	WebDriver driver;
	
	
	/*String userName = "techfiosdemo@gmail.com";
	String passWord = "abc123";*/
	
	
	@Test
	@Parameters({"userName", "password"})
	public void validUserShouldBeAbleToLogin(String userName, String passWord) throws InterruptedException {
		driver = BrowserFactory.init();
		
		LoginPage loginPage =  PageFactory.initElements(driver, LoginPage.class);
		
		loginPage.enterUserName(userName);
		loginPage.enterPassword(passWord);
		loginPage.clickOnSignInButton();
		
		DashboardPage dashboardPage =  PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.verifyDashboardPage();
		
		BrowserFactory.tearDown();
	}

}
