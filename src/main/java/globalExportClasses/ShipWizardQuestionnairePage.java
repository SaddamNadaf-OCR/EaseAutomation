
package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class ShipWizardQuestionnairePage extends GenericMethods{

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	
	public static final String OCR_ShipWizardQuestion_NotApplicable = "//input[@name='notApplicable']";
	public static final String OCR_ShipWizardQuestion_SaveAndProceed = "//button[@name='proceed']";
	public static final String OCR_ShipWizardQuestion_Save = "//button[@name='save']";
	
	/* ******************************* Constructor ****************************** */

	public ShipWizardQuestionnairePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	
	// click on Not Applicable
	public void click_NotApplicable() {
		clickElement(driver, test, OCR_ShipWizardQuestion_NotApplicable, "click on Not Applicable");
	}
	
	//Click on Save and proceed
	public void click_SaveAndProceed() {
		clickElement(driver, test, OCR_ShipWizardQuestion_SaveAndProceed, "Click on Save and Proceed");
	}

	//Click on Save 
	public void click_Save() {
		clickElement(driver, test, OCR_ShipWizardQuestion_Save, "Click on Save");
	}

}
