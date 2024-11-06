package crsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class TypeOfExport extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************Locators********************* */

	public static final String OCR_TypeOfExport_PermanentExportHardwareTechnicalCheckBox = "(//div[@class='col-lg-6']/input)[1]";
	// (//div[@class='col-lg-6']/input)[5]
	public static final String OCR_TypeOfExport_AgreementReExportsReTransfers_HFAGR = "//input[@id='editExportRequest_exportRequestValue_hardwareFurtheranceAgr-1']";
	public static final String OCR_TypeOfExport_TechnicalDataExports_EPBPD = "//input[@id='editExportRequest_exportRequestValue_expProdBluePrints-1']";
	public static final String OCR_TypeOfExportServices_Insta = "//input[@id='editExportRequest_exportRequestValue_installation-1']";
	public static final String OCR_saveTypeOfExportBtn = "//input[@name='saveTypeOfExport']";
	

	public TypeOfExport(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

	}

	public void ExportRequestType() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_TypeOfExport_PermanentExportHardwareTechnicalCheckBox,
				"select Permanent Hardware Technical check box");
	}

	public void AgreementReExportsReTransfers() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_TypeOfExport_AgreementReExportsReTransfers_HFAGR,
				"Click on Hardware in furtherance of Agreement");
	}

	public void TechnicalDataExport() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_TypeOfExport_TechnicalDataExports_EPBPD,
				"Click on Product blue print Check Box");
	}

	public void Services() {
		Wait.waitfor(3);
		scrollToBottom(driver);
		Wait.waitfor(2);
		clickElement(driver, test, OCR_TypeOfExportServices_Insta, "Select Installation check box");

	}

	public void saveTypeOfExport() {
		Wait.waitfor(2);
		scrollToElement(driver, OCR_saveTypeOfExportBtn);
		scrollToTop(driver);
		Wait.waitfor(2);
		clickElement(driver, test, OCR_saveTypeOfExportBtn, "Click on Save Button");
	}
	
	
}
