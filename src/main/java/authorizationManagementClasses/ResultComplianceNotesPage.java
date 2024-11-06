package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ResultComplianceNotesPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	//......................................Locators .................................................//
	public static final String Auth_Mana_ResultAuthActivity="//h3[@class='page-heading']";
	
	//...................................Constructors............................................//
	public ResultComplianceNotesPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//..........................Title of the page is Displayed or not................................//
	public void titleIsDisplayed() {
		try {
			if(isDisplayed(driver, Auth_Mana_ResultAuthActivity)) {
				test.log(LogStatus.PASS, "Title is Displayed : Results Authorization Activity");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Title is not Displayed : Results Authorization Activity");
		}
	} 
}
