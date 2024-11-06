package dpssClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class SBUConfigurationPage extends GenericMethods{

	public WebDriver driver;
	public ExtentTest test;
	
	/* ******************************** LOCATORS ******************************** */
	
	public static final String OCR_SBUConfig_ModulesList = "//select[@id='resultSbuConf_sbuConf_modId']";
	public static final String OCR_SBUConfig_Search = "//button[contains(text(),'Search')]";
	
	public static final String OCR_SBUConfig_SYMMETRIC = "//a[contains(text(),'SYMMETRIC')]";
	public static final String OCR_SBUConfig_INCREMENT = "//a[contains(text(),'INCREMENT')]";
	public static final String OCR_SBUConfig_EXTRA_WORD_DEDUCTION = "//a[contains(text(),'EXTRA_WORD_DEDUCTION')]";
	
	public static final String OCR_SBUConfig_BASE_DEDUCTION = "//a[contains(text(),'BASE_DEDUCTION')]";
	public static final String OCR_SBUConfig_WORD_DROP_FACTOR = "//a[contains(text(),'WORD_DROP_FACTOR')]";
	
	
	public static final String OCR_SBUConfig_ParameterValue = "//textarea[@id='editSbuConf_sbuConf_sbuConfValue']";
	public static final String OCR_SBUConfig_Save = "//button[@name='save']";
	public static final String OCR_SBUConfig_SaveAndReturn = "//button[contains(text(),'Save & Return')]";
	
	/* ******************** Constructor ***************************** */
	
	public SBUConfigurationPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	/* ******************** Actions ********************************* */
	
			
	
	// Click on Search
	public void click_Search() throws InterruptedException {
		Wait.waitfor(2);
		clickElement(driver, test,OCR_SBUConfig_Search , "Clicking on Search");
	}
	
	// Click on Save
		public void click_Save() throws InterruptedException {
			Wait.waitfor(2);
			clickElement(driver, test,OCR_SBUConfig_Save , "Clicking on Save");
		}	
		
	// Click on Save And Return
		public void click_SaveAndReturn() throws InterruptedException {
			clickElement(driver, test,OCR_SBUConfig_SaveAndReturn , "Clicking on Save And Return");
			Wait.waitfor(2);
		}			
	
	// Select option from Module
	public void select_Module(String Option ) {
		selectByVisibleText(driver,test,OCR_SBUConfig_ModulesList ,"Select Module :",Option);
	}		
	
	// Click on SYMMETRIC
	public void click_SYMMETRIC() throws InterruptedException {
		Wait.waitfor(2);
		clickElement(driver, test,OCR_SBUConfig_SYMMETRIC , "Clicking on SYMMETRIC link");
	}	
	
	// Click on INCREMENT
		public void click_INCREMENT() throws InterruptedException {
			Wait.waitfor(2);
			clickElement(driver, test,OCR_SBUConfig_INCREMENT , "Clicking on INCREMENT link");
		}	

	// Click on EXTRA WORD DEDUCTION
		public void click_EXTRA_WORD_DEDUCTION() throws InterruptedException {
			Wait.waitfor(2);
			clickElement(driver, test,OCR_SBUConfig_EXTRA_WORD_DEDUCTION , "Clicking on EXTRA_WORD_DEDUCTION link");
		}
		
	// Click on BASE_DEDUCTION
		public void click_BASE_DEDUCTION() throws InterruptedException {
			Wait.waitfor(2);
			clickElement(driver, test,OCR_SBUConfig_BASE_DEDUCTION , "Clicking on BASE_DEDUCTION link");
		}	

	// Click on WORD_DROP_FACTOR
		public void click_WORD_DROP_FACTOR() throws InterruptedException {
			Wait.waitfor(2);
			clickElement(driver, test,OCR_SBUConfig_WORD_DROP_FACTOR, "Clicking on WORD_DROP_FACTOR link");
		}		
		
		
		
	// Enter SBU Value
		public void enter_SBUValue(String Value){
			clearAndSet( driver, test, OCR_SBUConfig_ParameterValue ,"Entering SBU Value :",Value);
		}	
	
	
}
