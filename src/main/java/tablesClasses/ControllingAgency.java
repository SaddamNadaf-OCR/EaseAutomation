package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class ControllingAgency extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
//---------------------------------Locators---------------------------------------------
	
	public static final String OCRAddAgencybtn="//button[@id='mybutton']";
	public static final String OCRsearchbtn="(//button[@class='primary-btn'])[1]";
	public static final String OCRcode="(//input[@id='searchControllingAgency_controllingAgency_agencyCode'])[1]";
	public static final String OCRStatus="(//select[@id='searchControllingAgency_controllingAgency_status'])[1]";
	public static final String OCRname="(//input[@id='searchControllingAgency_controllingAgency_agencyName'])[1]";
	public static final String OCRCountry="(//select[@id='searchControllingAgency_controllingAgency_country'])[1]";
	public static final String OCRsortBy="(//select[@name='sortBy'])[1]";
	public static final String OCRDirection="(//select[@name='direction'])[1]";
			
	
//----------------------------------------------------add controlling agency locators---------------------------------------------------			
	public static final String OCRbuttonsave="//button[@type='submit']"	;
	public static final String OCRSBU="//input[@id='editControllingAgency_controllingAgency_agencyCode']";
	public static final String OCRName="//input[@id='editControllingAgency_controllingAgency_agencyName']";
	public static final String OCRCountryName="//input[@id='editControllingAgency_countryName']";

	
	
			
			//--------------------Constructor------------------------------------
			
			public ControllingAgency(WebDriver driver, ExtentTest test) {
				this.driver = driver;
				this.test = test;
					
			}
			//....................click on search button......................
			public void searchbutton() {
				clickElement(driver, test, OCRsearchbtn, "clicking on search button :");
					}
			//....................click on Add config button......................//
			public void addControllingAgency() {
				clickElement(driver, test, OCRAddAgencybtn, "clicking on Add button :");
				}

			public void savebutton() {
				clickElement(driver, test, OCRbuttonsave, "clicking on save button :");
					}
		//.....................searchParameter...............................//
			public void searchbyParameters(String Code, String Name, String status, String country, String SortBy, String Direction) {
					typeText(driver, test, OCRcode, "Entering contryCode :", Code);
					Wait.waitfor(2);
					typeText(driver, test, OCRname, "Entering config type", Name);
					Wait.waitfor(2);
					selectByVisibleText(driver, test, OCRStatus,"selecting Config For by dropdown", status);
					Wait.waitfor(2);
					selectByVisibleText(driver, test, OCRCountry, "selecting Status by dropdown :", country );
					Wait.waitfor(2);
					selectByVisibleText(driver, test, OCRsortBy,"selecting Config For by dropdown", SortBy);
					Wait.waitfor(2);
					selectByVisibleText(driver, test, OCRDirection, "selecting Status by dropdown :", Direction );
					Wait.waitfor(2);
			}
			//--------------------------------Add controlling agency parameter----------------------------------------------------
					
					public void AddAgencyParameters(String SBU1, String Name1,String Country) {
						typeText(driver, test, OCRSBU, "Entering SBU:", SBU1);
						Wait.waitfor(2);
						typeText(driver, test, OCRName, "Entering Name", Name1);
						Wait.waitfor(2);
						typeText(driver, test, OCRCountryName, "Entering Country:", Country);
						Wait.waitfor(2);

					}
					
			
			}
				