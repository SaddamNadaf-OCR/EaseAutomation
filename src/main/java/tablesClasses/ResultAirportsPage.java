package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ResultAirportsPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
// -------------------------------Locators-----------------------------------------------//
	public static final String OCR_Airports_Title = "//h3[@class='page-heading']";
	public static final String OCR_serchcontyconfigtitle="//h3[@class='page-heading']";

	// ----------------------------------Constructor------------------------------------------//

	public ResultAirportsPage(WebDriver driver, ExtentTest test) {
			this.driver = driver;
			this.test = test;
	}
			
	/* ******************** Actions ********************************* */
	// Title of Airports page is displaying or not
	public void AirportsIsDisplayed() {
		try {
			isDisplayed(driver, OCR_Airports_Title);
				test.log(LogStatus.PASS, "Result Airports Is Displayed");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Result Airports  Is Not Displayed");

			}}
	//----------------search result page is displayed--------------------------
	public void searchresultIsDisplayed() {
		try {
			isDisplayed(driver, OCR_Airports_Title);
				test.log(LogStatus.PASS, "Result page Is Displayed");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Result page Is Not Displayed");

			}}
	
	
	
	// Title of countryconfig search page is displaying or not
		public void countryconfigsrchpage() {
			try {
				isDisplayed(driver, OCR_serchcontyconfigtitle);
					test.log(LogStatus.PASS, "Result searchcountry config Is Displayed");
				} catch (Exception e) {
					testFailSshot(driver, test);
					test.log(LogStatus.FAIL, "Resultsearch country config  Is Not Displayed");

					}
	
}}
