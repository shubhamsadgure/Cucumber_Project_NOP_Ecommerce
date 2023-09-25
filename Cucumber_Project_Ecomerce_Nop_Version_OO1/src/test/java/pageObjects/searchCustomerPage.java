package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilites.waitHealper;

public class searchCustomerPage {
	
	
	WebDriver ldriver;
	Actions act;
	waitHealper wait;
	String a1="far fa-angle-down";
	
	public searchCustomerPage(WebDriver rdriver) {
		
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
			
	}
	
	
	//Searching The Customer by Email Id
	
		@FindBy(id="SearchEmail")
		WebElement searcEmail;
		
		@FindBy(xpath="//button[@id='search-customers']")
		WebElement searchBtn;
		
		@FindBy(id="SearchFirstName")
		WebElement firstName;
		
		@FindBy(id="SearchLastName")
		WebElement lastName;
		
		@FindBy(xpath="//input[@id='SearchCompany']")
		WebElement companyName;
		
		@FindBy(xpath="//div[@role='listbox']")
		WebElement customerRole;
		
		@FindBy(xpath="//table[@id='customers-grid']//tbody")
		WebElement table;
		
		@FindBy(xpath="//table[@id='customers-grid']//tbody/tr")
		List<WebElement> tblRow;
		
		@FindBy(xpath="//table[@id='customers-grid']//tbody/tr/td")
		List<WebElement> tblclum;
		
		@FindBy(xpath="//i[@class='far fa-angle-down']")
		WebElement angleDown;
		

		public void setSearchbox(String searchbox) {
			wait=new waitHealper(ldriver);
	
			String a2 = ldriver.getPageSource();
			if(a2.contains(a1)) {
			
			 System.out.println("We Need To Open Search");
			 this.angleDown.click();
		     this.searcEmail.sendKeys(searchbox);
			}
			else {
				
				System.out.println("We dont Need To Open Search");
				this.searcEmail.sendKeys(searchbox);
			}
		}

		public void setFirstName(String firstName) {
			
			wait=new waitHealper(ldriver);
			String a3 = ldriver.getPageSource();
			
			if(a3.contains(a1)) {
				
				 System.out.println("We Need To Open Search");
				 this.angleDown.click();
				 wait.waitForElement(this.firstName,Duration.ofSeconds(6));
				 this.firstName.sendKeys(firstName);
				}
				else {
					
					System.out.println("We dont Need To Open Search");
					wait.waitForElement(this.firstName,Duration.ofSeconds(6));
					this.firstName.sendKeys(firstName);;
				}
			
			
		}

		public void setLastName(String lastName) {
			this.lastName.sendKeys(lastName);;
		}

		public void setCompanyName(String companyName) {
			this.companyName.sendKeys(companyName);
		}

		public void setCustomerRole(String customerRole) {
			
			wait.waitForElement(this.customerRole,Duration.ofSeconds(4));
			act=new Actions(ldriver);
			act.click(this.customerRole);
			act.sendKeys(Keys.BACK_SPACE);
			this.customerRole.sendKeys(customerRole); ;
		}
		
		public void setSearchBtn() {
			
			wait=new waitHealper(ldriver);
			wait.waitForElement(this.searchBtn,Duration.ofSeconds(6));
			this.searchBtn.click(); ;
		}
		
		public int getRow() {
			
			 return(this.tblRow.size());	
		}
		
		public int getclum() {
			 return(this.tblclum.size());	
		}
		
		public boolean serchCustomerByEmail(String email) {
			
			boolean flag=false;
			
			for(int i=1; i<=getRow(); i++ ) {
				
				  String emailId = ldriver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+ i +"]/td[2]")).getText();
				  
				  if(emailId.equals(email)) {
				
					  flag=true;
				  }
				  
				  System.out.println(emailId+"Is Present In Table...................");
			}
			
			return flag;
		}
		
		
		public boolean searchCustomerByName(String name) {
			
			boolean flag=false;
			
			
			for(int i=1; i<=getRow(); i++) {
				
				String Name = ldriver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+ i +"]/td[3]")).getText();
				
				if(Name.equals(name)) {
					
					System.out.println(Name+"Is Present In Table...................");
					 flag=true;
				}
			}
			
			return flag;
			
		}
		

}
