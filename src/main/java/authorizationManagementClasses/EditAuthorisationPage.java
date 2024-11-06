package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class EditAuthorisationPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Locators........................................//
	public static final String Auth_Mana_AuthorizationDetailst="//button[contains(text(),'Authorization Details')]";
	
	//..................................Constructors..................................//
	public EditAuthorisationPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//..........................Click on Authorization Details .........................//
	public void authorizationDetails() {
		scrollToElement(driver, Auth_Mana_AuthorizationDetailst);
		clickElement(driver, test, Auth_Mana_AuthorizationDetailst, "Clicking on Authorization Details :");
	}

}
