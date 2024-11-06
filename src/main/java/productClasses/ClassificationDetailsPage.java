package productClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;
import utilities.Wait;

public class ClassificationDetailsPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_Button_AddEditClassification = "//button[contains(text(),'Add/Edit Classification')]";
	public static final String OCR_Button_GeneralInfo = "//button[@id='genInfo']";
	public static final String OCR_Button_Proceed ="//button[@class='primary-btn']";
	public static final String OCR_RegionalClassification ="//input[@id='regionalClassificationId']";
	public static final String OCR_Button_Forward = "html/body/div[2]/form/div[5]/div/div[4]/div/button[2]";
	public static final String OCR_POPUpClose = "//div[@id='ocrModal']//button[@class='btn-close']";
	public static final String OCR_SelectCountryinClassfctn="//input[@id='addClassTypePopupFormId_countryName']";
				
	/* ******************** Constructor ***************************** */
	public ClassificationDetailsPage(WebDriver driver, ExtentTest test) { 
		this.driver = driver;
		this.test = test;
	}
	
	public void click_addeditclassification(String CountryName ) {
		try {
			clickElement(driver, test, OCR_Button_AddEditClassification,"Click on Add Edit Classification");
			Wait.waitfor(2);
		//	clearText(driver, test, OCR_SelectCountryinClassfctn, "clear text");
			//typeText(driver, test, OCR_SelectCountryinClassfctn, "Enter country name", CountryName);
		//selectByVisibleText(driver, test, locator, logger, SelectList);
			clickElement(driver, test, OCR_Button_Proceed,"Click on Proceed Button");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_POPUpClose, "Click on POP up close Icon");
		}
	}
	
	public void moveforward() {
		clickElement(driver, test, OCR_Button_Forward,"Clicking on Forward Button");
	}
	
	public void movetomanufacturertab() {
		scrollToTop(driver);
		scrollToTop(driver);
		Wait.waitfor(2);
		clickElement(driver, test, "//a[@id='tab3']","Clicking on Manufacturer Tab: ");
		
	}
	
	
}
