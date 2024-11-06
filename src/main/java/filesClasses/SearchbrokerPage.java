package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchbrokerPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_Homepage_module = "//ul[@class='nav navbar-nav']/li[2]/a";
	public static final String OCRSBU_Code = "//select[@id='searchBroker_broker_sbuCode']";
	public static final String OCR_searchbtn="//button[contains(text(),'Search')]";
	public static final String OCR_BrokerCode="//input[@id='searchBroker_broker_brokerId']";
	public static final String OCR_BrokerName="//input[@id='searchBroker_broker_brokerName']";
	
	/*******************************Constructor**********************************/

	public SearchbrokerPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

	}

	/* ******************************* Actions ********************************* */
	public void Searchbroker(String SBUCode, String BrokerCode, String BrokerName) {

		selectByVisibleText(driver, test, OCRSBU_Code, "Select SBU Code", SBUCode);
		Wait.waitfor(2);
		typeText(driver, test, OCR_BrokerCode, "Enter broker code", BrokerCode);
		Wait.waitfor(2);
		typeText(driver, test, OCR_BrokerName, "Enter broker name", BrokerName);
		Wait.waitfor(2);
	}

	public void clickonSearch() {
		clickElement(driver, test, OCR_searchbtn, "click on search");
	}

}
