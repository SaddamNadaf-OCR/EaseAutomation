package lpAppBelgiumClasses;
/* 
 * Module : LP
 * Author  : Saddam
 * created date : April 2024
 * Descriptions : General Form For Belgium Country
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

public class ViewEditAuthorizationDetailsPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_ViewEditAuth_Save = "//button[@name='Save']";
	public static final String OCR_ViewEditAuth_BackToHeader = "//button[contains(text(),'Back to Header')]";
	public static final String OCR_ViewEditAuth_ApplicantSupplyDetailLabel = "//label[contains(text(),'Applicant/Supplier Details')]";
	public static final String OCR_ViewEdit_AppicantSupplier = "//a[contains(text(),'Applicant/Supplier')]";
	public static final String OCR_ViewEdit_ApplicantStatus = "//select[@id='searchForm_exporter_status']";
	public static final String OCR_ExporterCode = "//input[@name='exporter.expCode']";
	public static final String OCR_SearchPopupButton = "//button[@name='Search']";
	public static final String OCR_SelectPopupButton = "//button[@name='Ok']";
	public static final String OCR_CancelPopupIcon = "//button[@class='btn-close']";
	public static final String OCR_Code = "//input[@name='authorisationAddress.licAddrCode']";
	public static final String OCR_Name = "//input[@name='authorisationAddress.licAddrName']";
	public static final String OCR_Address = "//input[@name='authorisationAddress.licAddrAddr1']";
	public static final String OCR_City = "//input[@name='authorisationAddress.licAddrCity']";
	public static final String OCR_State = "//input[@name='authorisationAddress.licAddrStateName']";
	public static final String OCR_Country = "//input[@name='authorisationAddress.licAddrCountryName']";
	public static final String OCR_PinCode = "//input[@name='authorisationAddress.licAddrZip']";
	public static final String OCR_Phone = "//input[@name='authorisationAddress.licAddrPhone']";
	public static final String OCR_ViewEditAuth_CountryLabel = "(//label[contains(text(),'Country')])[3]";
	public static final String OCR_AddCountryButton = "//button[@id='countryBtn']";
	public static final String OCR_AddCountryDropDown = "//select[@name='authorisationCountryValue.countryCode']";
	public static final String OCR_CountryTypeDropDown = "//select[@id='editCountry_authorisationCountryValue_countryType']";
	public static final String OCR_ExportInfoCountry_MoveRightselectBtn = "//button[@name='Add']";
	public static final String OCR_ExportInfoCountry_MoveLeftselectBtn = "//button[@name='remove']";
	public static final String OCR_ExportInfoCountry_SaveandReturnBtn = "//input[@name='OK.x']";
	public static final String OCR_ExportInfoCountry_SaveBtn = "//input[@name='Save.x']";
	public static final String OCR_ExportInfoCountry_CancelBtn = "//input[@name='Cancel.x']";
	public static final String OCR_AddCountryGrid = "//div[@id='gbox_gridCountry']";
	public static final String OCR_ViewEditAuth_ItemsLabel = "//label[contains(text(),'Items')]";
	public static final String OCR_AddItem = "//button[@id='addItem']";
	public static final String OCR_AddFromExcelItem = "(//button[contains(text(),'Add from Excel')])[1]";
	public static final String OCR_ViewEditAuth_ClassificationLabel = "//label[contains(text(),'Classifications')]";
	public static final String OCR_ClassificationNumber = "//input[@name='eccnValue']";
	public static final String OCR_Add = "//button[@id='save-eccn']";
	public static final String OCR_ViewEditAuth_ForeignPartyDetails = "//label[contains(text(),'Foreign Party Details')]";
	public static final String OCR_AddForeignPartyButton = "//button[@id='fpartyBtn']";
	public static final String OCR_AddForeignPartyAddFromExcelButton = "(//button[contains(text(),'Add from Excel')])[2]";	
	public static final String OCR_ViewEditAuth_DomesticPartyDetails = "//label[contains(text(),'Domestic Party Details')]";
	public static final String OCR_AddDomesticPartyButton = "//button[@id='usPartyBtn']";
	public static final String OCR_AddDomesticPartyAddFromExcelButton = "(//button[contains(text(),'Add from Excel')])[3]";	
	public static final String OCR_ViewEditAuth_EndUseSpecificPurpose = "//label[contains(text(),'End Use/Specific Purpose')]";
	public static final String OCR_UploadExcel = "//input[@id='fileUpload']";

	/* ******************** Constructor ***************************** */

	public ViewEditAuthorizationDetailsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//Click on Save Button
	public void Save() {
		clickElement(driver, test, OCR_ViewEditAuth_Save, "Clicking on Save Button :");
	}
	
	//Click on Back to Header
	public void BacktoHeader() {
		clickElement(driver, test, OCR_ViewEditAuth_BackToHeader, "Clicking on Back To Header :");
	}
	
	//Click on Application Details Label
	public void applicationDetailsLabel(String ExporterCode, String ApplicantStatus, String Aname, String Aaddress, 
			String Acountry, String Astate, String Acity, String Apincode, String Aphone) {
		clickElement(driver, test, OCR_ViewEditAuth_ApplicantSupplyDetailLabel, "Clicking on Application Supply Details Label :");
		try {
			if(ExporterCode.length()> 0) {
				clickElement(driver, test, OCR_ViewEdit_AppicantSupplier, "Clicking on Applicant_Supplier Link :");
				try {
					typeText(driver, test, OCR_ExporterCode, "Entering Exporter Code :", ExporterCode);
					selectByVisibleText(driver, test, OCR_ViewEdit_ApplicantStatus, "Selecting Status :", ApplicantStatus);
					clickElement(driver, test, OCR_SearchPopupButton, "Clicking on Search Popup Button :");
					mouseOverAndClick(driver, test, "//td[contains(text(),'"+ExporterCode+"')]", "Selecting Applicant Supplier :");
					clickElement(driver, test, OCR_SelectPopupButton, "Clicking on Select Popup Button :");
				}catch(Exception e) {
					testFailSshot(driver, test);
					test.log(LogStatus.FAIL, "Enable to Select Applicant Supplier :");
					clickElement(driver, test, OCR_CancelPopupIcon, "Clicking on CLose Popup Icon :");
				}
			}else {
				typeText(driver, test, OCR_Name, "Entering Applicant Name :", Aname);
				typeText(driver, test, OCR_Address, "Entering Applicant Address :", Aaddress);
				typeText(driver, test, OCR_Country, "Entering Applicant Country :", Acountry);
				typeText(driver, test, OCR_State, "Entering Applicant State :", Astate);
				typeText(driver, test, OCR_City, "Entering Applicant City :", Acity);
				typeText(driver, test, OCR_PinCode, "Entering Applicant Pin Code :", Apincode);
				typeText(driver, test, OCR_Phone, "Entering Applicant Phone :", Aphone);
				
			}
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Applicant Supplier is Not Added :");
		}
	}
	
	//Click on Country Label
	public void addCountry(String CountryType,String AddCountry) {
		scrollToElement(driver, OCR_ViewEditAuth_CountryLabel);
		clickElement(driver, test, OCR_ViewEditAuth_CountryLabel, "Clicking on Country Label :");
		clickElement(driver, test, OCR_AddCountryButton, "Clicking on Add Country Button :");
		try {
			// Adding the Country
				selectByVisibleText(driver, test, OCR_CountryTypeDropDown, "Select Export country : ",
						CountryType);
				selectByVisibleText(driver, test, OCR_AddCountryDropDown, "Select Add country : ", AddCountry);
				clickElement(driver, test, OCR_ExportInfoCountry_MoveRightselectBtn, "Move selected country to Right ");
				clickElement(driver, test, OCR_ExportInfoCountry_SaveBtn, "Click on Save Button");
				clickElement(driver, test, OCR_ExportInfoCountry_SaveandReturnBtn, "Click on Save and Return Button");
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail To Add Country :");
			}
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ViewEditAuth_CountryLabel, "Clicking on Country Label :");
			//Added Country is Displaying in Grid
				try {
					if(isDisplayed(driver, "//td[contains(text(),'"+ AddCountry +"')]")) {
						test.log(LogStatus.PASS, "Added Country is Displayed in Grid :");
					}
				}catch(Exception e) {
					testFailSshot(driver, test);
					test.log(LogStatus.FAIL, "Added Country is Not Displayed in Grid :");
				}
	}
	
	//Click on Items Label 
	public void addItems(String UploadItemExcel) {
		clickElement(driver, test, OCR_ViewEditAuth_ItemsLabel, "Clicking on Add Items Label :");
		Wait.waitfor(3);
		//Add From Excel Button
		clickElement(driver, test, OCR_AddFromExcelItem, "Clicking on Add From Excel Button :");
		try {
			if (UploadItemExcel.length() > 0) {
				mouseOverAndClick(driver, test, OCR_UploadExcel, "Clicking on Upload Button :");
				Wait.waitfor(4);
				addFromExcel(driver, test, UploadItemExcel, "Excel is Added :"+UploadItemExcel);
				Wait.waitfor(2);
				clickElement(driver, test, "//button[@name='btn-sbmt']", "Clicking on Close Button :");
				Wait.waitfor(2);
			}
		} catch (Exception e) {
			e.printStackTrace();
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Excel is Not Added :");
		}
		
		clickElement(driver, test, OCR_ViewEditAuth_ItemsLabel, "Clicking on Add Items Label :");
		Wait.waitfor(3);
		
		//Added Items are Displaying in Grid
		/*try {
			if(isDisplayed(driver, OCR_AddCountryGrid)) {
				test.log(LogStatus.PASS, "Added Items is Displayed in Grid :");
			}
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Added Items is Not Displayed in Grid :");
		}*/
	}
	
	//Click on Classification Labels
	public void addClassification(String classification) {
		clickElement(driver, test, OCR_ViewEditAuth_ClassificationLabel, "Clicking on Classification Label :");
		try {
			typeText(driver, test, OCR_ClassificationNumber, "Adding Classification Number :", classification);
			clickElement(driver, test, OCR_Add, "Clicking on Add Classifiaction :");
		}catch(Exception e) {
			testFailSshot(driver, test);
		}
		//Validation
		try {
			if(isDisplayed(driver, OCR_ViewEditAuth_ClassificationLabel+classification)) {
				test.log(LogStatus.PASS, "Added Classic=fication is Displayed :");
			}
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Added Classification is Not Displayed :");
		}
	}
	
	//Click on Foreign party Details label
	public void foreignPartyDetails(String UploadForeignPartyExcel) {
		clickElement(driver, test, OCR_ViewEditAuth_ForeignPartyDetails, "Clicking on Foreign Party Details Label :");
		//clickElement(driver, test, OCR_AddForeignPartyButton, "Clicking on Add Foreign Party Button :");
		Wait.waitfor(2);
		//Add From Excel Button
		clickElement(driver, test, OCR_AddForeignPartyAddFromExcelButton, "Clicking on Add From Excel Button :");
		try {
			if (UploadForeignPartyExcel.length() > 0) {
				mouseOverAndClick(driver, test, OCR_UploadExcel, "Clicking on Upload Button :");
				Wait.waitfor(4);
				addFromExcel(driver, test, UploadForeignPartyExcel, "Excel is Added :"+UploadForeignPartyExcel);
				Wait.waitfor(2);
				clickElement(driver, test, "//button[@name='btn-sbmt']", "Clicking on Close Button :");
				Wait.waitfor(2);
			}
		} catch (Exception e) {
			e.printStackTrace();
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Excel is Not Added :");
		}
	}
	
	//Click on Domestic Party Details
	public void domesticPartyDetails(String UploadDomesticPartyExcel) {
		clickElement(driver, test, OCR_ViewEditAuth_DomesticPartyDetails, "Clicking on Domestic Party Details Label :");
		//clickElement(driver, test, OCR_AddDomesticPartyButton, "Clicking on Add Domestic Party Button :");
		//Add From Excel Button
		clickElement(driver, test, OCR_AddDomesticPartyAddFromExcelButton, "Clicking on Add From Excel Button :");
		try {
			if (UploadDomesticPartyExcel.length() > 0) {
				mouseOverAndClick(driver, test, OCR_UploadExcel, "Clicking on Upload Button :");
				Wait.waitfor(4);
				addFromExcel(driver, test, UploadDomesticPartyExcel, "Excel is Added :"+UploadDomesticPartyExcel);
				Wait.waitfor(2);
				clickElement(driver, test, "//button[@name='btn-sbmt']", "Clicking on Close Button :");
				Wait.waitfor(2);
			}
		} catch (Exception e) {
			e.printStackTrace();
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Excel is Not Added :");
		}
	}
	
	//Click on End User Details
	public void endUserDetails() {
		clickElement(driver, test, OCR_ViewEditAuth_EndUseSpecificPurpose, "Clicking on End-User Specific Purpose Label :");
	}


}
