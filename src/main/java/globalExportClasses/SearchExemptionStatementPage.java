package globalExportClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.handler.ClickElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchExemptionStatementPage extends GenericMethods{


	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_SearchExemptionStatementPage_AddNewExemption = "//button[@name='Add']";
	public static final String OCR_SearchExemptionStatementPage_ResetBtn = "//button[contains(text(),'Reset')]";
	public static final String OCR_SearchExemptionStatementPage_SearchBtn = "//button[@id='aes-submit']";
	public static final String OCR_SearchExemptionStatementPage_Country = "//input[@id='resultAesExemptionStatement_countryName']";
	public static final String OCR_SearchExemptionStatementPage_ExemptionCode = "//input[@id='resultAesExemptionStatement_aesExemptionStatement_shortDesc']";
	public static final String OCR_SearchExemptionStatementPage_ExemptionDescription = "//textarea[@id='resultAesExemptionStatement_aesExemptionStatement_longDesc']";
	public static final String OCR_SearchExemptionStatementPage_CreatedOnFromDate = "//input[@id='resultAesExemptionStatement_fromCreatedDate']";
	public static final String OCR_SearchExemptionStatementPage_CreatedOnToDate = "//input[@id='resultAesExemptionStatement_toCreatedDate']";
	public static final String OCR_SearchExemptionStatementPage_TodayDate = "//button[contains(text(),'Today')]";
	public static final String OCR_SearchExemptionStatementPage_Status = "//select[@name='aesExemptionStatement.status']";
	public static final String OCR_SearchExemptionStatementPage_SortBy = "//select[@name='sortBy']";
	
	

	/* ******************************* Constructor ****************************** */

	public SearchExemptionStatementPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	
	public void searchByParameters(String country, String ExemptionCode, String ExemptionDesc, String CreatedFrom, String CreatedTo, String Status) {
		Wait.waitfor(2);
		if(country.length() > 0) {
			Wait.waitfor(2);
		typeText(driver, test, OCR_SearchExemptionStatementPage_Country, "Enter Country", country);
		}
		if(ExemptionCode.length() > 0) {
			Wait.waitfor(2);
			typeText(driver, test, OCR_SearchExemptionStatementPage_ExemptionCode, "Enter Exemption Code : ", ExemptionCode);
		}
		if(ExemptionDesc.length() > 0) {
			Wait.waitfor(2);
			typeText(driver, test, OCR_SearchExemptionStatementPage_ExemptionDescription, "Enter Exemption Description : ", ExemptionDesc);
		}
		
		if (CreatedFrom.length() > 0) {
		clickElement(driver, test, OCR_SearchExemptionStatementPage_CreatedOnFromDate,
				"Clicking on Created On From Date :");
		try {
			if (CreatedFrom.equalsIgnoreCase("Today")) {
				clickElement(driver, test, OCR_SearchExemptionStatementPage_TodayDate, "Clicking on Today :");
			} else {
				date(driver, test, "Selecting the From Date :", CreatedFrom);
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Unable to Select the Date :");
		}
	}
		
		if (CreatedTo.length() > 0) {
			clickElement(driver, test, OCR_SearchExemptionStatementPage_CreatedOnToDate,
					"Clicking on Created On To Date :");
			try {
				if (CreatedTo.equalsIgnoreCase("Today")) {
					clickElement(driver, test, OCR_SearchExemptionStatementPage_TodayDate, "Clicking on Today :");
				} else {
					date(driver, test, "Selecting the To Date :", CreatedTo);
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Unable to Select the Date :");
			}
		}
		
		if(Status.length() > 0) {
			Wait.waitfor(2);
			selectByVisibleText(driver, test, OCR_SearchExemptionStatementPage_Status, "Select Status : ", Status);
		}
	}
	
	public void click_Search() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_SearchExemptionStatementPage_SearchBtn, "Click on Search button : ");
	}
	
	public void click_ResetBtn() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_SearchExemptionStatementPage_ResetBtn, "CLick on Reset button : ");
	
	}
	
	public void click_AddNewExemption() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_SearchExemptionStatementPage_AddNewExemption, "Click on Add New Exemption button : ");
	}
	
	
	public void enter_ExemptDescription(String ExemptDescription) {
		Wait.waitfor(2);
	//	scrollToElement(driver, OCR_SearchExemptionStatementPage_ExemptionDescription);
		typeText(driver, test, OCR_SearchExemptionStatementPage_ExemptionDescription, "Enter Exemption Description : ", ExemptDescription);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
