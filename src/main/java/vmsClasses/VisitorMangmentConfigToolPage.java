package vmsClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class VisitorMangmentConfigToolPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_VMCT_VisitorRequest = "//input[@id='visitorRequestBtn']";
	public static final String OCR_VMCT_OtherSetting = "//button[@id='otherSettingBtn']";
	public static final String OCR_VMCT_PolicyDoc = "//button[@id='policyDocBtn']";
	public static final String OCR_VMCT_KioskSettings = "//input[@id='kioskSettingsBtn']";
	public static final String OCR_VMCT_WorkFlowConfig = "//button[@id='wrkflowConfigBtn']";
	public static final String OCR_VMCT_CheckListConfig = "//button[contains(text(),'Checklist Config')]";
	public static final String OCR_VMCT_Notification = "//button[@id='notificationBtn']";

	/* ******************** Constructor ***************************** */

	public VisitorMangmentConfigToolPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Clicking on Visitor Request
	public void click_VisitorRequest(){		
		clickElement(driver, test, OCR_VMCT_VisitorRequest, "Clicking on Visitor Request");			
	}
	
	//Click on WorkFlow Configuration
	public void click_WorkFlowConfig(){		
		clickElement(driver, test, OCR_VMCT_WorkFlowConfig, "Clicking on WorkFlow Configuration");			
	}

	// Clicking on Other settings
	public void click_OtherSetting(){		
		clickElement(driver, test, OCR_VMCT_OtherSetting, "Clicking on Other settings");			
	}

	// Clicking on Policy Documents
	public void click_PolicyDoc(){		
		clickElement(driver, test, OCR_VMCT_PolicyDoc, "Clicking on Policy Documents");			
	}

	// Clicking on Kiosk settings under VMCT
	public void click_Kiosksettings(){		
		scrollToElement(driver, OCR_VMCT_VisitorRequest);
		clickElement(driver, test, OCR_VMCT_KioskSettings, "Clicking on Kiosk Settings");
	}
	
	//Click on CheckList Config
	public void clickCheckListConfig() {
		clickElement(driver, test, OCR_VMCT_CheckListConfig, "Click on CheckList Config");
	}
	
	//click on Notification
	public void clickNotification() {
		clickElement(driver, test, OCR_VMCT_Notification, "Click on Notification");
	}

}
