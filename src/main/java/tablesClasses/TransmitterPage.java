package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class TransmitterPage  extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

//---------------------------------Locators---------------------------------------------

	public static final String OCRAddAgencybtn = "//button[@name='Add']";
	public static final String OCRAesTransmitterId="//input[@id='editAesTransmitter_aesTransmitter_transmitterId']";
	public static final String OCRpassword="//input[@id='editAesTransmitter_aesTransmitter_commPassword']";
	public static final String OCRsavebtn="//button[@name='save']";
	
	// --------------------Constructor------------------------------------
	

	public TransmitterPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

	}
	// .....................addParameter...............................//
	
	public void addbutton() {
		clickElement(driver, test, OCRAddAgencybtn, "clicking on Add button :");
	}
	public void savebtn() {
		clickElement(driver, test, OCRsavebtn, "clicking on save button :");
	}
		public void addbyParameters(String Password) {

			typeText(driver, test, OCRAesTransmitterId, "Entering hazmat ID:", randomnumbers());
			Wait.waitfor(2);	
			typeText(driver, test, OCRpassword, "Entering country :", Password);
			Wait.waitfor(2);
			
		}
		}