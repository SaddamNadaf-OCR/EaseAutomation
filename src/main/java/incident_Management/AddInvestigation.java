package incident_Management;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class AddInvestigation extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	
	 public static final String IM_AddInvestigationBtn ="//button[@id='adInvestigation']";
	 public static final String IM_InvestigationCreateMatterName ="//textarea[@id='createNewInvestigation_citInvestigationValue_matterName']";
	
	 public static final String IM_AddInvestigationAddDocumentBtn ="//button[@id='documentAttachId']";
	 public static final String IM_AddInvestigationCorrectiveActionsManagerLink ="//a[contains(text(),'Corrective Actions Manager')]";
	
	 public static final String IM_AddInvestigationSearchCorrectiveActionsManagerName ="//input[@id='searchForm_userProfile_userFirstname']";
	 public static final String IM_AddInvestigationSearchCorrectiveActionsManagerSearchBtn ="//button[contains(text(),'Search')][1]";
	 public static final String IM_InvestigationformSaveBtn="//button[contains(text(),'Save')]";
	 
	
	
	public static final String IM_Investigation="//a[@onclick='incidentNoPopUp()']";
	public static final String IM_InvestigationSaveBtn="//button[@id='save']";
	public static final String IM_InvestigationViewQuestionnaireBtn="//button[@id='btnQuestionnaire']";
	public static final String IM_InvestigationResetBtn="//button[contains(text(),'Reset')]";
    public static final String IM_InvestigationMatterName ="//textarea[@id='editCaseUpdate_citInvestigationValue_matterName']";
	public static final String IM_InvestigationMatterDescription  ="//textarea[@id='editCaseUpdate_citCaseDeadlineUpdateValue_matterDescription']";
	public static final String IM_InvestigationInvestigationTrack   ="//select[@id='editCaseUpdate_citCaseDeadlineUpdateValue_investigationTrack']";
	
	public static final String IM_InvestigationSatatus="//font[contains(text(),'Pending Review')]";
	
	
	
	public static final String IM_InvestigationAddNotes="//button[@id='addNotes']";
	public static final String IM_InvestigationAddNotesBtn="//button[@id='addNotes']";
	public static final String IM_InvestigationAddNotesText="//textarea[@id='editCitNotes_citNotesValue_notes']";
	public static final String IM_InvestigationAddNotesSaveandReturnBtn="//button[@id='ok']";
	public static final String IM_InvestigationAddNotesSaveBtn="//button[@id='save']";

	

			
	public AddInvestigation(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	

	//..................................Investigation Form................................SK//
	public void addReviewInvestigation() {
		clickElement(driver, test, IM_AddInvestigationBtn, "click on Add InvestigationBtn");
	
	}
	

	
	
	//Add Notes on ReviewInvestigation Tab
    public void addNotes(String notes) {
    	
    	clickElement(driver, test, IM_InvestigationAddNotesBtn, "Clicking On Add Notes Button");
    	typeText(driver, test, IM_InvestigationAddNotesText, "Add Note text :", notes);
    	clickElement(driver, test, IM_InvestigationAddNotesSaveandReturnBtn, "Clicking On Add Notes Button");
    	scrollToBottom(driver);
    	Wait.waitfor(2);
    	scrollToBottom(driver);
    	Wait.waitfor(2);
    	scrollToBottom(driver);
    	mouseOverAndClick(driver, test, "//td[contains(text(),'"+ notes +"')]", "Selecting Data From table :"+notes);
    	
    	String sucessmesg = getText(driver, test, "//td[contains(text(),'"+ notes +"')]", "Get the Data From table :");
		if (sucessmesg.equals(notes)) {
			test.log(LogStatus.PASS, "Search data displayed and AddNotes functionality working fine");
		} else {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Search data not displayed");
		}
		Wait.waitfor(2);
    }
	

	
	
}
