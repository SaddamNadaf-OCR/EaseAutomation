package lpAppBelgiumClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilities.GenericMethods;
import utilities.Wait;

public class ApplicationReferencePage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_ApplicationReference_YourRefID = "//label[contains(text(),'Your Reference')]/../div/input";
	public static final String OCR_ApplicationReference_LicenceRbtn = "//input[@id='isExporterL']";	
	public static final String OCR_ApplicationReference_ReleaseLetterRbtn = "//input[@id='isExporterR']";
	public static final String OCR_ApplicationReference_NewLicenceRbtn = "//input[@id='isAdditionalExporterN']";
	public static final String OCR_ApplicationReference_ExtensionLicenceRbtn = "//input[@id='isAdditionalExporterE']";
	public static final String OCR_ApplicationReference_LicenceNo = "//input[@id='licenceNo']";
	public static final String OCR_ApplicationReference_IndividualLicence = "//input[@id='licTypeI']";
	public static final String OCR_ApplicationReference_GlobalLicence = "//input[@id='licTypeG']";

	/* ******************************* Constructor ****************************** */

	public ApplicationReferencePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	
	//Getting the your reference text
	public String get_yourRefID() {
		return getAttribute(driver, test, OCR_ApplicationReference_YourRefID, "value", "Get the Reference ID : ");		
	}

	//Checking the individual and Global license is selected or not
	public void licenceType(String licenceType) {
		Wait.waitfor(3);
		if(licenceType.equalsIgnoreCase("EXP-DL-IND")) {
			String button = getAttribute(driver, test, OCR_ApplicationReference_IndividualLicence, "checked", "Checking Individual Radio Button");
			if(button.equalsIgnoreCase("true")) {
				test.log(LogStatus.PASS, "Individual Licence is Selected");									
			}else {
				test.log(LogStatus.FAIL, "Individual Licence is not Selected");		
			}
		}else if(licenceType.equalsIgnoreCase("EXP-DL-GL")){
			String button = getAttribute(driver, test, OCR_ApplicationReference_GlobalLicence, "checked", "Checking Global Radio Button");
			if(button.equalsIgnoreCase("true")) {
				test.log(LogStatus.PASS, "Global Licence is Selected");									
			}else {
				test.log(LogStatus.FAIL, "Global Licence is not Selected");		
			}
		}
	}
	
}