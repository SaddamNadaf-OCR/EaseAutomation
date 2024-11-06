package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ResultPackingListPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	
	public static final String OCR_ResultPackingList_Title = "//h3[contains(text(),'Result Packing List')]";
	public static final String OCR_ResultPackingList_NewSearchBtn = "//button[contains(text(),'New Search')]";
	public static final String OCR_ResultPackingList_CopyIcon = "(//i[@class='fa fa-copy'])[1]";
	/* ******************************* Constructor ****************************** */

	public ResultPackingListPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// click on packing List no
	public void click_PLNo(String ResultPLNo) {
		isDisplayed(driver, "//a[contains(text(),'"+ ResultPLNo +"')]");
		test.log(LogStatus.PASS, "Packing List is created successfully !!");
		Wait.waitfor(2);
		clickElement(driver, test, "//a[contains(text(),'"+ ResultPLNo + "')]", "Clicking on Packing list :");
	}

	// Result Packing List is displayed
	public void packingListResult() {
		isDisplayed(driver, OCR_ResultPackingList_Title);
		test.log(LogStatus.PASS, "Result Packing List is Displayed");
	}
	
	//result packing list New Search button
	public void newSearch() {
		clickElement(driver, test, OCR_ResultPackingList_NewSearchBtn, "Click on New Search Button");
	}
	
	public void clickPackingList(String packingList) {
		Wait.waitfor(2);
		clickElement(driver, test, "//a[contains(text(),'"+ packingList +"')]", packingList);
	}

	public void copyPL() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_ResultPackingList_CopyIcon, "Click on Copy icon : ");
	}

}
