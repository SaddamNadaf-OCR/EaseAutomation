package incident_Management;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class QuestionnaireIM extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	/* ******************************** LOCATORS ******************************** */
	public static final String IM_GI_IncidentNumber="//a[@onclick='incidentNoPopUp()']";
	public static final String IM_GI_IncidentNumberText="//input[@name='citGeneralInfoValue.referenceNo']";
	
	
	
	
	public static final String IM_GI_SearchPopup="(//button[contains(text(),'Search')])[1]";
	public static final String IM_GI_SelectPopup="(//button[contains(text(),'Select')])[1]";
	public static final String IM_GI_NewSearchPopup="(//button[contains(text(),'New Search')])[1]";	
	public static final String IM_GI_CancelPopup="(//button[contains(text(),'Cancel')])[4]";
	public static final String IM_GI_BusinessUnit="//select[@id='sbuCode']";
	public static final String IM_GI_Save="(//button[contains(text(),'Save')])[1]";
	public static final String IM_GI_Save_Return="(//button[contains(text(),'Save')])[2]";
	public static final String IM_GI_Cancel="(//button[contains(text(),'Cancel')])[1]";
	public static final String IM_GI_IncidentDiscoveryDate="//input[@name='incidentDiscDate']";
	
	public static final String IM_Searchdata="//a[@class='cfn']";
	
	//Questionnaire Page
	public static final String IM_QuestionnaireTab="(//a[contains(text(),'Questionnaire')])[2]";
	public static final String IM_QueLockbutton="//i[@id='lockIcon']";
	public static final String IM_QueNo = "//input[@id='editIncidentQuestionnaire_questionnaireResponseValues_0__responseObjectiveN']";
	//input[@id='editIncidentQuestionnaire_questionnaireResponseValues_0__responseObjectiveY']
    public static final String IM_QueSelect="//option[contains(text(),'Create New Question')]";
    public static final String IM_AddQuestionnaireSaveBtn="//button[@id='save']";
    
    //Questionnaire Page Documents
	public static final String IM_ViewAddDocumentsBtn="//button[@id='documentAttachId']";
	public static final String IM_UploadFileBtn="//i[@class='fa fa-upload']";
	public static final String IM_UploadFileSuccessMsg="//li[contains(text(),'File Uploaded successfully.')]";
	public static final String IM_DocumentsType="//select[@id='docTypeId']";
	
	public static final String IM_DocumentsformSaveBtn="//button[@id='saveButton']";
	
	public static final String IM_DocumentsformCrossBtn="//button[@id='closeTop']";

	
	
	//Questionnaire Page Notes
	public static final String IM_AddNotesBtn="//button[@id='addNotes']";
	public static final String IM_AddNotesText="//textarea[@id='editCitNotes_citNotesValue_notes']";
	public static final String IM_AddNotesSaveandReturnBtn="//button[@id='ok']";
	public static final String IM_AddNotesSaveBtn="//button[@id='save']";
	
	
	
	
	/* ******************************* Constructor ****************************** */
	public QuestionnaireIM(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	/* ******************************* Action ****************************** */
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
	
	public void clickonSearchdata() {
		clickElement(driver, test, IM_Searchdata, "Clicking on Search Data");
		
	}
	
	public void QuestionnaireTab() {
			
		Wait.waitfor(2);
		scrollToTop(driver);
		clickElement(driver, test, IM_QueLockbutton, "Clicking on General Info LocK button Disable");
		clickElement(driver, test, IM_QueLockbutton, "Clicking on General Info Lock button Enable ");
		Wait.waitfor(2);
		clickElement(driver, test, IM_QuestionnaireTab, "Clicking on QuestionnaireTab");
		Wait.waitfor(2);
		clickElement(driver, test, IM_QueLockbutton, "Clicking on Questionnaire Lock  button Enable and add data");
	}

	  public void addQuestionnaire() {
			
    	  clickElement(driver, test, IM_QueNo, "Clicking On Questionnaire No");
		
    	  clickElement(driver, test, IM_QueSelect, "Clicking On Create New Question Text"); 
    	  Wait.waitfor(3);
  		clickElement(driver, test, IM_AddQuestionnaireSaveBtn, "Clicking on Save button");
  		
		
	}
	
	//Disable lock on Questionnaire page
	public void disableQuestionnaireLockBtn() {
		clickElement(driver, test, IM_QueLockbutton, "Clicking On Select Button");
	}
	
	//Add documents
    public void addDocument(String uploadfileName,String DocumentType) {
    	clickElement(driver, test, IM_ViewAddDocumentsBtn, "Clicking On View /AddDocuments Button");
    	
  	selectByVisibleText(driver, test, IM_DocumentsType,"Select the document type from dropdown :", DocumentType);
//		typeText(driver, test, OCR_Document_Description, "Add Description in box :", DocumentDescription);
    	Wait.waitfor(4);
    	mouseOverAndClick(driver, test, IM_UploadFileBtn, "click on Upload File :");
	  //Wait.waitfor(4);
    	
    //	clickElement(driver, test, IM_UploadFileBtn, "Clicking On File Upload button");
    	uploadFile(driver, test, uploadfileName, "Document is Added : " + uploadfileName);
		Wait.waitfor(3);
    	
		String sucessmesg = getText(driver, test, IM_UploadFileSuccessMsg, "Get the Message : ");
		if (sucessmesg.equals("File Uploaded successfully.")) {
			test.log(LogStatus.PASS, "UploadFile Success Message  displayed and Upload functionality working fine");
		} else {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "UploadFile Success Message not displayed");
		}
		Wait.waitfor(2);

		clickElement(driver, test, IM_DocumentsformSaveBtn, "Clicking On Documents form Save Button");
		Wait.waitfor(2);
		clickElement(driver, test, IM_DocumentsformCrossBtn, "Clicking On Documents form Cross Button");
		
		Wait.waitfor(2);
		
		
		
	}
   //Add Notes
    public void addNotes(String notes) {
    	
    	clickElement(driver, test, IM_AddNotesBtn, "Clicking On Add Notes Button");
    	typeText(driver, test, IM_AddNotesText, "Add Note text :", notes);
    	clickElement(driver, test, IM_AddNotesSaveandReturnBtn, "Clicking On Add Notes Button");
//    	scrollToBottom(driver);
//    	Wait.waitfor(2);
//    	scrollToBottom(driver);
//    	Wait.waitfor(2);
//    	scrollToBottom(driver);
//    	mouseOverAndClick(driver, test, "//td[contains(text(),'"+ notes +"')]", "Selecting Data From table :"+notes);
//    	
//    	String sucessmesg = getText(driver, test, "//td[contains(text(),'"+ notes +"')]", "Get the Data From table :");
//		if (sucessmesg.equals(notes)) {
//			test.log(LogStatus.PASS, "Search data displayed and AddNotes functionality working fine");
//		} else {
//			testFailSshot(driver, test);
//			test.log(LogStatus.FAIL, "Search data not displayed");
//		}
		Wait.waitfor(2);
    }
	
    
    

  }
    

