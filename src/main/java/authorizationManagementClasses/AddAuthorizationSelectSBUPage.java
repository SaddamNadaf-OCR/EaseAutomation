package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;
import utilities.Wait;

public class AddAuthorizationSelectSBUPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Locators........................................//
	public static final String Auth_Mana_Select="//button[@id='mybutton']";
	public static final String Auth_Mana_Cancel="//button[@name='cancel']";
	public static final String Auth_Mana_AuthorizationGrantedByCountry="encryptedCountryName";
	public static final String Auth_Mana_SBUCode="//select[@name='selSbu']";
	public static final String Auth_Mana_AuthorizationType="(//a[contains(text(),'Authorization Type')])[2]";
	public static final String Auth_Mana_authorizationTypePopUp="//textarea[@id='licTypePopupForm_licenseTypes_licenseType']";
	public static final String Auth_Mana_SearchPopup="//button[@name='Search']";
	public static final String Auth_Mana_SelectPopup="//button[@name='Ok']";
	
	//..................................Constructors..................................//
	public AddAuthorizationSelectSBUPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//.............................Select SBU .................................//
	public void selectSBU(String autorizationType) {
		clickElement(driver, test, Auth_Mana_AuthorizationType, "Clicking on Aythorization Type");
		Wait.waitfor(3);
		typeText(driver, test, Auth_Mana_authorizationTypePopUp, "Entering Authorization type", autorizationType);
		Wait.waitfor(3);
		clickElement(driver, test, Auth_Mana_SearchPopup, "Clicking on Search Tab");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, "//td[contains(text(),'"+ autorizationType +"')]", "Selecting Data From table"+autorizationType);
		Wait.waitfor(3);
		clickElement(driver, test, Auth_Mana_SelectPopup, "Clicking on Select Tab");
		Wait.waitfor(3);
		clickElement(driver, test, Auth_Mana_Select, "Clicking on Select Tab");
	}
}
