package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;
import utilities.Wait;

public class AuthorizationHeaderTemplatePage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Locators........................................//
	public static final String Auth_Mana_Select="//button[@id='submitform']";
	public static final String Auth_Mana_New="//button[contains(text(),'New')]";
	public static final String Auth_Mana_Cancel="//button[contains(text(),'Cancel')]";
	public static final String Auth_Mana_SBUCode="//select[@name='selSbu']";
	public static final String Auth_Mana_SelectTemplate="//select[@name='templateId']";
	
	//..................................Constructors..................................//
	public AuthorizationHeaderTemplatePage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//.............................Click on New template ...............................//
	public void newTemplate() {
		clickElement(driver, test, Auth_Mana_New, "Clicking on New Template");
	}
	
	//.............................Click on Cancel ....................................//
	public void cancel() {
		clickElement(driver, test, Auth_Mana_Cancel, "Clicking on Cancel tab");
	}
	
	//............................Click on Select Template Tab ................................//
	public void selecttemplate(String Template) {
		selectByVisibleText(driver, test, Auth_Mana_SelectTemplate, "Selecting template", Template);
		Wait.waitfor(3);
		clickElement(driver, test, Auth_Mana_Select, "Clicking on Select Tab");
	}
}
