package importOperationClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;
import utilities.Wait;

public class EntrySummarySpecialDetailsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_ESSD_ForeignExporterLink = "//a[@id='foreignExporter-Popup']";
	public static final String OCR_ESSD_ADCaseNoLink = "//a[@id='addPopup']";
	public static final String OCR_ESSD_ADPaymentMode = "//select[@id='editImport7501ItemDetails_import7501ItemDetailsValue_adaPayType']";
	public static final String OCR_ESSD_ADCaseDepositRate = "//input[@id='editImport7501ItemDetails_adaRate']";
	public static final String OCR_ESSD_ADCaseRateType = "//select[@id='editImport7501ItemDetails_import7501ItemDetailsValue_adRateType']";
	public static final String OCR_ESSD_ADGoodsValue = "//input[@id='editImport7501ItemDetails_adGoodsValue']";
	public static final String OCR_ESSD_ADQuantity = "//input[@id='editImport7501ItemDetails_adQuantity']";
	public static final String OCR_ESSD_ADDutyAmount = "//input[@id='editImport7501ItemDetails_adaDuty']";
	public static final String OCR_ESSD_CVCaseNoLink = "//a[@id='cvdPopup']";
	public static final String OCR_ESSD_CVPaymentMode = "//select[@id='editImport7501ItemDetails_import7501ItemDetailsValue_cvdPayType']";
	public static final String OCR_ESSD_CVCaseDepositRate = "//input[@id='editImport7501ItemDetails_cvdRate']";
	public static final String OCR_ESSD_CVCaseRateType = "//select[@id='editImport7501ItemDetails_import7501ItemDetailsValue_cvdRateType']";
	public static final String OCR_ESSD_CVCaseGoodsValue = "//input[@id='editImport7501ItemDetails_cvdGoodsValue']";
	public static final String OCR_ESSD_CVQuantity = "//input[@id='editImport7501ItemDetails_cvdQuantity']";
	public static final String OCR_ESSD_CVDutyAmount = "//input[@id='editImport7501ItemDetails_cvdDuty']";
	public static final String OCR_ESSD_ADCVDNonRS = "//input[@id='editImport7501ItemDetails_adCvdStmtDecleration']";
	public static final String OCR_ESSD_CategoryCode = "//input[@id='editImport7501ItemDetails_import7501ItemDetailsValue_textileCategoryCode']";
	public static final String OCR_ESSD_DateOfExport = "//input[@id='editImport7501ItemDetails_textileDateOfExport']";
	public static final String OCR_ESSD_VisaQuantity = "//input[@id='editImport7501ItemDetails_visaQuantity']";
	public static final String OCR_ESSD_LCPermitTypeLink = "//a[@id='licenseCertifcatePermitType-popup']";
	public static final String OCR_ESSD_CottonOrganicExemptionNo = "//input[@id='editImport7501ItemDetails_import7501ItemDetailsValue_cottonOrgExmtCertNo']";
	public static final String OCR_ESSD_AdditionalDeclaration = "//select[@id='editImport7501ItemDetails_import7501ItemDetailsValue_additionalDecleration']";
	public static final String OCR_ESSD_SoftwoodLumberDeclaration = "//input[@id='editImport7501ItemDetails_softwdLumbDeclaration']";
	public static final String OCR_ESSD_SoftwoodLumberExportPrice = "//input[@id='editImport7501ItemDetails_softwdLumbExportPrice']";
	public static final String OCR_ESSD_StandardVisaNumber = "//input[@id='editImport7501ItemDetails_import7501ItemDetailsValue_standardVisaNo']";
	public static final String OCR_ESSD_VisaUOM = "//input[@id='editImport7501ItemDetails_import7501ItemDetailsValue_visaUom']";
	public static final String OCR_ESSD_LicenseCertificatePermitNo = "//input[@id='editImport7501ItemDetails_import7501ItemDetailsValue_licCertPermitNo']";
	public static final String OCR_ESSD_SWPMIndicator = "//select[@id='editImport7501ItemDetails_import7501ItemDetailsValue_cnHkSwpmIndicator']";
	public static final String OCR_ESSD_FirstSale = "//select[@id='editImport7501ItemDetails_import7501ItemDetailsValue_firstSale']";
	public static final String OCR_ESSD_SoftwoodLumberExportCharge = "//input[@id='editImport7501ItemDetails_softwdLumbExportCharge']";
	public static final String OCR_ESSD_AppraisementMethod = "//select[@id='editImport7501ItemDetails_import7501ItemDetailsValue_altValuationType']";
	public static final String OCR_ESSD_PriceActuallyPaid = "//input[@name='invoiceValue1']";
	public static final String OCR_ESSD_AssistSpecifiedAt = "//select[@id='editImport7501ItemDetails_import7501ItemDetailsValue_tvAssistSpecifiedAt']";
	public static final String OCR_ESSD_ApplicableAssistValue = "//input[@id='editImport7501ItemDetails_assistsValue']";
	public static final String OCR_ESSD_ConvertedAssistValue = "//input[@id='editImport7501ItemDetails_convertedAssistsValue']";
	public static final String OCR_ESSD_PackingCost = "//input[@id='editImport7501ItemDetails_packingCost']";
	public static final String OCR_ESSD_SellingCommission = "//input[@id='editImport7501ItemDetails_sellingCommission']";
	public static final String OCR_ESSD_RoyalityorLicensefee = "//input[@id='editImport7501ItemDetails_royaltyLicenseFee']";
	public static final String OCR_ESSD_ProceedsFromResale = "//input[@id='editImport7501ItemDetails_subsequentResale']";
	public static final String OCR_ESSD_Select = "(//button[@name='Ok'])[1]";
	public static final String OCR_ESSD_Close = "(//button[@class='close'])[1]";

	/* ******************** Constructor ***************************** */

	public EntrySummarySpecialDetailsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Adding Antidumping / Countervailing Duty
	public void addAntidumpingCountervailingDuty(String ForeignExporterCode, String ADCaseNoCode, String ADPaymentMode,
			String ADCaseDepositRate, String ADCaseRateType, String ADGoodsValue, String ADQuantity, String ADDutyAmount, String CVCaseNoCode, String CVPaymentMode, String CVCaseDepositRate, String CVCaseRateType, String CVCaseGoodsValue, String CVQuantity, String CVDutyAmount) {
		clickElement(driver, test, OCR_ESSD_ForeignExporterLink, "Click on Foreign Exporter Link");
		try {
			Wait.waitfor(3);
			clickElement(driver, test, "//td[contains(text(),'" + ForeignExporterCode + "')]",
					"Click on PartyCode : " + ForeignExporterCode);
			clickElement(driver, test, OCR_ESSD_Select, "Click on Select");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_ESSD_Close, "Click on Close");
		}
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ESSD_ADCaseNoLink, "Click on AD Case No Link");
		try {
			Wait.waitfor(3);
			clickElement(driver, test, "//td[contains(text(),'" + ADCaseNoCode + "')]",
					"Click on AD Case No Code : " + ADCaseNoCode);
			clickElement(driver, test, OCR_ESSD_Select, "Click on Select");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_ESSD_Close, "Click on Close");
		}

		selectByVisibleText(driver, test, OCR_ESSD_ADPaymentMode, "Select the AD Payment Mode : ", ADPaymentMode);
		typeText(driver, test, OCR_ESSD_ADCaseDepositRate, "Enter the AD Case Deposit Rate : ", ADCaseDepositRate);
		selectByVisibleText(driver, test, OCR_ESSD_ADCaseRateType, "Select the AD Case Rate Type : ", ADCaseRateType);
		typeText(driver, test, OCR_ESSD_ADGoodsValue, "Enter the AD Goods Value : ", ADGoodsValue);
		typeText(driver, test, OCR_ESSD_ADQuantity, "Enter the AD Quantity : ", ADQuantity);
		typeText(driver, test, OCR_ESSD_ADDutyAmount, "Enter the AD Duty Amount : ", ADDutyAmount);
		clickElement(driver, test, OCR_ESSD_CVCaseNoLink, "Click on CV CaseNo Link");
		try {
			Wait.waitfor(3);
			clickElement(driver, test, "//td[contains(text(),'" + CVCaseNoCode + "')]",
					"Click on CV CaseNo : " + CVCaseNoCode);
			clickElement(driver, test, OCR_ESSD_Select, "Click on Select");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_ESSD_Close, "Click on Close");
		}
		selectByVisibleText(driver, test, OCR_ESSD_CVPaymentMode, "Select the CV Payment Mode : ", CVPaymentMode);
		typeText(driver, test, OCR_ESSD_CVCaseDepositRate, "Enter the CV Case Deposit Rate : ", CVCaseDepositRate);
		selectByVisibleText(driver, test, OCR_ESSD_CVCaseRateType, "Select the CV Case Rate Type : ", CVCaseRateType);
		typeText(driver, test, OCR_ESSD_CVCaseGoodsValue, "Enter the CV Case Goods Value : ", CVCaseGoodsValue);
		typeText(driver, test, OCR_ESSD_CVQuantity, "Enter the CV Quantity : ", CVQuantity);
		typeText(driver, test, OCR_ESSD_CVDutyAmount, "Enter the CV Duty Amount : ", CVDutyAmount);
	}

	//Add the Textile / Softwood Lumber / Visa / Permit Details
	public void addTextileSoftwoodLVisaPermitDetails(String CategoryCode, String DateOfExport, String VisaQuantity) {
		typeText(driver, test, OCR_ESSD_CategoryCode, "Enter the Category Code : ", CategoryCode);
		clickElement(driver, test, OCR_ESSD_DateOfExport, "Click on Date Of Export");
		date(driver, test, "Select the Date : ", DateOfExport);
		typeText(driver, test, OCR_ESSD_VisaQuantity, "Enter the Visa Quantity : ", VisaQuantity);
	}
	
	
}
