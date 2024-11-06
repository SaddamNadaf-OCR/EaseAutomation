package globalExportClasses;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewSalesOrderPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_CreateNewSalesOrderPage_OrderNo = "//input[@name='invoice.invoiceNo']";
	public static final String OCR_CreateNewSalesOrderPage_UltDestination = "//input[@name='invoice.countryOfUltDest']";
	public static final String OCR_CreateNewSalesOrderPage_MOT = "(//a[contains(text(),'Mode of Transport')])[2]";
	public static final String OCR_CreateNewSalesOrderPage_SelectMOT = "//button[contains(@name,'Ok')]";
	public static final String OCR_CreateNewSalesOrderPage_CloseMOTPopUp = "//button[contains(@class,'btn-close')]";
	public static final String OCR_CreateNewSalesOrderPage_AddPartyBtn = "//button[contains(text(),'Add Party')]";
	public static final String OCR_CreateNewSalesOrderPage_SelectEntityType = "//select[@id='selectedParty']";
	public static final String OCR_CreateNewSalesOrderPage_EntityCode = "//a[contains(@name,'entityCodeLink')]";
	public static final String OCR_CreateNewSalesOrderPage_Status = "//select[@name='popupValue.status']";
	public static final String OCR_CreateNewSalesOrderPage_ConsigneeCode = "//input[@id='resultConsigneeWithContactPopup_popupValue_code']";
	public static final String OCR_CreateNewSalesOrderPage_SearchConsignee = "//button[@name='Search']";
	public static final String OCR_CreateNewSalesOrderPage_SelectConsignee = "//button[@name='Ok']";
	public static final String OCR_CreateNewSalesOrderPage_CloseBtnConsignee = "//button[@class='btn-close']";
	public static final String OCR_CreateNewSalesOrderPage_AddPartySaveBtn = "//button[@id='entitySave']";
	public static final String OCR_CreateNewSalesOrderPage_AddContainerBtn = "//button[@id='addCartonBtn']";
	public static final String OCR_CreateNewSalesOrderPage_MarkingContainerID = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_marking']";
	public static final String OCR_CreateNewSalesOrderPage_DimensionUOM = "//select[@id='dimensionUom']";
	public static final String OCR_CreateNewSalesOrderPage_DimInchesL = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_length']";
	public static final String OCR_CreateNewSalesOrderPage_DimInchesW = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_width']";
	public static final String OCR_CreateNewSalesOrderPage_DimInchesH = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_height']";
	public static final String OCR_CreateNewSalesOrderPage_DimCmL = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_lengthCm']";
	public static final String OCR_CreateNewSalesOrderPage_DimCmW = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_widthCm']";
	public static final String OCR_CreateNewSalesOrderPage_DimCmH = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_heightCm']";
	public static final String OCR_CreateNewSalesOrderPage_DimML = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_lengthMt']";
	public static final String OCR_CreateNewSalesOrderPage_DimMW = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_widthMt']";
	public static final String OCR_CreateNewSalesOrderPage_DimMH = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_heightMt']";
	public static final String OCR_CreateNewSalesOrderPage_WeightUOM = "//select[@id='editTabbedInvoiceCarton_invoiceCarton_widthUom']";
	public static final String OCR_CreateNewSalesOrderPage_WeightKG_Gross = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_grossWeightKg']";
	public static final String OCR_CreateNewSalesOrderPage_WeightKG_Net = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_netWeightKg']";
	public static final String OCR_CreateNewSalesOrderPage_WeightLbs_Gross = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_grossWeightLbs']";
	public static final String OCR_CreateNewSalesOrderPage_WeightLbs_Net = "//input[@id='editTabbedInvoiceCarton_invoiceCarton_netWeight']";
	public static final String OCR_CreateNewSalesOrderPage_ContainerSubmit = "//button[@id='btnSave']";
	public static final String OCR_CreateNewSalesOrderPage_AdditionalInformation = "//i[@class='fa fa-th']";
	public static final String OCR_CreateNewSalesOrderPage_Items = "//a[@class='eo-tab'][contains(text(),'Items')]";

	/* ******************************* Constructor ****************************** */

	public CreateNewSalesOrderPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Adding the Add Sales Order Button action

	public void sales_Order_Details(String orderNo, String ultDest, String ModeOfTransport) {
		typeText(driver, test, OCR_CreateNewSalesOrderPage_OrderNo, "Enter Order Number : ", orderNo);
		typeText(driver, test, OCR_CreateNewSalesOrderPage_OrderNo, "Enter  Random ShipmentNo : ", randomnumbers());
		typeText(driver, test, OCR_CreateNewSalesOrderPage_UltDestination, "Enter Ultimate Destination : ", ultDest);
		try {
			if (ModeOfTransport.length() > 0) {
				Wait.waitfor(2);
				clickElement(driver, test, OCR_CreateNewSalesOrderPage_MOT, "Click on Mode Of Transport");
				clickElement(driver, test, "//td[contains(text(),'" + ModeOfTransport + "')]",
						"Click on Mode Of transport : " + ModeOfTransport);
				clickElement(driver, test, OCR_CreateNewSalesOrderPage_SelectMOT, "Click on Select button");

			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_CreateNewSalesOrderPage_CloseMOTPopUp, "Click on Pop up Close button");
		}

	}

	// Adding the Parties to the Transaction
	public void addPartiesToTheTransaction(String EntityType, String entityCode, String Status) {
		scrollToElement(driver, OCR_CreateNewSalesOrderPage_AddPartyBtn);
		clickElement(driver, test, OCR_CreateNewSalesOrderPage_AddPartyBtn, "Click on Add Party Button");
		selectByVisibleText(driver, test, OCR_CreateNewSalesOrderPage_SelectEntityType, "Select Entity Type : ",
				EntityType);
		if (entityCode.length() > 0) {
			try {
				clickElement(driver, test, OCR_CreateNewSalesOrderPage_EntityCode, "Click on Entity Code");
				selectByVisibleText(driver, test, OCR_CreateNewSalesOrderPage_Status, "Select Status : ", Status);
				typeText(driver, test, OCR_CreateNewSalesOrderPage_ConsigneeCode, "Enter Consignee Code : ",
						entityCode);
				clickElement(driver, test, OCR_CreateNewSalesOrderPage_SearchConsignee, "Click on Search Button");
				clickElement(driver, test, "//td[contains(text(),'" + entityCode + "')]",
						"Select the Consignee : " + entityCode);
				clickElement(driver, test, OCR_CreateNewSalesOrderPage_SelectConsignee, "Click on Select button");
				scrollToBottom(driver);
				clickElement(driver, test, OCR_CreateNewSalesOrderPage_AddPartySaveBtn, "Click on Save Button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_CreateNewSalesOrderPage_CloseBtnConsignee, "Click on Close popup icon");
			}
		}
	}

	// Add the program
	public void addprogram(String Program) {
		clickElement(driver, test, "(//a[contains(text(),'Program')])[3]", "Click on Program Link");
		try {
			typeText(driver, test, "//input[@id='searchForm_programTab_programCode']", "Enter the Program Code : ",
					Program);
			clickElement(driver, test, OCR_CreateNewSalesOrderPage_SearchConsignee, "Click on Search :");
			clickElement(driver, test, "//td[contains(text(),'" + Program + "')]", "Select the Consignee : " + Program);
			clickElement(driver, test, OCR_CreateNewSalesOrderPage_SelectConsignee, "Click on Select button :");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_CreateNewSalesOrderPage_CloseBtnConsignee, "Click on Close popup icon :");
		}

	}

	// Adding Container/Packing Details
	public void containerDetails(String containerID, String DimensionUOM, String LenghtWidthHight, String WeightUOM,
			String GrossNet) {
		clickElement(driver, test, OCR_CreateNewSalesOrderPage_AddContainerBtn,
				"Click on Add Container/packing Details button");
		typeText(driver, test, OCR_CreateNewSalesOrderPage_MarkingContainerID, "Enter Markings/container ID : ",
				containerID);
		selectByVisibleText(driver, test, OCR_CreateNewSalesOrderPage_DimensionUOM, "Select the Dimension UOM : ",
				DimensionUOM);
		ArrayList<String> LWH = GenericMethods.stringtoken(LenghtWidthHight);
		if (DimensionUOM.contains("Inches")) {
			typeText(driver, test, OCR_CreateNewSalesOrderPage_DimInchesL, "Enter the inches(lenght) : ", LWH.get(0));
			typeText(driver, test, OCR_CreateNewSalesOrderPage_DimInchesW, "Enter the inches(width) : ", LWH.get(1));
			typeText(driver, test, OCR_CreateNewSalesOrderPage_DimInchesH, "Enter the inches(Height) : ", LWH.get(2));
		}
		selectByVisibleText(driver, test, OCR_CreateNewSalesOrderPage_WeightUOM, "Select the Weight UOM : ", WeightUOM);
		ArrayList<String> GN = GenericMethods.stringtoken(GrossNet);
		if (WeightUOM.contains("Kilograms")) {
			typeText(driver, test, OCR_CreateNewSalesOrderPage_WeightKG_Gross, "Enter the KG(Gross) : ", GN.get(0));
			typeText(driver, test, OCR_CreateNewSalesOrderPage_WeightKG_Net, "Enter the KG(Net) : ", GN.get(1));
		}
		Wait.waitfor(3);
		clickElement(driver, test, OCR_CreateNewSalesOrderPage_ContainerSubmit,
				"click on Container/Packing Details Submit button");
	}

	// click on Additional Information icon and select Items option
	public void select_Items() {
		scrollToElement(driver, OCR_CreateNewSalesOrderPage_AdditionalInformation);
		scrollToTop(driver);
		clickElement(driver, test, OCR_CreateNewSalesOrderPage_AdditionalInformation,
				"Click on Additional Information tab");
		clickElement(driver, test, OCR_CreateNewSalesOrderPage_Items,
				"Select Items option from Additional Information tab");
	}

	public String gettingSalesOrderNo() {
		return getAttribute(driver, test, "//span[@class='heading-additional']/span", "innerText",
				"Get the Sales Order Number : ");
	}

}
