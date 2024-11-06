package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchAuthorizationExpiringReportPage extends GenericMethods{
	

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_SearchAuthorizationBalanceSummaryPage_SBU = "//select[@id='reportLicExpire_licenseHeader_sbuCode']";
	public static final String OCR_SearchAuthorizationBalanceSummaryPage_AuthType = "//textarea[@id='reportLicExpire_licenseHeader_licenseType']";
	public static final String OCR_SearchAuthorizationBalanceSummaryPage_AuthTypeLink = "(//a[@data-ocr-role='modal-link'])[contains(text(),'Authorization Type')]";
	public static final String OCR_SearchAuthorizationBalanceSummaryPage_Activity = "//select[@id='licTypePopupForm_licenseTypes_activityType']";
	public static final String OCR_SearchAuthorizationBalanceSummaryPage_SearchBtn = "(//button[@name='Search'][@class='primary-btn popupSearchButton'])[1]";
	public static final String OCR_SearchAuthorizationBalanceSummaryPage_SelectBtn = "(//button[@name='Ok'])[1]";
	public static final String OCR_SearchAuthorizationBalanceSummaryPage_CloseBtn = "(//button[@class='btn-close'])[1]";
	public static final String OCR_SearchAuthorizationBalanceSummaryPage_AuthNo = "//a[contains(text(),'Authorization No')]";
	public static final String OCR_SearchAuthorizationBalanceSummaryPage_AuthNoEntry = "//input[@id='searchForm_dosGeneralInfoDTO_licenseNo']";
	public static final String OCR_SearchAuthorizationBalanceSummaryPage_SearchBtnPopUp = "//button[@id='searchAgreementNoPopUp']";
	public static final String OCR_SearchAuthorizationBalanceSummaryPage_SelectBtnPopUp = "(//button[@class='primary-btn recordFromPopup'])[1]";
	public static final String OCR_SearchAuthorizationBalanceSummaryPage_CloseBtnPopUp = "(//button[@class='btn-close'])[1]";
	public static final String OCR_SearchAuthorizationBalanceSummaryPage_AuthNoTextInput = "//input[@id='reportLicExpire_licenseHeader_licenseNo']";
	public static final String OCR_SearchAuthorizationBalanceSummaryPage_ValidateHeading = "//h3[contains(text(),'Authorization Expiring Report')]";
	public static final String OCR_SearchAuthorizationBalanceSummaryPage_Search = "(//button[@name='Search'])[1]";
	public static final String Ocr_Auth_Exp_Report_Program ="(//a[contains(text(),'Program')])[3]";
	public static final String Ocr_Auth_Exp_Report_ProgramCodePop = "//input[@name='programTab.programCode']";
	public static final String Ocr_Auth_Exp_Report_ProgramSearchPop= "(//button[@class='primary-btn popupSearchButton'])[1]";
	public static final String Ocr_Auth_Exp_Report_ProgramSelectBtnPop = "(//button[@class='primary-btn recordFromPopup'])[1]";
	public static final String Ocr_Auth_Exp_Report_Segment = "(//a[contains(text(),'Segment')])[2]";
	public static final String OCR_SegmentSelectOk = "(//button[@name='Ok'])[1]";
	public static final String Ocr_ClosePopUp = "(//button[@class='btn-close'])[1]";
	public static final String Ocr_Auth_Exp_Report_Site = "(//a[contains(text(),'Site')])[4]";
	public static final String Ocr_Auth_Exp_Report_SiteCode = "//input[@name='dosSite.siteId']";
	public static final String Ocr_Auth_Exp_Report_Department ="(//a[contains(text(),'Department')])";
	public static final String Ocr_Auth_Exp_Report_ExpireDatefrom = "//input[@name='fromExpireDate']";
	public static final String Ocr_Auth_Exp_Report_ExpireDateTo = "//input[@name='toExpireDate']";
	public static final String OCR_Today = "//button[@data-handler='today']";
	public static final String OCR_RESET = "(//button[@type='reset'])[1]";
	public static final String OCR_Country = "//input[@name='licenseCountry.countryDescription']";
	/* ******************************* Constructor ****************************** */

	public SearchAuthorizationExpiringReportPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	public void selectSBU(String sbu) {
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_SearchAuthorizationBalanceSummaryPage_SBU, "Select SBU Code : ", sbu);

	}
	 public void enterAuthType(String AuthType, String AuthTypeLink) {
		 Wait.waitfor(2);
		 typeText(driver, test, OCR_SearchAuthorizationBalanceSummaryPage_AuthType, "Enter Authorization Type : ", AuthType);
		 try {
				if (AuthTypeLink.length() > 0) {
					Wait.waitfor(2);
					clickElement(driver, test, OCR_SearchAuthorizationBalanceSummaryPage_AuthTypeLink, "Click on Authorization Type Link");
					clickElement(driver, test, OCR_SearchAuthorizationBalanceSummaryPage_SearchBtn, "Click on Pop-Up Search button");
					clickElement(driver, test, "//td[contains(text(),'"+ AuthTypeLink +"')]", "Select the Authorization Type : " + AuthTypeLink);
					clickElement(driver, test, OCR_SearchAuthorizationBalanceSummaryPage_SelectBtn, "Click on Select button");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_SearchAuthorizationBalanceSummaryPage_CloseBtn, "Click on Close popup icon");
			}
	 }
		 
	 public void authNo(String AuthNoLink, String AuthNumber) {
		 if(AuthNoLink.length() > 0) {
			 Wait.waitfor(2);
			 clickElement(driver, test, OCR_SearchAuthorizationBalanceSummaryPage_AuthNo, "Click on Authorization No");
			 try {
				typeText(driver, test, OCR_SearchAuthorizationBalanceSummaryPage_AuthNoEntry, "Enter Authorization Number in pop-up : ", AuthNoLink);
				 clickElement(driver, test, OCR_SearchAuthorizationBalanceSummaryPage_SearchBtnPopUp, "Click on Search button in Pop-Up");
				 clickElement(driver, test, "//td[contains(text(),'"+ AuthNoLink +"')]", "Select the Authorization Number : " +AuthNoLink);
				 clickElement(driver, test, OCR_SearchAuthorizationBalanceSummaryPage_SelectBtnPopUp, "Click on Select Button in Pop-Up");
			 }
			 
			 catch (Exception e) {
					testFailSshot(driver, test);
					clickElement(driver, test, OCR_SearchAuthorizationBalanceSummaryPage_CloseBtnPopUp, "Click on Close popup icon");
				}
			} else {
				typeText(driver, test, OCR_SearchAuthorizationBalanceSummaryPage_AuthNoTextInput, "Enter the Authorization Number : ", AuthNumber);
				}
		  }
	 
	 public void searchBtn() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_SearchAuthorizationBalanceSummaryPage_Search, "Click on Search Button");
	 }
	 
	 public void validateHeading() {
		 Wait.waitfor(2);
			isDisplayed(driver, OCR_SearchAuthorizationBalanceSummaryPage_ValidateHeading);
			Wait.waitfor(3);
			test.log(LogStatus.PASS, "Authorization Expiring Report Page is Displayed");
			Wait.waitfor(3);
	 }
	//****************************************Regression*******************************************//
	 public void search() {
			clickElement(driver, test, OCR_SearchAuthorizationBalanceSummaryPage_Search, "Click on Search :");
		}

	// Click on Reset
		public void reset() {
			clickElement(driver, test, OCR_RESET, "Click on Reset :");
		}
		
	 public void SearchByParameter (String sbu, String AuthTypeLink, String AuthType, String AuthNoLink, 
			 String AuthNumber, String Country, String Program, String Segment, String Site, String Department) {
		 if (sbu.length() > 0) {
		 selectByVisibleText(driver, test, OCR_SearchAuthorizationBalanceSummaryPage_SBU, "Select SBU Code : ", sbu); 
		 }
		 typeText(driver, test, OCR_SearchAuthorizationBalanceSummaryPage_AuthType, "Enter Authorization Type : ", AuthType);
		 try {
				if (AuthTypeLink.length() > 0) {
					Wait.waitfor(2);
					clickElement(driver, test, OCR_SearchAuthorizationBalanceSummaryPage_AuthTypeLink, "Click on Authorization Type Link");
					clickElement(driver, test, OCR_SearchAuthorizationBalanceSummaryPage_SearchBtn, "Click on Pop-Up Search button");
					clickElement(driver, test, "//td[contains(text(),'"+ AuthTypeLink +"')]", "Select the Authorization Type : " + AuthTypeLink);
					clickElement(driver, test, OCR_SearchAuthorizationBalanceSummaryPage_SelectBtn, "Click on Select button");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_SearchAuthorizationBalanceSummaryPage_CloseBtn, "Click on Close popup icon");
			}
		 
	 
	 if(AuthNoLink.length() > 0) {
		 Wait.waitfor(2);
		 clickElement(driver, test, OCR_SearchAuthorizationBalanceSummaryPage_AuthNo, "Click on Authorization No");
		 try {
			typeText(driver, test, OCR_SearchAuthorizationBalanceSummaryPage_AuthNoEntry, "Enter Authorization Number in pop-up : ", AuthNoLink);
			 clickElement(driver, test, OCR_SearchAuthorizationBalanceSummaryPage_SearchBtnPopUp, "Click on Search button in Pop-Up");
			 clickElement(driver, test, "//td[contains(text(),'"+ AuthNoLink +"')]", "Select the Authorization Number : " +AuthNoLink);
			 clickElement(driver, test, OCR_SearchAuthorizationBalanceSummaryPage_SelectBtnPopUp, "Click on Select Button in Pop-Up");
		 }
		 
		 catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_SearchAuthorizationBalanceSummaryPage_CloseBtnPopUp, "Click on Close popup icon");
			}
		} else {
			typeText(driver, test, OCR_SearchAuthorizationBalanceSummaryPage_AuthNoTextInput, "Enter the Authorization Number : ", AuthNumber);
			}
	 
	 if(Country.length() > 0) {
		 typeText(driver, test, OCR_Country, "Enter Country :", Country);
	 }
	 if (Program.length() > 0) {
		 Wait.waitfor(1);
		 clickElement(driver, test, Ocr_Auth_Exp_Report_Program, "Click on Program");
		 try {
		  typeText(driver, test, Ocr_Auth_Exp_Report_ProgramCodePop, "Enter Program Code :   ", Program);
		  clickElement(driver, test, Ocr_Auth_Exp_Report_ProgramSearchPop, "Click on Search :");
		  clickElement(driver, test, "//td[contains(text(),'"+ Program +"')]", "Select the Authorization Number : " +Program);
		  clickElement(driver, test, Ocr_Auth_Exp_Report_ProgramSelectBtnPop, "Click on Select");
		 }
		 catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_SearchAuthorizationBalanceSummaryPage_CloseBtnPopUp, "Click on Close popup icon");
			}
		} 
	 
	    if (Segment.length() > 0) {
		 Wait.waitfor(1);
		 clickElement(driver, test, Ocr_Auth_Exp_Report_Segment, "Click on Segment");
		 try {

				Wait.waitfor(2);
				clickElement(driver, test, "//td[contains(text(),'" + Segment + "')]",
						"Select the Authorization Type : " + Segment);
				clickElement(driver, test, OCR_SegmentSelectOk, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, Ocr_ClosePopUp, "Click on Close popup icon");

			}
	 }
	 
	 
	 if (Site.length() > 0) {
		 Wait.waitfor(1);
		 clickElement(driver, test, Ocr_Auth_Exp_Report_Site, "Click on site");
		 try {
		  typeText(driver, test, Ocr_Auth_Exp_Report_SiteCode, "Enter Program Code :   ", Site);
		  clickElement(driver, test, Ocr_Auth_Exp_Report_ProgramSearchPop, "Click on Search :");
		  clickElement(driver, test, "//td[contains(text(),'"+ Site +"')]", "Select the Authorization Number : " +Site);
		  clickElement(driver, test, Ocr_Auth_Exp_Report_ProgramSelectBtnPop, "Click on Select");
		 }
		 catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_SearchAuthorizationBalanceSummaryPage_CloseBtnPopUp, "Click on Close popup icon");
			}
		} 
	 if (Department.length() > 0) {
		 Wait.waitfor(1);
		 clickElement(driver, test, Ocr_Auth_Exp_Report_Department, "Click on Department");
		 try {

				Wait.waitfor(2);
				clickElement(driver, test, "//td[contains(text(),'" + Department + "')]",
						"Select the Authorization Type : " + Department);
				clickElement(driver, test, OCR_SegmentSelectOk, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, Ocr_ClosePopUp, "Click on Close popup icon");

			}
	 }
	 }
}
