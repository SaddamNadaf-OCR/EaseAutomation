package crsClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class AgreementReqAmendmentMainPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_AmendmentPurpose_Checkbox = "//div[@class='col-xs-5']/input[@type='checkbox']";
	public static final String OCR_AmendmentNo = "//input[@id='editAgmtDetailsAmendment_agmtDetailsAmendment_amendmentNo']";
	public static final String OCR_ScopeChange = "//textarea[@id='editAgmtDetailsAmendment_agmtDetailsAmendment_scopeChange']";
	public static final String OCR_AdditionchangeinHardwareTechData = "//textarea[@id='editAgmtDetailsAmendment_agmtDetailsAmendment_addChgHwTechData']";
	public static final String OCR_PartiesInvolvedAddDeletionofParties = "//textarea[@id='editAgmtDetailsAmendment_agmtDetailsAmendment_partiesInvolved']";
	public static final String OCR_EnduserEndusechange = "//textarea[@id='editAgmtDetailsAmendment_agmtDetailsAmendment_enduserEnduseChg']";
	public static final String OCR_ExtendTerm = "//textarea[@id='editAgmtDetailsAmendment_agmtDetailsAmendment_extendTerm']";
	public static final String OCR_ComplianceIssuesDiscovered = "//textarea[@id='editAgmtDetailsAmendment_agmtDetailsAmendment_complIssuesDiscovered']";
	public static final String OCR_Other = "//textarea[@id='editAgmtDetailsAmendment_agmtDetailsAmendment_otherDetails']";
	public static final String OCR_USMLCategories = "//textarea[@id='editAgmtDetailsAmendment_agmtDetailsAmendment_usmlCategories']";
	public static final String OCR_Button_AddCountry = "//button[contains(text(),'Add Country')]";
	public static final String OCR_AddCountryofUltDest = "//select[@id='cntryListIdList']";
	public static final String OCR_Button_Add = "//button[@name='move-right']";
	public static final String OCR_Button_SaveandReturn = "//button[contains(text(),'Save & Return')]";
	public static final String OCR_Button_Save = "//button[contains(text(),'Save')]";
	public static final String OCR_Button_ForwardNavigation = "//button[@id='next-btn']";

	public AgreementReqAmendmentMainPage(WebDriver driver, ExtentTest test) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.test = test;
	}

	// Select all checkboxes
	public void amendmentpurpose() {
		clickElement(driver, test, "html/body/div[2]/form/div[3]/div/div[5]/div[1]",
				"Click outside to remove module list");
		Wait.waitfor(3);
		List<WebElement> noofcheckboxes = driver.findElements(By.xpath(OCR_AmendmentPurpose_Checkbox));
		for (int i = 0; i < noofcheckboxes.size(); i++) {
			WebElement checkboxes = noofcheckboxes.get(i);
			checkboxes.click();

		}
	}

	// Enter Amendment No
	public void enter_amendmentno(String AmendmentNo) {
		typeText(driver, test, OCR_AmendmentNo, "Enter the AmendmentNo : ", AmendmentNo);
	}

	// Enter Scope Change
	public void enter_scopechange(String ScopeChange) {
		typeText(driver, test, OCR_ScopeChange, "Enter the Scope Change : ", ScopeChange);
	}

	// Enter Additional Change in Hardware Tech Data
	public void enter_AdditionChangeInHardwareTechData(String AdditionChangeInHardwareTechData) {
		typeText(driver, test, OCR_AdditionchangeinHardwareTechData,
				"Enter the Addition Change In Hardware Tech Data : ", AdditionChangeInHardwareTechData);
	}

	// Enter Parties Involved
	public void enter_PartiesInvolvedAddDeletionofParties(String PartiesInvolvedAddDeletionofParties) {
		typeText(driver, test, OCR_PartiesInvolvedAddDeletionofParties,
				"Enter the Parties Involved Add Deletion of Parties : ", PartiesInvolvedAddDeletionofParties);
	}

	// Enter End User Change
	public void enter_EndUserEndUseChange(String EndUserEndUseChange) {
		typeText(driver, test, OCR_EnduserEndusechange, "Enter the EndUser EndUse Change : ", EndUserEndUseChange);
	}

	// Enter Extend Term
	public void enter_ExtendTerm(String ExtendTerm) {
		typeText(driver, test, OCR_ExtendTerm, "Enter the Extend Term :", ExtendTerm);
	}

	// Enter Compliance Issues Discovered
	public void enter_ComplianceIssuesDiscovered(String ComplianceIssuesDiscovered) {
		typeText(driver, test, OCR_ComplianceIssuesDiscovered, "Enter the Compliance Issues Discovered : ",
				ComplianceIssuesDiscovered);
	}

	// Enter Other
	public void enter_Other(String Other) {
		typeText(driver, test, OCR_Other, "Enter the Other : ", Other);
	}

	// Enter USML Categories
	public void enter_USMLCategories(String USMLCategories) {
		typeText(driver, test, OCR_Other, "Enter the USML Categories : ", USMLCategories);
	}

	// Add Country of Ultimate Destination
	public void addCountryOfUltDestination(String Country) {
		scrollToBottom(driver);
		scrollToElement(driver, OCR_Button_AddCountry);
		Wait.waitfor(2);
		clickElement(driver, test, OCR_Button_AddCountry, "Clicking on Add Country Button");
		Wait.waitfor(3);
		try {
			selectByVisibleText(driver, test, OCR_AddCountryofUltDest, "Selecting Country : ", Country);
		} catch (Exception e) {
			// TODO: handle exception
		}

		Wait.waitfor(3);
		clickElement(driver, test, OCR_Button_Add, "Click on  Country");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Button_SaveandReturn, "Clicking on Save and Return Button");
	}

	// Click on Save Button
	public void save() {
		clickElement(driver, test, OCR_Button_Save, "Clicking on Save Button");
	}

	// Move to Foreign Parties Tab
	public void moveto_ForeignParties() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();",
				driver.findElement(By.xpath("//span[contains(text(), 'Foreign Parties')]")));
		// clickElement(driver, test, "//span[contains(text(), 'Foreign Parties')]","
		// Move to Foreign Parties Page: ");
	}

	// Move to US Parties Tab
	public void moveto_USParties() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();",
				driver.findElement(By.xpath("//span[contains(text(), 'US Parties')]")));
		// clickElement(driver, test, "//span[contains(text(), 'US Parties')]"," Move to
		// US Parties Page: ");
	}

	// Click on Forward Button
	public void moveForward() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(OCR_Button_ForwardNavigation)));
	}

}
