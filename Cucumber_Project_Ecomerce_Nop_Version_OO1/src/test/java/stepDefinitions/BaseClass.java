package stepDefinitions;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
//import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;

import pageObjects.addNewCustomerPage;
import pageObjects.loginPage;
import pageObjects.searchCustomerPage;

public class BaseClass {
	
	public WebDriver driver;
	public loginPage lp;
	public addNewCustomerPage AddCust;
	public searchCustomerPage search;
	public static Logger logger;
	public Properties configProp;
	
	
	
	//Created for generating random string for Unique email
		public static String randomestring(){
			String generatedString1 = RandomStringUtils.randomAlphabetic(5);
			return (generatedString1);
		}


}
