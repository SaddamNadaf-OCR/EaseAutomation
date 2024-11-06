package crsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class AgrReqSelectToImportPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_Country_Checkbox="//input[@name='countryItemNo']";
	public static final String OCR_ForeignParties_Checkbox="//input[@name='consigneeItemNo']";
	public static final String OCR_TCN_Checkbox="//input[@name='tcdnItemNo']";
	public static final String OCR_USParties_Checkbox="//input[@name='sourceMfgItemNo']";
	public static final String OCR_Button_SelectAll="//input[@name='selectBox']";
	public static final String OCR_Button_Import="//button[@name='select']";



    public AgrReqSelectToImportPage(WebDriver driver, ExtentTest test) {
	// TODO Auto-generated constructor stub
	this.driver = driver;
	this.test = test;
   }
    
    public void selectall() {
    	clickElement(driver, test, OCR_Button_SelectAll, "Clicking on Select All Button: ");
    }
    
    public void click_import(){
    	clickElement(driver, test, OCR_Button_Import, "Clicking on Import Button: ");
    }
}