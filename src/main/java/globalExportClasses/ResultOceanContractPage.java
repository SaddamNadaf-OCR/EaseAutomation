package globalExportClasses;
/* 
 * Module : Export Operation
 * Author  : Saddam
 * created date : May 2024
 * Descriptions : Result Ocean Contract Page
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil 
 */
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilities.GenericMethods;

public class ResultOceanContractPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_ResultOceanContractResultPage_Heading = "//h3[contains(text(),'Result Ocean Contract')]";
	public static final String OCR_ResultOceanContractResultPage_NewSearch = "//button[contains(text(),'New Search')]";
	public static final String OCR_ResultOceanContractResultPage_CopyIcon = "//i[@class='fa fa-copy']";
	public static final String OCR_ResultOceanContractResultPage_DeleteIcon = "//i[@class='fa fa-trash-o']";

	/* ******************************* Constructor ****************************** */

	public ResultOceanContractPage(WebDriver driver, ExtentTest test) {
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
		clickElement(driver, test, OCR_ResultOceanContractResultPage_NewSearch, "Clicking on New Search Button :");
	}

	// Click on Copy Icon
	public void copyIcon() {
		clickElement(driver, test, OCR_ResultOceanContractResultPage_CopyIcon, "Clicking on Copy Icon :");
	}

	// Click on Delete Icon
	public void deleteIcon() {
		clickElement(driver, test, OCR_ResultOceanContractResultPage_DeleteIcon, "Clicking on Delete ICon :");
	}
	
	//Heading is Displayed
	public void titleisDisplayed() {
		try {
			if(isDisplayed(driver, OCR_ResultOceanContractResultPage_Heading)) {
				test.log(LogStatus.PASS, "Title is Displayed :");
			}
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Title is Not Displayed :");
		}
	}
}
