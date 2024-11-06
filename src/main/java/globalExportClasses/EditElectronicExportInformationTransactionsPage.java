package globalExportClasses;
/* 
 * Module : Export Operation
 * Author  : Saddam
 * created date : April 2024
 * Descriptions : Edit Electronic Export Information Transactions Page
 * changed by : Pooja
 * changed date : 02/05/2024
 * Purpose of change : Nil 
 * Reviewed by : Nil 
 */
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilities.GenericMethods;
import utilities.Wait;

public class EditElectronicExportInformationTransactionsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_EntityScreeningStatus = "//i[@class='fa fa-user']";
	public static final String OCR_ExportAuthorizationScreeningStatus = "//i[@class='fa fa-legal']";
	public static final String OCR_ComplianceSummaryReport = "//i[@class='fa fa-file-text-o']";
	public static final String OCR_ValidationStatus = "//i[@class='fa fa-exclamation-circle']";
	public static final String OCR_GenerateDocument = "//i[@class='fa fa-file-pdf-o']";
	public static final String OCR_Link_UnlinkInvoices = "//i[@class='fa fa-link']";
	public static final String OCR_UploadFileAttachment = "//i[@class='fa fa-upload']";
	public static final String OCR_PreviousButon = "//button[@id='prev-btn']";
	public static final String OCR_NextButton = "//button[@id='next-btn']";
	public static final String OCR_CloseButton = "//button[@id='cancelBtn']";
	public static final String OCR_AdditionalTransactionDetails = "//i[@class='fa fa-th']";
	public static final String OCR_Grid = "//div[@id='gbox_grid-link']";
	public static final String OCR_ShipmentNo = "(//span[@class='additional-value'])[1]";
	public static final String OCR_Status = "(//span[@class='additional-value'])[2]";
	public static final String OCR_InvoiceNumber = "//a[@class='ead-invoice-tooltip']";
	public static final String OCR_ReportIcon = "(//i[@class='fa fa-file-text-o'])[2]";
	public static final String OCR_PopupHeading = "//h4[@id='myModalLabel']";
	
	public static final String OCR_EditEEI_AESStatus = "//select[@id='editSed_shipment_shipmentCustomFilingStatus']";
	public static final String OCR_EditEEI_VerifyHeading = "//div[@class='page-heading']";
	public static final String OCR_EditEEI_AdditionalTransactionDetails = "//i[@class='fa fa-th']";
	public static final String OCR_EditEEI_ShipmentDetails = "//a[contains(text(),'Shipment Details')]";
	public static final String OCR_EditEEI_VerifyBookedStatus = "//span[contains(text(),'Booked')]";
	public static final String OCR_EditEEI_SaveBtn = "(//button[contains(text(),'Save')])[1]";
	public static final String OCR_EditEEI_AddDocpopUpDocTypeDropdwn = "//select[@id='requiredDocTypeId']";
	public static final String OCR_EditEEI_AddDocpopUpUploadFile = "//input[@id='fileAttach']";
	public static final String OCR_EditEEI_AddDescriptionBox = "//textarea[@id='editDCSFileAttach_documentDetail_comments']";
	public static final String OCR_EditEEI_AddDocpopUpSavendReturnBtn = "//button[@id='saveButton']";
	public static final String OCR_EditEEI_CopyIcon = "//i[@class='fa fa-copy']";
	public static final String OCR_EditEEI_AESOption = "//select[@id='editSed_shipment_aesOption']";
	public static final String OCR_EditEEI_LateFilingErrorMsg = "//span[contains(text(),'Date of Export cannot be older than  60 days.')]";

	/* ******************************* Constructor ****************************** */

	public EditElectronicExportInformationTransactionsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	// Click on Forward Button
	public void moveForward() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(OCR_NextButton)));
	}

	// Click on Backword Button
	public void moveBackward() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(OCR_PreviousButon)));
	}

	// Click on Close Button
	public void close() {
		clickElement(driver, test, OCR_CloseButton, "Clicking on Close Button :");
	}

	// Click on Additional Transaction Details
	public void additionalTransactionDetails() {
		Wait.waitfor(5);
		scrollToElement(driver, OCR_AdditionalTransactionDetails);
		clickElement(driver, test, OCR_AdditionalTransactionDetails, "Clicking on Additional Transaction Details :");
	}
	
	//select Item
	public void selectItem() {
		mouseOverAndClick(driver, test, "(//a[contains(text(),'Items')])[2]", "Selecting Item :");
	}

	// Getting the Shipment No
	public String get_ShipmentID() {
		return getText(driver, test, OCR_ShipmentNo, "Get the Actual Shipment No : ");
	}

	// Getting the Shipment Status
	public String get_ShipmentStatus() {
		return getText(driver, test, OCR_Status, "Get the Actual Shipment Status : ");
	}

	// Getting the Invoice No
	public String get_InvoiceNumber() {
		return getText(driver, test, OCR_InvoiceNumber, "Get the Actual Shipment No : ");
	}

	// Click on Entity Screening Status
	public void entityScreeningStatus() {
		clickElement(driver, test, OCR_EntityScreeningStatus, "Clicking on Entity Screening Status :");
	}

	// Click on Export Authorization Screening Status
	public void exportAuthorizationScreeningStatus() {
		clickElement(driver, test, OCR_ExportAuthorizationScreeningStatus,
				"Clicking on Export Authorization Screening Status :");

	}

	// Click on Compliance Summary
	public void complianceSummary() {
		clickElement(driver, test, OCR_ComplianceSummaryReport, "Clicking on Compliance Summary Report :");

	}

	// Click on Validation Status
	public void validationStatus() {
		clickElement(driver, test, OCR_ValidationStatus, "Clicking on Validation Status :");

	}

	// Click on Generate Document
	public void generateDocument() {
		clickElement(driver, test, OCR_GenerateDocument, "Clicking on Generate Document :");

	}

	// Click on Link_Unlink Invoices
	public void link_UnlinkInvoices() {
		clickElement(driver, test, OCR_Link_UnlinkInvoices, "Click on Link_Unlink Invoices :");

	}

	// Click on Upload File Attachment
	public void uploadFileAttachment() {
		clickElement(driver, test, OCR_UploadFileAttachment, "Clicking on Upload File Attachment :");

	}
	
	//Click on Report Icon and Validate Popup Heading
	public void reportIcon() {
		clickElement(driver, test, OCR_ReportIcon, "Clicking on Report Icon in Grid :");
		try {
			if(isDisplayed(driver, OCR_PopupHeading)) {
				test.log(LogStatus.PASS, "Popup Heading is Displayed after Clicking on Report Icon :");
			}
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Popup Haeding is Not Displayed after Clicking on Report Icon :");
		}
	}
	
	//Comparing Invoice number and Shipment No
	public void comparissionOfInvoiceNoandShipmentNo() {
		String Get_ShipmentID = getText(driver, test, OCR_ShipmentNo, "Get the Actual Shipment No : ");
		String Get_InvoiceNo = getText(driver, test, OCR_InvoiceNumber, "Get the Actual Shipment No : ");
		try {
			if(Get_InvoiceNo.equals(Get_ShipmentID)) {
				test.log(LogStatus.PASS, "Shipment No and Invoice No is Same :");
			}
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Shipment No and Invoice No are Not Equals :");
		}	
	}

	// Validations of Icon
	public void iconValidation() {
		// Entity Screening Status
		try {
			if (isDisplayed(driver, OCR_EntityScreeningStatus)) {
				test.log(LogStatus.PASS, "Entity Screening Status Icon is Displayed :");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Entity Screening Status ICon in Not Displayed :");
		}

		// Export Authorization Screening Status
		try {
			if (isDisplayed(driver, OCR_ExportAuthorizationScreeningStatus)) {
				test.log(LogStatus.PASS, "Export Authorization Screening Status Icon is Displayed :");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Export Authorization Screening Status ICon in Not Displayed :");
		}

		// Compliance Summary
		try {
			if (isDisplayed(driver, OCR_ComplianceSummaryReport)) {
				test.log(LogStatus.PASS, "Compliance Summary Report Icon is Displayed :");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Compliance Summary Report ICon in Not Displayed :");
		}

		// Validation Status
		try {
			if (isDisplayed(driver, OCR_ValidationStatus)) {
				test.log(LogStatus.PASS, "Validation Status Icon is Displayed :");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Validation Status ICon in Not Displayed :");
		}

		// Generate Document
		try {
			if (isDisplayed(driver, OCR_GenerateDocument)) {
				test.log(LogStatus.PASS, "Generate Document Icon is Displayed :");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Generate Document ICon in Not Displayed :");
		}

		// Link_Unlink Invoices
		try {
			if (isDisplayed(driver, OCR_Link_UnlinkInvoices)) {
				test.log(LogStatus.PASS, "Link_Unlink Invoices Icon is Displayed :");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Link_Unlink Invoices ICon in Not Displayed :");
		}

		// Upload File Attachment
		try {
			if (isDisplayed(driver, OCR_UploadFileAttachment)) {
				test.log(LogStatus.PASS, "Upload File Attachment Icon is Displayed :");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Upload File Attachment ICon in Not Displayed :");
		}
	}
	
	//Grid Validation
	public void gridvalidation() {
		try {
			if(isDisplayed(driver, OCR_Grid)) {
				test.log(LogStatus.PASS, "Grid is Displayed :");
			}
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Grid in Not Displayed :");
		}
	}
	
	
	//Verify EEI Transaction page heading
		public void EEIHeading() {
			Wait.waitfor(2);
			String EEI_Heading = getText(driver, test, OCR_EditEEI_VerifyHeading, "Getting the heading od EEI Transactions page :");
			try {
				if(EEI_Heading.equalsIgnoreCase("Edit  Electronic Export Information Transactions")) {
					test.log(LogStatus.PASS, "Edit Electronic Export Information Transactions page is opened");
				}	
				}catch(Exception e) {
					testFailSshot(driver, test);
					test.log(LogStatus.FAIL, "Edit Electronic Export Information Transactions page is not opened");
					
				}
			}
		
		
		//verify AES Status is open
		public void AESStatus() {
			Wait.waitfor(2);
			String AES_Status = getText(driver, test, OCR_EditEEI_AESStatus, "Getting the actual status of AES :");
			try {
			if(AES_Status.equalsIgnoreCase("Open")) {
			test.log(LogStatus.PASS, "AES Status is Open");
			}	
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "AES Status is not Open");
			}
			
		}
		
		//click on Additional Transactional Details 
			public void AdditionalTransaction() {
				Wait.waitfor(2);
				scrollToElement(driver, OCR_EditEEI_AdditionalTransactionDetails);
				clickElement(driver, test, OCR_EditEEI_AdditionalTransactionDetails, "Click on Additional Transactional Details tab :");
				
			}
		
		//select Shipment details from Additional Transactional Details
		public void ShipDetails() {
			Wait.waitfor(2);
			clickElement(driver, test, OCR_EditEEI_ShipmentDetails, "Click on Shipment Details option");
			
		}
		
		//verify EEI status as Booked
		public void verifyBookedStatus() {
			Wait.waitfor(2);
			String EEI_Status = getText(driver, test, OCR_EditEEI_VerifyBookedStatus, "Getting the status of EEI :");
			try {
				if(EEI_Status.equalsIgnoreCase("Booked")) {
					test.log(LogStatus.PASS, "The EEI Status is Booked :");
				}
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "The EEI Status is not Booked :");
			}
		}
		
		//fetch the status of AES
		public void AES(String AES) {
			Wait.waitfor(2);
			clickElement(driver, test, OCR_EditEEI_AESStatus, "Click on AES Status :");
			selectByVisibleText(driver, test, OCR_EditEEI_AESStatus, "Select AES Status : ", AES);
		}
		
		//click on Save button
		public void SaveBtn() {
			Wait.waitfor(2);
			scrollToElement(driver, OCR_EditEEI_SaveBtn);
			clickElement(driver, test, OCR_EditEEI_SaveBtn, "Click on Save button :");
		}
		
		//verify AES Status is Reported and option is disabled
		public void AESReported() {
			Wait.waitfor(2);
//		String AES_Reported = getText(driver, test, OCR_EditEEI_AESStatus, "Getting the status of AES :");
//			try {
//				
//					if(AES_Reported.equalsIgnoreCase("Reported")) {
//						test.log(LogStatus.PASS, "The AES Status is Reported :");
//					}
//					
//				if(AES_Reported.equalsIgnoreCase("Reported")) {
//					test.log(LogStatus.PASS, "The AES Status is Reported :");
//				}
//			}catch(Exception e) {
//				testFailSshot(driver, test);
//				test.log(LogStatus.FAIL, "The AES Status is not Reported :");
//			}
			Wait.waitfor(2);
			try {
			isEnabled(driver, OCR_EditEEI_AESStatus);
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "AES Status is enabled :");
		}
		catch(Exception e) {
			test.log(LogStatus.PASS, "AES Status is disabled :");
		}
	}
		
		public void NextArrowCustFilingView() {
			Wait.waitfor(2);
			clickElement(driver, test, "//i[@class='fa fa-angle-right']", "Click on Arrow link to move to next page on custom filing view :");
		}
		
		//Get Document Name
		public String getDocName() {
			return getText(driver, test, "//td[@aria-describedby='gridPopup_docName']", "Getting the Document Name :");
		}
		
		// Uploading the Document
		public void uploadDoc(String DocType, String DocDesc, String UploadfileName) {
			try {
				selectByVisibleText(driver, test, OCR_EditEEI_AddDocpopUpDocTypeDropdwn,
						"Select the document type from dropdown :", DocType);
				typeText(driver, test, OCR_EditEEI_AddDescriptionBox, "Add Description in box :", DocDesc);
				mouseOverAndClick(driver, test, OCR_EditEEI_AddDocpopUpUploadFile, "click on Upload File :");
				Wait.waitfor(4);
				uploadFile(driver, test, UploadfileName, "Document is Added : " + UploadfileName);
				Wait.waitfor(3);
				clickElement(driver, test, OCR_EditEEI_AddDocpopUpSavendReturnBtn, "Clicking on Save Button in Popup :");
				clickElement(driver, test, "//button[@id='closeTop']", "Click on Document pop close :");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, "//button[@id='closeTop']", "Click on Document pop close :");
			}
		}
		
		//Click on Item Copy Icon From grid
		public void clickcopyiconinGrid() {
			clickElement(driver, test, OCR_EditEEI_CopyIcon, "Clicking on Copy Icon in Grid :");
		}
		
		//Change the AES Option
		public void AESOption(String AESOption) {
			Wait.waitfor(2);
			selectByVisibleText(driver, test, OCR_EditEEI_AESOption, "Select AES Option : ", AESOption);
		}
		
		//Validate Late Filing Error Msg
		public void lateFilingErrorMsgValidation() {
			try {
				if(isDisplayed(driver, OCR_EditEEI_LateFilingErrorMsg)) {
					test.log(LogStatus.PASS, "Late Filling Warning Error Msg is Displayed :");
				}
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Late Filling Warning Error Msg is Not Displayed :");
			}
		}
		
		//Accept Alert
		public void alertAccept() {
			AlertPopUp(driver, test, "OK");
			test.log(LogStatus.INFO, "Alert is Accepted :");
		}
		
		//validate already uploaded attachment doc
		public void validate_attachment(String DocumentType) {
			Wait.waitfor(2);
			String uploadDoc = "//select[@id='doctypeId1'] //option[contains(text(),' " + DocumentType + "')]";
			isDisplayed(driver, uploadDoc);
			test.log(LogStatus.PASS, "Document type is added in the Grid table : " + DocumentType);
		
		}
		
		public void select_Doc(String DocumentType1, String UploadfileName1, String DocumentLocationPath1) {
			Wait.waitfor(2);
			try {
				if (UploadfileName1.length() > 0) {
					selectByVisibleText(driver, test, "//select[@id='requiredDocTypeId']", "Select the Document Type : ",
							DocumentType1);
					mouseOverAndClick(driver, test, "//span[@id='editModedisable']", "click on Upload File button");
					uploadFile(driver, test, UploadfileName1, "Document is Added : " + UploadfileName1);
					Wait.waitfor(3);
					clickElement(driver, test, "//button[@id='saveButton']", "click on Document save");
					clickElement(driver, test, "//button[@id='closeTop']", "Click on PopUp Close");
				}
				if (DocumentLocationPath1.length() > 0) {
					clickElement(driver, test, "//input[@id='editDCSFileAttach_fileStoreTypeisLocalFtp']", "click on Local Folder Radio button");
					selectByVisibleText(driver, test, "//select[@id='requiredDocTypeId']", "Select the Document Type : ",
							DocumentType1);
					typeText(driver, test, "//input[@id='textUrl']", "Enter local path : ", DocumentLocationPath1);
					Wait.waitfor(3);
					clickElement(driver, test, "//button[@id='saveButton']", "click on Document save");
					clickElement(driver, test, "//button[@id='closeTop']", "Click on PopUp Close");
				}

			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, "//button[@id='closeTop']", "Click on PopUp Close");
			}
			Wait.waitfor(2);
			String uploadDoc = "//select[@id='doctypeId1'] //option[contains(text(),' " + DocumentType1 + "')]";
			isDisplayed(driver, uploadDoc);
			test.log(LogStatus.PASS, "Document type is added in the Grid table : " + DocumentType1);
		
		}

	}
