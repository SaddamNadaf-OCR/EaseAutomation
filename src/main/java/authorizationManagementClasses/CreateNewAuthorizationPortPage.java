package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Mouse;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class CreateNewAuthorizationPortPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Locators........................................//
	public static final String Auth_Mana_Save="//button[@name='Save.x']";
	public static final String Auth_Mana_SaveandReturn="//button[@name='OK.x']";
	public static final String Auth_Mana_Cancel="//button[@name='cancel.x']";
	public static final String Auth_Mana_Port="(//a[contains(text(),'Port')])[3]";
	public static final String Auth_Mana_portId="//input[@name='ports.portId']";
	public static final String Auth_Mana_SearchPopup="//button[@name='Search']";
	public static final String Auth_Mana_SelectPopup="//button[@name='Ok']";
	public static final String Auth_Mana_ClosePopup="//button[@class='btn-close']";
	public static final String Auth_Mana_PortTextBox="//input[@name='licensePort.licPortName']";
	public static final String Auth_Mana_portType="//select[@name='portType']";
	
	//..................................Constructors..................................//
	public CreateNewAuthorizationPortPage(WebDriver driver,ExtentTest test) {
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
	
	//.........................Click on Port ................................//
	public void port(String Port, String PortType) {
		if(Port.length() > 0) {
			clickElement(driver, test, Auth_Mana_Port, "Clicking on Port :");
			try {
				typeText(driver, test, Auth_Mana_portId, "Entering Port ID :", Port);
				clickElement(driver, test, Auth_Mana_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Port+"')]", "Selecting Port :");
				clickElement(driver, test, Auth_Mana_SelectPopup, "Clicking on Select Button :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, Auth_Mana_ClosePopup, "Clicking on Close PopUp :");
			}
		}else {
			typeText(driver, test, Auth_Mana_PortTextBox, "Entering Port In Textbox :", Port);
		}
		selectByVisibleText(driver, test, Auth_Mana_portType, "Selecting Port type :", PortType);
	}
}
