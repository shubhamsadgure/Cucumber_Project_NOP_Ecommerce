package utilites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waitHealper{

WebDriver ldriver;
	
	public waitHealper(WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);	
	}
	
	public void waitForElement(WebElement element, java.time.Duration timeOutInSeconds ) {
		
		    WebDriverWait wait = new WebDriverWait(ldriver,timeOutInSeconds);
		    wait.until(ExpectedConditions.visibilityOf(element));
	}
}
