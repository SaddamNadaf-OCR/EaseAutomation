package incident_Management;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class AddIncident extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	public static final String IM_GI_IncidentNumber = "//a[@onclick='incidentNoPopUp()']";
	public static final String IM_GI_IncidentNumberText = "//input[@name='citGeneralInfoValue.referenceNo']";
	public static final String IM_GI_SearchPopup = "(//button[contains(text(),'Search')])[1]";
	public static final String IM_GI_SelectPopup = "(//button[contains(text(),'Select')])[1]";
	public static final String IM_GI_NewSearchPopup = "(//button[contains(text(),'New Search')])[1]";
	public static final String IM_GI_CancelPopup = "(//button[contains(text(),'Cancel')])[4]";
	public static final String IM_GI_BusinessUnit = "//select[@id='sbuCode']";
	public static final String IM_GI_Save = "(//button[contains(text(),'Save')])[1]";
	public static final String IM_GI_Save_Return = "(//button[contains(text(),'Save')])[2]";
	public static final String IM_GI_Cancel = "(//button[contains(text(),'Cancel')])[1]";
	public static final String IM_GI_IncidentDiscoveryDate = "//input[@name='incidentDiscDate']";
	public static final String IM_GI_Program = "//a[contains(text(),'Program')]";
	public static final String IM_GI_Segment = "//a[contains(text(),'Segment')]";
	public static final String IM_GI_Site = "(//a[contains(text(),'Site')])[2]";
	public static final String IM_GI_ProductFamily = "(//a[contains(text(),'Product Family')])[2]";
	public static final String IM_GI_ProductLine = "(//a[contains(text(),'Product Line')])[2]";
	public static final String IM_GI_Department = "//a[contains(text(),'Department')]";
	public static final String IM_AddIncidentbutton = "//button[contains(text(),'Add Incident')]";
	public static final String IM_AddIncidentTemSelectBtn = "//button[@id='select']";
	public static final String IM_AddIncidentNo = "//input[@id='editCitGeneralInfo_citGeneralInfoValue_referenceNo']";
	public static final String IM_AddIncidentSegment = "//a[contains(text(),'Segment')]";
	public static final String IM_AddIncidentSegmentpopupSelectBtn = "//button[contains(text(),'Select')]";
	public static final String IM_AddIncidentProductFamily = "(//a[contains(text(),'Product Family')])[2]";
	public static final String IM_AddIncidentProductFamilypopupSelectBtn = "//button[contains(text(),'Select')]";
	public static final String IM_AddIncidentProductLine = "(//a[contains(text(),'Product Line')])[2]";
	public static final String IM_AddIncidentProductLinepopupSelectBtn = "//button[contains(text(),'Select')]";
	public static final String IM_AddIncidentDepartment = "//a[contains(text(),'Department')]";
	public static final String IM_AddIncidentDepartmentpopupSelectBtn = "//button[contains(text(),'Select')]";
	public static final String IM_AddIncidentSaveBtn = "//button[@id='saveButton']";
	public static final String IM_AddIncidentComplianceIncidentNo = "//font[@color='blue']";
	
	
	public static final String IM_QueNo = "//input[@id='editIncidentQuestionnaire_questionnaireResponseValues_0__responseObjectiveN']";
	//input[@id='editIncidentQuestionnaire_questionnaireResponseValues_0__responseObjectiveY']
	
	public static final String IM_QueSelect = "//option[contains(text(),'Create New Question')]";
	
	// SubmitInfoTab	
	public static final String IM_Documents_NotesTab = "//a[contains(text(),'Documents/Notes')]";
	public static final String IM_ViewAddDocumentsBtn = "//button[@id='documentAttachId']";
	public static final String IM_UploadFileBtn = "//input[@id='fileAttach']";
	public static final String IM_UploadFileSuccessMsg = "//li[contains(text(),'File Uploaded successfully.')]";
	
	public static final String IM_AddNotesBtn = "//button[@id='addNotes']";
	public static final String IM_AddNotesText = "//textarea[@id='editCitNotes_citNotesValue_notes']";
	public static final String IM_AddNotesSaveBtn = "//button[@id='save']";
	

	// SubmitInfoTab
	public static final String IM_SubmitInfoTab = "//a[contains(text(),'Submit Info')]";
	public static final String IM_AuditNameLink = "(//a[contains(text(),'Name')])[2]";
	public static final String IM_SI_firstName = "//input[@id='searchForm_userProfile_userFirstname']";
	public static final String IM_SI_ComplianceAuditPointofContactSearchBtn = "(//button[contains(text(),'Search')])[1]";
	public static final String IM_SI_ComplianceAuditPointofContactSelectBtn = "(//button[contains(text(),'Select')])[1]";
	
	public static final String IM_SI_SubmitInfoCheckBoxBtn = "//input[@id='editCitGeneralInfo_certify']";
	public static final String IM_SI_SubmitForReviewBtn = "(//button[@id='review'])[2]";
	public static final String IM_SI_SubmitForReviewStatus = "//font[contains(text(),'Submitted For Review')]";

	// Review/InvestigationTab
	public static final String IM_SI_Review_InvestigationTab = "//a[contains(text(),'Review/Investigation')]";
	
	public static final String IM_AddInvestigationCaseOfficerLink ="//a[contains(text(),'Case Officer')]";
    public static final String IM_CaseOfficer_firstName = "//input[@id='searchForm_userProfile_userFirstname']";
	
	public static final String IM_RI_CaseOfficerPopUpSearchBtn = "(//button[contains(text(),'Search')])[1]";
	public static final String IM_RI_CaseOfficerpopUpSelectBtn = "(//button[contains(text(),'Select')])[1]";

	public static final String IM_AddInvestigationCorrectiveActionsManagerLink ="//a[contains(text(),'Corrective Actions Manager')]";
	public static final String IM_CorrectiveActionsManager_firstName = "//input[@id='searchForm_userProfile_userFirstname']";
	
	public static final String IM_SI_CorrectiveActionsManagerPopUpSearchBtn = "(//button[contains(text(),'Search')])[1]";
	public static final String IM_SI_CorrectiveActionsManagerpopUpSelectBtn = "(//button[contains(text(),'Select')])[1]";
	
	public static final String IM_RI_SaveReviewBtn = "//button[@id='saveReviewTab']";
	
	// CorrectiveAction
	public static final String IM_CorrectiveActionTab = "(//a[contains(text(),'Corrective Actions')])[2]";
	public static final String IM_CorrectiveActionTabAddUserLink = "//a[contains(text(),'Add User')]";
	public static final String IM_CorrectiveActionTabAddUserSearch = "//input[@id='searchForm_userProfile_userFirstname']";
	public static final String IM_CorrectiveActionTabAddUserSearchBtn = "(//button[contains(text(),'Search')])[1]";
	public static final String IM_CorrectiveActionTabAddUserSelectBtn = "(//button[contains(text(),'Select')])[1]";
	public static final String IM_CorrectiveAction = "//a[@onclick='incidentNoPopUp()']";
	public static final String IM_CorrectiveActionSaveBtn = "//button[@id='save']";
			
	
	
	public static final String IM_CorrectiveActionDescription = "//textarea[@id='editCitCorrectiveAction_citCorrectiveActionValue_description']";
	
	public static final String IM_CARequiredbyDate = "//input[@id='editCitCorrectiveAction_actionRequiredDate']";
	public static final String IM_CARequiredbyDateToday = "//button[contains(text(),'Today')]";
	
	public static final String IM_CARemark = "//textarea[@id='editCitCorrectiveAction_citCorrectiveActionValue_remark']";
	
	
	public static final String IM_Features="(//a[@class='nav-link dropdown-item'])[3]";
	public static final String IM_IncidentForm="(//a[contains(text(),'Incident Form')])[1]";
	public static final String IM_incidentNumber = "//input[@id='resultCitGeneralInfo_citGeneralInfoValue_referenceNo']";
	public static final String IM_incidentsearchBtn = "//button[contains(text(),'Search')]";
	
	public static final String IM_incidentDeleteBtn = "//tbody/tr[@id='1']/td[20]/a[1]/i[1]";
	
	public static final String IM_incidentDeleteMsg = "//li[contains(text(),'No records found')]";
			
			
	public AddIncident(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	public void incidentNo(String incidentNumber) {
		typeText(driver, test, IM_GI_IncidentNumberText, "Typing Incident No", incidentNumber);
	}
	public void businessUnit(String businessSbu) {
		selectByVisibleText(driver, test, IM_GI_BusinessUnit, "Select Business SBU", businessSbu);
	}
	public void incidentDiscoveryDate(String incidentDate) {
		clickElement(driver, test, IM_GI_IncidentDiscoveryDate, "Clicking on Incident Discovery Date");
		date(driver, test, "Select the IncidentDate :", incidentDate);
	}
	
	public void incidentdelete(String incidentNumber) {
		mouseOverAndClick(driver, test, IM_Features, "Mouse over on Feature");
		
		clickElement(driver, test, IM_IncidentForm, "Clicking on Incident Form");
		
		typeText(driver, test, IM_incidentNumber, "Typing Incident No :", incidentNumber);	
		clickElement(driver, test, IM_incidentsearchBtn, "Clicking on Search button");
		Wait.waitfor(3);
		clickElement(driver, test, IM_incidentDeleteBtn, "Clicking on Delete button");
		
		 // Switching to Alert        
        Alert alert = driver.switchTo().alert();		
        		
        // Capturing alert message.    
        String alertMessage= driver.switchTo().alert().getText();		
        		
        // Displaying alert message		
        System.out.println(alertMessage);	
		
        // Accepting alert		
       alert.accept();	
       
       String sucessmesg = getText(driver, test, IM_incidentDeleteMsg, "Get the Message : ");
		
		if (sucessmesg.equals("No records found")) {
		test.log(LogStatus.PASS, "Incident record Deleted successfully");
	} else {
		testFailSshot(driver, test);
		test.log(LogStatus.FAIL, "Incident record not Deleted ");
	}

		
		
		}
	
	
	public void click_CopyIcon() {
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, "(//td[@aria-describedby='grid_copy'])[1]", "Clicking on Copy Icon :");
		Wait.waitfor(6);
		String alertmsg = "Proceed to Copy without Invalid data";
		//String alertmsg = getText(driver, test, "//span[contains(text(),'Proceed to Copy without Invalid data')]", "Alert Msg :");
		try {
			if(alertmsg.equalsIgnoreCase("Proceed to Copy without Invalid data")) {
				clickElement(driver, test, "//span[contains(text(),'Proceed to Copy without Invalid data')]", "Clicking on Proceed Without Invalid Data Button :");
				}
			else {
				clickElement(driver, test, "//span[contains(text(),'Abort Copying')]", "Clicking on Abort Copying :");
			}
		}catch(Exception e) {
				//testFailSshot(driver, test);
				test.log(LogStatus.INFO, "Clicked on Copy Icon without Alert Msg :");
			}
	}

	
	
	
	//..................................Incident Form in Features................................SK//
	public void addincidentdetails(String incidentNumber,String templateName,String segment,String productFamily,String	productLine,String department) {
		clickElement(driver, test, IM_AddIncidentbutton, "Clicking on Incident button");
		clickElement(driver, test, "//option[contains(text(),'" + templateName + "')]",
				"Add Template :" + templateName);
		clickElement(driver, test, IM_AddIncidentTemSelectBtn, "Clicking on Incident button");
		clearText(driver, test, IM_GI_IncidentNumberText, "Clear old button color");
		Wait.waitfor(3);
		typeText(driver, test, IM_GI_IncidentNumberText, "Typing Incident No :", incidentNumber);
		scrollToBottom(driver);
		clickElement(driver, test, IM_AddIncidentSegment, "Clicking on Segment hyper link");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, "//td[contains(text(),'" + segment + "')]",
				"Selecting Data From Segment table :" + segment);
		clickElement(driver, test, IM_AddIncidentSegmentpopupSelectBtn, "Clicking on Segment Popup select button");

		clickElement(driver, test, IM_AddIncidentProductFamily, "Clicking on Product Family hyper link");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, "//td[contains(text(),'" + productFamily + "')]",
				"Selecting Data From Product Family table :" + productFamily);
		clickElement(driver, test, IM_AddIncidentProductFamilypopupSelectBtn,
				"Clicking on Product Family Popup select button");

		clickElement(driver, test, IM_AddIncidentProductLine, "Clicking on ProductLine hyper link");
		Wait.waitfor(5);
		mouseOverAndClick(driver, test, "//td[contains(text(),'" + productLine + "')]",
				"Selecting Data From Product Line table :" + productLine);
		clickElement(driver, test, IM_AddIncidentProductLinepopupSelectBtn,
				"Clicking on Product Line Popup select button");

		clickElement(driver, test, IM_AddIncidentDepartment, "Clicking on Department hyper link");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, "//td[contains(text(),'" + department + "')]",
				"Selecting Data From Department table :" + department);
		clickElement(driver, test, IM_AddIncidentDepartmentpopupSelectBtn,
				"Clicking on Department Popup select button");

		Wait.waitfor(3);
		clickElement(driver, test, IM_AddIncidentSaveBtn, "Clicking on Save button");

//		String sucessmesg = getText(driver, test, IM_AddIncidentComplianceIncidentNo, "Get the Message : ");
//		if (sucessmesg.equals(incidentNumber)) {
//			test.log(LogStatus.PASS, "Compliance Incident Number displayed and Incident Created ");
//		} else {
//			testFailSshot(driver, test);
//			test.log(LogStatus.FAIL, "Compliance Incident not Created");
//		}

	}
	
	
	
	   //SubmitInfo
       public void submitInfo(String firstName) {
    	   scrollToTop(driver);
    	   Wait.waitfor(3);
   		
		clickElement(driver, test, IM_SubmitInfoTab, "Clicking on SubmitInfo Tab");

		clickElement(driver, test, IM_AuditNameLink, "Clicking on SubmitInfo Tab");

		Wait.waitfor(3);
		typeText(driver, test, IM_SI_firstName, "Typing Incident No :", firstName);

		clickElement(driver, test, IM_SI_ComplianceAuditPointofContactSearchBtn, "Clicking on Search button");

		Wait.waitfor(3);
		mouseOverAndClick(driver, test, "//td[contains(text(),'" + firstName + "')]",
				"Selecting Data From Product Line table :" + firstName);

		clickElement(driver, test, IM_SI_ComplianceAuditPointofContactSelectBtn, "Clicking on SubmitInfo Checkbox");
		
		scrollToBottom(driver);
		scrollToBottom(driver);
		clickElement(driver, test, IM_SI_SubmitInfoCheckBoxBtn, "Clicking on Submit Info Checkbox");

		clickElement(driver, test, IM_SI_SubmitForReviewBtn, "Clicking on Submit for Review");

		String sucessmesg = getText(driver, test, IM_SI_SubmitForReviewStatus, "Get the Message : ");
		if (sucessmesg.equals("Submitted For Review")) {
			test.log(LogStatus.PASS, "Incedent form data Submitted For Review");
		} else {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Incedent form data not Submitted For Review");
		}
	
	
	
}

  
      //ReviewandInvestigation
       public void ReviewandInvestigation(String firstName) {
	       
    	   clickElement(driver, test, IM_SI_Review_InvestigationTab, "Clicking on SubmitInfo Tab");
    	   //CaseOfficer
    	   clickElement(driver, test, IM_AddInvestigationCaseOfficerLink, "Clicking on Case Officer Link");
    	   typeText(driver, test, IM_CaseOfficer_firstName, "Typing Corrective Actions Manager First Name :", firstName);
    	   clickElement(driver, test, IM_RI_CaseOfficerPopUpSearchBtn, "Clicking on Case Officer Search");
    	   Wait.waitfor(3);
   		   mouseOverAndClick(driver, test, "//td[contains(text(),'" + firstName + "')]",
   				"Selecting Data From Product Line table :" + firstName);
    	   clickElement(driver, test, IM_RI_CaseOfficerpopUpSelectBtn, "Clicking on Case Officer Select");
   
           //CorrectiveActionsManager  
		clickElement(driver, test, IM_AddInvestigationCorrectiveActionsManagerLink, "Clicking on SubmitInfo Tab");
		Wait.waitfor(3);
		typeText(driver, test, IM_CorrectiveActionsManager_firstName, "Typing Corrective Actions Manager First Name :",
				firstName);
		clickElement(driver, test, IM_SI_CorrectiveActionsManagerPopUpSearchBtn, "Clicking on Search button");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, "//td[contains(text(),'" + firstName + "')]",
				"Selecting Data From Product Line table :" + firstName);
        clickElement(driver, test, IM_SI_CorrectiveActionsManagerpopUpSelectBtn, "Clicking on Select button");
        Wait.waitfor(3);
		mouseOverAndClick(driver, test, "//td[contains(text(),'" + firstName + "')]",
				"Selecting Data From Product Line table :" + firstName);
		
		clickElement(driver, test, IM_RI_SaveReviewBtn, "Clicking on Select button");
		
	

         }

     //CorrectiveAction
       public void AddCorrectiveAction(String firstName) {
   		clickElement(driver, test, IM_CorrectiveActionTab, "Click on Corrective Action Tab ");
   		
   		clickElement(driver, test, IM_CorrectiveActionTabAddUserLink, "Click on Corrective Action Tab ");
   		
   		
   		clickElement(driver, test, IM_CorrectiveActionTabAddUserSearch, "Click on Corrective Action Tab ");
   		
   		
   		clickElement(driver, test, IM_CorrectiveActionTabAddUserSearchBtn, "Click on Add User Search button ");
   		
   		mouseOverAndClick(driver, test, "//td[contains(text(),'" + firstName + "')]",
   				"Selecting Data From Product Line table :" + firstName);
   		clickElement(driver, test, IM_CorrectiveActionTabAddUserSelectBtn, "Click on Add User Select button ");
   		clickElement(driver, test, IM_CorrectiveActionSaveBtn, "Click on Corrective Action Tab ");
   		
   		
   		
   				
   	
   	}
       
       //CorrectiveAction
       public void createNewCorrectiveAction(String CADescription, String CARemark) {
    	   
    	   typeText(driver, test, IM_CorrectiveActionDescription, "Typing Corrective Actions Manager First Name :",
    			   CADescription);
    	   
    	   
   		clickElement(driver, test, IM_CorrectiveActionTab, "Click on Corrective Action Tab ");
   		
   		
   		
   		typeText(driver, test, IM_CARemark, "Typing Corrective Actions Remark Text :",
 			   CARemark);
   		
   				
   	
   	} 
         
       
    
       
       
   	public void editincidentdetails(String segment,String productFamily,String	productLine,String department) {

		scrollToBottom(driver);
		clickElement(driver, test, IM_AddIncidentSegment, "Clicking on Segment hyper link");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, "//td[contains(text(),'" + segment + "')]",
				"Selecting Data From Segment table :" + segment);
		clickElement(driver, test, IM_AddIncidentSegmentpopupSelectBtn, "Clicking on Segment Popup select button");

		clickElement(driver, test, IM_AddIncidentProductFamily, "Clicking on Product Family hyper link");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, "//td[contains(text(),'" + productFamily + "')]",
				"Selecting Data From Product Family table :" + productFamily);
		clickElement(driver, test, IM_AddIncidentProductFamilypopupSelectBtn,
				"Clicking on Product Family Popup select button");

		clickElement(driver, test, IM_AddIncidentProductLine, "Clicking on ProductLine hyper link");
		Wait.waitfor(5);
		mouseOverAndClick(driver, test, "//td[contains(text(),'" + productLine + "')]",
				"Selecting Data From Product Line table :" + productLine);
		clickElement(driver, test, IM_AddIncidentProductLinepopupSelectBtn,
				"Clicking on Product Line Popup select button");

		clickElement(driver, test, IM_AddIncidentDepartment, "Clicking on Department hyper link");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, "//td[contains(text(),'" + department + "')]",
				"Selecting Data From Product Line table :" + department);
		clickElement(driver, test, IM_AddIncidentDepartmentpopupSelectBtn,
				"Clicking on Department Popup select button");

		Wait.waitfor(3);
		clickElement(driver, test, IM_AddIncidentSaveBtn, "Clicking on Save button");

//		String sucessmesg = getText(driver, test, IM_AddIncidentComplianceIncidentNo, "Get the Message : ");
//		if (sucessmesg.equals(incidentNumber)) {
//			test.log(LogStatus.PASS, "Compliance Incident Number displayed and Incident Created ");
//		} else {
//			testFailSshot(driver, test);
//			test.log(LogStatus.FAIL, "Compliance Incident not Created");
//		}

	}
       
       

}
