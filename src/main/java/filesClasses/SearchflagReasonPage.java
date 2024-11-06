package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchflagReasonPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;
	
	/* ******************************** LOCATORS ******************************** */
	
	public static final String OCR_Homepage_module = "//ul[@class='nav navbar-nav']/li[2]/a";
	public static final String OCRSBU_Code="//select[@name='flagReason.sbuCode']";
	public static final String OCR_ReasonCode="//input[@id='resultFlagReason_flagReason_reasonCode']";
	public static final String OCR_FlagIcon="(//button[@type='button'])[4]";
	public static final String OCR_FlagColor="(//button[@type='button'])[5]";
	public static final String OCR_FlagDescription="//textarea[@id='resultFlagReason_flagReason_desc']";
	public static final String OCR_BtnSave="//button[@name='save']";
	public static final String OCR_searchbtn="(//button[@name='Search'])";
	public static final String OCR_flgicon="(//a[@class='optionLabel dropdown-item'])[2]";
	public static final String OCR_flgcolor="(//a[contains(text(),'Yellow')])[1]";
	/*
	 * ****************************** Constructor *********************************
	 */
	public SearchflagReasonPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

	}
	/* ******************************* Actions ********************************* */
public void SearchFlagReasn(String SBUCode, String ReasonCode, String FlagIcon, String FlagColor, 
		String FlagDescription) {
	
		selectByVisibleText(driver, test, OCRSBU_Code, "Select SBU Code", SBUCode);
		Wait.waitfor(2);
		typeText(driver, test, OCR_ReasonCode, "Enter reason code", ReasonCode);
		Wait.waitfor(2);
		clickElement(driver, test, OCR_FlagIcon, "click on  flag icon");
		clickElement(driver, test, "(//a[contains(text(),'"+FlagIcon+"')])[2]", "select the flag icon : "+FlagIcon);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_FlagColor, "click on  flag color");
		clickElement(driver, test, "//a[contains(text(),'"+FlagColor+"')]", "select the flag color : "+FlagColor);
		Wait.waitfor(2);
		typeText(driver, test, OCR_FlagDescription, "Enter description", FlagDescription);
		
	}
	public void clickonSearch(){
		clickElement(driver, test, OCR_searchbtn, "click on search");
	}
	
	
	
	
	
}