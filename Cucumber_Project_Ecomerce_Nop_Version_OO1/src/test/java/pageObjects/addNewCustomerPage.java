package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class addNewCustomerPage {

	public WebDriver ldriver;
	Actions act;
	

	public addNewCustomerPage(WebDriver rdriver) {

		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "(//a[@class='nav-link'])[21]")
	WebElement customer;

	@FindBy(xpath = "(//p[contains(text(),'Customers')])[2]")
	WebElement customer0;

	@FindBy(xpath = "//a[normalize-space()='Add new']")
	WebElement btnAddNewc;

	@FindBy(xpath = "//input[@id='Email']")
	WebElement txtEmail;

	@FindBy(xpath = "//input[@id='Password']")
	WebElement txtPassword;

	@FindBy(id = "FirstName")
	WebElement txtName;

	@FindBy(id = "LastName")
	WebElement txtLastname;

	@FindBy(xpath = "//label[normalize-space()='Male']")
	WebElement rdMale;

	@FindBy(xpath = "//label[normalize-space()='Female']")
	WebElement rdFemale;

	@FindBy(id = "DateOfBirth")
	WebElement txtDob;

	@FindBy(name = "Company")
	WebElement txtCname;

	@FindBy(id = "IsTaxExempt")
	WebElement isTaxExempt;

	@FindBy(xpath = "(//div[@role='listbox'])[1]")
	WebElement newSelter;

	@FindBy(xpath = "(//div[@role='listbox'])[2]")
	WebElement listBox;

	@FindBy(xpath = "//li[normalize-space()='Administrators']")
	WebElement Admin;

	@FindBy(xpath = "//li[normalize-space()='Forum Moderators']")
	WebElement forumModerator;

	@FindBy(xpath = "//li[normalize-space()='Guests']")
	WebElement guest;

	@FindBy(xpath = "//li[normalize-space()='Registered']")
	WebElement registered;

	@FindBy(xpath = "//li[contains(text(),'Vendors')]")
	WebElement vendors;

	@FindBy(id = "VendorId")
	WebElement mngOfVendor;

	@FindBy(id = "AdminComment")
	WebElement addCmt;

	@FindBy(xpath="(//button[@name='save'])[1]")
	WebElement save;
	
	@FindBy(id="customer_attribute_1_1")
	WebElement TestCB;
	
	@FindBy(tagName="body")
	WebElement body;
	
	@FindBy(xpath="//div[@class='row search-row']")
	WebElement search;
	
	@FindBy(id=("SelectedCustomerRoleIds"))
	WebElement slecustrole;
	
	@FindBy(xpath="//span[@class='k-icon k-i-close']")
	WebElement cut;
	
	// Action Methods
	
	public String getTitle() {
		
		return ldriver.getTitle();
	}

	public void clickCustomerMenu() {

		this.customer.click();
	}

	public void clickCustomer() {

		this.customer0.click();
	}

	public void ClickAddNewcBtn() {
		this.btnAddNewc.click();
	}
	
	public void setTxtEmail(String txtEmail) {

		this.txtEmail.sendKeys(txtEmail);
	}

	public void setTxtPassword(String txtPassword) {
		this.txtPassword.sendKeys(txtPassword);
	
	}

	public void setTxtName(String txtName) {
		this.txtName.sendKeys(txtName);
	}

	public void setTxtLastname(String txtLastname) {
		this.txtLastname.sendKeys(txtLastname);
	}

	// Radio Button

	public void setGender(String gender) {

		if (gender == "Male") {

			this.rdMale.click();
		}

		else if (gender == "Female") {

			this.rdFemale.click();
		}

		else {
			this.rdMale.click();
		}
	}

	public void setTxtDob(String txtDob) {
		this.txtDob.sendKeys(txtDob);
	}

	public void setTxtCname(String txtCname) {
		this.txtCname.sendKeys(txtCname);
	}

	public void setIsTaxExempt() {
		this.isTaxExempt.click();
	}

	public void setNewSelter(String a) {
		this.newSelter.sendKeys(a);
	}

	// Customer Role

	public void clearCustomerRole() throws InterruptedException {

		Select sl=new Select(this.slecustrole);
		Thread.sleep(3000);
		sl.deselectAll();
	}
	
	public void setTestCB() {
		
		this.TestCB.click();
	}

	public void setCusrol(String cusrol) throws InterruptedException{

		JavascriptExecutor j = (JavascriptExecutor) ldriver;
		j.executeScript("arguments[0].click();", cut);
		this.listBox.click();
				
		if (cusrol.equals("Administrators")) {
            
			this.Admin.click();	
		}
		
		else if (cusrol.equals("Forum Moderators")) {

			this.forumModerator.click();
		}

		else if (cusrol.equals("Guests")) {
			
			j.executeScript("arguments[0].click();",this.guest);
			
		}

		else if (cusrol.equals("Registered")) {

			j.executeScript("arguments[0].click();",this.registered);
		}

		else if (cusrol.equals("Vendors")) {

			this.vendors.click();
		}
		
		else {
			this.guest.click();
		}
	}
	
	//Drop Down
	public void setMngOfVendor( String value) throws InterruptedException {
		
		Thread.sleep(3000);
		WebElement dropDown = ldriver.findElement(By.id("VendorId"));
		Select s=new Select(dropDown);
		s.selectByValue(value);
	}
	
	public void scrollDown() {
		
		JavascriptExecutor jse = (JavascriptExecutor)ldriver;
		jse.executeScript("window.scrollBy(0,500)");
	}
	
    public void scrollUp() {
		
		JavascriptExecutor jse = (JavascriptExecutor)ldriver;
		jse.executeScript("window.scrollBy(0,-500)");
	}

	public void setAddCmt(String addCmt) {
		this.addCmt.sendKeys(addCmt);;
	}

	public void ClickOnSave() {
		this.save.click();
	}
	
	//Searching The Customer by Email Id
	
	@FindBy(xpath="//input[@id='SearchEmail']")
	WebElement searchbox;
	
	@FindBy(xpath="//button[@id='search-customers']")
	WebElement searchBtn;

}
