package bulkUpdateClassificationClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchImportClassificationPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */ 
	
	
	public static final String OCR_SearchImportClassification_RegulatoryUpdate = "//body/div[@id='content-cont']/form[@id='resultProductMassControl']/div[3]/div[1]/div[2]/div[3]/button[1]";
	public static final String OCR_SearchImportClassification_ImportClassification = "//a[contains(text(),'Import Classification')]";
	public static final String OCR_SearchImportClassification_SBUCode = "//select[@id='resultHtsRegUpdate_product_sbuCode']";
	public static final String OCR_SearchImportClassification_Country = "//select[@id='countryCode']";
	public static final String OCR_SearchImportClassification_CheckboxListInvalidClassification = "//body/div[@id='content-cont']/form[@id='resultHtsRegUpdate']/div[3]/div[1]/div[8]/div[1]/div[1]/label[1]/input[1]";
	public static final String OCR_SearchImportClassification_ChangeEffectiveDate = "//select[@id='effectiveDate']";
	public static final String OCR_SearchImportClassification_ConversionTypeAll = "(//input[@name='conversionType'])[1]";
	public static final String OCR_SearchImportClassification_ConversionTypeDirectConversion = "(//input[@name='conversionType'])[2]";
	public static final String OCR_SearchImportClassification_ConversionTypeSpecialCases = "(//input[@name='conversionType'])[3]";
	public static final String OCR_SearchImportClassification_ConversionTypeUnknown = "(//input[@name='conversionType'])[4]";
	public static final String OCR_SearchImportClassification_ConversionTypeSpecialUnknown = "(//input[@name='conversionType'])[5]";
	public static final String OCR_SearchImportClassification_Status = "//select[@id='resultHtsRegUpdate_product_status']";
	public static final String OCR_SearchImportClassification_SortBy = "//body/div[@id='content-cont']/form[@id='resultHtsRegUpdate']/div[3]/div[1]/div[12]/div[1]/select[1]";
	public static final String OCR_SearchImportClassification_Direction = "//body/div[@id='content-cont']/form[@id='resultHtsRegUpdate']/div[3]/div[1]/div[13]/div[1]/select[1]";
	public static final String OCR_SearchImportClassification_SearchButton = "(//button[contains(text(),'Search')])[1]";
	
	/* ******************** Constructor ***************************** */
	public SearchImportClassificationPage(WebDriver driver, ExtentTest test) {

		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	
	
	public void click_RegulatoryUpdate() throws InterruptedException {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_SearchImportClassification_RegulatoryUpdate, "Click on Regulatory Update Button");
		clickElement(driver, test, OCR_SearchImportClassification_ImportClassification, "Click on Import Classification Button");
		Wait.waitfor(2);
	}
	
	public void searchImportClassificationDetails(String SBUCode, String ImportClassificationCountry, String CheckboxListInvalidClassification, 
			String ChangeEffectiveDate, String ConversionType, String Status, String SortBy, String Direction) throws InterruptedException {
	

		selectByVisibleText(driver, test, OCR_SearchImportClassification_SBUCode, "Select Sbu Code ", SBUCode);
		selectByVisibleText(driver, test, OCR_SearchImportClassification_Country, "Select Import Classification Country ", ImportClassificationCountry);
		
		if(CheckboxListInvalidClassification.equalsIgnoreCase("Yes")) {
			clickElement(driver, test, OCR_SearchImportClassification_CheckboxListInvalidClassification, "Checkbox List with Invalid Classification");
		}
		
		selectByVisibleText(driver, test, OCR_SearchImportClassification_ChangeEffectiveDate, "Select Change Effective Date ", ChangeEffectiveDate);
		
		if(ConversionType.length() > 0) {
			if(ConversionType.equalsIgnoreCase("ALL")){
				clickElement(driver, test, OCR_SearchImportClassification_ConversionTypeAll, "Click Conversion Type All");
			}
			if(ConversionType.equalsIgnoreCase("DirectConversion")){
				clickElement(driver, test, OCR_SearchImportClassification_ConversionTypeDirectConversion, "Click Conversion Type DirectConversion");
			}
			if(ConversionType.equalsIgnoreCase("SpecialCases")){
				clickElement(driver, test, OCR_SearchImportClassification_ConversionTypeSpecialCases, "Click Conversion Type SpecialCases");
			}
			if(ConversionType.equalsIgnoreCase("Unknown")){
				clickElement(driver, test, OCR_SearchImportClassification_ConversionTypeUnknown, "Click Conversion Type Unknown");
			}
			if(ConversionType.equalsIgnoreCase("SpecialUnknown")){
				clickElement(driver, test, OCR_SearchImportClassification_ConversionTypeSpecialUnknown, "Click Conversion Type SpecialUnknown");
			}
		}
		
		selectByVisibleText(driver, test, OCR_SearchImportClassification_Status, "Select Status ", Status);
		selectByVisibleText(driver, test, OCR_SearchImportClassification_SortBy, "Select SortBy ", SortBy);
		selectByVisibleText(driver, test, OCR_SearchImportClassification_Direction, "Select Direction ", Direction);
}
	
	public void click_ImportClassificationSearch() throws InterruptedException {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_SearchImportClassification_SearchButton, "Click on Search Button");
	}
	
}
