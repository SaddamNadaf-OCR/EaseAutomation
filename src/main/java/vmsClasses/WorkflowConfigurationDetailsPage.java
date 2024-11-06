package vmsClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;
import utilities.Wait;

public class WorkflowConfigurationDetailsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_VMCT_VR_SBUcode = "//select[@id='selSbuCode']";
	public static final String OCR_VMCT_VR_Search = "//input[@id='search']";
	public static final String OCR_VMCT_VR_Edit = "//i[@class='fa fa-edit']";
	public static final String OCR_VMCT_VR_Enforce = "//select[@id='enforceRevG1']";
	public static final String OCR_VMCT_VR_SaveAndReturn = "//button[contains(text(),'Save & Return')]";

	/* ******************** Constructor ***************************** */

	public WorkflowConfigurationDetailsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Select SBU Code // Clicking on Search // Clicking on Edit and select Group
	public void VmctCofigSelect(String SBU, String GroupID) {
		selectByVisibleText(driver, test, OCR_VMCT_VR_SBUcode, "Select SBU CODE : ", SBU);
		clickElement(driver, test, OCR_VMCT_VR_Search, "Clicking on VR Search");
		clickElement(driver, test, OCR_VMCT_VR_Edit, "Clicking on Edit Icon");
		selectByVisibleText(driver, test, "//select[@id='group']", "Select Screen Name: ", GroupID);
		Wait.waitfor(5);
		scrollToBottom(driver);
		Wait.waitfor(3);
	}

	// Select SBU Code // Clicking on Search // Clicking on Edit
	public void VmctCofigSelect(String SBU) {
		selectByVisibleText(driver, test, OCR_VMCT_VR_SBUcode, "Select SBU CODE : ", SBU);
		clickElement(driver, test, OCR_VMCT_VR_Search, "Clicking on VR Search");
		clickElement(driver, test, OCR_VMCT_VR_Edit, "Clicking on Edit Icon");
		Wait.waitfor(3);
	}
	
	//Change the enforce to No
	public void enforceReview(String EnforceReview) {
		selectByVisibleText(driver, test, OCR_VMCT_VR_Enforce, "Select the Enforce Review : ", EnforceReview);
	}
	
	//Click on Save and Return
	public void clickSaveAndReturn() {
		clickElement(driver, test, OCR_VMCT_VR_SaveAndReturn, "Click on Save and Return");
	}

	// Get the Meeting category field
	public String getMeetingCategory() {
		return getAttribute(driver, test, "//input[@id='fieldRow10']", "value", "Get the value of field : ");
	}
}
