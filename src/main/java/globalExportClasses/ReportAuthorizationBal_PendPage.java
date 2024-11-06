package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class ReportAuthorizationBal_PendPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_SEARCH  ="(//button[contains(text(),'Search')])[1]";
	public static final String OCR_RESET  ="(//button[@type='reset'])[1]";
	public static final String OCR_SBUCODE ="(//select[@name='licenseHeader.sbuCode'])[1]";
    public static final String OCR_AuthorizationType = "//textarea[@name='licenseHeader.licenseType']";
    public static final String OCR_AuthorizationNo  ="//input[@name='licenseHeader.licenseNo']";
    public static final String OCR_AuthStatus ="//select[@name='licenseStatus']";
    public static final String OCR_PartNo ="//input[@name='licenseItem.productCd']";
    
  //* ******************************* Constructor ****************************** *//

  		public ReportAuthorizationBal_PendPage(WebDriver driver, ExtentTest test) {
  			this.driver = driver;
  			this.test = test; 
  		}
  		/* ******************************* Action ****************************** */

  		//clicking on Search 
  		public void search () {
  			clickElement(driver, test, OCR_SEARCH, "Click on Search :");
  		}
  		//Click on Reset
  		public void reset () {
  			clickElement(driver, test, OCR_RESET, "Click on Reset :");
  		}
  		//Search by parameter
  		public void parameter (String Sbu, String AuthType, String AuthNO, String AuthStatus, String PartNo) {
  			selectByVisibleText(driver, test, OCR_SBUCODE, "Select Sbu", Sbu);
  			typeText(driver, test, OCR_AuthorizationType, "Enter Auth Type", AuthType);
  			typeText(driver, test, OCR_AuthorizationNo, "Enter Auth NO", AuthNO);
  			selectByVisibleText(driver, test, OCR_AuthStatus, "Auth Status", AuthStatus);
  			typeText(driver, test,OCR_PartNo , "Enter PartNo", PartNo);
  			scrollToElement(driver, OCR_SEARCH);
  		}
}
