package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class TradeProgramPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

//---------------------------------Locators---------------------------------------------

	public static final String OCRsearchbtn = "(//button[@class='primary-btn'])[1]";
	public static final String OCRAddAgencybtn = "(//button[@class='primary-btn'])[2]";
	public static final String OCRtradeprogramcountry="//select[@id='createSearchProductFtaGspProgram_productFtaGspProgramValue_tradeProgCountrycode']";
	public static final String OCRsplprogindicator="//input[@id='createSearchProductFtaGspProgram_productFtaGspProgramValue_ftaGsp']";
	public static final String OCRspclprogram="//input[@id='createSearchProductFtaGspProgram_productFtaGspProgramValue_specialProgName']";
	public static final String OCRcountry="//input[@id='createSearchProductFtaGspProgram_countryName']";
	public static final String OCRststyus="//select[@name='productFtaGspProgramValue.status']";
	public static final String OCRortby="//select[@name='sortBy']";
	public static final String OCRdirection="//select[@name='direction']";
	
	//-----------------------------Add Locator-----------------------------------------------
	public static final String OCRsplprogramindicator="//input[@id='editProductFtaGspProgram_productFtaGspProgramValue_ftaGsp']";
	public static final String OCRspclprogname="//input[@id='editProductFtaGspProgram_productFtaGspProgramValue_specialProgName']";
	public static final String OCRpartcipcountry="//textarea[@id='editProductFtaGspProgram_productFtaGspProgramValue_countryIsoCode']";
	public static final String OCRsavebtn="//button[@name='save']";
	
	
	// --------------------Constructor------------------------------------
	

	public TradeProgramPage(WebDriver driver, ExtentTest test) {
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

	public void searchbyParameters(String TradeProgramCountry, String SpecialProgramIndicator, String SpecialProgram, String Country, String Status, String sortby, String direction) {

		selectByVisibleText(driver, test, OCRtradeprogramcountry, "selecting trade program country", TradeProgramCountry);
		Wait.waitfor(2);
		typeText(driver, test, OCRsplprogindicator, "Entering special program indicator:", SpecialProgramIndicator);
		Wait.waitfor(2);	
		typeText(driver, test, OCRspclprogram, "Entering special program :", SpecialProgram);
		Wait.waitfor(2);	
		typeText(driver, test, OCRcountry, "Entering country :", Country);
		Wait.waitfor(2);	
		selectByVisibleText(driver, test, OCRststyus, "selecting created by dropdown :", Status);
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCRortby, "selecting sortby  dropdown :", sortby);
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCRdirection, "selecting direction by dropdown :", direction);
		Wait.waitfor(2);
	}
	// .....................addParameter...............................//

	public void addbyParameters(String SpecialProgName, String ParticipCountryCode) {

		typeText(driver, test, OCRsplprogramindicator, "Entering hazmat ID:", randomnumbers());
		Wait.waitfor(2);	
		typeText(driver, test, OCRspclprogname, "Entering country :", SpecialProgName);
		Wait.waitfor(2);
		typeText(driver, test, OCRpartcipcountry, "Entering participating country:", ParticipCountryCode);
		Wait.waitfor(2);	
		
		
	}
	public void scrolltosavebtn() {
		scrollToElement(driver, OCRsavebtn);
	}
}
	
	
