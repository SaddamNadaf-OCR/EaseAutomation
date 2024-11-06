package crsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class ExportRequestLicenseQuestionPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/******************************** Locators *********************************/
	public static final String OCR_ExportRequest_LicenseQuestion_NACheckBox = "//legend[contains(text(),'License Questions')]//input[@name='notApplicable']";
	public static final String OCR_ExportRequest_License_1_Y = "//input[@id='editExportRequest_responseObjective_0_Y']";
	public static final String OCR_ExportRequest_License_1_N = "//input[@id='editExportRequest_responseObjective_0_N']";
	public static final String OCR_ExportRequest_License_1_YTexbox = "//textarea[@id='remLength0']";
	public static final String OCR_ExportRequest_License_2_Texbox = "//textarea[@id='descriptive0']";
	public static final String OCR_ExportRequest_License_3_Y = "//input[@id='editExportRequest_responseObjective_2_Y']";
	public static final String OCR_ExportRequest_License_3_N = "//input[@id='editExportRequest_responseObjective_2_N']";
	public static final String OCR_ExportRequest_License_4_Y = "//input[@id='editExportRequest_responseObjective_3_Y']";
	public static final String OCR_ExportRequest_License_4_N = "//input[@id='editExportRequest_responseObjective_3_N']";
	public static final String OCR_ExportRequest_License_5_Y = "//input[@id='editExportRequest_responseObjective_4_Y']";
	public static final String OCR_ExportRequest_License_5_N = "//input[@id='editExportRequest_responseObjective_4_N']";
	public static final String OCR_ExportRequest_License_6_Y = "//input[@id='editExportRequest_responseObjective_5_Y']";
	public static final String OCR_ExportRequest_License_6_N = "//input[@id='editExportRequest_responseObjective_5_N']";
	public static final String OCR_ExportRequest_License_7_TextBox = "//textarea[@id='descriptive1']";

}
