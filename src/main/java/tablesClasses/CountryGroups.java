package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class CountryGroups extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
//---------------------------------Locators---------------------------------------------
	
	public static final String OCRcntrysearchsearch="//button[@name='save']";
			public static final String coutrysearchgrouptype="//input[@id='groupType']";
			public static final String coutrysearchadd="//button[@name='Ok']";
			public static final String coutrysearchCountryGrpCode="//input[@id='resultCountryGroups_countryGroupsValue_countryGroupCode']";
			public static final String coutrysearchstatus="//select[@id='resultCountryGroups_countryGroupsValue_status']";
			public static final String coutrysearchSortBy="//select[@name='sortBy']";
			public static final String coutrysearchdirection="//select[@name='direction']";
			public static final String coutrysearchefffromdate="resultCountryGroups_fromDateFrom";
			public static final String coutrysearcheffTdate="//input[@id='resultCountryGroups_toDateFrom']";
			
			
			//---------------add country group locators--------------------------------------------------
			public static final String coutrygrpAddGrpType="//a[contains(text(),'Group Type')]";
			public static final String coutrygrpContrygrpcode="(//a[contains(text(),'Country')])[5]";
			public static final String coutrygrpcontrycode="//input[@id='editCountryGroups_']";
			public static final String coutrygrpeffectivedate="//input[@id='editCountryGroups_effectiveFromDate']";
			public static final String coutrygrpselectbutton="(//button[@name='Ok'])[1]";
			public static final String coutrygrpbuttonclose="(//button[@class='btn-close'])[1]";
			public static final String coutrygrpbuttonsave="(//button[@name='save'])[1]";
		
			
		
			
			//--------------------Constructor------------------------------------
			
			public CountryGroups(WebDriver driver, ExtentTest test) {
				this.driver = driver;
				this.test = test;
					
			}

		//....................click on search button......................
			public void searchbutton() {
				clickElement(driver, test, OCRcntrysearchsearch, "clicking on search button :");
					}
				
			
			//.....................searchParameter...............................//
			public void searchbyParameters(String CountryGroup, String CountryGroupCode, String status, String SortBy, String direction) {
					typeText(driver, test, coutrysearchgrouptype, "Entering contrygroup type :", CountryGroup);
					Wait.waitfor(2);
					typeText(driver, test, coutrysearchCountryGrpCode, "Entering country group code", CountryGroupCode);
					Wait.waitfor(2);
				
					
					selectByVisibleText(driver, test, coutrysearchstatus, "selecting Status by dropdown :", status );
					Wait.waitfor(2);
					
					selectByVisibleText(driver, test, coutrysearchSortBy, "selecting SortBy by dropdown :", SortBy );
					Wait.waitfor(2);
					selectByVisibleText(driver, test, coutrysearchdirection, "selecting direction by dropdown :", direction );
					Wait.waitfor(2);
									
					}
			
			
			//-------------------------------------Add country code-----------------------------------------------
			
			public void effectiveDate(String Effecivedate) {
				Wait.waitfor(2);
				if (Effecivedate.length() > 0) {
					clickElement(driver, test, coutrygrpeffectivedate, "Click on Effetive date");
					date(driver, test, "Selected on effective date : ", Effecivedate);
					test.log(LogStatus.PASS, "Selected on effective date : " + Effecivedate);
				}}
			public void click_countrygrpcode() {
				Wait.waitfor(3);
				clickElement(driver, test, coutrygrpContrygrpcode, "Click on countrygroupcode: ");
			}
			
			public void click_grouptype() {
				Wait.waitfor(3);
				clickElement(driver, test, coutrygrpAddGrpType, "Click on grouptype : ");
			}
			public void click_Addcountrygrps() {
				Wait.waitfor(3);
				clickElement(driver, test, coutrysearchadd, "Click on grouptype : ");
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
					clickElement(driver, test, coutrygrpbuttonclose, "Click on POP up close Icon");
				}}
			
				// Add group type
				public void addgrouptype(String GroupType) {
					Wait.waitfor(3);
					String addCA = "//table[@id='gridPopup']/tbody/tr/td[contains(text(),'" + GroupType + "')]";
					try {
						if (isDisplayed(driver, addCA)) {
							clickElement(driver, test, addCA, "Click on search record");
							test.log(LogStatus.PASS, "Add config type in add to result grid table : " + GroupType);
							select();
						}
					} catch (Exception e) {
						testFailSshot(driver, test);
						test.log(LogStatus.FAIL, "Fail to Add configtype in result grid table : " + GroupType);
						clickElement(driver, test, coutrygrpbuttonclose, "Click on POP up close Icon");
					}
				
			}
			public void select() {
				// TODO Auto-generated method stub
				clickElement(driver, test, coutrygrpselectbutton, "Clicking on Select Button");
			}
			public void country(String Country) {
				
				typeText(driver, test, coutrygrpcontrycode, "enter country :", Country);
			}
			public void save() {
				clickElement(driver, test, coutrygrpbuttonsave, "Clicking on save Button");
			}
		
		
		
	}

