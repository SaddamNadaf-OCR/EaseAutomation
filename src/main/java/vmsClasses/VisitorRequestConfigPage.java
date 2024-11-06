package vmsClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;
import utilities.Wait;

public class VisitorRequestConfigPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_VMCT_VR_SBUcode = "//select[@id='selSbuCode']";
	public static final String OCR_VMCT_VR_Search = "//input[@id='search']";
	public static final String OCR_VMCT_VR_Edit = "//i[@class='fa fa-edit']";
	public static final String OCR_VMCT_VR_ScreenName = "//select[@id='selScreenName']";
	public static final String OCR_VMCT_VR_SelectBlkList = "//select[@name='vmctConfSelectBlkList']";
	public static final String OCR_VMCT_VR_Right = "//i[@class='fa fa-angle-right']";
	public static final String OCR_VMCT_VR_left = "//i[@class='fa fa-angle-left']";
	public static final String OCR_VMCT_VR_DoubleRight = "//i[@class='fa fa-angle-double-right']";
	public static final String OCR_VMCT_VR_DoubleLeft = "//i[@class='fa fa-angle-double-left']";
	public static final String OCR_VMCT_VR_SaveBlk = "//button[@id='saveBlock']";
	public static final String OCR_VMCT_VR_AvailBlkList = "//select[@id='vmctConfAvailBlkList']";
	public static final String OCR_VMCT_VR_ModifyBlkList = "//button[@id='modBlockDetails']";
	public static final String OCR_VMCT_VR_ModifyFieldDetails = "//button[@id='fieldConfig']";
	public static final String OCR_VMCT_VR_BlockName = "//select[@id='blocklist']";
	public static final String OCR_VMCT_VR_SelectFieldList = "//select[@name='vmctConfSelectFldList']";
	public static final String OCR_VMCT_VR_AvailFieldList = "//select[@id='vmctConfAvailFldList']";
	public static final String OCR_VMCT_VR_SaveField = "//button[@id='saveBlkFld']";
	public static final String OCR_VMCT_VR_ModifyFiledCancel = "//button[@id='confirmModalCancel']";
	public static final String OCR_VMCT_KioskSBUCode = "//select[@id='kioskSbuCode']";
	public static final String OCR_VMCT_KioskRequest_Edit = "//i[@class='fa fa-edit']";
	public static final String OCR_VMCT_VR_Site = "//select[@id='kioskSiteId']";
	public static final String OCR_VMCT_VR_Filedname = "//*[@id='entityTable']/tbody/tr[1]/td[1]";
	public static final String OCR_VMCT_VR_CustomFiledname = "(//table[@id='entityTable']/tbody/tr/td[2]/input)[1]";
	public static final String OCR_VMCT_VR_CustomFilednameSave = "//button[@id='confirmModalOk']";
	public static final String OCR_VMCT_VR_OrgPreviewIcon = "//*[@id='vmctBlockPreiviw']/i";
	public static final String OCR_VMCT_VR_OrgPreviewIconCancel = "(//button[@class='cancelBtn'])[1]";
	public static final String OCR_VMCT_VR_EmployeeID = "//select[@id='mcoStatus3']";

	/* ******************** Constructor ***************************** */

	public VisitorRequestConfigPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Select SBU Code // Clicking on Search // Clicking on Edit // Select the
	// Screen Name
	public void VmctCofigSelect(String SBU, String ScreenName) {
		selectByVisibleText(driver, test, OCR_VMCT_VR_SBUcode, "Select SBU CODE : ", SBU);
		clickElement(driver, test, OCR_VMCT_VR_Search, "Clicking on VR Search");
		clickElement(driver, test, OCR_VMCT_VR_Edit, "Clicking on Edit Icon");
		selectByVisibleText(driver, test, OCR_VMCT_VR_ScreenName, "Select Screen Name: ", ScreenName);
	}

	// Select the selected block list
	public void select_VR_SelectList(String SelectList) {
		selectByVisibleText(driver, test, OCR_VMCT_VR_SelectBlkList, "Select Select Block List : ", SelectList);
	}

	// Select the Available block list
	public void select_VR_AvailableList(String AvailableList) {
		selectByVisibleText(driver, test, OCR_VMCT_VR_AvailBlkList, "Select Available Block List : ", AvailableList);
	}

	// Clicking on Right side button
	public void click_VR_RightMove() {
		clickElement(driver, test, OCR_VMCT_VR_Right, "Clicking on Right button");
	}

	// Clicking on left side button
	public void click_VR_LeftMove() {
		clickElement(driver, test, OCR_VMCT_VR_left, "Clicking on left button");
	}

	// Clicking on Double Right side button
	public void click_VR_DblRightMove() {
		clickElement(driver, test, OCR_VMCT_VR_DoubleRight, "Clicking on Double  Right button");
	}

	// Clicking on Double left side button
	public void click_VR_DblLeftMove() {
		clickElement(driver, test, OCR_VMCT_VR_DoubleRight, "Clicking on Double left button");
	}

	// Clicking on Visitor Request Save Block list
	public void click_VR_SaveBlk() {
		clickElement(driver, test, OCR_VMCT_VR_SaveBlk, "Clicking on VR Save Block");
	}

	// Clicking on Visitor Request Modify Block List
	public void click_VR_ModifyBlkList() {
		clickElement(driver, test, OCR_VMCT_VR_ModifyBlkList, "Clicking on VR Modify Block List");
	}

	// To verify VMCT Field name
	public String getFiledname() {
		Wait.waitfor(3);
		return getText(driver, test, OCR_VMCT_VR_Filedname, "Get the Actual text of Host SBU Field name : ");
	}

	// To verify VMCT custom Field name
	public String getcustomFiledname(String CustomFieldName) {

		clearText(driver, test, OCR_VMCT_VR_CustomFiledname, "clear the custom filed name");
		typeText(driver, test, OCR_VMCT_VR_CustomFiledname, "Enter the custom filed name : ", CustomFieldName);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_VMCT_VR_CustomFilednameSave, "Clicking on custom filed name save button");
		Wait.waitfor(4);
		System.out.println();
		return getAttribute(driver, test, OCR_VMCT_VR_CustomFiledname, "value",
				"Get the Actual text of custom Field name : ");

	}

	// click on cancel button in View / Modify Field Properties pop up
	public void click_VR_ModifyFieldCancel() {
		clickElement(driver, test, OCR_VMCT_VR_ModifyFiledCancel,
				"Clicking on cancel button in View / Modify Field Properties pop up ");
	}

	// Clicking on Visitor Request Modify fields details
	public void click_VR_ModifyFieldDetails() {
		clickElement(driver, test, OCR_VMCT_VR_ModifyFieldDetails, "Clicking on VR Modify fields details ");
	}

	// Select the block Name
	public void select_VR_BlockList(String BlockName) {
		Wait.waitfor(3);
		selectByVisibleText(driver, test, OCR_VMCT_VR_BlockName, "Select Available Block List : ", BlockName);
	}

	// Click on camera icon of Organization Preview
	public void click_VR_OrganizationPreviewIcon() {
		clickElement(driver, test, OCR_VMCT_VR_OrgPreviewIcon, "Clicking on on camera icon of Organization Preview  ");
	}

	// Click on Organization Preview cancel button
	public void click_VR_OrganizationPreviewIconCancel() {
		clickElement(driver, test, OCR_VMCT_VR_OrgPreviewIconCancel,
				"Clicking on on Cancel button in Organization Preview screen  ");
	}

	// Select the Select Field List
	public void select_VR_SelectedFieldList(String SelectedFieldList) {
		Wait.waitfor(3);
		selectByVisibleText(driver, test, OCR_VMCT_VR_SelectFieldList, "Selected Field List : ", SelectedFieldList);
	}

	// Select the Avaliable Field List
	public void select_VR_AvailFieldList(String AvailableFieldList) {
		Wait.waitfor(3);
		selectByVisibleText(driver, test, OCR_VMCT_VR_AvailFieldList, "Select Available Field List : ",
				AvailableFieldList);
	}

	// Clicking on Visitor Request Save Fields list
	public void click_VR_SaveFields() {
		clickElement(driver, test, OCR_VMCT_VR_SaveField, "Clicking on VR Save Fields");
	}

	// Select kiosk SBU Code
	public void select_KioskSBUcode(String SBU) {
		selectByVisibleText(driver, test, OCR_VMCT_KioskSBUCode, "Select SBU CODE :  ", SBU.trim());
	}

	// Select Site
	public void select_VRSite(String Site) {
		selectByVisibleText(driver, test, OCR_VMCT_VR_Site, "Select Site : ", Site.trim());
	}

	// Clicking on kiosk type Edit
	public void click_KioskRequestEdit() throws InterruptedException {
		clickElement(driver, test, OCR_VMCT_KioskRequest_Edit, "Clicking on kiosk type Edit Icon");
	}

	// Select the Employee ID
	public void selectEmployeeID(String EmployeeID) {
		selectByVisibleText(driver, test, OCR_VMCT_VR_EmployeeID, "Select the Employee ID : ", EmployeeID);
	}

	// Clicking on kiosk type Edit
	public void click_Save() throws InterruptedException {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_VMCT_VR_CustomFilednameSave, "Clicking on custom filed name save button");
		Wait.waitfor(4);
	}

}