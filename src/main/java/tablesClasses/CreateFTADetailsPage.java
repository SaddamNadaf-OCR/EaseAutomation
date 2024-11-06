package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateFTADetailsPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
//------------------------------------------Locators-----------------------------------------------------------------//
	
	public static final String OCR_CountryGroupCode = "//a[contains(text(),'Country/Group Code')]";
	public static final String OCR_FTACode= "//input[@name='ftaDetailsValue.ftaCode']";
	public static final String OCR_RegulatoryCode = "//input[@name='ftaDetailsValue.regFtaCode']";
	public static final String OCR_Name = "//input[@name='ftaDetailsValue.name']";
	public static final String OCR_LangCode = "//select[@name='languageCode']";
	public static final String OCR_Save = "//button[@name='save']";
	public static final String OCR_SaveandReturn = "//button[@name='ok']";
	public static final String OCR_SelectBtn = "//button[@name='Ok']";
	public static final String OCR_CloseBtn="(//button[@class='btn-close'])[1]";
		
// -------------------------------------------Constructor-----------------------------------------//

	public CreateFTADetailsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
//--------------------------Code------------------------------------------------//
	public void enter_ExportItemsCode(String FTACode, String RegulatoryCode, String Name, String LangCode) {
			
			
		typeText(driver, test, OCR_FTACode, "enter FTACode", FTACode);
		typeText(driver, test, OCR_RegulatoryCode, "enter RegulatoryCode", RegulatoryCode);
		typeText(driver, test, OCR_Name, "enter Name", Name);
		selectByVisibleText(driver, test, OCR_LangCode, "selecting LangCode by dropdown :", LangCode );

			}
		public void Add_CountryGroupCodeButton() {
		clickElement(driver, test, OCR_CountryGroupCode, "click on add CountryGroupCode button");
		Wait.waitfor(3);
		}
		public void Add_CountryGroupCode(String CountryGroupCode) {
			clickElement(driver, test, OCR_CountryGroupCode, "click on add OCR_CountryGroupCode button");
			Wait.waitfor(3);
			String addGCC = "//table[@id='gridPopup']/tbody/tr/td[contains(text(),'" + CountryGroupCode + "')]";
			try {
				if (isDisplayed(driver, addGCC)) {
					clickElement(driver, test, addGCC, "Click on search record");
					test.log(LogStatus.PASS, "Add country grp code in add to result grid table : " + CountryGroupCode);
					select();
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Add country grp code in result grid table : " + CountryGroupCode);
				clickElement(driver, test, OCR_CloseBtn, "Click on POP up close Icon");
			}}
		public void select() {
			// TODO Auto-generated method stub
			clickElement(driver, test, OCR_SelectBtn, "Clicking on Select Button");
		}
		// --------------------------------Save--------------------------------------------//

				public void save() {
					scrollToElement(driver, OCR_Save);
					Wait.waitfor(3);
					scrollToTop(driver);
					clickElement(driver, test, OCR_Save, "Click on Save Button ");
				}
			// -------------------------------------SaveandReturn---------------------//

				public void saveandReturn() {
					scrollToElement(driver, OCR_SaveandReturn);
					Wait.waitfor(3);
					scrollToTop(driver);
					clickElement(driver, test, OCR_SaveandReturn, "Click on Save Button ");
				}



}
