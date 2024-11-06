
package globalExportClasses;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ShipWizardInvoicePartyDetailsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_InvoicePartyDetails_PaymentTermsLink = "//a[contains(text(),'Payment Terms')]";
	public static final String OCR_InvoicePartyDetails_SelectButton = "(//button[contains(text(),'Select')])[1]";
	public static final String OCR_InvoicePartyDetails_SearchBtn = "//button[@name='Search']";
	public static final String OCR_InvoicePartyDetails_Incoterm = "(//a[contains(text(),'Incoterms')])[2]";
	public static final String OCR_InvoicePartyDetails_Global_Incoterm = "(//a[contains(text(),'Incoterm')])[2]";
	public static final String OCR_InvoicePartyDetails_DoPayInvoice = "//input[@name='dontPayInv']";
	public static final String OCR_InvoicePartyDetails_IncoNamedforDestination = "//input[@id='editShipmentWizardInvoice_invoice_deliveryLocation']";
	public static final String OCR_InvoicePartyDetails_ForCustomsPurpose = "//input[@name='customsPurpose']";
	public static final String OCR_InvoicePartyDetails_Notes = "//textarea[@id='editShipmentWizardInvoice_invoice_notes']";
	public static final String OCR_InvoicePartyDetails_AddMorePartiesBtn = "//button[@id='addPartyBtn']";
	public static final String OCR_InvoicePartyDetails_closePopUP = "//button[@class='btn-close']";
	public static final String OCR_InvoicePartyDetails_SaveParties = "//button[@id='entitySave']";
	public static final String OCR_InvoicePartyDetails_EntryType = "//select[@name='eType']";
	public static final String OCR_InvoicePartyDetails_EntryTypeCode = "//a[@name='entityCodeLink']";
	public static final String OCR_InvoicePartyDetails_ConsigneeIdBillTo = "//input[@id='resultConsigneeWithContactPopup_popupValue_code']";
	public static final String OCR_InvoicePartyDetails_CartonDetailsBtn = "//button[@id='addCartonBtn']";
	public static final String OCR_InvoicePartyDetails_DimensionUOM = "//select[@id='editTabbedInvoiceCartonWizard_invoiceCarton_dimensionUom']";
	public static final String OCR_InvoicePartyDetails_Dim_ML = "//input[@id='editTabbedInvoiceCartonWizard_invoiceCarton_lengthMt']";
	public static final String OCR_InvoicePartyDetails_Dim_MW = "//input[@id='editTabbedInvoiceCartonWizard_invoiceCarton_widthMt']";
	public static final String OCR_InvoicePartyDetails_Dim_MH = "//input[@id='editTabbedInvoiceCartonWizard_invoiceCarton_heightMt']";
	public static final String OCR_InvoicePartyDetails_Dim_CmL = "//input[@id='editTabbedInvoiceCartonWizard_invoiceCarton_lengthCm']";
	public static final String OCR_InvoicePartyDetails_Dim_CmW = "//input[@id='editTabbedInvoiceCartonWizard_invoiceCarton_widthCm']";
	public static final String OCR_InvoicePartyDetails_Dim_CmH = "//input[@id='editTabbedInvoiceCartonWizard_invoiceCarton_heightCm']";
	public static final String OCR_InvoicePartyDetails_Dim_InchesL = "//input[@id='editTabbedInvoiceCartonWizard_invoiceCarton_length']";
	public static final String OCR_InvoicePartyDetails_Dim_InchesW = "//input[@id='editTabbedInvoiceCartonWizard_invoiceCarton_width']";
	public static final String OCR_InvoicePartyDetails_Dim_InchesH = "//input[@id='editTabbedInvoiceCartonWizard_invoiceCarton_height']";
	public static final String OCR_InvoicePartyDetails_WeightUOM = "//select[@id='editTabbedInvoiceCartonWizard_invoiceCarton_widthUom']";
	public static final String OCR_InvoicePartyDetails_WeightKG_Gross = "//input[@id='editTabbedInvoiceCartonWizard_invoiceCarton_grossWeightKg']";
	public static final String OCR_InvoicePartyDetails_WeightKG_Net = "//input[@id='editTabbedInvoiceCartonWizard_invoiceCarton_netWeightKg']";
	public static final String OCR_InvoicePartyDetails_WeightLbs_Gross = "//input[@id='editTabbedInvoiceCartonWizard_invoiceCarton_grossWeightLbs']";
	public static final String OCR_InvoicePartyDetails_WeightLbs_Net = "//input[@id='editTabbedInvoiceCartonWizard_invoiceCarton_netWeight']";
	public static final String OCR_InvoicePartyDetails_SaveAndReturn = "//button[@id='invCartonSaveReturn']";
	public static final String OCR_InvoicePartyDetails_CustomsCurrency = "//input[@id='editShipmentWizardInvoice_invoice_convertedCurrency']";
	public static final String OCR_InvoicePartyDetails_ConversionRate = "//input[@id='editShipmentWizardInvoice_invoice_currConvStr']";
	public static final String OCR_InvoicePartyDetails_AddCarton = "//button[@id='addCartonBtn']";
	public static final String OCR_InvoicePartyDetailsCartonCopy = "(//td[@aria-describedby='grid-cartons_copy'])[1]";
	public static final String OCR_InvoicePartyDetailsCartonDelete = "(//td[@aria-describedby='grid-cartons_trash'])[1]";
	public static final String OCR_ShipAdditionalCharges_PopUpClose = "//div[@id='ocrModal']//button[@class='btn-close']";

	/* ******************************* Constructor ****************************** */

	public ShipWizardInvoicePartyDetailsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Validating parties to to the transaction on Invoice & Party Details for create request via template 
		public void validate_ShipToOnInvoicePartyDetails() {
			try {
					if (isDisplayed(driver, "//td[contains(text(),'Afsha Mir')]")) {
						
						test.log(LogStatus.INFO, "Parties to the Transaction on Invoice & Party Details page is not displayed");
					}
			
				} catch (Exception e) {
				test.log(LogStatus.FAIL,"Parties to the Transaction on requestor Invoice & Party Details is not displayed ");
				testFailSshot(driver, test);		
	  }
	}
	
	
	// Adding the Invoice Details
	public void addInvoiceDetails(String PaymnetID, String IncotermCode, String DontPayInvoice,
			String IncoNamedforDestination, String ForCustomsPurpose, String Notes) {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_InvoicePartyDetails_PaymentTermsLink, "Click on Payment Terms Link");
		try {
			Wait.waitfor(3);
			clickElement(driver, test, "//td[contains(text(),'" + PaymnetID + "')]",
					"click on Payment ID : " + PaymnetID);
			clickElement(driver, test, OCR_InvoicePartyDetails_SelectButton, "Click on Select Button");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_InvoicePartyDetails_closePopUP, "Click on Close Button");
		}
		Wait.waitfor(5);
		clickElement(driver, test, OCR_InvoicePartyDetails_Incoterm, "Click on Incoterm Link");
		try {
			Wait.waitfor(3);
			clickElement(driver, test, "//td[contains(text(),'" + IncotermCode + "')]",
					"Click on Incoterm Code : " + IncotermCode);
			clickElement(driver, test, OCR_InvoicePartyDetails_SelectButton, "Click on Select Button");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_InvoicePartyDetails_closePopUP, "Click on Close Button");
		}
		Wait.waitfor(3);
		if (DontPayInvoice.equalsIgnoreCase("Yes")) {
			clickElement(driver, test, OCR_InvoicePartyDetails_DoPayInvoice, "Click on Do Pay Invoice check box");
		}
		typeText(driver, test, OCR_InvoicePartyDetails_IncoNamedforDestination,
				"Enter the Inco Named for Destination : ", IncoNamedforDestination);
		if (ForCustomsPurpose.equalsIgnoreCase("Yes")) {
			clickElement(driver, test, OCR_InvoicePartyDetails_ForCustomsPurpose,
					"Click on For Customs Purpose check box");
		}
		typeText(driver, test, OCR_InvoicePartyDetails_Notes, "Enter the Notes", Notes);
	}
	
	// Adding the Invoice Details for Non-US(Global EO)
		public void addInvoiceDetails_Global(String PaymnetID, String IncotermCode, String DontPayInvoice,
				String IncoNamedforDestination, String ForCustomsPurpose, String Notes) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_InvoicePartyDetails_PaymentTermsLink, "Click on Payment Terms Link");
			try {
				Wait.waitfor(3);
				clickElement(driver, test, "//td[contains(text(),'" + PaymnetID + "')]",
						"click on Payment ID : " + PaymnetID);
				clickElement(driver, test, OCR_InvoicePartyDetails_SelectButton, "Click on Select Button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_InvoicePartyDetails_closePopUP, "Click on Close Button");
			}
			Wait.waitfor(5);
			clickElement(driver, test, OCR_InvoicePartyDetails_Global_Incoterm, "Click on Incoterm Link");
			try {
				Wait.waitfor(3);
				clickElement(driver, test, "//td[contains(text(),'" + IncotermCode + "')]",
						"Click on Incoterm Code : " + IncotermCode);
				clickElement(driver, test, OCR_InvoicePartyDetails_SelectButton, "Click on Select Button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_InvoicePartyDetails_closePopUP, "Click on Close Button");
			}
			Wait.waitfor(3);
			if (DontPayInvoice.equalsIgnoreCase("Yes")) {
				clickElement(driver, test, OCR_InvoicePartyDetails_DoPayInvoice, "Click on Do Pay Invoice check box");
			}
			typeText(driver, test, OCR_InvoicePartyDetails_IncoNamedforDestination,
					"Enter the Inco Named for Destination : ", IncoNamedforDestination);
			if (ForCustomsPurpose.equalsIgnoreCase("Yes")) {
				clickElement(driver, test, OCR_InvoicePartyDetails_ForCustomsPurpose,
						"Click on For Customs Purpose check box");
			}
			typeText(driver, test, OCR_InvoicePartyDetails_Notes, "Enter the Notes", Notes);
		}

	// Add Parties to the Transaction
	public void addPartiesToTheTransaction(String EntryType, String ConsigneeIdBillTo) {
		clickElement(driver, test, OCR_InvoicePartyDetails_AddMorePartiesBtn, "Click on Add More Parties button");
		try {
			selectByVisibleText(driver, test, OCR_InvoicePartyDetails_EntryType, "Select the Entry Type : ", EntryType);
			clickElement(driver, test, OCR_InvoicePartyDetails_EntryTypeCode, "click on Entry type code");
			typeText(driver, test, OCR_InvoicePartyDetails_ConsigneeIdBillTo, "Enter the ConsigneeId :  ",
					ConsigneeIdBillTo);
			clickElement(driver, test, OCR_InvoicePartyDetails_SearchBtn, "Click on Search button");
			Wait.waitfor(3);
			clickElement(driver, test, "//td[contains(text(),'" + ConsigneeIdBillTo + "')]",
					"click on Consignee ID : " + ConsigneeIdBillTo);
			Wait.waitfor(3);
			clickElement(driver, test, OCR_InvoicePartyDetails_SelectButton, "Click on Select Button");
			Wait.waitfor(3);
			clickElement(driver, test, OCR_InvoicePartyDetails_SaveParties, "Click on Save Parties");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_InvoicePartyDetails_closePopUP, "Click on Close Button");
		}
	}

	// Add the Carton Details
	public void addCartonDetails(String CartonDimensionUOM, String CartonLenghtWidthHight, String CartonWeightUOM,
			String CartonGrossNet) {
		Wait.fluwait(driver, "//label[contains(text(),'Loading Content')]");
		scrollToBottom(driver);
		scrollToBottom(driver);
		scrollToElement(driver, OCR_InvoicePartyDetails_CartonDetailsBtn);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_InvoicePartyDetails_CartonDetailsBtn, "Click on Carton Details");
		try {
			selectByVisibleText(driver, test, OCR_InvoicePartyDetails_DimensionUOM, "Select the Dimension UOM : ",
					CartonDimensionUOM);
			ArrayList<String> LWH = GenericMethods.stringtoken(CartonLenghtWidthHight);
			if (CartonDimensionUOM.contains("Inches")) {
				typeText(driver, test, OCR_InvoicePartyDetails_Dim_InchesL, "Enter the inches(lenght) : ", LWH.get(0));
				typeText(driver, test, OCR_InvoicePartyDetails_Dim_InchesW, "Enter the inches(width) : ", LWH.get(1));
				typeText(driver, test, OCR_InvoicePartyDetails_Dim_InchesH, "Enter the inches(Height) : ", LWH.get(2));
			}
			if (CartonDimensionUOM.contains("Centimeters")) {
				typeText(driver, test, OCR_InvoicePartyDetails_Dim_CmL, "Enter the CM(lenght) : ", LWH.get(0));
				typeText(driver, test, OCR_InvoicePartyDetails_Dim_CmW, "Enter the CM(width) : ", LWH.get(1));
				typeText(driver, test, OCR_InvoicePartyDetails_Dim_CmH, "Enter the CM(Height) : ", LWH.get(2));
			}
			if (CartonDimensionUOM.contains("Meters")) {
				typeText(driver, test, OCR_InvoicePartyDetails_Dim_ML, "Enter the M(lenght) : ", LWH.get(0));
				typeText(driver, test, OCR_InvoicePartyDetails_Dim_MW, "Enter the M(width) : ", LWH.get(1));
				typeText(driver, test, OCR_InvoicePartyDetails_Dim_MH, "Enter the M(Height) : ", LWH.get(2));
			}
			selectByVisibleText(driver, test, OCR_InvoicePartyDetails_WeightUOM, "Select the Weight UOM : ",
					CartonWeightUOM);
			ArrayList<String> GN = GenericMethods.stringtoken(CartonGrossNet);
			if (CartonWeightUOM.contains("Kilograms")) {
				typeText(driver, test, OCR_InvoicePartyDetails_WeightKG_Gross, "Enter the KG(Gross) : ", GN.get(0));
				typeText(driver, test, OCR_InvoicePartyDetails_WeightKG_Net, "Enter the KG(Net) : ", GN.get(1));
			}
			if (CartonWeightUOM.contains("Pounds")) {
				typeText(driver, test, OCR_InvoicePartyDetails_WeightLbs_Gross, "Enter the Pounds(Gross) : ",
						GN.get(0));
				typeText(driver, test, OCR_InvoicePartyDetails_WeightLbs_Net, "Enter the Pounds(Net) : ", GN.get(1));
			}
			clickElement(driver, test, OCR_InvoicePartyDetails_SaveAndReturn, "Click on Carton Save and Return");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_InvoicePartyDetails_closePopUP, "Click on Close Button");
		}
	}

	// Clear the fields in Customs Currency and Conversion Rate
	public void clearCustomsCurrencyAndConversionRate() {
		clearText(driver, test, OCR_InvoicePartyDetails_CustomsCurrency, "Clear the Customs Currency");
		clearText(driver, test, OCR_InvoicePartyDetails_ConversionRate, "Clear the Conversion Rate");
	}

	// VAlidate the Customs Currency and Conversion Rate
	public void validateCustomsCurrencyConversionRate() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error!')]")) {

				if (isDisplayed(driver,
						"(//li[contains(text(),'Please provide Customs Currency')])[1]")) {
					test.log(LogStatus.INFO, "Please provide Customs Currency");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Please provide Customs Currency Conversion Rate')]")) {
					test.log(LogStatus.INFO, "Please provide Customs Currency Conversion Rate");
				}

			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error Vaildation is not Displayed by clicking on SAVE button in Invoice & Party Details page");
		}
	}
	
	//Getting the Entity type
	public String getEntityType() {
		String entityType = "//table[@id='entityTable']//tbody/tr/td/a";
		String Entity = getText(driver, test, entityType, "Get the Entity type : ");
		if(Entity.equals("Ship To")) {
			String entityName = "//table[@id='entityTable']//tbody/tr/td/a/../../td[2]";
			String entity = getText(driver, test, entityName, "Get the Entity Name : " );
			return entity;
		}
		return null;
	}
	
	//Parties details radio button is selected or not
	public void PartiesIsThisADropShipment() {
		if(isSelected(driver, "//input[@id='dropShipN']")) {
			test.log(LogStatus.PASS, "By default Parties Is This a Drop Shipment is NO ");
		}else {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "By default Parties Is This a Drop Shipment is Yes ");
		}
	}
	
	//Parties details radio button to yes
	public void clickPartiesDropShip() {
		clickElement(driver, test, "//input[@id='dropShipY']", "Click on Is This a Drop Shipment? : yes ");
		Wait.waitfor(3);
		try {
			if(isDisplayed(driver, "//a[contains(text(),'Ship To')]")) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Ship to details is Enabled");
			}
		} catch (Exception e) {
			test.log(LogStatus.PASS, "Ship to details is Disable");
		}
	
	}
	
	//Click on Add Carton Button
	public void addCartonButton() {
		scrollToElement(driver, OCR_InvoicePartyDetails_AddCarton);
		clickElement(driver, test, OCR_InvoicePartyDetails_AddCarton, "Clicking on Add Carton Button :");
	}
	
	// click on add charges grid Copy icon --------Added by Saddam
	public void click_ItemCopyIcon() {
		scrollToElement(driver, OCR_InvoicePartyDetails_AddCarton);
		clickElement(driver, test, OCR_InvoicePartyDetailsCartonCopy, " click on  Additional Charges Copy icon ");
		test.log(LogStatus.PASS, "Clicked on  Additional Charges Copy icon");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ShipAdditionalCharges_PopUpClose, "Click on PopUp close Icon");
	}

	// click on add charges grid Delete Icon -----Added by Saddam
	public void click_ItemDeleteIcon() {
		scrollToElement(driver, OCR_InvoicePartyDetails_AddCarton);
		clickElement(driver, test, OCR_InvoicePartyDetailsCartonDelete,
					"click on Additional Charges Delate Icon");
		Wait.waitfor(2);
		AlertPopUp(driver, test, "Are you sure you wish to delete?");
		Wait.waitfor(2);
		test.log(LogStatus.PASS, "Clicked on Additional Cartons Delate Icon");
	}
	
	//Click on Save and Return button on Carton Popup
	public void saveAndReturn() {
		clickElement(driver, test, OCR_InvoicePartyDetails_SaveAndReturn, "Click on Carton Save and Return");
	}
}
