package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashboardPage {
WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Element Liberary
	@FindBy(how = How.XPATH, using = "//span[contains(text(), 'Dashboard')]") WebElement DASHBOARD_FIELD_LOCATOR;
	
	
	//Method to interact with the element
	public void verifyDashboardPage() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertEquals(DASHBOARD_FIELD_LOCATOR.getText(), "Dashboard", "Title haven't mached!!");
	}
}
