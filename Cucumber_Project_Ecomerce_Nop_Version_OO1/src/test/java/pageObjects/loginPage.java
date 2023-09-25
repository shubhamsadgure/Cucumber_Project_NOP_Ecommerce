package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

	public WebDriver ldriver;

	public loginPage(WebDriver rdriver) {

		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "Email")
	WebElement txtEmail;

	@FindBy(id = "Password")
	WebElement txtPassword;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement btnLogin;

	@FindBy(linkText = "Logout")
	WebElement btnLogout;
	

	public void setTxtEmail(String uname) {

		txtEmail.clear();
		txtEmail.sendKeys(uname);
	}

	public void setTxtPassword(String pwd) {

		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}

	public void clickBtnLogin() {

		btnLogin.click();
	}

	public void clickBtnLogout() {

		btnLogout.click();
	}

}
