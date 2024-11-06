package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;


import utilities.GenericMethods;

public class ResultShimentWizPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_ResultShipwiz_NewSearch = "//button[contains(text(), 'New Search')]";
	// select shipment number for creating packing list
	public static final String OCR_ResultShipwiz_DocumentUploadIcon = "//i[@xpath='1']";
	
	public ResultShimentWizPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	
	
	// Click on New search button
	public void click_NewSearch() {
		clickElement(driver, test, OCR_ResultShipwiz_NewSearch, "Click on New search button");
	}
	
	// Click on document upload icon 
		public void click_documentUploadicon() {
			clickElement(driver, test, OCR_ResultShipwiz_DocumentUploadIcon, "Click on document upload icon ");
		}
	

}

