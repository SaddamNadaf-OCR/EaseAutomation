package crsClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class AgreementReqDocumentsOrNotesPage extends GenericMethods{

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	
	public static final String OCR_Button_ViewOrAddDoc = "//button[@id='documentAttachId']"; 
	public static final String OCR_DocumentType="//select[@id='docTypeId']";	
	public static final String OCR_Document_Description="//textarea[@id='editDCSFileAttach_documentDetail_comments']";	
	public static final String OCR_UploadFile="//input[@id='fileAttach']";	
	public static final String OCR_AddDocpopUpUploadFile="//i[@class='fa fa-upload']";
	public static final String OCR_Button_ForwardNavigation="//button[@id='next-btn']";
	public static final String OCR_Button_Cancel = "//button[@class='cancelPopup']";
	public static final String OCR_Button_AddNote ="//button[contains(text(),'Add Note')]";
	public static final String OCR_Button_SaveandReturn ="//button[contains(text(),'Save & Return')]";
	public static final String OCR_AddEditNote="//textarea[@id='editDocsAndNotes_exportNotes_secureNotes']";
	public static final String OCR_Button_NSave="//button[@name='Save.x']";
	public static final String OCR_Button_Doc_Save="(//button[contains(text(),'Save')])[2]";

	
	public AgreementReqDocumentsOrNotesPage(WebDriver driver, ExtentTest test) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.test = test;
	}
    //Click on Add Document Button 
    public void click_view_add_Document() {
    	clickElement(driver, test, OCR_Button_ViewOrAddDoc,"Clicking on View/AddDocument Button");
    }
    // Upload document
	public void add_Document(String DocumentType, String DocumentDescription, String uploadfileName) {	
		
		selectByVisibleText(driver, test, OCR_DocumentType,"Enter Document Type : ", DocumentType);		
		typeText(driver, test,OCR_Document_Description ,"Enter Description : ",DocumentDescription);
		Wait.waitfor(3);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript ("arguments[0].click();" , driver.findElement(By.xpath(OCR_UploadFile)));
		//WebElement UploadFile= driver.findElement(By.xpath(OCR_UploadFile));
		//UploadFile.click();
		Wait.waitfor(3);
		//typeText(driver, test,  OCR_UploadFile, "Click Upload File Button: "," ");
		Wait.waitfor(3);
		uploadFile(driver, test, uploadfileName, "Uploading document");
		//uploadFile(driver, test, "TestDataVms.xlsx", "Uploading document");
		//typeText(driver, test, OCR_UploadFile, "sending the excel : ", System.getProperty("user.dir")+ "\\testdata\\TestDataVms.xlsx");	    
		Wait.waitfor(3);			
						
	}
	
	// Uploading the Document
		public void uploadDoc(String DocumentType, String DocumentDescription, String uploadfileName) {
			try {
				selectByVisibleText(driver, test, OCR_DocumentType,"Select the document type from dropdown :", DocumentType);
				typeText(driver, test, OCR_Document_Description, "Add Description in box :", DocumentDescription);
				mouseOverAndClick(driver, test, OCR_AddDocpopUpUploadFile, "click on Upload File :");
				Wait.waitfor(4);
				uploadFile(driver, test, uploadfileName, "Document is Added : " + uploadfileName);
				Wait.waitfor(3);
				click_save();
				clickElement(driver, test, "//button[@id='closeTop']", "Click on Document pop close :");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, "//button[@id='closeTop']", "Click on Document pop close :");
			}
		}
	// Click on Add Note Button
	public void click_addnote() {
		clickElement(driver, test, OCR_Button_AddNote, "Clicking on Add Note Button");
	}
	//Add Note
	public void addnote(String Note) {	
		Wait.waitfor(3);
		typeText(driver, test, OCR_AddEditNote,"Entering Notes: ",Note);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Button_SaveandReturn,"Clicking on Save and Return");
		
	}
	// Click on Forward Button
	public void moveForward() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript ("arguments[0].click();" , driver.findElement(By.xpath(OCR_Button_ForwardNavigation)));
	} 
	//Validate Document Tab
	public void validate_DocumentError() {
		try {
			if (isDisplayed(driver,"//h4[contains(text(),'Error')]")) {				

				if (isDisplayed(driver,"//li[contains(text(),'Document Type is required.')]")) {
					test.log(LogStatus.INFO, "Document Type is required.");
				}
				if (isDisplayed(driver,"//li[contains(text(),'Document Name is required.')]")) {
					test.log(LogStatus.INFO, "Document Name is required.");
				}			
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error Vaildation is not Displayed by clicking on SAVE button in Create New  File Attachment Page.");					
		}
	}
	//Validate Notes Tab
	public void validate_NotesError() {
		try {
			if (isDisplayed(driver,"//h4[contains(text(),'Error')]")) {				

				if (isDisplayed(driver,"//li[contains(text(),'Secure notes is a required field.')]")) {
					test.log(LogStatus.INFO, "Secure notes is a required field.");
				}	
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error Vaildation is not Displayed by clicking on SAVE button in Notes Page.");					
		}
	}
	//Click on Save Button for Notes Screen
	public void save() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript ("arguments[0].click();" , driver.findElement(By.xpath(OCR_Button_NSave)));
	}
	
	public void click_save() {
		clickElement(driver, test, OCR_Button_Doc_Save, "Click on Save Button on Document Page: ");
	}
	//Click on Cancel Button
	public void cancel() {
		clickElement(driver, test, OCR_Button_Cancel, "click on cancel :");	
	}
	
	public void movetosubmit() {
		clickElement(driver, test, "//a[contains(text(),'Submit')]","Clicking on Submit tab :");
	} 
	
	public void movetoDocNotes() {
		clickElement(driver, test, "//a[contains(text(),'Documents/Notes')]","Clicking on Documnet/Notes tab :");
	} 

}
