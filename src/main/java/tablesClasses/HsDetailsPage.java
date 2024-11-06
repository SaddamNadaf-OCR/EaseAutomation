package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class HsDetailsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

//---------------------------------Locators---------------------------------------------

	public static final String OCRsearchbtn = "(//button[@class='primary-btn'])[1]";
	public static final String OCRAddAgencybtn = "(//button[@class='primary-btn'])[2]";
	public static final String OCRHtsNo="//input[@id='hsNo']";
	public static final String OCRdescr="//textarea[@id='searchHs_hsDesc']";
	public static final String OCRstatus="//select[@id='hsStatus']";
	public static final String OCRsortby="//select[@name='sortBy']";
	public static final String OCRDirection="//select[@name='direction']";
	public static final String OCRImportExport="//select[@id='importExportSelectId']";
	public static final String OCREffectivedate="//input[@id='effectiveDate_Id']";
	
	//-----------------------------Add Locator-----------------------------------------------
	public static final String OCRsavebtn="//button[@name='save']";
	public static final String OCRhtsNo	="//input[@id='createUpdateHs_comHsDetailsValue_hsNo']";
	public static final String OCRCountry="//input[@id='createUpdateHs_country']";
	public static final String OCReffDate="//input[@id='createUpdateHs_effectiveDate']";
	public static final String OCRdescription="//textarea[@id='createUpdateHs_comHsDetailsValue_description']";
	public static final String OCReffsattsu="//select[@id='createUpdateHs_comHsDetailsValue_effectiveStatus']";
	public static final String OCRExpImport="//select[@id='createUpdateHs_comHsDetailsValue_importExport']";
	// --------------------Constructor------------------------------------
	

	public HsDetailsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

	}

	// ....................click on search button......................
	public void searchbutton() {
		clickElement(driver, test, OCRsearchbtn, "clicking on search button :");
	}

	public void addbutton() {
		clickElement(driver, test, OCRAddAgencybtn, "clicking on Add button :");
	}

	public void savebtn() {
		clickElement(driver, test, OCRsavebtn, "clicking on save button :");
	}

	// .....................searchParameter...............................//

	public void searchbyParameters(String HtsNo , String ImportExport ,String Description, String Status,String Effectivedate, String sortby, String direction ) {

		typeText(driver, test, OCRHtsNo, "Entering HtsNo :", HtsNo);
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCRImportExport, "selecting import/Export :", ImportExport);
		Wait.waitfor(2);
		typeText(driver, test, OCRdescr, "Entering description :", Description);
		Wait.waitfor(2);	
		selectByVisibleText(driver, test, OCRstatus, "selecting created by dropdown :", Status);
		Wait.waitfor(2);
		if (Effectivedate.length() > 0) {
			clickElement(driver, test, OCREffectivedate, "Click on Effetive date");
			date(driver, test, "Selected on effective date : ", Effectivedate);
			test.log(LogStatus.PASS, "Selected on effective date : " + Effectivedate);
		}
		selectByVisibleText(driver, test, OCRsortby, "selecting sortby  dropdown :", sortby);
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCRDirection, "selecting direction by dropdown :", direction);
		Wait.waitfor(2);
	}

	
	// .....................addParameter...............................//

		public void addbyParameters(String Country, String ExportImport, String Effectvedate, String Description, String EffectiveStatus) {

			typeText(driver, test, OCRhtsNo, "Entering hts no:", randomnumbers());
			Wait.waitfor(2);
			clearText(driver, test, OCRCountry, "clearing text");
			typeText(driver, test, OCRCountry, "Entering hts no:", Country);
			Wait.waitfor(2);
			selectByVisibleText(driver, test, OCRExpImport, "selecting direction by dropdown :", ExportImport);
			Wait.waitfor(2);
			if (Effectvedate.length() > 0) {
				clickElement(driver, test, OCReffDate, "Click on Effetive date");
				date(driver, test, "Selected on effective date : ", Effectvedate);
				test.log(LogStatus.PASS, "Selected on effective date : " + Effectvedate);
			}
			typeText(driver, test, OCRdescription, "Entering Description:", Description);
			Wait.waitfor(2);	
			selectByVisibleText(driver, test, OCRExpImport, "selecting effective status by dropdown :", EffectiveStatus);
			Wait.waitfor(2);
		
		}}