package vmsClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class NotificationConfigurationPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/*-------------------------------------------Locators-------------------------------------*/

	public static final String OCR_VMCT_NC_SBUcode = "//select[@id='selSbuCode']";
	public static final String OCR_VMCT_NC_Search = "//input[@id='search']";
	public static final String OCR_VMCT_NC_Edit = "//i[@class='fa fa-edit']";

	/*--------------------------------Constructor------------------------------------------*/

	public NotificationConfigurationPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/*-------------------------------------------Actions-------------------------------------*/

	// Select SBU Code // Clicking on Search // Clicking on Edit 
	public void VmctCofigNotifictn(String SBU) {
		selectByVisibleText(driver, test, OCR_VMCT_NC_SBUcode, "Select SBU CODE : ", SBU);
		clickElement(driver, test, OCR_VMCT_NC_Search, "Clicking on VR Search");
		clickElement(driver, test, OCR_VMCT_NC_Edit, "Clicking on Edit Icon");
	}
}
