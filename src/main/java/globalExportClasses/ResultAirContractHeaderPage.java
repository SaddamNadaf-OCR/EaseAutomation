package globalExportClasses;
/* 
 * Module : Export Operation
 * Author  : Saddam
 * created date : May 2024
 * Descriptions : Result Air Contract Header Page
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil 
 */
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilities.GenericMethods;

public class ResultAirContractHeaderPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_AirContractResultPage_Heading = "//h3[contains(text(),'Result Air Contract Header')]";
	public static final String OCR_AirContractResultPage_CopyIcon = "//i[@class='fa fa-copy']";
	public static final String OCR_AirContractResultPage_DeleteIcon = "//i[@class='fa fa-trash-o']";
	public static final String OCR_AirContractResultPage_NewSearch = "//button[@name='newSearch']";

	/* ******************************* Constructor ****************************** */

	public ResultAirContractHeaderPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	// Click on Contract Code
	public void contractCodeEdit(String ContractCode) {
		clickElement(driver, test, "//a[contains(text(),'" + ContractCode + "')]",
				"Clicking on Contract Code :" + ContractCode);
	}

	// Click on Copy Icon
	public void copyIcon() {
		clickElement(driver, test, OCR_AirContractResultPage_CopyIcon, "Clicking on Copy Icon :");
	}

	// Click on Delete Icon
	public void deleteIcon() {
		clickElement(driver, test, OCR_AirContractResultPage_DeleteIcon, "Clicking on Delete ICon :");
	}
	
	//Heading is Displayed
	public void titleisDisplayed() {
		try {
			if(isDisplayed(driver, OCR_AirContractResultPage_Heading)) {
				test.log(LogStatus.PASS, "Title is Displayed :");
			}
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Title is Not Displayed :");
		}
	}
	
	//Click on New Search Button
	public void newSearch() {
		clickElement(driver, test, OCR_AirContractResultPage_NewSearch, "Clicking on New Search Button :");
	}

}
