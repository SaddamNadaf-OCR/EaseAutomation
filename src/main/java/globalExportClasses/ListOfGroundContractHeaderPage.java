package globalExportClasses;
/* 
 * Module : Export Operation
 * Author  : Saddam
 * created date : May 2024
 * Descriptions : List Of Ground Contract Header Page
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil 
 */
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ListOfGroundContractHeaderPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_GroundContractResultPage_Heading = "//h3[contains(text(),'List of Ground Contract Header')]";
	public static final String OCR_GroundContractResultPage_NewSearch = "//button[contains(text(),'New Search')]";
	public static final String OCR_GroundContractResultPage_CopyIcon = "//i[@class='fa fa-copy']";
	public static final String OCR_GroundContractResultPage_DeleteIcon = "//i[@class='fa fa-trash-o']";

	/* ******************************* Constructor ****************************** */

	public ListOfGroundContractHeaderPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	// Click on Contract Code
	public void clickcontractCode(String ContractCode) {
		clickElement(driver, test, "//a[contains(text(),'" + ContractCode + "')]",
				"Clicking on Contract Code :" + ContractCode);
	}
	
	//Click on New Search button
	public void newSearch() {
		clickElement(driver, test, OCR_GroundContractResultPage_NewSearch, "Clicking on New Search Button :");
	}

	// Click on Copy Icon
	public void copyIcon() {
		clickElement(driver, test, OCR_GroundContractResultPage_CopyIcon, "Clicking on Copy Icon :");
	}

	// Click on Delete Icon
	public void deleteIcon() {
		clickElement(driver, test, OCR_GroundContractResultPage_DeleteIcon, "Clicking on Delete ICon :");
	}
	
	//Heading is Displayed
	public void titleisDisplayed() {
		try {
			if(isDisplayed(driver, OCR_GroundContractResultPage_Heading)) {
				test.log(LogStatus.PASS, "Title is Displayed :");
			}
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Title is Not Displayed :");
		}
	}
}