package vmsClasses;

import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;
import utilities.Wait;

public class PolicyDocumentsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_VMCT_PD_SBUCode = "//select[@id='vmmPolicyDocumentConfValue_sbuCode']";
	public static final String OCR_VMCT_PD_Site = "//select[@id='vmmPolicyDocumentConfValue_siteId']";
	public static final String OCR_VMCT_PD_Nationality = "//select[@id='vmmPolicyDocumentConfValue_usForeign']";
	public static final String OCR_VMCT_PD_VisitorCategory = "//select[@id='vmmPolicyDocumentConfValue_visitorType']";
	public static final String OCR_VMCT_PD_Configure = "//button[@id='policyDocConfig']";
	public static final String OCR_VMCT_PD_DocDetilsSave = "//button[@id='savePolicyResult']";
	public static final String OCR_VMCT_PD_Delete = "//a[@class='delete-icon']";	

	/* ******************** Constructor ***************************** */

	public PolicyDocumentsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */	

	// Select SBU Code,Site,Nationality,VisitorCategory in policy documents
	public void select_Policy(String SBUCode,String Site,String Nationality,String VisitorCategory) {				
		selectByVisibleText(driver, test, OCR_VMCT_PD_SBUCode, "Select SBU Code: " , SBUCode);
		selectByVisibleText(driver, test, OCR_VMCT_PD_Site, "Select Site " , Site);
		selectByVisibleText(driver, test, OCR_VMCT_PD_Nationality, "Select SBU Code: " , Nationality);
		selectByVisibleText(driver, test, OCR_VMCT_PD_VisitorCategory, "Select SBU Code: " , VisitorCategory);		
	}

	//Click configure button
	public void click_ConfigBtn() {
		clickElement(driver, test, OCR_VMCT_PD_Configure, "click on config");
	}

	//clicking the check box of Requried Document Type and Click on Save button
	public void click_DocTypeCheckBox(String DocumentType) {
		ArrayList<String> DocTypes = stringtoken(DocumentType);
		Wait.waitfor(2);
		for (int i = 0; i < DocTypes.size(); i++) {			
			String DocType = "//td[contains(text(),'" +DocTypes.get(i).trim()+ "')]/../td[2]/input";
			clickElement(driver, test, DocType, "Clicking the CheckBox :"+DocTypes.get(i));
		}
		clickElement(driver, test, OCR_VMCT_PD_DocDetilsSave, "click on Doc Details Save ");

	}	

	// Clicking on delete icon and Accepting Alert to delete the record
	public void click_DeleteIcon() {
		clickElement(driver, test, OCR_VMCT_PD_Delete, "Click on Delete icon");
		AlertPopUp(driver, test, "Are you sure you wish to delete?");
		
	}

}
