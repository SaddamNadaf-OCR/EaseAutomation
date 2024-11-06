package productClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewProductGeneralInfoPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_PartNo = "//input[@id='editProduct_product_productCode']";
	public static final String OCR_SKUNo = "//input[@id='editProduct_product_skuNo']";
	public static final String OCR_Description = "//textarea[@id='editProduct_product_productDesc']";
	public static final String OCR_NationalStockNumber = "//input[@id='editProduct_product_nationalStockNumber']";
	public static final String OCR_ProductName = "//textarea[@id='editProduct_product_productName']";
	public static final String OCR_ProductLine = "//a[contains(text(),'Product Line')]";
	public static final String OCR_SchedulingAgreement = "//input[@id='editProduct_product_schedulingAgreement']";
	public static final String OCR_Program = "//div[5]/label/a";
	public static final String OCR_Commodity_Type = "//select[@id='editProduct_product_productType']";
	public static final String OCR_Site = "//a[contains(text(),'Site')]";
	public static final String OCR_PlantId = "//input[@id='editProduct_product_plantId']";
	public static final String OCR_ModelNo = "//input[@id='editProduct_product_modelNo']";
	public static final String OCR_NetWeight = "//input[@id='editProduct_netWeight']";
	public static final String OCR_MaterialType = "//input[@id='editProduct_product_bomType']";
	public static final String OCR_UOMForPrice = "//div[10]/label/a";
	public static final String OCR_FlagReason = "(//a[contains(text(),'Flag Reason')])[2]";
	public static final String OCR_UnitPrice = "//input[@id='editProduct_unitPrice']";
	public static final String OCR_Currency = "//div[7]/label[2]/a";
	public static final String OCR_Action = "//select[@id='editProduct_product_flagReasonAction']";
	public static final String OCR_SecurityClassification = "//select[@id='editProduct_product_securityClassId']";
	public static final String OCR_productOwner="//input[@id='editProduct_product_productOwner']";
	public static final String OCR_HazardousMaterial = "//input[@id='editProduct_hazardMaterial']";
	public static final String OCR_ApprovedBy = "//input[@id='editProduct_product_userCol1']";
	public static final String OCR_CompIsDesAuth = "//input[@id='editProduct_compIsDesAuth']";
	public static final String OCR_IsraelFTACertified = "//input[@id='editProduct_israelFTACertified']";
	public static final String OCR_SourceSystemId = "//input[@id='editProduct_product_sourceSystemId']";
	public static final String OCR_SourceSystemPartNo = "//input[@id='editProduct_product_sourceProductId']";
	public static final String OCR_Tsca12bCode = "//input[@id='editProduct_product_tsca12bCode']";
	public static final String OCR_MSDSNumber = "//input[@id='editProduct_product_msdsNumber']";
	public static final String OCR_CASNumber = "//input[@id='editProduct_product_casNumber']";
	public static final String OCR_Save = "(//button[contains(text(),'Save')])[1]";
	public static final String OCR_SaveandReturn = "//button[contains(text(),'Save & Return')]";
	public static final String OCR_Cancel = "//button[contains(text(),'Cancel')]";
	public static final String OCR_Select = "(//button[contains(text(),'Select')])[1]";
	public static final String OCR_Button_Forward = "html/body/div[2]/form/div[5]/div/div[2]/div/button[1]";
	public static final String OCR_Search = "(//button[contains(text(),'Search')])[1]";
	public static final String OCR_POPUpClose = "(//button[@type='button'][@class='btn-close'])[1]";
	public static final String OCR_HeaderAddinInformation="//label[contains(text(),'Additional Information')]";
	public static final String OCR_Segment="//textarea[@id='editProduct_product_segment']/../../label/a";
	
	/* ******************** Constructor ***************************** */
	public CreateNewProductGeneralInfoPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public void enter_partno(String PartNo) {
		//clearText(driver, test, OCR_PartNo, "Clear previous data");
		Wait.waitfor(2);
		// typeText(driver, test, OCR_PartNo, "Enter Part No", PartNo+randomnumbers());
		typeText(driver, test, OCR_PartNo, "Enter Part No", PartNo);
		Wait.waitfor(3);
	}

	public void enter_skuno(String SKUNo) {
		typeText(driver, test, OCR_SKUNo, "Enter Part No : ", SKUNo);

	}

	public void enter_description(String Description) {
		typeText(driver, test, OCR_Description, "Enter the Description : ", Description);
	}

	public void enter_nsNo(String NationalStockNumber) {
		typeText(driver, test, OCR_NationalStockNumber, "Enter the National Stock Number : ", NationalStockNumber);
	}

	public void enter_productname(String ProductName) {
		typeText(driver, test, OCR_ProductName, "Enter the Product name : ", ProductName);
	}

	public void click_productline() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ProductLine, "Clicking on Product Line");
	}

	// Add Product Line is Added to the Result grid or not
	public void addProductLineToResultsGrid(String ProductLine) {
		Wait.waitfor(5);
		String addProductline = "//table[@id='gridPopup']/tbody/tr[2]/td[contains(text(),'" + ProductLine + "')]";
		try {
			if (isDisplayed(driver, addProductline)) {
				clickElement(driver, test, addProductline, "Click on search record");
				test.log(LogStatus.PASS, "Add Product Line in add to result grid table : " + ProductLine);
				Wait.waitfor(4);
				select();
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to Add Product Line in result grid table : " + ProductLine);
			clickElement(driver, test, OCR_POPUpClose, "Click on POP up close Icon");
		}
	}

	public void enter_schedulingagreement(String SchedulingAgreement) {
		typeText(driver, test, OCR_SchedulingAgreement, "Enter Scheduling Agreement : ", SchedulingAgreement);
	}

	public void click_program(String Program) {
		Wait.waitfor(4);
		clickElement(driver, test, OCR_Program, "Click on Program link");
		typeText(driver, test, "//input[@id='searchForm_programTab_programCode']", "Enter the program name : ",
				Program);
	}

	// Add Program is Added to the Result grid or not
	public void addProgramToResultsGrid(String Program) {
		Wait.waitfor(3);
		String addProgram = "//table[@id='gridPopup']/tbody/tr[2]/td[contains(text(),'" + Program + "')]";
		// String addProgram= "//div[contains(text(), '\" + Program + \"')]";
		try {
			if (isDisplayed(driver, addProgram)) {
				clickElement(driver, test, addProgram, "Click on search record");
				test.log(LogStatus.PASS, "Add Product Line in add to result grid table : " + Program);
				Wait.waitfor(3);
				select();
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to Add Product Line in result grid table : " + Program);
			clickElement(driver, test, OCR_POPUpClose, "Click on POP up close Icon");
		}
	}

	public void enter_type(String CommodityType) {
		selectByVisibleText(driver, test, OCR_Commodity_Type, "Select commodity Type : ", CommodityType);
	}

	public void click_site(String Site) {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Site, "Clicking on Site Link");
		typeText(driver, test, "//input[@id='dosSitePopupForm_dosSite_siteName']", "Enter the site name : ", Site);
	}

	// Add Site is Added to the Result grid or not
	public void addSiteToResultsGrid(String Site) {
		Wait.waitfor(3);
		String addSite = "//td[contains(text(),'" + Site + "')]";
		try {
			if (isDisplayed(driver, addSite)) {
				clickElement(driver, test, addSite, "Click on search record");
				test.log(LogStatus.PASS, "Add Site in add to result grid table : " + Site);
				select();
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to Add Site in result grid table : " + Site);
			clickElement(driver, test, OCR_POPUpClose, "Click on POP up close Icon");
		}
	}

	public void enter_plantid(String PlantId) {
		typeText(driver, test, OCR_PlantId, "Enter the PlantId : ", PlantId);
	}

	public void enter_ModelNo(String ModelNo) {
		typeText(driver, test, OCR_ModelNo, "Enter the Model No : ", ModelNo);
	}

	public void enter_netweight(String NetWeight) {
		typeText(driver, test, OCR_NetWeight, "Enter the Net Weight : ", NetWeight);
	}

	public void enter_materialtype(String MaterialType) {
		typeText(driver, test, OCR_MaterialType, "Enter the Material Type : ", MaterialType);
	}

	public void click_uomforprice() {
		clickElement(driver, test, OCR_UOMForPrice, "Clicking on UOM Link");
	}

	// Add UOM is Added to the Result grid or not
	public void addUOMToResultsGrid(String UOMForPrice) {
		Wait.waitfor(3);
		String addUOM = "//table[@id='gridPopup']/tbody/tr/td[contains(text(),'" + UOMForPrice + "')]";
		try {
			if (isDisplayed(driver, addUOM)) {
				clickElement(driver, test, addUOM, "Click on search record");
				test.log(LogStatus.PASS, "Add UOM in add to result grid table : " + UOMForPrice);
				select();
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to Add UOM in result grid table : " + UOMForPrice);
			clickElement(driver, test, OCR_POPUpClose, "Click on POP up close Icon");
		}
	}

	public void click_flagreason(String FlagReason) {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_FlagReason, "Clicking on Flag Reason Link");
		typeText(driver, test, "//input[@id='flagReasonPopupForm_flagReason_reasonCode']", "Enter the Reason Code : ",
				FlagReason);
	}

	// Add FlagReason is Added to the Result grid or not
	public void addFRToResultsGrid(String FlagReason) {
		Wait.waitfor(3);
		String addFR = "//table[@id='gridPopup']/tbody/tr/td[contains(text(),'" + FlagReason + "')]";
		try {
			if (isDisplayed(driver, addFR)) {
				clickElement(driver, test, addFR, "Click on search record");
				test.log(LogStatus.PASS, "Add FlagReason in add to result grid table : " + FlagReason);
				select();
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to Add FlagReason in result grid table : " + FlagReason);
			clickElement(driver, test, OCR_POPUpClose, "Click on POP up close Icon");
		}
	}

	public void enter_unitprice(String UnitPrice) {
		typeText(driver, test, OCR_UnitPrice, "Enter the Unit Price : ", UnitPrice);
	
	}
	public void click_currency() {
		clickElement(driver, test, OCR_Currency, "Clicking on Currency Link");
	}

	// Add Currency is Added to the Result grid or not
	public void addCurrencyToResultsGrid(String Currency) {
		Wait.waitfor(3);
		String addCurrency = "//table[@id='gridPopup']/tbody/tr/td[contains(text(),'" + Currency + "')]";
		try {
			if (isDisplayed(driver, addCurrency)) {
				clickElement(driver, test, addCurrency, "Click on search record");
				test.log(LogStatus.PASS, "Add Currency in add to result grid table : " + Currency);
				select();
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to Add  Currency in result grid table : " + Currency);
			clickElement(driver, test, OCR_POPUpClose, "Click on POP up close Icon");
		}
	}


	
	public void enter_securityclassification(String SecurityClassification) {
		selectByVisibleText(driver, test, OCR_SecurityClassification, "Select Security Classification",
				SecurityClassification);
	}

	public void enter_action(String Action) {
		selectByVisibleText(driver, test, OCR_Action, "Select the Action", Action);
	}

	public void enter_hazardousmaterial(String HazardousMaterial) {
		Wait.waitfor(3);
		if (HazardousMaterial.equalsIgnoreCase("Y")) {
			clickElement(driver, test, OCR_HazardousMaterial, "Check Hazardous Material Checkbox");
		}
	}

	public void enter_approvedby(String ApprovedBy) {
		typeText(driver, test, OCR_ApprovedBy, "Enter the Approved By : ", ApprovedBy);
	}

	public void enter_compisdesauth(String CompIsDesAuth) {
		if (CompIsDesAuth.equalsIgnoreCase("Y")) {
			clickElement(driver, test, OCR_CompIsDesAuth, "Check Company Is Design Authority Checkbox");
		}
	}

	public void enter_IsraelFTACertified(String IsraelFTACertified) {
		if (IsraelFTACertified.equalsIgnoreCase("Y")) {
			clickElement(driver, test, OCR_IsraelFTACertified, "Check Israel FTA Certified Checkbox");
		}
	}

	public void enter_SourceSystemId(String SourceSystemId) {
		/*
		 * scrollToElement(driver,
		 * "//label[contains(text(),'Additional Information')]"); Wait.waitfor(3);
		 * clickElement(driver, test,
		 * "//label[contains(text(),'Additional Information')]",
		 * "Click on Additional Information");
		 */
		Wait.waitfor(3);
		typeText(driver, test, OCR_SourceSystemId, "Enter the Source System Id : ", SourceSystemId);
	}

	public void enter_SourceSystemPartNo(String SourceSystemPartNo) {
		typeText(driver, test, OCR_SourceSystemPartNo, "Enter the Source System Part No : ", SourceSystemPartNo);
	}

	public void enter_TSCA12bCode(String Tsca12bCode) {
		typeText(driver, test, OCR_Tsca12bCode, "Enter the TSCA 12b code : ", Tsca12bCode);
	}

	public void enter_MSDSNumber(String MSDSNumber) {
		typeText(driver, test, OCR_MSDSNumber, "Enter the MSDS Number : ", MSDSNumber);
	}

	public void enter_CASNumber(String CASNumber) {
		typeText(driver, test, OCR_CASNumber, "Enter the MSDS Number : ", CASNumber);
	}

	public void save() {
		scrollToElement(driver, OCR_Save);
		Wait.waitfor(3);
		scrollToTop(driver);
		clickElement(driver, test, OCR_Save, "Click on Save Button ");
	}

	public void select() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Select, "Click on Select Button ");
		Wait.waitfor(3);
	}

	public void search() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Search, "Click on Search Button ");
	}

	public void moveForward() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Button_Forward, "Click on Forward Button ");
	}

	public void movetoclassificationtab() {
		Wait.waitfor(3);
		clickElement(driver, test, "//a[@id='tab2']", "Clicking on Classification Tab ");

	}

	// Validate General Info Tab
	public void validate_GeneralInfoError() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {
				if (isDisplayed(driver, "//li[contains(text(),'Product Description')]")) {
					test.log(LogStatus.INFO, "Product Description is required");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error Validation is not Displayed by clicking on SAVE button in General Info Page");
		}
	}

	public void movetonotestab() {
		clickElement(driver, test, "//a[@id='tab7']", "Clicking on Notes Tab");
	}

	public void movetoimagestab() {
		clickElement(driver, test, "//a[@id='tab9']", "Clicking on Image Tab");
	}

	public void movetodocumenttab() {
		clickElement(driver, test, "//a[@id='tab6']", "Clicking on Document tab");
	}

	public void movetosubcomponenttab() {
		clickElement(driver, test, "//a[@id='tab4']", "Click on Sub Component Tab");
	}

	public void movetomanufacturertab() {
		clickElement(driver, test, "//a[@id='tab3']", "Clicking on Manufacturer Tab");

	}

	public void ScrolltoSecurityClasiification() {
		scrollToElement(driver, OCR_SecurityClassification);
	}
	public void ScrolltoProductOwner() {
		scrollToElement(driver, OCR_HazardousMaterial);
	}

	public void Scrolltobottom() {
		scrollToBottom(driver);
	}
	public void ClickOnHeader() {
		clickElement(driver, test, OCR_HeaderAddinInformation, "click on Additional Information Header");
	}
	
	public void segmentclick(String Segment) {
		
	
	if (Segment.length() > 0) {
		Wait.waitfor(5);
		clickElement(driver, test, OCR_Segment, "Click oon segment");
		try {
			String seg = "//td[contains(text(),'" + Segment + "')]";
			clickElement(driver, test, seg, "Click on segment :" + Segment);
			clickElement(driver, test, OCR_Select, "Click segment Select button");
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to add the segment");
			clickElement(driver, test, OCR_POPUpClose, "Close the Pop UP");
		}
	}
	}}
	
	

