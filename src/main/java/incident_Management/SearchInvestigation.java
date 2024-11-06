package incident_Management;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchInvestigation extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	

	public static final String SInvest_Search="//button[contains(text(),'Search')]";
	public static final String SInvest_Reset="//button[contains(text(),'Reset')]";
	public static final String SInvest_IncidentNoHyperlink="//a[contains(text(),'Incident No')]";
	public static final String SInvest_IncidentNo="//input[@name='citCorrectiveActionValue.referenceNo']";
	public static final String SInvest_SearchPopup="(//button[contains(text(),'Search')])[2]";
	public static final String SInvest_Select="//button[contains(text(),'Select')]";
	public static final String Sinvest_ClosePopup="//button[@class='btn-close']";
	
	public static final String IM_SelectButton="//button[@class='primary-btn recordFromPopup']";
	public static final String SI_Search="//button[contains(text(),'Search')]";
	public static final String IM_Searchdata="//td[@aria-describedby='investigationsGrid_referenceNo']";
	
	public static final String IM_resultdata="//label[contains(text(),'Total No of records found: 1')]";
	
	public static final String IM_invresultdata="//label[contains(text(),'Total No of records found:')]";
	
	
	
    //Edit Investigation
	public static final String IM_CI_MatterName="//textarea[@id='editCaseUpdate_citInvestigationValue_matterName']";
	public static final String IM_CI_MatterDescription="//textarea[@id='editCaseUpdate_citCaseDeadlineUpdateValue_matterDescription']";
	
	public static final String IM_CI_InvestigationScope="//textarea[@id='editCaseUpdate_citCaseDeadlineUpdateValue_investigationScope']";
	public static final String IM_CI__Methodology="//textarea[@id='editCaseUpdate_citCaseDeadlineUpdateValue_methodology']";
	public static final String IM_CI_AgencyCaseNo="//input[@id='editCaseUpdate_citCaseDeadlineUpdateValue_agencyCaseNo']";
	public static final String IM_CI_InvestFormSaveBtn="//button[@id='save']";
	
	
	
	
	
	
	
	
	
	
    
	
	public SearchInvestigation(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	public void searchTab() {
		clickElement(driver, test, SInvest_Search, "Clickin On Search Tab");
	}
	
	public void search(String investigationID) {
		clickElement(driver, test, "//a[contains(text(),'"+investigationID+"')]", "Enter Investigation ID :"+investigationID);
	}
	
	public void resetTab() {
		clickElement(driver, test, SInvest_Reset, "Clickin On Reset Tab");
	}
	
	public void searchIncidentNo(String incidentno,String data) {
		clickElement(driver, test, SInvest_IncidentNoHyperlink, "Clicking on Incident Number link");
		try {
			typeText(driver, test, "//input[@id='searchForm_referenceNo']", "Type the referance number:", incidentno);
			clickElement(driver, test, SInvest_SearchPopup, "Clicking on Search Tab");
//			clickElement(driver, test, "//td[contains(text(),'"+data+"')]", "Entering Data :"+data);
//			clickElement(driver, test, SInvest_Select, "Clicking on Select Tab");
		
			mouseOverAndClick(driver, test, "//td[contains(text(),'"+ incidentno +"')]", "Selecting Data From table"+incidentno);
			clickElement(driver, test, SInvest_Select, "Clicking on Select Tab");
					//	clickElement(driver, test, IM_SelectButton, "Clicking On Select Button");
						clickElement(driver, test, SI_Search, "Clicking on Search");
						
						String sucessmesg = getText(driver, test, IM_Searchdata, "Get the Message : ");
						if (sucessmesg.equals(incidentno)) {
							test.log(LogStatus.PASS, "Search data displayed and search functionality working fine");
						} else {
							testFailSshot(driver, test);
							test.log(LogStatus.FAIL, "Search data not displayed");
						}
						Wait.waitfor(2);
			
			
			
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, Sinvest_ClosePopup, "Closing the Popup Window");
		}
	}

	
	public void searchTabpopup() {
		clickElement(driver, test, SInvest_Search, "Clickin On Search Tab");
		
	}
	
	
	
	public void searchIncidentNoinv(String incidentno,String data,String blanksearch,String invalidsearch) {
	
		if (blanksearch.length() > 0) {
			
			System.out.println("hello");
		}
		
		clickElement(driver, test, SInvest_IncidentNoHyperlink, "Clicking on Incident Number link");
		
		
	
		
		try {
			typeText(driver, test, "//input[@id='searchForm_referenceNo']", "Type the referance number:", incidentno);
			clickElement(driver, test, SInvest_SearchPopup, "Clicking on Search Tab");
//			clickElement(driver, test, "//td[contains(text(),'"+data+"')]", "Entering Data :"+data);
//			clickElement(driver, test, SInvest_Select, "Clicking on Select Tab");
			Wait.waitfor(2);
			mouseOverAndClick(driver, test, "//td[contains(text(),'"+ incidentno +"')]", "Selecting Data From table :"+incidentno);
			Wait.waitfor(2);
			clickElement(driver, test, IM_SelectButton, "Clicking On Select Button");
			Wait.waitfor(2);
			clickElement(driver, test, SI_Search, "Clicking on Search");
			Wait.waitfor(2);
			String sucessmesg = getText(driver, test, IM_Searchdata, "Get the Message : ");
			if (sucessmesg.equals(incidentno)) {
				test.log(LogStatus.PASS, "Search data displayed and search functionality working fine");
			} else {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Search data not displayed");
			}
			Wait.waitfor(2);
			
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, Sinvest_ClosePopup, "Closing the Popup Window");
		}
	}
	
	
	//******Edit  Investigation  Details********
	
	public void editInvestigationdetails(String investigationId, String matterName,String matterDescription,String investigationScope,String methodology,String agencyCaseNo) {
		
		Wait.waitfor(2);
		mouseOverAndClick(driver, test, "//a[contains(text(),'"+ investigationId +"')]", "Selecting Data From table"+investigationId);
       	Wait.waitfor(2);
		
		clearText(driver, test, IM_CI_MatterName, "Clear old Investigation Matter Name");
		Wait.waitfor(2);
		typeText(driver, test, IM_CI_MatterName, "Typing Investigation Matter Name  :", matterName);
		Wait.waitfor(2);
		scrollToBottom(driver);
		scrollToBottom(driver);
		clearText(driver, test, IM_CI_MatterDescription, "Clear old Investigation Matter Description");
		Wait.waitfor(2);
		typeText(driver, test, IM_CI_MatterDescription, "Typing Investigation Matter Description  :", matterDescription);
		Wait.waitfor(2);
		scrollToBottom(driver);
		scrollToBottom(driver);
		clearText(driver, test, IM_CI_InvestigationScope, "Clear old Investigation Investigation Scope");
		Wait.waitfor(2);
		typeText(driver, test, IM_CI_InvestigationScope, "Typing Investigation Investigation Scope  :", investigationScope);
		Wait.waitfor(2);
		scrollToBottom(driver);
		
		clearText(driver, test, IM_CI__Methodology, "Clear old Investigation Methodology");
		Wait.waitfor(2);
		typeText(driver, test, IM_CI__Methodology, "Typing Investigation Methodology  :", methodology);
		Wait.waitfor(2);
		
		scrollToBottom(driver);
		clearText(driver, test, IM_CI_AgencyCaseNo, "Clear old Investigation  Agency Case No");
		Wait.waitfor(2);
		typeText(driver, test, IM_CI_AgencyCaseNo, "Typing Investigation Agency CaseNo  :", agencyCaseNo);
		Wait.waitfor(2);
		scrollToTop(driver);
		scrollToTop(driver);
		scrollToTop(driver);
		Wait.waitfor(2);
		clickElement(driver, test, IM_CI_InvestFormSaveBtn, "Clicking on investigation Form Save button");
		
	
		
		
		
//		clickElement(driver, test, IM_SI_Review_InvestigationTab, "Clicking on SubmitInfo Tab");
// 	   //CaseOfficer
// 	   clickElement(driver, test, IM_AddInvestigationCaseOfficerLink, "Clicking on Case Officer Link");
// 	   typeText(driver, test, IM_CaseOfficer_firstName, "Typing Corrective Actions Manager First Name :", firstName);
// 	   clickElement(driver, test, IM_RI_CaseOfficerPopUpSearchBtn, "Clicking on Case Officer Search");
// 	   Wait.waitfor(3);
//		   mouseOverAndClick(driver, test, "//td[contains(text(),'" + firstName + "')]",
//				"Selecting Data From Product Line table :" + firstName);
// 	   clickElement(driver, test, IM_RI_CaseOfficerpopUpSelectBtn, "Clicking on Case Officer Select");
//
//        //CorrectiveActionsManager  
//		clickElement(driver, test, IM_AddInvestigationCorrectiveActionsManagerLink, "Clicking on SubmitInfo Tab");
//		Wait.waitfor(3);
//		typeText(driver, test, IM_CorrectiveActionsManager_firstName, "Typing Corrective Actions Manager First Name :",
//				firstName);
//		clickElement(driver, test, IM_SI_CorrectiveActionsManagerPopUpSearchBtn, "Clicking on Search button");
//		Wait.waitfor(3);
//		mouseOverAndClick(driver, test, "//td[contains(text(),'" + firstName + "')]",
//				"Selecting Data From Product Line table :" + firstName);
//     clickElement(driver, test, IM_SI_CorrectiveActionsManagerpopUpSelectBtn, "Clicking on Select button");
//     Wait.waitfor(3);
//		mouseOverAndClick(driver, test, "//td[contains(text(),'" + firstName + "')]",
//				"Selecting Data From Product Line table :" + firstName);
//		
//		clickElement(driver, test, IM_RI_SaveReviewBtn, "Clicking on Select button");
		
	
		
		
	}
	
	public void searchIncidentbyInvestigationId(String investigationId) {
		   Wait.waitfor(2);
			typeText(driver, test, "//input[@id='resultCitInvestigations_citInvestigationValue_investigationId']", "Type the Reported By Name :", investigationId);
			
			clickElement(driver, test, SI_Search, "Clicking on Search");
	      String sucessmesg = getText(driver, test, IM_resultdata, "Total No of records found: ");
	      
	     test.log(LogStatus.PASS, "Search  by Investigation Id data displayed and search functionality working fine");

		}
   public void searchIncidentbyStatus(String status) {
		
		clickElement(driver, test, "//option[contains(text(),'" + status + "')]",
				"Add Template :" + status);
		clickElement(driver, test, SI_Search, "Clicking on Search");
        String sucessmesg = getText(driver, test, IM_invresultdata, "Total No of records found: ");
       test.log(LogStatus.PASS, "Search  by Status data displayed and search functionality working fine");

	}
	
	
}


