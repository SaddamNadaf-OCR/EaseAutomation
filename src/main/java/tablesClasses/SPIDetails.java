package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class SPIDetails extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

//---------------------------------Locators---------------------------------------------

	public static final String OCRsearchbtn = "//button[@name='save']";
	public static final String OCRAddAgencybtn = "(//button[@class='primary-btn'])[2]";
	public static final String OCRCountryCode="//input[@id='resultSpiDetails_country']";
	public static final String OCRFTACode="//input[@id='resultSpiDetails_spiDetailsValue_ftaCode']";
	public static final String OCRSPICode="//input[@id='resultSpiDetails_spiDetailsValue_spiCode']";
	public static final String OCRstatus="//select[@id='resultSpiDetails_spiDetailsValue_status']";
	public static final String OCRLanguageCode="//select[@id='resultSpiDetails_spiDetailsValue_languageCode']";
	public static final String OCRSortby="//select[@name='sortBy']";
	public static final String OCRDirection="//select[@name='direction']";
	
	//-----------------------------Add Locator-----------------------------------------------
		public static final String OCRHazmatId="//input[@id='editHazmat_hazmat_ocrHazmatUnqId']";
		public static final String OCRsavebtn="//button[@name='save']";
		
		
		// --------------------Constructor------------------------------------
		

		public SPIDetails(WebDriver driver, ExtentTest test) {
			this.driver = driver;
			this.test = test;

		}

		// ....................click on search button......................
		public void searchbutton() {
			clickElement(driver, test, OCRsearchbtn, "clicking on search button :");
		}

		public void addbutton() {
			clickElement(driver, test, OCRAddAgencybtn, "clicking on Add button :");
		}

		public void savebtn() {
			clickElement(driver, test, OCRsavebtn, "clicking on save button :");
		}
		// .....................searchParameter...............................//

		public void searchbyParameters(String CountryCode, String Status, String LanguageCode, String FTACode, String SPICode, String sortby, String direction) {

			typeText(driver, test, OCRCountryCode, "Entering doc type code :", CountryCode);
			Wait.waitfor(2);			
			selectByVisibleText(driver, test, OCRstatus, "selecting set id For by dropdown", Status);
			Wait.waitfor(2);
			selectByVisibleText(driver, test, OCRLanguageCode, "selecting set id For by dropdown", LanguageCode);
			Wait.waitfor(2);
			typeText(driver, test, OCRFTACode, "Entering doc type description :", FTACode);
			Wait.waitfor(2);
			typeText(driver, test, OCRSPICode, "Entering doc type code :", SPICode);
			Wait.waitfor(2);	
			selectByVisibleText(driver, test, OCRSortby, "selecting sortby  dropdown :", sortby);
			Wait.waitfor(2);
			selectByVisibleText(driver, test, OCRDirection, "selecting direction by dropdown :", direction);
			Wait.waitfor(2);
		}

}