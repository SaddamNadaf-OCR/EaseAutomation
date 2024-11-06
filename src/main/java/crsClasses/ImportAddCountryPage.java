package crsClasses;


import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class ImportAddCountryPage extends GenericMethods{
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_ImportInfo_Addcountry = "//select[@id='editExportCountry_exportCountry_countryCode']";
	public static final String OCR_ImportInfo_MoveRightBtn = "//i[@class='fa fa-angle-right']";
	public static final String OCR_ImportInfo_CountryType = "//select[@id='editExportCountry_exportCountry_countryType']";
	public static final String OCR_ImportInfo_AddCountrySaveAndReturnBtn = "//input[@name='OK.x']";
	
	/* ******************** Constructor ***************************** */

	public ImportAddCountryPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Select country and Move to Right and select Country type
	public void selectAddcountry(String AddCountry, String CountryType){
		selectByVisibleText(driver, test, OCR_ImportInfo_Addcountry, "Select the Add Country : ", AddCountry);
		clickElement(driver, test, OCR_ImportInfo_MoveRightBtn, "Click on move Right button");		
		//selectByVisibleText(driver, test, OCR_ImportInfo_CountryType, "Select the Country type : ", CountryType);
		clickElement(driver, test, OCR_ImportInfo_AddCountrySaveAndReturnBtn, "Click on Add Country Save & return button");
	}
	
}
