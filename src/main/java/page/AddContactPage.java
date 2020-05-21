package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddContactPage extends BasePage {

	WebDriver driver;

	public AddContactPage(WebDriver driver) {
		this.driver = driver;
	}

	// Element Liberary

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'CRM')]")
	WebElement CRM_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Add Contact')]")
	WebElement ADD_CONTACT_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//input[@id='account']")
	WebElement Full_NAME_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//input[@id='company']")
	WebElement COMPANY_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//input[@id='email']")
	WebElement EMAIL_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//input[@id='phone']")
	WebElement PHONE_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//input[@id='address']")
	WebElement ADDRESS_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//input[@id='city']")
	WebElement CITY_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//input[@id='state']")
	WebElement STATE_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//input[@id='zip']")
	WebElement ZIP_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//button[@id='submit']")
	WebElement SUBMIT_BUTTON_LOCATOR;
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'List Contacts')]")
	WebElement LIST_CONTACTS_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//div[@class='input-group']//descendant::input[@class='form-control']")
	WebElement LIST_CONTACTS_SEARCH_BAR_LOCATOR;
	@FindBy(how = How.XPATH, using = "//BUTTON[@class='btn btn-primary']")
	WebElement LIST_CONTACTS_SEARCH_BUTTON_LOCATOR;
	

	// Methods to interact with the elements
	public void crmButton() {
		CRM_FIELD_LOCATOR.click();
	}

	public void addContactButton() {
		ADD_CONTACT_FIELD_LOCATOR.click();
	}

	String enterName;

	public void fullNameField(String fullName) throws InterruptedException {
		Thread.sleep(3000);
		enterName = fullName + BasePage.randomNumGenerator();
		Full_NAME_FIELD_LOCATOR.sendKeys(enterName);
	}

	public void companyField(String company) {
		COMPANY_FIELD_LOCATOR.sendKeys(company + BasePage.randomNumGenerator());
	}

	public void emailField(String email) {
		EMAIL_FIELD_LOCATOR.sendKeys(email + BasePage.randomNumGenerator());
	}

	public void phoneField(String phoneNumber) {
		PHONE_FIELD_LOCATOR.sendKeys(phoneNumber);
	}

	public void addressField(String address) {
		ADDRESS_FIELD_LOCATOR.sendKeys(address);
	}

	public void cityField(String city) {
		CITY_FIELD_LOCATOR.sendKeys(city);
	}

	public void stateField(String state) {
		STATE_FIELD_LOCATOR.sendKeys(state);
	}

	public void zipField(String zip) {
		ZIP_FIELD_LOCATOR.sendKeys(zip);
	}

	public void submitButtonClick() throws InterruptedException {
		SUBMIT_BUTTON_LOCATOR.click();
		Thread.sleep(5000);
	}

	public void clickListContacts() throws InterruptedException {
		LIST_CONTACTS_FIELD_LOCATOR.click();
		Thread.sleep(2000);
	}

	// tbody/tr[i]/td[2]//following-sibling::td[4]/a[2]

	// tbody/tr[1]/td[2]
	// tbody/tr[i]/td[2]
	String before_xpath = "//tbody/tr[";
	String after_xpath = "]/td[2]";

	public void verifyEnteredContactAndDelete() throws InterruptedException {
		for (int i = 1; i <= 10; i++) {
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			// System.out.println(name);
			if (name.contains(enterName)) {
				System.out.println("Entered name exists.");
				driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[2]//following-sibling::td[4]/a[2]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
			}

		}
	}
	
	public void listContactSearchBarTest() {
		LIST_CONTACTS_SEARCH_BAR_LOCATOR.sendKeys(enterName);
		LIST_CONTACTS_SEARCH_BUTTON_LOCATOR.click();
	}
	
	//tbody/tr[1]/td[2]//following-sibling::td[4]/a[2]
	public void listContactViewButtonTest() throws InterruptedException {
		for (int i = 1; i <= 10; i++) {
			//Thread.sleep(3000); 
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			//Thread.sleep(3000);
			//System.out.println(name);
			if (name.contains(enterName)) {
				System.out.println("Entered name exists.");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[6]/a[1]")).click();
				Thread.sleep(5000);
				//i=11; //not required still adding to end the loop as the dynamic table is not available on Contact View page
				LIST_CONTACTS_FIELD_LOCATOR.click(); //going back to List Contacts page
					
					}

		}
	}

}
