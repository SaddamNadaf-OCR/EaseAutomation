package dpssClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchConsigneePage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;
	
	/* ******************************** LOCATORS ******************************** */
	
	public static final String OCR_Consignee_ConsigneeID = "//input[@id='searchConsignee_consignee_consigneeId']";
	public static final String OCR_Consignee_ConsigneeName = "//input[@id='searchConsignee_consignee_consigneeName']";
	public static final String OCR_Consignee_CreatedFromDate = "//input[@id='searchConsignee_fromCreationDate']";
	public static final String OCR_Consignee_SaveAndReturn = "//button[contains(text(),'Save & Return')]";
	public static final String OCR_Consignee_Search = "//button[contains(text(),'Search')]";
	public static final String OCR_Consignee_NewSearch = "//button[contains(text(),'New Search')]";
	public static final String OCR_Consignee_ConsigneeDelete = "//i[@class='fa fa-trash-o'][1]";
	public static final String OCR_Consignee_ConsigneeIDLink = "//*[@id=\"1\"]/td[2]/a";
	public static final String OCR_Consignee_AddressField = "//input[@id='editConsignee_consignee_consigneeAddr1']";
	
	public static final String OCR_Consignee_NoRecordsFound = "//li[contains(text(),'No Records found.')]";
	public static final String OCR_Consignee_IDFieldInTable1stRow  = "//tbody/tr[@id='1']/td[2]";
	public static final String OCR_Consignee_NameFieldInTable1stRow  = "//tbody/tr[@id='1']/td[3]";
	public static final String OCR_Consignee_AddressFieldInTable1stRow  = "//tbody/tr[@id='1']/td[4]";
	public static final String OCR_Consignee_StatusFieldInTable1stRow  = "//tbody/tr[@id='1']/td[6]";
	
	/* ******************** Constructor ***************************** */
	
	public SearchConsigneePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	/* ******************** Actions ********************************* */
	
	
	// Enter Consignee ID
	public void enter_ConsigneeID(String ID){
		typeText( driver, test, OCR_Consignee_ConsigneeID ,"Entering Consignee ID ",ID);
	}
			
	// Enter Consignee Name
		public void enter_ConsigneeName(String Name){
			typeText( driver, test, OCR_Consignee_ConsigneeName ,"Entering Consignee Name ",Name);
		}
		
	// Enter Consignee Address
		public void enter_ConsigneeAddress(String Address){
			clearAndSet( driver, test, OCR_Consignee_AddressField ,"Entering Consignee Address ",Address);
		}		

	// Click on Save And Return
		public void click_SaveAndReturn() throws InterruptedException {
			clickElement(driver, test,OCR_Consignee_SaveAndReturn , "Clicking on Save And Return");
			Wait.waitfor(2);
			}		
		
	// Click on Search
	public void click_Search() throws InterruptedException {
		Wait.waitfor(2);
		clickElement(driver, test,OCR_Consignee_Search , "Clicking on Search");
		}
	
	// Click on New Search
		public void click_NewSearch() throws InterruptedException {
			Wait.waitfor(2);
			clickElement(driver, test,OCR_Consignee_NewSearch , "Clicking on New Search");
			}	
		
	// Click on Consignee ID Link
		public void click_ConsigneeIDLink() throws InterruptedException {
			Wait.waitfor(2);
			clickElement(driver, test,OCR_Consignee_ConsigneeIDLink , "Clicking on Consignee ID Link");
			}		

	// Clicking on CreatedFromDate
		public void click_CreatedFromDate() throws InterruptedException {
			clickElement(driver, test,OCR_Consignee_CreatedFromDate , "Clicking on CreatedDate");
			Wait.waitfor(2);
		}	
		
	// Select Created From Date
		public void select_CreatedFromDate(String date) throws InterruptedException {
//			date( driver, date);
			dateInPopUp(driver, test, "Select the Date : ", date);
				}		
	
	// Clicking on delete icon
		public void click_Delete() throws InterruptedException {
			clickElement(driver, test,OCR_Consignee_ConsigneeDelete , "Clicking on Delete");
			Wait.waitfor(2);
		}			
		
	// Verify No Records Found message
		public void verify_NoRecordsFoundmessage() throws InterruptedException {
			if(isDisplayed(driver,OCR_Consignee_NoRecordsFound)) {
					test.log(LogStatus.PASS, "No Record Found" );
				}
		}	
		
	// Verify text in ID field in Table
		public void verify_IDFieldinTable(String ID) throws InterruptedException {
			validate_FieldText(driver,test,OCR_Consignee_IDFieldInTable1stRow , "Verify the text in ID field ",ID);		
		}	
				
	// Verify text in Name Field in Table
		public void verify_NameFieldinTable(String Name) throws InterruptedException {
			validate_FieldText(driver,test,OCR_Consignee_NameFieldInTable1stRow , "Verify the text in Name field ",Name);		
		}
		
	// Verify text in Address Field in Table
		public void verify_AddressFieldinTable(String Address) throws InterruptedException {
			validate_FieldText(driver,test,OCR_Consignee_AddressFieldInTable1stRow , "Verify the text in Address field ",Address);		
		}		
		
	// Verify text in Status Field in Table
		public void verify_StatusFieldinTable(String Name) throws InterruptedException {
			validate_FieldText(driver,test,OCR_Consignee_StatusFieldInTable1stRow , "Verify the text in Status field ",Name);		
		}	
				
	// Verify text in Address field
				public void verify_AddressField(String Address) throws InterruptedException {
					
					validate_FieldValue(driver,test,OCR_Consignee_AddressField , "Verify the text in Address field ", Address);		
				}	
		
}
