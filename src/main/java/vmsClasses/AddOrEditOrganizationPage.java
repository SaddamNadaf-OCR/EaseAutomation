package vmsClasses;


import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilities.GenericMethods;
import utilities.Wait;

public class AddOrEditOrganizationPage extends GenericMethods{

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_AddOrEditOrg_OrgName = "//input[@id='VMM_FLD_154']";
	public static final String OCR_AddOrEditOrg_OrgAddress = "//input[@id='VMM_FLD_155']";
	public static final String OCR_AddOrEditOrg_OrgType = "//select[@id='VMM_FLD_158']";
	public static final String OCR_AddOrEditOrg_OrgCity = "//input[@id='VMM_FLD_159']";
	public static final String OCR_AddOrEditOrg_OrgState = "//input[@id='VMM_FLD_160']";
	public static final String OCR_AddOrEditOrg_OrgZip = "//input[@id='VMM_FLD_161']";
	public static final String OCR_AddOrEditOrg_OrgCountry = "//input[@id='VMM_FLD_162']";
	public static final String OCR_AddOrEditOrg_Save = "//button[@name='save']";
	public static final String OCR_AddOrEditOrg_SaveAndReturn = "//button[@name='Ok']";
	public static final String OCR_AddOrEditOrg_OrgAdded = "//span[@class='dpl-status']";
	public static final String OCR_AddOrEditOrg_DplStatusRed = "//i[@class='fa ocr-flag-field fa-flag ocr-flag-red']";
	public static final String OCR_AddOrEditOrg_ViewDetailOverride = "//button[contains(text(),'Override')]";
	public static final String OCR_AddOrEditOrg_DisptnReasonMatrix = "(//input[@name='dplreasons'])[5]";
	public static final String OCR_AddOrEditOrg_DisptnReasonMatxSave = "//div[@class='ocr-modal-base']//div[@class='modal-body']"
			+ "//div[1]//div[1]//button[1]";
	public static final String OCR_VisitorInfo_DRMclose = "//button[@class='close']";
	public static final String OCR_AddOrEditOrg_AddVisitorBtn = "//button[contains(text(),'Add Visitor')]";

	/* ******************** Constructor ***************************** */

	public AddOrEditOrganizationPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Enter organization Name
	public void type_OrgName(String OrgName) throws InterruptedException {
		Wait.waitfor(4);
		typeText(driver, test, OCR_AddOrEditOrg_OrgName, "Enter organization Name : ", OrgName);
	}

	// Enter organization Address
	public void type_OrgAddress(String OrgAddress) {
		typeText(driver, test, OCR_AddOrEditOrg_OrgAddress, "Enter organization Address : ", OrgAddress);
	}

	// Select organization Type
	public void select_OrgType(String OrgType) {		
		clickElement(driver, test, OCR_AddOrEditOrg_OrgType, "click OrgType");
		selectByVisibleText(driver, test, OCR_AddOrEditOrg_OrgType, "Select organization Type : " , OrgType);		
	}	

	// Enter organization city
	public void type_Orgcity(String Orgcity) throws InterruptedException {
		typeText(driver, test, OCR_AddOrEditOrg_OrgCity, "Enter organization city : ", Orgcity);
		Wait.waitfor(3);	
	}

	// Enter organization State
	public void type_OrgState(String OrgState) throws InterruptedException {
		typeText(driver, test, OCR_AddOrEditOrg_OrgState, "Enter State : ", OrgState);
		String loc1="//div[contains(text(),'"+OrgState.trim()+"')]";
		Wait.waitfor(3);		
		clickElement(driver, test, loc1, "click on State : "+OrgState);
	}

	// Enter organization Zip
	public void type_OrgZip(String OrgZip) {
		typeText(driver, test, OCR_AddOrEditOrg_OrgZip,"Enter organization Zip : ", OrgZip);
	}

	// select organization country
	public void type_OrgCountry(String OrgCountry) throws InterruptedException {
		typeText(driver, test, OCR_AddOrEditOrg_OrgCountry,"Enter Country : ", OrgCountry);
		String loc1="//div[contains(text(),'"+OrgCountry.trim()+"')]";
		Wait.waitfor(3);
		Wait.fluwait(driver,loc1);
		clickElement(driver, test, loc1, "Click Country : "+OrgCountry);
	}

	//click on Save
	public void click_Save() {
		clickElement(driver, test, OCR_AddOrEditOrg_Save, "Clicking on Save");
	}

	//click on Save and Return
	public void click_SaveAndReturn() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_AddOrEditOrg_SaveAndReturn, "Clicking on Save And Return");
	}

	//click on Add visitor
	public void click_AddVisitorBtn() {
		clickElement(driver, test, OCR_AddOrEditOrg_AddVisitorBtn, "Clicking on Add Visitor");
	}

	/* ******************  Validations in Add/Edit Organization ***************************** */

	//validate save button in add organizations
	public void validate_AddOrgSaveBtn() {
		try {
			if (isDisplayed(driver,"//h4[contains(text(),'Error!')]")) {
				if (isDisplayed(driver,"//li[contains(text(),'Org Name is required.')]")) {
					test.log(LogStatus.PASS, "Org Name is required.");
				}
				if (isDisplayed(driver,"//li[contains(text(),'Org Type is required.')]")) {
					test.log(LogStatus.PASS, "Org Type is required.");
				}
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "organizations  is required.");
		}
	}

	//validate save and Return button in add organizations
	public void validate_AddOrgSaveAndReturnBtn() {
		try {
			if (isDisplayed(driver,"//h4[contains(text(),'Error!')]")) {
				if (isDisplayed(driver,"//li[contains(text(),'Org Name is required.')]")) {
					test.log(LogStatus.PASS, "Org Name is required.");
				}
				if (isDisplayed(driver,"//li[contains(text(),'Org Type is required.')]")) {
					test.log(LogStatus.PASS, "Org Type is required.");
				}
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "organizations  is required.");
		}
	}

	// Validating Rescanning of DPl status flag in the Add Organization 
	public void validReScanAddOrg(String RechangeOrgCountry,String RechangeOrgState) throws Exception{
		clearText(driver, test, OCR_AddOrEditOrg_OrgCountry,"clear the Org country field");
		type_OrgCountry(RechangeOrgCountry);	
		clearText(driver, test, OCR_AddOrEditOrg_OrgState,"clear the Org state field");
		type_OrgState(RechangeOrgState);
		click_Save();
		try {
			if (OCR_AddOrEditOrg_DplStatusRed != null) {
				clickElement(driver, test, OCR_AddOrEditOrg_DplStatusRed, "Click DPL flag");
				Wait.waitfor(3);
				clickElement(driver, test, OCR_AddOrEditOrg_ViewDetailOverride, "Clicking on Override");
				Wait.waitfor(3);
				clickElement(driver, test, OCR_AddOrEditOrg_DisptnReasonMatrix, "Select the Disposition Reason Matrix");
				Wait.waitfor(3);
				clickElement(driver, test, OCR_AddOrEditOrg_DisptnReasonMatxSave, "Clicking on Disposition Reason Matrix Save");
				Wait.waitfor(3);
			}else {
				test.log(LogStatus.FAIL, " DPl status flag status is not changed");
				testFailSshot(driver, test);
			}
		}
		catch(Exception e){ 	
			e.printStackTrace();
			clickElement(driver, test, OCR_VisitorInfo_DRMclose, "click on cancle");
			test.log(LogStatus.FAIL, "Click on cancle");
		}
	}
}
