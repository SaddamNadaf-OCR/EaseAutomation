package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class SemiAnnualSummaryReport2023Page extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	//....................................Locators ......................................//
	public static final String ResultAuth_ResultAuthorization="//h3[@class='page-heading']";
	
	//...................................Constructors............................................//
	public SemiAnnualSummaryReport2023Page(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//..........................Title of the page is Displayed or not................................//
	public void titleIsDisplayed() {
		try {
			if(isDisplayed(driver, ResultAuth_ResultAuthorization)) {
				test.log(LogStatus.PASS, "Title is Displayed : Results Semi-Annual Summary Report 2023 Page ");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Title is not Displayed : Results Semi-Annual Summary Report 2023 Page ");
		}
	} 
}