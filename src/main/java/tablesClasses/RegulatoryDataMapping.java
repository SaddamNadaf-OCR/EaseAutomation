package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class RegulatoryDataMapping  extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

//---------------------------------Locators---------------------------------------------

	public static final String OCRsearchbtn = "(//button[@class='primary-btn'])[1]";
	public static final String OCRAddAgencybtn = "(//button[@class='primary-btn'])[2]";
	public static final String OCRCntryGrpCode="(//input[@id='resultComDataMapping_comDataMappingValue_countryGroupCode'])[1]";
	public static final String OCRmappingtype="//input[@id='resultComDataMapping_comDataMappingValue_mappingType']";
	public static final String OCRBaseData="//input[@id='resultComDataMapping_comDataMappingValue_baseData']";
	public static final String OCRTargetdata="//input[@id='resultComDataMapping_comDataMappingValue_targetData']";
	public static final String OCRstatus="//select[@id='resultComDataMapping_comDataMappingValue_status']";
	public static final String OCRsortby="//select[@id='resultComDataMapping_sortBy']";
	public static final String OCRDirection="//select[@id='resultComDataMapping_direction']";
	public static final String OCRsavebtn="//button[@name='save']";
	
	//----------------------------------Add Locators-----------------------------------------------------
	public static final String OCRCountryGrpCode="//input[@id='editComDataMapping_comDataMappingValue_countryGroupCode']";
	public static final String OCRBaseData1="//input[@id='editComDataMapping_comDataMappingValue_baseData']";
	public static final String OCRmappingtype1="//input[@id='mappingTypeId']";
	public static final String OCRTargetData="//input[@id='editComDataMapping_comDataMappingValue_targetData']";
	

	// --------------------Constructor------------------------------------
	

	public RegulatoryDataMapping(WebDriver driver, ExtentTest test) {
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

	public void searchbyParameters(String CountrygrpCode, String MappingType, String BaseData, String TargetData, String Status, String sortby, String direction) {

		typeText(driver, test, OCRCntryGrpCode, "Entering country group code :", CountrygrpCode);
		Wait.waitfor(2);	
		typeText(driver, test, OCRmappingtype, "Entering mapping type :", MappingType);
		Wait.waitfor(2);	
		typeText(driver, test, OCRBaseData, "Entering base data:", BaseData);
		Wait.waitfor(2);
		typeText(driver, test, OCRTargetdata, "Entering target data :", TargetData);
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCRstatus, "selecting created by dropdown :", Status);
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCRsortby, "selecting sortby  dropdown :", sortby);
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCRDirection, "selecting direction by dropdown :", direction);
		Wait.waitfor(2);
	}
	// .....................addParameter...............................//

		public void addbyParameters(String BaseData, String MappingType, String TargetData) {

			typeText(driver, test, OCRCountryGrpCode, "Entering country group code:", randomnumbers());
			Wait.waitfor(2);	
			typeText(driver, test, OCRBaseData1, "Enteringbase data:", BaseData);
			Wait.waitfor(2);
			typeText(driver, test, OCRmappingtype1, "Entering mapping type:", MappingType);
			Wait.waitfor(2);	
			typeText(driver, test, OCRTargetData, "Entering target data:", TargetData);
			Wait.waitfor(2);
		
			
		}}
