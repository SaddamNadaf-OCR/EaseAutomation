package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class EditShipmentHazmatDetailsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_HSD_Hazardous = "//select[@id='shipment_hazardous']";
	public static final String OCR_HSD_Destination = "//input[@id='shipment_destination']";
	public static final String OCR_HSD_ContainerAndVehicleNumber = "//input[@id='shipment_contnIdnoVechRegno']";
	public static final String OCR_HSD_SealNumbers = "//input[@id='shipment_sealNumbers']";
	public static final String OCR_HSD_ContainerVechileSizeandType = "//input[@id='shipment_containerTypeSize']";
	public static final String OCR_HSD_TareMass = "//input[@id='shipment_tareMass']";
	public static final String OCR_HSD_TotalGross = "//input[@id='shipment_tareMassGross']";
	public static final String OCR_HSD_Nameofthecompanypacking = "//input[@id='shipment_companyName']";
	public static final String OCR_HSD_NameStatusDeclarant = "//input[@id='shipment_nameStatusDecl']";
	public static final String OCR_HSD_ContainerPlace = "//input[@id='shipment_contPlace']";
	public static final String OCR_HSD_ContainerDate = "//input[@id='contDate']";
	public static final String OCR_HSD_NameoftheCompany = "//input[@id='shipment_shipperName']";
	public static final String OCR_HSD_ShipperNameStatusDeclarant = "//input[@id='shipment_shipperNameStatusDecl']";
	public static final String OCR_HSD_ShipperPlace = "//input[@id='shipment_shipperPlace']";
	public static final String OCR_HSD_ShipperDate = "//input[@id='shipperDate']";
	public static final String OCR_HSD_Radioactive = "(//input[@name='shipment.shipmentType'])[1]";
	public static final String OCR_HSD_NonRadiocative = "(//input[@name='shipment.shipmentType'])[2]";
	public static final String OCR_HSD_HazmatloadsheetInstructions = "//textarea[@id='shipment_addlShippingInfo']";
	public static final String OCR_HSD_CarrierInfo = "//textarea[@id='shipment_carrierInfo']";
	public static final String OCR_HSD_EmergencyContactNo = "//input[@id='shipment_emergencyContactNumber']";
	public static final String OCR_HSD_AI_TSCA = "//select[@id='shipment_tscaRequired']";
	public static final String OCR_HSD_AI_REACH = "//select[@id='shipment_exportRequirement']";
	public static final String OCR_HSD_AI_ChemicalSubstance = "//select[@id='shipment_tscaSubstance']";
	public static final String OCR_HSD_Save = "//form[@id='editShipment']//button[3]";
	public static final String OCR_HSD_SaveAndReturn = "//button[@id='saveandreturn']";
	public static final String OCR_HSD_ChangeStatus = "//button[@class='primary-btn dropdown-toggle shipment']";
	public static final String OCR_HSD_Close = "//button[@id='cancelBtn']";
	public static final String OCR_HSD_AdditionalDetails = "//i[@class='fa fa-th']";
	public static final String OCR_HSD_Instructions = "//a[@class='eo-tab'] [contains(text(),'Instructions')]";
	
	

	/* ******************************* Constructor ****************************** */

	public EditShipmentHazmatDetailsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Add Shipment - Hazmat Details
	public void addHazmatShipmentDetails(String Hazardous, String Destination, String ContainerAndVehicleNumber,
			String SealNumber, String ContainerVechileSize, String TareMass, String TotalGross,
			String Nameofthecompanypacking, String NameStatusDeclarant, String ContainerPlace, String ConatinerDate,
			String NameoftheCompany, String ShipperNameStatusDeclarant, String ShipperPlace, String ShipperDate,
			String Radioactive, String HazmatloadsheetInstructions, String CarrierInfo, String EmergencyContactNo,
			String TSCA, String REACH, String ChemicalSubstance) {

		selectByVisibleText(driver, test, OCR_HSD_Hazardous, "Select the Hazardous : ", Hazardous);
		typeText(driver, test, OCR_HSD_Destination, "Enter the Destination : ", Destination);
		typeText(driver, test, OCR_HSD_ContainerAndVehicleNumber,
				"Enter the Container Identification Number/ Vehicle Registration Number : ", ContainerAndVehicleNumber);
		typeText(driver, test, OCR_HSD_SealNumbers, "Enter the Seal Numbers : ", SealNumber);
		typeText(driver, test, OCR_HSD_ContainerVechileSizeandType, "Enter the Container/ Vechile Size and Type : ",
				ContainerVechileSize);
		typeText(driver, test, OCR_HSD_TareMass, "Enter the Tare Mass(KG) : ", TareMass);
		typeText(driver, test, OCR_HSD_TotalGross, "Enter the Total Gross (Including Tare) KG : ", TotalGross);
		typeText(driver, test, OCR_HSD_Nameofthecompanypacking,
				"Enter the Name of the company packing/ Loading the Container : ", Nameofthecompanypacking);
		typeText(driver, test, OCR_HSD_NameStatusDeclarant, "Enter the Name of the Name/ Status Declarant : ",
				NameStatusDeclarant);
		typeText(driver, test, OCR_HSD_ContainerPlace, "Enter the Container Place : ", ContainerPlace);
		Wait.waitfor(2);
		scrollToElement(driver, OCR_HSD_ContainerDate);
		clickElement(driver, test, OCR_HSD_ContainerDate, "Click on Container Date");
		date(driver, test, "Select the Container Date : ", ConatinerDate);
		typeText(driver, test, OCR_HSD_NameoftheCompany,
				"Enter the Name of the Company (Of Shipper Preparing the note) : ", NameoftheCompany);
		typeText(driver, test, OCR_HSD_ShipperNameStatusDeclarant,
				"Enter the Shipper Name of the Name/Status Declarant : ", ShipperNameStatusDeclarant);
		typeText(driver, test, OCR_HSD_ShipperPlace, "Enter the Shipper Place : ", ShipperPlace);
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HSD_ShipperDate, "Click on Shipper Date");
		date(driver, test, "Select the ShipperDate : ", ShipperDate);
		if (Radioactive.equalsIgnoreCase("yes"))
			clickElement(driver, test, OCR_HSD_Radioactive, "Click on Radioactive radio button");
		else
			clickElement(driver, test, OCR_HSD_NonRadiocative, "Click on Non Radioactive radio button");
		typeText(driver, test, OCR_HSD_HazmatloadsheetInstructions, "Enter the Hazmat load sheet Instructions : ",
				HazmatloadsheetInstructions);
		typeText(driver, test, OCR_HSD_CarrierInfo, "Enter the Carrier Info : ", CarrierInfo);
		typeText(driver, test, OCR_HSD_EmergencyContactNo, "Enter the Emergency Contact No : ", EmergencyContactNo);
		selectByVisibleText(driver, test, OCR_HSD_AI_TSCA,
				"Select the Is this shipment subject to TSCA 12(b) export requirements? ", TSCA);
		selectByVisibleText(driver, test, OCR_HSD_AI_REACH,
				"Select the Is this shipment subject to REACH export requirements ? ", REACH);
		selectByVisibleText(driver, test, OCR_HSD_AI_ChemicalSubstance,
				"Does this shipment contain a chemical substance, mixture, or article containing a chemical substance or mixture?",
				ChemicalSubstance);
	}

	// Click on Save
	public void click_SaveHazmatDetails() {
		scrollToElement(driver, OCR_HSD_Save);
		scrollToTop(driver);
		clickElement(driver, test, OCR_HSD_Save, "Click on Save in Hazmat Details");
	}

	// click on Save and Return
	public void click_SaveAndReturn() {
		scrollToElement(driver, OCR_HSD_SaveAndReturn);
		scrollToTop(driver);
		clickElement(driver, test, OCR_HSD_SaveAndReturn, "Click on Save and Return in Hazmat Details");
	}
	
	//click on Additional Details and Instructions
	public void click_AdditionalDetails() {
		Wait.waitfor(2);
		scrollToElement(driver, OCR_HSD_AdditionalDetails);
		clickElement(driver, test, OCR_HSD_AdditionalDetails, "CLick on Additional Transaction Details :");
		clickElement(driver, test, OCR_HSD_Instructions, "Click on Instructions :");
		
	}

	// Click on change Status
	public void click_ChangeStatus() {
		clickElement(driver, test, OCR_HSD_ChangeStatus, "Click on Change Status in Hazmat Details");
	}

	// Click on Close
	public void click_Close() {
		clickElement(driver, test, OCR_HSD_Close, "Click on Close in Hazmat Details");
	}
	
	//Get the first selected options in Hazardous field
	public String getHazardous() {
		return getSelectFirstText(driver, test, OCR_HSD_Hazardous, "Get the First selected option in Hazardous :");
	}

}
