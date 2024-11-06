package globalExportClasses;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewLetterOfCreditInstructionsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_CNewLCI_LCIID = "//input[@id='editLetterOfCredit_letterOfCredit_lcId']";
	public static final String OCR_CNewLCI_InvoiceNo = "//input[@id='editLetterOfCredit_letterOfCredit_invoiceNo']";
	public static final String OCR_CNewLCI_InvoiceDate = "//input[@id='editLetterOfCredit_invoiceDate']";
	public static final String OCR_CNewLCI_ExporterCodeLink = "(//a[contains(text(),'Code') and (@data-ocr-role='modal-link')])[1]";
	public static final String OCR_CNewLCI_ExporterCode = "//input[@id='searchForm_exporter_expCode']";
	public static final String OCR_CNewLCI_Search = "(//button[contains(text(),'Search')])[1]";
	public static final String OCR_CNewLCI_Select = "(//button[@name='Ok'])[1]";
	public static final String OCR_CNewLCI_PopUpClose = "(//button[@class='btn-close'])[1]";
	public static final String OCR_CNewLCI_ConsigneeCodeLink = "//input[@id='editLetterOfCredit_letterOfCredit_lcToCode']/../../label/a";
	public static final String OCR_CNewLCI_ConsigneeCode = "//input[@id='searchForm_consignee_consigneeId']";
	public static final String OCR_CNewLCI_AdvisingBankLink = "//a[contains(text(),'Advising Bank')]";
	public static final String OCR_CNewLCI_BankID = "//input[@id='resultBankScreeningPopupDetails_bankScreeningDTO_bankId']";
	public static final String OCR_CNewLCI_ConfirmingBankLink = "//a[contains(text(),'Confirming Bank')]";
	public static final String OCR_CNewLCI_DrawingBankLink = "//a[contains(text(),'Drawing Bank')]";
	public static final String OCR_CNewLCI_Beneficiary = "//input[@id='editLetterOfCredit_letterOfCredit_beneficiaryLine1']";
	public static final String OCR_CNewLCI_CreditCurrency = "//select[@id='editLetterOfCredit_letterOfCredit_creditCurrencyCode']";
	public static final String OCR_CNewLCI_MaximumCreditType = "//select[@id='editLetterOfCredit_letterOfCredit_creditBoundaryType']";
	public static final String OCR_CNewLCI_Amount = "//input[@id='editLetterOfCredit_letterOfCredit_creditBoundaryAmt']";
	public static final String OCR_CNewLCI_DraftsAt = "//select[@id='editLetterOfCredit_letterOfCredit_paymentBoundaryType']";
	public static final String OCR_CNewLCI_ChargesExpenseBearer = "//select[@id='editLetterOfCredit_letterOfCredit_expenseBearer']";
	public static final String OCR_CNewLCI_ApplyCICountryToApplicant = "//select[@id='editLetterOfCredit_letterOfCredit_applyInsideCountryCharges']";
	public static final String OCR_CNewLCI_AllowPartialShipments = "//select[@id='editLetterOfCredit_letterOfCredit_isPartialShipment']";
	public static final String OCR_CNewLCI_AllowedDays = "//input[@id='editLetterOfCredit_letterOfCredit_allowedDaysAfterPresentati']";
	public static final String OCR_CNewLCI_LetterCredittransferrable = "//select[@id='editLetterOfCredit_letterOfCredit_isTransferrable']";
	public static final String OCR_CNewLCI_AllowTramsshipments = "//select[@id='editLetterOfCredit_letterOfCredit_isTransshipment']";
	public static final String OCR_CNewLCI_CommercialInvoice = "//select[@id='editLetterOfCredit_letterOfCredit_commercialInvoiceReq']";
	public static final String OCR_CNewLCI_InsuranceCertificate = "//select[@id='editLetterOfCredit_letterOfCredit_insuranceCertReq']";
	public static final String OCR_CNewLCI_AllowforNVOCCbillsoflading = "//select[@id='editLetterOfCredit_letterOfCredit_allowNvocc']";
	public static final String OCR_CNewLCI_Markbillofladingonboard = "//select[@id='editLetterOfCredit_letterOfCredit_allowConsolidatorsAwb']";
	public static final String OCR_CNewLCI_AWBConsignedTo = "//input[@id='editLetterOfCredit_letterOfCredit_awbConsignedTo']";
	public static final String OCR_CNewLCI_PackingList = "//select[@id='editLetterOfCredit_letterOfCredit_packingListReq']";
	public static final String OCR_CNewLCI_PAmount = "//input[@id='editLetterOfCredit_letterOfCredit_insuranceAmt']";
	public static final String OCR_CNewLCI_AllowConsolidatedAirwaybill = "//select[@id='editLetterOfCredit_letterOfCredit_markBolOnBoard']";
	public static final String OCR_CNewLCI_MarkDocumentFreightPrepaid = "//select[@id='editLetterOfCredit_letterOfCredit_isFreightToBeCollected']";
	public static final String OCR_CNewLCI_InlandBOLConsignedTo = "//input[@id='editLetterOfCredit_letterOfCredit_inlandBolConsignedTo']";
	public static final String OCR_CNewLCI_ShippingOrigin = "//input[@id='editLetterOfCredit_letterOfCredit_shippingOrigin']";
	public static final String OCR_CNewLCI_OtherReqDocs = "//input[@id='editLetterOfCredit_letterOfCredit_otherReqDocs']";
	public static final String OCR_CNewLCI_ShowForwarderAs = "//input[@id='editLetterOfCredit_letterOfCredit_showForwarderAs']";
	public static final String OCR_CNewLCI_ShowCarrierAs = "//input[@id='editLetterOfCredit_letterOfCredit_showCarrierAs']";
	public static final String OCR_CNewLCI_SpecialInstructions = "//textarea[@id='editLetterOfCredit_letterOfCredit_specialInstruction']";
	public static final String OCR_CNewLCI_ShippingDestination = "//input[@id='editLetterOfCredit_letterOfCredit_shippingDestination']";
	public static final String OCR_CNewLCI_SaveAndReturn = "(//button[contains(text(),'Save')])[2]";
	public static final String OCR_CNewLCI_Save = "(//button[contains(text(),'Save')])[1]";

	public static final String OCR_CNewLCI_GenerateDoc = "//i[@class='fa fa-file-pdf-o']";
	public static final String OCR_CNewLCI_EmailWithLink = "//button[@id='docEmailAsLink']";
	public static final String OCR_CNewLCI_EmailWithAttachment = "//button[@id='docEmailAsAttachment']";
	public static final String OCR_CNewLCI_GenerateDoc_PopupClose = "//div[@id='ocrModal']//button[@class='btn-close']";
	public static final String OCR_CNewLCI_InvTodayDate = "//button[contains(text(),'Today')]";

	/* ******************************* Constructor ****************************** */

	public CreateNewLetterOfCreditInstructionsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Add the header details in LCI
	public void addHeaderLCI(String LCIID, String InvoiceNo, String InvoiceDate) {
		typeText(driver, test, OCR_CNewLCI_LCIID, "Enter the LCI ID : ", LCIID + randomnumbers());
		typeText(driver, test, OCR_CNewLCI_InvoiceNo, "Enter the Invoice No : ", InvoiceNo + randomnumbers());
		clickElement(driver, test, OCR_CNewLCI_InvoiceDate, "Click on Invoice Date");
		date(driver, test, "Select the Invoice Date ", InvoiceDate);
	}

	public void addHeaderLCI(String LCIID, String InvoiceNo) {
		typeText(driver, test, OCR_CNewLCI_LCIID, "Enter the LCI ID : ", LCIID + randomnumbers());
		typeText(driver, test, OCR_CNewLCI_InvoiceNo, "Enter the Invoice No : ", InvoiceNo + randomnumbers());
		clickElement(driver, test, OCR_CNewLCI_InvoiceDate, "Click on Invoice Date");

	}

	public void addHeaderInvDate(String InvDate) {
		Wait.waitfor(2);
		if (InvDate.length() > 0) {
			clickElement(driver, test, OCR_CNewLCI_InvoiceDate, "Clicking on Invoice Date :");
			try {
				if (InvDate.equalsIgnoreCase("Today")) {
					clickElement(driver, test, OCR_CNewLCI_InvTodayDate, "Clicking on Today :");
				} else {
					date(driver, test, "Selecting the Invoice Date :", InvDate);
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select the Invoice Date :");
			}
		}
	}

	// Add the Exporter
	public void addExporter(String ExporterCode) {
		clickElement(driver, test, "//input[@name='letterOfCredit.fromName']", "");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_CNewLCI_ExporterCodeLink, "Click on Exporter Code link :");
		try {
			Wait.waitfor(3);
			typeText(driver, test, OCR_CNewLCI_ExporterCode, "Enter the Exporter code : ", ExporterCode);
			clickElement(driver, test, OCR_CNewLCI_Search, "Click on Search :");
			Wait.waitfor(3);
			clickElement(driver, test, "//td[contains(text(),'" + ExporterCode + "')]",
					"Click on Exporter Code :" + ExporterCode);
			clickElement(driver, test, OCR_CNewLCI_Select, "Click on Select :");
			Wait.waitfor(4);
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_CNewLCI_PopUpClose, "Click on Pop up close :");
		}
	}

	// Add the Consignee
	public void addConsignee(String ConsigneeCode) {
		scrollToElement(driver, OCR_CNewLCI_ConsigneeCodeLink);
		clickElement(driver, test, OCR_CNewLCI_ConsigneeCodeLink, "Click on Consignee Code link");
		try {
			typeText(driver, test, OCR_CNewLCI_ConsigneeCode, "Enter the Consignee code : ", ConsigneeCode);
			clickElement(driver, test, OCR_CNewLCI_Search, "Click on Search");
			Wait.waitfor(3);
			clickElement(driver, test, "//td[contains(text(),'" + ConsigneeCode + "')]",
					"Click on Consignee Code : " + ConsigneeCode);
			clickElement(driver, test, OCR_CNewLCI_Select, "Click on Select");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_CNewLCI_PopUpClose, "Click on Pop up close");
		}
	}
	
	//Adding an On-Hold consignee for Regression US
	
		public void addOnHoldConsignee(String ConsigneeCode) {
			scrollToElement(driver, OCR_CNewLCI_ConsigneeCodeLink);
			clickElement(driver, test, OCR_CNewLCI_ConsigneeCodeLink, "Click on Consignee Code link");
			try {
				typeText(driver, test, OCR_CNewLCI_ConsigneeCode, "Enter the Consignee code : ", ConsigneeCode);
				clickElement(driver, test, OCR_CNewLCI_Search, "Click on Search");
				Wait.waitfor(3);
				clickElement(driver, test, "//td[contains(text(),'" + ConsigneeCode + "')]",
						"Click on Consignee Code : " + ConsigneeCode);
				clickElement(driver, test, OCR_CNewLCI_Select, "Click on Select");
				Wait.waitfor(2);
				
				Alert a1 = driver.switchTo().alert();
				 a1.accept();
				
//				String alertmsg = "OK";
//			     
//		        try {
//		            if(alertmsg.equalsIgnoreCase("OK")) {
//		                clickElement(driver, test, "//div[contains(text(),'OK')]", "CLicking on OK :");
//		                }
//		            else {
//		                clickElement(driver, test, "//div[contains(text(),'Cancel')]", "Clicking on Cancel button :");
//		            }
//		        }catch(Exception e) {
//		             //   testFailSshot(driver, test);
//		                test.log(LogStatus.INFO, "Added On Hold Consignee :");
//		            }
				
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CNewLCI_PopUpClose, "Click on Pop up close");
			}
		}
	
	//Override Consignee by selecting from Status dropdown
	public void editConsigneeStatus(String OverriddenCons) {
		scrollToElement(driver, OCR_CNewLCI_ConsigneeCodeLink);
		selectByVisibleText(driver, test, "//select[@id='consigneeStatusSelect']", "Select an overridden Consginee : ", OverriddenCons);
		
	}

	// Add Bank Details
	public void addBankDetails(String AdvisingBankID, String ConfirmingBankID, String DrawingBankID, String Beneficiary,
			String CreditCurrency, String MaximumCreditType, String Amount, String DraftsAt,
			String ChargesExpenseBearer, String ApplyCICountryToApplicant, String AllowPartialShipments,
			String AllowedDays, String LetterCredittransferrable, String AllowTramsshipments) {
		scrollToBottom(driver);
		clickElement(driver, test, OCR_CNewLCI_AdvisingBankLink, "Click on Advising Bank Link");
		try {
			typeText(driver, test, OCR_CNewLCI_BankID, "Enter the Advising Bank ID : ", AdvisingBankID);
			clickElement(driver, test, OCR_CNewLCI_Search, "click on Search");
			clickElement(driver, test, "//td[contains(text(),'" + AdvisingBankID + "')]",
					"Click on Advising Bank ID : " + AdvisingBankID);
			clickElement(driver, test, OCR_CNewLCI_Select, "Click on Select");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_CNewLCI_PopUpClose, "Click on Pop up close");
		}
		Wait.waitfor(3);
		clickElement(driver, test, OCR_CNewLCI_ConfirmingBankLink, "Click on Confirming Bank Link");
		try {
			typeText(driver, test, OCR_CNewLCI_BankID, "Enter the Confirming Bank ID : ", ConfirmingBankID);
			clickElement(driver, test, OCR_CNewLCI_Search, "click on Search");
			clickElement(driver, test, "//td[contains(text(),'" + ConfirmingBankID + "')]",
					"Click on Advising Bank ID : " + ConfirmingBankID);
			clickElement(driver, test, OCR_CNewLCI_Select, "Click on Select");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_CNewLCI_PopUpClose, "Click on Pop up close");
		}
		Wait.waitfor(3);
		clickElement(driver, test, OCR_CNewLCI_DrawingBankLink, "Click on Drawing Bank Link");
		try {
			typeText(driver, test, OCR_CNewLCI_BankID, "Enter the  Drawing Bank ID : ", DrawingBankID);
			clickElement(driver, test, OCR_CNewLCI_Search, "click on Search");
			clickElement(driver, test, "//td[contains(text(),'" + DrawingBankID + "')]",
					"Click on Advising Bank ID : " + DrawingBankID);
			clickElement(driver, test, OCR_CNewLCI_Select, "Click on Select");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_CNewLCI_PopUpClose, "Click on Pop up close");
		}

		typeText(driver, test, OCR_CNewLCI_Beneficiary, "Enter the Beneficiary : ", Beneficiary);
		selectByVisibleText(driver, test, OCR_CNewLCI_CreditCurrency, "Select the Credit Currency : ", CreditCurrency);
		selectByVisibleText(driver, test, OCR_CNewLCI_MaximumCreditType, "Select the Maximum Credit Type : ",
				MaximumCreditType);
		typeText(driver, test, OCR_CNewLCI_Amount, "Enter the Amount : ", Amount);
		selectByVisibleText(driver, test, OCR_CNewLCI_DraftsAt, "Select the Drafts At : ", DraftsAt);
		selectByVisibleText(driver, test, OCR_CNewLCI_ChargesExpenseBearer, "Select the Charges Expense Bearer : ",
				ChargesExpenseBearer);
		selectByVisibleText(driver, test, OCR_CNewLCI_ApplyCICountryToApplicant,
				"Select the Apply charges inside Country to applicant : ", ApplyCICountryToApplicant);
		selectByVisibleText(driver, test, OCR_CNewLCI_AllowPartialShipments, "Select the Allow Partial Shipments : ",
				AllowPartialShipments);
		typeText(driver, test, OCR_CNewLCI_AllowedDays, "Enter the AllowedDays : ", AllowedDays);
		selectByVisibleText(driver, test, OCR_CNewLCI_LetterCredittransferrable,
				"Select the Letter of Credit shall be transferrable : ", LetterCredittransferrable);
		selectByVisibleText(driver, test, OCR_CNewLCI_AllowTramsshipments, "Select the Allow Tramsshipments : ",
				AllowTramsshipments);
	}

	// Add the Required Documents Should Include
	public void addRequiredDoc(String CommercialInvoice, String InsuranceCertificate, String AllowforNVOCCbillsoflading,
			String Markbillofladingonboard, String AWBConsignedTo, String PackingList, String PAmount,
			String AllowConsolidatedAirwaybill, String MarkDocumentFreightPrepaid, String InlandBOLConsignedTo,
			String ShippingOrigin, String OtherReqDocs, String ShowForwarderAs, String ShowCarrierAs,
			String SpecialInstructions, String ShippingDestination) {
		scrollToElement(driver, OCR_CNewLCI_AllowTramsshipments);
		selectByVisibleText(driver, test, OCR_CNewLCI_CommercialInvoice, "Select the Commercial Invoice : ",
				CommercialInvoice);
		selectByVisibleText(driver, test, OCR_CNewLCI_InsuranceCertificate, "Select the Insurance Certificate : ",
				InsuranceCertificate);
		selectByVisibleText(driver, test, OCR_CNewLCI_AllowforNVOCCbillsoflading,
				"Select the Allowfor NVOCC bills of lading : ", AllowforNVOCCbillsoflading);
		selectByVisibleText(driver, test, OCR_CNewLCI_Markbillofladingonboard,
				"Select the Mark bill of ladingon board : ", Markbillofladingonboard);
		typeText(driver, test, OCR_CNewLCI_AWBConsignedTo, "Enter the AWB Consigned To : ", AWBConsignedTo);
		selectByVisibleText(driver, test, OCR_CNewLCI_PackingList, "Select the Packing List : ", PackingList);
		typeText(driver, test, OCR_CNewLCI_PAmount, "Enter the PAmount : ", PAmount);
		selectByVisibleText(driver, test, OCR_CNewLCI_AllowConsolidatedAirwaybill,
				"Select the Allow Consolidated Airway bill : ", AllowConsolidatedAirwaybill);
		selectByVisibleText(driver, test, OCR_CNewLCI_MarkDocumentFreightPrepaid,
				"Select the Mark Document Freight Prepaid : ", MarkDocumentFreightPrepaid);

		typeText(driver, test, OCR_CNewLCI_InlandBOLConsignedTo, "Enter the In land BOL Consigned To : ",
				InlandBOLConsignedTo);
		typeText(driver, test, OCR_CNewLCI_ShippingOrigin, "Enter the Shipping Origin : ", ShippingOrigin);
		typeText(driver, test, OCR_CNewLCI_OtherReqDocs, "Enter the Other Req Docs : ", OtherReqDocs);
		typeText(driver, test, OCR_CNewLCI_ShowForwarderAs, "Enter the  Show Forwarder As : ", ShowForwarderAs);
		typeText(driver, test, OCR_CNewLCI_ShowCarrierAs, "Enter the Show Carrier As : ", ShowCarrierAs);
		typeText(driver, test, OCR_CNewLCI_SpecialInstructions, "Enter the  Special Instructions : ",
				SpecialInstructions);
		typeText(driver, test, OCR_CNewLCI_ShippingDestination, "Enter the Shipping Destination : ",
				ShippingDestination);

	}

	// click on Save and return
	public void clickSaveAndReturn() {
		Wait.waitfor(2);
		scrollToElement(driver, OCR_CNewLCI_SaveAndReturn);
		clickElement(driver, test, OCR_CNewLCI_SaveAndReturn, "click on Save and Return");
	}

	// click on Save
	public void clickSave() {
		Wait.waitfor(2);
		scrollToElement(driver, OCR_CNewLCI_Save);
		clickElement(driver, test, OCR_CNewLCI_Save, "click on Save");
		Wait.waitfor(2);
		clickElement(driver, test, "//input[@id='editLetterOfCredit_letterOfCredit_toName']", "");
	}

	// Get the LCI No
	public String getValueLCI() {
		return getAttribute(driver, test, OCR_CNewLCI_LCIID, "value", "Getting the LCI NO : ");
	}

	public void generateDoc() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CNewLCI_GenerateDoc, "Click on Generate Document icon :");
	}

	public void sendEmail(String emailID) {
		Wait.waitfor(2);
		clickElement(driver, test,
				"//div[@class='selectize-control doc-email form-control multi plugin-remove_button']",
				"Click on Email To text box :");
		Wait.waitfor(2);
		typeText(driver, test, "//input[@autocomplete='new-password']", "Enter the email id : ", emailID);
		scrollToElement(driver, OCR_CNewLCI_EmailWithLink);
		clickElement(driver, test, OCR_CNewLCI_EmailWithLink, "Click on Send Email With Link : ");

		Wait.waitfor(5);
		try {
			if (isDisplayed(driver, "//div[@class='row ocr-info']//h4[contains(text(),'Information!')]")) {

				if (isDisplayed(driver, "//li[contains(text(),'Email Sent Successfully')]")) {
					test.log(LogStatus.INFO, "Email sent successfully.");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Email not sent successfully. Information message is not Displayed ");
		}
		Wait.waitfor(3);
		clickElement(driver, test, OCR_CNewLCI_GenerateDoc_PopupClose, "Click on Pop up Close button");
	}

	public void entityScreening() {
		Wait.waitfor(2);
		clickElement(driver, test, "//i[@class='fa fa-user']", "Click on Entity Screening Status icon : ");
		Wait.waitfor(2);
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Entity Screening Status')]")) {
				test.log(LogStatus.PASS, "Entity Screening Status pop up is opened :");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Entity Screening Status pop up is not opened :");
		}
		Wait.waitfor(2);
		clickElement(driver, test, "(//button[@class='btn-close'])[1]", "Click on Pop Up Close Button");
	}
	
	public void entityScreening(String entityStat) {
		Wait.waitfor(2);
		clickElement(driver, test, "//i[@class='fa fa-user']", "Click on Entity Screening Status icon : ");
		Wait.waitfor(2);
		String entityStatus = getText(driver, test, "//tr/td[contains(text(),'"+ entityStat +"')]", entityStat);
		try {
			if (entityStatus.equalsIgnoreCase(entityStat)) {
				test.log(LogStatus.PASS, "Entity Screening Status shows correct screening :");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Entity Screening Status does not show correct screening :");
		}
		Wait.waitfor(2);
		clickElement(driver, test, "(//button[@class='btn-close'])[1]", "Click on Pop Up Close Button");
	}

	public void cancelBtn() {
		Wait.waitfor(2);

		clickElement(driver, test, OCR_CNewLCI_InvoiceDate, "Clicking on Invoice Date :");
		clickElement(driver, test, "//button[@id='cancelBtn']", "Click on Cancel Button :");
	}

	public void verifyDuplicateMsg() {
		Wait.waitfor(2);
		String duplicateMsg = getText(driver, test, "//span[contains(text(),'This LCI ID already exists in SBU SETES - SeleniumTest. Enter unique LCI ID.')]", "Duplicate LCI ID error message displays :");
		System.out.println(duplicateMsg);
		try {
			if(duplicateMsg.equalsIgnoreCase("This LCI ID already exists in SBU SETES - SeleniumTest. Enter unique LCI ID.")) {
				test.log(LogStatus.PASS, "Duplicate error message displays. This test script passes since System does not allow duplicate LCI ID creation :");
			
			}
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Duplicate error message does not display. This test script fails :");
		}
	}
	
	public void clickInvoiceDate() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CNewLCI_InvoiceDate, "Clicking on Invoice Date :");
	}

}
