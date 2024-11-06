package lpAppUKClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class DeclarationUKPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/************************************ Locators ***************************************/
	
	public static final String OCR_DeclarationTab = "//i[@id='DECLARATION']";
	public static final String OCR_DeclarationSectionPage_Name = "//input[@id='declarentName']";
	public static final String OCR_DeclarationSectionPage_Position = "//select[@id='ukDeclarationValue.relationship']";
	public static final String OCR_DeclarationSectionPage_UserCheckBox = "//input[@id='user']";
	public static final String OCR_DeclarationSectionPage_HarmfulInfoText = "//textarea[@id='explanation']";
	public static final String OCR_DeclarationSectionPage_IAgree = "//input[@id='confirmationTxtBox']";
	public static final String OCR_DeclarationSectionPage_SaveBtn = "//input[@id='submitAppl']";

	/********************* Constructor *******************************/
	public DeclarationUKPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public void clickOnDeclarationTab() {
		clickElement(driver, test, OCR_DeclarationTab, "Click on Declaration Tab");
	}
	
	public void addRelationship(String DeclarentName, String DeclarentRelationship, String DeclarantSelectType, String HarmfulInfo,
			String DecIAGREE) {
		typeText(driver, test, OCR_DeclarationSectionPage_Name, "Add Declarent Name :  ", DeclarentName);
		selectByVisibleText(driver, test, OCR_DeclarationSectionPage_Position, "Select a Relationship : ", DeclarentRelationship);
		if (DeclarantSelectType.contains("check")) {
			clickElement(driver, test, OCR_DeclarationSectionPage_UserCheckBox, "click on checkbox");
			typeText(driver, test, OCR_DeclarationSectionPage_HarmfulInfoText, "Add Harmful Info : ", HarmfulInfo);
		}
			typeText(driver, test, OCR_DeclarationSectionPage_IAgree, "Type Text : ", DecIAGREE);
			clickElement(driver, test, OCR_DeclarationSectionPage_SaveBtn, "click on save button");
	}

	// validations in Declaration Tab
	public void validateDeclarationError() {
		try {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_DeclarationSectionPage_SaveBtn, "click on save button");
			Wait.waitfor(3);
			if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {
				if (isDisplayed(driver, "//li[text()='Declarant Name is required.']")) {
					test.log(LogStatus.INFO, "Declarant Name is required");
				}
				if (isDisplayed(driver, "//li[text()='Please type I AGREE in the textbox.']")) {
					test.log(LogStatus.INFO, "Please type I AGREE in the textbox");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Errors is not Displayed by clicking on SAVE button for status: Approved");
		}
	}
}
