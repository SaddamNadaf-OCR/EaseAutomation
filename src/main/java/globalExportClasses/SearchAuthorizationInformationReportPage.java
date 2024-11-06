package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchAuthorizationInformationReportPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_SearchAuthorizationInformationReportPage_SBU = "//select[@id='generateReport_licenseHeader_sbuCode']";
	public static final String OCR_SearchAuthorizationInformationReportPage_AuthNo = "//input[@id='generateReport_licenseHeader_licenseNo']";
	public static final String OCR_SearchAuthorizationInformationReportPage_AuthTypeLink = "(//a[@data-ocr-role='modal-link'])[contains(text(),'Authorization Type')]";
	public static final String OCR_SearchAuthorizationInformationReportPage_SearchPopUp = "(//button[@name='Search'])[1]";
	public static final String OCR_SearchAuthorizationInformationReportPage_SelectBtn = "(//button[@name='Ok'])[1]";
	public static final String OCR_SearchAuthorizationInformationReportPage_AuthType = "//textarea[@id='generateReport_licenseHeader_licenseType']";
	public static final String OCR_SearchAuthorizationInformationReportPage_CloseBtnPopUp = "(//button[@class='btn-close'])[1]";
	public static final String OCR_SearchAuthorizationInformationReportPage_AuthStatus = "//select[@id='generateReport_licenseHeader_licenseStatus']";
	public static final String OCR_SearchAuthorizationInformationReportPage_ValidateHeading = "//h3[contains(text(),'Authorization Information Report')]";
	public static final String OCR_SearchAuthorizationInformationReportPage_SearchBtn = "//button[contains(text(),'Search')]";
	public static final String OCR_AuthInfo_Agency = "//select[@name='licenseHeader.controllingAgency']";
	public static final String OCR_AuthInfo_Program = "(//a[contains(text(),'Program')])[3]";
	public static final String OCR_AuthInfo_ProgramCodePop = "//input[@name='programTab.programCode']";
	public static final String OCR_AuthInfo_ProgramSearchPop = "(//button[@class='primary-btn popupSearchButton'])[1]";
	public static final String OCR_AuthInfo_ProgramSelectBtnPop = "(//button[@class='primary-btn recordFromPopup'])[1]";
	public static final String Ocr_ClosePopUp = "(//button[@class='btn-close'])[1]";
	public static final String OCR_AuthInfo_RefNo = "(//input[@id='generateReport_licenseHeader_referenceNo'])";
	public static final String OCR_AuthInfo_ContractNo = "//input[@name='licenseHeader.contractNo']";
	public static final String OCR_AuthInfoExpireDateFrom = "//input[@name='fromExpireDate']";
	public static final String OCR_ExpireDateTo = "//input[@name='toExpireDate']";
	public static final String OCR_AuthInfo_Today = "//button[@data-handler='today']";
	public static final String OCR_AuthInfo_UltConsingnee = "//input[@id='generateReport_licUltCons']";
	public static final String OCR_AuthInfo_Country1 = "(//input[@name=''])[1]";
	public static final String OCR_AuthInfo_EndUser = "(//input[@id='generateReport_licEuCons'])[1]";

	// ***************Selection criteria based on Authorization// Item*******////////////////////

	public static final String OCR_AuthInfo_sbuCode = "(//select[@name='licenseHeader.sbuCode'])";
	public static final String OCR_AuthInfo_Country2 = "(//input[@name=''])[2]";
	public static final String OCR_AuthInfo_PartNo = "//input[@name='licenseItem.productCd']";
	public static final String OCR_AuthInfo_Description = "//textarea[@name='licenseItem.description']";
	public static final String OCR_AuthInfo_Value = "//input[@id='generateReport_licenseValue']";
	public static final String OCR_AuthInfo_CreatedBy = "//select[@name='licenseHeader.createdBy']";
	public static final String OCR_RESET = "(//button[@type='reset'])[1]";

	/* ******************************* Constructor ****************************** */

	public SearchAuthorizationInformationReportPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	public void selectSBU(String sbu) {
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_SearchAuthorizationInformationReportPage_SBU, "Select SBU Code : ", sbu);

	}

	public void authNo(String AuthNo) {
		Wait.waitfor(2);
		typeText(driver, test, OCR_SearchAuthorizationInformationReportPage_AuthNo, "Enter Authorization Number : ",AuthNo);
	}

	public void enterAuthType(String AuthTypeLink, String AuthType) {
		Wait.waitfor(2);
		if (AuthTypeLink.length() > 0) {
			try {
				clickElement(driver, test, OCR_SearchAuthorizationInformationReportPage_AuthTypeLink,"Click on Authorization Type Link");
				clickElement(driver, test, OCR_SearchAuthorizationInformationReportPage_SearchPopUp,"Click on Search button");
				clickElement(driver, test, "//td[contains(text(),'" + AuthTypeLink + "')]","Select the Authorization Type : " + AuthTypeLink);
				clickElement(driver, test, OCR_SearchAuthorizationInformationReportPage_SelectBtn,"Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_SearchAuthorizationInformationReportPage_CloseBtnPopUp,"Click on Close popup icon");
			}

		} 
		else {
			typeText(driver, test, OCR_SearchAuthorizationInformationReportPage_AuthType,"Enter the Authorization Type : ", AuthType);
		}

	}

	public void authStatus(String AuthStatus) {
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_SearchAuthorizationInformationReportPage_AuthStatus,"Select Authorization Status : ", AuthStatus);

	}

	public void SearchBtn() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_SearchAuthorizationInformationReportPage_SearchBtn, "Click on Search Button");
	}

	public void validateHeading() {
		isDisplayed(driver, OCR_SearchAuthorizationInformationReportPage_ValidateHeading);
		Wait.waitfor(3);
		test.log(LogStatus.PASS, "Authorization Information Report Page is Displayed");
		Wait.waitfor(3);
	}

	///////////// ********Regression**********************////////////////////////////

	public void search() {
		clickElement(driver, test, OCR_SearchAuthorizationInformationReportPage_SearchBtn, "Click on Search :");
	}

	// Click on Reset
	public void reset() {
		clickElement(driver, test, OCR_RESET, "Click on Reset :");
    }

	public void SearchByParameter(String AuthNo, String AuthTypeLink, String AuthType, String AuthStatus, String Agency, 
			String Program, String RefNo, String ContractNo, String FromDate, String EndDate, String UltConsingnee, 
			String Country, String EndUser, String SbuCode, String PartNo,String ItemValue, String Description) {
		
		if(AuthNo.length() > 0) {
			typeText(driver, test, OCR_SearchAuthorizationInformationReportPage_AuthNo, "Enter Authorization Number : ",AuthNo);
		}
		if (AuthTypeLink.length() > 0) {
			try {
				clickElement(driver, test, OCR_SearchAuthorizationInformationReportPage_AuthTypeLink,"Click on Authorization Type Link");
				clickElement(driver, test, OCR_SearchAuthorizationInformationReportPage_SearchPopUp,"Click on Search button");
				clickElement(driver, test, "//td[contains(text(),'" + AuthTypeLink + "')]","Select the Authorization Type : " + AuthTypeLink);
				clickElement(driver, test, OCR_SearchAuthorizationInformationReportPage_SelectBtn,"Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_SearchAuthorizationInformationReportPage_CloseBtnPopUp,"Click on Close popup icon");
			}

		} 
		else {
			typeText(driver, test, OCR_SearchAuthorizationInformationReportPage_AuthType,"Enter the Authorization Type : ", AuthType);
		}
		if(AuthStatus.length() > 0) {
			selectByVisibleText(driver, test, OCR_SearchAuthorizationInformationReportPage_AuthStatus,"Select Authorization Status : ", AuthStatus);
		}
    	if(Agency.length() > 0) {
    		selectByVisibleText(driver, test, OCR_AuthInfo_Agency, "Select Agency :", Agency);
    	}
    	if (Program.length() > 0) {
    		Wait.waitfor(1);
    		clickElement(driver, test, OCR_AuthInfo_Program, "Click on Program");
    		try {
    			typeText(driver, test, OCR_AuthInfo_ProgramCodePop, "Enter Program Code :   ", Program);
    			clickElement(driver, test, OCR_AuthInfo_ProgramSearchPop, "Click on Search :");
    			clickElement(driver, test, "//td[contains(text(),'"+ Program +"')]", "Select the Authorization Number : " +Program);
    			clickElement(driver, test, OCR_AuthInfo_ProgramSelectBtnPop, "Click on Select");
    		 }
    		catch (Exception e) {
    			testFailSshot(driver, test);
    			clickElement(driver, test, Ocr_ClosePopUp, "Click on Close popup icon");
    		}
    	} 
        if (RefNo.length()>0) {
        	typeText(driver, test, OCR_AuthInfo_RefNo, "Enter Ref No :", RefNo);
        }
        if (ContractNo.length()>0) {
        	typeText(driver, test, OCR_AuthInfo_ContractNo, "enter contractNo", ContractNo);
        }
    	if (FromDate.length() > 0) {
			clickElement(driver, test, OCR_AuthInfoExpireDateFrom, "Click on From date");
			if (FromDate.equalsIgnoreCase("Today")) {
				clickElement(driver, test, OCR_AuthInfo_Today, "Selecting Today");
			} else {
				date(driver, test, "Select date", FromDate);
			}
		}
		if (EndDate.length() > 0) {
			clickElement(driver, test, OCR_ExpireDateTo, "Click on End date");
			if (EndDate.equalsIgnoreCase("Today")) {
				clickElement(driver, test, OCR_AuthInfo_Today, "Selecting Today");
			} else {
				date(driver, test, "Select date", EndDate);
			}
		}
	   if (UltConsingnee.length()>0) {
		   typeText(driver, test, OCR_AuthInfo_UltConsingnee, "Enter Ult Consignee :", UltConsingnee);

	   }
	   if (Country.length()>0) {
		   typeText(driver, test, OCR_AuthInfo_Country1, "Enter Country  :", Country);
	   }
	   if (EndUser.length ()> 0) {
		   typeText(driver, test, OCR_AuthInfo_EndUser, "Enter EndUSer  :", EndUser);
	   }
	   if(SbuCode.length() > 0) {
		   selectByVisibleText(driver, test, OCR_AuthInfo_sbuCode, "Enter Sbu Code :", SbuCode);
	   }
	   if (PartNo.length ()>0) {
		   typeText(driver, test, OCR_AuthInfo_PartNo, "Enter PartNo:", PartNo);
	   }
	   if (ItemValue.length()> 0) {
		   typeText(driver, test, OCR_AuthInfo_Value, "Enter Item Value :", ItemValue);
	   }
	   if (Description.length()>0) {
		   typeText(driver, test, OCR_AuthInfo_Description, "Enter Description : ", Description);
	   }
	}
}	
	
