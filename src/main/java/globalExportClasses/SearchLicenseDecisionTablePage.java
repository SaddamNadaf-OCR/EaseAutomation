package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchLicenseDecisionTablePage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_SearchLDT_ShippedToCountry = "//input[@id='searchLicenseDecision_licenseDecision_shippedToCountryName']";
	public static final String OCR_SearchLDT_ClassificationCode= "//input[@id='searchLicenseDecision_licenseDecision_classificationCode']";
	public static final String OCR_SearchLDT_AuthorizationNo = "//input[@id='searchLicenseDecision_licenseDecision_authorizationNo']"; 
	public static final String OCR_SearchLDT_SearchBtn = "//button[@name='Search']";
	
	/* ******************************* Constructor ****************************** */

	public SearchLicenseDecisionTablePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

//Enter the classification Code
	public void type_ClassificationCode(String ShippedToCountry, String ClassificationCode) {
		typeText(driver, test, OCR_SearchLDT_ShippedToCountry, "Enter the shipped to country : ", ShippedToCountry);
		typeText(driver, test, OCR_SearchLDT_ClassificationCode, "Enter the Classification Code : ", ClassificationCode);
	}
	
	//Enter the Authorization No
	public void type_AuthorizationNo(String AuthorizationNo) {
		typeText(driver, test, OCR_SearchLDT_AuthorizationNo, "Enter the Authorization No : ", AuthorizationNo);
	}
	
	//click on Search button
	public void Click_SearchBtn() {
		clickElement(driver, test, OCR_SearchLDT_SearchBtn, "Click on Search button");
	}
}
