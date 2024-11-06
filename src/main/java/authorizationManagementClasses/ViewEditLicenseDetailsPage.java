package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class ViewEditLicenseDetailsPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Locators........................................//
	public static final String Auth_Mana_AuthorizationDetailst="//button[contains(text(),'Authorization Details')]";
	
	//..................................Constructors..................................//
	public ViewEditLicenseDetailsPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

}
