package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageObjects.addNewCustomerPage;
import pageObjects.loginPage;
import pageObjects.searchCustomerPage;

public class Steps extends BaseClass {

	@Before
	public void setUp() throws IOException {
		
		
		logger = Logger.getLogger("NopEcomerce");
		PropertyConfigurator.configure(".//testResource\\log4j.properties");
		

		// Reading The Properties
		configProp = new Properties();
		FileInputStream configProfile = new FileInputStream("./testResource\\config.properties");
		configProp.load(configProfile);


		String br = configProp.getProperty("browser");
		

		if (br.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));
			driver = new ChromeDriver();
		} 
		
		else if (br.equals("fireFox")) {

			System.setProperty("webdriver.grcko.driver", configProp.getProperty("geckopath"));
			driver = new FirefoxDriver();

		} 
		
		else if (br.equals("edge")) {

			System.setProperty("webdriver.edge.driver", configProp.getProperty("msedgpatg"));
			driver = new EdgeDriver();

		}
		
		

		logger.info("*******Launching Browser********");

	}
	
	

	@Given("User Launch Chrome Browser")
	public void user_launch_chrome_browser() {

		lp = new loginPage(driver);

	}

	@When("Users Open URl {string}")

	public void users_open_u_rl(String url) {

		logger.info("*******Opeaning URL********");
		driver.get(url);
	    driver.manage().window().maximize();

	}

	@And("Users Enters Email As {string} and Password as {string}")
	public void users_enters_email_as_and_password_as(String Email, String Password) {

		logger.info("*******Providing Login Details********");
		lp.setTxtEmail(Email);
		lp.setTxtPassword(Password);
	}

	@And("Click on the login button")
	public void click_on_the_login_button() {

		logger.info("*******Clicking on Login Button********");

		lp.clickBtnLogin();

	}

	@And("Page Title Should be {string}")
	public void page_title_should_be(String title) throws InterruptedException {

		if (driver.getPageSource().contains("Login was unsuccessful")) {

			driver.close();
			logger.info("*******Loggin Passed********");
			Assert.assertTrue(false);
		}

		else {

			logger.info("*******Getting Title********");
			Assert.assertEquals(title, driver.getTitle());

		}
		Thread.sleep(2000);
	}

	@When("User click on the logout button")
	public void user_click_on_the_logout_button() throws InterruptedException {

		logger.info("*******Clicking on LogOut Button********");
		lp.clickBtnLogout();
		Thread.sleep(3000);
	}

	@Then("logout page title should be {string}")
	public void logout_page_title_should_be(String titleLg) {

		if (driver.getPageSource().contains("Your store. Login")) {

			logger.info("*******Loggout Passed********");
			Assert.assertTrue(true);
		}

		else {

			logger.info("*******Logot failed********");
			driver.close();
			Assert.assertTrue(false);

		}

	}

	@And("Close the browser")
	public void close_the_browser() throws InterruptedException {

		logger.info("*******Closing The Browser********");
		Thread.sleep(2000);
		driver.quit();
	}

	// Failed Login.......................................................

	@Then("Failed login Page Title Should be {string}")
	public void failed_login_page_title_should_be(String string) {

		if (driver.getPageSource().contains("Login was unsuccessful. Please correct the errors and try again.")) {

			logger.info("*******Loggin Failed********");
			Assert.assertTrue(true);
		}

		else {

			driver.close();
			Assert.assertTrue(false);

		}
	}

	// Add New Customor Steps...................................................

	@Then("User can see the dashboard")
	public void user_can_see_the_dashboard() {

		logger.info("*******Getting Title********");
		AddCust = new addNewCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", AddCust.getTitle());

	}

	@When("User click on customer menu")
	public void user_click_on_customer_menu() throws InterruptedException {
		logger.info("*******Clicking On Customer Main Menu********");
		Thread.sleep(2000);
		AddCust.clickCustomerMenu();
	}

	@And("click on customer menu item")
	public void click_on_customer_menu_item() throws InterruptedException {
		logger.info("*******Clicking on Cutomer sub Menu********");
		Thread.sleep(2000);
		AddCust.clickCustomer();
	}

	@And("click on add new customer button")
	public void click_on_add_new_customer_button() throws InterruptedException {

		logger.info("*******Clicking on Add Cuctomer Btn********");
		Thread.sleep(2000);
		AddCust.ClickAddNewcBtn();
	}

	@Then("User can see add new customer page")
	public void user_can_see_add_new_customer_page() throws InterruptedException {
		logger.info("*******User Can See Add Cuctomer Page********");
		Thread.sleep(2000);
		Assert.assertEquals("Add a new customer / nopCommerce administration", AddCust.getTitle());
	}

	@When("User enter new customer info")
	public void user_enter_new_customer_info() throws InterruptedException {

		logger.info("*******Adding Cuctomer Details********");
		String email = randomestring() + "@gmail.com";
		Thread.sleep(2000);
		AddCust.setTxtEmail(email);
		AddCust.setTxtPassword("m123");
		AddCust.setTxtName("flix");
		AddCust.setTxtLastname("movies");
		AddCust.setGender("male");
		AddCust.setTxtDob("9/4/2023");
		AddCust.setTxtCname("tom");
		// AddCust.setTestCB();
		AddCust.setIsTaxExempt();
		// AddCust.setNewSelter("Test store 2");
		Thread.sleep(2000);
		AddCust.scrollDown();
		Thread.sleep(2000);
		AddCust.setCusrol("Registered");
		AddCust.setMngOfVendor("2");
		AddCust.setAddCmt("ABC");
		Thread.sleep(2000);
		AddCust.scrollUp();

	}

	@And("Click on save button")
	public void click_on_save_button() {

		logger.info("*******Clicking on save Button********");
		AddCust.ClickOnSave();

	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String string) {

		logger.info("*******User Can See The new customer has been added successfully*******");

		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains("The new customer has been added successfully."));

	}

	// Searching The Customer Using Email Id...................

	@When("Enter customer email")
	public void enter_customer_email() throws InterruptedException {

		logger.info("*******Entering Cuctomer Menu*******");
		search = new searchCustomerPage(driver);
		search.setSearchbox("admin@yourStore.com");
	}

	@When("click on search button")
	public void click_on_search_button() throws InterruptedException {
		logger.info("*******Clicking on search Button*******");
		search.setSearchBtn();
		Thread.sleep(2000);
	}

	@Then("user shoud found email in the search table")
	public void user_shoud_found_email_in_the_search_table() {

		logger.info("*******Searchin email i table*******");
		boolean status = search.serchCustomerByEmail("admin@yourStore.com");

		Assert.assertEquals(true, status);
	}

	// Searching The Customer Using first and last name...................

	@And("Enter customer first and last name")
	public void enter_customer_first_and_last_name() {

		logger.info("*******Entering First Name*******");
		search = new searchCustomerPage(driver);
		// search.enterFirstAndLastName("flix","movies");
		search.setFirstName("flix");
		search.setLastName("movies");
	}

	@Then("user shoud found first and last name in the search table")
	public void user_shoud_found_first_and_last_name_in_the_search_table() {

		logger.info("*******Searching name in table*******");
		search.searchCustomerByName("flix movies");
	}

}
