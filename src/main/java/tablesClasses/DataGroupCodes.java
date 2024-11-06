package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class DataGroupCodes extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
//---------------------------------Locators---------------------------------------------
	
	public static final String OCRsearch="//button[@name='save']";
	public static final String OCRaddDatagroupcode="//button[@name='Ok']";
	public static final String OCRgroupcode="//input[@id='resultDataGroupCodes_dataGroupCodesValue_groupCode']";
	public static final String OCRdescription="//input[@id='resultDataGroupCodes_dataGroupCodesValue_description']";
	public static final String OCRstatus="//select[@id='resultDataGroupCodes_dataGroupCodesValue_status']";
	public static final String OCRsortBy="//select[@name='sortBy']";
	public static final String OCRdirection="//select[@name='direction']";
	
	
	//--------------------------Add datagroupcode xpath--------------------------------------------------
	
	public static final String OCR_groupcode="//input[@id='editDataGroupCodes_dataGroupCodesValue_groupCode']";
	public static final String OCRgroupcodedescription="//input[@id='editDataGroupCodes_dataGroupCodesValue_description']";
	public static final String OCRgroupcoderemark="//textarea[@id='editDataGroupCodes_dataGroupCodesValue_remarks']";
	
	public static final String OCRsavebutton="//button[@name='save']";
	
	
	//--------------------Constructor------------------------------------
	
			public DataGroupCodes(WebDriver driver, ExtentTest test) {
				this.driver = driver;
				this.test = test;
					
			}

		//....................click on search button......................
			public void searchbutton() {
				clickElement(driver, test, OCRsearch, "clicking on search button :");
				
					}
			
			public void addbutton() {
				clickElement(driver, test, OCRaddDatagroupcode, "clicking on add button :");
				
					}
			//.....................searchParameter...............................//
			public void searchbyParameters(String GroupCode, String Description, String status, String SortBy, String direction) {
					typeText(driver, test, OCRgroupcode, "Entering group code :", GroupCode);
					Wait.waitfor(2);
					typeText(driver, test, OCRdescription, "Entering description", Description);
					Wait.waitfor(2);
					
					selectByVisibleText(driver, test, OCRstatus, "selecting Status by dropdown :", status );
					Wait.waitfor(2);
					
					selectByVisibleText(driver, test, OCRsortBy, "selecting SortBy by dropdown :", SortBy );
					Wait.waitfor(2);
					selectByVisibleText(driver, test, OCRdirection, "selecting direction by dropdown :", direction );
					Wait.waitfor(2);
									
					}
			//-----------------------------------------add data group code--------------------------
			
			public void AddbyParameters(String GroupCode, String Description, String Remarks) {
				
				typeText(driver, test, OCR_groupcode, "Entering Group code :", GroupCode);
				Wait.waitfor(2);
				typeText(driver, test, OCRgroupcodedescription, "Entering config type", Description);
				Wait.waitfor(2);
				typeText(driver, test, OCRgroupcoderemark, "Entering config type", Remarks);
				Wait.waitfor(2);
				clickElement(driver, test, OCRsavebutton, "Click on save button");
}
}