package vmsClasses;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilities.GenericMethods;
import utilities.Wait;

public class CheckInVerifyDetailsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_CheckInVD_AcknwlegmntAndDocTable = "//table[@id='tableGrid1']";
	public static final String OCR_CheckInVD_CheckIn = "(//i[@class='icon ocr-check-in'])[2]";
	public static final String OCR_ViewPolicyDoc = "//table[@id='tableGrid1']/tbody/tr/td[3]/a/i";
	public static final String OCR_CheckInVD_Agree = "//button[@class='pull-right primary-btn agreeBtn']";
	public static final String OCR_CheckInVD_Back = "//button[contains(text(),'Back')]";
	public static final String OCR_EscortRequired = "//div[@class='lcs_label lcs_label_on']";
	public static final String OCR_CheckInVD_ExpirationDate = "//input[@name='docExpDate']";

	/* ******************** Constructor ***************************** */

	public CheckInVerifyDetailsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Clicking on check In Button
	public void click_CheckIn() {
		if (isDisplayed(driver, OCR_CheckInVD_CheckIn)) {
			Wait.wait(driver, OCR_CheckInVD_CheckIn);
			Wait.waitfor(3);
			clickElement(driver, test, OCR_CheckInVD_CheckIn, "Click on Check In Button");
			Wait.waitfor(3);
			scrollToTop(driver);
		} else {
			test.log(LogStatus.FAIL, "Check In Button is not Present");
		}
	}

	// Verify check in button is disable or not
	public void Disable_CheckIn() {
		if (isEnabled(driver, "//button[@name='ok'][contains(text(),'Check In')]")) {
			Wait.waitfor(3);
			test.log(LogStatus.FAIL, "Check in button is Enabled");
		} else {
			test.log(LogStatus.PASS, "Check In Button is Disabled");
		}
	}

	/* ****************** Validations in CheckIn Verify Details page ************ */

	public void Verify_AckwAndDoc() {
		String scroll = "(//a[@class='accordion-toggle'])[5]";
		Wait.wait(driver, scroll);
		GenericMethods.scrollToElement(driver, scroll);
		isDisplayed(driver, OCR_CheckInVD_AcknwlegmntAndDocTable);
		test.log(LogStatus.PASS, "Acknowledgement and Documentation Table is Displayed");
	}

	// Read and check Policy Document
	public void read_AckwAndDoc() {
		String scroll = "(//a[@class='accordion-toggle'])[5]";
		Wait.wait(driver, OCR_CheckInVD_AcknwlegmntAndDocTable);
		GenericMethods.scrollToElement(driver, scroll);
		if (isDisplayed(driver, OCR_CheckInVD_AcknwlegmntAndDocTable)) {
			test.log(LogStatus.PASS, "Acknowledgement and Documentation Table is Displayed");
		}
		Wait.waitfor(5);
		clickElement(driver, test, OCR_ViewPolicyDoc, "Clicking on Policy Document: ");
		Wait.waitfor(5);
		String scrolldown = "(//div[@class='col-xs-12'])[32]";
		Wait.wait(driver, scrolldown);
		GenericMethods.scrollToElement(driver, scrolldown);
		clickElement(driver, test, OCR_CheckInVD_Agree, "Clicking on Agree Button of Policy Document: ");
		Wait.waitfor(3);
	}

	// click on back button
	public void click_backbutton() {
		clickElement(driver, test, "//label/b", "click on back button");
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[@name='saveLocation']")));
	}

	// checking escort is selected or not.
	public boolean check_escortrequired() {
		return isSelected(driver, OCR_EscortRequired);
	}

	// Accepting Policy document
	public void acceptingPolicy(String DocmentName) {
		ArrayList<String> DocName = stringtoken(DocmentName);
		for (int i = 0; i < DocName.size(); i++) {
			Wait.waitfor(3);
			Wait.wait(driver, "//i[@class='infoDoc fa fa-file-pdf-o']");
			scrollToElement(driver, "//button[@name='saveLocation']");
			Wait.waitfor(3);
			scrollToBottom(driver);
			Wait.waitfor(3);
			int j = i + 1;
			String pdf = "(//i[@class='infoDoc fa fa-file-pdf-o'])" + "[" + j + "]";
			scrollToElement(driver, pdf);
			Wait.waitfor(3);
			clickElement(driver, test, pdf, "click on PDF Document : " + DocName.get(i));
			Wait.waitfor(3);
			try {
				clickElement(driver, test, OCR_CheckInVD_Agree, "click on Agree button ");
				Wait.waitfor(5);
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, "//button[@name='cancel']", "Click on Cancle");
			}
		}
	}

	// Add the identity document
	public void addIdentityDoc(String DocType, String IDNumber, String CountryOfCitizenship, String DocState,
			String IDExpirationDate) {
		scrollToElement(driver, "//span[contains(text(),'Host Details')]");
		Wait.waitfor(3);
		clickElement(driver, test, "(//i[@class='icon ocr-android-add'])[2]",
				"Click on Add Icon in Identifying Documents Tab");
		Wait.waitfor(3);
		try {
			selectByVisibleText(driver, test, "//select[@id='docType']", "Select the Identity Document : ", DocType);
			typeText(driver, test, "//input[@id='saveVisitorsCheckIn_visitorPersonDocCheckInValue_docNo']",
					"Enter the ID Number : ", IDNumber);
			typeText(driver, test, "//input[@id='saveVisitorsCheckIn_docIssCountry']",
					"Enter the Country of Citizenship : ", CountryOfCitizenship);
			typeText(driver, test, "//input[@id='saveVisitorsCheckIn_visitorPersonDocCheckInValue_docIssState']",
					"Enter the State : ", DocState);
			clickElement(driver, test, OCR_CheckInVD_ExpirationDate, "Clicking on Expiration date");
			dateInPopUp(driver, test, "Select the Expiration date : ", IDExpirationDate);
			Wait.waitfor(3);
			clickElement(driver, test, "//button[@id='saveDoc']", "Click on Save");
			Wait.waitfor(3);
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, "(//button[@class='close'])[2]", "Click on Cancle Icon");
		}
	}

	// Edit the Badge Details
	public void editBadgeDetails(String visitCategory) {
		scrollToElement(driver, "//span[contains(text(),'Identifying Documents')]");
		clickElement(driver, test, "//i[@class='icon ocr-pencil-square badgeDetails']", "Click on Edit icon in Badge Details Tab");
		Wait.waitfor(3);
		selectByVisibleText(driver, test, "//select[@id='saveVisitorsCheckIn_visitCategory']", "Select the Visit Category : ", visitCategory);
		clickElement(driver, test, "//button[@id='saveBadgeDetails']", "Click on Save in Badge Details");
		Wait.waitfor(3);
	}
	
	//Verify the identity Document is Added or not
	public void verifyIdentityDoc(String DocType) {
		scrollToElement(driver, "//span[contains(text(),'Host Details')]");
		Wait.waitfor(3);
		try {
			isDisplayed(driver, "//span[contains(text(),'"+DocType+"')]");
			test.log(LogStatus.PASS, "Identity Document is added succesfully");
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Identity Document is NOT added succesfully");
		}
	}

}