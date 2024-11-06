package tablesClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.handler.ClickElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class CountryConfigurationPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
//---------------------------------Locators---------------------------------------------
	
	public static final String OCRcntryconfigsearch ="//button[@name='save']";
	public static final String OCRcntryconfig_Add="//button[@name='Ok']";
	public static final String OCRcntryconfigFor="//select[@id='confFor']";
	public static final String OCRcntryconfigStatus="//select[@id='resultCountryConfiguration_countryConfigValue_status']";
	public static final String OCRcntryconfigCountryCode="//input[@id='resultCountryConfiguration_countryConfigValue_countryGroupCode']";
	public static final String OCRcntryconfigType="//input[@id='resultCountryConfiguration_countryConfigValue_configurationType']";
	public static final String OCRcntryconfigValue="//textarea[@id='resultCountryConfiguration_countryConfigValue_configurationValue']";
	public static final String OCRcntryconfigEffectiveStatus="//select[@id='resultCountryConfiguration_countryConfigValue_effectiveStatus']";
	public static final String OCRcntryconfigSortBy="//select[@name='sortBy']";
	public static final String OCRcntryconfigDirection	="//select[@name='direction']";
	public static final String OCRcntryconfigreset="//button[@type='reset']";
	
	//add configurations xpaths
	
	public static final String configFor="//select[@id='confFor']";
	public static final String Countrygrpcodehypelink="//a[contains(text(),'Country group code')]";
	public static final String configurtypehyperlink="(//a[contains(text(),'Type')])[10]";
	public static final String configvalue="//textarea[@id='editCountryConfiguration_countryConfigValue_configurationValue']";
	public static final String effectivedate="//input[@id='editCountryConfiguration_effectiveFromDate']";
	public static final String effectivetatus="//select[@id='editCountryConfiguration_countryConfigValue_effectiveStatus']";
	public static final String selectbutton ="//button[@name='Ok']";
	public static final String configtypeselectbutton="(//button[@name='Ok'])[1]";
	public static final String savebutton	="(//button[@type='submit'])[1]";
	public static final String buttonclose="(//button[@class='btn-close'])[1]";
	
	
	
	
	//--------------------Constructor------------------------------------
	
		public CountryConfigurationPage(WebDriver driver, ExtentTest test) {
			this.driver = driver;
			this.test = test;
				
		}

	//....................click on search button......................
		public void searchbutton() {
			clickElement(driver, test, OCRcntryconfigsearch, "clicking on search button :");
				}
			
		//....................click on reset button......................//
		public void resetbutton() {
			clickElement(driver, test, OCRcntryconfigreset, "clicking on reset button :");
				}
		
	//....................click on Add config button......................//
		public void addCountryCofig() {
			clickElement(driver, test, OCRcntryconfig_Add, "clicking on Add button :");
			}
	//.....................searchParameter...............................//
		public void searchbyParameters(String CountryCode, String CountryType, String ConfValue, String ConfigFor, String status, String Effectivestatus, String SortBy, String direction) {
				typeText(driver, test, OCRcntryconfigCountryCode, "Entering contryCode :", CountryCode);
				Wait.waitfor(2);
				typeText(driver, test, OCRcntryconfigType, "Entering config type", CountryType);
				Wait.waitfor(2);
				typeText(driver, test, OCRcntryconfigValue, "Entering config value", ConfValue);
				Wait.waitfor(2);
				selectByVisibleText(driver, test, OCRcntryconfigFor,"selecting Config For by dropdown", ConfigFor);
				Wait.waitfor(2);
				selectByVisibleText(driver, test, OCRcntryconfigStatus, "selecting Status by dropdown :", status );
				Wait.waitfor(2);
				selectByVisibleText(driver, test, OCRcntryconfigEffectiveStatus, "selecting Effetive Status by dropdown :", Effectivestatus );
				selectByVisibleText(driver, test, OCRcntryconfigSortBy, "selecting SortBy by dropdown :", SortBy );
				Wait.waitfor(2);
				selectByVisibleText(driver, test, OCRcntryconfigDirection, "selecting direction by dropdown :", direction );
				Wait.waitfor(2);
								
				}
		
		//add configurations
	
		public void effectiveDate(String Effecivedate) {
			Wait.waitfor(2);
			if (Effecivedate.length() > 0) {
				clickElement(driver, test, effectivedate, "Click on Effetive date");
				date(driver, test, "Selected on effective date : ", Effecivedate);
				test.log(LogStatus.PASS, "Selected on effective date : " + Effecivedate);
			}}
		public void click_countrygrpcode() {
			Wait.waitfor(3);
			clickElement(driver, test, Countrygrpcodehypelink, "Click on countrygroupcode: ");
		}
		
		public void click_confgtype() {
			Wait.waitfor(3);
			clickElement(driver, test, configurtypehyperlink, "Click on configuration type: ");
		}
		
		// Add Country group code
		public void addcountrygroupcode(String CountryGrpCode) {
			Wait.waitfor(3);
			String addCA = "//table[@id='gridPopup']/tbody/tr/td[contains(text(),'" + CountryGrpCode + "')]";
			try {
				if (isDisplayed(driver, addCA)) {
					clickElement(driver, test, addCA, "Click on search record");
					test.log(LogStatus.PASS, "Add country grp code in add to result grid table : " + CountryGrpCode);
					select();
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Add country grp code in result grid table : " + CountryGrpCode);
				clickElement(driver, test, buttonclose, "Click on POP up close Icon");
			}}
		
			// Add Country config type
			public void addconfigtype(String ConfigType) {
				Wait.waitfor(3);
				String addCA = "//table[@id='gridPopup']/tbody/tr/td[contains(text(),'" + ConfigType + "')]";
				try {
					if (isDisplayed(driver, addCA)) {
						clickElement(driver, test, addCA, "Click on search record");
						test.log(LogStatus.PASS, "Add config type in add to result grid table : " + ConfigType);
						select();
					}
				} catch (Exception e) {
					testFailSshot(driver, test);
					test.log(LogStatus.FAIL, "Fail to Add configtype in result grid table : " + ConfigType);
					clickElement(driver, test, buttonclose, "Click on POP up close Icon");
				}
			
		}
		public void select() {
			// TODO Auto-generated method stub
			clickElement(driver, test, configtypeselectbutton, "Clicking on Select Button");
		}
		public void configvalue(String configurationvalue) {
			
			typeText(driver, test, configvalue, "enter config value :", configurationvalue);
		}
		public void save() {
			clickElement(driver, test, savebutton, "Clicking on save Button");
		}
	
	
	
}