package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class AddfreightForwarderPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_FFcodeinput = "//input[@type='text'][@id='editFreightForwarder_freightForwarder_ffCode']";
	public static final String OCR_FFname = "//input[@type='text'][@id='editFreightForwarder_freightForwarder_ffName']";
	public static final String OCR_FFLanguageSelect = "//select[@id='editFreightForwarder_freightForwarder_sourceLanguage']";
	public static final String OCR_FFSave = "//button[@name='okx']";
	public static final String OCR_ClickFFADDbtn = "(//button[@type='button'])[3]";

	/* ******************** Constructor ***************************** */

	public AddfreightForwarderPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */
	public void addFF(String FFName, String FFcodeinput) {

		clickElement(driver, test, OCR_ClickFFADDbtn, "click on add freight forwarder button");
		Wait.waitfor(3);
		typeText(driver, test, OCR_FFname, "enter freight forwarder name", FFName);
		typeText(driver, test, OCR_FFcodeinput, "enter freight forwarder Code", FFcodeinput);

	}

	public void addFFsave() {
		clickElement(driver, test, OCR_FFSave, "click on save button");
	}

}
