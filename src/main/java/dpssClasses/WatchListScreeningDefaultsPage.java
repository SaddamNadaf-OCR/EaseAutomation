package dpssClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class WatchListScreeningDefaultsPage extends GenericMethods{

	public WebDriver driver;
	public ExtentTest test;
	
	/* ******************************** LOCATORS ******************************** */
	//Entity Search Type Options
	public static final String OCR_WLSDEFLT_ShowName_Default ="//input[@id='st0']";
	public static final String OCR_WLSDEFLT_ShowNameORCountry_Default= "//input[@id='st1']";
	public static final String OCR_WLSDEFLT_ShowNameANDCountry_Default= "//input[@id='st2']";
	public static final String OCR_WLSDEFLT_ShowNameORAddress_Default= "//input[@id='st3']";
	public static final String OCR_WLSDEFLT_ShowNameANDAddress_Default= "//input[@id='st4']";
	public static final String OCR_WLSDEFLT_ShowNameORADR_ANDCountry_Default="//input[@id='st5']";
	
	//Fuzzy Score Options
	public static final String OCR_WLSDEFLT_ShowTight_Default ="//input[@id='so0']";
	public static final String OCR_WLSDEFLT_ShowMedium_Default ="//input[@id='so1']";
	public static final String OCR_WLSDEFLT_ShowWide_Default ="//input[@id='so2']";
	public static final String OCR_WLSDEFLT_DNTShow_SrchOptions ="//input[@id='SO_SHOW_NOT']";
	
	//Search Method Options
	public static final String OCR_WLSDEFLT_ShowExact_Default ="//input[@id='sm0']";
	public static final String OCR_WLSDEFLT_ShowFuzzy_Default ="//input[@id='sm1']";
	
	//WorkFlow Settings
	public static final String OCR_WLSDEFLT_WorkFlowSettings = "//a[contains(text(),'WorkFlow Settings')]";
	public static final String OCR_WLSDEFLT_AutoAddToDB_Adhoc ="//input[@id='dpssScreeningAdminDefault_addToDatabaseFromAdHoc-1']";
	public static final String OCR_WLSDEFLT_AddToDB_Dropdown = "//select[@id='dpssScreeningAdminDefault_fileName']";
	public static final String OCR_WLSDEFLT_AddToDB_Cases = "//select[@id='dpssScreeningAdminDefault_approvedEntityFlag']";
	public static final String OCR_WLSDEFLT_Save = "//button[contains(text(),'Save')]";
	
	/* ******************** Constructor ***************************** */
	
	public WatchListScreeningDefaultsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	/* ******************** Actions ********************************* */
	
	// click Show Name default radio button
		public void click_ShowName ()throws InterruptedException {
			clickElement(driver, test, OCR_WLSDEFLT_ShowName_Default, "Clicking on Show Name default radio button");
		}
		// click Show Name or country default radio button
		public void click_ShowNameORCountry ()throws InterruptedException {
			clickElement(driver, test, OCR_WLSDEFLT_ShowNameORCountry_Default, "Clicking on Show Name or Country default radio button");
		}
		// click Show Name and  country default radio button
		public void click_ShowNameANDCountry ()throws InterruptedException {
			clickElement(driver, test, OCR_WLSDEFLT_ShowNameANDCountry_Default, "Clicking on Show Name and  Country default radio button");
		}
		// click Show Name or address default radio button
		public void click_ShowNameORAddress ()throws InterruptedException {
			clickElement(driver, test, OCR_WLSDEFLT_ShowNameORAddress_Default, "Clicking on Show Name or Address default radio button");
		}
		// click Show Name and address default radio button
		public void click_ShowNameANDAddress ()throws InterruptedException {
			clickElement(driver, test, OCR_WLSDEFLT_ShowNameANDAddress_Default, "Clicking on Show Name and Address default radio button");
		}
		// click Show Name or address and country default radio button
		public void click_ShowNameORAddressANDCountry ()throws InterruptedException {
			clickElement(driver, test, OCR_WLSDEFLT_ShowNameORADR_ANDCountry_Default, "Clicking on Show Name or Address and country  default radio button");
		}
		// click Show Tight default radio button
		public void click_ShowTight ()throws InterruptedException {
			clickElement(driver, test, OCR_WLSDEFLT_ShowTight_Default, "Clicking on Show Tight default radio button");
		}
		// click Show Medium default radio button
			public void click_ShowMedium ()throws InterruptedException {
				clickElement(driver, test, OCR_WLSDEFLT_ShowMedium_Default, "Clicking on Show Medium default radio button");
		}
		// click Show Wide default radio button
			public void click_ShowWide ()throws InterruptedException {
			clickElement(driver, test, OCR_WLSDEFLT_ShowWide_Default, "Clicking on Show Wide default radio button");
		}
			// click Show Exact radio button
			public void click_Exact ()throws InterruptedException {
			clickElement(driver, test, OCR_WLSDEFLT_ShowExact_Default, "Clicking on Show Exact default radio button");
		}
			// click Show Fuzzy radio button
			public void click_Fuzzy ()throws InterruptedException {
			clickElement(driver, test, OCR_WLSDEFLT_ShowFuzzy_Default, "Clicking on Show Fuzzy default radio button");
		}		
			
		// click Work Flow Setting section
				public void click_WorkFlowSetting ()throws InterruptedException {
				clickElement(driver, test,OCR_WLSDEFLT_WorkFlowSettings , "Clicking on Work Flow Setting");
			}		
	
			
			// click Add to Database checkbox
			public void click_AutoAddtoDB ()throws InterruptedException {
			clickElement(driver, test, OCR_WLSDEFLT_AutoAddToDB_Adhoc, "Clicking on Auto Add to DB Checkbox");
		}		
			// Select option from Add to Database Drop down 
			public void select_AddToDatabase(String SearchType ) {
			selectByVisibleText(driver,test,OCR_WLSDEFLT_AddToDB_Dropdown ,"Select Entity Search Type",SearchType);
		}
			
			// Select option from Cases Drop down 
			public void select_Cases(String SearchType ) {
			selectByVisibleText(driver,test,OCR_WLSDEFLT_AddToDB_Cases ,"Select Cases  Search Type",SearchType);
		}
		
		// click Save
			public void click_Save()throws InterruptedException {
			clickElement(driver, test, OCR_WLSDEFLT_Save, "Clicking on Save");
			}			
		
}
