package globalTradeControlClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;
import utilities.Wait;

public class GtcHomePage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_HomePage_ListScreening="//ul[@class='nav navbar-nav']/li[2]/a";
	public static final String OCR_GtcHomePage_GlobalTradeControls = "(//a[contains(text(),'Global Trade Controls')])[1]";
	public static final String OCR_GtcHomePage_ReturnGlobalTradeControls = "(//a[contains(text(),'Global Trade Controls')])[2]";
	public static final String OCR_GtcHomePage_Feature = "//ul[@class='nav navbar-nav']/li[3]/a";
	public static final String OCR_GtcHomePage_TradeControlScreen = "(//a[contains(text(),'Trade Control Screening')])[1]";

	/* ******************** Constructor ***************************** */

	public GtcHomePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Move to list screening
	public void moveTo_GtcListScreening(){
		mouseOver(driver, test, OCR_HomePage_ListScreening, "Mouse over on Watch List Screening");
		clickElement(driver, test, OCR_GtcHomePage_GlobalTradeControls, "Clicking on Global Trade Controls");
		mouseOver(driver, test, OCR_GtcHomePage_Feature, "Mouse over on Features");
	}
	
	// Selecting the trade control Screening from feature
	public void clickTo_TradeControlsScreening(){
		clickElement(driver, test, OCR_GtcHomePage_TradeControlScreen, "Clicking on Trade Controls Screening");
	}

	// Return to Global Trade Controls page
	public void GtcreturnPage(){
		mouseOver(driver, test, OCR_HomePage_ListScreening, "Mouse over on Watch List Screening");
		Wait.wait(driver, OCR_GtcHomePage_ReturnGlobalTradeControls);		
		clickElement(driver, test, OCR_GtcHomePage_ReturnGlobalTradeControls, "click on Global Trade Controls");
	}
}
