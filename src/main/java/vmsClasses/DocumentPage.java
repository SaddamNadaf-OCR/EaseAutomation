//Added By Nancy//
package vmsClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class DocumentPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/*-------------------------------------------Locators-------------------------------------*/	

	public static final String OCR_Button_ViewAddDocument="//button[@id='addDocumentId']";	
	public static final String OCR_DocumentType="//select[@id='docTypeId']";	
	public static final String OCR_Document_Description="//textarea[@id='editDCSFileAttach_documentDetail_comments']";	
	public static final String OCR_UploadFile="//input[@id='fileAttach']";	
	public static final String OCR_KeyWords="//input[@id='keyWord']";	
	public static final String OCR_Button_Add="//input[@name='ok']";	
	public static final String OCR_SourceSystemDocNumber="//input[@id='editDCSFileAttach_documentDetail_systemDocNumber']";	
	public static final String OCR_PostApproval="//input[@id='postApprovalId']";	
	public static final String OCR_TransmitToGovernmentAgency="//input[@id='trnsGovAgency']";	
	public static final String OCR_AdditionalFields="//label[contains(text(),'Additional Fields')]";	
	public static final String OCR_Button_Save="//button[contains(text(),'Save')]";	
	public static final String OCR_Button_ForwardNavigation="//button[@id='next-btn-down']";//button[@id='prev-btn-upper']//button[@id='next-btn-upper']
	public static final String OCR_Button_PopUpCancel = "//button[@id='cancel']";

	/*--------------------------------Constructor------------------------------------------*/	

	public DocumentPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}	

	/*-------------------------------------------Actions-------------------------------------*/

	public void add_Document(String DocumentType, String DocumentDescription,String UploadFile, String DocKeywords,
			String SourceSystemDocNumber) {	
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Button_ViewAddDocument,"Clicking on View/AddDocument Button");
		try {		
			Wait.waitfor(5);
			selectByVisibleText(driver, test, OCR_DocumentType,"Enter Document Type : ", DocumentType);
			typeText(driver, test,OCR_Document_Description ,"Enter Description : ",DocumentDescription);
			Wait.waitfor(5);
			mouseOverAndClick(driver, test, "//i[@class='fa fa-upload']", "click on upload file");
			uploadFile(driver, test,UploadFile , "upload document");
			/*clickElement(driver, test, OCR_AdditionalFields, "Clicking on Additional Fields section");
			typeText(driver, test, OCR_KeyWords,"Enter Keywords : ", DocKeywords);
			clickElement(driver, test, OCR_Button_Add, "Clicking on Add Button");
			Wait.waitfor(5);
			typeText(driver, test, OCR_SourceSystemDocNumber, "Enter Source System Doc Number : ", SourceSystemDocNumber);
			clickElement(driver, test, OCR_PostApproval, "Check Post Approval checkbox");
			clickElement(driver, test, OCR_TransmitToGovernmentAgency, "Check Transmit To Government Agency checkbox ");*/
			Wait.waitfor(3);
			clickElement(driver, test, OCR_Button_Save,"Clicking on Save and Return Button");
			Wait.waitfor(2);
			clickElement(driver, test, OCR_Button_PopUpCancel, "click on cancel");
			Wait.waitfor(10);
		}
		catch(Exception e){ 	
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_Button_PopUpCancel, "click on cancel");
			test.log(LogStatus.FAIL, "Click on cancel");
		}
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript ("arguments[0].click();" , driver.findElement(By.xpath(OCR_Button_ForwardNavigation)));
	}

	//click on Forward button
	public void Forword() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Button_ForwardNavigation,"Click on Forward Navigation Button");	
	}
	
}
