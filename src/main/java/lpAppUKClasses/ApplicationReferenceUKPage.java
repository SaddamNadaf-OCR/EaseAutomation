package lpAppUKClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ApplicationReferenceUKPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/**************************** Locators ********************************/

	public static final String OCR_AppRefer_YourRefer = "//input[@id='editApplicationrefSection_referenceId']";
	public static final String OCR_AppRefer_PreviousApp = "//label[contains(text(),'Previous Applications')]";
	public static final String OCR_AppRefer_EnterPreviousAppBtn = "//button[@id='preApplButton']";
	public static final String OCR_AppRefer_PrevReferPopUp_AppReferLink = "//a[@id='licenseNo-Popup']";
	public static final String OCR_AppRefer_AuthNo = "//input[@id='resultLicensePopupData_authorisationHeader_authorisationNumber']";
	public static final String OCR_AppRefer_AddPrevApp_Comments = "//textarea[@id='editPreApplication_licUkPrevApplication_comments']";
	public static final String OCR_AppRefer_AuthNo_SearchBtn = "//button[@id='searchAuth']";
	public static final String OCR_AppRefer_AuthNo_SelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_AppRefer_AddPrevApp_SaveBtn = "//button[@id='save']";
	public static final String OCR_AppRefer_AddPrevApp_SaveandReturnBtn = "//button[@id='saveAndReturn']";
	public static final String OCR_AppRefer_AddPrevApp_AddMoreBtn = "//button[@id='AddMore']";
	public static final String OCR_AppRefer_AddPrevApp_CancelBtn = "//button[@id='btnClose']";
	public static final String OCR_AppRefer_NextLink_ProposedLicense = "//i[@id='PROP']";
	public static final String OCR_AppRefer_ReferenceId = "//input[@id='editApplicationrefSection_referenceId']";

	/* ******************** Constructor ***************************** */

	public ApplicationReferenceUKPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ************ Actions **********************/

	public void clickOnEnterPreviousApp() {
		clickElement(driver, test, OCR_AppRefer_PreviousApp, "click on previous Applications Link");
		clickElement(driver, test, OCR_AppRefer_EnterPreviousAppBtn, "click on Enter Previous Application Button");
	}

	public void addPreviousAppPopUp(String AuthorizationNo, String Comments) {
		clickElement(driver, test, OCR_AppRefer_PrevReferPopUp_AppReferLink, "click on Application Refer Link");
		try {
			addAuthNo(AuthorizationNo);
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_AppRefer_AddPrevApp_CancelBtn, "Click on pop close");
		}
		Wait.waitfor(3);
		typeText(driver, test, OCR_AppRefer_AddPrevApp_Comments, "Add comments :  ", Comments);
	}

	public void addAuthNo(String AuthorizationNo) {
		typeText(driver, test, OCR_AppRefer_AuthNo, "Enter Authorization No : ", AuthorizationNo);
		clickElement(driver, test, OCR_AppRefer_AuthNo_SearchBtn, "click on Auth Search Button");
		String AuthNo = "(//td[contains(text(),'" + AuthorizationNo + "')])[2]";
		clickElement(driver, test, AuthNo, "Select Authorization No : "+AuthorizationNo);
		clickElement(driver, test, OCR_AppRefer_AuthNo_SelectBtn, "click on Select Button");
	}

	public void clickonSaveBtn() {
		clickElement(driver, test, OCR_AppRefer_AddPrevApp_SaveandReturnBtn, "click on save and Return Button");
	}

	public void clickonNextLinktoProposeLicense() {
		clickElement(driver, test, OCR_AppRefer_NextLink_ProposedLicense, "click on next link to Propose License");
	}

	// Get text of Reference ID in export Details page
	public String ReferenceIDText() {
		String RefID = getAttribute(driver, test, OCR_AppRefer_ReferenceId, "value",
				"Reference ID in Application Reference Page : ");
		return RefID.trim();
	}

	// validations in Application Reference Tab
	public void validateApplicationReferenceError() {
		try {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_AppRefer_AddPrevApp_SaveandReturnBtn, "click on save and Return Button");
			Wait.waitfor(3);
			if (isDisplayed(driver, "//div[@class='row ocr-error']//h4[contains(text(),'Error')]")) {
				if (isDisplayed(driver, "//li[text()='Please enter the Application Reference Number']")) {
					test.log(LogStatus.INFO, "Please enter the Application Reference Number");
				}
				clickElement(driver, test, OCR_AppRefer_AddPrevApp_CancelBtn, "Close Application Reference Pop up");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Errors is not Displayed by clicking on SAVE button for status: Approved");
			clickElement(driver, test, OCR_AppRefer_AddPrevApp_CancelBtn, "Close Application Reference Pop up");
		}
	}

}
