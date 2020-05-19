package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Element Liberary
	@FindBy(how = How.ID, using = "username") WebElement USERNAME_FIELD_LOCATOR;
	@FindBy(how = How.ID, using = "password") WebElement PASSWORD_FIELD_LOCATOR;
	@FindBy(how = How.NAME, using = "login") WebElement SIGNIN_BUTTON_LOCATOR;
	
	//Method to interact with the element
	public void enterUserName(String username) {
		USERNAME_FIELD_LOCATOR.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		PASSWORD_FIELD_LOCATOR.sendKeys(password);
	}
	
	public void clickOnSignInButton() {
		SIGNIN_BUTTON_LOCATOR.click();
	}

}
