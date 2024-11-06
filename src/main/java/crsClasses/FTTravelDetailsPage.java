package crsClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilities.GenericMethods;
import utilities.Wait;

public class FTTravelDetailsPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String FT_BuisnessUnit = "//select[@id='editForeignTravelGeneralInfo_sbuCode']";
	public static final String FT_TravelDateFrom = "//input[@id='editForeignTravelGeneralInfo_travelDateFrom']";
	public static final String FT_TravelDateTo = "//input[@id='editForeignTravelGeneralInfo_travelDateTo']";
	public static final String FT_TravelerName = "//input[@id='editForeignTravelGeneralInfo_foreignTravelGeneralInfoValue_requesterName']";
	public static final String FT_CountryOfCitizenship = "//input[@id='editForeignTravelGeneralInfo_foreignTravelGeneralInfoValue_countryOfCitizenship']";
	public static final String FT_PrimaryPurpose = "//input[@id='editForeignTravelGeneralInfo_marketing-1']";
	public static final String FT_Button_Save = "//button[contains(text(),'Save')]";
	public static final String FTDate_Today = "//button[contains(text(),'Today')]";
	public static final String FT_TravelerEmail = "//input[@id='editForeignTravelGeneralInfo_foreignTravelGeneralInfoValue_requesterEmail']";
	public static final String FT_Button_ForwardNavigation = "//i[@class='fa fa-angle-right']";
	public static final String FT_Button_TravelInfo = "//a[contains(text(),'Travel Info')]";
	public static final String FT_Button_GeneralDesc = "//span[contains(text(),'General Descriptions')]";
	public static final String FTReq_RequestID = "//span[@class='status']/label/b/font";
	public static final String FT_TravelerNameLink = "//a[contains(text(),' Name')]";
	public static final String FT_UserFirstName = "//input[@id='searchForm_userProfile_userFirstname']";
	public static final String FT_Search_Button = "//Button[@name='Search']";
	public static final String FT_Select_Button = "//Button[@name='Ok']";
	public static final String FT_Close_Popup_Button = "(//Button[@class='btn-close'])[3]";
	public static final String FT_ManagerNameLink = "(//a[contains(text(),'Name')])[2]";
	public static final String FT_TravelDeskContactNameLink = "(//a[contains(text(),'Name')])[3]";
	public static final String FT_ChangeNumber = "//input[@id='editForeignTravelGeneralInfo_foreignTravelGeneralInfoValue_chargeNumber']";
	public static final String FT_Template_Name = "//input[@name='foreignTravelId']";
	
	/* ******************** Constructor ***************************** */

	public FTTravelDetailsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	// Add the required template Name
	public void add_template(String templateName) {
		typeText(driver, test, FT_Template_Name, "Adding Template Name :", templateName+randomnumbersbetween1_100());
	}

	// Select SBU
	public void select_BuisnessUnit(String BuisnessUnit) {
		selectByVisibleText(driver, test, FT_BuisnessUnit, "Selecting Buisness Unit: ", BuisnessUnit);
	}

	// Enter TravelDateFrom
	public void enter_TravelDateFrom(String TravelDateFrom) {
		clickElement(driver, test, FT_TravelDateFrom, "Clicking on Required By Date");
		if (TravelDateFrom.contains("Today")) {
			clickElement(driver, test, FTDate_Today, "Clicking on Today: ");
		} else {
			date(driver, test, "Selecting the Travel Date From : ", TravelDateFrom);
		}
	}

	// Enter TravelDateTo
	public void enter_TravelDateTo(String TravelDateTo) {
		clickElement(driver, test, FT_TravelDateTo, "Clicking on Required By Date");
		if (TravelDateTo.contains("Today")) {
			clickElement(driver, test, FTDate_Today, "Clicking on Today: ");
		} else {
			date(driver, test, "Selecting the Travel Date To : ", TravelDateTo);
		}
	}

	// Enter Traveler Name
	public void enter_TravelerName(String TravelerName) {
		typeText(driver, test, FT_TravelerName, "Enter Traveler Name : ", TravelerName);
	}

	// Enter Traveler Email
	public void enter_TravelerEmail(String TravelerEmail) {
		typeText(driver, test, FT_TravelerEmail, "Enter Traveler Email : ", TravelerEmail);
	}

	// Enter Country Of Citizenship
	public void enter_COC(String CountryOfCitizenship) {
		typeText(driver, test, FT_CountryOfCitizenship, "Enter Country Of Citizenship : ", CountryOfCitizenship);
	}

	// Select Primary Purpose
	public void select_primarypurpose() {
		scrollToElement(driver, FT_PrimaryPurpose);
		Wait.waitfor(2);
		clickElement(driver, test, FT_PrimaryPurpose, "Clicking on Marketing Primary Purpose");
	}

	// Click on Save Button
	public void save() {
		scrollToElement(driver, FT_Button_Save);
		scrollToTop(driver);
		Wait.waitfor(3);
		clickElement(driver, test, FT_Button_Save, "Clicking on Save Button");
	}

	// Click on Forward Button
	public void moveForward() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(FT_Button_ForwardNavigation)));
	}
	
	// Click on Submit Request Tab
	public void submitRequest() {
		clickElement(driver, test, "//a[contains(text(),'Submit Request')]", "Clicking on Submit Request Tab: ");
	}

	// Click on TravelInfo tab
	public void movetotravelinfo() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(FT_Button_TravelInfo)));
	}

	// Click on AdditionalInfo tab
	public void movetoadditionalinfo() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();",
				driver.findElement(By.xpath("//a[contains(text(),'Additional Info')]")));
	}

	public void movetogeneraldesc() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(FT_Button_GeneralDesc)));
	}

	// Click on Submit Request tab
	public void movetosubmitreq() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();",
				driver.findElement(By.xpath("//a[contains(text(),'Submit Request')]")));
	}

	// Validate General Info Tab
	public void validate_FTRGeneralInfoError() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {

				if (isDisplayed(driver, "//li[contains(text(),'Business Unit is required.')]")) {
					test.log(LogStatus.INFO, "Business Unit is required.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Travel Date From is required.')]")) {
					test.log(LogStatus.INFO, "Travel Date From is required.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Travel Date To is required.')]")) {
					test.log(LogStatus.INFO, "Travel Date To is required.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Traveler Name is required.')]")) {
					test.log(LogStatus.INFO, "Traveler Name is required.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Country of Citizenship is required.')]")) {
					test.log(LogStatus.INFO, "Country of Citizenship is required.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Please select atleast one Primary Purpose')]")) {
					test.log(LogStatus.INFO, "Please select atleast one Primary Purpose");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error Validation is not Displayed by clicking on SAVE button in Foreign Travel General Info Page");
		}
	}

	// Getting the Request ID
	public String get_RequestID() {
		return getText(driver, test, FTReq_RequestID, "Get the Actual text of Request ID : ");
	}

}
