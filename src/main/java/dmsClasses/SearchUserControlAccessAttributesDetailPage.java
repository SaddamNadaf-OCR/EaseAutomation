package dmsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchUserControlAccessAttributesDetailPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_UserId = "//a[contains(text(),'User ID')]";
	public static final String OCR_UserName = "//input[@id='searchForm_userProfile_username']";
	public static final String OCR_ContrAttrib = "//select[@id='doc_attribute_dropdown_id']";
	public static final String OCR_ContrAttribDet = "//select[@id='doc_attribute_dtl_dropdown_id']";
	public static final String OCR_SortBy = "//select[@name='sortBy']";
	public static final String OCR_Direction = "//select[@name='direction']";
	public static final String OCR_User = "//input[@id='searchForm_userProfile_username']";
	public static final String OCR_Button_Search = "//button[contains(text(),'Search')]";
	public static final String OCR_Button_Select = "//button[contains(text(),'Select')]";
	public static final String OCR_Button_AddUserCtrlAccAttrib = "//button[contains(text(),'Add User Control Access Attributes Detail')]";
	public static final String OCR_POPUpClose = "//div[@id='ocrModal']//button[@class='close']";

	/* ******************************* Constructor ****************************** */

	public SearchUserControlAccessAttributesDetailPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	public void search_userctrlacessattribdetails(String UserId, String ContrAttrib, String ContrAttribDet,
			String SortBy, String Direction) {

		if (UserId.length() > 0) {
			clickElement(driver, test, OCR_UserId, "click on User Id");
			Wait.waitfor(3);
			typeText(driver, test, OCR_UserName, "Enter Username: ", UserId);
			clickElement(driver, test, "//button[@name='Search']", "Click on search button");
			Wait.waitfor(3);
			String addUserName = "//table[@id='gridPopup']/tbody/tr[2]/td[contains(text(),'" + UserId + "')]";
			try {
				if (isDisplayed(driver, addUserName)) {
					clickElement(driver, test, addUserName, "Click on search record");
					test.log(LogStatus.PASS, "Add Product Line in add to result grid table : " + UserId);
					Wait.waitfor(2);
					clickElement(driver, test, OCR_Button_Select, "Click on Select Button");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Add Product Line in result grid table : " + UserId);
				clickElement(driver, test, OCR_POPUpClose, "Click on POP up close Icon");
			}
		}
		selectByVisibleText(driver, test, OCR_ContrAttrib, "Selecting Control Attribute: ", ContrAttrib);
		selectByVisibleText(driver, test, OCR_ContrAttribDet, "Selecting Control Attribute Details: ", ContrAttribDet);
		selectByVisibleText(driver, test, OCR_SortBy, "Select SortBy: ", SortBy);
		selectByVisibleText(driver, test, OCR_Direction, "Select Direction: ", Direction);

	}

	public void search() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Button_Search, "Clicking on Search Button");

	}

	public void add_doctypcontrolattrib() {
		clickElement(driver, test, OCR_Button_AddUserCtrlAccAttrib,
				"Clicking on Add Document type Control Attributes Button");
	}
}
