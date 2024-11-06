package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class OfficeOfExitPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

//---------------------------------Locators---------------------------------------------

	public static final String OCRsearchbtn = "(//button[@class='primary-btn'])[1]";
	public static final String OCRAddAgencybtn = "(//button[@class='primary-btn'])[2]";
	public static final String OCRcustomCode="//input[@id='resultOfficeOfExit_officeOfExitValue_customsCode']";
	public static final String OCROfficetitle="//textarea[@id='resultOfficeOfExit_officeOfExitValue_officeTitle']";
	public static final String OCRstatus="//select[@id='resultOfficeOfExit_officeOfExitValue_status']";
	public static final String OCRsortby="//select[@id='resultOfficeOfExit_sortBy']";
	public static final String OCRcity="//input[@id='resultOfficeOfExit_officeOfExitValue_city']";
	public static final String OCRcountrycode="//input[@id='resultOfficeOfExit_officeOfExitValue_countryCode']";
	public static final String OCRdirection="//select[@name='direction']";
	
	//-----------------------------Add Locator-----------------------------------------------
		public static final String OCRsavebtn="//button[@name='save']";
		public static final String OCRcustomcode="//input[@id='createUpdateOfficeOfExit_officeOfExitValue_customsCode']";
		public static final String OCRcity1="//input[@id='createUpdateOfficeOfExit_officeOfExitValue_city']";
		public static final String OCRofcTitle="//textarea[@id='createUpdateOfficeOfExit_officeOfExitValue_officeTitle']";
		public static final String OCRcntrycode	="//input[@id='createUpdateOfficeOfExit_officeOfExitValue_countryCode']";
		
		// --------------------Constructor------------------------------------
		

		public OfficeOfExitPage(WebDriver driver, ExtentTest test) {
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

		public void searchbyParameters(String Customcode, String Officetitle, String Status, String sortby, String city, String countrycode, String direction) {

			typeText(driver, test, OCRcustomCode, "Entering customcode :", Customcode);
			Wait.waitfor(2);	
			typeText(driver, test, OCROfficetitle, "Entering office of title :", Officetitle);
			Wait.waitfor(2);	
			selectByVisibleText(driver, test, OCRstatus, "selecting status from dropdown :", Status);
			Wait.waitfor(2);
			selectByVisibleText(driver, test, OCRsortby, "selecting sortby  from dropdown  :", sortby);
			Wait.waitfor(2);
			typeText(driver, test, OCRcity, "Entering city :", city);
			Wait.waitfor(2);	
			typeText(driver, test, OCRcountrycode, "Entering country code :", countrycode);
			Wait.waitfor(2);	
			selectByVisibleText(driver, test, OCRdirection, "selecting direction from dropdown :", direction);
			Wait.waitfor(2);
			
		}
		// .....................addParameter...............................//

		public void addbyParameters(String City, String OfficeOfTitle, String CountryCode) {

			typeText(driver, test, OCRcustomcode, "Entering hazmat ID:", randomnumbers());
			Wait.waitfor(2);	
			typeText(driver, test, OCRcity1, "Entering country :", City);
			Wait.waitfor(2);
			typeText(driver, test, OCRofcTitle, "Entering Description and shipping name:", OfficeOfTitle);
			Wait.waitfor(2);	
			typeText(driver, test, OCRcntrycode, "Entering Regulation:", CountryCode);
			Wait.waitfor(2);
		
			
		}
		
	}
		