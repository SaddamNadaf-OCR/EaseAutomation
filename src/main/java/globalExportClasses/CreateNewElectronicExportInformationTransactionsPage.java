package globalExportClasses;

/* 
 * Module : Export Operation
 * Author  : Saddam
 * created date : June 2024
 * Descriptions : Create New Electronic Export Information Transactions Page
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil 
 */
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewElectronicExportInformationTransactionsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_CreateNewEEITransactionsPage_SaveBtn = "(//button[@class='primary-btn eei ocr-cache-search-dynamic-class'])[1]";
	public static final String OCR_CreateNewEEITransactionsPage_SaveandReturnBtn = "(//button[contains(text(),'Save')])[2]";
	public static final String OCR_CreateNewEEITransactionsPage_CancelBtn = "(//button[contains(text(),'Close')])[1]";
	public static final String OCR_CreateNewEEITransactionsPage_ShipmentNoLink = "//a[@id='shipmentNo-popup']";
	public static final String OCR_CreateNewEEITransactionsPage_ShipmentNoSearch = "//button[@name='Search']";
	public static final String OCR_CreateNewEEITransactionsPage_ShipmentNo = "//input[@id='editSed_shipment_shipmentNo']";
	public static final String OCR_CreateNewEEITransactionsPage_CountryOfUltDest = "//input[@id='editSed_shipment_countryOfUltDest']";
	public static final String OCR_CreateNewEEITransactionsPage_ShipmentNoPopCloseBtn = "(//button[@class='btn-close'])[1]";
	public static final String OCR_CreateNewEEITransactionsPage_Exporter = "//table[@id='entityTable']//a[contains(text(),'Exporter')]";
	public static final String OCR_CreateNewEEITransactionsPage_Exporter_Code = "//a[@name='entityCodeLink']";
	public static final String OCR_CreateNewEEITransactionsPage_Exporter_ExpSearch = "//button[@name='Search']";
	public static final String OCR_CreateNewEEITransactionsPage_Exporter_ExpCode = "//input[@id='searchForm_popupValue_code']";
	public static final String OCR_CreateNewEEITransactionsPage_Exporter_ExpSelect = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_CreateNewEEITransactionsPage_Exporter_Save = "//button[@id='entitySave']";
	public static final String OCR_CreateNewEEITransactionsPage_Exporter_PopupClose = "//div[@id='ocrModal']//button[@class='btn-close']";
	public static final String OCR_CreateNewEEITransactionsPage_UltConsignee = "//a[contains(text(),'Ult. Consignee')]";
	public static final String OCR_CreateNewEEITransactionsPage_UltConsignee_Code = "//a[@name='entityCodeLink']";
	public static final String OCR_CreateNewEEITransactionsPage_UltConsignee_ID = "//input[@id='resultConsigneeWithContactPopup_popupValue_code']";
	public static final String OCR_CreateNewEEITransactionsPage_UltConsignee_Search = "//button[@name='Search']";
	public static final String OCR_CreateNewEEITransactionsPage_UltConsignee_Select = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_CreateNewEEITransactionsPage_UltConsignee_Save = "//button[@id='entitySave']";
	public static final String OCR_CreateNewEEITransactionsPage_UltConsignee_PopupClose = "//div[@id='ocrModal']//button[@class='btn-close']";
	public static final String OCR_CreateNewEEITransactionsPage_EndUserLink = "//a[contains(text(),'End User')]";
	public static final String OCR_CCreateNewEEITransactionsPage_FreightForwarder = "//table[@id='entityTable']//a[contains(text(),'Freight Forwarder')]";
	public static final String OCR_CreateNewEEITransactionsPage_FF_Code = "//a[@name='entityCodeLink']";
	public static final String OCR_CreateNewEEITransactionsPage_FF_FFCode = "//input[@id='resultFfWithContactPopup_popupValue_code']";
	public static final String OCR_CreateNewEEITransactionsPage_FF_Search = "//button[@name='Search']";
	public static final String OCR_CreateNewEEITransactionsPage_FF_Select = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_CreateNewEEITransactionsPage_FF_Save = "//button[@id='entitySave']";
	public static final String OCR_CreateNewEEITransactionsPage_FF_PopupClose = "//div[@id='ocrModal']//button[@class='btn-close']";
	public static final String OCR_CreateNewEEITransactionsPage_IntConsignee = "//a[contains(text(),'Intermediate Consignee')]";
	public static final String OCR_CreateNewEEITransactionsPage_IntConsignee_Code = "//a[@name='entityCodeLink']";
	public static final String OCR_CreateNewEEITransactionsPage_IntConsignee_Id = "//input[@id='resultConsigneeWithContactPopup_popupValue_code']";
	public static final String OCR_CreateNewEEITransactionsPage_IntConsignee_Search = "//button[@name='Search']";
	public static final String OCR_CreateNewEEITransactionsPage_IntConsignee_Select = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_CreateNewEEITransactionsPage_IntConsignee_Save = "//button[@id='entitySave']";
	public static final String OCR_CreateNewEEITransactionsPage_IntConsignee_PopUpClose = "(//button[@class='btn-close'])[1]";
	public static final String OCR_CreateNewEEITTransactionPage_ShipmentNoErrorMsg = "//li[contains(text(),'Shipment No. length cannot be more than 17 characters for AES Direct Submission.')]";
	public static final String OCR_AdditionalTransactionDetails = "//i[@class='fa fa-th']";

	/* ******************************* Constructor ****************************** */

	public CreateNewElectronicExportInformationTransactionsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// click on Save button
	public void savebutton() {
		Wait.waitfor(2);
		scrollToElement(driver, "//input[@id='editSed_shipment_internalRefNo']");
		clickElement(driver, test, "//input[@id='editSed_shipment_internalRefNo']", "");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CreateNewEEITransactionsPage_SaveBtn, "Clicking on Save Button :");
	}

	// click on Save and Return button
	public void saveandReturnbutton() {
		clickElement(driver, test, OCR_CreateNewEEITransactionsPage_SaveandReturnBtn,
				"Clicking on Save and return Button :");
	}

	// click on Cancel button
	public void cancelbutton() {
		clickElement(driver, test, OCR_CreateNewEEITransactionsPage_CancelBtn, "Clicking on Cancel Button :");
	}

	// Adding Shipment No
	public void select_ShipmentNo(String ShipmentNoLink) {
		Wait.waitfor(2);
		try {
			if (ShipmentNoLink.length() > 0) {
				Wait.waitfor(2);
				clickElement(driver, test, OCR_CreateNewEEITransactionsPage_ShipmentNoLink,
						"Click on Template ID Link : ");
				clickElement(driver, test, OCR_CreateNewEEITransactionsPage_ShipmentNoSearch,
						"Click on Search button : ");
				clickElement(driver, test, "//td[contains(text(),'" + ShipmentNoLink + "')]", ShipmentNoLink);
				clickElement(driver, test, "(//button[@name='Ok'])[1]", "Click on Select button :");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_CreateNewEEITransactionsPage_ShipmentNoPopCloseBtn,
					"Click on Close popup icon");
		}
	}

	// Enter Shipment No
	public void enterShipmentNo(String ShipmentNo) {
		Wait.waitfor(2);
		typeText(driver, test, OCR_CreateNewEEITransactionsPage_ShipmentNo, "Enter Shipment No : ",
				ShipmentNo + randomnumbers());
	}

	public void enterShipNo(String ShipmentNo) {
		Wait.waitfor(2);
		clearText(driver, test, OCR_CreateNewEEITransactionsPage_ShipmentNo, "Clear text : ");
		typeText(driver, test, OCR_CreateNewEEITransactionsPage_ShipmentNo, "Enter Shipment No : ",
				ShipmentNo + randomnumbersbetween1_100());
	}

	// Enter Country of ult Destination
	public void enterCountryDest(String UltDestination) {
		Wait.waitfor(2);
		typeText(driver, test, OCR_CreateNewEEITransactionsPage_CountryOfUltDest,
				"Enter Country Of Ultimate Destination : ", UltDestination);
	}

	// Enter parties to the transaction
	public void PartiesToTheTransaction(String ExporterCode, String ConsigneeId, String FFCode) {

		scrollToElement(driver, "//legend[contains(text(),'Parties to the Transaction')]");
		Wait.waitfor(3);
		if (ExporterCode.length() > 0) {
			clickElement(driver, test, OCR_CreateNewEEITransactionsPage_Exporter, "click on Exporter link");
			try {
				clickElement(driver, test, OCR_CreateNewEEITransactionsPage_Exporter_Code,
						"click on exporter code Link");
				Wait.wait(driver, "//label[contains(text(),'Loading Content')]");
				Wait.waitfor(5);
				typeText(driver, test, OCR_CreateNewEEITransactionsPage_Exporter_ExpCode, "Enter Exporter Code : ",
						ExporterCode);
				clickElement(driver, test, OCR_CreateNewEEITransactionsPage_Exporter_ExpSearch, "Click On Search");
				String ExpCode = "//td[contains(text(),'" + ExporterCode.trim() + "')]";
				clickElement(driver, test, ExpCode, "Select Exporter Code : " + ExporterCode);
				clickElement(driver, test, OCR_CreateNewEEITransactionsPage_Exporter_ExpSelect, "Click on Select");
				Wait.waitfor(2);
				clickElement(driver, test, OCR_CreateNewEEITransactionsPage_Exporter_Save, "Click on Save");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CreateNewEEITransactionsPage_Exporter_PopupClose,
						"Click on Cancel popup icon");
			}
		}
		if (ConsigneeId.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_CreateNewEEITransactionsPage_UltConsignee, "Click on Ult Consignee Link");
			try {
				clickElement(driver, test, OCR_CreateNewEEITransactionsPage_UltConsignee_Code,
						"Click on Ult Consignee Code Link");
				Wait.wait(driver, "//label[contains(text(),'Loading Content')]");
				Wait.waitfor(3);
				typeText(driver, test, OCR_CreateNewEEITransactionsPage_UltConsignee_ID, "Enter Consignee Id : ",
						ConsigneeId);
				clickElement(driver, test, OCR_CreateNewEEITransactionsPage_UltConsignee_Search,
						"Click On Search Button");
				String ConsCode = "//td[contains(text(),'" + ConsigneeId.trim() + "')]";
				clickElement(driver, test, ConsCode, "Select Consignee Code : " + ConsigneeId);
				clickElement(driver, test, OCR_CreateNewEEITransactionsPage_UltConsignee_Select,
						"Click on Select Button");
				Wait.waitfor(3);
				clickElement(driver, test, OCR_CreateNewEEITransactionsPage_UltConsignee_Save, "Click on Save Button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CreateNewEEITransactionsPage_UltConsignee_PopupClose,
						"Click on cancel popup icon");
			}
		}
		if (FFCode.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_CCreateNewEEITransactionsPage_FreightForwarder,
					"Click on Freight Forwarder Link");
			try {
				Wait.waitfor(3);
				clickElement(driver, test, OCR_CreateNewEEITransactionsPage_FF_Code,
						"Click on Freight forwarder code Link");
				Wait.wait(driver, "//label[contains(text(),'Loading Content')]");
				Wait.waitfor(3);
				typeText(driver, test, OCR_CreateNewEEITransactionsPage_FF_FFCode, "Enter FF Code : ", FFCode);
				clickElement(driver, test, OCR_CreateNewEEITransactionsPage_FF_Search, "Click On Search Button");
				String FFCodeSel = "//td[contains(text(),'" + FFCode.trim() + "')]";
				clickElement(driver, test, FFCodeSel, "Select FF Code : " + FFCode);
				clickElement(driver, test, OCR_CreateNewEEITransactionsPage_FF_Select, "Click on Select Button");
				Wait.waitfor(3);
				clickElement(driver, test, OCR_CreateNewEEITransactionsPage_FF_Save, "Click on save Button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CreateNewEEITransactionsPage_FF_PopupClose,
						"Click on Cancel popup icon");
			}
		}

	}

	// Get the Shipment No
	public String getEEIShipmentNo() {
		Wait.waitfor(2);
		return getAttribute(driver, test, "(//span[@class='additional-value'])[1]", "innerText",
				"Get the EEI template number :");

	}

	// Validating Mandatory Checks
	public void validateMandatoryChecks() {
		Wait.waitfor(2);
		String errorMsg = getText(driver, test, "//h4[contains(text(),'Error!')]", "Error message is displayed");

		try {
			if (errorMsg.equalsIgnoreCase("Error!")) {
				test.log(LogStatus.PASS, "Error message displays to enter mandatory fields before saving a record.");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error message is not displayed.");
		}
	}

	// Enter transportation details
	public void transportationDetails(String MOT, String ExpCarrier, String StateOfOrigin, String PortOfExport,
			String FTZ, String UnladingPort, String InbondType, String ImpEntryNum) {
		Wait.waitfor(2);
		scrollToElement(driver, "//input[@id='editSed_shipment_modeOfTransport']");
		typeText(driver, test, "//input[@id='editSed_shipment_modeOfTransport']", "Enter Mode of Transport : ", MOT);
		typeText(driver, test, "//input[@id='editSed_exportingCarrier']", "Enter Exporting Carrier/ID Code : ",
				ExpCarrier);
		typeText(driver, test, "//input[@id='editSed_shipment_stateOfOrigin']", "Enter State of Origin : ",
				StateOfOrigin);
		try {
			if (PortOfExport.length() > 0) {
				Wait.waitfor(2);
				clickElement(driver, test, "//a[contains(text(),'Port of Export')]", "Click on Port OF Export Link :");
				typeText(driver, test, "//input[@id='searchForm_ports_portId']", "Enter Port Of Export : ",
						PortOfExport);
				clickElement(driver, test, "//button[@name='Search']", "Click on Search button :");
				clickElement(driver, test, "//td[contains(text(),'" + PortOfExport + "')]", PortOfExport);
				clickElement(driver, test, "(//button[@name='Ok'])[1]", "Click on Select button :");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, "//button[@class='btn-close']", "Click on Cancel popup icon");
		}
		typeText(driver, test, "//input[@id='editSed_shipment_ftzNo']", "Enter FTZ : ", FTZ);
		typeText(driver, test, "//input[@id='editSed_shipment_portOfUnloading']", "Enter Port Of unlading : ",
				UnladingPort);
		typeText(driver, test, "//input[@id='editSed_shipment_entryNo']", "Enter Import Entry Number : ", ImpEntryNum);
		typeText(driver, test, "//input[@id='editSed_shipment_inbondType']", "Enter Inbond Type : ", InbondType);
	}

	// click on Save button
	public void Savebutton() {
		scrollToElement(driver, OCR_CreateNewEEITransactionsPage_SaveBtn);
		clickElement(driver, test, OCR_CreateNewEEITransactionsPage_SaveBtn, "Clicking on Save Button :");
	}

	// enter USPPI details:
	public void enterUSPPI(String USPPI, String USPPIEIN) {
		Wait.waitfor(2);
		typeText(driver, test, "//input[@id='editSed_shipment_usppiNumber']", "Enter USPPI ID : ",
				USPPI + randomnumbers());
		selectByVisibleText(driver, test, "//select[@id='editSed_shipment_filerIdType']", "Enter USPPI EIN : ",
				USPPIEIN);

	}

	// enter FILER details:
	public void enterFiler(String FILER, String FILEREIN) {
		Wait.waitfor(2);
		typeText(driver, test, "//input[@id='editSed_shipment_filerId']", "Enter FILER ID : ", FILER + randomnumbers());
		selectByVisibleText(driver, test, "//select[@id='editSed_shipment_idType']", "Enter FILER EIN : ", FILEREIN);

	}

	// enter Forwarder ID details:
	public void enterForwarderID(String ForwarderID, String ForwarderEIN) {
		Wait.waitfor(2);
		typeText(driver, test, "//input[@id='editSed_shipment_ffFilerId']", "Enter Forwarder ID : ",
				ForwarderID + randomnumbers());
		selectByVisibleText(driver, test, "//select[@id='editSed_shipment_ffIdType']", "Enter Forwarder EIN : ",
				ForwarderEIN);

	}

	// Enter contact info of Exporter:
	public void contactExporter(String Fname, String Lname, String Phone, String Mobile, String EmailId) {
		Wait.waitfor(2);
		scrollToElement(driver, OCR_CreateNewEEITransactionsPage_Exporter);
		clickElement(driver, test, OCR_CreateNewEEITransactionsPage_Exporter, "Click on Exporter Link :");
		typeText(driver, test, "(//input[@name='shipment.exporterContactName'])[2]", "Enter  first name : ", Fname);
		typeText(driver, test, "(//input[@name='shipment.intConsContactAddr2'])[2]", "Enter Last name : ", Lname);
		typeText(driver, test, "(//input[@name='shipment.exporterContactPhone'])[2]", "Enter phone : ", Phone);
		typeText(driver, test, "(//input[@name='shipment.exporterContactMobile'])[2]", "Enter mobile : ", Mobile);
		typeText(driver, test, "(//input[@name='shipment.exporterEmail'])[2]", "Enter Email : ", EmailId);
		clickElement(driver, test, "//button[@id='entitySave']", "Click on Save :");
	}

	// Enter contact info of Ult Consignee:
	public void contactUltCons(String ConsType, String City, String State, String ConsFname, String ConsPhone,
			String ConsMobile, String ConsEmailId) {
		Wait.waitfor(2);
		scrollToElement(driver, OCR_CreateNewEEITransactionsPage_UltConsignee);
		clickElement(driver, test, OCR_CreateNewEEITransactionsPage_UltConsignee, "Click on Ultimate COnsignee Link :");
		selectByVisibleText(driver, test, "//select[@name='shipment.ultConsType']", "Select type : ", ConsType);
		typeText(driver, test, "(//input[@name='shipment.ultConsCity'])[2]", "Enter City : ", City);
		typeText(driver, test, "(//input[@id='entityStateNameSed'])", "Enter State : ", State);
		typeText(driver, test, "(//input[@name='shipment.ultConsContactName'])[2]", "Enter  first name : ", ConsFname);
		typeText(driver, test, "(//input[@name='shipment.ultConsContactPhone'])[2]", "Enter phone : ", ConsPhone);
		typeText(driver, test, "(//input[@name='shipment.ultConsContactMobile'])[2]", "Enter mobile : ", ConsMobile);
		typeText(driver, test, "(//input[@name='shipment.ultConsContactEmail'])[2]", "Enter Email : ", ConsEmailId);
		clickElement(driver, test, "//button[@id='entitySave']", "Click on Save :");
	}

	// Enter contact info of FF:
	public void contactFF(String FFname, String FFPhone, String FFMobile, String FFEmailId) {
		Wait.waitfor(2);
		scrollToElement(driver, OCR_CCreateNewEEITransactionsPage_FreightForwarder);
		clickElement(driver, test, OCR_CCreateNewEEITransactionsPage_FreightForwarder, "Click on FF Link :");

		typeText(driver, test, "(//input[@name='shipment.ffContactName'])[2]", "Enter  first name : ", FFname);
		typeText(driver, test, "(//input[@name='shipment.ffContactPhone'])[2]", "Enter phone : ", FFPhone);
		typeText(driver, test, "(//input[@name='shipment.ffContactMobile'])[2]", "Enter mobile : ", FFMobile);
		typeText(driver, test, "(//input[@name='shipment.ffContactEmail'])[2]", "Enter Email : ", FFEmailId);
		clickElement(driver, test, "//button[@id='entitySave']", "Click on Save :");
	}

	// Enter transportation reference number
	public void transportRefNum(String TransRefNum) {
		Wait.waitfor(2);
		typeText(driver, test, "(//input[@id='editSed_shipment_transportRefNo'])",
				"Enter Transport Reference Number : ", TransRefNum + randomnumbersbetween1_1000());
	}

	// click on validation status icon
	public void click_validationStatus() {
		Wait.waitfor(2);
		scrollToElement(driver, "//i[@class='fa fa-exclamation-circle']");
		clickElement(driver, test, "//i[@class='fa fa-exclamation-circle']", "Click on Validation Status icon :");
		try {
			String validationMsg = getText(driver, test, "//th[contains(text(),'Error')]",
					"Fetch the text of the Validation status :");
			if (!validationMsg.equalsIgnoreCase("Error")) {
				test.log(LogStatus.PASS, "No validation error message displays : Test passed ");

			} else {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Validation error message displays : Test failed ");
			}
		} catch (Exception e) {

			Wait.waitfor(2);
			clickElement(driver, test, "(//button[@class='btn-close'])[1]", "Close the pop up :");
		}
	}
	// Get the EEI NO
	public String getEEINo() {
		return getText(driver, test, "(//span[@class='additional-value'])[1]", "Get the EEI/Shipment No : ");
	}
	// verify End user type is displayed for Ultimate consignee
	public void UltCons_EndUserType() {
		Wait.waitfor(2);
		scrollToElement(driver, OCR_CreateNewEEITransactionsPage_UltConsignee);
		clickElement(driver, test, OCR_CreateNewEEITransactionsPage_UltConsignee, "click on Ultimate Consignee link");
		String EndUserType = getText(driver, test, "//label[contains(text(),'End User Type')]",
				"Fetch the End User Type label : ");
		try {
			if (EndUserType.equalsIgnoreCase("End User Type")) {
				test.log(LogStatus.PASS, "End User Type is displayed for Ulitmate Consignee :");
			}
		} catch (Exception e) {
			Wait.waitfor(2);
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "End User Type is not displayed for Ulitmate Consignee :");
		}
	}

	// validate heading
	public void validateHeading() {
		Wait.waitfor(2);

		try {
			if (isDisplayed(driver, "//div[@class='page-heading']")) {
				test.log(LogStatus.PASS, "Title is Displayed : Edit Electronic Export Information Transactions");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Title is not Displayed : Edit Electronic Export Information Transactions");
		}

	}

	// move to additional transaction details tab and click on Shipment details
	public void select_ShipmentDetails() {
		Wait.waitfor(2);
		clickElement(driver, test, "//i[@class='fa fa-th']", "Click on Additional Transaction Details :");
		Wait.waitfor(2);
		clickElement(driver, test, "//a[contains(text(),'Shipment Details')]", "Select Shipment Details :");
	}

	// On EEI transaction page, Clicking on Change Status button to select Submitted
	// for Shipping Review for Regression US
	public void changeStatusToShipReview(String ShippingReviewStat) {
		clickElement(driver, test, "//div[@id='changestatus-div']", "Click on Change Status");
		Wait.waitfor(2);
		clickElement(driver, test, "//a[contains(text(),'" + ShippingReviewStat + "')]",
				"Select Submitted For Shipping Review : " + ShippingReviewStat);
	}

	// On EEI transaction page, Clicking on Change Status button to select Shipment
	// Approved for Regression US
	public void changeStatusToShipmentApproved(String ShipmentApproved) {
		clickElement(driver, test, "//div[@id='changestatus-div']", "Click on Change Status");
		Wait.waitfor(2);
		clickElement(driver, test, "//a[contains(text(),'" + ShipmentApproved + "')]",
				"Select Shipment Approved : " + ShipmentApproved);
	}

	// On EEI transaction page, Clicking on Change Status button to select Export
	// Approved for Regression US
	public void changeStatusToExportApproved(String ExportApproved) {
		clickElement(driver, test, "//div[@id='changestatus-div']", "Click on Change Status");
		Wait.waitfor(2);
		clickElement(driver, test, "//a[contains(text(),'" + ExportApproved + "')]",
				"Select Export Approved : " + ExportApproved);
	}

	// On EEI transaction page, Clicking on Change Status button to select Sent To
	// Freight Forwarder for Regression US
	public void changeStatusToFreightForwarder(String FrieghtForwarder) {
		clickElement(driver, test, "//div[@id='changestatus-div']", "Click on Change Status");
		Wait.waitfor(2);
		clickElement(driver, test, "//a[contains(text(),'" + FrieghtForwarder + "')]",
				"Select Sent to Freight Forwarder : " + FrieghtForwarder);
	}

	// On EEI transaction page, Clicking on Change Status button to select Booked
	// for Regression US
	public void changeStatusToBooked(String Booked) {
		clickElement(driver, test, "//div[@id='changestatus-div']", "Click on Change Status");
		Wait.waitfor(2);
		clickElement(driver, test, "//a[contains(text(),'" + Booked + "')]", "Select Booked : " + Booked);

	}

	// On EEI transaction page, Clicking on Change Status button to select Shipped
	// for Regression US
	public void changeStatusToShipped(String Shipped) {
		clickElement(driver, test, "//div[@id='changestatus-div']", "Click on Change Status");
		Wait.waitfor(2);
		clickElement(driver, test, "//a[contains(text(),'" + Shipped + "')]", "Select Shipped : " + Shipped);
	}

	// changing the AES status to Cancelled
	public void changeAES(String Cancelled) {
		Wait.waitfor(2);
		selectByVisibleText(driver, test, "//select[@id='editSed_shipment_shipmentCustomFilingStatus']",
				"Select status as Cancelled", Cancelled);
	}

	// verify the AES Status changes to Cancelled
	public void AES_Cancel() {
		Wait.waitfor(2);
		String AESCancel = getText(driver, test, "//select[@id='editSed_shipment_shipmentCustomFilingStatus']",
				"Fetching the status of AES : ");
		try {
			if (AESCancel.equalsIgnoreCase("Cancelled")) {
				test.log(LogStatus.PASS, "AES Status is set to Cancelled : Test Passed ");
			}

		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "AES Status is not set to Cancelled : Test Failed ");
		}
	}
	
	//verify AES Direct Submit link is displayed
	public void validate_AESSubmitLink() {
		Wait.waitfor(2);
		
		try {
			if(isDisplayed(driver, "//a[@class='eei aceUploadPopUp']")) {
				test.log(LogStatus.PASS, "AES Direct Submit link is available :");
			}
			
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "AES Direct Submit link is not available :");
		}
	}
	
	//verify AES Weblink Enquiry link is displayed
		public void validate_AESWeblink() {
			Wait.waitfor(2);
			clickElement(driver, test, "(//button[@class='btn-close'])[1]", "Close the pop up :");
			try {
				if(isDisplayed(driver, "//a[@class='eei aceDownloadPopUp']")) {
					test.log(LogStatus.PASS, "AES Weblink Enquiry link is available :");
				}
				
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "AES Weblink Enquiry link is not available :");
			}
		}
		
		//click on AES Submit link
		public void click_AESSubmitLink() {
			Wait.waitfor(2);
			clickElement(driver, test, "//a[@class='eei aceUploadPopUp']", "Click on AES Direct Submit Link icon :");
		}
		
		//verify Submit to AES Direct button is displayed
		public void AESButtonDisplayed() {
			Wait.waitfor(2);
			try {
				if(isDisplayed(driver, "(//button[contains(text(),'Submit to AES Direct')])[1]")) {
					test.log(LogStatus.PASS, "Submit to AES Direct button is displayed on AES Direct Submission Pop-up :");
				}
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Submit to AES Direct button is not displayed on AES Direct Submission Pop-up :");
			}
		}
		
		//close the AES Direct Submission pop up
		public void AESClose() {
			Wait.waitfor(2);
			clickElement(driver, test, "(//button[@class='btn-close'])[1]", "Close the AES Direct Submission pop up :");
		}
		
		// changing the AES status to Rejected
		public void AESRejected(String rejected) {
			Wait.waitfor(2);
			selectByVisibleText(driver, test, "//select[@id='editSed_shipment_shipmentCustomFilingStatus']",
					"Select status as Rejected", rejected);
		}
	
}
