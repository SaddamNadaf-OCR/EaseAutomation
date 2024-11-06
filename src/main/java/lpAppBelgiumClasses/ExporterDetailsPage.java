package lpAppBelgiumClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ExporterDetailsPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	
	public static final String OCR_ED_ExporterLink = "//i[@class='fa fa-user fa-2x']";
	public static final String OCR_ED_Exporter = "//a[text()='Exporter']";
	public static final String OCR_ED_EStatus = "//select[@id='searchForm_exporter_status']";
	public static final String OCR_ED_ESearch = "//button[@name='Search']";
	public static final String OCR_ED_EExporterSelect = "//button[contains(text(),'Select')]";
	public static final String OCR_ED_EExporterSave = "//input[@id='submitAppl']";
	public static final String OCR_ED_AddCountryIcon = "//span[contains(text(),'Add Countries')]/../i";
	public static final String OCR_ED_AddItemsIcon = "//i[@class='fa fa-list-ol fa-2x']";
	public static final String OCR_ED_AddForeignPartiesIcon = "//i[@class='fa fa-users fa-2x']";
	public static final String OCR_ED_AddDomesticPartiesIcon = "//li[@id='5']/a/i";
	public static final String OCR_ED_EndUserIcon = "//i[@class='fa fa-ship']";
	public static final String OCR_ED_AdditionalInformationIcon = "//i[@class='fa fa-info']";
	public static final String OCR_ED_AppStatementIcon = "//i[@class='fa fa-send']";
	public static final String OCR_ED_StatusText = "//span[@class='heading-additional']	";
	public static final String OCR_ED_RefIdText = "//div[@class='col-4 text-right tp-icons']/label";
	public static final String OCR_ED_BackToHeaderBtn = "//button[@class='closeAllBtn']";
	public static final String OCR_ED_PopUpClose = "//button[@class='btn-close']";

	/* ******************************* Constructor ****************************** */

	public ExporterDetailsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	
	//click on Exporter icon
	public void click_ExporterIcon() {
		clickElement(driver, test, OCR_ED_ExporterLink, "Click on Exporter Details Icon");
	}

	// Adding Exporter via pop up
	public void exporterDetails(String Status, String ExporterCode) {
		click_ExporterIcon();
		clickElement(driver, test, OCR_ED_Exporter, "Click on Exporter Link");
		try {
			selectByVisibleText(driver, test, OCR_ED_EStatus, "Select Status as : ", Status);
			typeText(driver, test, "//input[@id='searchForm_exporter_expCode']", "Entering Exporter Code :", ExporterCode);
			clickElement(driver, test, OCR_ED_ESearch, "Click on search button");
			String Ecode = "//td[contains(text(),'" + ExporterCode + "')]";
			Wait.waitfor(3);
			clickElement(driver, test, "(//td[@aria-describedby='gridPopup_expCode'])[1]", "Select Exporter : " + ExporterCode);
			clickElement(driver, test, OCR_ED_EExporterSelect, "Click on Select Button");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_ED_PopUpClose, "Click on POP UP close");
		}
		typeText(driver, test, "//input[@name='authorisationAddressValue.licAddrGovtValue1']", "Entering Number :", "1234");
	}

	// click on save button
	public void click_Exptsave() {
		clickElement(driver, test, OCR_ED_EExporterSave, "click on save button in Exporter Details");
	}

	// click on Add Country Icon
	public void click_addCountry() {
		clickElement(driver, test, OCR_ED_AddCountryIcon, "click on Add Country Icon");
	}

	// click on Add items Icon
	public void click_addItems() {
		clickElement(driver, test, OCR_ED_AddItemsIcon, "click on Add Items Icon");
	}

	// click on Add Foreign Party
	public void click_AddForeginParty() {
		clickElement(driver, test, OCR_ED_AddForeignPartiesIcon, "click on Add Foregin Party");
	}

	/*// click on Add Domestic party
	public void click_AddDomesticParty() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ED_AddDomesticPartiesIcon, "click on Add Demostic partys");
	}*/

	// click on End use/ specific Purpose
	public void click_EndUse() {
		clickElement(driver, test, OCR_ED_EndUserIcon, "click on End use / Specific purpose");
	}

	// click on additional informations
	public void click_AdditionalInfo() {
		clickElement(driver, test, OCR_ED_AdditionalInformationIcon, "click on Addtional");
	}

	// click on Applicant's Statement
	public void click_AppStatement() {
		clickElement(driver, test, OCR_ED_AppStatementIcon, "click on Applicant's Statement");
	}

	//click on Back to Header
	public void click_BackToHeader() {
		Wait.waitfor(4);
		clickElement(driver, test, OCR_ED_BackToHeaderBtn, "click on Back to Header Button");
	}	

	//Get text of status in export Details page
	public String statusText() {
		String StatusED = getText(driver, test, OCR_ED_StatusText, "Status in Export details Page : ");
		return StatusED;
	}

	//Get text of Reference ID in export Details page
	public String ReferenceIDText() {
		String RefID = getText(driver, test, OCR_ED_RefIdText, "Reference ID in Export details Page : ");
		String[] ReferenceID = RefID.split(":");
		return ReferenceID[1].trim();
	}	

	//validate Exporter details 
	public void validateExportDetailsError() {
		try {
			if (isDisplayed(driver,"//h4[contains(text(),'Error')]")) {				

				if (isDisplayed(driver,"//li[text()='Exporter Name  is required.']")) {
					test.log(LogStatus.INFO, "Exporter Name  is required.");
				}
				if (isDisplayed(driver,"//li[text()='Exporter Address  is required.']")) {
					test.log(LogStatus.INFO, "Exporter Address  is required.");
				}
				if (isDisplayed(driver,"//li[text()='Exporter City  is required.']")) {
					test.log(LogStatus.INFO, "Exporter City  is required.");
				}
				if (isDisplayed(driver,"//li[text()='Exporter Zip/Post Code  is required.']")) {
					test.log(LogStatus.INFO, "Exporter Zip/Post Code  is required.");
				}
				if (isDisplayed(driver,"//li[text()='Exporter Country  is required.']")) {
					test.log(LogStatus.INFO, "Exporter Country  is required.");
				}
				if (isDisplayed(driver,"//li[text()='Exporter BEL/W ID Number  is required.']")) {
					test.log(LogStatus.INFO, "Exporter BEL/W ID Number  is required.");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error Vaildation is not Displayed by clicking on SAVE button in Exporter Details");					
		}
	}

}
