package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewTIBPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	//......................................Locators..........................................//
	public static final String CreateNew_Save="//button[@name='Save.x']";
	public static final String CreateNew_SaveandReturn="//button[@name='Ok']";
	public static final String CreateNew_Cancel="//button[@name='Cancel.x']";
	public static final String CreateNew_TIBNo="//input[@id='editTib_tib_tibNo']";
	public static final String CreateNew_LiqDamage="//input[@name='tibIssueDate']";
	public static final String CreateNew_IssueDate="//input[@id='editTib_tibIssueDate']";
	public static final String CreateNew_ExtensionDate="//input[@id='editTib_tibExtensionDate']";
	public static final String CreateNew_ExpiryDate="//input[@id='editTib_tibCancelDate']";
	public static final String CreateNew_penalityAmount="//input[@id='editTib_penalityAmount']";
	public static final String CreateNew_MitigationAmount="//input[@id='editTib_mitigationAmount']";
	public static final String CreateNew_CancelDetails="//textarea[@id='editTib_tib_tibCancelDetails']";
	public static final String CreateNew_MitigationLetterSentY="//input[@id='editTib_tib_mitigationLetterSentY']";
	public static final String CreateNew_MitigationLetterSentN="//input[@id='editTib_tib_mitigationLetterSentN']";
	public static final String CreateNew_BreachY="//input[@id='editTib_tib_breachY']";
	public static final String CreateNew_BreachN="//input[@id='editTib_tib_breachN']";
	public static final String CreateNew_NotificationTo="//input[@id='editTib_tib_tibNotificationTo']";
	public static final String CreateNew_PaidY="//input[@id='editTib_tib_paidY']";
	public static final String CreateNew_PaidN="//input[@id='editTib_tib_paidN']";
	public static final String CreateNew_ContactName="//input[@id='editTib_tib_tibContactName']";
	public static final String CreateNewContactPhone="//input[@id='editTib_tib_tibContactPhone']";
	
	public CreateNewTIBPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//............................Click on Save Tab ................................//
	public void save() {
		clickElement(driver, test, CreateNew_Save, "Selecting Save Tab");
	}
	
	//...........................Click on Save and Return Tab ......................//
	public void saveAndreturn() {
		clickElement(driver, test, CreateNew_SaveandReturn, "Selecting Save  And Return Tab");
	}
	
	//............................Click on Cancel Tab ...............................//
	public void cancel() {
		clickElement(driver, test, CreateNew_Cancel, "Clicking on Cancel Button");
	}
	
	//.....................Entering All Data into the form ..........................//
	public void newTIB(String tibNumber,String LiqDamage,String issuedate,String extensionDate,String exiryDate,String penalityAmount,
			String mitigationAmount,String cancelDetails,String notificationTo,String contactName,String contactPhone) {
		
		typeText(driver, test, CreateNew_TIBNo, "Entering TIB No :", tibNumber);
		Wait.waitfor(2);
		typeText(driver, test, CreateNew_LiqDamage, "Entering LiqDamage Number :", LiqDamage);
		Wait.waitfor(2);
		if(issuedate.length() > 0) {
			clickElement(driver, test, CreateNew_IssueDate, "Clicking on Issue Date :");
			dateOfMonthName(driver, test, "Selecting Issue Date From PopUp : ", issuedate);
		}
		if(extensionDate.length() > 0) {
			clickElement(driver, test, CreateNew_ExtensionDate, "Clicking on Extension Date :");
			dateOfMonthName(driver, test, "Selecting Issue Date From PopUp : ", extensionDate);
		}
		if(exiryDate.length() > 0) {
			clickElement(driver, test, CreateNew_ExpiryDate, "Clicking on Expiry Date :");
			dateOfMonthName(driver, test, "Selecting Issue Date From PopUp : ", exiryDate);
		}
		typeText(driver, test, CreateNew_penalityAmount, "Entering Penality Amount :", penalityAmount);
		Wait.waitfor(2);
		typeText(driver, test, CreateNew_MitigationAmount, "Entering Mitigation Amount :", mitigationAmount);
		Wait.waitfor(2);
		typeText(driver, test, CreateNew_CancelDetails, "Entering Cancel Details :", cancelDetails);
		Wait.waitfor(2);
		typeText(driver, test, CreateNew_NotificationTo, "Entering Notification To :", notificationTo);
		Wait.waitfor(2);
		typeText(driver, test, CreateNew_ContactName, "Entering Contact Name :", contactName);
		Wait.waitfor(2);
		typeText(driver, test, CreateNewContactPhone, "Entering Contact Phone Number :", contactPhone);
		Wait.waitfor(2);
		isSelected(driver, CreateNew_BreachY);
		isSelected(driver, CreateNew_BreachN);
		isSelected(driver, CreateNew_PaidN);
	}

}
