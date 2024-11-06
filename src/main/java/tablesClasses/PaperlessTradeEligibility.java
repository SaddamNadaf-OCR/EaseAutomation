package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class PaperlessTradeEligibility extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

//---------------------------------Locators---------------------------------------------

	public static final String OCRsearchbtn = "(//button[@class='primary-btn'])[1]";
	public static final String OCRcareer="//select[@id='carrierId']";
	public static final String OCRcountryshippedfrom="//select[@id='countryShippedFromId']";
	public static final String OCRcountryshippedTo="//select[@id='countryShippedToId']";
	
	
	// --------------------Constructor------------------------------------
	

		public PaperlessTradeEligibility(WebDriver driver, ExtentTest test) {
			this.driver = driver;
			this.test = test;

		}

		// ....................click on search button......................
		public void searchbutton() {
			clickElement(driver, test, OCRsearchbtn, "clicking on search button :");
		}

		public void searchbyParameters(String Career, String CountryShippedFrom, String CountryShippedTo) {

			selectByVisibleText(driver, test, OCRcareer, "selecting Career from dropdown", Career);
			Wait.waitfor(2);
			selectByVisibleText(driver, test, OCRcountryshippedfrom, "selecting CountryShippedFrom from dropdown :", CountryShippedFrom);
			Wait.waitfor(2);
			selectByVisibleText(driver, test, OCRcountryshippedTo, "selecting CountryShippedTo from dropdown :", CountryShippedTo);
			Wait.waitfor(2);
		
		}
}
	