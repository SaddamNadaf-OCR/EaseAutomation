package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class DeclarationDetailsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_Customs_DD_TypeofTransaction = "//input[@id='declarationDetailsForm_customsFiling_transactionType']";
	public static final String OCR_Customs_DD_DecisiveDate = "//input[@id='declarationDetailsForm_customsFiling_decisiveDate']";
	public static final String OCR_Customs_DD_DateofExit = "//input[@id='declarationDetailsForm_customsFiling_dateOfExit']";
	public static final String OCR_Customs_DD_SpecificCircumstances = "//select[@id='declarationDetailsForm_customsFiling_specificCircumstances']";
	public static final String OCR_Customs_DD_StartTimeofPresentforLoading = "//input[@id='declarationDetailsForm_customsFiling_presStartTimeForLoading']";
	public static final String OCR_Customs_DD_EndTimeofPresentforLoading = "//div[@class='form-group normal-decl-block load_pres_time']//div[3]//input[1]";
	public static final String OCR_Customs_DD_PlaceOfLoading = "//select[@name='location.placeOfLoading']";
	public static final String OCR_Customs_DD_RoutingCountry = "//input[@id='locationRoutingCountries_tag']";
	public static final String OCR_Customs_DD_ExitOffice = "//input[@name='location.officeOfExit']";
	public static final String OCR_Customs_DD_LocationsLabel = "//label[contains(text(),'Locations')]";
	public static final String OCR_Customs_DD_Transportationlabel = "//label[contains(text(),'Transportation Details')]";
	public static final String OCR_Customs_DD_InlandCarrier = "//input[@id='declarationDetailsForm_inlandModeDesc']";
	public static final String OCR_Customs_DD_BorderNationality = "//input[@id='declarationDetailsForm_borderCountryName']";
	public static final String OCR_Customs_DD_ReflocationofIncoterms = "//input[@id='declarationDetailsForm_invoice_deliveryLocation']";
	public static final String OCR_Customs_DD_Containerised = "//input[@id='declarationDetailsForm_customsFiling_containerized']";
	public static final String OCR_Customs_DD_MiscDetailsLabel = "//label[contains(text(),'Misc Details')]";
	public static final String OCR_Customs_DD_RegNoExternalSystem = "//input[@id='declarationDetailsForm_customsFiling_externalSystemRegNumber']";
	public static final String OCR_Customs_DD_CommercialRef = "//input[@id='declarationDetailsForm_customsFiling_commercialRef']";
	public static final String OCR_Customs_DD_InternalRemark = "//textarea[@id='declarationDetailsForm_customsFiling_internalRemark']";
	public static final String OCR_Customs_DD_MenuItemsIcon = "//i[@class='fa fa-th']";
	public static final String OCR_Customs_DD_ItemsDetails = "//a[@class='cf-tab itemsTab']";
	public static final String OCR_Customs_DD_Documents = "//a[@class='cf-tab'][contains(text(),'Documents')]";
	public static final String OCR_Customs_DD_Notes = "//a[@class='cf-tab'][contains(text(),'Notes')]";
	public static final String OCR_Customs_DD_ShipmentView = "//a[contains(text(),'Shipment View')]";

	/* ******************************* Constructor ****************************** */

	public DeclarationDetailsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Add the header Information
	public void addHeaderInformation(String TypeofTransaction, String DecisiveDate, String DateofExit,
			String SpecificCircumstances, String StartTimeofPresentforLoading, String EndTimeofPresentforLoading) {
		typeText(driver, test, OCR_Customs_DD_TypeofTransaction, "Enter the Type of Transaction : ", TypeofTransaction);
		typeText(driver, test, OCR_Customs_DD_DecisiveDate, "Enter the Decisive Date : ", DecisiveDate);
		typeText(driver, test, OCR_Customs_DD_DateofExit, "Enter the Date of Exit : ", DateofExit);
		selectByVisibleText(driver, test, OCR_Customs_DD_SpecificCircumstances, "Select the Specific Circumstances : ",
				SpecificCircumstances);
		typeText(driver, test, OCR_Customs_DD_StartTimeofPresentforLoading,
				"Enter the Start Time of Present for Loading", StartTimeofPresentforLoading);
		typeText(driver, test, OCR_Customs_DD_EndTimeofPresentforLoading,
				"Enter the End Time of Present for Loading : ", EndTimeofPresentforLoading);
	}

	// Add the locations
	public void addLocations(String PlaceOfLoading, String ExitOffice, String RoutingCountry) {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_Customs_DD_LocationsLabel, "Click on Locations Label");
		Wait.waitfor(3);
		selectByVisibleText(driver, test, OCR_Customs_DD_PlaceOfLoading, "Select the Place of loading : ",
				PlaceOfLoading);
		typeText(driver, test, OCR_Customs_DD_ExitOffice, "Enter the Exit Office : ", ExitOffice);
		clickElement(driver, test, OCR_Customs_DD_RoutingCountry, "Click on Routing country");
		typeText(driver, test, OCR_Customs_DD_RoutingCountry, "Enter the Routing Country : ", RoutingCountry);
	}

	// Add the Transportation Details
	public void addTransportationDetails(String InlandCarrier, String BorderNationality, String Containerised,
			String ReflocationofIncoterms) {
		clickElement(driver, test, OCR_Customs_DD_Transportationlabel, "Click on Transportation Details Label");
		Wait.waitfor(3);
		typeText(driver, test, OCR_Customs_DD_InlandCarrier, "Enter the Inland Carrier : ", InlandCarrier);
		typeText(driver, test, OCR_Customs_DD_BorderNationality, "Enter the Border Nationality : ", BorderNationality);
		if (Containerised.equalsIgnoreCase("Yes")) {
			clickElement(driver, test, Containerised, "Click on Containerised");
		}
		typeText(driver, test, OCR_Customs_DD_ReflocationofIncoterms, "Enter the Ref. location of Incoterms : ",
				ReflocationofIncoterms);
	}

	// Add the Misc Details
	public void addMiscDetails(String RegNoExternalSystem, String CommercialRef, String InternalRemark) {
		clickElement(driver, test, OCR_Customs_DD_MiscDetailsLabel, "Click on Misc Details label");
		Wait.waitfor(3);
		typeText(driver, test, OCR_Customs_DD_RegNoExternalSystem, "Enter the Reg. No. (External System) : ",
				RegNoExternalSystem);
		typeText(driver, test, OCR_Customs_DD_CommercialRef, "Enter the Commercial Ref. : ", CommercialRef);
		typeText(driver, test, OCR_Customs_DD_InternalRemark, "Enter the Internal Remark : ", InternalRemark);
	}

	// Select the Items Details
	public void selectItemDetails() {
		clickElement(driver, test, OCR_Customs_DD_MenuItemsIcon, "Click on Menu Items Icon");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Customs_DD_ItemsDetails, "Click on Item Details");
	}

	// Select the Documents Details
	public void selectDocumentsDetails() {
		clickElement(driver, test, OCR_Customs_DD_MenuItemsIcon, "Click on Menu Items Icon");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Customs_DD_Documents, "Click on Documents ");
	}

	// Select the Notes Details
	public void selectNotesDetails() {
		clickElement(driver, test, OCR_Customs_DD_MenuItemsIcon, "Click on Menu Items Icon");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Customs_DD_Notes, "Click on Notes");
	}

	// Select the Shipment View
	public void selectShipmentView() {
		clickElement(driver, test, OCR_Customs_DD_MenuItemsIcon, "Click on Menu Items Icon");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Customs_DD_ShipmentView, "Click on  Shipment View");
	}

}
