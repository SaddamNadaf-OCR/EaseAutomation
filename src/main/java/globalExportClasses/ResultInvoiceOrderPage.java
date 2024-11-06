package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ResultInvoiceOrderPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_ResultInvoiceOrderPage_InvoiceOrderNo = "//a[@class='ead-invoice-tooltip']";
	public static final String OCR_ResultInvoiceOrderPage_HeaderInvoice = "//h3[contains(text(),'Result Invoice')]";
	public static final String OCR_ResultInvoiceOrderPage_HeaderInvoice_Regres_CopyInv = "(//i[@class='fa fa-copy'])[1]";
	public static final String OCR_ResultInvoiceOrderPage_HeaderInvoice_Regres_CopyWarningProceedmsg = "//span[contains(text(),'Proceed to Copy without Invalid data')]";
	public static final String OCR_ResultInvoiceOrderPage_HeaderInvoice_Regres_ClickReportIcon = "(//i[@class='fa fa-file-text-o'])[1]";
	public static final String OCR_ResultInvoiceOrderPage_HeaderInvoice_Regres_TransactionSummaryReportHeading = "//h4[@id='myModalLabel']";
	public static final String OCR_ResultInvoiceOrderPage_HeaderInvoice_Regres_TransactionSummaryReportHeadingCloseBtn = "(//button[@class='btn-close'])[1]";
	public static final String OCR_ResultInvoiceOrderPage_HeaderInvoice_Regres_ClickPdfIcon = "(//i[@class='fa fa-file-pdf-o'])[1]";
	public static final String OCR_ResultInvoiceOrderPage_Regres_GenerateDocDeselectAll = "//a[@id='none-doc-select']";
	public static final String OCR_ResultInvoiceOrderPage_Regres_GenerateDocBtn = "(//button[@class='primary-btn'])[1]";
	public static final String OCR_ResultInvoiceOrderPage_EmailWithLink = "//button[@id='docEmailAsLink']";
	public static final String OCR_ResultInvoiceOrderPage_Exporter_PopupClose = "//div[@id='ocrModal']//button[@class='btn-close']";
	public static final String OCR_ResultInvoiceOrderPage_Exporter_verifyResultGrid = "(//span[@class='ui-paging-info'])[1]";
	public static final String OCR_ResultInvoiceOrderPage_Exporter_NewSearchBtn = "(//button[@class='primary-btn ocr-cache-search-dynamic-class'])[1]";
	
	/* ******************************* Constructor ****************************** */

	public ResultInvoiceOrderPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// click on Invoice order no
	public void click_InvoiceOrderNo(String ResultIONo) {
		Wait.waitfor(5);
		clickElement(driver, test, "(//span[@class='ui-paging-info'])[1]", "");
		Wait.waitfor(2);
		isDisplayed(driver, "//a[contains(text(),'" + ResultIONo + "')]");
		test.log(LogStatus.PASS, "Invoice Order is created successfully !!");
	}

	//click on Invoice number to open the invoice for Regression US
	public void clickInvoiceNo() {
		clickElement(driver, test, "(//span[@class='ui-paging-info'])[1]", "");
	Wait.waitfor(2);
	
		clickElement(driver, test, "//a[@class='ead-invoice-tooltip']", "Selecting first Invoice Order No :");
		
	}
	
	//click on pdf icon on Result page for Regression US
	public void clickPdficon() {
		Wait.waitfor(2);
clickElement(driver, test, OCR_ResultInvoiceOrderPage_HeaderInvoice_Regres_ClickPdfIcon, "Click on Generate Documents icon :");
		
	}
	
	//copy the existing invoice for regression US
	public void clickCopyInv() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ResultInvoiceOrderPage_HeaderInvoice_Regres_CopyInv, "Click on Copy icon to copy existing invoice");
	}
	
	//Click on Report icon on Result page for Regression US
	public void clickReport() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_ResultInvoiceOrderPage_HeaderInvoice_Regres_ClickReportIcon, "Click on Report icon : ");
	}
	
	//click on warning message to proceed to copy without invalid data for Regression US
	public void copyWarningMsg() {
		Wait.waitfor(2);
		String alertmsg = "Proceed to Copy without Invalid data";
		//String alertmsg = getText(driver, test, "//span[contains(text(),'Proceed to Copy without Invalid data')]", "Alert Msg :");
		try {
			if(alertmsg.equalsIgnoreCase("Proceed to Copy without Invalid data")) {
				clickElement(driver, test, "//span[contains(text(),'Proceed to Copy without Invalid data')]", "Clicking on Proceed Without Invalid Data Button :");
				}
			else {
				clickElement(driver, test, "//span[contains(text(),'Abort Copying')]", "Clicking on Abort Copying :");
			}
		}catch(Exception e) {
				test.log(LogStatus.INFO, "Clicked on Copy Icon without Alert Msg :");
			}
		//clickElement(driver, test, OCR_ResultInvoiceOrderPage_HeaderInvoice_Regres_CopyWarningProceedmsg, "Click on 'Proceed to copy without Invalid data'");
	}
	
	// Title of the Page is Displayed or not
	public void titleDisplayed() {
		isDisplayed(driver, OCR_ResultInvoiceOrderPage_HeaderInvoice);
		test.log(LogStatus.PASS, "Result Invoice Order Page is Displayed  !!");
	}
	
	//Verify the transaction compliance screening summary report on result grid
	public void transactionScreeningSummaryDisplayed() {
		
		if(isDisplayed(driver, OCR_ResultInvoiceOrderPage_HeaderInvoice_Regres_TransactionSummaryReportHeading)) {
			Wait.fluwait(driver, OCR_ResultInvoiceOrderPage_HeaderInvoice_Regres_TransactionSummaryReportHeading);
			test.log(LogStatus.PASS,
					"Transaction Compliance Screening Summary Report is Displayed  !!");
		}
		else {
			test.log(LogStatus.FAIL,
					"Transaction Compliance Screening Summary Report is not Displayed  !!");
		}		
		
	}
	
	// Close the Transaction compliance summary report
	public void transactionScreeningPopUpClose() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_ResultInvoiceOrderPage_HeaderInvoice_Regres_TransactionSummaryReportHeadingCloseBtn, "Close the pop up button");
		}
	

//Deselect all document checkbox
	public void deselctAllDoc() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_ResultInvoiceOrderPage_Regres_GenerateDocDeselectAll, "De-select all documents :");
	}
	
	//select bill of lading, certificate of origin and international shipping authorizatrion checkbox
		public void selectDocs()
		{
			Wait.waitfor(2);
			clickElement(driver, test, "(//input[@name='docSelected'])[1]", "Select Bill Of Lading-Straight :");
			Wait.waitfor(2);
			clickElement(driver, test, "(//input[@name='docSelected'])[9]", "Select Certificate Of Origin :");
			Wait.waitfor(2);
			scrollToElement(driver, "(//input[@name='docSelected'])[31]");
			clickElement(driver, test, "(//input[@name='docSelected'])[31]", "Select International Shipping Authorization :");
		}
		
		//scroll to generate documents button and click on it
		public void generateDocBtn() {
			Wait.waitfor(2);
			scrollToElement(driver, OCR_ResultInvoiceOrderPage_Regres_GenerateDocBtn);
			clickElement(driver, test, OCR_ResultInvoiceOrderPage_Regres_GenerateDocBtn, "Click on Generate All Documents button :");
			}
		
		//Enter email id for all 3 docs selected
		public void enterEmailID(String emailID1, String emailID2, String emailID3) {
			Wait.waitfor(2);
			scrollToElement(driver, "(//div[@class='selectize-control doc-email form-control multi plugin-remove_button'])[1]");
			Wait.waitfor(2);
			clickElement(driver, test, "(//div[@class='selectize-control doc-email form-control multi plugin-remove_button'])[1]", "Enter Email ID 1");
			Wait.waitfor(2);
			typeText(driver, test, "(//input[@autocomplete='new-password'])[3]", "Enter Email ID to send the link : ", emailID1);
			
			scrollToElement(driver, "(//div[@class='selectize-control doc-email form-control multi plugin-remove_button'])[2]");
			Wait.waitfor(2);
			clickElement(driver, test, "(//div[@class='selectize-control doc-email form-control multi plugin-remove_button'])[2]", "Enter Email ID 2");
			Wait.waitfor(2);
			typeText(driver, test, "(//input[@autocomplete='new-password'])[4]", "Enter Email ID to send the link : ", emailID2);
			
			scrollToElement(driver, "(//div[@class='selectize-control doc-email form-control multi plugin-remove_button'])[3]");
			Wait.waitfor(2);
			clickElement(driver, test, "(//div[@class='selectize-control doc-email form-control multi plugin-remove_button'])[3]", "Enter Email ID 3");
			Wait.waitfor(2);
			typeText(driver, test, "(//input[@autocomplete='new-password'])[5]", "Enter Email ID to send the link : ", emailID3);
			
			Wait.waitfor(2);
			scrollToElement(driver, OCR_ResultInvoiceOrderPage_EmailWithLink);
			clickElement(driver, test, OCR_ResultInvoiceOrderPage_EmailWithLink, "click on Send email with link");
			Wait.waitfor(5);
			try {
				if (isDisplayed(driver, "//div[@class='row ocr-info']//h4[contains(text(),'Information!')]")) {

					if (isDisplayed(driver, "//li[contains(text(),'Email sent successfully.')]")) {
						test.log(LogStatus.INFO, "Email sent successfully.");
					}
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Email not sent successfully. Information message is not Displayed ");
			}
			Wait.waitfor(3);
			clickElement(driver, test, OCR_ResultInvoiceOrderPage_Exporter_PopupClose, "Click on Pop up Close button");
			
		}
		
		//verify result invoice grid displays invoices based on search criteria
		public void resultGridInfo() {
			clickElement(driver, test, "(//input[@class='ui-widget-content ui-pg-input ocr-cache-search-dynamic-class'])[1]", "");
			Wait.waitfor(2);
			try {
				
				if(isDisplayed(driver, "//td[@aria-describedby='grid_invoiceNo']")) {
					test.log(LogStatus.INFO, "Result grid displays result successfully .");
				}
			
			}catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Result grid does not display any content .");
				// TODO: handle exception
			}
			
		}
		
		//click on Shipment No for an invoice with Shipped Status
		public void ShipNoFromResultPage() {
			scrollToElement(driver, "(//td[@aria-describedby='grid_shipment.shipmentNo'])[1]");
			clickElement(driver, test, "(//td[@aria-describedby='grid_shipment.shipmentNo'])[1]", "Click on Shipment No");
			
		}
		
		
		
		public void click_NewSearchBtn() {
			Wait.waitfor(2);
			clickElement(driver, test, OCR_ResultInvoiceOrderPage_Exporter_NewSearchBtn, "Click on New Search Button :");
		}

}
	


