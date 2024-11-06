package globalExportClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class EditShipmentBookingDeatilsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_BD_HI_BookingNo = "//input[@id='shipment_bookingNo']";
	public static final String OCR_BD_HI_BillOfLadingNo = "//input[@id='shipment_billOfLading']";
	public static final String OCR_BD_HI_AirwayBillNumberLink = "//a[@id='shipmentAwbLink']";
	public static final String OCR_BD_HI_HouseAirwayBillNumber = "//a[@id='shipmentHawbLink']";
	public static final String OCR_BD_HI_MasterAWBNumber = "//input[@id='shipment_mawbNo']";
	public static final String OCR_BD_HI_TrackingNo = "//input[@id='shipment_trackingNo']";
	public static final String OCR_BD_HI_TransportRefNo = "//input[@id='shipment_transportRefNo']";
	public static final String OCR_BD_HI_DateofArrival = "//input[@id='dateOfArrivalBookingPage']";
	public static final String OCR_BD_SPI_Prepaid = "//select[@id='shipment_prepaid']";
	public static final String OCR_BD_SPI_ConsolidateShip = "//select[@id='shipment_consolidateShipment']";
	public static final String OCR_BD_SPI_CodeAmount = "//input[@id='shipment_codAmount']";
	public static final String OCR_BD_SPI_Collect = "//select[@id='shipment_collect']";
	public static final String OCR_BD_SPI_ContainsPersonalInfo = "//select[@id='shipment_containsPersonalInfo']";
	public static final String OCR_BD_SPI_CarnetNo = "//input[@id='shipment_carnetNo']";
	public static final String OCR_BD_SPI_IssueDate = "//input[@id='carnetIssueDate']";
	public static final String OCR_BD_SPI_ExpiryDate = "//input[@id='carnetExpiryDate']";
	public static final String OCR_BD_SPI_InsuranceAmount = "//input[@id='shipment_insuranceAmount']";
	public static final String OCR_BD_SPI_InsuranceRequired = "//select[@id='shipment_insuranceRequired']";
	public static final String OCR_BD_SPI_Insured = "//select[@id='shipment_insurance']";
	public static final String OCR_BD_SPI_Containerized = "//select[@id='shipment_containerized']";
	public static final String OCR_BD_TI_CountryOfOrigin = "//input[@id='shipment_countryOfOrigin']";
	public static final String OCR_BD_TI_PortofExportLink = "//a[contains(text(),'Port of Export')]";
	public static final String OCR_BD_TI_PortID = "//input[@id='searchForm_ports_portId']";
	public static final String OCR_BD_Search = "//button[@name='Search']";
	public static final String OCR_BD_Select = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_BD_PopUpclose = "//form[@id='searchForm']//button[@class='btn-close']";
	public static final String OCR_BD_TI_PortofUnladingLink = "//a[@id='portofunloading-popup']";
	public static final String OCR_BD_TI_PortofLoading = "//input[@id='shipment_portOfLoading']";
	public static final String OCR_BD_TI_PlaceofDelivery = "//input[@id='shipment_placeOfDelivery']";
	public static final String OCR_BD_TI_PortOfArrivalLink = "//a[@id='portofarrival-popup']";
	public static final String OCR_BD_TI_AirOceanCarrierLink = "//a[@id='shipmentAirLink']";
	public static final String OCR_BD_TI_InlandCarrierLink = "//a[@id='shipmentInlandLink']";
	public static final String OCR_BD_TI_LoadingPier = "//input[@id='shipment_loadingPier']";
	public static final String OCR_BD_TI_VesselFlightNumber = "//input[@id='shipment_vesselFlightNo']";
	public static final String OCR_BD_TI_AirportofFinalDestinationLink = "//a[@id='airportfinaldest-popup']";
	public static final String OCR_BD_TI_AirportCode = "//input[@id='searchForm_airport_destinationCode']";
	public static final String OCR_BD_TI_TransportDOCNumber = "//input[@id='shipment_transportDocNumber']";
	public static final String OCR_BD_TI_PassengerandCargoAircraft = "(//input[@name='shipment.cargoAircraftFlag'])[1]";
	public static final String OCR_BD_TI_CargoAircraftOnly = "(//input[@name='shipment.cargoAircraftFlag'])[2]";
	public static final String OCR_BD_Save = "//form[@id='editShipment']//button[3]";
	public static final String OCR_BD_SaveAndReturn = "//button[@id='saveandreturn']";
	public static final String OCR_BD_Close = "//button[@id='cancelBtn']";
	public static final String OCR_BD_AdditionalDetails = "//i[@class='fa fa-th']";
	public static final String OCR_BD_HazmatDetails = "//a[contains(text(),'Hazmat Details')]";

	/* ******************************* Constructor ****************************** */

	public EditShipmentBookingDeatilsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Add the Transport Information
	public void addTransportInfo(String TransportCountryOfOrigin, String TransportPortOfExport,
			String TransportPortOfUnlading, String TransportPortOfLoading, String TransportPlaceofDelivery,
			String TransportPortOfArrival, String TransportLoadingPier, String TransportVesselFlightNumber,
			String TransportAirportofFinalDest, String TransportDOCNumber, String PassengerandCargoAircraft,
			String CargoAircraftOnly) {

		typeText(driver, test, OCR_BD_TI_CountryOfOrigin, "Enter the Country of Origin : ", TransportCountryOfOrigin);
		if (TransportPortOfExport.length() > 0) {
			Wait.waitfor(2);
			clickElement(driver, test, OCR_BD_TI_PortofExportLink, "Click on Port of Export Link");
			try {
				typeText(driver, test, OCR_BD_TI_PortID, "Enter the Port ID : ", TransportPortOfExport);
				clickElement(driver, test, OCR_BD_Search, "Click on Search");
				clickElement(driver, test, "//td[contains(text(),'" + TransportPortOfExport + "')]",
						"Select on Port ID : " + TransportPortOfExport);
				clickElement(driver, test, OCR_BD_Select, "Click on Select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_BD_PopUpclose, "Click on Pop Up close");
			}
		}
		if (TransportPortOfUnlading.length() > 0) {
			scrollToElement(driver, OCR_BD_TI_PortofUnladingLink);
			Wait.waitfor(2);
			clickElement(driver, test, OCR_BD_TI_PortofUnladingLink, "click on Port of Unlading Link");
			try {
				typeText(driver, test, OCR_BD_TI_PortID, "Enter the Port ID : ", TransportPortOfUnlading);
				clickElement(driver, test, OCR_BD_Search, "Click on Search");
				clickElement(driver, test, "//td[contains(text(),'" + TransportPortOfUnlading + "')]",
						"Select on Port ID : " + TransportPortOfUnlading);
				clickElement(driver, test, OCR_BD_Select, "Click on Select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_BD_PopUpclose, "Click on Pop Up close");
			}
		}
		typeText(driver, test, OCR_BD_TI_PortofLoading, "Enter the Port of loading : ", TransportPortOfLoading);
		typeText(driver, test, OCR_BD_TI_PlaceofDelivery, "Enter the Place of Delivery : ", TransportPlaceofDelivery);
		if (TransportPortOfArrival.length() > 0) {
			scrollToElement(driver, OCR_BD_TI_PortOfArrivalLink);
			Wait.waitfor(2);
			clickElement(driver, test, OCR_BD_TI_PortOfArrivalLink, "Click on Port of Arrival Link");
			try {
				typeText(driver, test, OCR_BD_TI_PortID, "Enter the Port ID : ", TransportPortOfArrival);
				clickElement(driver, test, OCR_BD_Search, "Click on Search");
				clickElement(driver, test, "//td[contains(text(),'" + TransportPortOfArrival + "')]",
						"Select on Port ID : " + TransportPortOfArrival);
				clickElement(driver, test, OCR_BD_Select, "Click on Select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_BD_PopUpclose, "Click on Pop Up close");
			}
		}
		// clickElement(driver, test, OCR_BD_TI_AirOceanCarrierLink, "Click on Air /
		// Ocean Carrier Link");
		// clickElement(driver, test, OCR_BD_TI_InlandCarrierLink, "Click on Inland
		// Carrier Link");
		typeText(driver, test, OCR_BD_TI_LoadingPier, "Enter the Loading Pier : ", TransportLoadingPier);
		typeText(driver, test, OCR_BD_TI_VesselFlightNumber, "Enter the Vessel Flight Number : ",
				TransportVesselFlightNumber);
		if (TransportAirportofFinalDest.length() > 0) {
			Wait.waitfor(2);
			clickElement(driver, test, OCR_BD_TI_AirportofFinalDestinationLink,
					"Click on Airport of Final Destination Link");
			try {
				typeText(driver, test, OCR_BD_TI_AirportCode, "Enter the Airport Code : ", TransportAirportofFinalDest);
				clickElement(driver, test, OCR_BD_Search, "Click on Search");
				clickElement(driver, test, "//td[contains(text(),'" + TransportAirportofFinalDest + "')]",
						"Select on Airport of Final Dest. : " + TransportAirportofFinalDest);
				clickElement(driver, test, OCR_BD_Select, "Click on Select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_BD_PopUpclose, "Click on Pop Up close");
			}
		}
		typeText(driver, test, OCR_BD_TI_TransportDOCNumber, "Enter the Transport DOC Number : ", TransportDOCNumber);
		if (PassengerandCargoAircraft.equalsIgnoreCase("Yes")) {
			Wait.waitfor(2);
			clickElement(driver, test, OCR_BD_TI_PassengerandCargoAircraft,
					"Click on Passenger and CargoAircraft Radio button");
		}
		if (CargoAircraftOnly.equalsIgnoreCase("Yes")) {
			Wait.waitfor(2);
			clickElement(driver, test, OCR_BD_TI_CargoAircraftOnly, "Click on Cargo Aircraft Only Radio button");
		}
	}

	// Add Header inforamtion
	public void add_HearderInfo(String BookingNo, String BillOfLadingNo, String MasterAWBNumber, String TrackingNo,
			String TransportRefNo, String DateofArrival) {
		scrollToElement(driver, OCR_BD_HI_BookingNo);
		scrollToTop(driver);
		typeText(driver, test, OCR_BD_HI_BookingNo, "Enter the Booking No : ", BookingNo);
		typeText(driver, test, OCR_BD_HI_BillOfLadingNo, "Enter the Bill of Lading No : ", BillOfLadingNo);
		// clickElement(driver, test, OCR_BD_HI_AirwayBillNumberLink, "Click on Airway
		// Bill Number Link");
		// clickElement(driver, test, OCR_BD_HI_HouseAirwayBillNumber, "Click on House
		// Airway Bill Number");
		typeText(driver, test, OCR_BD_HI_MasterAWBNumber, "Enter the Master AWB Number : ", MasterAWBNumber);
		typeText(driver, test, OCR_BD_HI_TrackingNo, "Enter the Tracking No : ", TrackingNo);
		typeText(driver, test, OCR_BD_HI_TransportRefNo, "Enter the Transport Ref. No. : ", TransportRefNo);
		typeText(driver, test, OCR_BD_HI_DateofArrival, "Enter the Date of Arrival : ", DateofArrival);
	}

	// Add the Shipping Payment Information
	public void addShippingPaymentInfo(String Prepaid, String CodeAmount, String Collect, String ContainsPersonalInfo,
			String CarnetNo, String SPIIssueDate, String ExpiryDate, String InsuranceAmount, String InsuranceRequired,
			String Insured, String Containerized) {
		selectByVisibleText(driver, test, OCR_BD_SPI_Prepaid, "Select the Prepaid : ", Prepaid);
		typeText(driver, test, OCR_BD_SPI_CodeAmount, "Enter the Code Amount : ", CodeAmount);
		selectByVisibleText(driver, test, OCR_BD_SPI_Collect, "Select the Collect : ", Collect);
		selectByVisibleText(driver, test, OCR_BD_SPI_ContainsPersonalInfo, "Select the Contains Personal Info : ",
				ContainsPersonalInfo);
		typeText(driver, test, OCR_BD_SPI_CarnetNo, "Enter the Carnet No : ", CarnetNo);
		Wait.waitfor(2);
		clickElement(driver, test, OCR_BD_SPI_IssueDate, "click on Issue Date");
		Wait.waitfor(2);
		date(driver, test, "Select the Issue Date : ", SPIIssueDate);
		Wait.waitfor(2);
		clickElement(driver, test, OCR_BD_SPI_ExpiryDate, "Click on Expiry Date");
		date(driver, test, "Select the Expiry Date : ", ExpiryDate);
		typeText(driver, test, OCR_BD_SPI_InsuranceAmount, "Enter the Insurance Amount : ", InsuranceAmount);
		selectByVisibleText(driver, test, OCR_BD_SPI_InsuranceRequired, "Select the Insurance Required : ",
				InsuranceRequired);
		selectByVisibleText(driver, test, OCR_BD_SPI_Insured, "Select the Insured : ", Insured);
		selectByVisibleText(driver, test, OCR_BD_SPI_Containerized, "Select the Containerized : ", Containerized);
	}

	// Click on Save
	public void click_SaveBookingDetails() {
		scrollToElement(driver, OCR_BD_Save);
		scrollToTop(driver);
		clickElement(driver, test, OCR_BD_Save, "Click on Save in Booking Details");
	}

	// click on Save and Return
	public void click_SaveAndReturn() {
		scrollToElement(driver, OCR_BD_Save);
		scrollToTop(driver);
		clickElement(driver, test, OCR_BD_SaveAndReturn, "Click on Save and Return in Booking Details");
	}

	// Click on Close
	public void click_Close() {
		clickElement(driver, test, OCR_BD_Close, "Click on Close in Booking Details");
	}
	
	//select Hazmat Details
	public void selectHazmatDetails() {
		Wait.waitfor(2);
		scrollToElement(driver, OCR_BD_AdditionalDetails);
		clickElement(driver, test, OCR_BD_AdditionalDetails, "Click on Additional Details :");
		clickElement(driver, test, OCR_BD_HazmatDetails, "Select hazmat Details :");
	}

	// Validation of Air/ Ocean carrier for the selected Mode of Transport
	public void validateAirOcean() {
		scrollToBottom(driver);
		scrollToBottom(driver);
		clickElement(driver, test, OCR_BD_TI_AirOceanCarrierLink, "Click on Air/Ocean Carrier");
		try {
			if (isDisplayed(driver, "//div[@id='ocrModal']//button[@class='btn-close']")) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL,
						"Error Vaildation is not Displayed by clicking on SAVE button in Inland carrier for the selected Mode of Transport");
				clickElement(driver, test, "//div[@id='ocrModal']//button[@class='btn-close']", "click on POP up Close");
			}
		} catch (Exception e1) {

		}
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {
				if (isDisplayed(driver,
						"//li[contains(text(),'Please select an Inland carrier for the selected M')]")) {
					test.log(LogStatus.INFO, "Please select an Inland carrier for the selected Mode of Transport.");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, "//div[@id='ocrModal']//button[@class='btn-close']", "click on POP up Close");
			test.log(LogStatus.FAIL,
					"Error Vaildation is not Displayed by clicking on SAVE button in Inland carrier for the selected Mode of Transport");

		}

	}

	// Validation of Inland Carrier for the selected Mode of Transport
	public void validateInlandCarrier() {
		scrollToBottom(driver);
		Wait.waitfor(3);
		try {
			clickElement(driver, test, OCR_BD_TI_InlandCarrierLink, "Click on Inland Carrier");
			if (isDisplayed(driver, "//div[@id='ocrModal']//button[@class='close']")) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL,
						"Error Vaildation is not Displayed by clicking on SAVE button in Air/ Ocean carrier for the selected Mode of Transport");
				clickElement(driver, test, "//div[@id='ocrModal']//button[@class='close']", "click on POP up Close");
			}
		} catch (Exception e1) {

		}
		try {
			Wait.waitfor(3);
			if (isDisplayed(driver, "//h4[contains(text(),'Error!')]"))
				if (isDisplayed(driver, "//li[contains(text(),'Please select an Air')]")) {
					test.log(LogStatus.INFO, "Please select an Air/ Ocean carrier for the selected Mode of Transport");
				}
		} catch (Exception e2) {
			test.log(LogStatus.FAIL,
					"Error Vaildation is not Displayed by clicking on SAVE button in Air/ Ocean carrier for the selected Mode of Transport");
		}
	}

}
