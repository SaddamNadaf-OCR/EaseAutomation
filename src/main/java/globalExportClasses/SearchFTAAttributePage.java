package globalExportClasses;
/* 
 * Module : Export Operation
 * Author  : Saddam
 * created date : May 2024
 * Descriptions : Search FTA Attribute Page
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil 
 */
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class SearchFTAAttributePage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_FTASearchPage_Search = "//button[contains(text(),'Search')]";
	public static final String OCR_FTASearchPage_Reset = "//button[contains(text(),'Reset')]";
	public static final String OCR_FTASearchPage_AddFTAAttribute = "//button[contains(text(),'Add FTA Attribute')]";
	public static final String OCR_FTASearchPage_SBUCode = "//select[@id='searchFtaAttribute_ftaAttribute_sbuCode']";
	public static final String OCR_FTASearchPage_FTAType = "//select[@id='searchFtaAttribute_ftaAttribute_fta']";
	public static final String OCR_FTASearchPage_SortBy = "//select[@name='sortBy']";
	public static final String OCR_FTASearchPage_Direction = "//select[@name='direction']";

	/* ******************************* Constructor ****************************** */

	public SearchFTAAttributePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	// Click on Search Button
	public void search() {
		clickElement(driver, test, OCR_FTASearchPage_Search, "Clicking on Search Button :");
	}

	// Click on Reset Button
	public void reset() {
		clickElement(driver, test, OCR_FTASearchPage_Reset, "Clicking on Reset Button :");
	}

	// Click on Add Attribute Button
	public void addAttribute() {
		clickElement(driver, test, OCR_FTASearchPage_AddFTAAttribute, "Clicking on Add Attributes Button :");
	}

	// Select SBU Code
	public void selectSBU(String sbuCode) {
		selectByVisibleText(driver, test, OCR_FTASearchPage_SBUCode, "Selecting SBU Code :", sbuCode);
	}

	// Select FTA type Code
	public void ftaType(String FTAtype) {
		selectByVisibleText(driver, test, OCR_FTASearchPage_FTAType, "Selecting FTA Type :", FTAtype);
	}

	// Select Sort By Code
	public void sortBy(String SortBy) {
		selectByVisibleText(driver, test, OCR_FTASearchPage_SortBy, "Selecting Sort By :", SortBy);
	}

	// Select SBU Code
	public void direction(String Direction) {
		selectByVisibleText(driver, test, OCR_FTASearchPage_Direction, "Selecting Direction :", Direction);
	}
	
	//Search By Parameters
	public void searchbyParameters(String sbuCode, String FTAtype, String SortBy, String Direction) {
		selectByVisibleText(driver, test, OCR_FTASearchPage_SBUCode, "Selecting SBU Code :", sbuCode);
		selectByVisibleText(driver, test, OCR_FTASearchPage_FTAType, "Selecting FTA Type :", FTAtype);
		selectByVisibleText(driver, test, OCR_FTASearchPage_SortBy, "Selecting Sort By :", SortBy);
		selectByVisibleText(driver, test, OCR_FTASearchPage_Direction, "Selecting Direction :", Direction);
	}
	
	//Click on FTYType
	public void ftaTypeEdit(String FTAtype) {
		clickElement(driver, test, "//a[contains(text(),'"+FTAtype+"')]", "Clicking on FTA type :"+FTAtype);
	}
	
	//Click on Copy Icon
	public void copyIcon() {
		clickElement(driver, test, "//i[@class='fa fa-copy']", "Clicking on Copy Icon :");
	}
	
	//Click on Delete Icon
	public void deleteIcon() {
		clickElement(driver, test, "//i[@class='fa fa-trash-o']", "Clicking on Delete ICon :");
	}

}
