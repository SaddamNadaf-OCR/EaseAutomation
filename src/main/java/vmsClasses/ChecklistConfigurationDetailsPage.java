package vmsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ChecklistConfigurationDetailsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_VMCT_CL_SbuCode = "//select[@id='selSbuCode']";
	public static final String OCR_VMCT_CL_Search = "//input[@id='search']";
	public static final String OCR_VMCT_CL_EditIcon = "//i[@class='fa fa-edit']";
	public static final String OCR_VMCT_CL_Group = "//select[@id='reviewerType']";
	public static final String OCR_VMCT_CL_Save = "//button[@name='save']";
	public static final String OCR_VMCT_CL_AddBtn = "//button[@class='primary-btn addChecklistItem']";
	public static final String OCR_VMCT_CL_AddSaveBtn = "(//button[@name='save'])[2]";
	public static final String OCR_VMCT_CL_Back = "//button[@id='cancel']";
	public static final String OCR_VMCT_CL_Enable = "//div[@class='lcs_label lcs_label_on']";
	public static final String OCR_VMCT_CL_Disable = "//div[@class='lcs_label lcs_label_off']";
	public static final String OCR_VMCT_CL_EnterCertification = "//textarea[@id='certStatement-textarea']";

	/* ******************** Constructor ***************************** */

	public ChecklistConfigurationDetailsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Select the Sbu
	public void selectCheckListConfig(String SbuCode) {
		selectByVisibleText(driver, test, OCR_VMCT_CL_SbuCode, "Select the Sbu Code : ", SbuCode);
		clickElement(driver, test, OCR_VMCT_CL_Search, "Click on Search");
		clickElement(driver, test, OCR_VMCT_CL_EditIcon, "Click on Edit Icon");
	}
	// Add Certification Statement
	public void TypeCerificationText() {
		typeText(driver, test, OCR_VMCT_CL_EnterCertification, "Add Certification text", "Test");
		
	}
	
	// Select the Group
	public void selectGroup(String CheckListGroup) {
		selectByVisibleText(driver, test, OCR_VMCT_CL_Group, "Select the Group : ", CheckListGroup);
	}

	// click on Add button
	public void clickAdd() {
		clickElement(driver, test, OCR_VMCT_CL_AddBtn, "Click on Add button");
	}

	// click on Save button
	public void click_Save() {
		clickElement(driver, test, OCR_VMCT_CL_Save, "Click on Save");
	}

	// click on Save button in ADD Reviewer
	public void click_SaveReviewer() {
		clickElement(driver, test, OCR_VMCT_CL_AddSaveBtn, "Click on Save button in ADD Reviewer");
	}

	// Click on Certification Statement Enable toggle
	public void click_CertificatnStatementEnable() {
		clickElement(driver, test, OCR_VMCT_CL_Enable, "Click on Certification Statement Enable toggle button");
	}

	// Click on Certification Statement disable toggle
	public void click_CertificatnStatementDisable() {
		clickElement(driver, test, OCR_VMCT_CL_Disable, "Click on Certification Statement Disable toggle button");
	}

	// validaing At least one reviewer group is required.
	public void validateReviewerGroup() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error!')]")) {
				if (isDisplayed(driver, "//li[contains(text(),'At least one Reviewer group is required.')]"))
				{
					test.log(LogStatus.INFO, "At least one reviewer group is required.");
				}
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Error Vaildation is not Displayed by clicking on SAVE button");
			testFailSshot(driver, test);
		}
	}

	// validaing At least one reviewer group is required.
	public void validateAddReviewer() {
		try {
			if (isDisplayed(driver, "//div[contains(@class,'modal-body')]//h4[contains(text(),'Error!')]")) {
				if (isDisplayed(driver, "//li[contains(text(),'Checklist Name is required.')]")) {
					test.log(LogStatus.INFO, "Checklist Name is required.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Field Name 1 is required.')]")) {
					test.log(LogStatus.INFO, "Field Name 1 is required.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Value Condition 1 is required.')]")) {
					test.log(LogStatus.INFO, "Value Condition 1 is required.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Value Text 1 is required.')]")) {
					test.log(LogStatus.INFO, "Value Text 1 is required.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Status Item 1 is required.')]")) {
					test.log(LogStatus.INFO, "List Item 1 is required.");
				}
				Wait.waitfor(3);
				clickElement(driver, test, OCR_VMCT_CL_Back, "Click on Back Button");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error Vaildation is not Displayed by clicking on SAVE button");
			clickElement(driver, test, OCR_VMCT_CL_Back, "Click on Back Button");
		}
	}
}
