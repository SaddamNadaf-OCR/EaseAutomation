package dpssClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class UploadFile extends GenericMethods{
	public WebDriver driver;
	public ExtentTest test;
	
	/* ******************************** LOCATORS ******************************** */
	
	public static final String OCR_UploadFile_UploadFile = "//button[contains(text(),'Upload File')]";
	public static final String OCR_UploadFile_AddFile = "//button[contains(text(),'Add File')]";
	public static final String OCR_UploadFile_UploadFiles = "//input[@id='upload']";
	public static final String OCR_UploadFile_Submit = "//button[@id='submit-btn']";
	public static final String OCR_UploadFile_Save = "//button[contains(text(),'Save')]";
	public static final String OCR_UploadFile_Search = "//button[contains(text(),'Search')]";
	public static final String OCR_UploadFile_FileUploadedSuccessfully = "//li[contains(text(),'File uploaded and submitted to screening successfu')]";
	public static final String OCR_UploadFile_FileNameField = "//input[@id='searchUploadFile_uploadFile_filename']";
	public static final String OCR_UploadFile_Status ="//tbody/tr[@id='1']/td[8]";
	
	/* ******************** Constructor ***************************** */
	
	public UploadFile(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	/* ******************** Actions ********************************* */
	
	// Clicking on Upload File
			public void click_UploadFile() throws InterruptedException {
				clickElement(driver, test,OCR_UploadFile_UploadFile , "Clicking on Upload File");
				Wait.waitfor(2);
			}
	
	// Clicking on Add File
			public void click_AddFile() throws InterruptedException {
				clickElement(driver, test,OCR_UploadFile_AddFile , "Clicking on Add File");
				Wait.waitfor(2);
			}	
	
	// Uploading on Add File
			public void Upload_File(String FileName) throws InterruptedException {
				uploadFile( driver, test,OCR_UploadFile_UploadFiles,"Uploading File", FileName);
				//uploadFile(driver, test, FileName, "Uploading File");
				Wait.waitfor(2);
			}	
	
	// Clicking on Submit
			public void click_Submit() throws InterruptedException {
				clickElement(driver, test,OCR_UploadFile_Submit , "Clicking on Submit");
				Wait.waitfor(2);
			}	
	
	// Clicking on Save
			public void click_Save() throws InterruptedException {
				clickElement(driver, test,OCR_UploadFile_Save , "Clicking on Save");
				Wait.waitfor(2);
			}
			
	// Clicking on Search
			public void click_Search() throws InterruptedException {
				clickElement(driver, test,OCR_UploadFile_Search , "Clicking on Search");
				Wait.waitfor(2);
			}	
			
	// Verify File Uploaded successfully message
			public void verify_FileUploadedSuccessfully() throws InterruptedException {
				if(isDisplayed(driver,OCR_UploadFile_FileUploadedSuccessfully )) {
						test.log(LogStatus.PASS, "File Uploaded successfully" );
				}
			}	
			
	// Verify text in Status Field in Table
			public void verify_StatusFieldinTable(String Status) throws InterruptedException {
				validate_FieldText(driver,test,OCR_UploadFile_Status , "Verify the text in Status field ",Status);		
			}			
			
			
	// Enter File Name
			public void enter_FileName(String Name){
				typeText( driver, test,OCR_UploadFile_FileNameField ,"Entering File Name",Name);
			}	
						

}
