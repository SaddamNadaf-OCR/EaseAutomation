package crsClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class FTSubmitPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_Link_ExportName = "//a[@id='tdfpLink']";
	public static final String OCR_Link_SecurityName = "//b[contains(text(),'Security')]/following::a[contains(text(),'Name')][1]";
	public static final String OCR_Link_ManagerName = "//b[contains(text(),'Security')]/following::a[contains(text(),'Name')][2]";
	public static final String OCR_Link_DirectorName = "//b[contains(text(),'Security')]/following::a[contains(text(),'Name')][3]";
	public static final String OCR_UserFirstName = "//input[@id='searchForm_userProfile_userFirstname']";
	public static final String OCR_Button_Search = "//button[contains(text(),'Search')]";
	public static final String OCR_Button_Select = "//button[contains(text(),'Select')]";
	public static final String OCR_Button_Save = "//button[contains(text(),'Save')]";
	public static final String OCR_Button_Submit = "//button[contains(text(),'Submit')]";
	public static final String OCR_Button_ForwardNavigation = "//button[@id='next-btn']";

	/*
	 * ******************************** Constructor ********************************
	 */
	public FTSubmitPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	// Clicking on Export Name link
	public void click_exportname() {
		clickElement(driver, test, OCR_Link_ExportName, "Clicking on Export Name link :");
	}

	// Selecting Record FROM Reviewer Name Popup
	public void select_record(String UserFirstName) {
		typeText(driver, test, OCR_UserFirstName, "Enter User First Name : ", UserFirstName);
		clickElement(driver, test, OCR_Button_Search, "Click on Search Button");
		Wait.waitfor(3);
		clickElement(driver, test, "//div[@class='ui-jqgrid-bdiv']", "Selecting Record :");
		clickElement(driver, test, OCR_Button_Select, "Click on Select Button :");
	}

	// Clicking on Security Name link
	public void click_securityname() {
		clickElement(driver, test, OCR_Link_SecurityName, "Clicking on Security Name link");
	}

	// Clicking on Manager Name link
	public void click_managername() {
		clickElement(driver, test, OCR_Link_ManagerName, "Clicking on Manager Name link");
	}

	// Clicking on Director Name link
	public void click_directorname() {
		scrollToElement(driver, OCR_Link_DirectorName);
		scrollToBottom(driver);
		clickElement(driver, test, OCR_Link_DirectorName, "Clicking on Director Name link");
	}

	// Click on Save Button
	public void save() {
		scrollToElement(driver, OCR_Button_Save);
		scrollToTop(driver);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(OCR_Button_Save)));
		// clickElement(driver, test,,"Clicking on Save Button");
	}

	// Click on Submit Button
	public void submit() {
		clickElement(driver, test, OCR_Button_Submit, "Clicking  on Submit Button");
	}

	// Clicking on Forward Button
	public void moveforward() {
		clickElement(driver, test, OCR_Button_ForwardNavigation, "Clicking  on Forward Button");
	}

	// Validate submit page error
	public void validate_submitpageerror() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {

				if (isDisplayed(driver, "//li[contains(text(),'Export Representative name is required.')]")) {
					test.log(LogStatus.INFO, "Export Representative name is required.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Security Representative name is required.')]")) {
					test.log(LogStatus.INFO, "Security Representative name is required.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Manager Representative name is required.')]")) {
					test.log(LogStatus.INFO, "Manager Representative name is required.");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error Validation is not Displayed by clicking on SAVE button in Notes Page");
		}

	}

}
