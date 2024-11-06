package globalTradeControlClasses;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilities.GenericMethods;
import utilities.Wait;

public class GtcNewScreeningPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_GtcNewScreening_HeaderReferenceNo = "//input[@id='editExportControlScreening_gtcGeneralInfoValue_clientRefNo']";
	public static final String OCR_GtcNewScreening_HeaderExportCountry = "//input[@id='editExportControlScreening_gtcGeneralInfoValue_exportCountry']";
	public static final String OCR_GtcNewScreening_HeaderImportCountry = "//input[@id='editExportControlScreening_gtcGeneralInfoValue_importCountry']";
	public static final String OCR_GtcNewScreening_ExportControl = "//select[@id='exportControlCountry']";
	public static final String OCR_GtcNewScreening_SubComponentLicenseScreening = "//input[@id='screeningtype1']";
	public static final String OCR_GtcNewScreening_ExportLicenseScreening = "//input[@id='screeningtype2']";
	public static final String OCR_GtcNewScreening_DocumentationRequirementScreening = "//input[@id='screeningtype3']";
	public static final String OCR_GtcNewScreening_ImportControlScreening = "//input[@id='screeningtype4']";
	public static final String OCR_GtcNewScreening_SourceFile = "//select[@id='editExportControlScreening_entityType']";
	public static final String OCR_GtcNewScreening_EntityCode = "//a[@id='namePopop']";
	public static final String OCR_GtcNewScreening_EntityStatus = "//select[@id='searchForm_consignee_status']";
	public static final String OCR_GtcNewScreening_ConsigneeId = "//input[@id='searchForm_consignee_consigneeId']";
	public static final String OCR_GtcNewScreening_ConsigneeSearch = "//button[@name='Search']";
	public static final String OCR_GtcNewScreening_ConsigneeNameSelect = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_GtcNewScreening_EntityName = "//input[@id='editExportControlScreening_entityName']";
	public static final String OCR_GtcNewScreening_EntityAddress1 = "//input[@id='editExportControlScreening_entityAddress1']";
	public static final String OCR_GtcNewScreening_EntityAddress2 = "//input[@id='editExportControlScreening_entityAddress2']";
	public static final String OCR_GtcNewScreening_EntityAddress3 = "//input[@id='editExportControlScreening_entityAddress3']";
	public static final String OCR_GtcNewScreening_EntityRole = "//input[@id='entity-role-selectized']";
	public static final String OCR_GtcNewScreening_EntityCity = "//input[@id='editExportControlScreening_entityCity']";
	public static final String OCR_GtcNewScreening_EntityState = "//input[@id='editExportControlScreening_entityState']";
	public static final String OCR_GtcNewScreening_EntityCountry = "//input[@id='editExportControlScreening_entityCountryName']";
	public static final String OCR_GtcNewScreening_EntityZip = "//input[@id='editExportControlScreening_entityZip']";
	public static final String OCR_GtcNewScreening_ClickOutside = "//label[contains(text(),'Entity Role')]";
	public static final String OCR_GtcNewScreening_EntityAdd = "//button[@id='wlsAddBtn']";
	public static final String OCR_GtcNewScreening_EntitySave = "(//button[contains(text(),'Save')])[1]";
	public static final String OCR_GtcNewScreening_PopupClose = "//div[@id='ocrModal']//button[@class='close']";
	public static final String OCR_GtcNewScreening_PartNoLink = "//a[@id='partNoPopupId']";
	public static final String OCR_GtcNewScreening_EnterPartNo = "//input[@id='searchForm_product_productCode']";
	public static final String OCR_GtcNewScreening_ClickSelect = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";

	public static final String OCR_GtcNewScreening_ExportClassificationLink = "//a[@id='ecnPopup']";
	public static final String OCR_GtcNewScreening_EnterECCN = "//input[@id='searchForm_productClazz_prodClassification']";
	public static final String OCR_GtcNewScreening_UnitPrice = "//input[@id='editExportControlScreening_unitPrice']";
	public static final String OCR_GtcNewScreening_Value = "//input[@id='editExportControlScreening_value']";
	public static final String OCR_GtcNewScreening_Currency = "//input[@id='editExportControlScreening_currency']";
	public static final String OCR_GtcNewScreening_Enduse = "//select[@id='editExportControlScreening_endUse']";
	public static final String OCR_GtcNewScreening_ImportClassificationLink = "//a[@id='ecnPopupImport']";
	public static final String OCR_GtcNewScreening_ImportItem = "//input[@id='searchForm_ukItemsDTO_prodClassification']";

	public static final String OCR_GtcNewScreening_EnterHSNo = "//input[@id='hsNo_resultStdHsPopup']";
	public static final String OCR_GtcNewScreening_SearchHSNo = "//button[@id='searchHsDtlBtn']";
	public static final String OCR_GtcNewScreening_SelectHSNo = "//div[contains(text(),'01012100')]";
	public static final String OCR_GtcNewScreening_SelectButton = "//button[@id='slctBtn']";
	public static final String OCR_GtcNewScreening_Qty = "//input[@id='editExportControlScreening_quantity']";
	public static final String OCR_GtcNewScreening_Uom = "//input[@id='editExportControlScreening_uom']";
	public static final String OCR_GtcNewScreening_ExportExceptionLink = "//a[@id='expExceptionPopup']";
//	public static final String OCR_GtcNewScreening_AuthorizationType = "//input[@id='licTypePopupForm_licenseTypes_licenseType']";
	public static final String OCR_GtcNewScreening_AuthorizationType = "//textarea[@id='licTypePopupForm_licenseTypes_licenseType']";
	public static final String OCR_GtcNewScreening_AuthorizationTypeSearch = "(//button[@name='Search'])[1]";
	public static final String OCR_GtcNewScreening_ClickCode = "//tr[@id='1']//td[3]";
	public static final String OCR_GtcNewScreening_ClickSelectCode = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_GtcNewScreening_CountryOfOrigin = "//div[@id='SHOW_ITEM']//input[@id='editExportControlScreening_entityCountryName']";
	public static final String OCR_GtcNewScreening_EndUserType = "//select[@id='editExportControlScreening_endUserType']";
	public static final String OCR_GtcNewScreening_AddBtn = "//button[@id='licenseAddBtn']";
	public static final String OCR_GtcNewScreening_PageHeading = "//h3[@class='page-heading']";
	public static final String OCR_GtcNewScreening_ScreenBtn = "//div[@class='row btn-row']//button[@class='primary-btn'][contains(text(),'Screen')]";
	public static final String OCR_GtcNewScreening_LicenseScreeningBtn = "//a[@class='usLicenseScreening']";
	public static final String OCR_GtcNewScreening_DocumentationRequirementBtn = "//a[@class='documentRequirment']";
	public static final String OCR_GtcNewScreening_pageheader="//h3[@class='page-heading']";
	
	/* ******************************* Constructor ****************************** */

	public GtcNewScreeningPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Enter Header Details
	public void headerDetails(String ClientReferenceNo, String ExportCountry, String ImportCountry,
			String ScreeningType, String ExportControl) throws InterruptedException {
		Wait.waitfor(2);
		typeText(driver, test, OCR_GtcNewScreening_HeaderReferenceNo, "Enter Reference No : ",
				ClientReferenceNo + randomnumbers());
		typeText(driver, test, OCR_GtcNewScreening_HeaderExportCountry, "Enter Export Country : ", ExportCountry);
		Wait.waitfor(2);
		typeText(driver, test, OCR_GtcNewScreening_HeaderImportCountry, "Enter Import Country : ", ImportCountry);
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_GtcNewScreening_ExportControl, "Select the Country of Export Control : ", ExportControl);

		if (ScreeningType.equalsIgnoreCase("Watch-List Screening")) {
			clickElement(driver, test, OCR_GtcNewScreening_SubComponentLicenseScreening,
					"Uncheck the SubComponent License Screening");
			clickElement(driver, test, OCR_GtcNewScreening_ExportLicenseScreening, "Uncheck the Export License Screening");
			clickElement(driver, test, OCR_GtcNewScreening_DocumentationRequirementScreening,
					"Uncheck the Documentation Requirement Screening");
			clickElement(driver, test, OCR_GtcNewScreening_ImportControlScreening, "Uncheck the Import Control Screening");
		}
	}

	// Enter Entity Details
	public void entityDetails(String SourceFile, String ConsigneeId, String EntityName, String EntityAddress1,
			String EntityAddress2, String EntityAddress3, String EntityRole, String EntityCity, String EntityState,
			String EntityCountry, String EntityZip, String EntityStatus) throws InterruptedException, Exception {
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_GtcNewScreening_SourceFile, "Select Source File : ", SourceFile);
		if ((ConsigneeId.equalsIgnoreCase("No"))) {
			typeText(driver, test, OCR_GtcNewScreening_EntityName, "Enter Entity Name : ", EntityName);
			typeText(driver, test, OCR_GtcNewScreening_EntityAddress1, "Enter Entity Address1 : ", EntityAddress1);
			typeText(driver, test, OCR_GtcNewScreening_EntityAddress2, "Enter Entity Address2 : ", EntityAddress2);
			typeText(driver, test, OCR_GtcNewScreening_EntityAddress3, "Enter Entity Address3 : ", EntityAddress3);
			Wait.waitfor(3);
			typeText(driver, test, OCR_GtcNewScreening_EntityCity, "Enter Entity City : ", EntityCity);
			typeText(driver, test, OCR_GtcNewScreening_EntityCountry, "Enter Entity Country : ", EntityCountry);
			Wait.waitfor(4);
			String state = "//div[contains(text(),'" + EntityState + "')]";
			typeText(driver, test, OCR_GtcNewScreening_EntityState, "Enter Entity State : ", EntityState);
			Wait.waitfor(2);
			clickElement(driver, test, state, "Click State :" + EntityState);
			typeText(driver, test, OCR_GtcNewScreening_EntityZip, "Enter Entity Zip : ", EntityZip);
		} else {
			clickElement(driver, test, OCR_GtcNewScreening_EntityCode, "Click Entity Code");
			Wait.waitfor(2);
			try {
				selectByVisibleText(driver, test, OCR_GtcNewScreening_EntityStatus, "Select Entity Status : ",
						EntityStatus);
				Wait.waitfor(2);
				typeText(driver, test, OCR_GtcNewScreening_ConsigneeId, "Enter Consignee Id : ", ConsigneeId);
				clickElement(driver, test, OCR_GtcNewScreening_ConsigneeSearch, "Click Consignee Search");
				String consigid = "//td[contains(text(),'" + ConsigneeId + "')]";
				clickElement(driver, test, consigid, "Click Consignee Id : " + ConsigneeId);
				clickElement(driver, test, OCR_GtcNewScreening_ConsigneeNameSelect, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_GtcNewScreening_PopupClose, "Click on Popup Close");
			}
			if (EntityStatus.equalsIgnoreCase("On Hold")) {
				String statusmsg = "This entity is on hold,Press OK to continue or Cancel to select a different entity.";
				AlertPopUp(driver, test, statusmsg);
			}
		}
		Wait.waitfor(3);
		clickElement(driver, test, OCR_GtcNewScreening_EntityRole, "Click on Entity Role");
		typeText(driver, test, OCR_GtcNewScreening_EntityRole, "Enter Entity Role : ", EntityRole);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_GtcNewScreening_ClickOutside, "Click Outside");
		Wait.waitfor(3);
		scrollToBottom(driver);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_GtcNewScreening_EntityAdd, "Click on Add Entity");
	}

	// Click on Entity Save button
	public void saveNewScreening() throws InterruptedException {
		mouseOverAndClick(driver, test, OCR_GtcNewScreening_EntitySave, " Click on Entity Save");
	}
public void scrolltosavescreen() {
	scrollToElement(driver, OCR_GtcNewScreening_EntitySave);
}

	// validating the Table Getting Added in New Screening Page
	public void validate_newScreening(String EntityRole) {
		try {
			String entityTable = "//table[@id='murauTable']/tbody/tr/td[contains(text(),'" + EntityRole + "')]";
			if (isDisplayed(driver, entityTable)) {
				test.log(LogStatus.PASS, "Entity Role is Added in result grid table : " + EntityRole);
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to Add Item in result grid table : " + EntityRole);
		}
	}

	// validating the Mandatory Field in New Screening Page
	public void validateHeaderDetailsError() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {

				if (isDisplayed(driver, "//li[contains(text(),'Add at least one Entity Screening details')]")) {
					test.log(LogStatus.INFO, "Add at least one Entity Screening details");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Select Country of Export')]")) {
					test.log(LogStatus.INFO, "Select Country of Export");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Select Country of Import')]")) {
					test.log(LogStatus.INFO, "Select Country of Import");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error Vaildation is not Displayed by clicking on SAVE button in Header Details");
		}
	}

	// Enter Item Details
	public void itemDetails(String PartNo, String ECCNumber, String ClassificationItem, String UnitPrice,
			String Quantity, String UOM, String Value, String AuthorizationType, String Currency,
			String CountryOfOrigin, String Enduse, String EndUserType) {
		scrollToElement(driver, "//label[contains(text(),'Item Details')]");
		Wait.waitfor(3);
		if (PartNo.length() > 0) {
			clickElement(driver, test, OCR_GtcNewScreening_PartNoLink, "Click on Part no Link");
			Wait.waitfor(4);
			try {
				typeText(driver, test, OCR_GtcNewScreening_EnterPartNo, "Enter the Part no : ", PartNo);
				clickElement(driver, test, OCR_GtcNewScreening_ConsigneeSearch, "Click on Search button");
				Wait.waitfor(4);
				String productCode = "//td[contains(text(),'" + PartNo + "')]";
				clickElement(driver, test, productCode, "Click on Product code : " + PartNo);
				Wait.waitfor(3);
				clickElement(driver, test, OCR_GtcNewScreening_ClickSelect, "Click on Select button");
				Wait.waitfor(3);
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_GtcNewScreening_PopupClose, "Click on Popup Close");
			}
		}
		scrollToElement(driver, "//label[contains(text(),'Item Details')]");
		Wait.waitfor(3);

		clickElement(driver, test, OCR_GtcNewScreening_ExportClassificationLink, "Click Export Classification link");
		try {
			typeText(driver, test, OCR_GtcNewScreening_EnterECCN, "Enter ECCN/USML : ", ECCNumber);
			clickElement(driver, test, OCR_GtcNewScreening_ConsigneeSearch, "Click on Search button");
			Wait.waitfor(3);
			String productClasftion = "//td[contains(text(),'" + ECCNumber + "')]";
			Wait.waitfor(3);
			clickElement(driver, test, productClasftion, "Click on Product Classification : " + ECCNumber);
			Wait.waitfor(3);
			clickElement(driver, test, OCR_GtcNewScreening_ClickSelect, "Click on Select button");
			Wait.waitfor(3);
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_GtcNewScreening_PopupClose, "Click on Popup Close");
		}
		scrollToElement(driver, "//label[contains(text(),'Item Details')]");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_GtcNewScreening_ImportClassificationLink, "Click Import Classification link");
		try {
			// typeText(driver, test, OCR_GtcNewScreening_ImportItem, "Enter Item : ",
			// ClassificationItem);
			typeText(driver, test, OCR_GtcNewScreening_EnterHSNo, "Enter Item : ", ClassificationItem);
			clickElement(driver, test, OCR_GtcNewScreening_SearchHSNo, "Click on Search button");
			// String item = "//td[contains(text(),'" + ClassificationItem + "')]";
			String item = "//div[contains(text(),'" + ClassificationItem + "')]";
			Wait.waitfor(3);
			clickElement(driver, test, item, "Click on Item : " + ClassificationItem);
			Wait.waitfor(3);
			// clickElement(driver, test, OCR_GtcNewScreening_ClickSelect, "Click on Select
			// button");
			clickElement(driver, test, OCR_GtcNewScreening_SelectButton, "Click on Select button");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_GtcNewScreening_PopupClose, "Click on Popup Close");
		}
		typeText(driver, test, OCR_GtcNewScreening_UnitPrice, "Enter the Unit price : ", UnitPrice);
		typeText(driver, test, OCR_GtcNewScreening_Qty, "Enter the Quantity : ", Quantity);
		typeText(driver, test, OCR_GtcNewScreening_Uom, "Enter the UOM : ", UOM);
		typeText(driver, test, OCR_GtcNewScreening_Value, "Enter the Value : ", Value);
		if (AuthorizationType.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_GtcNewScreening_ExportExceptionLink, "Click Export Exceptions link");
			try {
				typeText(driver, test, OCR_GtcNewScreening_AuthorizationType, "Enter AuthorizationType : ",
						AuthorizationType);
				clickElement(driver, test, OCR_GtcNewScreening_AuthorizationTypeSearch, "Click on Search button");
				String Code = "//td[contains(text(),'" + AuthorizationType + "')]";
				Wait.waitfor(3);
				clickElement(driver, test, Code, "Click on Code : " + AuthorizationType);
				Wait.waitfor(3);
				clickElement(driver, test, OCR_GtcNewScreening_ClickSelect, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_GtcNewScreening_PopupClose, "Click on Popup Close");
			}
		}
		typeText(driver, test, OCR_GtcNewScreening_Currency, "Enter the Currency : ", Currency);
		typeText(driver, test, OCR_GtcNewScreening_CountryOfOrigin, "Enter the country of Origin : ", CountryOfOrigin);
		selectByVisibleText(driver, test, OCR_GtcNewScreening_Enduse, "Select the End Use : ", Enduse);
		selectByVisibleText(driver, test, OCR_GtcNewScreening_EndUserType, "Select the End User Type : ", EndUserType);
	}

	// click on add item button
	public void click_addItembutton() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_GtcNewScreening_AddBtn, "Click on Add item button");
		
	}

	// click on screen button
	public void click_screenbtn() {
		scrollToElement(driver, OCR_GtcNewScreening_ScreenBtn);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_GtcNewScreening_ScreenBtn, "click on Screen button");
		Wait.waitfor(5);
	}

	// click on License Screening screen
	public void click_licensescreeningbtn() {
		clickElement(driver, test, OCR_GtcNewScreening_LicenseScreeningBtn, "click on License Screen button");
	}

	// click on Documentation Requirement screen
	public void click_documentationrequirementbtn() {
		clickElement(driver, test, OCR_GtcNewScreening_DocumentationRequirementBtn,
				"click on Documentation Screen button");
	}

	// Error message in Entity details notes
	public void entitydetailsvalidation() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error!')]")) {
				if (isDisplayed(driver, "//li[contains(text(),'Add at least one Entity Screening details')]")) {
					test.log(LogStatus.INFO, "Add at least one Entity Screening details");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error Vaildation is not Displayed by clicking on SAVE  button in Header Details for Entity Screening");
		}
	}

	// Error message in Entity details Name
	public void entitydetailsNamevalidation() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error!')]")) {
				if (isDisplayed(driver, "//li[contains(text(),'Please enter a value for the Name field and select a Country')]")) {
					test.log(LogStatus.INFO, "Please enter the Name");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error Vaildation is not Displayed by clicking on ADD button in Entity Details");
		}
	}

	// Error message in Entity details Entity Role
	public void entitydetailsEntityRolevalidation() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error!')]")) {
				if (isDisplayed(driver, "//li[contains(text(),'Select Entity Role')]")) {
					test.log(LogStatus.INFO, "Select Entity Role");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error Vaildation is not Displayed by clicking on ADD button in Entity Details");
		}
	}

	// Error message in item details notes
	public void itemdetailsvalidation() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {
				if (isDisplayed(driver, "//li[contains(text(),'Add at least one Item Screening details')]")) {
					test.log(LogStatus.INFO, "Add at least one Item Screening details");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error Vaildation is not Displayed by clicking on SAVE  button in Header Details for Item Screening");
		}
	}

	// validate the Item details Classification
	public void itemclassificationvalidation() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {
				if (isDisplayed(driver, "//li[contains(text(),'Enter Import Classification')]")) {
					test.log(LogStatus.INFO, "Enter Import Classification");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Enter Part No. or Export Classification')]")) {
					test.log(LogStatus.INFO, "Enter Part No. or Export Classification");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error Vaildation is not Displayed by clicking on SAVE  button in Import Control Screening");
		}
	}

}
