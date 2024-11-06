package vmsClasses;

import java.util.ArrayList;
import java.util.StringTokenizer;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilities.GenericMethods;
import utilities.Wait;

public class NotificationConfigurationEmailPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	// ******************** LOCATORS ********************************

	public static final String OCR_NFE_EmailType = "//select[@id='updateNotificationEmailConfiguration_emailType']";
	public static final String OCR_NFE_AttachFileOFF = "(//div[@class='lcs_switch lcs_off lcs_checkbox_switch'])[2]";
	public static final String OCR_NFE_AttachFileON = "//div[@class='lcs_switch lcs_on lcs_checkbox_switch']";
	public static final String OCR_NFE_Save = "(//button[@name='updateEmailNotiConf'])[1]";
	public static final String OCR_NFE_AttachFile = "//input[@id='disableAttach']/..//div/div";

	/* ******************** Constructor ***************************** */

	public NotificationConfigurationEmailPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	// ******************** Actions *********************************

	// Select the Email Type
	public void selectEmailType(String EmailType) {
		selectByVisibleText(driver, test, OCR_NFE_EmailType, "Select the Email Type : ", EmailType);
		Wait.waitfor(3);
	}

	// validating Disable "Attach File" Capability switch is OFF
	public void DisableAttachFileOFF() {
		try {
			isDisplayed(driver, OCR_NFE_AttachFileOFF);
			test.log(LogStatus.PASS, "Disable Attach File Capability switch is OFF");
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Disable Attach File Capability switch is ON");
		}
	}

	// validating Disable "Attach File" Capability switch is ON
	public void DisableAttachFileON() {
		isDisplayed(driver, OCR_NFE_AttachFileON);
		test.log(LogStatus.PASS, "Disable Attach File Capability switch is ON");
	}
	
	//click on Disable "Attach File"
	public void clickDisableAttachFile() {
		clickElement(driver, test, OCR_NFE_AttachFile, "Click on  Disable Attach File");
	}
	
	//Click on Save button
	public void clickSave() {
		clickElement(driver, test, OCR_NFE_Save, "Click on Save");
	}

}
