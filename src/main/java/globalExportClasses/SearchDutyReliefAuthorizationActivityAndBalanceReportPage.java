package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchDutyReliefAuthorizationActivityAndBalanceReportPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_SearchDutyReliefAuthorizationActivityAndBalanceReportPage_SBU = "//select[@id='editDutyLog_dutyReliAuthDetails_sbuCode']";
	public static final String OCR_SearchDutyReliefAuthorizationActivityAndBalanceReportPage_Status = "//select[@id='editDutyLog_dutyReliAuthDetails_status']";
	public static final String OCR_SearchDutyReliefAuthorizationActivityAndBalanceReportPage_RAN = "//a[contains(@data-ocr-role,'modal-link')][contains(text(),'Relief Authorization No')]";
	public static final String OCR_SearchDutyReliefAuthorizationActivityAndBalanceReportPage_RANPopUp = "//input[@id='searchForm_dutyReliAuthDetails_reliefAuthNo']";
	public static final String OCR_SearchDutyReliefAuthorizationActivityAndBalanceReportPage_SearchPopUp = "//button[@name='Search']";
	public static final String OCR_SearchDutyReliefAuthorizationActivityAndBalanceReportPage_SelectPopUp = "//button[@name='Ok']";
	public static final String OCR_SearchDutyReliefAuthorizationActivityAndBalanceReportPage_ClosePopUp = "//button[@class='btn-close']";
	public static final String OCR_SearchDutyReliefAuthorizationActivityAndBalanceReportPage_RANTextInput = "//input[@id='editDutyLog_dutyReliAuthDetails_reliefAuthNo']";
	public static final String OCR_SearchDutyReliefAuthorizationActivityAndBalanceReportPage_ReliefType = "//select[@id='editDutyLog_dutyReliAuthDetails_reliefType']";
	public static final String OCR_SearchDutyReliefAuthorizationActivityAndBalanceReportPage_ReliefCategory = "//select[@id='editDutyLog_dutyReliAuthDetails_reliefCategory']";
	public static final String OCR_SearchDutyReliefAuthorizationActivityAndBalanceReportPage_Searchbtn = "//button[@name='search']";
	public static final String OCR_SearchDutyReliefAuthorizationActivityAndBalanceReportPage_ValidateHeading = "//h3[contains(text(),'Duty Relief Authorization Activity & Balance Repor')]";
	
	/* ******************************* Constructor ****************************** */

	public SearchDutyReliefAuthorizationActivityAndBalanceReportPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	public void selectSBU(String Sbu) {
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_SearchDutyReliefAuthorizationActivityAndBalanceReportPage_SBU, "Select SBU : ", Sbu);

	}
	
	public void selectStatus(String Status) {
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_SearchDutyReliefAuthorizationActivityAndBalanceReportPage_Status, "Select Status : ", Status);
	}
	
	public void ReliefAuthNo(String RANLink, String RAN) {
		 Wait.waitfor(2);
		 if(RANLink.length() > 0) {
			 try {
				 clickElement(driver, test, OCR_SearchDutyReliefAuthorizationActivityAndBalanceReportPage_RAN, "Click on Relief Authorization Number Link");
				 typeText(driver, test, OCR_SearchDutyReliefAuthorizationActivityAndBalanceReportPage_RANPopUp, "Enter Relief Authorization Number : ", RANLink);
				 clickElement(driver, test, OCR_SearchDutyReliefAuthorizationActivityAndBalanceReportPage_SearchPopUp, "Click on Search Pop Up button");
				 clickElement(driver, test, "//td[contains(text(),'"+ RANLink +"')]", "Select Relief Authorization Number : " +RANLink);
				 clickElement(driver, test, OCR_SearchDutyReliefAuthorizationActivityAndBalanceReportPage_SelectPopUp, "Click on Select Pop Up Button");
			  }
			 catch (Exception e) {
					testFailSshot(driver, test);
					clickElement(driver, test, OCR_SearchDutyReliefAuthorizationActivityAndBalanceReportPage_ClosePopUp, "Click on Close popup icon");
				}
			  }else {
				  typeText(driver, test, OCR_SearchDutyReliefAuthorizationActivityAndBalanceReportPage_RANTextInput, "Enter Relief Authorization Number : ", RAN);
			  }
		
			}
	
	public void ReliefType(String RelType) {
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_SearchDutyReliefAuthorizationActivityAndBalanceReportPage_ReliefType, "Enter Relief Type : ", RelType);
	}
	
	public void ReliefCategory(String RelCat) {
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_SearchDutyReliefAuthorizationActivityAndBalanceReportPage_ReliefCategory, "Enter Relief Category : ", RelCat);
	}
	
	public void SearchBtn() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_SearchDutyReliefAuthorizationActivityAndBalanceReportPage_Searchbtn, "Click on Search Button");
	}
	
	public void validateHeading() {
		Wait.waitfor(2);
		isDisplayed(driver, OCR_SearchDutyReliefAuthorizationActivityAndBalanceReportPage_ValidateHeading);
		Wait.waitfor(3);
		test.log(LogStatus.PASS, "Duty Relief Authorization Actvity & Balance Report Page is Displayed");
		
		
	}
	
}
