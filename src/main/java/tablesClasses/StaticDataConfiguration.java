package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class StaticDataConfiguration extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
//---------------------------------Locators---------------------------------------------
	
	public static final String OCRCountry="(//input[@id='resultStaticDataConfig_country'])[1]";
	public static final String OCRstaticdatatype="(//select[@id='resultStaticDataConfig_staticDataConfigValue_staticDataType'])[1]";
	public static final String OCRconfigurationvalue="(//input[@id='resultStaticDataConfig_country'])[2]";
	public static final String OCRtrackerNo="(//input[@id='resultStaticDataConfig_staticDataConfigValue_trackerNo'])[1]";
	public static final String OCRstatus="(//select[@id='resultStaticDataConfig_staticDataConfigValue_status'])[1]";
	public static final String OCRsortby="(//select[@name='sortBy'])[1]";
	public static final String OCRDirection="(//select[@name='direction'])[1]";
	public static final String OCRsearchbutton="(//button[@name='save'])[1]";
	
	//---------------------------add staticdata xpath----------------------------------------------------
	public static final String OCRaddstaticdatabtn="//button[@name='Ok']";
	public static final String OCRaddCountry="(//input[@id='editStaticDataConfig_country'])[1]";
	public static final String OCRaddstaticdatatype="(//select[@id='editStaticDataConfig_staticDataConfigValue_staticDataType'])[1]";
	public static final String OCRconfigvalue="(//input[@id='editStaticDataConfig_country'])[2]";
	public static final String OCRsavebutton="(//button[@name='save'])[1]";
	
	
	
	
	//--------------------Constructor------------------------------------
	
			public StaticDataConfiguration(WebDriver driver, ExtentTest test) {
				this.driver = driver;
				this.test = test;
					
			}

		//....................click on search button......................
			public void searchbutton() {
				clickElement(driver, test, OCRsearchbutton, "clicking on search button :");
					}
			//....................click on save button......................
			public void savebutton() {
				clickElement(driver, test, OCRsavebutton, "clicking on save button :");
					}
			
			//.....................searchParameter...............................//
			public void searchbyParameters(String Country, String TrackerNo, String ConfValue, String staticData, String status, String SortBy, String direction) {
					typeText(driver, test, OCRCountry, "Entering contry :", Country);
					Wait.waitfor(2);
					typeText(driver, test, OCRtrackerNo, "Entering config type", TrackerNo);
					Wait.waitfor(2);
					typeText(driver, test, OCRconfigurationvalue, "Entering config value", ConfValue);
					Wait.waitfor(2);
					selectByVisibleText(driver, test, OCRstaticdatatype,"selecting Config For by dropdown", staticData);
					Wait.waitfor(2);
					selectByVisibleText(driver, test, OCRstatus, "selecting Status by dropdown :", status );
					Wait.waitfor(2);
				
					selectByVisibleText(driver, test, OCRsortby, "selecting SortBy by dropdown :", SortBy );
					Wait.waitfor(2);
					selectByVisibleText(driver, test, OCRDirection, "selecting direction by dropdown :", direction );
					Wait.waitfor(2);
									
					}
			
			//....................click on Add config button......................//
			public void addstaticdata() {
				clickElement(driver, test, OCRaddstaticdatabtn, "clicking on Add button :");
				}
			
			public void addcountry(String Country) {
			
				typeText(driver, test, OCRaddCountry, "Entering contry :", Country);
				Wait.waitfor(2);
			}
			
			public void otherdetails(String StaticDataType, String ConfigurationValue) {
				
				selectByVisibleText(driver, test, OCRaddstaticdatatype, "selecting staticdataType from dropdown :", StaticDataType );
				Wait.waitfor(2);
				typeText(driver, test, OCRconfigvalue, "Entering contry :", ConfigurationValue);
				Wait.waitfor(2);
			}
}