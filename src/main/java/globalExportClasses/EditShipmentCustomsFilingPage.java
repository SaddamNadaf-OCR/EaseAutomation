package globalExportClasses;
/* 
 * Module : Export Operation
 * Author  : Saddam
 * created date : May 2024
 * Descriptions : Edit Shipment Customs Filing Page
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil 
 */
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class EditShipmentCustomsFilingPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_Heading = "//h3[@class='page-heading']";
	public static final String OCR_ShipmentNo = "(//span[@class='additional-value'])[1]";
	public static final String OCR_Status = "(//span[@class='additional-value'])[2]";
	public static final String OCR_AdditionalTransactionDetails = "//i[@class='fa fa-th']";
	public static final String OCR_PreviousButon = "//button[@id='prev-btn']";
	public static final String OCR_NextButton = "//button[@id='next-btn']";
	public static final String OCR_SaveButton = "(//button[contains(text(),'Save')])[1]";
	public static final String OCR_SaveandReturnButton = "(//button[contains(text(),'Save')])[2]";
	public static final String OCR_CloseButton = "//button[@id='cancelBtn']";
	public static final String OCR_EstimatedRate = "//i[@class='fa fa-money']";
	public static final String OCR_EntityScreeningStatus = "//i[@class='fa fa-user']";
	public static final String OCR_ExportAuthorizationScreeningStatus = "//i[@class='fa fa-legal']";
	public static final String OCR_ComplianceSummaryReport = "//i[@class='fa fa-file-text-o']";
	public static final String OCR_ValidationStatus = "//i[@class='fa fa-exclamation-circle']";
	public static final String OCR_GenerateDocument = "//i[@class='fa fa-file-pdf-o']";
	public static final String OCR_Link_UnlinkInvoices = "//i[@class='fa fa-link']";
	public static final String OCR_UploadFileAttachment = "//i[@class='fa fa-upload']";
	public static final String OCR_EEINo = "//input[@name='shipment.sedNo']";
	public static final String OCR_AESStatus = "//select[@name='shipment.shipmentCustomFilingStatus']";
	public static final String OCR_CorrectionCode = "//a[@id='correctioncode-popup']";
	public static final String OCR_SelectPopup = "//button[@name='Ok']";
	public static final String OCR_ClosePopup = "(//button[@class='btn-close'])[1]";
	public static final String OCR_CorrectionCodetextbox = "//input[@name='shipment.correctionCode']";
	public static final String OCR_AESOption = "//select[@name='shipment.aesOption']";
	public static final String OCR_ITN = "//input[@name='shipment.itn']";
	public static final String OCR_XTN = "//input[@name='shipment.xtn']";
	public static final String OCR_RoutedExportTXN = "//select[@name='shipment.routedExportTransaction']";
	public static final String OCR_RelatedPartyTXN = "//select[@name='shipment.relatedPartyTransaction']";
	public static final String OCR_StateOfOrigin = "//a[@id='stateoforigin-popupp']";
	public static final String OCR_MexicanDestinationState = "//a[contains(text(),'Mexican Destination State')]";
	public static final String OCR_FTZNo = "//input[@name='shipment.ftzNo']";
	public static final String OCR_DECCode = "//a[contains(text(),'DEC Code')]";
	public static final String OCR_OriginalITN = "//input[@id='editShipment_shipment_originalItnNo']";

	/* ******************************* Constructor ****************************** */

	public EditShipmentCustomsFilingPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	// Click on Additional Transaction Details
	public void additionalTransactionDetails() {
		clickElement(driver, test, OCR_AdditionalTransactionDetails, "Clicking on Additional Transaction Details :");
	}

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

	// Click on Save Button
	public void save() {
		clickElement(driver, test, OCR_SaveButton, "Clicking on Save Button :");
	}

	// Click on Save and Return button
	public void saveandreturn() {
		clickElement(driver, test, OCR_SaveandReturnButton, "Clicking on Save and Return button :");
	}

	// Add Edit Shipment Custom Filling Details
	public void addCustomFillingDetails(String EEINo, String AESStatus, String AESOption, String ITN, String XTN,
			String RoutedXTN, String RelatedPartyTXN, String FTZNo, String OriginITN) {
		typeText(driver, test, OCR_EEINo, "Entering EEI No :", EEINo);
		selectByVisibleText(driver, test, OCR_AESStatus, "Selecting AES Status :", AESStatus);
		clickElement(driver, test, OCR_CorrectionCode, "Clicking on Correction Code :");
		try {
			mouseOverAndClick(driver, test, "(//td[@aria-describedby='gridPopup_correctionCode'])[1]",
					"Clicking on Correction Code :");
			clickElement(driver, test, OCR_SelectPopup, "Clicking on Select popup Button :");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_ClosePopup, "Clicking on Close Popup Icon :");
		}
		selectByVisibleText(driver, test, OCR_AESOption, "Selecting AES option :", AESOption);
		typeText(driver, test, OCR_ITN, "Entering ITN :", ITN);
		typeText(driver, test, OCR_XTN, "Entering XTN :", XTN);
		selectByVisibleText(driver, test, OCR_RoutedExportTXN, "Selecting Routed Export TXN :", RoutedXTN);
		selectByVisibleText(driver, test, OCR_RelatedPartyTXN, "Selecting Related Party TXN :", RelatedPartyTXN);
		clickElement(driver, test, OCR_StateOfOrigin, "Clicking on State Of Origin :");
		try {
			mouseOverAndClick(driver, test, "(//td[@aria-describedby='gridPopup_correctionCode'])[1]",
					"Clicking on Correction Code :");
			clickElement(driver, test, OCR_SelectPopup, "Clicking on Select popup Button :");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_ClosePopup, "Clicking on Close Popup Icon :");
		}
		clickElement(driver, test, OCR_MexicanDestinationState, "Clicking on Mexican Destination State :");
		try {
			mouseOverAndClick(driver, test, "(//td[@aria-describedby='gridPopup_correctionCode'])[1]",
					"Clicking on Correction Code :");
			clickElement(driver, test, OCR_SelectPopup, "Clicking on Select popup Button :");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_ClosePopup, "Clicking on Close Popup Icon :");
		}
		typeText(driver, test, OCR_FTZNo, "Entering FTZ No :", FTZNo);
		clickElement(driver, test, OCR_DECCode, "Clicking on DEC Code :");
		try {
			mouseOverAndClick(driver, test, "(//td[@aria-describedby='gridPopup_correctionCode'])[1]",
					"Clicking on Correction Code :");
			clickElement(driver, test, OCR_SelectPopup, "Clicking on Select popup Button :");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_ClosePopup, "Clicking on Close Popup Icon :");
		}
		typeText(driver, test, OCR_OriginalITN, "Entering Origin ITN :", OriginITN);
	}

	// Getting the Shipment No
	public String get_ShipmentID() {
		return getText(driver, test, OCR_ShipmentNo, "Get the Actual Shipment No : ");
	}

	// Getting the Shipment Status
	public String get_ShipmentStatus() {
		return getText(driver, test, OCR_Status, "Get the Actual Shipment Status : ");
	}

}
