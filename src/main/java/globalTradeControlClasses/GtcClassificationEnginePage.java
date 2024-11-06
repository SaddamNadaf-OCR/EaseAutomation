package globalTradeControlClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class GtcClassificationEnginePage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_GtcHomePage_Feature = "(//a[@class='dropdown-toggle'])[3]";
	public static final String OCR_ClassificationEngine = "//a[contains(text(),'Classification Engine')]";
	public static final String OCR_ClassificationEngineClearCountryField = "//span[@class='tag']//a[contains(text(),'x')]";
	public static final String OCR_ClassificationEngineCountry = "//input[@id='ceng_countryDescription_tag']";
	public static final String OCR_ClassificationEngineSearchText = "//input[@id='ceng_query']";
	public static final String OCR_ClassificationEngineSearchType = "//select[@id='ceng_searchRule']";
	public static final String OCR_ClassificationEngineSearchBasedOn = "//label[contains(text(),'Search Based On')]";
	public static final String OCR_ClassificationEngineAlphabeticalIndex = "//input[@id='ceng_searchccl']";
	public static final String OCR_ClassificationEngineCASNumber = "//input[@id='ceng_searchcas']";
	public static final String OCR_ClassificationEngineSearch = "//button[@id='mybutton']";

	/* ******************** Constructor ***************************** */

	public GtcClassificationEnginePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Classification Engine Search
	public void moveTo_GtcClassificationEngine(String Country, String SearchText, String SearchType, String SearchBasedOn){
//		mouseOver(driver, test, OCR_GtcHomePage_Feature, "Mouse over on Features");
		clickElement(driver, test, OCR_ClassificationEngine, "Clicking on Classification Engine");
			clickElement(driver, test, OCR_ClassificationEngineClearCountryField, "Clear Country Field");
		typeText(driver, test, OCR_ClassificationEngineCountry, "Enter Country Name : ", Country);
		typeText(driver, test, OCR_ClassificationEngineSearchText, "Enter Search Text : ", SearchText);
		if(SearchType.equalsIgnoreCase("OR"))
		selectByVisibleText(driver, test, OCR_ClassificationEngineSearchType, "Enter Search Type : ", SearchType);
		if(SearchBasedOn.equalsIgnoreCase("Alphabetical Index"))
			clickElement(driver, test, OCR_ClassificationEngineAlphabeticalIndex, "click on Alphabetical Index Button");
		if(SearchBasedOn.equalsIgnoreCase("CAS Number"))
			clickElement(driver, test, OCR_ClassificationEngineCASNumber, "click on CAS Number Button");
		clickElement(driver, test, OCR_ClassificationEngineSearch, "click on Classification Engine Search Button");
		
	}

}
