package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateAuthorizationTransactionTypePage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
//-----------------------------------------Locators----------------------------------------------//
	
	public static final String Create_Sbu= "//input[@name='licTxnType.transactionType']";
	public static final String Create_ShipmentType = "//select[@name='licTxnType.shipmentType']";
	public static final String OCR_Save = "//button[@name='save']";
	public static final String OCR_SaveandReturn = "//button[@name='ok']";
	
	// -----------------------------Constructor---------------------------------------------//

	public CreateAuthorizationTransactionTypePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	// -----------------------------Code-------------------------------------------//

	public void enterSBU(String Sbu, String ShipmentType) {

		typeText(driver, test, Create_Sbu, "Enter Sbu :", Sbu);
		typeText(driver, test, Create_ShipmentType, "Select ShipmentType :", ShipmentType);
			
					

	}

	// -------------------------------Save-------------------------------------------------//
	public void save() {
		scrollToElement(driver, OCR_Save);
		Wait.waitfor(3);
		scrollToTop(driver);
		clickElement(driver, test, OCR_Save, "Click on Save Button ");
	}

	// --------------------------------Save&Return-------------------------------------------//
	public void saveandReturn() {
		scrollToElement(driver, OCR_SaveandReturn);
		Wait.waitfor(3);
		scrollToTop(driver);
		clickElement(driver, test, OCR_SaveandReturn, "Click on Save Button ");
	}


}
