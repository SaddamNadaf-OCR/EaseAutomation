package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class AddDCSpage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_addnewDcsbutton="//button[@name='Add']";
	public static final String OCR_search="//button[@name='Search1']";
	public static final String OCR_srcpageSbuCode="//select[@id='resultDcs_dcs_sbuCode']";
	public static final String OCR_srcpagedcsid="//input[@id='resultDcs_dcs_dcsId']";
	public static final String OCR_srcpageexportingcountry="//select[@id='resultDcs_dcs_licensedCountry']";
	public static final String OCR_srcpageimportcountry="//input[@id='resultDcs_dcs_countryName']";
	public static final String OCR_save="//button[@name='save.x']";
	public static final String OCR_dcsid="//input[@id='editDcs_dcs_dcsId']";
	public static final String OCR_exportingcountry="//select[@id='editDcs_dcs_licensedCountry']";
	public static final String OCR_importingcountry="//input[@id='editDcs_dcs_countryName']";
	public static final String OCR_statement="//textarea[@id='editDcs_dcs_statement']";
	public static final String OCR_pageheading="//h3[contains (text(),'Edit')]";
	public static final String OCR_HomePage_Files = "(//a[@class='nav-link dropdown-item'])[4]";
	public static final String OCR_HomePagedcs = "(//a[contains(text(),'DCS')])[1]";
	
	

	/* ******************************* Constructor ****************************** */

	public AddDCSpage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
public void dcsdetails(String DcsId, String ExportingCountry, String ImportingCountry, String Statement) {
	typeText(driver, test, OCR_dcsid, "enter dcs id", DcsId+randomnumbersbetween1_100());
	Wait.waitfor(2);
	selectByVisibleText(driver, test, OCR_exportingcountry, "select exporting country", ExportingCountry);
	Wait.waitfor(2);
	typeText(driver, test, OCR_importingcountry, "enter importing contry", ImportingCountry);
	Wait.waitfor(2);
	typeText(driver, test, OCR_statement, "enter OCR statement", Statement);

	
}
public void adddcs() {
	clickElement(driver, test, OCR_addnewDcsbutton, "click on add dcs");
}
	
	public void savebtn() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_save, "Click on save Button");
	}

	public void validateHeading() {
		Wait.waitfor(2);
		isDisplayed(driver, OCR_pageheading);
		Wait.waitfor(3);
		test.log(LogStatus.PASS, "Edit dcs page is Displayed");
		Wait.waitfor(3);
		
	}
	// Click on Files
		public void movetoFiles() {
			mouseOverAndClick(driver, test, OCR_HomePage_Files, "Mouseover to Files");
			Wait.waitfor(3);
			mouseOver(driver, test, OCR_HomePagedcs, "mousehover on dcs");
			clickElement(driver, test, OCR_HomePagedcs, "Click on dcs");
		}


}











