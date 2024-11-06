package productClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class AddNewProductImage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_Button_AttachImage = "//button[contains(text(),'Attach Image')]";
	public static final String OCR_Comments = "//textarea[@id='editProductImage_productImageAttach_description']";
	public static final String OCR_UploadImage = "//span[@class='btn fileinput-button']";
	public static final String OCR_Button_Submit = "//button[@id='btn-sbmt']";
	public static final String OCR_Button_Save = "//button[@name='save.x']";
	public static final String OCR_Button_SavendReturn = "//button[@name='Ok']";
	public static final String OCR_Button_Close = "//button[@class='btn-close']";

	/* ******************** Constructor ***************************** */
	public AddNewProductImage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public void attachimage() {
		clickElement(driver, test, OCR_Button_AttachImage, "Clicking on Attach Image");
	}

	public void uploadimage(String UploadfileName, String Comments) {
		try {
			clickElement(driver, test, OCR_UploadImage, "Click on Upload Image Button");
			uploadFile(driver, test, UploadfileName, "upload document");
			Wait.waitfor(5);
			clickElement(driver, test, OCR_Button_Submit, "Clicking on Submit Button");
			Wait.waitfor(5);
			typeText(driver, test, OCR_Comments, "Enter Comments", Comments);
			Wait.waitfor(2);
			clickElement(driver, test, OCR_Button_Save, "Clicking on Save Button");
			Wait.waitfor(2);
			clickElement(driver, test, OCR_Button_SavendReturn, "Clicking on Save and Return Button");
		} catch (Exception e) {
			clickElement(driver, test, OCR_Button_Close, "Unable to upload Image, clicking on close button ");
		}
	}

	public void uploadimage(String UploadfileName) {
		uploadFile(driver, test, UploadfileName, "upload document");

	}

	public void submit() {
		clickElement(driver, test, OCR_Button_Submit, "Clicking on Submit Button");
	}

	public void enter_comments(String Comments) {
		typeText(driver, test, OCR_Comments, "Enter Comments", Comments);
	}

	public void save() {
		clickElement(driver, test, OCR_Button_Save, "Clicking on Save Button");
	}

	public void savendreturn() {
		clickElement(driver, test, OCR_Button_SavendReturn, "Clicking on Save and Return Button");
	}

	public void validate_imageerror() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {

				if (isDisplayed(driver, "//li[contains(text(),'Image Name is required.')]")) {
					test.log(LogStatus.INFO, "Image Name is required.");
				}

			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error Validation is not Displayed by clicking on SAVE button in Image Page");
		}

	}

}
