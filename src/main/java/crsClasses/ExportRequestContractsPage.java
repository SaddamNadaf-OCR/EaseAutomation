package crsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class ExportRequestContractsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/********************* Locators **********************************************/

	public static final String OCR_ExportRequest_Contracts_Y = "//input[@id='editExportRequest_exportQuestionnaireValue_underUsgCotnractY']";
	public static final String OCR_ExportRequest_Contracts_N = "//input[@id='editExportRequest_exportQuestionnaireValue_underUsgCotnractN']";
	public static final String OCR_ExportRequest_Contracts_DK = "//input[@id='editExportRequest_exportQuestionnaireValue_underUsgCotnractD']";
	public static final String OCR_ExportRequest_Contracts_Y_FMSTextBox = "//textarea[@id='editExportRequest_exportQuestionnaireValue_fmsDetails']";
	public static final String OCR_ExportRequest_Contracts_2_Y = "//input[@id='editExportRequest_exportQuestionnaireValue_dodContractsY']";
	public static final String OCR_ExportRequest_Contracts_2_N = "//input[@id='editExportRequest_exportQuestionnaireValue_dodContractsN']";
	public static final String OCR_ExportRequest_Contracts_2_DK = "//input[@id='editExportRequest_exportQuestionnaireValue_dodContractsD']";
	public static final String OCR_ExportRequest_Contracts_ContractNoTextBox = "//input[@id='editExportRequest_exportQuestionnaireValue_contractNo']";
	public static final String OCR_ExportContracts_3_Y = "//input[@id='editExportRequest_exportQuestionnaireValue_contractOffsetY']";
	public static final String OCR_ExportContracts_3_N = "//input[@id='editExportRequest_exportQuestionnaireValue_contractOffsetN']";
	public static final String OCR_ExportContracts_3_DK = "//input[@id='editExportRequest_exportQuestionnaireValue_contractOffsetD']";
	public static final String OCR_ExportRequest_Contracts_OffSiteArrangTextBox = "//textarea[@id='editExportRequest_exportQuestionnaireValue_offsetReason']";
	public static final String OCR_ExportRequestFees_1_Y = "//input[@id='editExportRequest_exportQuestionnaireValue_salesAgentInvolvedY']";
	public static final String OCR_ExportRequestFees_1_N = "//input[@id='editExportRequest_exportQuestionnaireValue_salesAgentInvolvedN']";
	public static final String OCR_ExportRequestFees_1_DK = "//input[@id='editExportRequest_exportQuestionnaireValue_salesAgentInvolvedD']";
	public static final String OCR_ExportRequestFees_2_Y = "//input[@id='editExportRequest_exportQuestionnaireValue_commissionForExportY']";
	public static final String OCR_ExportRequestFees_2_N = "//input[@id='editExportRequest_exportQuestionnaireValue_commissionForExportN']";
	public static final String OCR_ExportRequestFees_2_DK = "//input[@id='editExportRequest_exportQuestionnaireValue_commissionForExportD']";
	public static final String OCR_ExportRequestFees_2_PartyRole = "//textarea[@id='editExportRequest_exportQuestionnaireValue_natureOfArrangement']";
	public static final String OCR_Contrct_Save = "//input[@name='saveContracts']";

	/* ******************** Constructor ***************************** */

	public ExportRequestContractsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Adding Contracts Questions
	public void contractsQuestions(String ContractQuestions, String ContractAnswer) {
		if (ContractQuestions.equalsIgnoreCase("Q1")) {
			if (ContractAnswer.equalsIgnoreCase("Y")) {
				clickElement(driver, test, OCR_ExportRequest_Contracts_Y,"Click on Q1 replacement With NoCharge : Yes");
			} else if (ContractAnswer.equalsIgnoreCase("N")) {
				clickElement(driver, test, OCR_ExportRequest_Contracts_N, "Click on Q1 replacement With NoCharge : No");
			} else {
				clickElement(driver, test, OCR_ExportRequest_Contracts_DK,"Click on Q1 replacement With NoCharge : Dont know");
			}
		}
		if (ContractQuestions.equalsIgnoreCase("Q2")) {
			if (ContractAnswer.equalsIgnoreCase("Y")) {
				clickElement(driver, test, OCR_ExportRequest_Contracts_2_Y, "Click on Q2 repair Under Warrenty : Yes");
			} else if (ContractAnswer.equalsIgnoreCase("N")) {
				clickElement(driver, test, OCR_ExportRequest_Contracts_2_N, "Click on Q2 repair Under Warrenty : No");
			} else {
				clickElement(driver, test, OCR_ExportRequest_Contracts_2_DK,"Click on Q2 repair Under Warrenty : Dont Know");
			}
		}
		if (ContractQuestions.equalsIgnoreCase("Q3")) {
			if (ContractAnswer.equalsIgnoreCase("Y")) {
				clickElement(driver, test, OCR_ExportContracts_3_Y, "Click on Q3 items Controlled By USD Agency : Yes");
			} else if (ContractAnswer.equalsIgnoreCase("N")) {
				clickElement(driver, test, OCR_ExportContracts_3_N, "Click on Q3 items Controlled By USD Agency : No");
			} else {
				clickElement(driver, test, OCR_ExportContracts_3_DK,"Click on Q3 items Controlled By USD Agency : Dont Know");
			}
		}
	}

	// Adding Contracts Fees Questions
	public void feesQuestions(String FeesQuestions, String FeesAnswer) {
		if (FeesQuestions.equalsIgnoreCase("Q1")) {
			if (FeesAnswer.equalsIgnoreCase("Y")) {
				clickElement(driver, test, OCR_ExportRequestFees_1_Y,"Click on Q1 items Controlled By Foreign Agency : Yes");
			} else if (FeesAnswer.equalsIgnoreCase("N")) {
				clickElement(driver, test, OCR_ExportRequestFees_1_N,"Click on Q1 items Controlled By Foreign Agency : No");
			} else {
				clickElement(driver, test, OCR_ExportRequestFees_1_DK,"Click on Q1 items Controlled By Foreign Agency : Dont Know");
			}
		}
		scrollToBottom(driver);
		if (FeesQuestions.equalsIgnoreCase("Q2")) {
			if (FeesAnswer.equalsIgnoreCase("Y")) {
				clickElement(driver, test, OCR_ExportRequestFees_2_Y, "Click on Q2 marked As Restricted : Yes");
			} else if (FeesAnswer.equalsIgnoreCase("N")) {
				clickElement(driver, test, OCR_ExportRequestFees_2_N, "Click on Q2 marked As Restricted : No");
			} else {
				clickElement(driver, test, OCR_ExportRequestFees_2_DK, "Click on Q2 marked As Restricted : Dont Know");
			}
		}
	}

	// Click on Contract Save Button
	public void click_SaveContract() {
		scrollToElement(driver, OCR_Contrct_Save);
		clickElement(driver, test, OCR_Contrct_Save, "Click on Contract Save");
	}

}
