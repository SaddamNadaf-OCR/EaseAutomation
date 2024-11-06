package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class CreateNewPart130ReportPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	//............................Locators..................................//
	public static final String CeatePart_Save="//button[@name='Save']";
	public static final String CeatePart_SaveandReturn="//button[@name='ok']";
	public static final String CreatePart_Cancel="//button[@name='Cancel']";
	public static final String CreatePart_Status="//input[@name='status']";
	public static final String CreatePart_RefID="//input[@name='part130Value.part130Id']";
	public static final String CreatePart_POA="//input[@name='part130Value.poa']";
	public static final String CreatePart_ContactNoPopUp="//a[contains(text(),'Contract No')]";
	public static final String CreatePart_Contacts="//input[@name='contract.contractNo']";
	public static final String CreatePart_SearchPopUp="(//button[contains(text(),'Search')])[1]";
	public static final String CreatePart_Select="(//button[contains(text(),'Select')])[1]";
	public static final String CreatePart_ClosePopup="//button[@class='btn-close']";
	public static final String CreatePart_ContactNo="//input[@name='part130Value.contractNo']";
	public static final String CreatePart_AgreementNo="//a[contains(text(),'Agreement No')]";
	public static final String CreatePart_TransactionId="//input[@name='dosGeneralInfoDTO.licenseNo']";
	public static final String CreatePart_SearchPopUp1="//button[@id='searchAgreementNoPopUp']";
	public static final String CreatePart_Select1="//button[contains(text(),'Select')]";
	public static final String CreatePart_AgreementNoTextBox="//input[@name='part130Value.licAggNo']";
	public static final String CreatePart_licAggNo="//input[@name='part130Value.licAggNo']";
	public static final String CreatePart_Part130ReportY="//input[@name='part130Value.part130Rep']";
	public static final String CreatePart_DateReported="//input[@name='dateReported']";
	public static final String CreatePart_ProgrammePopUp="(//a[contains(text(),'Program')])[3]";
	public static final String CreatePart_ProgrammeCode="//input[@name='programTab.programCode']";
	public static final String CreatePart_SearchPopUp2="(//button[contains(text(),'Search')])[1]";
	public static final String CreatePart_Select2="//button[contains(text(),'Select')]";
	public static final String CreatePart_Programme="//textarea[@name='part130Value.programCode']";
	public static final String CreatePart_SegmentPopUp="(//a[contains(text(),'Segment')])[2]";
	public static final String CreatePart_Select3="//button[contains(text(),'Select')]";
	public static final String CreatePart_Segment="//textarea[@name='part130Value.segmentCode']";
	public static final String CreatePart_SitePopUp="//a[contains(text(),'Site')]";
	public static final String CreatePart_SiteID="//input[@id='dosSitePopupForm_dosSite_siteId']";
	public static final String CreatePart_SearchPopUp3="(//button[contains(text(),'Search')])[1]";
	public static final String CreatePart_Select4="//button[contains(text(),'Select')]";
	public static final String CreatePart_Site="//textarea[@name='part130Value.site']";
	public static final String CreatePart_DepartmentPopUp="//a[contains(text(),'Department')]";
	public static final String CreatePart_Select5="//button[contains(text(),'Select')]";
	public static final String CreatePart_Department="//textarea[@name='part130Value.department']";
	public static final String CreatePart_InitialContractValue="//input[@name='part130Value.orgContractValue']";
	public static final String CreatePart_InitialEstPayment="//input[@name='part130Value.orgEstFees']";
	public static final String CreatePart_TotalContractValue="//input[@name='part130Value.totalContractValue']";
	public static final String CreatePart_TotalEstFees="//input[@name='part130Value.totalEstFees']";
	public static final String CreatePart_ActualPayment="//input[@name='actualFeesPaid']";
	public static final String CreatePart_Balance="//input[@name='balance']";
	
	//....................................Constructor........................................//
	public CreateNewPart130ReportPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//.............................Click on Save Tab......................................//
	public void save() {
		clickElement(driver, test, CeatePart_Save, "Clicking on Save Tab");
	}
		
	//.............................Click on Save and Return Tab.......................................//
	public void saveandreturn() {
		clickElement(driver, test, CeatePart_SaveandReturn, "Clicking on Save and Return Tab");
	}
		
	//.............................Click on Cancel Tab ...............................//
	public void cancel() {
		clickElement(driver, test, CreatePart_Cancel, "Clicking on Cancel Tab");
	}
	
	//..............................Create New Part ..................................//
	public void createNewPart(String contractNo,String AgreementNo, String Program,String Segment, String Site, String Department) {
		
		if(contractNo.length() > 0) {
			clickElement(driver, test, CreatePart_ContactNoPopUp, "Clicking on Contact No :");
			try {
				typeText(driver, test, CreatePart_Contacts, "Entering Contract No :", contractNo);
				clickElement(driver, test, CreatePart_SearchPopUp, "Clicking on Search PopUp :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ contractNo +"')]", "Clicking on Contract no :");
				clickElement(driver, test, CreatePart_Select1, "Clicking on Select Tab :");
			} catch (Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, CreatePart_ClosePopup, "Clicking on Close Popup Icon :");
			}
		}
		if(AgreementNo.length() > 0) {
			clickElement(driver, test, CreatePart_AgreementNo, "Clicking on Agreement No :");
			try {
				typeText(driver, test, CreatePart_TransactionId, "Entering Agreement No :", AgreementNo);
				clickElement(driver, test, CreatePart_SearchPopUp, "Clicking on Search PopUp :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ AgreementNo +"')]", "Clicking on Agreement no :");
				clickElement(driver, test, CreatePart_Select1, "Clicking on Agreement Tab :");
			} catch (Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, CreatePart_ClosePopup, "Clicking on Close Popup Icon :");
			}
		}else {
			typeText(driver, test, CreatePart_AgreementNoTextBox, "Entering Agreement No in TextBox :", AgreementNo);
		}
		clickElement(driver, test, CreatePart_Part130ReportY, "CLicking on Part 130 Report Radio Button :");
		if(Program.length() > 0) {
			clickElement(driver, test, CreatePart_ProgrammePopUp, "Clicking on Program No :");
			try {
				typeText(driver, test, CreatePart_ProgrammeCode, "Entering Program No :", Program);
				clickElement(driver, test, CreatePart_SearchPopUp, "Clicking on Search PopUp :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ Program +"')]", "Clicking on Program no :");
				clickElement(driver, test, CreatePart_Select1, "Clicking on Agreement Tab :");
			} catch (Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, CreatePart_ClosePopup, "Clicking on Close Popup Icon :");
			}
		}else {
			typeText(driver, test, CreatePart_Programme, "Entering Program No in TextBox :", Program);
		}
		if(Segment.length() > 0) {
			clickElement(driver, test, CreatePart_SegmentPopUp, "Clicking on Program No :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ Segment +"')]", "Clicking on Segment no :");
				clickElement(driver, test, CreatePart_Select1, "Clicking on Agreement Tab :");
			} catch (Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, CreatePart_ClosePopup, "Clicking on Close Popup Icon :");
			}
		}else {
			typeText(driver, test, CreatePart_Segment, "Entering Segment No in TextBox :", Segment);
		}
		if(Site.length() > 0) {
			clickElement(driver, test, CreatePart_SitePopUp, "Clicking on Site No :");
			try {
				typeText(driver, test, CreatePart_SiteID, "Entering Site No :", Site);
				clickElement(driver, test, CreatePart_SearchPopUp, "Clicking on Search PopUp :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ Site +"')]", "Clicking on Site no :");
				clickElement(driver, test, CreatePart_Select1, "Clicking on Agreement Tab :");
			} catch (Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, CreatePart_ClosePopup, "Clicking on Close Popup Icon :");
			}
		}else {
			typeText(driver, test, CreatePart_Site, "Entering Site No in TextBox :", Site);
		}
		if(Department.length() > 0) {
			clickElement(driver, test, CreatePart_DepartmentPopUp, "Clicking on Program No :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ Department +"')]", "Clicking on Department  :");
				clickElement(driver, test, CreatePart_Select1, "Clicking on Department Tab :");
			} catch (Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, CreatePart_ClosePopup, "Clicking on Close Popup Icon :");
			}
		}else {
			typeText(driver, test, CreatePart_Department, "Entering Department in TextBox :", Department);
		}
	}
}
