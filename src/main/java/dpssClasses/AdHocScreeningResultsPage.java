package dpssClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class AdHocScreeningResultsPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	
	public static final String OCR_AdhocResults_NewScreen = "//button[contains(text(),'New Screen')]";
	public static final String OCR_AdhocResults_MatchesFoundMessage = "//div[contains(text(),'matches found for')]"; 
	public static final String OCR_AdhocResults_NoMatchesFoundMessage = "//div[contains(text(),'No matches found for')]";
	public static final String OCR_AdhocResults_NameFieldInTable1stRow  = "//tbody/tr[@id='1']/td[4]";
	public static final String OCR_AdhocResults_CountryFieldInTable1stRow  = "//tbody/tr[@id='1']/td[5]";
	public static final String OCR_AdhocResults_ScoreFieldInTable1stRow  = "//tbody/tr[@id='1']/td[3]";
	public static final String OCR_AdhocResults_AgencyFieldInTable1stRow  = "//tbody/tr[@id='1']/td[9]";
	
	public static final String OCR_AdhocResults_AddToFile  = "//label[contains(text(),'Add to File')]";
	public static final String OCR_AdhocResults_AddToFileList  = "//select[@id='addFile']";
	public static final String OCR_AdhocResults_AddRecordToDatabaseSave  = "//button[text()='Save']";
	public static final String OCR_AdhocResults_AddRecordToDatabaseClose  = "//body/div[@id='content-cont']/div[3]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/button[1]";
	public static final String OCR_AdhocResults_PDFIcon  = "//i[@class='fa fa-file-pdf-o']";
	public static final String OCR_AdhocResults_EmailIcon  = "//i[@class='fa fa-envelope']";
	public static final String OCR_AdhocResults_PrintIcon  = "//i[@class='fa fa-print']";
	
	/* ******************** Constructor ***************************** */
	
	public AdHocScreeningResultsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	/* ******************** Actions ********************************* */	
	
	// Click on New Screen
		public void click_NewScreen() throws InterruptedException {
			clickElement(driver, test,OCR_AdhocResults_NewScreen , "Clicking on New Screen");
			Wait.waitfor(2);
		}
		
	// Click on Add To File
		public void click_AddToFile() throws InterruptedException {
			clickElement(driver, test,OCR_AdhocResults_AddToFile , "Clicking on Add To File");
			Wait.waitfor(2);
		}		
		
	// Click on AddRecordToDatabase Save
		public void click_AddRecordToDatabasSave() throws InterruptedException {
			clickElement(driver, test,OCR_AdhocResults_AddRecordToDatabaseSave , "Clicking on AddRecordToDatabase Save");
			Wait.waitfor(2);
		}			

	// Click on AddRecordToDatabase Close
		public void click_AddRecordToDatabaseWindowClose() throws InterruptedException {
			clickElement(driver, test,OCR_AdhocResults_AddRecordToDatabaseClose , "Clicking on AddRecordToDatabase Save");
			Wait.waitfor(2);
		}		
		
	// Select option from Entity Search Type 
		public void select_EntityFile(String File ) {
			selectByVisibleText(driver,test,OCR_AdhocResults_AddToFileList ,"Select File :",File);
		}		
		
	
	// Verify Match Found message
		public void verify_MatchFoundmessage() throws InterruptedException {
			if(isDisplayed(driver, OCR_AdhocResults_MatchesFoundMessage)) {
				test.log(LogStatus.PASS, "Matches Found" );
			}
		}	

	// Verify No Match Found message
		public void verify_NoMatchFoundmessage() throws InterruptedException {
			if(isDisplayed(driver, OCR_AdhocResults_NoMatchesFoundMessage)) {
					test.log(LogStatus.PASS, "No Match Found" );
			}
		}		
		
	// Verify PDF Icon
		public void verify_PDFIcon() throws InterruptedException {
			if(isDisplayed(driver,OCR_AdhocResults_PDFIcon )) {
					test.log(LogStatus.PASS, "PDF Icon displayed" );
			}
		}
				
	// Verify Email Icon
		public void verify_EmailIcon() throws InterruptedException {
			if(isDisplayed(driver,OCR_AdhocResults_EmailIcon )) {
					test.log(LogStatus.PASS, "Email Icon displayed" );
			}
		}				
		
	// Verify Print Icon
		public void verify_PrintIcon() throws InterruptedException {
			if(isDisplayed(driver,OCR_AdhocResults_PrintIcon )) {
					test.log(LogStatus.PASS, "Print Icon displayed" );
			}
		}	
				
	// Verify text in Name Field in Table
		public void verify_NameFieldinTable(String Name) throws InterruptedException {
			validate_FieldText(driver,test,OCR_AdhocResults_NameFieldInTable1stRow , "Verify the text in Name field ",Name);		
		}			
		
	// Verify text in Country Field in Table
		public void verify_CountryFieldinTable(String Country) throws InterruptedException {
			validate_FieldText(driver,test,OCR_AdhocResults_CountryFieldInTable1stRow , "Verify the text in Country field ",Country);		
		}
		
	// Verify text in Score Field in Table
		public void verify_ScoreFieldinTable(String Score) throws InterruptedException {
			validate_FieldText(driver,test,OCR_AdhocResults_ScoreFieldInTable1stRow , "Verify the text in Score field ",Score);		
		}	
		
	// Verify text in Agency Field in Table
		public void verify_AgencyFieldinTable(String Agency) throws InterruptedException {
			validate_FieldText(driver,test,OCR_AdhocResults_AgencyFieldInTable1stRow , "Verify the text in Agency field ",Agency);		
		}	
		
	// Verify text in Addressncy Field in Table
		public void verify_AddressFieldinTable(String Address) throws InterruptedException {
			validate_FieldText(driver,test,OCR_AdhocResults_AgencyFieldInTable1stRow , "Verify the text in Address field ",Address);		
		}	
		
}



