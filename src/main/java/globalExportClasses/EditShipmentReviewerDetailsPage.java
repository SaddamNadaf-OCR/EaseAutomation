package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class EditShipmentReviewerDetailsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_Shipment_Review_Save = "(//button[contains(text(),'Save')])[1]";
	public static final String OCR_Shipment_Review_SaveAndReturn = "//button[@id='saveandreturn']";
	public static final String OCR_Shipment_Review_RequestorInformationLink = "//a[@id='reqInfo-popup']";
	public static final String OCR_Shipment_Review_ShippingDeptReviewerLink = "//a[@id='shippingDeptReviewer-popup']";
	public static final String OCR_Shipment_Review_ExportComplianceReviewerLink = "//a[@id='expCompReviewer-popup']";
	public static final String OCR_Shipment_Review_TransportGatekeeperExportOpsLink = "//a[@id='transportationreviewer-popup']";
	public static final String OCR_Shipment_Review_UserFirstName = "//input[@id='searchForm_userProfile_userFirstname']";
	public static final String OCR_Shipment_Review_Search = "//button[@name='Search']";
	public static final String OCR_Shipment_Review_Select = "//div[@id='resultDIV']//div[3]//div[1]//button[1]";
	public static final String OCR_Shipment_Review_AddReviewerNotes = "//button[@id='addReviewerNotesBtn']";
	public static final String OCR_Shipment_Review_Notes = "//textarea[@id='editTabbedShipmentReviewerNotes_shipmentReviewerNotes_reviewerNote']";
	public static final String OCR_Shipment_Review_NoteSave = "//div[@class='modal-footer']//button[@class='primary-btn'][contains(text(),'Save')]";
	public static final String OCR_Shipment_Review_closePopUp = "(//button[@class='btn-close'])[1]";
	public static final String OCR_Shipment_Review_SR_Reason = "//select[@id='editShipment_shippingReview_reason']";
	public static final String OCR_Shipment_Review_SR_ReviewerRemark = "//textarea[@id='editShipment_shippingReview_reviewRemark']";
	public static final String OCR_Shipment_Review_ReasonsForReworkSave = "//button[@id='saveReview']";
	public static final String OCR_Shipment_Review_ER_Reason = "//select[@id='editShipment_exportReview_reason']";
	public static final String OCR_Shipment_Review_ER_ReviewerRemark = "//textarea[@id='editShipment_exportReview_reviewRemark']";
	public static final String OCR_Shipment_Review_TR_Reason = "//select[@id='editShipment_transportReview_reason']";
	public static final String OCR_Shipment_Review_TR_ReviewerRemark = "//textarea[@id='editShipment_transportReview_reviewRemark']";
	public static final String OCR_Shipment_Review_TR_AdditionalTransaction = "//i[@class='fa fa-th']";
	public static final String OCR_Shipment_Review_TR_ShipmentForm = "//a[contains(text(),'Shipment Form')]";

	public static final String OCR_Shipment_Review_TR_ShipReviewerRegion = "//select[@id='searchForm_regionId']";
	public static final String OCR_Shipment_Review_TR_ShipReviewerSite = "//select[@id='searchForm_siteId']";

	/* ******************************* Constructor ****************************** */

	public EditShipmentReviewerDetailsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Add Reviewer Details
	public void add_ShipReviewDetails(String RequestorReviewer, String ShippingDeptReviewer,
			String ExportComplianceReviewer, String TransportGatekeeperExportOps) {
		Wait.waitfor(3);
		clickElement(driver, test, "//input[@id='editShipment_shipment_intConsContactPhone']",
				"Mouse over to Requestor Reviewer");
		if (RequestorReviewer.length() > 0) {
			clickElement(driver, test, OCR_Shipment_Review_RequestorInformationLink, "Click on Requestor Information");
			try {
				typeText(driver, test, OCR_Shipment_Review_UserFirstName, "Enter the User First Name : ",
						RequestorReviewer);
				clickElement(driver, test, OCR_Shipment_Review_Search, "Click on Search button");
				Wait.fluwait(driver, "//div[@id='load_gridPopup']");
				Wait.waitfor(20);
				clickElement(driver, test, "(//td[contains(text(),'" + RequestorReviewer + "')])[1]",
						"Select the Requestor Reviewer : " + RequestorReviewer);
				clickElement(driver, test, OCR_Shipment_Review_Select, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_Shipment_Review_closePopUp, "Click on Cancel popup icon");
			}
		}
		if (ShippingDeptReviewer.length() > 0) {
			Wait.waitfor(2);
			clickElement(driver, test, OCR_Shipment_Review_ShippingDeptReviewerLink,
					"Click on Shipping Dept Reviewer Link");
			try {
				typeText(driver, test, OCR_Shipment_Review_UserFirstName, "Enter the User First Name : ",
						ShippingDeptReviewer);
				Wait.waitfor(2);
				clickElement(driver, test, OCR_Shipment_Review_Search, "Click on Search button");
				Wait.waitfor(3);
				Wait.fluwait(driver, "//div[@id='load_gridPopup']");
				Wait.waitfor(20);
				clickElement(driver, test,
						"//div[@class='ocr-modal-base']//tr//td[contains(text(),'" + ShippingDeptReviewer + "')]",
						"Select the Shipping Dept Reviewer : " + ShippingDeptReviewer);
				Wait.waitfor(3);
				clickElement(driver, test, OCR_Shipment_Review_Select, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_Shipment_Review_closePopUp, "Click on Cancel popup icon");
			}
		}
		if (ExportComplianceReviewer.length() > 0) {
			Wait.waitfor(2);
			clickElement(driver, test, OCR_Shipment_Review_ExportComplianceReviewerLink,
					"Click on Export Compliance Reviewer Link");
			try {
				typeText(driver, test, OCR_Shipment_Review_UserFirstName, "Enter the User First Name : ",
						ExportComplianceReviewer);
				Wait.waitfor(2);
				clickElement(driver, test, OCR_Shipment_Review_Search, "Click on Search button");
				Wait.fluwait(driver, "//div[@id='load_gridPopup']");
				Wait.waitfor(30);
				clickElement(driver, test,
						"//div[@class='ocr-modal-base']//tr//td[contains(text(),'" + ExportComplianceReviewer + "')]",
						"Select the Export Compliance Reviewer : " + ExportComplianceReviewer);
				Wait.waitfor(3);
				clickElement(driver, test, OCR_Shipment_Review_Select, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_Shipment_Review_closePopUp, "Click on Cancel popup icon");
			}
		}
		if (TransportGatekeeperExportOps.length() > 0) {
			Wait.waitfor(2);
			clickElement(driver, test, OCR_Shipment_Review_TransportGatekeeperExportOpsLink,
					"Click on Transport Gate Keeper Export Ops Link");
			try {
				typeText(driver, test, OCR_Shipment_Review_UserFirstName, "Enter the User First Name : ",
						TransportGatekeeperExportOps);
				Wait.waitfor(2);
				clickElement(driver, test, OCR_Shipment_Review_Search, "Click on Search button");
				Wait.fluwait(driver, "//div[@id='load_gridPopup']");
				Wait.waitfor(30);
				clickElement(driver, test,
						"//div[@class='ocr-modal-base']//tr//td[contains(text(),'" + TransportGatekeeperExportOps
								+ "')]",
						"Select the Transport Gate keeper Export Ops : " + TransportGatekeeperExportOps);
				Wait.waitfor(3);
				clickElement(driver, test, OCR_Shipment_Review_Select, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_Shipment_Review_closePopUp, "Click on Cancel popup icon");
			}
		}
	}

	// Adding reviewer details for Regression US

	// Add Reviewer Details
	public void add_ShipReviewDetails(String ShippingDeptReviewer, String ShipRegion, String ShipSite,
			String ExportComplianceReviewer, String ExportRegion, String ExportSite,
			String TransportGatekeeperExportOps, String TransRegion, String TransSite) {
		Wait.waitfor(3);

		if (ShippingDeptReviewer.length() > 0) {
			Wait.waitfor(2);
			clickElement(driver, test, OCR_Shipment_Review_ShippingDeptReviewerLink,
					"Click on Shipping Dept Reviewer Link");
			try {
				selectByVisibleText(driver, test, OCR_Shipment_Review_TR_ShipReviewerRegion,
						"Clear the value of Region : ", ShipRegion);
				Wait.waitfor(5);
				selectByVisibleText(driver, test, OCR_Shipment_Review_TR_ShipReviewerSite, "CLear the value of Site : ",
						ShipSite);
				Wait.waitfor(5);
				typeText(driver, test, OCR_Shipment_Review_UserFirstName, "Enter the User First Name : ",
						ShippingDeptReviewer);
				Wait.waitfor(2);
				clickElement(driver, test, OCR_Shipment_Review_Search, "Click on Search button");
				Wait.waitfor(3);
				Wait.fluwait(driver, "//div[@id='load_gridPopup']");
				Wait.waitfor(20);
				clickElement(driver, test,
						"//div[@class='ocr-modal-base']//tr//td[contains(text(),'" + ShippingDeptReviewer + "')]",
						"Select the Shipping Dept Reviewer : " + ShippingDeptReviewer);
				Wait.waitfor(3);
				clickElement(driver, test, OCR_Shipment_Review_Select, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_Shipment_Review_closePopUp, "Click on Cancel popup icon");
			}
		}
		if (ExportComplianceReviewer.length() > 0) {
			Wait.waitfor(2);
			clickElement(driver, test, OCR_Shipment_Review_ExportComplianceReviewerLink,
					"Click on Export Compliance Reviewer Link");
			try {
				selectByVisibleText(driver, test, OCR_Shipment_Review_TR_ShipReviewerRegion,
						"Clear the value of Region : ", ExportRegion);
				Wait.waitfor(5);
				selectByVisibleText(driver, test, OCR_Shipment_Review_TR_ShipReviewerSite, "CLear the value of Site : ",
						ExportSite);
				Wait.waitfor(5);
				typeText(driver, test, OCR_Shipment_Review_UserFirstName, "Enter the User First Name : ",
						ExportComplianceReviewer);
				Wait.waitfor(2);
				clickElement(driver, test, OCR_Shipment_Review_Search, "Click on Search button");
				Wait.fluwait(driver, "//div[@id='load_gridPopup']");
				Wait.waitfor(30);
				clickElement(driver, test,
						"//div[@class='ocr-modal-base']//tr//td[contains(text(),'" + ExportComplianceReviewer + "')]",
						"Select the Export Compliance Reviewer : " + ExportComplianceReviewer);
				Wait.waitfor(3);
				clickElement(driver, test, OCR_Shipment_Review_Select, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_Shipment_Review_closePopUp, "Click on Cancel popup icon");
			}
		}
		if (TransportGatekeeperExportOps.length() > 0) {
			Wait.waitfor(2);
			clickElement(driver, test, OCR_Shipment_Review_TransportGatekeeperExportOpsLink,
					"Click on Transport Gate Keeper Export Ops Link");
			try {
				selectByVisibleText(driver, test, OCR_Shipment_Review_TR_ShipReviewerRegion,
						"Clear the value of Region : ", TransRegion);
				Wait.waitfor(5);
				selectByVisibleText(driver, test, OCR_Shipment_Review_TR_ShipReviewerSite, "CLear the value of Site : ",
						TransSite);
				Wait.waitfor(5);
				typeText(driver, test, OCR_Shipment_Review_UserFirstName, "Enter the User First Name : ",
						TransportGatekeeperExportOps);
				Wait.waitfor(2);
				clickElement(driver, test, OCR_Shipment_Review_Search, "Click on Search button");
				Wait.fluwait(driver, "//div[@id='load_gridPopup']");
				Wait.waitfor(30);
				clickElement(driver, test,
						"//div[@class='ocr-modal-base']//tr//td[contains(text(),'" + TransportGatekeeperExportOps
								+ "')]",
						"Select the Transport Gate keeper Export Ops : " + TransportGatekeeperExportOps);
				Wait.waitfor(3);
				clickElement(driver, test, OCR_Shipment_Review_Select, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_Shipment_Review_closePopUp, "Click on Cancel popup icon");
			}
		}
	}

	// Click on Save
	public void click_save() {
		scrollToElement(driver, OCR_Shipment_Review_Save);
		scrollToTop(driver);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Shipment_Review_Save, "Click on Save button in Reviewer");
	}

	// Adding the Shipping reviewer
	public String addingShippingReviewer(String ShippingReason, String ShippingRemark) {
		selectByVisibleText(driver, test, OCR_Shipment_Review_SR_Reason, "Select the Shipping Reason : ",
				ShippingReason);
		typeText(driver, test, OCR_Shipment_Review_SR_ReviewerRemark, "Enter the Shipping Reviewer Remark : ",
				ShippingRemark);
		scrollToBottom(driver);
		Wait.waitfor(3);
		clickElement(driver, test, "//div[@id='shipmentReviewBlock2']//div[@class='lcs_cursor']",
				"Click on toggle to YES");
		clickElement(driver, test, OCR_Shipment_Review_ReasonsForReworkSave, "Click on Save in Reviewer Reason");
		click_save();
		Wait.waitfor(5);
		scrollToBottom(driver);
		scrollToBottom(driver);
		return getText(driver, test, "//table[@id='grid-reviewerNotes']//tr[2]/td[2]", "Getting the Value : ");
	}
	
	// Adding the Shipping reviewer reason only
		public void addShippingReviewer(String ShippingReason, String Shipremarks) {
			selectByVisibleText(driver, test, OCR_Shipment_Review_SR_Reason, "Select the Shipping Reason : ",
					ShippingReason);
			typeText(driver, test, "//textarea[@id='editShipment_shippingReview_reviewRemark']", "Enter Remarks : ", Shipremarks + randomnumbersbetween1_100());
			
		/*	scrollToBottom(driver);
			Wait.waitfor(3);
			clickElement(driver, test, "//div[@id='shipmentReviewBlock2']//div[@class='lcs_cursor']",
					"Click on toggle to YES");*/
			clickElement(driver, test, OCR_Shipment_Review_ReasonsForReworkSave, "Click on Save in Reviewer Reason");
			click_save();
			Wait.waitfor(5);
			
		}

	// Adding the Export Reviewer
	public String addingExportReviewer(String ExportReason, String ExportRemark) {
		selectByVisibleText(driver, test, OCR_Shipment_Review_ER_Reason, "Select the Export Reason : ", ExportReason);
		typeText(driver, test, OCR_Shipment_Review_ER_ReviewerRemark, "Enter the Export Reviewer Remark : ",
				ExportRemark);
		scrollToBottom(driver);
		Wait.waitfor(3);
		clickElement(driver, test, "//div[@id='shipmentReviewBlock3']//div[@class='lcs_cursor']",
				"Click on toggle to YES");
		clickElement(driver, test, OCR_Shipment_Review_ReasonsForReworkSave, "Click on Save in Reviewer Reason");
		click_save();
		return getText(driver, test, "//table[@id='grid-reviewerNotes']//tr[2]/td[2]", "Getting the Value : ");
	}

	// Adding the Transportation Reviewer
	public String addingTransportationReviewer(String TransportationReason, String TransportationRemark) {
		selectByVisibleText(driver, test, OCR_Shipment_Review_TR_Reason, "Select the Transportation Reason : ",
				TransportationReason);
		typeText(driver, test, OCR_Shipment_Review_TR_ReviewerRemark, "Enter the Export Reviewer Remark : ",
				TransportationRemark);
		scrollToBottom(driver);
		Wait.waitfor(3);
		clickElement(driver, test, "//div[@id='shipmentReviewBlock4']//div[@class='lcs_cursor']",
				"Click on toggle to YES");
		clickElement(driver, test, OCR_Shipment_Review_ReasonsForReworkSave, "Click on Save in Reviewer Reason");
		click_save();
		return getText(driver, test, "//table[@id='grid-reviewerNotes']//tr[2]/td[2]", "Getting the Value : ");
	}

	// upload document
	public void uploadDocument() {
		clickElement(driver, test, "//i[@class='fa fa-upload']", "Click on upload document");

	}

	// click on Additional Transaction Details tab for Regression US
	public void addTransaction() {
		Wait.waitfor(2);
		scrollToElement(driver, OCR_Shipment_Review_TR_AdditionalTransaction);
		clickElement(driver, test, OCR_Shipment_Review_TR_AdditionalTransaction,
				"CLick on Additional Transaction Details tab :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_Shipment_Review_TR_ShipmentForm, "Click on Shipment Form : ");
	}

}
