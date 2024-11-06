
package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class ShipWizardTSCAReachInformationPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_TSCA_Q1_Y = "//input[@id='wizardTSCA_shipment_tscaRequiredY']";
	public static final String OCR_TSCA_Q1_N = "//input[@id='wizardTSCA_shipment_tscaRequiredN']";
	public static final String OCR_TSCA_Q2_Y = "//input[@id='wizardTSCA_shipment_exportRequirementY']";
	public static final String OCR_TSCA_Q2_N = "//input[@id='wizardTSCA_shipment_exportRequirementN']";
	public static final String OCR_TSCA_Q3_Y = "//input[@id='wizardTSCA_shipment_tscaSubstanceY']";
	public static final String OCR_TSCA_Q3_N = "//input[@id='wizardTSCA_shipment_tscaSubstanceN']";
	public static final String OCR_TSCA_Save = "//button[@id='tscaSave']";

	/* ******************************* Constructor ****************************** */

	public ShipWizardTSCAReachInformationPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Adding the TSCA Reach Information
	public void addTSCAReachInformation(String TSCAReachInfoQuestion, String TSCAReachInfoAnswer) {
		if (TSCAReachInfoQuestion.equalsIgnoreCase("Q1")) {
			if (TSCAReachInfoAnswer.equalsIgnoreCase("Y")) {
				clickElement(driver, test, OCR_TSCA_Q1_Y, "Click on Q1  TSCA 12(b) export requirements : Yes");
			} else {
				clickElement(driver, test, OCR_TSCA_Q1_N, "Click on Q1  TSCA 12(b) export requirements : No");
			}
		}
		if (TSCAReachInfoQuestion.equalsIgnoreCase("Q2")) {
			if (TSCAReachInfoAnswer.equalsIgnoreCase("Y")) {
				clickElement(driver, test, OCR_TSCA_Q2_Y, "Click on Q2  REACH export requirements : Yes");
			} else {
				clickElement(driver, test, OCR_TSCA_Q2_N, "Click on Q2  REACH export requirements : No");
			}
		}
		if (TSCAReachInfoQuestion.equalsIgnoreCase("Q3")) {
			if (TSCAReachInfoAnswer.equalsIgnoreCase("Y")) {
				clickElement(driver, test, OCR_TSCA_Q3_Y, "Click on Q3  chemical substance, mixture : Yes");
			} else {
				clickElement(driver, test, OCR_TSCA_Q3_N, "Click on Q3  chemical substance, mixture : No");
			}
		}
	}
	
	// Click on Save
	public void click_Save() {
		clickElement(driver, test,OCR_TSCA_Save, "Click on Save");
	}
	
	
	
	
}