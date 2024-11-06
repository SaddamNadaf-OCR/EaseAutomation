package crsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class DOSSearchAgreementPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_SearchAgreement_TranasactionId = "//input[@id='resultDosGeneralInfo_dosGeneralInfo_transactionId']";	
	public static final String OCR_SearchDSP5_Agreements = "//a[contains(text(),'Agreements')]/i";
	public static final String OCR_SearchDSP5_Agreement = "//li[3]//ul[1]//li[4]//div[1]//ul[1]//li[1]//a[1]";
	public static final String OCR_Button_Search="//button[contains(text(),'Search')]";

	/* ******************** Constructor ***************************** */

	public DOSSearchAgreementPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Enter Transactionid
	public void enter_transactionid(String Transactionid){
		typeText(driver, test, OCR_SearchAgreement_TranasactionId,"Enter Transactionid", Transactionid);	
	}
	
	public void click_serach() {
		clickElement(driver, test,OCR_Button_Search, "Clicking on Search Button");
	}
}
