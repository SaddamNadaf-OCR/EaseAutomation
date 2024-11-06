package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewPackingListPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_CreateNewPackingListPage_PackingListNo = "//input[@id='editPackinglist_packinglist_packinglistNo']";
	public static final String OCR_CreateNewPackingListPage_ExporterCodeLink = "//a[contains(text(),'Exporter Cod')]";
	public static final String OCR_CreateNewPackingListPage_ExporterStatusSelect = "//select[@id='searchForm_exporter_status']";
	public static final String OCR_CreateNewPackingListPage_ExporterCountry = "//input[@id='searchForm_exporter_expCountryName']";
	public static final String OCR_CreateNewPackingListPage_ExporterSearchBtn = "//button[@name='Search']";
	public static final String OCR_CreateNewPackingListPage_ExporterSelectBtn = "(//button[@name='Ok'])[1]";
	public static final String OCR_CreateNewPackingListPage_ExporterPopUpCloseBtn = "(//button[@class='btn-close'])[1]";
	public static final String OCR_CreateNewPackingListPage_ShipmentNoLink = "//a[contains(text(),'Shipment No')]";
	public static final String OCR_CreateNewPackingListPage_ShipmentNoSelectBtn = "//button[contains(text(),'Select')]";
	public static final String OCR_CreateNewPackingListPage_ShipmentNoPopUpCloseBtn = "(//button[@class='btn-close'])[1]";
	public static final String OCR_CreateNewPackingListPage_UltConsigneeCodeLink = "//input[@id='editPackinglist_packinglist_ultimateConsigneeCode']/../..//a";
	public static final String OCR_CreateNewPackingListPage_ConsigneeID = "//input[@id='searchForm_consignee_consigneeId']";
	public static final String OCR_CreateNewPackingListPage_ConsigneeSearchBtn = "//button[@name='Search']";
	public static final String OCR_CreateNewPackingListPage_ConsigneeSelectBtn = "(//button[@name='Ok'])[1]";
	public static final String OCR_CreateNewPackingListPage_ConsigneePopUpCloseBtn = "(//button[@class='btn-close'])[1]";
	public static final String OCR_CreateNewPackingListPage_AirCarrierLink = "//input[@id='editPackinglist_packinglist_airCarrierCode']/../..//a";
	public static final String OCR_CreateNewPackingListPage_AirCarrierSearchBtn = "//button[@name='Search']";
	public static final String OCR_CreateNewPackingListPage_AirCarrierSelectBtn = "(//button[@name='Ok'])[1]";
	public static final String OCR_CreateNewPackingListPage_AirCarrierPopUpCloseBtn = "(//button[@class='btn-close'])[1]";
	public static final String OCR_CreateNewPackingListPage_Status = "//select[@id='editPackinglist_packinglist_status']";
	public static final String OCR_CreateNewPackingListPage_SaveBtn = "(//button[@class='primary-btn packinglist-btn ocr-cache-search-dynamic-class'])[1]";
	public static final String OCR_CreateNewPackingListPage_SaveAndReturnBtn = "//button[@id='saveAndReturnBtn']";
	public static final String OCR_CreateNewPackingListPage_DateOfExport = "//input[@id='editPackinglist_dateOfExport']";
	public static final String OCR_CreateNewPackingListPage_DateOfExportToday = "//button[contains(text(),'Today')]";
	public static final String OCR_CreateNewPackingListPage_DateOfDelivery = "//input[@id='editPackinglist_dateOfArrival']";
	public static final String OCR_CreateNewPackingListPage_SpecialInstructions = "//textarea[@id='editPackinglist_packinglist_specialInstructions']";
	public static final String OCR_CreateNewPackingListPage_movetoItems = "//i[@class='fa fa-angle-right']";
	public static final String OCR_CreateNewPackingListPage_ViewPagination = "(//span[@class='ui-paging-info'])[1]";
	public static final String OCR_CreateNewPackingListPage_EntityScreeningStatusIcon = "//i[@class='fa fa-user']";
	public static final String OCR_CreateNewPackingListPage_EntityScreeningStatusHeading = "//h4[contains(text(),'Entity Screening Status')]";
	public static final String OCR_CreateNewPackingListPage_GenerateDocIcon = "//i[@class='fa fa-file-pdf-o']";
	public static final String OCR_CreateNewPackingListPage_AdditionalTransaction = "//i[@class='fa fa-th']";
	public static final String OCR_CreateNewPackingListPage_EExporterCode = "//input[@name='exporter.expCode']";
	
	
	

	/* ******************************* Constructor ****************************** */

	public CreateNewPackingListPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// create a new packing list with packing List No ,exporter code and shipment no
	public void createNewpackingList_GeneralInfo(String PackListNo, String exporterCode, String ExporterStatus,
			String ExporterCountry, String shipmentNo) {

		typeText(driver, test, OCR_CreateNewPackingListPage_PackingListNo, "Enter packing List Number : ", PackListNo);
		typeText(driver, test, OCR_CreateNewPackingListPage_PackingListNo,
				"Append Packing list Number with a randomly generated number : ", randomnumbers());

		try {
			if (exporterCode.length() > 0) {
				clickElement(driver, test, OCR_CreateNewPackingListPage_ExporterCodeLink,
						"Click on Exporter Code Link");
				selectByVisibleText(driver, test, OCR_CreateNewPackingListPage_ExporterStatusSelect, "Select status : ",
						ExporterStatus);
				typeText(driver, test, OCR_CreateNewPackingListPage_ExporterCountry, "Enter Exporter Country : ",
						ExporterCountry);
				clickElement(driver, test, OCR_CreateNewPackingListPage_ExporterSearchBtn, "Click on Search Button");
				clickElement(driver, test, "//td[contains(text(),'" + exporterCode + "')]",
						"Select Exporter : " + exporterCode);
				clickElement(driver, test, OCR_CreateNewPackingListPage_ExporterSelectBtn, "Click on Select Button");

			}
		} catch (Exception e) {
			testFailSshot(driver, test);

		}

		try {
			if (shipmentNo.length() > 0) {
				clickElement(driver, test, OCR_CreateNewPackingListPage_ShipmentNoLink, "Click on Shipment No link :");
				clickElement(driver, test, "(//td[@aria-describedby='gridPopup_shipmentNo'])[1]",
						"Select Shipment Number : " + shipmentNo);
				clickElement(driver, test, OCR_CreateNewPackingListPage_ShipmentNoSelectBtn, "Click on Select Button :");

			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_CreateNewPackingListPage_ShipmentNoPopUpCloseBtn,
					"Click on Close popup icon");
		}

	}

	// Adding more parameters in header information for Regression US
	public void createNewpackingList_GeneralInfo(String PackListNo, String exporterCode, String ExporterStatus,
			String shipmentNo, String dateOfExport, String OrderNo, String dateOfDelivery,
			String packingListTitle, String NoOfPackage, String BillOfLading, String grossWeight, String HouseAWBNo) {

		typeText(driver, test, OCR_CreateNewPackingListPage_PackingListNo, "Enter packing List Number : ", PackListNo);
		typeText(driver, test, OCR_CreateNewPackingListPage_PackingListNo,
				"Append Packing list Number with a randomly generated number : ", randomnumbers());

		try {
			if (exporterCode.length() > 0) {
				clickElement(driver, test, OCR_CreateNewPackingListPage_ExporterCodeLink,
						"Click on Exporter Code Link");
				selectByVisibleText(driver, test, OCR_CreateNewPackingListPage_ExporterStatusSelect, "Select status : ",
						ExporterStatus);
				typeText(driver, test, OCR_CreateNewPackingListPage_EExporterCode, "Enter Exporter Code : ",
						exporterCode);
				clickElement(driver, test, OCR_CreateNewPackingListPage_ExporterSearchBtn, "Click on Search Button");
				clickElement(driver, test, "//td[contains(text(),'" + exporterCode + "')]",
						"Select Exporter : " + exporterCode);
				clickElement(driver, test, OCR_CreateNewPackingListPage_ExporterSelectBtn, "Click on Select Button");

			}
		} catch (Exception e) {
			testFailSshot(driver, test);

		}

		try {
			if (shipmentNo.length() > 0) {
				clickElement(driver, test, OCR_CreateNewPackingListPage_ShipmentNoLink, "Click on Shipment No link");
				clickElement(driver, test, "//td[contains(text(),'" + shipmentNo + "')]",
						"Select Shipment Number : " + shipmentNo);
				clickElement(driver, test, OCR_CreateNewPackingListPage_ShipmentNoSelectBtn, "Click on Select Button");

			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_CreateNewPackingListPage_ShipmentNoPopUpCloseBtn,
					"Click on Close popup icon");
		}

		if (dateOfExport.length() > 0) {
				clickElement(driver, test, OCR_CreateNewPackingListPage_DateOfExport,
						"Clicking on Date of export :");
				try {
					if (dateOfExport.equalsIgnoreCase("Today")) {
						clickElement(driver, test, OCR_CreateNewPackingListPage_DateOfExportToday, "Clicking on Today :");
					} else {
						date(driver, test, "Selecting the Date of Export :", dateOfExport);
					}
				} catch (Exception e) {
					testFailSshot(driver, test);
					test.log(LogStatus.FAIL, "Unable to Select the Date :");
				}
			}

		if (OrderNo.length() > 0) {
			Wait.waitfor(2);
			typeText(driver, test, "//input[@id='editPackinglist_packinglist_orderNo']", "Enter Order Number : ",
					OrderNo);
		}
		if (dateOfDelivery.length() > 0) {
			
			clickElement(driver, test, OCR_CreateNewPackingListPage_DateOfDelivery,
					"Clicking on Date of Delivery :");
			try {
				if (dateOfDelivery.equalsIgnoreCase("Today")) {
					clickElement(driver, test, OCR_CreateNewPackingListPage_DateOfExportToday, "Clicking on Today :");
				} else {
					date(driver, test, "Selecting the Date of Delivery :", dateOfDelivery);
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Unable to Select the Date :");
			}
		}

		
		if (packingListTitle.length() > 0) {
			Wait.waitfor(2);
			typeText(driver, test, "//input[@id='editPackinglist_packinglist_plistTitle']",
					"Enter packing list title : ", packingListTitle);
		}
		if (NoOfPackage.length() > 0) {
			Wait.waitfor(2);
			typeText(driver, test, "//input[@id='editPackinglist_packinglist_noOfPackages']",
					"Enter Number of packages : ", NoOfPackage);
		}
		if (BillOfLading.length() > 0) {
			Wait.waitfor(2);
			typeText(driver, test, "//input[@id='editPackinglist_packinglist_billOfLading']",
					"Enter Bill Of Lading/AWB Number : ", BillOfLading);
		}
		if (grossWeight.length() > 0) {
			Wait.waitfor(2);
			typeText(driver, test, "//input[@id='editPackinglist_packinglist_grossWeight']", "Enter Gross Weight : ",
					grossWeight);

		}
		if (HouseAWBNo.length() > 0) {
			Wait.waitfor(2);
			typeText(driver, test, "//input[@id='editPackinglist_packinglist_hawbNo']", "Enter House AWB Number : ",
					HouseAWBNo);
		}

	}

	public void ultimateConsignee(String UltConsigneeCode) {
		try {
			if (UltConsigneeCode.length() > 0) {
				clickElement(driver, test, OCR_CreateNewPackingListPage_UltConsigneeCodeLink,
						"Click on Ultimate Consignee Code Link");
				typeText(driver, test, OCR_CreateNewPackingListPage_ConsigneeID, "Enter Consignee ID : ",
						UltConsigneeCode);
				clickElement(driver, test, OCR_CreateNewPackingListPage_ConsigneeSearchBtn, "Click on Search Button");
				clickElement(driver, test, "//td[contains(text(),'" + UltConsigneeCode + "')]",
						"Select Consignee Code : " + UltConsigneeCode);
				clickElement(driver, test, OCR_CreateNewPackingListPage_ConsigneeSelectBtn, "Click on Select button");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_CreateNewPackingListPage_ConsigneePopUpCloseBtn,
					"Click on Close popup icon");
		}

	}

	public void airCarrier(String AirCarrierCode) {
		try {
			if (AirCarrierCode.length() > 0) {
				clickElement(driver, test, OCR_CreateNewPackingListPage_AirCarrierLink,
						"Click on Air Carrier Code Link");
				clickElement(driver, test, OCR_CreateNewPackingListPage_AirCarrierSearchBtn, "Click on Search Button");
				clickElement(driver, test, "//td[contains(text(),'" + AirCarrierCode + "')]",
						"Select Carrier Code : " + AirCarrierCode);
				clickElement(driver, test, OCR_CreateNewPackingListPage_AirCarrierSelectBtn, "Click on Select Button");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_CreateNewPackingListPage_AirCarrierPopUpCloseBtn,
					"Click on Close popup icon");

		}
	}
	
	public void specialInstructions(String specialInstruction) {
		Wait.waitfor(2);
		scrollToElement(driver, OCR_CreateNewPackingListPage_SpecialInstructions);
		typeText(driver, test, OCR_CreateNewPackingListPage_SpecialInstructions, "Enter Special instructions : ", specialInstruction);
		
	}
	
	public void terms(String terms) {
		Wait.waitfor(2);
		typeText(driver, test, "//textarea[@id='editPackinglist_packinglist_terms']", "Enter Terms : ", terms);
	}
	
	public void header(String Header) {
		Wait.waitfor(2);
		typeText(driver, test, "//textarea[@id='editPackinglist_packinglist_header']", "Enter Header : ", Header);
	}
	
	public void footer(String Footer) {
		Wait.waitfor(2);
		typeText(driver, test, "//textarea[@id='editPackinglist_packinglist_footer']", "Enter Footer : ", Footer);
	}

	public void save() {
		Wait.waitfor(3);
		scrollToElement(driver, OCR_CreateNewPackingListPage_SaveBtn);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_CreateNewPackingListPage_SaveBtn, "Click on Save button");
		Wait.waitfor(3);
		clickElement(driver, test, "//input[@id='editPackinglist_packinglist_shipmentNo']", "");
	}

	// get the packing list no

	public String get_PackingListNo() {
		scrollToTop(driver);
		return getAttribute(driver, test, OCR_CreateNewPackingListPage_PackingListNo, "value",
				"Get the Packing List Number : ");
	}

	public void saveAndReturn() {
		clickElement(driver, test, OCR_CreateNewPackingListPage_Status, "");
		clickElement(driver, test, OCR_CreateNewPackingListPage_SaveAndReturnBtn, "Click on Save And Return Button");
		Wait.waitfor(3);
	}
	
	public void moveToItems() {
		Wait.waitfor(3);
//		scrollToElement(driver,"//input[@id='editPackinglist_packinglist_orderNo']" );
//		clickElement(driver, test, OCR_CreateNewPackingListPage_movetoItems, "CLick on Next arrow mark to move to Items : ");

		scrollToElement(driver, OCR_CreateNewPackingListPage_AdditionalTransaction);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_CreateNewPackingListPage_AdditionalTransaction, "Click on Additonal Transaction Details tab : ");
		clickElement(driver, test, "(//a[contains(text(),'Items')])[2]", "Select Items : ");
		Wait.waitfor(2);
		clickElement(driver, test, "//button[@id='addPackinglistItem']", "Click on Add item :");
		
	}
	
	public void pagination() {
		Wait.waitfor(2);
		try {
		if(isDisplayed(driver, OCR_CreateNewPackingListPage_ViewPagination)) {
			test.log(LogStatus.PASS, "Item is successfully added in the grid : ");
			
		}
	}catch(Exception e) {
		testFailSshot(driver, test);
		test.log(LogStatus.FAIL, "Item is not successfully added in the grid : ");
	}
	}
	
	public void entityScreeningIcon() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CreateNewPackingListPage_EntityScreeningStatusIcon, "Click on Entity Screening Status icon : ");
		try {
			if(isDisplayed(driver, OCR_CreateNewPackingListPage_EntityScreeningStatusHeading)) {
				test.log(LogStatus.PASS, "Entity Screening Status Pop-up is opened successfully : ");
			}
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Entity Screening Status Pop-up is not opened successfully : ");
		}
		Wait.waitfor(2);
		clickElement(driver, test, "(//button[@class='btn-close'])[1]", "Close the Entity Screening Status Pop-Up : ");
	}
	
	public void generateDocIcon() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CreateNewPackingListPage_GenerateDocIcon, "CLick on Generate Documents icon : ");
		Wait.waitfor(2);
	}
	
	public void sendEmailWithLink(String emailID) {
		Wait.waitfor(2);
		clickElement(driver, test,
				"//div[@class='selectize-control doc-email form-control multi plugin-remove_button']",
				"Click on Email To text box :");
		Wait.waitfor(2);
		typeText(driver, test, "//input[@autocomplete='new-password']", "Enter the email id : ", emailID);
		scrollToElement(driver, "//button[@id='docEmailAsLink']");
		clickElement(driver, test, "//button[@id='docEmailAsLink']", "Click on Send Email With Link : ");

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
		clickElement(driver, test, "(//button[@class='btn-close'])[1]", "Click on Pop up Close button");
	}
	
	public void saveBtn() {
		Wait.waitfor(2);
		clickElement(driver, test, "(//button[contains(text(),'Save')])[1]", "Click on Save button : ");
	}

}
