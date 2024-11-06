package crsClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class AgreementReqExportsUnderAgreementPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_Button_ForwardNavigation = "//button[@id='next-btn']";
	public static final String OCR_Ques_NotApplicable = "//input[@name='notApplicableQues']";
	public static final String OCR_Button_Save = "//button[contains(text(),'Save')]";

	public AgreementReqExportsUnderAgreementPage(WebDriver driver, ExtentTest test) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.test = test;
	}

	// Click on all not applicable checkbox
	public void notapplicable() {
		List<WebElement> notapplicable = driver.findElements(By.xpath(OCR_Ques_NotApplicable));
		for (int i = 1; i <= notapplicable.size(); i++) {
			Wait.waitfor(3);
			scrollToElement(driver, "(//input[@name='notApplicableQues'])" + "[" + i + "]");
			Wait.waitfor(3);
			clickElement(driver, test, "(//input[@name='notApplicableQues'])" + "[" + i + "]", "Click on Not Applicable");
		}
	}

	// Click on Save Button
	public void save() {
		scrollToElement(driver, OCR_Button_Save);
		scrollToTop(driver);
		clickElement(driver, test, OCR_Button_Save, "Clicking on Save Button: ");
	}

	// Click on Forward Button
	public void moveForward() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(OCR_Button_ForwardNavigation)));
	}

	// Validating Export Under Agreement Tab
	public void validate_ExportUnderAgreementError() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {

				if (isDisplayed(driver,
						"//li[contains(text(),'Questions regarding Licenses in Furtherance of the Agreement - if Rebaselining/Amending Question:1 - Please select one of the options.')]")) {
					test.log(LogStatus.INFO,
							"Questions regarding Licenses in Furtherance of the Agreement - if Rebaselining/Amending Question:1 - Please select one of the options.");
				}
				if (isDisplayed(driver,
						"//li[contains(text(),'Questions regarding Licenses in Furtherance of the Agreement - if Rebaselining/Amending Question:5 - Please select one of the options.')]")) {
					test.log(LogStatus.INFO,
							"Questions regarding Licenses in Furtherance of the Agreement - if Rebaselining/Amending Question:5 - Please select one of the options.");
				}
				if (isDisplayed(driver,
						"//li[contains(text(),'Questions regarding Licenses in Furtherance of the Agreement - if Rebaselining/Amending Question:8 - Description is required.')]")) {
					test.log(LogStatus.INFO,
							"Questions regarding Licenses in Furtherance of the Agreement - if Rebaselining/Amending Question:8 - Description is required.");
				}

			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error Vaildation is not Displayed by clicking on SAVE button in Exports Under Agreement Page");
		}
	}
}
