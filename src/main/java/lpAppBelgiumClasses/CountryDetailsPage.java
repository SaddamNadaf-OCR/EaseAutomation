package lpAppBelgiumClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilities.GenericMethods;
import utilities.Wait;

public class CountryDetailsPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	
	public static final String OCR_CountryDetils_AddcountryBtn = "//button[@id='countryBtn']";
	public static final String OCR_CountryDetils_Country = "//select[@id='createNewCountryPopup_totalCountries']";
	public static final String OCR_CountryDetils_CountryType = "//select[@id='createNewCountryPopup_authorisationCountryValue_countryType']";
	public static final String OCR_CountryDetils_CNCSaveAndReturn = "//button[@name='saveAndReturn']";
	public static final String OCR_CountryDetils_CountryCancel = "//div[@class='ocr-modal-cont']//button[@id='cancelPopup']";
	public static final String OCR_CountryDetils_PopUpclose = "//button[@class='close']";

	/* ******************************* Constructor ****************************** */

	public CountryDetailsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Add country details
	public void addCountry(String Country,String CountryType) {
		clickElement(driver, test, OCR_CountryDetils_AddcountryBtn, "click on Add Country button");
		Wait.waitfor(4);
		try {
			selectByVisibleText(driver, test, OCR_CountryDetils_CountryType, "Select Country type : ", CountryType);
			Wait.waitfor(4);
			selectByVisibleText(driver, test, OCR_CountryDetils_Country, "Select Country : ", Country);			
			clickElement(driver, test, "//button[@name='move-right']", "Click on move Right");			
			Wait.waitfor(3);
			clickElement(driver, test, OCR_CountryDetils_CNCSaveAndReturn, "click on Create new country Save and return");
			Wait.waitfor(4);			
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_CountryDetils_PopUpclose , "click on country Cancel button");
		}
	}

	//validating the Add country is Added or not in grid table
	public void validate_addCountry(String Country) {
		try {
			Wait.waitfor(4);
			String countryTable = "//table[@id='countryTable']//tr/td[contains(text(),'"+Country.trim()+"')]";
			Wait.fluwait(driver, countryTable);
			isDisplayed(driver, countryTable);
			test.log(LogStatus.PASS, "Add country is Added in result grid table : "+Country);			
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to Add country in result grid table: "+Country);
		}
	}

	//validate add country details Errors
	public void validateCountryDetails() {
		clickElement(driver, test, OCR_CountryDetils_AddcountryBtn, "click on Country Details button");
		clickElement(driver, test, OCR_CountryDetils_CNCSaveAndReturn, "click on Create new country Save");
		try {
			if (isDisplayed(driver,"(//h4[contains(text(),'Error')])[2]")) {				

				if (isDisplayed(driver,"//li[text()='Error!  Please select at least one country']")) {
					test.log(LogStatus.INFO, "Error!  Please select at least one country");
				}				
				Wait.waitfor(3);
				clickElement(driver, test, OCR_CountryDetils_CountryCancel, "click on country Cancel button");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);			
			test.log(LogStatus.FAIL, "Error Vaildation is not Displayed by clicking on SAVE button in Country Details");
			clickElement(driver, test, OCR_CountryDetils_CountryCancel, "click on country Cancel button");
		}
	}

	//validate add country details Errors
	public void validateCountryDetlsofSameCountryType() {
		try {
			if (isDisplayed(driver,"//div[@class='row ocr-error']//h4[contains(text(),'Error')]")) {				

				if (isDisplayed(driver,"//li[contains(text(),'Please enter one Country for each Country Type.')]")) {
					test.log(LogStatus.INFO, "Please enter one Country for each Country Type.");
				}
				
				Wait.waitfor(3);
				clickElement(driver, test, OCR_CountryDetils_CountryCancel, "click on country Cancel button");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);			
			test.log(LogStatus.FAIL, "Error Vaildation is not Displayed by clicking on SAVE button in Country Details already Added");
			clickElement(driver, test, OCR_CountryDetils_CountryCancel, "click on country Cancel button");
		}
	}
	
}
