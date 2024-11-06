package filesClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;
import utilities.Wait;

public class ConsigneeTypesearchPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;
	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_Homepage_module = "//ul[@class='nav navbar-nav']/li[2]/a";
	public static final String OCR_WatchlistScreening_module = "(//a[contains (text(),'Watch List Screening')])[1]";
	public static final String OCR_SearchFiles = "//ul[@class='nav navbar-nav']/li[5]/a";
	public static final String OCR_searchFiles_consingee = "(//a[contains(text(),'Consignee Type')])";
	public static final String OCR_SearchConsignee_SBUCode = "//select[@name='consigneeType.sbuCode']";
	public static final String OCR_ConsigneeID = "//input[@id='resultConsigneeType_consigneeType_consigneeTypeId']";
	public static final String OCR_SearchConsignees_MainSearch = "//button[contains(text(),'Search')]";

	/*
	 * ****************************** Constructor *********************************
	 */
	public ConsigneeTypesearchPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

	}
	/* ******************************* Actions ********************************* */
	// Enter Search Products

	public void SearchConsigneeType(String SBUCode, String ConsigneeID) {

		selectByVisibleText(driver, test, OCR_SearchConsignee_SBUCode, "Select SBU Code", SBUCode);
		Wait.waitfor(3);
		typeText(driver, test, OCR_ConsigneeID, "enter consignee ID", ConsigneeID);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_SearchConsignees_MainSearch, "Click on Search Button");

	}

}
