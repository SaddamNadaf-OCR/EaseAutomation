package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewDocumentTypePage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
	//--------------------------------------------Locators-------------------------------------------//
	
	public static final String Create_DocumentTypeCode = "//input[@name='documentType.docTypeCode']";
	public static final String Create_DocumentTypeDescription = "//input[@name='documentType.docTypeDesc']";
	public static final String Create_SetID = "//select[@name='documentType.setId']";
	public static final String OCR_Save = "//button[@name='save']";
	public static final String OCR_SaveandReturn = "//button[@name='ok']";
	
	// -----------------------------Constructor---------------------------------------------//

		public CreateNewDocumentTypePage(WebDriver driver, ExtentTest test) {
			this.driver = driver;
			this.test = test;
		}

		// -----------------------------Code-------------------------------------------//

		public void enterDocumentTypeCode(String DocumentTypeCode, String DocumentTypeDescription, String SetID) {

			typeText(driver, test, Create_DocumentTypeCode, "Enter Code :", DocumentTypeCode);
			typeText(driver, test, Create_DocumentTypeDescription, "Enter Name :", DocumentTypeDescription);
			selectByVisibleText(driver, test, Create_SetID, "Enter SBUCode :", SetID);
			

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
