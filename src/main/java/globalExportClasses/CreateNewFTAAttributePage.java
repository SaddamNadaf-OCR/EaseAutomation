package globalExportClasses;
/* 
 * Module : Export Operation
 * Author  : Saddam
 * created date : May 2024
 * Descriptions : Create New FTA Attribute Page
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil 
 */
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewFTAAttributePage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_AddFTAPage_Save = "//button[@name='save']";
	public static final String OCR_AddFTAPage_SaveandReturn = "//button[@name='savereturn']";
	public static final String OCR_AddFTAPage_Cancel = "//button[@name='cancel']";
	public static final String OCR_AddFTAPage_SBUCode = "//select[@id='editFtaAttribute_ftaAttribute_sbuCode']";
	public static final String OCR_AddFTAPage_FTAType = "//select[@id='editFtaAttribute_ftaAttribute_fta']";
	public static final String OCR_AddFTAPage_PreferanceCriteria = "//select[@id='editFtaAttribute_ftaAttribute_preferenceCriteria']";
	public static final String OCR_AddFTAPage_Producer = "//select[@id='editFtaAttribute_ftaAttribute_producer']";
	public static final String OCR_AddFTAPage_RegionalValueContent = "//select[@id='editFtaAttribute_ftaAttribute_netCost']";
	public static final String OCR_AddFTAPage_Heading = "//h3[contains(text(),'Result FTA Attribute')]";
	public static final String OCR_AddFTAPage_SBUMandatoryError = "//li[contains(text(),'SBU Code is Mandatory.')]";
	public static final String OCR_AddFTAPage_FTAMandatoryError = "//li[contains(text(),'FTA Type is Mandatory.')]";

	/* ******************************* Constructor ****************************** */

	public CreateNewFTAAttributePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	// Click on Save Button
	public void save() {
		clickElement(driver, test, OCR_AddFTAPage_Save, "Clicking on Save Button :");
	}

	// Click on Save and Return Button
	public void saveandReturn() {
		clickElement(driver, test, OCR_AddFTAPage_SaveandReturn, "Clicking on Save and Return Button :");
	}

	// Click on Cancel Button
	public void cancel() {
		clickElement(driver, test, OCR_AddFTAPage_Cancel, "Clicking on Cancel Button :");
	}
	
	//Add Parametrs
	public void addParameters(String SBUCode, String FTAType, String PreferanceCriteria, String Producer, String RegionalValueContent) {
		selectByVisibleText(driver, test, OCR_AddFTAPage_SBUCode, "Selecting SBU Code :", SBUCode);
		selectByVisibleText(driver, test, OCR_AddFTAPage_FTAType, "Selecting FTA Type :", FTAType);
		selectByVisibleText(driver, test, OCR_AddFTAPage_PreferanceCriteria, "Selecting Preferance Criteria Type :", PreferanceCriteria);
		selectByVisibleText(driver, test, OCR_AddFTAPage_Producer, "Selecting Producer :", Producer);
		selectByVisibleText(driver, test, OCR_AddFTAPage_RegionalValueContent, "Selecting Regional Value Content :", RegionalValueContent);
	}
	
	//Edit Attributes
	public void edit(String SBUCode, String FTAType) {
		selectByVisibleText(driver, test, OCR_AddFTAPage_SBUCode, "Selecting SBU Code :", SBUCode);
		selectByVisibleText(driver, test, OCR_AddFTAPage_FTAType, "Selecting FTA Type :", FTAType);
	}
	
	//click on FTA attributes
	public void open_FTAAttribute() {
		Wait.waitfor(2);
		clickElement(driver, test, "//a[contains(text(),'NAFTACA')]", "CLicking on FTA Attributes : ");
	}
	
	//Validating Heading
	public void titleisDisplayed() {
		try {
			if(isDisplayed(driver, OCR_AddFTAPage_Heading)) {
				test.log(LogStatus.PASS, "Title is Displayed :");
			}
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Title is Not Displayed :");
		}
	}
	
	//Error Validation
	public void eerorValidation() {
		try {
			if(isDisplayed(driver, OCR_AddFTAPage_SBUMandatoryError)) {
				test.log(LogStatus.PASS, "Error Msg is Displayed :");
			}
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error Msg is Not Displayed :");
		}
		try {
			if(isDisplayed(driver, OCR_AddFTAPage_FTAMandatoryError)) {
				test.log(LogStatus.PASS, "Error Msg is Displayed :");
			}
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error Msg is Not Displayed :");
		}
	}
}
