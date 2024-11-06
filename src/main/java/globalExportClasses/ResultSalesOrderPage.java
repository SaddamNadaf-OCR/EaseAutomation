package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ResultSalesOrderPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_ResultSalesOrderPage_SalesOrderNo = "//a[@class='ead-invoice-tooltip']";
	public static final String OCR_ResultSales_Title = "//h3[contains(text(),'Result Sales Order')]";

	/* ******************************* Constructor ****************************** */

	public ResultSalesOrderPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// click on Sales order no
	public void click_SalesOrderNo(String ResultSONo) {
		isDisplayed(driver, "//a[contains(text(),'" + ResultSONo + "')]");
		test.log(LogStatus.PASS, "Sales Order is created successfully !!");
	}

	// Result Sales is displayed
	public void salesResult() {
		isDisplayed(driver, OCR_ResultSales_Title);
		test.log(LogStatus.PASS, "Result Sales Order is Displayed");
	}

}
