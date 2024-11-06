package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class AddbrokerPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_Homepage_module = "//ul[@class='nav navbar-nav']/li[2]/a";
	public static final String OCR_Addbrokerbtn = "//button[contains(text(),'Add Broker')]";
	public static final String OCR_BtnSave = "//button[@id='mybutton']";
	public static final String OCR_brokercode="//input[@id='editBroker_broker_brokerId']";
	public static final String OCR_brokername="//input[@id='editBroker_broker_brokerName']";
	/*
	 * ****************************** Constructor *********************************
	 */
	public AddbrokerPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

	}

	/* ******************************* Actions ********************************* */
	public void AddBroker( String Brokercode, String Brokername) {
		
		clickElement(driver, test, OCR_Addbrokerbtn, "Click on add broker button");
		typeText(driver, test, OCR_brokercode, "Enter brokercode  ", Brokercode);
		typeText(driver, test, OCR_brokername, "Enter brokername ", Brokername);
		
		

	}
		
	public void clickonSave() {
		clickElement(driver, test, OCR_BtnSave, "click on save");
	}

}