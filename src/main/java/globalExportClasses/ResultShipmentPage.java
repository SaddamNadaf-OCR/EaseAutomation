package globalExportClasses;

import javax.swing.text.TableView.TableCell;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ResultShipmentPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_ResultShip_ShipmentNO = "//a[@class='ead-shipment-tooltip']";
	// select shipment number for creating packing list
	public static final String OCR_ResultShip_SelectShipmentNO = "//input[@id='jqg_grid_4']";
	public static final String OCR_ResultShip_ClickPackinglistFromShipmentNOBtn = "//button[contains(text(),'Create Packinglist from Selected Shipments')]";
	public static final String OCR_ResultShip_PLFromSelectedShipmentPopUpTitle = "Packinglist from Selected Shipments";
	public static final String OCR_ResultShip_PLFromSelectedShipmentPopUpCloseBtn = "//button[@id='close_btn']";
	public static final String OCR_ResultShip_CopyIcon = "//i[@class='fa fa-copy']";
	public static final String OCR_delteicon="(//i[@class='fa fa-trash-o'])[1]";
	public static final String OCR_uploadfileicon="(//i[@class='fa fa-upload'])[1]";
	public static final String OCR_ViewAddDoc = "//button[@id='documentAttachId']";
	public static final String OCR_DocumentType = "//select[@id='requiredDocTypeId']";
	public static final String OCR_DocDescription = "//textarea[@id='editDCSFileAttach_documentDetail_comments']";
	public static final String OCR_UploadFile = "//span[@class='btn fileinput-button']";
	public static final String OCR_Button_Save = "//button[@id='saveButton']";
	public static final String OCR_Button_Cancel = "//button[@id='cancel']";
	public static final String OCR_fileuploadMessage="//li[contains(text(),'File Uploaded successfully.')]";
	public static final String OCR_emailrelfilebtn="//button[@id='emailButton']";
	public static final String OCR_emailsendTo="//input[@id='send-toEmail']";
	public static final String OCR_emailsendCC="//input[@id='send-ccEmail']";
	public static final String OCR_emailsendSubject="//textarea[@id='editDCSFileAttach_emailHeader']";
	public static final String OCR_emailsendBody="//textarea[@id='editDCSFileAttach_emailBody']";
	public static final String OCR_emailsendsucessmessage="//li[contains (text(),'Email has been successfully sent to ')]";
	public static final String OCR_popupclose="//button[@id='closeTop']";
	public static final String OCR_deleteattachfilebtn="(//i[@class='fa fa-trash-o'])[21]";
	public static final String OCR_deletefilemsgcapture="//li[contains(text(),'Record has been deleted successfully')]";
	public static final String OCRSendEmailbtn="//button[@name='send-email-1']";
	public static final String OCRSysGeneratedNumBRadioBtn = "(//input[@name='packinglistGenType'])[2]";
	public static final String OCR_PDFIcon = "//td[@aria-describedby='grid_pdf']";
	public static final String OCR_GenerateDocPopupValidation = "//h4[contains(text(),'Generate Documents')]";
	public static final String OCR_AttachIcon = "//td[@aria-describedby='grid_attach']";
	public static final String OCR_EmailPopupBackButton = "(//button[@id='docBack'])[1]";
	public static final String OCR_PopupCloseIcon = "(//button[@class='btn-close'])[1]";	
	public static final String OCR_ShipmentNolink ="//a[contains(text(), 'DM_SHIP_001')]";//a[@data-ocr-value='RE1fU0hJUF8wMDE$N5mkk8A6I_I_']";
	/* ******************************* Constructor ****************************** */

	public ResultShipmentPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Click on the shipmentNo
	public void click_ShipmentNo(String ShipmentNO) {
		String shipmentNo = getText(driver, test, OCR_ResultShip_ShipmentNO, "Get the Shipment No : ");
		if (shipmentNo.equalsIgnoreCase(ShipmentNO)) {
			clickElement(driver, test, "//a[contains(text(),'" + ShipmentNO + "')]",
					"Click on Shipment : " + ShipmentNO);
		} else {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "SHIPMENT is not created sucessfully");
		}
	}

	// Result Shipment is displayed
	public void shipmentResult() {
		isDisplayed(driver, "//h3[contains(text(),'Result')]");
		test.log(LogStatus.PASS, "Result Shipment is Displayed");
	}

	// select any shipment number to create a packing list -----Pooja
	public void select_ShipmentNo() {
		clickElement(driver, test, "//input[@id='jqg_grid_1']", "Select a shipment number ");
	}
	
	// click shipment number link on shipment result screen -----Deva
	public void select_ShipmentNolink() {
		clickElement(driver, test, OCR_ShipmentNolink, "click on shipment number ");
	}
	
	//select system generated radio button
	public void select_SysGenNum() {
		Wait.waitfor(2);
		scrollToElement(driver, OCRSysGeneratedNumBRadioBtn);
		clickElement(driver, test, OCRSysGeneratedNumBRadioBtn, "Select system generated number");
	}

	// click on "Create Packing List from Selected Shipments" button----------Pooja
	public void click_PLFromShipNo() {
		// scrollToElement(driver, OCR_ResultShip_ClickPackinglistFromShipmentNOBtn);
		clickElement(driver, test, OCR_ResultShip_ClickPackinglistFromShipmentNOBtn,
				"Click on Create Packing List from Selected Shipment");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ResultShip_PLFromSelectedShipmentPopUpCloseBtn, "Click on Close pop up icon");
	}
	
	//Click on Copy Icon
	public void copyIcon() {
		clickElement(driver, test, OCR_ResultShip_CopyIcon, "Clicking on Copy Icon :");
		try {
			String alertmsg = getText(driver, test, "//span[contains(text(),'Proceed to Copy without Invalid data')]", "Alert Msg :");
			if(alertmsg.equalsIgnoreCase("Proceed to Copy without Invalid data")) {
				clickElement(driver, test, "//span[contains(text(),'Proceed to Copy without Invalid data')]", "Clicking on Proceed Without Invalid Data Button :");
				}
			else {
				clickElement(driver, test, "//span[contains(text(),'Abort Copying')]", "Clicking on Abort Copying :");
			}
		}catch(Exception e) {
				//testFailSshot(driver, test);
				test.log(LogStatus.INFO, "Clicked on Copy Icon without Alert Msg :");
			}
	}
		public void deleterecord() {
			clickElement(driver, test, OCR_delteicon, "Clicking on delete icon");
		}
		public void uploadfileicon() {
			clickElement(driver, test, OCR_uploadfileicon, "Clicking fileupload icon");
		}
		// Uploading the Document
		public void add_Document(String DocType, String DocDesc, String UploadfileName) {
			
			try {
				selectByVisibleText(driver, test, OCR_DocumentType, "Enter Document Type : ", DocType);
				typeText(driver, test, OCR_DocDescription, "Add Description : ", DocDesc);
				clickElement(driver, test, OCR_UploadFile, "click on upload file");
				uploadFile(driver, test, UploadfileName, "upload document : "+UploadfileName);
				Wait.waitfor(5);
				clickElement(driver, test, "(//button[@id='closeTop'])[1]", "click on cancel");
			} catch (Exception e) {
				testFailSshot(driver, test);
			//	e.printStackTrace();
				clickElement(driver, test, "(//button[@id='closeTop'])[1]", "click on cancel");
				test.log(LogStatus.FAIL, "Click on cancel");
			}
		}
		
		// Uploading the Document
				public void add_Documentwiz(String DocType, String DocDesc, String UploadfileName) {
					
					try {
						if(isDisplayed(driver, "//a[contains(text(), 'Capture.PNG (11 KB)')]")) {
							clickElement(driver, test, "(//i[@class='fa fa-trash-o'])[2]", "Delate Document added");
							Wait.waitfor(2);
							AlertPopUp(driver, test, "Are you sure you wish to delete?");
							Wait.waitfor(7);
							try{
								if(isDisplayed(driver, "//li[contains(text(), 'Record has been deleted successfully')]")) 
								{
									test.log(LogStatus.PASS, "Record has been deleted successfully");
								}
								
							}catch (Exception e){
									testFailSshot(driver, test);
									test.log(LogStatus.FAIL, " Record is not delated");
								}
						}
						
						}catch(Exception e) {
						test.log(LogStatus.INFO, "No Document is Exists :");
					}
									
					try {
						selectByVisibleText(driver, test, OCR_DocumentType, "Enter Document Type : ", DocType);
						typeText(driver, test, OCR_DocDescription, "Add Description : ", DocDesc);
						clickElement(driver, test, OCR_UploadFile, "click on upload file");
						uploadFile(driver, test, UploadfileName, "upload document : "+UploadfileName);
						Wait.waitfor(5);
						clickElement(driver, test, "(//button[@id='closeTop'])[1]", "click on cancel");
					} catch (Exception e) {
						testFailSshot(driver, test);
					//	e.printStackTrace();
						clickElement(driver, test, "(//button[@id='closeTop'])[1]", "click on cancel");
						test.log(LogStatus.FAIL, "Click on cancel");
					}
				}
		public void uploadsuccessmessage() {
			isDisplayed(driver,OCR_fileuploadMessage );
			test.log(LogStatus.PASS, "File Uploaded successfully.");
		}
		
		public void emailrelfilebtn() {
			clickElement(driver, test, OCR_emailrelfilebtn, "Clicking on email related file button");
		}
		public void emailsendsuccessmsg() {
			isDisplayed(driver,OCR_emailsendsucessmessage );
			test.log(LogStatus.PASS, "Email has been successfully sent to user");
		}
		public void popupclose() {
			clickElement(driver, test, OCR_popupclose, "Clicking on close button");
		}
		public void sendemail(String SendTo, String EmailCC, String EmailSubject, String EmailBody) {
			clickElement(driver, test, "//i[@class='fa fa-check cboxAll']", "Clicking on checkbox");
			typeText(driver, test, OCR_emailsendTo, "Enter email send To : ", SendTo);
			typeText(driver, test, OCR_emailsendCC, "Enter email CC : ", EmailCC);
			typeText(driver, test, OCR_emailsendSubject, "Enter email subject : ", EmailSubject);
			typeText(driver, test, OCR_emailsendBody, "Enter email body : ", EmailBody);
			clickElement(driver, test, OCRSendEmailbtn, "Clicking on send email button");
			
		}
		public void deleteAttachFilebtn() {
			clickElement(driver, test, OCR_deleteattachfilebtn, "Clicking on delete attach file button");
		}
		public void delFilemsgCapture() {
			isDisplayed(driver,OCR_deletefilemsgcapture );
			test.log(LogStatus.PASS, "Record has been deleted successfully");
		}
		
		public String fetch_PLFromSelectedShipNum() {
			Wait.waitfor(2);
			return getText(driver, test, "//table[@class='table table-condensed table-bordered table-striped']/tbody/tr/td[1]", "Fetching the sucess value of PL : ");
	
		}
		
		public void createPLFromSelectedShipmentBtn() {
			Wait.waitfor(5);
			scrollToElement(driver, "//button[@name='addPackinglist']");
			clickElement(driver, test, "//button[@name='addPackinglist']", "CLick on Create packing List From Selected Shipments button : ");
		}
		
		public void closePopUp() {
			Wait.waitfor(2);
			clickElement(driver, test, "//button[@id='close_btn']", "click on Close Pop up button : ");
		}
		
		//Validate Heading
		public void headingValidation() {
			try {
				if(isDisplayed(driver, "//h3[contains(text(),'Result Shipment')]")) {
					test.log(LogStatus.PASS, "Heading is Displayed :");
				}
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Heading is Not Displayed :");
			}
		}
		
		//Click on PDF Icon
		public void pdfIcon() {
			clickElement(driver, test, OCR_PDFIcon, "Clicking on PDF Icon :");
		}
		
		//Generate Document Popup Validation   ............................Added By Saddam
		public void generatePopupValidation() {
			try {
				if(isDisplayed(driver, OCR_GenerateDocPopupValidation)) {
					test.log(LogStatus.PASS, "Generate Document Popup is Displayed :");
				}
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Generate Document Popup Is Not Displayed :");
			}
		}
		
		//Check Commercial Invoice Checkbox is Checked or Not   ............................Added By Saddam
		public void cvinCheckedorNot() {
			scrollToElement(driver, "//input[@value='CINV']");
			try {
				if(isSelected(driver, "//input[@value='CINV']")) {
					clickElement(driver, test, "(//i[@class='fa fa-download'])[18]", "Clicking on Commercial Invoice Download Icon :");
					Wait.waitfor(3);
					downloadFile(driver, test, "Downloading the Commercial Invoice PDF :");
					Wait.waitfor(3);
				}else {
					clickElement(driver, test, "//input[@value='CINV']", "Clicking on Commerical Invoice Checkbox :");
					clickElement(driver, test, "(//i[@class='fa fa-download'])[18]", "Clicking on Commercial Invoice Download Icon :");
					Wait.waitfor(3);
					downloadFile(driver, test, "Downloading the Commercial Invoice PDF :");
					Wait.waitfor(3);
				}
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Download the Commericial Invoice PDF :");
			}
		}
		
		//Click on Commercial Invoice Email Icon       ............................Added By Saddam
		public void commericialInvoiceEmailIcon() {
			scrollToElement(driver, "(//a[@class='email-doc'])[18]");
			clickElement(driver, test, "(//a[@class='email-doc'])[18]", "Clicking on Commercial Invoice Email Icon :");
			try {
				if(isDisplayed(driver, "(//h4[@class='modal-title'])[1]")) {
					test.log(LogStatus.PASS, "Generate Document Popup is Displayed :");
				}
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Generate Document Popup Is Not Displayed :");
			}
			scrollToElement(driver, OCR_EmailPopupBackButton);
			clickElement(driver, test, OCR_EmailPopupBackButton, "Clicking on Back Button :");
			Wait.waitfor(3);
		}
		
		//Check Packing List Checkbox is Checked or Not      ............................Added By Saddam
		public void packingListCheckedorNot() {
			scrollToElement(driver, "//input[@value='HPK']");
			try {
				if(isSelected(driver, "//input[@value='HPK']")) {
					clickElement(driver, test, "(//i[@class='fa fa-download'])[37]", "Clicking on Packing List Download Icon :");
					Wait.waitfor(3);
					downloadFile(driver, test, "Downloading the Packing List PDF :");
					Wait.waitfor(3);
				}else {
					clickElement(driver, test, "//input[@value='HPK']", "Clicking on Packing List Checkbox :");
					clickElement(driver, test, "(//i[@class='fa fa-download'])[37]", "Clicking on Packing List Download Icon :");
					Wait.waitfor(3);
					downloadFile(driver, test, "Downloading the Packing List PDF :");
					Wait.waitfor(3);
				}
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Download the Packing List PDF :");
			}
		}
		
		//Click on Packing List Email Icon          ............................Added By Saddam
		public void packinglistEmailIcon() {
			scrollToElement(driver, "(//a[@class='email-doc'])[37]");
			clickElement(driver, test, "(//a[@class='email-doc'])[37]", "Clicking on Packing List Email Icon :");
			try {
				if(isDisplayed(driver, "(//h4[@class='modal-title'])[1]")) {
					test.log(LogStatus.PASS, "Generate Document Popup is Displayed :");
				}
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Generate Document Popup Is Not Displayed :");
			}
			scrollToElement(driver, OCR_EmailPopupBackButton);
			clickElement(driver, test, OCR_EmailPopupBackButton, "Clicking on Back Button :");
			Wait.waitfor(3);
		}
		
		//Check Shipper Letter of instruction Checkbox is Checked or Not   ............................Added By Saddam
		public void shipperletterofInstCheckedorNot() {
			scrollToElement(driver, "//input[@value='SLI']");
			try {
				if(isSelected(driver, "//input[@value='SLI']")) {
					clickElement(driver, test, "(//i[@class='fa fa-download'])[43]", "Clicking on Shipper Letter of instruction Download Icon :");
					Wait.waitfor(3);
					downloadFile(driver, test, "Downloading the Shipper Letter of instruction PDF :");
					Wait.waitfor(3);
				}else {
					clickElement(driver, test, "//input[@value='SLI']", "Clicking on Shipper Letter of instruction Checkbox :");
					clickElement(driver, test, "(//i[@class='fa fa-download'])[43]", "Clicking on Shipper Letter of instruction Download Icon :");
					Wait.waitfor(3);
					downloadFile(driver, test, "Downloading the Shipper Letter of instruction PDF :");
					Wait.waitfor(3);
				}
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Download the Shipper Letter of Instruction PDF :");
			}
		}
		
		//Click on Shipper Letter of instruction Email Icon    ............................Added By Saddam
		public void shipperLetterofInstructionEmailIcon() {
			scrollToElement(driver, "(//a[@class='email-doc'])[43]");
			clickElement(driver, test, "(//a[@class='email-doc'])[43]", "Clicking on Shipper Letter of instruction Email Icon :");
			try {
				if(isDisplayed(driver, "(//h4[@class='modal-title'])[1]")) {
					test.log(LogStatus.PASS, "Generate Document Popup is Displayed :");
				}
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Generate Document Popup Is Not Displayed :");
			}
			scrollToElement(driver, OCR_EmailPopupBackButton);
			clickElement(driver, test, OCR_EmailPopupBackButton, "Clicking on Back Button :");
			Wait.waitfor(3);
		}
		
		//Check Straight Bill Of Lading Checkbox is Checked or Not      ............................Added By Saddam
		public void straightBillOfladdingCheckedorNot() {
			scrollToElement(driver, "//input[@value='BDF']");
			try {
				if(isSelected(driver, "//input[@value='BDF']")) {
					clickElement(driver, test, "(//i[@class='fa fa-download'])[1]", "Clicking on Straight Bill Of Lading Download Icon :");
					Wait.waitfor(3);
					downloadFile(driver, test, "Downloading the Commercial Invoice PDF :");
					Wait.waitfor(3);
				}else {
					clickElement(driver, test, "//input[@value='BDF']", "Clicking on Commerical Invoice Checkbox :");
					clickElement(driver, test, "(//i[@class='fa fa-download'])[1]", "Clicking on Straight Bill Of Lading Download Icon :");
					Wait.waitfor(3);
					downloadFile(driver, test, "Downloading the Straight Bill Of Lading PDF :");
					Wait.waitfor(3);
				}
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Download the Straight Bill Of Lading PDF :");
			}
		}
		
		//Click on Straight Bill Of Lading Email Icon       ............................Added By Saddam
		public void straightBillOfLadingEmailIcon() {
			scrollToElement(driver, "(//a[@class='email-doc'])[1]");
			clickElement(driver, test, "(//a[@class='email-doc'])[1]", "Clicking on Shipper Letter of instruction Email Icon :");
			try {
				if(isDisplayed(driver, "(//h4[@class='modal-title'])[1]")) {
					test.log(LogStatus.PASS, "Generate Document Popup is Displayed :");
				}
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Generate Document Popup Is Not Displayed :");
			}
			scrollToElement(driver, OCR_EmailPopupBackButton);
			clickElement(driver, test, OCR_EmailPopupBackButton, "Clicking on Back Button :");
			Wait.waitfor(3);
		}
		
		//Click on Attach Icon From Grid       ...................Added by Saddam
		public void attachIcon() {
			clickElement(driver, test, OCR_AttachIcon, "Clicking on Attach Icon  :");
		}
		
		//Click on Close Popup Icon
		public void pdfclosePopupIcon() {
			scrollToElement(driver, OCR_PopupCloseIcon);
			clickElement(driver, test, OCR_PopupCloseIcon, "Clicking on Close Popup Icon :");
		}
		
		//Click on Shipment No
		public void shipmentNoClick() {
			clickElement(driver, test, "//td[@aria-describedby='grid_shipmentNo']", "Clicking on Shipment No :");
		}
		
		// Uploading the Document
		public void add_DocumentandClickEmail(String DocType, String DocDesc, String UploadfileName) {
			try {
				selectByVisibleText(driver, test, OCR_DocumentType, "Enter Document Type : ", DocType);
				typeText(driver, test, OCR_DocDescription, "Add Description : ", DocDesc);
				clickElement(driver, test, OCR_UploadFile, "click on upload file");
				uploadFile(driver, test, UploadfileName, "upload document : "+UploadfileName);
				Wait.waitfor(5);
			} catch (Exception e) {
				testFailSshot(driver, test);
				//	e.printStackTrace();
				clickElement(driver, test, "(//button[@id='closeTop'])[1]", "click on cancel");
				test.log(LogStatus.FAIL, "Click on cancel");
			}
		}
		
		//Click on Cancel Icon in Add Document
		public void cancelIcon() {
			clickElement(driver, test, "(//button[@id='closeTop'])[1]", "click on cancel");
		}
	}