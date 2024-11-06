package globalExportClasses;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewDeliveryOrderPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_NewDO_OrderNo = "//input[@id='editInvoice_invoice_invoiceNo']";
	public static final String OCR_NewDO_AssignedTo = "//a[@id='assignedTo-popup']";
	public static final String OCR_NewDO_UserFirstName = "//input[@id='searchForm_userProfile_userFirstname']";
	public static final String OCR_NewDO_Search = "//button[@name='Search']";
	public static final String OCR_NewDO_Select = "(//button[@name='Ok'])[1]";
	public static final String OCR_NewDO_EntitySave = "//button[@id='entitySave']";
	public static final String OCR_NewDO_Save = "(//button[contains(text(),'Save')])[1]";
	public static final String OCR_NewDO_PopUpClose = "(//button[@class='btn-close'])[1]";
	public static final String OCR_NewDO_UltDestination = "//input[@id='editInvoice_invoice_countryOfUltDest']";
	public static final String OCR_NewDO_ModeOfTransportLink = "(//a[contains(text(),'Mode of Transport')])[2]";
	public static final String OCR_NewDO_AddParty = "//button[@id='addPartyBtn']";
	public static final String OCR_NewDO_EntityType = "//select[@id='selectedParty']";
	public static final String OCR_NewDO_AddPartyCode = "//a[@name='entityCodeLink']";
	public static final String OCR_NewDO_ConsigneeCode = "//input[@id='resultConsigneeWithContactPopup_popupValue_code']";
	public static final String OCR_NewDO_AddContainerPackingDetailsBtn = "//button[@id='addCartonBtn']";
	public static final String OCR_NewDO_MarkingsContainerID = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_marking']";
	public static final String OCR_NewDO_SealNumber = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_sealNo']";
	public static final String OCR_NewDO_ConsolidatedPackNumber = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_consolidatedPackNo']";
	public static final String OCR_NewDO_Hazardous = "//select[@id='editTabbedInvoiceCarton_invoiceCarton_hazardFlag']";
	public static final String OCR_NewDO_RadioActivityAmnt = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_radioactivityAmt']";
	public static final String OCR_NewDO_DryIce = "//select[@id='editTabbedInvoiceCarton_invoiceCarton_dryIceFlag']";
	public static final String OCR_NewDO_GrossCartonWeight = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_cartonWeight']";
	public static final String OCR_NewDO_PackageType = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_packageType']";
	public static final String OCR_NewDO_Model = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_model']";
	public static final String OCR_NewDO_TareWeight = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_tareWeight']";
	public static final String OCR_NewDO_DimensionUOM = "//select[@id='dimensionUom']";
	public static final String OCR_NewDO_Dim_ML = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_lengthMt']";
	public static final String OCR_NewDO_Dim_MW = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_widthMt']";
	public static final String OCR_NewDO_Dim_MH = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_heightMt']";
	public static final String OCR_NewDO_Dim_CmL = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_lengthCm']";
	public static final String OCR_NewDO_Dim_CmW = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_widthCm']";
	public static final String OCR_NewDO_Dim_CmH = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_heightCm']";
	public static final String OCR_NewDO_Dim_InchesL = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_length']";
	public static final String OCR_NewDO_Dim_InchesW = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_width']";
	public static final String OCR_NewDO_Dim_InchesH = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_height']";
	public static final String OCR_NewDO_WeightUOM = "//select[@id='editTabbedInvoiceCarton_invoiceCarton_widthUom']";
	public static final String OCR_NewDO_WeightKG_Gross = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_grossWeightKg']";
	public static final String OCR_NewDO_WeightKG_Net = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_netWeightKg']";
	public static final String OCR_NewDO_WeightLbs_Gross = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_grossWeightLbs']";
	public static final String OCR_NewDO_WeightLbs_Net = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_netWeight']";
	public static final String OCR_NewDO_ContainerSubmit = "//button[@id='btnSave']";
	public static final String OCR_NewDO_AdditionalInformation = "//i[@class='fa fa-th']";
	public static final String OCR_NewDO_items = "//a[@class='eo-tab'][contains(text(),'Items')]";

	/* ******************************* Constructor ****************************** */

	public CreateNewDeliveryOrderPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Add the Delivery Order Details
	public void addDeliveryOrderDetails(String OrderNo, String UserFirstName, String UltDestination,
			String ModeOfTransport) {
		typeText(driver, test, OCR_NewDO_OrderNo, "Enter the Order No : ", OrderNo + randomnumbers());

		clickElement(driver, test, OCR_NewDO_AssignedTo, "Click on AssignedTo Link");

		try {
			typeText(driver, test, OCR_NewDO_UserFirstName, "Enter the User First Name : ", UserFirstName);
			clickElement(driver, test, OCR_NewDO_Search, "Click on Search");
			clickElement(driver, test, "(//td[contains(text(),'" + UserFirstName + "')])[1]",
					"Click on User First Name : " + UserFirstName);
			clickElement(driver, test, OCR_NewDO_Select, "click on Select");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_NewDO_PopUpClose, "click on Pop up Close");
		}

		typeText(driver, test, OCR_NewDO_UltDestination, "Enter the UltDestination : ", UltDestination);

		clickElement(driver, test, OCR_NewDO_ModeOfTransportLink, "Click on Mode Of Transport Link");

		try {
			clickElement(driver, test, "(//td[contains(text(),'" + ModeOfTransport + "')])[1]",
					"Click on Mode Of Transport : " + ModeOfTransport);
			clickElement(driver, test, OCR_NewDO_Select, "click on Select");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_NewDO_PopUpClose, "click on Pop up Close");
		}

	}
	
	//Add Program
	public void addProgram(String Program) {
		clickElement(driver, test, "(//a[contains(text(),'Program')])[3]", "Click on Program Link");
		try {
			typeText(driver, test, "//input[@id='searchForm_programTab_programCode']", "Enter the Program Code : ",
					Program);
			clickElement(driver, test, OCR_NewDO_Search, "Click on Select");
			clickElement(driver, test, "//td[contains(text(),'" + Program + "')]", "Select the Consignee : " + Program);
			clickElement(driver, test, OCR_NewDO_Select, "Click on Select button");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_NewDO_PopUpClose, "Click on Close popup icon");
		}
	}

	// Add Party Details
	public void addParty(String EntityType, String ConsigneeCode) {
		scrollToElement(driver, "//input[@id='editInvoice_invoice_terms']");
		clickElement(driver, test, OCR_NewDO_AddParty, "Click on Add Party");
		try {
			selectByVisibleText(driver, test, OCR_NewDO_EntityType, "Select Entity Type : ", EntityType);
			Wait.waitfor(3);
			clickElement(driver, test, OCR_NewDO_AddPartyCode, "Click on Add Party Code");
			typeText(driver, test, OCR_NewDO_ConsigneeCode, "Enter the Consignee Code : ", ConsigneeCode);
			clickElement(driver, test, OCR_NewDO_Search, "click on Search");
			clickElement(driver, test, "(//td[contains(text(),'" + ConsigneeCode + "')])[1]",
					"Click on Consignee Code : " + ConsigneeCode);
			clickElement(driver, test, OCR_NewDO_Select, "Click on Select");
			Wait.waitfor(5);
			clickElement(driver, test, OCR_NewDO_EntitySave, "click on Entity Save");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_NewDO_PopUpClose, "click on Pop up Close");
		}
	}

	// Adding the Container/Packing Details
	public void addContainerPackingDetails(String MarkingsContainerID, String SealNumber, String ConsolidatedPackNumber,
			String Hazardous, String RadioActivityAmnt, String DryIce, String GrossCartonWeight, String PackageType,
			String Model, String TareWeight, String DimensionUOM, String LenghtWidthHight, String WeightUOM,
			String GrossNet) {
		if (MarkingsContainerID.length() > 0) {
			Wait.waitfor(2);
			scrollToElement(driver, OCR_NewDO_AddContainerPackingDetailsBtn);
			Wait.waitfor(2);
			clickElement(driver, test, OCR_NewDO_AddContainerPackingDetailsBtn,
					"Click on Add Container Packing Details ");
			try {
				Wait.waitfor(3);
				typeText(driver, test, OCR_NewDO_MarkingsContainerID, "Enter the Marking Container ID : ",
						MarkingsContainerID);
				typeText(driver, test, OCR_NewDO_SealNumber, "Enter the Seal Number : ", SealNumber);
				typeText(driver, test, OCR_NewDO_ConsolidatedPackNumber, "Enter the Consolidated Pack Number : ",
						ConsolidatedPackNumber);
				selectByVisibleText(driver, test, OCR_NewDO_Hazardous, "Select the Hazardous : ", Hazardous);
				typeText(driver, test, OCR_NewDO_RadioActivityAmnt, "Enter the Radio Activity Amnt : ",
						RadioActivityAmnt);
				selectByVisibleText(driver, test, OCR_NewDO_DryIce, "Select the Dry Ice : ", DryIce);
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_TAB);
				r.keyRelease(KeyEvent.VK_TAB);
				Wait.waitfor(3);
				typeText(driver, test, OCR_NewDO_GrossCartonWeight, "Enter the Gross Carton Weight : ",
						GrossCartonWeight);
				typeText(driver, test, OCR_NewDO_PackageType, "Enter the Package Type : ", PackageType);
				typeText(driver, test, OCR_NewDO_Model, "Enter the MOdel : ", Model);
				typeText(driver, test, OCR_NewDO_TareWeight, "Enter the Tare Weight : ", TareWeight);

				selectByVisibleText(driver, test, OCR_NewDO_DimensionUOM, "Select the Dimension UOM : ", DimensionUOM);
				ArrayList<String> LWH = GenericMethods.stringtoken(LenghtWidthHight);
				if (DimensionUOM.contains("Inches")) {
					typeText(driver, test, OCR_NewDO_Dim_InchesL, "Enter the inches(lenght) : ", LWH.get(0));
					typeText(driver, test, OCR_NewDO_Dim_InchesW, "Enter the inches(width) : ", LWH.get(1));
					typeText(driver, test, OCR_NewDO_Dim_InchesH, "Enter the inches(Height) : ", LWH.get(2));
				}
				if (DimensionUOM.contains("Centimeters")) {
					typeText(driver, test, OCR_NewDO_Dim_CmL, "Enter the CM(lenght) : ", LWH.get(0));
					typeText(driver, test, OCR_NewDO_Dim_CmW, "Enter the CM(width) : ", LWH.get(1));
					typeText(driver, test, OCR_NewDO_Dim_CmH, "Enter the CM(Height) : ", LWH.get(2));
				}
				if (DimensionUOM.contains("Meters")) {
					typeText(driver, test, OCR_NewDO_Dim_ML, "Enter the M(lenght) : ", LWH.get(0));
					typeText(driver, test, OCR_NewDO_Dim_MW, "Enter the M(width) : ", LWH.get(1));
					typeText(driver, test, OCR_NewDO_Dim_MH, "Enter the M(Height) : ", LWH.get(2));
				}
				selectByVisibleText(driver, test, OCR_NewDO_WeightUOM, "Select the Weight UOM : ", WeightUOM);
				ArrayList<String> GN = GenericMethods.stringtoken(GrossNet);
				if (WeightUOM.contains("Kilograms")) {
					typeText(driver, test, OCR_NewDO_WeightKG_Gross, "Enter the KG(Gross) : ", GN.get(0));
					typeText(driver, test, OCR_NewDO_WeightKG_Net, "Enter the KG(Net) : ", GN.get(1));
				}
				if (WeightUOM.contains("Pounds")) {
					typeText(driver, test, OCR_NewDO_WeightLbs_Gross, "Enter the Pounds(Gross) : ", GN.get(0));
					typeText(driver, test, OCR_NewDO_WeightLbs_Net, "Enter the Pounds(Net) : ", GN.get(1));
				}

				Wait.waitfor(3);
				clickElement(driver, test, OCR_NewDO_ContainerSubmit,
						"click on Container/Packing Details Submit button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_NewDO_PopUpClose, "Click on Cancel popup icon");
			}
		}
	}

	// Click on Save
	public void clickSave() {
		scrollToElement(driver, OCR_NewDO_Save);
		scrollToTop(driver);
		clickElement(driver, test, OCR_NewDO_Save, "Click on Save");
	}

	// Click on Additional Transaction Details and Select items
	public void select_additems() {
		scrollToElement(driver, OCR_NewDO_AdditionalInformation);
		scrollToTop(driver);
		clickElement(driver, test, OCR_NewDO_AdditionalInformation, "Click on Additional Transaction Details");
		clickElement(driver, test, OCR_NewDO_items, "Click on Items");
	}

}
