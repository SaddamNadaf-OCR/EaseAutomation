package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class CreatePaymentPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
	//-------------------------------------Locators----------------------------------//
	
	public static final String Create_PaymentID = "//input[@name='payment.paymentId']";
	public static final String Create_PaymentDesc = "//textarea[@name='payment.paymentDesc']";
	public static final String OCR_Save = "//button[@name='save.x']";
	public static final String OCR_SaveandReturn = "//button[@name='ok.x']";
	
	// -----------------------------Constructor---------------------------------------------//

	public CreatePaymentPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	// -----------------------------Code-------------------------------------------//

	public void enterPaymentID(String PaymentID, String PaymentDesc) {

		typeText(driver, test, Create_PaymentID, "Enter Code :", PaymentID);
		typeText(driver, test, Create_PaymentDesc, "Enter Name :", PaymentDesc);
		
				

	}

	// -------------------------------Save-------------------------------------------------//
	public void save() {
		scrollToElement(driver, OCR_Save);
		Wait.waitfor(3);
		scrollToTop(driver);
		clickElement(driver, test, OCR_Save, "Click on Save Button ");
	}

	// --------------------------------Save&Return-------------------------------------------//
	public void saveandReturn() {
		scrollToElement(driver, OCR_SaveandReturn);
		Wait.waitfor(3);
		scrollToTop(driver);
		clickElement(driver, test, OCR_SaveandReturn, "Click on Save Button ");
	}



}
