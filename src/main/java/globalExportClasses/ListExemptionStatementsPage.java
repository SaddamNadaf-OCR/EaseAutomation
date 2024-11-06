package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ListExemptionStatementsPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_ListExemptionStatementsPage_NewSearchbtn = "//button[contains(text(),'New Search')]";
	public static final String OCR_ListExemptionStatementsPage_AddnewExemption = "//button[contains(text(),'Add New Exemption')]";
	public static final String OCR_ListExemptionStatementsPage_Copy = "(//i[@class='fa fa-copy'])[1]";
	public static final String OCR_ListExemptionStatementsPage_Delete = "(//i[@class='fa fa-trash-o'])[1]";
	public static final String OCR_ListExemptionStatementsPage_Heading = "//h3[@class='page-heading']";
	
	/* ******************************* Constructor ****************************** */

	public ListExemptionStatementsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	public void click_No(String No) {
		Wait.waitfor(2);
		clickElement(driver, test, "(//a[contains(text(),'"+ No +"')])[1]", No);
		
//		try {
//			if(No.length() > 0) {
//		clickElement(driver, test, "(//a[contains(text(),'"+ No +"')])[1]", No);
//	}
//		}catch(Exception e){
//		testFailSshot(driver, test);
//		test.log(LogStatus.FAIL, "Unable to click on No link :");
//		}

	}
	
	public void copyIcon() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_ListExemptionStatementsPage_Copy, "Click on Copy icon :");
	}
	
	public void deleteIcon() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_ListExemptionStatementsPage_Delete, "Click on Delete icon :");
	}
	
		public void titleIsDisplayed() {
	        try {
	            if(isDisplayed(driver, OCR_ListExemptionStatementsPage_Heading)) {
	                test.log(LogStatus.PASS, "Title is Displayed : List Exemption Statements");
	            }
	        } catch (Exception e) {
	            testFailSshot(driver, test);
	            test.log(LogStatus.FAIL, "Title is not Displayed : List Exemption Statements");
	        }
	    }
		
		public void verifyRecordDisplay() {
			Wait.waitfor(2);
			try {
				if(isDisplayed(driver, "(//td[contains(text(),'1')])[1]")) {
					 test.log(LogStatus.PASS, "Record is Displayed : List Exemption Statements Records");
				}
			}catch (Exception e) {
	            testFailSshot(driver, test);
	            test.log(LogStatus.FAIL, "Record is not Displayed : List Exemption Statements Records");
		}
		
		}
	
		public void newSearchBtn() {
			Wait.waitfor(2);
			clickElement(driver, test, OCR_ListExemptionStatementsPage_NewSearchbtn, "Click on New Search : ");
		}
		
		public void addNewExemption() {
			Wait.waitfor(2);
			clickElement(driver, test, "//button[contains(text(),'Add New Exemption')]", "Click on Add new Exemption button :");
		}
		
		
		public void DescIsDisplayed(String Desc) {
			Wait.waitfor(2);
			try {
				isDisplayed(driver, "//td[contains(text(),'" + Desc + "')]");
				test.log(LogStatus.PASS, "Description is displayed :" +Desc);
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Description is not displayed :" +Desc);
			}
		}
		
		
		}
		
		

