package lpAppUKClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class NatureofGoodsUKPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/********************* Locators *************************/

	public static final String OCR_NatureofGoodsTab = "//i[@id='NATURE_OF_GOODS']";
	public static final String OCR_NatureofGoods_Question1_All = "//input[@id='questionaire1A']";
	public static final String OCR_NatureofGoods_Question1_Some = "//input[@id='questionaire1S']";
	public static final String OCR_NatureofGoods_Question1_None = "//input[@id='questionaire1N']";
	public static final String OCR_NatureofGoods_Question2_All = "//input[@id='questionaire2A']";
	public static final String OCR_NatureofGoods_Question2_Some = "//input[@id='questionaire2S']";
	public static final String OCR_NatureofGoods_Question2_None = "//input[@id='questionaire2N']";
	public static final String OCR_NatureofGoods_Question3_All = "//input[@id='questionaire3A']";
	public static final String OCR_NatureofGoods_Question3_Some = "//input[@id='questionaire3S']";
	public static final String OCR_NatureofGoods_Question3_None = "//input[@id='questionaire3N']";
	public static final String OCR_NatureofGoods_Question4_All = "//input[@id='questionaire4A']";
	public static final String OCR_NatureofGoods_Question4_Some = "//input[@id='questionaire4S']";
	public static final String OCR_NatureofGoods_Question4_None = "//input[@id='questionaire4N']";
	public static final String OCR_NatureofGoods_Question5_All = "//input[@id='questionaire5A']";
	public static final String OCR_NatureofGoods_Question5_Some = "//input[@id='questionaire5S']";
	public static final String OCR_NatureofGoods_Question5_None = "//input[@id='questionaire5N']";
	public static final String OCR_NatureofGoods_Question6_All = "//input[@id='questionaire6A']";
	public static final String OCR_NatureofGoods_Question6_Some = "//input[@id='questionaire6S']";
	public static final String OCR_NatureofGoods_Question6_None = "//input[@id='questionaire6N']";
	public static final String OCR_NatureofGoods_Question7_All = "//input[@id='questionaire7A']";
	public static final String OCR_NatureofGoods_Question7_Some = "//input[@id='questionaire7S']";
	public static final String OCR_NatureofGoods_Question7_None = "//input[@id='questionaire7N']";
	public static final String OCR_NatureofGoods_ApplyChangesToGoodUsageTableBtn = "//button[@id='generateTable']";
	public static final String OCR_NatureofGoods_SaveBtn = "//button[@id='submitItem']";

	/**************** Nature of Goods ****************/
	public NatureofGoodsUKPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public void clickOnNatureOfGoodsTab() {
		clickElement(driver, test, OCR_NatureofGoodsTab, "Click on Nature of Goods Tab");
	}

	public void addNatureOfGoods(String Questionnaire1, String Questionnaire2, String Questionnaire3,
			String Questionnaire4, String Questionnaire5, String Questionnaire6, String Questionnaire7) {

		if (Questionnaire1.length() > 0) {
			if (Questionnaire1.equalsIgnoreCase("All")) {
				clickElement(driver, test, OCR_NatureofGoods_Question1_All, "Click on all option");
			} else if (Questionnaire1.equalsIgnoreCase("Some")) {
				clickElement(driver, test, OCR_NatureofGoods_Question1_Some, "click on Some");
			} else {
				clickElement(driver, test, OCR_NatureofGoods_Question1_None, "Click on None option");
			}
		}

		if (Questionnaire2.length() > 0) {
			if (Questionnaire2.equalsIgnoreCase("All")) {
				clickElement(driver, test, OCR_NatureofGoods_Question2_All, "Click on all option");
			} else if (Questionnaire2.equalsIgnoreCase("Some")) {
				clickElement(driver, test, OCR_NatureofGoods_Question2_Some, "click on Some");
			} else {
				clickElement(driver, test, OCR_NatureofGoods_Question2_None, "Click on None option");
			}
		}

		if (Questionnaire3.length() > 0) {
			if (Questionnaire3.equalsIgnoreCase("All")) {
				clickElement(driver, test, OCR_NatureofGoods_Question3_All, "Click on all option");
			} else if (Questionnaire3.equalsIgnoreCase("Some")) {
				clickElement(driver, test, OCR_NatureofGoods_Question3_Some, "click on Some");
			} else {
				clickElement(driver, test, OCR_NatureofGoods_Question3_None, "Click on None option");
			}
		}

		if (Questionnaire4.length() > 0) {
			if (Questionnaire4.equalsIgnoreCase("All")) {
				clickElement(driver, test, OCR_NatureofGoods_Question4_All, "Click on all option");
			} else if (Questionnaire4.equalsIgnoreCase("Some")) {
				clickElement(driver, test, OCR_NatureofGoods_Question4_Some, "click on Some");
			} else {
				clickElement(driver, test, OCR_NatureofGoods_Question4_None, "Click on None option");
			}
		}

		if (Questionnaire5.length() > 0) {
			if (Questionnaire5.equalsIgnoreCase("All")) {
				clickElement(driver, test, OCR_NatureofGoods_Question5_All, "Click on all option");
			} else if (Questionnaire5.equalsIgnoreCase("Some")) {
				clickElement(driver, test, OCR_NatureofGoods_Question5_Some, "click on Some");
			} else {
				clickElement(driver, test, OCR_NatureofGoods_Question5_None, "Click on None option");
			}
		}

		if (Questionnaire6.length() > 0) {
			if (Questionnaire6.equalsIgnoreCase("All")) {
				clickElement(driver, test, OCR_NatureofGoods_Question6_All, "Click on all option");
			} else if (Questionnaire6.equalsIgnoreCase("Some")) {
				clickElement(driver, test, OCR_NatureofGoods_Question6_Some, "click on Some");
			} else {
				clickElement(driver, test, OCR_NatureofGoods_Question6_None, "Click on None option");
			}
		}

		if (Questionnaire7.length() > 0) {
			if (Questionnaire7.equalsIgnoreCase("All")) {
				clickElement(driver, test, OCR_NatureofGoods_Question7_All, "Click on all option");
			} else if (Questionnaire7.equalsIgnoreCase("Some")) {
				clickElement(driver, test, OCR_NatureofGoods_Question7_Some, "click on Some");
			} else {
				scrollToBottom(driver);
				clickElement(driver, test, OCR_NatureofGoods_Question7_None, "Click on None option");
			}
		}

	}

	public void clickOnApplyChangesToGoodUsageTable() {
		clickElement(driver, test, OCR_NatureofGoods_ApplyChangesToGoodUsageTableBtn, "click on apply changes ");
	}

	public void clickOnSave() {
		Wait.waitfor(4);
		scrollToTop(driver);
		clickElement(driver, test, OCR_NatureofGoods_SaveBtn, "click on Save Button");
	}

	// validations in Nature of Goods Tab
	public void validateNatureofGoodsError() {
		try {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_NatureofGoods_SaveBtn, "Click on Save and Return");
			Wait.waitfor(4);
			if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {
				if (isDisplayed(driver, "//li[text()='Question No : 1  is required']")) {
					test.log(LogStatus.INFO, "Question No : 1  is required");
				}
				if (isDisplayed(driver, "//li[text()='Question No : 2  is required']")) {
					test.log(LogStatus.INFO, "Question No : 2  is required");
				}
				if (isDisplayed(driver, "//li[text()='Question No : 3  is required']")) {
					test.log(LogStatus.INFO, "Question No : 3  is required");
				}
				if (isDisplayed(driver, "//li[text()='Question No : 4  is required']")) {
					test.log(LogStatus.INFO, "Question No : 4  is required");
				}
				if (isDisplayed(driver, "//li[text()='Question No : 5  is required']")) {
					test.log(LogStatus.INFO, "Question No : 5  is required");
				}
				if (isDisplayed(driver, "//li[text()='Question No : 6  is required']")) {
					test.log(LogStatus.INFO, "Question No : 6  is required");
				}
				if (isDisplayed(driver, "//li[text()='Question No : 7  is required']")) {
					test.log(LogStatus.INFO, "Question No : 7  is required");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Errors is not Displayed by clicking on SAVE button for status: Approved");
		}
	}

}
