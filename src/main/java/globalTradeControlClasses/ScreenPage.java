package globalTradeControlClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilities.GenericMethods;
import utilities.Wait;

public class ScreenPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_GtcScreen = "(//button[contains(text(),'Screen')])[1]";
	public static final String OCR_GtcTradeControlDecision_TakeOwnership = "//button[contains(text(),'Take Ownership')]";
	public static final String OCR_GtcEntityScreening = "//a[@class='entityScreening']";
	public static final String OCR_GtcEntityScreening_DrmSelectEntity = "//td[@class='grid-icon']//input";
	public static final String OCR_GtcEntityScreening_DrmRemarks = "//textarea[@id='editDispositionMatrix_otherReason']";
	public static final String OCR_GtcEntityScreening_DrmSave = "(//button[contains(text(),'Save')])[2]";
	public static final String OCR_GtcExportLicenseScreening = "//a[@class='usLicenseScreening']";
	public static final String OCR_GtcExportExceptions = "//input[@id='selGeaNa']";
	public static final String OCR_GtcExportSubmit = "//input[@class='primary-btn']";
	public static final String OCR_GtcImportControlScreening = "//a[@class='importControlScreening']";
	public static final String OCR_GtcImportPartDetails = "//input[@id='cb_grid']";
	public static final String OCR_GtcImportStatus = "//select[@id='editImpCntrlScreening_impControlStatus']";
	public static final String OCR_GtcImportRemarks = "//textarea[@id='editImpCntrlScreening_remarks']";
	public static final String OCR_GtcImportSave = "//button[@class='form-control primary-btn']";
	public static final String OCR_GtcNewScreening_DocumentationRequirementBtn = "//a[@class='documentRequirment']";
	public static final String OCR_GtcNewScreening_DocumentationMultimodalDangerousGoodsform = "//a[contains(text(),'Multimodal Dangerous Goods form')]";
	public static final String OCR_GtcNewScreening_DocumentationBananaWeighingCertificate = "//a[contains(text(),'Banana Weighing Certificate')]";
	public static final String OCR_GtcNewScreening_CloseDocumentationsDetailsPopup = "//div[@id='ocrModal']//button[@class='close']";
	public static final String OCR_GtcTradeControlDecision = "//a[contains(text(),'Trade Control Decision')]";
	public static final String OCR_GtcTradeControlDecision_Submit = "//button[@id='sign']";
	public static final String OCR_HomePage_ListScreening="//ul[@class='nav navbar-nav']/li[2]/a";
	public static final String OCR_GtcHomePage_GlobalTradeControls = "(//a[contains(text(),'Global Trade Controls')])[1]";
	public static final String OCR_GtcHomePage_GlobalTradeRefNo = "//span[@class='heading-additional']/span";
	public static final String OCR_GtcHomePage_GlobalTradeStatus = "//span[@class='heading-additional']/span[2]";
	public static final String OCR_GtcHomePage_PopUpClose = "//button[@class='close']";
	public static final String OCR_EntityOverride = "//button[contains(text(),'Override')]";
	public static final String OCR_ReviewerComments = "//textarea[@id='editTradeControlDecision_gtcGeneralInfoValue_comments']";

	/* ******************************* Constructor ****************************** */

	public ScreenPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	/* ******************************* Actions ********************************* */

	// Click Screen
	public void click_GtcScreen(){
		scrollToElement(driver, "//h3[@class='page-heading']");
		clickElement(driver, test, OCR_GtcScreen, "Click on Screen Button");
		Wait.waitfor(4);
	}
	
	// Click Reviewer Comments
		public void click_ReviewerComments(){
			clickElement(driver, test, OCR_ReviewerComments, "Click on Reviewer Comments");
			Wait.waitfor(4);
		}

	// Click on TradeControlDecision
	public void click_GtcTradeControlDecision(){
		Wait.waitfor(4);
		clickElement(driver, test, OCR_GtcTradeControlDecision_TakeOwnership, "Click on Take Ownership Button");
	}

	// Click on Entity Screening
	public void click_GtcEntityScreening(){
		Wait.waitfor(4);
		clickElement(driver, test, OCR_GtcEntityScreening, "Click on Entity Screening Button");
		Wait.waitfor(4);
	}

	public void click_GtcSelectEntity(int i){
		String str = "(//td[@class='grid-icon']//input)["+i+"]";		
		clickElement(driver, test, str, "Click to Select Entity");
	}

	// Select Entity
	public void click_GtcSaveEntity(String EntityDecision, String DispositionReason, String Remarks) throws InterruptedException {
		Wait.waitfor(2);
		String decision = "//button[contains(text(),'"+EntityDecision+"')]";
		clickElement(driver, test, decision, "Click on Entity Decision Button : "+ EntityDecision);
		try {
			String drm = "//td[contains(text(),'"+DispositionReason.trim()+"')]/../td/input";
			Wait.waitfor(3);
			clickElement(driver, test, drm, "Click on Disposition Reason Button : "+ DispositionReason);
			typeText(driver, test, OCR_GtcEntityScreening_DrmRemarks, "Drm Remarks", Remarks);
			clickElement(driver, test, OCR_GtcEntityScreening_DrmSave, "Click to Drm Save Button");
			Wait.waitfor(3);
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_GtcHomePage_PopUpClose, "Click on PopUp Close Icon");
		}
	}

	// click Override in entity screening
	public void click_OverrideButton(){
		clickElement(driver, test, OCR_EntityOverride, "Click on Override Button");
	}


	// Click Export License Screening Page	
	public void click_GtcExportLicenseScreening(){
		clickElement(driver, test, OCR_GtcExportLicenseScreening, "Click on Export License Screening Button");
//		scrollToElement(driver, "//table[@id='gea1']//b[contains(text(),'Exceptions')]");
	}	

	// Select Export Exception
	public void select_GtcExportException(){
		clickElement(driver, test, OCR_GtcExportExceptions, "Click on Export Exceptions");
	}

	// Click Submit in Export License Screening Page	
	public void click_GtcExportLicenseScreeningSubmit(){
		clickElement(driver, test, OCR_GtcExportSubmit, "Click on Export Submit");
		Wait.waitfor(4);
	}


	//	Click Import Control Screening Page	
	public void click_GtcImportControlScreening(){
		clickElement(driver, test, OCR_GtcImportControlScreening, "Click on Import Control Screening Button");
		Wait.waitfor(2);
	}
	
//	Fill details in Import Control Screening Page	
	public void click_GtcImportControlDetails(String ImportStatus, String ImportRemarks){
		clickElement(driver, test, OCR_GtcImportPartDetails, "Click on Import PartDetails");
		Wait.waitfor(3);
		selectByVisibleText(driver, test, OCR_GtcImportStatus, "Select Status : ", ImportStatus);
		typeText(driver, test, OCR_GtcImportRemarks, "Enter the Remarks : ", ImportRemarks);
	}
	
//	Save Import Control Screening Page	
	public void click_GtcImportControlSave(){
		clickElement(driver, test, OCR_GtcImportSave, "Click on Import Save");
	}

	// click on Documentation Requirement screen
	public void click_documentationrequirementbtn() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_GtcNewScreening_DocumentationRequirementBtn,
				"click on Documentation Screen button");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_GtcNewScreening_DocumentationMultimodalDangerousGoodsform, "Click Documentation Multimodal Dangerous Goods form");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_GtcNewScreening_CloseDocumentationsDetailsPopup, "Close Documentation Popup");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_GtcNewScreening_DocumentationBananaWeighingCertificate, "Click Documentation Banana Weighing Certificate");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_GtcNewScreening_CloseDocumentationsDetailsPopup, "Close Documentation Popup");
		Wait.waitfor(2);
	}

	//	Return to TradeControlDecision
	public void click_GtcSubmitTradeControlScreening(String ControlDecision){
		clickElement(driver, test, OCR_GtcTradeControlDecision, "Click on Trade Control Decision Button");
		String ctrlDecison = "//label[contains(text(),'"+ControlDecision+"')]/../input";
		clickElement(driver, test, ctrlDecison, "Click to Control Decision Button : "+ ControlDecision);
		Wait.waitfor(2);
		clickElement(driver, test, OCR_GtcTradeControlDecision_Submit, "Click to Trade Control Decision Submit Button");
	}

	//getting the reference no.
	public String getReferenceNo() {		
		return getText(driver, test, OCR_GtcHomePage_GlobalTradeRefNo, "Global Trade RefNo : ");
	}

	// validate the Take owner ship
	public void takeOwnershipValidation() {
		try {
			if(isDisplayed(driver, OCR_GtcTradeControlDecision_TakeOwnership)) {
				test.log(LogStatus.PASS, "Take Ownership Button is Displayed");	
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Take Ownership Button is Disable");
			testFailSshot(driver, test);
		}
	}

	// validate the Entity Screening
	public void entityscreeningValidation() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error!')]")) {
				if (isDisplayed(driver, "//li[contains(text(),'Select at least on entity')]")) {
					test.log(LogStatus.INFO, "Select at least on entity");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error Vaildation is not Displayed by clicking on SAVE  button in Entity Screening");
		}
	}

	// validate the Export License Screening
	public void exportlicensescreeningValidation() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error!')]")) {
				if (isDisplayed(driver, "//li[contains(text(),'Select an item')]")) {
					test.log(LogStatus.INFO, "Select at least on item");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error Vaildation is not Displayed by clicking on SAVE  button in Export License Screening");
		}
	}

	// validate the Import Control Screening
	public void importlicensescreeningValidation() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error!')]")) {
				if (isDisplayed(driver, "//li[contains(text(),'Atleast one line item should be selected.')]")) {
					test.log(LogStatus.INFO, "Select at least on one line item");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Status is required.')]")) {
					test.log(LogStatus.INFO, "Select at least on Status");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error Vaildation is not Displayed by clicking on SAVE  button in Import Control Screening");
		}
	}

	public String getStatus() {		
		return getText(driver, test, OCR_GtcHomePage_GlobalTradeStatus, "Global Trade Status : ");
	}
}
