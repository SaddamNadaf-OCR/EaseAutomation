package incident_Management;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class SearchDS_7787VoluntaryDisclosureFormPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String DS_7787_Heading = "//h3[contains(text(),'Search DS-7787 Voluntary Disclosure Form')]";
	public static final String DS_7787_SearchButton = "//button[contains(text(),'Search')]";
	public static final String DS_7787_ResetButton = "//button[contains(text(),'Reset')]";
	public static final String DS_7787_Add_DS_7787_Button = "//button[contains(text(),'Add DS-7787 Form')]";
	public static final String DS_7787_SBU = "//select[@name='citVoluntaryDisclosureValue.sbuCode']";
	public static final String DS_7787_Transaction_Id = "//a[contains(text(),'Transaction Id')]";
	public static final String DS_7787_TransactionIdPopup = "//input[@name='transactionId']";
	public static final String DS_7787_SearchPopup = "(//button[@name='Search'])[2]";
	public static final String DS_7787_SelectPopup = "//button[contains(text(),'Select')]";
	public static final String DS_7787_ClosePopup = "//button[@class='btn-close']";
	public static final String DS_7787_TransactionIdTextbox = "//input[@name='citVoluntaryDisclosureValue.transactionId']";
	public static final String DS_7787_AuthorizationNo = "//a[contains(text(),'Authorization No')]";
	public static final String DS_7787_AuthorizatioNoPopup = "//input[@id='searchForm_dosGeneralInfoDTO_licenseNo']";
	public static final String DS_7787_AuthorizationNoTextbox = "//input[@id='searchVDGeneralInfo_citVoluntaryDisclosureValue_licenseNo']";
	public static final String DS_7787_Status = "//select[@id='searchVDGeneralInfo_citVoluntaryDisclosureValue_status']";
	public static final String DS_7787_WLSStatus = "//select[@id='searchVDGeneralInfo_citVoluntaryDisclosureValue_dplStatus']";
	public static final String DS_7787_POAName = "//a[contains(text(),'POA Name')]";
	public static final String DS_7787_UserFirstName = "//input[@id='searchForm_userProfile_userFirstname']";
	public static final String DS_7787_POANameTextbox = "//input[@id='searchVDGeneralInfo_citVoluntaryDisclosureValue_poaName']";
	public static final String DS_7787_CountryName = "//input[@id='countryName']";
//	public static final String DS_7787_RequiredByDate = "//input[@id='editExportRequest_expReqByDate']";
//	public static final String DS_7787_RequiredByDate_Today = "//button[contains(text(),'Today')]";
//	public static final String DS_7787_BuisnessUnit = "//select[@id='editExportRequest_sbuCode']";
//	public static final String DS_7787_RequiredByDate = "//input[@id='editExportRequest_expReqByDate']";
//	public static final String DS_7787_RequiredByDate_Today = "//button[contains(text(),'Today')]";
//	public static final String DS_7787_BuisnessUnit = "//select[@id='editExportRequest_sbuCode']";
//	public static final String DS_7787_RequiredByDate = "//input[@id='editExportRequest_expReqByDate']";
//	public static final String DS_7787_RequiredByDate_Today = "//button[contains(text(),'Today')]";
//	public static final String DS_7787_BuisnessUnit = "//select[@id='editExportRequest_sbuCode']";
//	public static final String DS_7787_RequiredByDate = "//input[@id='editExportRequest_expReqByDate']";
//	public static final String DS_7787_RequiredByDate_Today = "//button[contains(text(),'Today')]";
//	public static final String DS_7787_BuisnessUnit = "//select[@id='editExportRequest_sbuCode']";
//	public static final String DS_7787_RequiredByDate = "//input[@id='editExportRequest_expReqByDate']";
//	public static final String DS_7787_RequiredByDate_Today = "//button[contains(text(),'Today')]";
//	public static final String DS_7787_BuisnessUnit = "//select[@id='editExportRequest_sbuCode']";
//	public static final String DS_7787_RequiredByDate = "//input[@id='editExportRequest_expReqByDate']";
//	public static final String DS_7787_RequiredByDate_Today = "//button[contains(text(),'Today')]";
//	public static final String DS_7787_BuisnessUnit = "//select[@id='editExportRequest_sbuCode']";
//	public static final String DS_7787_RequiredByDate = "//input[@id='editExportRequest_expReqByDate']";
//	public static final String DS_7787_RequiredByDate_Today = "//button[contains(text(),'Today')]";
//	public static final String DS_7787_BuisnessUnit = "//select[@id='editExportRequest_sbuCode']";
//	public static final String DS_7787_RequiredByDate = "//input[@id='editExportRequest_expReqByDate']";
//	public static final String DS_7787_RequiredByDate_Today = "//button[contains(text(),'Today')]";
//	public static final String DS_7787_BuisnessUnit = "//select[@id='editExportRequest_sbuCode']";
//	public static final String DS_7787_RequiredByDate = "//input[@id='editExportRequest_expReqByDate']";
//	public static final String DS_7787_RequiredByDate_Today = "//button[contains(text(),'Today')]";
//	public static final String DS_7787_BuisnessUnit = "//select[@id='editExportRequest_sbuCode']";
//	public static final String DS_7787_RequiredByDate = "//input[@id='editExportRequest_expReqByDate']";
//	public static final String DS_7787_RequiredByDate_Today = "//button[contains(text(),'Today')]";
//	public static final String DS_7787_BuisnessUnit = "//select[@id='editExportRequest_sbuCode']";
//	public static final String DS_7787_RequiredByDate = "//input[@id='editExportRequest_expReqByDate']";
//	public static final String DS_7787_RequiredByDate_Today = "//button[contains(text(),'Today')]";
	
	/* ******************************* Constructor ****************************** */

	public SearchDS_7787VoluntaryDisclosureFormPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//Click on Search Button
	public void searchButton() {
		clickElement(driver, test, DS_7787_SearchButton, "Clicking on Search Button :");
	}
	
	//Click on Reset Button
	public void resetButton() {
		clickElement(driver, test, DS_7787_ResetButton, "Clicking on Reset Button :");
	}
	
	//Click on Add DS-7787 Form Button
	public void addDS_7787Form() {
		clickElement(driver, test, DS_7787_Add_DS_7787_Button, "Clicking on Add DS-7787 Form Button :");
	}
	
	//Search with Different Parameters
	public void searchWithParameters(String SBU, String TransactionID, String AuthorizationNo, String Status, 
			String WLSStatus, String POAName) {
		
		if(SBU.length() > 0) {
			selectByVisibleText(driver, test, DS_7787_SBU, "Selecting SBU Parameter :", SBU);
		}
		if(TransactionID.length() > 0) {
			clickElement(driver, test, DS_7787_Transaction_Id, "Clicking on Transaction ID Link :");
			try {
				typeText(driver, test, DS_7787_TransactionIdPopup, "Entering Transaction ID :", TransactionID);
				clickElement(driver, test, DS_7787_SearchPopup, "Clicking on Search Button in Popup :");
				clickElement(driver, test, "//td[contains(text(),'"+TransactionID+"')]", "Selecting Transaction ID :");
				clickElement(driver, test, DS_7787_SelectPopup, "Clicking on Select Button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select the Transaction ID :");
				clickElement(driver, test, DS_7787_ClosePopup, "Clicking on Close Popup :");
			}
		}else {
			typeText(driver, test, DS_7787_TransactionIdTextbox, "Entering Transaction ID :", TransactionID);
		}
		if(AuthorizationNo.length() > 0) {
			clickElement(driver, test, DS_7787_AuthorizationNo, "Clicking on Authorization No Link :");
			try {
				typeText(driver, test, DS_7787_AuthorizatioNoPopup, "Entering Authorization No :", AuthorizationNo);
				clickElement(driver, test, DS_7787_SearchPopup, "Clicking on Search Button in Popup :");
				clickElement(driver, test, "//td[contains(text(),'"+AuthorizationNo+"')]", "Selecting Authorization No :");
				clickElement(driver, test, DS_7787_SelectPopup, "Clicking on Select Button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select the Authorization No :");
				clickElement(driver, test, DS_7787_ClosePopup, "Clicking on Close Popup :");
			}
		}else {
			typeText(driver, test, DS_7787_AuthorizationNoTextbox, "Entering Authorization No :", AuthorizationNo);
		}
		if(Status.length() > 0) {
			selectByVisibleText(driver, test, DS_7787_Status, "Selecting Status Parameter :", Status);
		}
		if(WLSStatus.length() > 0) {
			selectByVisibleText(driver, test, DS_7787_WLSStatus, "Selecting WLS Status Parameter :", WLSStatus);
		}
		if(POAName.length() > 0) {
			clickElement(driver, test, DS_7787_POAName, "Clicking on POA Name Link :");
			try {
				typeText(driver, test, DS_7787_UserFirstName, "Entering User First Name :", POAName);
				clickElement(driver, test, DS_7787_SearchPopup, "Clicking on Search Button in Popup :");
				clickElement(driver, test, "//td[contains(text(),'"+POAName+"')]", "Selecting POA Name :");
				clickElement(driver, test, DS_7787_SelectPopup, "Clicking on Select Button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select the POA Name :");
				clickElement(driver, test, DS_7787_ClosePopup, "Clicking on Close Popup :");
			}
		}else {
			typeText(driver, test, DS_7787_POANameTextbox, "Entering POA Name :", POAName);
		}
	}

}
