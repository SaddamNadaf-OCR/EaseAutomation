package crsClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class AgreementSelectSBUPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_SelectSBU="//select[@id='selectSbu_selSbu']";
	public static final String OCR_Button_Select = "//button[contains(text(),'Select')]";
	public static final String OCR_Button_Cancel = "//button[contains(text(),'Cancel')]";

	/* ******************** Constructor ***************************** */
    
	
	public AgreementSelectSBUPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//Select SBU
	public void SelectSBU(String SBU) {	
		if(SBU.length()>0){	
			selectByVisibleText(driver, test, OCR_SelectSBU, "Select SBU : ",  SBU);		
		}
	}
	
    //Click on Select Button
	public void clickSelect() {
		clickElement(driver, test, OCR_Button_Select," Clicking on Select Button");
	}
}
