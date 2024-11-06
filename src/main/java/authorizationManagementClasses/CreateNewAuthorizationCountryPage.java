package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class CreateNewAuthorizationCountryPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Locators........................................//
	public static final String Auth_Mana_Save="//button[@name='Save.x']";
	public static final String Auth_Mana_SaveandReturn="//button[@name='OK.x']";
	public static final String Auth_Mana_Cancel="//button[@name='cancel.x']";
	public static final String Auth_Mana_CountryCode="//input[@name='licenseCountry.countryDescription']";
	public static final String Auth_Mana_countryType="//select[@name='licenseCountry.countryType']";
	public static final String Auth_Mana_modifiedFlag="//select[@name='licenseCountry.modifiedFlag']";
		
	//..................................Constructors..................................//
	public CreateNewAuthorizationCountryPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//........................Click on Save Button ...........................//
	public void save() {
		clickElement(driver, test, Auth_Mana_Save, "Clicking on Save Button :");
	}
	
	//........................Click on Save and Return Button ...........................//
	public void saveandreturn() {
		clickElement(driver, test, Auth_Mana_SaveandReturn, "Clicking on Save and Return Button :");
	}
	
	//........................Click on Cancel Button ...........................//
	public void cancel() {
		clickElement(driver, test, Auth_Mana_Cancel, "Clicking on Cancel Button :");
	}
	
	//........................Create New Authorization Country............................//
	public void newAuthCountry(String CountryCode, String CountryType, String ModifiedFlag) {
		typeText(driver, test, Auth_Mana_CountryCode, "Entering Country Code :", CountryCode);
		selectByVisibleText(driver, test, Auth_Mana_countryType, "Selecting Country type :", CountryType);
		selectByVisibleText(driver, test, Auth_Mana_modifiedFlag, "Selecting Modified Flag :", ModifiedFlag);
	}

}
