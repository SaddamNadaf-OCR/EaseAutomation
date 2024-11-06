package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;
import utilities.Wait;

public class SelectAuthorizationNumberPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//............................Locators...............................//
	public static final String Auth_Mana_CreateAuthReview="//button[contains(text(),'Create Authorization Review')]";
	public static final String Auth_Mana_Cancel="//button[contains(text(),'Cancel')]";
	public static final String Auth_Mana_AuthorizationNo="//a[contains(text(),'Authorization No.')]";
	public static final String Auth_Mana_Search="//button[@id='searchAgreementNoPopUp']";
	public static final String Auth_Mana_Reset="//button[contains(text(),'Reset')]";
	public static final String Auth_Mana_CancelPopUp="(//button[contains(text(),'Cancel')])[2]";
	public static final String Auth_Mana_TransactionId="//input[@name='dosGeneralInfoDTO.transactionId']";
	public static final String Auth_Mana_AuthorizationNoPopup="//input[@name='dosGeneralInfoDTO.licenseNo']";
	public static final String Auth_Mana_Select="//button[contains(text(),'Select')]";
	
	//.............................Constructor.................................//
	public SelectAuthorizationNumberPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//...........................Authorization Number............................//
	public void authorizationNo(String transactionId) {
		if(transactionId.length() > 0) {
			clickElement(driver, test, Auth_Mana_AuthorizationNo, "Clicking on Authorization Number :");
			try {
				Wait.waitfor(3);
				typeText(driver, test, Auth_Mana_TransactionId, "Entering Transaction Id :", transactionId);
				Wait.waitfor(3);
				clickElement(driver, test, Auth_Mana_Search, "Clicking on Search Tab :");
				Wait.waitfor(6);
				clickElement(driver, test, "//td[contains(text(),'"+transactionId+"')]", "Selecting Transaction ID :");
				Wait.waitfor(3);
				clickElement(driver, test, Auth_Mana_Select, "Clicking on Select Tab :");
				Wait.waitfor(3);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}clickElement(driver, test, Auth_Mana_CreateAuthReview, "Clicking on Create Authorization Review :");
	}
}
