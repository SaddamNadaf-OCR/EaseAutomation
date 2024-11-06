package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchFreightForwardersPage extends GenericMethods{
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_FF_SBUCode ="//select[@id='searchFreightForwarder_freightForwarder_sbuCode']";
	public static final String OCR_FF_code="//input[@id='searchFreightForwarder_freightForwarder_ffCode']";
	public static final String OCR_FF_name="//input[@id='searchFreightForwarder_freightForwarder_ffName']";
	public static final String OCR_FF_country="//input[@id='searchFreightForwarder_countryName']";
	public static final String OCR_FF_active="//select[@id='searchFreightForwarder_freightForwarder_active']";
	public static final String OCR_FF_status="//select[@id='searchFreightForwarder_freightForwarder_status']";
	public static final String OCR_FF_whitelistFF="//select[@id='searchFreightForwarder_freightForwarder_whitelistFF']";
	public static final String OCR_FF_Createdby="//select[@id='searchFreightForwarder_freightForwarder_createdBy']";
	public static final String OCR_FF_sortBy="(//select[@class='form-control ocr-cache-search-dynamic-class'])[6]";
	public static final String OCR_FF_Direction="(//select[@class='form-control ocr-cache-search-dynamic-class'])[7]";
public static final String OCR_FF_SearchClick="(//button[@type='submit'])[1]";

	/*
	 * ****************************** Constructor *********************************
	 */
	public SearchFreightForwardersPage (WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

	}
	/* ******************************* Actions ********************************* */

	public void searchfreitforwrders(String FFSBUCode, String Code, String name, String country) {
		
		selectByVisibleText(driver, test, OCR_FF_SBUCode, "Select SBU Code", FFSBUCode);

		Wait.waitfor(3);
		typeText(driver, test, OCR_FF_code, "enter code", Code);
		typeText(driver, test, OCR_FF_name, "enter name", name);
		clickElement(driver, test, OCR_FF_country, "click on country");
		typeText(driver, test, OCR_FF_country, "type country ", country);
		mouseOverAndClick(driver, test, OCR_FF_country, "clicking on typed country");
		
		
		
		
	}
	public void ClickonFFsearch() {
		clickElement(driver, test, OCR_FF_SearchClick, "click on FF search");
	}
	
	
	
	
	
	
	
}
