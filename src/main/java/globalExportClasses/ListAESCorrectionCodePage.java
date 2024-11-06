package globalExportClasses;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ListAESCorrectionCodePage extends GenericMethods{
	

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_ListAESCorrectionCodePage_AddAESCorrectionCodeBtn = "//button[@name='Add']";
	public static final String OCR_ListAESCorrectionCodePage_CopyIcon = "(//i[@class='fa fa-copy'])[1]";
	public static final String OCR_ListAESCorrectionCodePage_DeleteIcon = "(//i[@class='fa fa-trash-o'])[1]";
	public static final String OCR_ListAESCorrectionCodePage_ValidateHeading = "//h3[@class='page-heading']";
	

	/* ******************************* Constructor ****************************** */

	public ListAESCorrectionCodePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	
	public void click_AddAESCorrectionCode() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_ListAESCorrectionCodePage_AddAESCorrectionCodeBtn, "Click on Add AES Correction Code : ");
	}
	
	public void click_Copy() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_ListAESCorrectionCodePage_CopyIcon, "Click on Copy icon : ");
	}
	
	public void click_Delete() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_ListAESCorrectionCodePage_DeleteIcon, "Click on Delete icon : ");
	}
	
	public void validateHeading() {
		Wait.waitfor(2);
		 try {
	            if(isDisplayed(driver, OCR_ListAESCorrectionCodePage_ValidateHeading)) {
	                test.log(LogStatus.PASS, "Title is Displayed : List AES Correction Code");
	            }
	        } catch (Exception e) {
	            testFailSshot(driver, test);
	            test.log(LogStatus.FAIL, "Title is not Displayed : List AES Correction Code");
	        }
	}
	
	//validate addition of AES code
	public void validateAddAES(String AES) {
		Wait.waitfor(2);
		String getAESValue = getText(driver, test, "//td[@aria-describedby='grid_correctionCode']//a[contains(text(),'"+ AES +"')]", AES);
		try {
		if(getAESValue.equalsIgnoreCase("F")) {
			test.log(LogStatus.PASS, "AES Code is added successfully :");
		}
		
	}catch(Exception e) {
		testFailSshot(driver, test);
		test.log(LogStatus.FAIL, "AES Code is not added successfully :");
	}
	
}
	
	//validate copying an AES code
	public void validateCopyAESZ(String AES) {
		Wait.waitfor(2);
		String getAESValue = getText(driver, test, "//td[@aria-describedby='grid_correctionCode']//a[contains(text(),'"+ AES +"')]", AES);
		try {
		if(getAESValue.equalsIgnoreCase("Z")) {
			test.log(LogStatus.PASS, "AES Code is copied successfully :");
		}
		
	}catch(Exception e) {
		testFailSshot(driver, test);
		test.log(LogStatus.FAIL, "AES Code is not copied successfully :");
	}
	
}
	
	public void copyAESCode(String copyAES) {
		Wait.waitfor(2);
		clickElement(driver, test, "(//i[@class='fa fa-copy'])[4]", copyAES);
	}
	
	//delete AES Code F
	public void deleteF_AESCode() {
		Wait.waitfor(2);
		clickElement(driver, test, "(//i[@class='fa fa-trash-o'])[4]", "Click on Delete icon to delete AES Code F :");
		Alert a1 = driver.switchTo().alert();
		 a1.accept();
		
	}
	
	//delete AEs Code Z
	public void deleteZ_AESCode() {
		Wait.waitfor(2);
		clickElement(driver, test, "(//i[@class='fa fa-trash-o'])[6]", "Click on Delete icon to delete AES Code Z :");
		Alert a1 = driver.switchTo().alert();
		 a1.accept();
		
	}
	
	//verify AES Code F is deleted or not
	public void verifyDeletedItems_F() {
		Wait.waitfor(2);
	//	isDisplayed(driver, "//td[@aria-describedby='grid_correctionCode']//a[contains(text(),'F')]");
		try {
		if(isDisplayed(driver, "//td[@aria-describedby='grid_correctionCode']//a[contains(text(),'F')]")) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "AES Code F is not deleted successfully :");
			
		}
		}catch(Exception e) {
	
		test.log(LogStatus.PASS, "AES Code F is deleted successfully :");
	}	
}
	
	//verify AES Code Z is deleted or not
		public void verifyDeletedItem_Z() {
			Wait.waitfor(2);
		//	isDisplayed(driver, "//td[@aria-describedby='grid_correctionCode']//a[contains(text(),'F')]");
			try {
			if(isDisplayed(driver, "//td[@aria-describedby='grid_correctionCode']//a[contains(text(),'Z')]")) {
				test.log(LogStatus.FAIL, "AES Code Z is not deleted successfully :");
				
			}
			}catch(Exception e) {
	//		testFailSshot(driver, test);
			test.log(LogStatus.PASS, "AES Code Z is deleted successfully :");
		}	
	}
}
