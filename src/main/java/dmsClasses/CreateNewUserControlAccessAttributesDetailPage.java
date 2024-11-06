package dmsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewUserControlAccessAttributesDetailPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_UserId = "//a[contains(text(),'User ID')]";
	public static final String OCR_UserName = "//input[@id='searchForm_userProfile_username']";
	public static final String OCR_AvailUserContrlAccessAttribDetail = "//select[@id='totalUsrDocAttrDetailsCombo']";
	public static final String OCR_ControlAttributes = "//select[@id='docAttributeCode']";
	public static final String OCR_Button_ForwardAll = "//i[@class='fa fa-angle-double-right']";
	public static final String OCR_Button_BackwardAll = "//i[@class='fa fa-angle-double-left']";
	public static final String OCR_Button_Save = "//input[@name='save']";
	public static final String OCR_Button_SavendReturn = "//input[@name='ok']";
	public static final String OCR_Button_Search = "//button[contains(text(),'Search')]";
	public static final String OCR_Button_Select = "//button[contains(text(),'Select')]";
	public static final String OCR_POPUpClose = "//div[@id='ocrModal']//button[@class='close']";

	/* ******************************* Constructor ****************************** */

	public CreateNewUserControlAccessAttributesDetailPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	public void add_usertcontrlattribdetmapping(String UserId, String ContrAttrib) {
		try {
			if (UserId.length() > 0) {
				clickElement(driver, test, OCR_UserId, "Enter User Id");
				Wait.waitfor(3);
				typeText(driver, test, OCR_UserName, "Enter Username : ", UserId);
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
			selectByVisibleText(driver, test, OCR_ControlAttributes, "Selecting Control Attribute : ", ContrAttrib);
			clickElement(driver, test, OCR_Button_ForwardAll, "Clicking on Forward All Button");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectall() {
		clickElement(driver, test, OCR_Button_ForwardAll, "Click on Forward ALL");
	}

	public void save() {
		clickElement(driver, test, OCR_Button_Save, "Click on Save Button");
	}

	public void savendreturn() {
		clickElement(driver, test, OCR_Button_SavendReturn, "Click on Save and Return Button");
	}
}
