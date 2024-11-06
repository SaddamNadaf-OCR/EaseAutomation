package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;
import utilities.Wait;

public class SelectSBUAddActivityPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Locators........................................//
	public static final String Auth_Mana_Select="//button[@name='Search']";
	public static final String Auth_Mana_Cancel="//button[@name='cancel.x']";
	public static final String Auth_Mana_Country="//input[@id='encryptedCountryName']";
	public static final String Auth_Mana_SBU="//select[@id='selSbu']";
	
	//...................................Constructor......................................//
	public SelectSBUAddActivityPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//..........................Click on SUBMIT ..............................//
	public void submit() {
		clickElement(driver, test, Auth_Mana_Select, "Clicking on Submit Button");
	}
	
	//..........................Click on Cancel ..............................//
	public void cancel() {
		clickElement(driver, test, Auth_Mana_Cancel, "Clicking on Cancel Button");
	}
	
	//.........................Click on Submit With Country ......................//
	public void submitwithSBU(String SBU) {
		selectByVisibleText(driver, test, Auth_Mana_SBU, "Selecting Country from DropDown", SBU);
		Wait.waitfor(3);
		clickElement(driver, test, Auth_Mana_Select, "Clicking on Submit Button");
	}

}
