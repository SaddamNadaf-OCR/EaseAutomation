package dmsClasses;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ResultDocumentTypeControlAttributesPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_Button_NewSearch = "//button[@name='User Profile']";
	public static final String OCR_HomePage_ModuleSelection = "(//a[@class='dropdown-toggle'])[2]";
	public static final String OCR_HomePage_ModuleExport = "(//a[contains(text(),'Export Operations')])[2]";

	/* ******************************* Constructor ****************************** */

	public ResultDocumentTypeControlAttributesPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	public void returntosearchpage() {
		clickElement(driver, test, OCR_Button_NewSearch, "Return to searchpage");
	}

	public void validate_searchresult() {
		try {
			if (isDisplayed(driver,
					"//div[@class='col-xs-12 ']//label[contains(text(),'Total Number of Records Found:"))
				;
			test.log(LogStatus.PASS, "Record is present");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "No Records Found");
		}
	}

	public void inactivecontrolattrib() {
		clickElement(driver, test, "//tbody/tr[@id='1']/td[10]/a[1]/i[1] ", "Click on Active icon");
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

}
