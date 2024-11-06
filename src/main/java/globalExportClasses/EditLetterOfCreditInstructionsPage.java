package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class EditLetterOfCreditInstructionsPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_EditLCI_ValidateHeading = "//h3[@class='page-heading']";
	
	
	
	
	
	/* ******************************* Constructor ****************************** */

	public EditLetterOfCreditInstructionsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
		 
	public void validateHeading() {
		Wait.waitfor(2);
		try {
			if (isDisplayed(driver, OCR_EditLCI_ValidateHeading)) {
				test.log(LogStatus.INFO, "Edit Letter Of Credit Instructions (LCI) is opened successfully .");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Edit Letter Of Credit Instructions (LCI) is not opened successfully .");
		}
	}
		
		public void editExporterCode(String ExporterCode) {
			Wait.waitfor(2);
			String exporter = getText(driver, test, "//input[@id='editLetterOfCredit_letterOfCredit_lcFromCode']", "Get the edited value of Exporter");
			
			try {
			if(exporter.equalsIgnoreCase(ExporterCode)) {
				
				test.log(LogStatus.INFO, "Edit Letter Of Credit Instructions (LCI) is edited successfully .");
			
		}
	}catch(Exception e) {
		testFailSshot(driver, test);
		test.log(LogStatus.FAIL, "Edit Letter Of Credit Instructions (LCI) is not Editable .");
	}
		}
		
		public void getLCIid(String getLCIid ) {
			Wait.waitfor(2);
			getLCIid= getText(driver, test, "//input[@id='editLetterOfCredit_letterOfCredit_lcId']", "Fetch the value of LCI ID :");
		 
	
		}
		
	public String getLCIid() {
		return getText(driver, test, "//input[@id='editLetterOfCredit_letterOfCredit_lcId']", "Fetch the value of LCI ID :");
	}
		
		public void enterLCI(String lci) {
			Wait.waitfor(2);
			scrollToElement(driver, "//input[@id='editLetterOfCredit_letterOfCredit_lcId']");
			typeText(driver, test, "//input[@id='editLetterOfCredit_letterOfCredit_lcId']", "Enter LCI ID : ", lci);
		}
		
		
	
}
