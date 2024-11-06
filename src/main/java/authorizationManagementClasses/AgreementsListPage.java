package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class AgreementsListPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Constructors..................................//
	public AgreementsListPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	//.......................Validating Report Data ...............................//
	public void validate(String TransactioID) {
		mouseOverAndClick(driver, test, "//a[contains(text(),'"+TransactioID+"')]", "Selecting Transaction ID");
	}
}
