package globalExportClasses;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ResultLetterOfCreditInstructionsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_CLCI_HeaderRLCI = "//h3[contains(text(),'Result Letter Of Credit Instructions (LCI)')]";
	public static final String OCR_CLCI_HeaderRCopyIcon = "(//i[@class='fa fa-copy'])[1]";
	public static final String OCR_CLCI_HeaderRNewSearchbtn = "//button[contains(text(),'New Search')]";
	
	

	/* ******************************* Constructor ****************************** */

	public ResultLetterOfCreditInstructionsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Title of the Page is Displayed or not
	public void titleDisplayedLCI() {
		isDisplayed(driver, OCR_CLCI_HeaderRLCI);
		test.log(LogStatus.PASS, "Result Letter Of Credit Instructions Page is Displayed  !!");
	}

	// click on Invoice order no
	public void isDisplayResultLCI(String ResultLCI) {
		Wait.waitfor(4);
		isDisplayed(driver, "//a[contains(text(),'" + ResultLCI + "')]");
		test.log(LogStatus.PASS, "LetterOfCreditInstructions is created successfully !! "+ResultLCI);
	}
	
	//copy the existing LCI
	public void copyLCI() {
		Wait.waitfor(2);
		scrollToElement(driver, OCR_CLCI_HeaderRCopyIcon);
		clickElement(driver, test, OCR_CLCI_HeaderRCopyIcon, "Click on Copy icon :");
	}
	
	public void newSearchBtn() {
		Wait.waitfor(2);
		clickElement(driver, test, "//span[@class='ui-paging-info']", "Clicking on random element to avoid going to module selection directly :");
		clickElement(driver, test, OCR_CLCI_HeaderRNewSearchbtn, "Click on New Search Button :");
		
	}

	public void clickLCIID(String LCIId) {
		Wait.waitfor(2);
		clickElement(driver, test, "//td[@aria-describedby='grid_lcId']//a[contains(text(),'"+ LCIId +"')]", "Click on LCI ID link to open :" +LCIId);
	}
	
	public void verifyResultDisplayed(String serialNum) {
		Wait.waitfor(2);
		isDisplayed(driver, "//tr[@id='1']//td[contains(text(),'"+ serialNum +"')]");
		try {
			if(serialNum.equals(1)) {
				test.log(LogStatus.PASS, "Result is displayed successfully : ");
			}
				
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Result is not displayed, No record found for the search criteria : ");
		}
	}
	
	public void deleteIcon() {
		Wait.waitfor(2);
		clickElement(driver, test, "//i[@class='fa fa-trash-o']", "Click on Delete icon :");
		Alert a1 = driver.switchTo().alert();
		 a1.accept();
	}
	
	 public void noResultMsg() {
		 Wait.waitfor(2);
		 String resultMsg = getText(driver, test, "//li[contains(text(),'No Records found.')]", "No result found :");
		 try {
			 if(resultMsg.equalsIgnoreCase("No Records found.")) {
				 test.log(LogStatus.PASS, "Deleted Message is not found : ");
			 }
		 }catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Deleted message is found : ");
			}
	 }
	
//	 public String fetchLCI() {
//		 String DelLCI;
//		 Wait.waitfor(2);
//		 return fetchLCI = getText(driver, test, "//td[@aria-describedby='grid_lcId']//a[contains(text(),'"+ DelLCI +"')]", DelLCI);
//	 }
	
}
