package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class HomePageTables extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
//-----------------------------------------Locators-------------------------------------------------------//
	
	public static final String OCR_HomePage_SBU = "(//a[@class='nav-link dropdown-item'])[1]";
	public static final String OCR_HomePage_ModuleSelection = "(//a[@data-hover='dropdown'])[2]";
	public static final String OCR_HomePage_ModuleGExport = "(//a[contains(text(),'Export Operations')])[1]";
	public static final String OCR_HomePage_TablesEO = "(//a[@class='nav-link dropdown-item'])[5]";
	public static final String OCR_HomePageAESDirectInvalidHTSCodes = "//a[contains(text(),'AES Direct Invalid HTS Codes')]";
	public static final String OCR_HomePageAirOceanCarrier = "//a[contains(text(),'Air/Ocean Carrier')]";
	public static final String OCR_HomePageAirports = "//a[contains(text(),'Airports')]";
	public static final String OCR_HomePageClassificationCH = "//a[contains(text(),'Classification Change History')]";
	public static final String OCR_HomePageAuthorizationTransctionTypes = "//a[contains(text(),'Authorization Transaction Types')]";
	public static final String OCR_HomePageCommodityType = "//a[contains(text(),'Commodity Type')]";
	public static final String OCR_HomePageConfidenceLevel = "//a[contains(text(),'Confidence Level')]";
	public static final String OCR_HomePageCountry = "(//a[contains(text(),'Country')])[3]";
	public static final String OCR_HomePage_Report = "(//a[@class='nav-link dropdown-item'])[3]";
	public static final String OCR_HomePage_ProductReport = "//a[contains(text(),'Product Report')]";
	public static final String OCR_HomePage_commondata	="(//i[@class='fa fa-plus-square'])[15]";
	public static final String OCR_HomePage_countryconnfig="//a[contains (text(),'Country Configuration')]";
	public static final String OCR_HomePage_countrygroups="//a[contains (text(),'Country Groups')]";
	public static final String OCR_HomePage_datagfrpcode="//a[contains (text(),'Data Group Codes')]";
	public static final String OCR_HomePage_datagrpsbcodes="//a[contains (text(),'Data Group Sub Codes')]";
	public static final String OCR_HomePage_statcdatconfig="//a[contains (text(),'Static Data Configuration')]";
	public static final String OCR_HomePage_controllingagency	="//a[contains(text(),'Controlling Agency')]";
	public static final String OCR_HomePage_subcontrollingagency="(//a[contains(text(),'Controlling Agency')])[2]";
	public static final String OCR_HomePage_currency	="(//a[@class='show_hide dropdown-item'])[17]";
	public static final String OCR_HomePage_CurrencyInner	="(//a[contains (text(),'Currency')])[4]";
	public static final String OCR_HomePage_CommericialCurrConvRate	="(//a[contains (text(),'Currency')])[3]";
	public static final String OCR_HomePage_CurrencyExchangeRateRules	="(//a[contains (text(),'Currency')])[5]";
	public static final String OCR_HomePage_CustomCurrencyConversionRate	="(//a[contains (text(),'Currency')])[6]";
	public static final String OCR_HomePage_CustomCurrencyConversion	="(//a[contains (text(),'Currency')])[7]";
	public static final String OCR_HomePage_CommercialCurrencyConversion	="(//a[contains (text(),'Currency')])[2]";
	
	public static final String OCR_HomePage_ECCNUSMLMapping	="//a[contains (text(),'ECCN USML Mapping')]";
	public static final String OCR_HomePage_ExportItems	="//a[contains (text(),'Export Items')]";
	public static final String OCR_HomePage_FTADetails	="//a[contains (text(),'FTA Details')]";
	public static final String OCR_HomePage_ModeOfPayment	="//a[contains (text(),'Mode Of Payment')]";
	public static final String OCR_HomePage_ModeOfTransport	="//a[contains (text(),'Mode of Transport')]";
	public static final String OCR_HomePage_LocationDetails	="//a[contains (text(),'Location Details')]";
	
//--------------------------------------Constructor--------------------------------------------------------//
	public HomePageTables(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
// Move to SBU Select and module selections
	public void moveTo_SBUSelectionEO(String SBU) {
		mouseOver(driver, test, OCR_HomePage_SBU, "On Mouse Click Select the SBU");
		clickElement(driver, test, OCR_HomePage_SBU, "clickingonSBU :" + SBU);
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_HomePage_ModuleSelection, "Mouseover to Module Selection");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_ModuleGExport, "Click on Global Export Module");
	}
	
//----------------------------------Move to Tables-------------------------------------------//
	public void movetoAESIvalidHTSCodes() {
		mouseOver(driver, test, OCR_HomePage_TablesEO, "Mouseover to AES Invalid HTS Codes");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePageAESDirectInvalidHTSCodes, "Click on AES Invalid HTS Codes");
	}
	
	public void movetoAirOceanCarrier() {
		mouseOver(driver, test, OCR_HomePage_TablesEO, "Mouseover to Air/Ocean Carrier");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePageAirOceanCarrier, "Click on Air/Ocean Carrier");
	}
	
	public void movetoAirports() {
		mouseOver(driver, test, OCR_HomePage_TablesEO, "Mouseover to Airports");
		Wait.waitfor(3);
		
		clickElement(driver, test, OCR_HomePageAirports, "Click on Airports");
	}
	
	public void movetoECCNUSMLMapping() {
		mouseOver(driver, test, OCR_HomePage_TablesEO, "Mouseover to ECCN USML Mapping");
		Wait.waitfor(3);
		
		clickElement(driver, test, OCR_HomePage_ECCNUSMLMapping, "Click on ECCN USML Mapping");
	}
	
	public void movetoExportItems() {
		mouseOver(driver, test, OCR_HomePage_TablesEO, "Mouseover to ExportItems");
		Wait.waitfor(3);
		
		clickElement(driver, test, OCR_HomePage_ExportItems, "Click on ExportItems");
	}
	public void movetoFTADetails() {
		mouseOver(driver, test, OCR_HomePage_TablesEO, "Mouseover to FTADetails");
		Wait.waitfor(3);
		
		clickElement(driver, test, OCR_HomePage_FTADetails, "Click on FTADetails");
	}
	
	public void movetoModeOfPayment() {
		mouseOver(driver, test, OCR_HomePage_TablesEO, "Mouseover to Mode of Payment");
		Wait.waitfor(3);
		
		clickElement(driver, test, OCR_HomePage_ModeOfPayment, "Click on Mode Of Payment");
	}
	public void movetoModeofTransport() {
		mouseOver(driver, test, OCR_HomePage_TablesEO, "Mouseover to Mode of Transport");
		Wait.waitfor(3);
		
		clickElement(driver, test, OCR_HomePage_ModeOfTransport, "Click on Mode Of Transport");
	}
	public void movetoLocationDetails() {
		mouseOver(driver, test, OCR_HomePage_TablesEO, "Mouseover to Mode of Transport");
		Wait.waitfor(3);
		
		clickElement(driver, test, OCR_HomePage_LocationDetails, "Click on Location Details");
	}

	public void movetocommondata() {
		mouseOver(driver, test, OCR_HomePage_TablesEO, "Mouseover to tables");
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_HomePage_commondata, "Mouseover to commondata");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_commondata, "Click on common data");
	}
	public void clickoncoutryconfig() {
		
		clickElement(driver, test, OCR_HomePage_countryconnfig, "Click on country comfiguration");
	}
public void clickoncoutryGroups() {
		
		clickElement(driver, test, OCR_HomePage_countrygroups, "Click on country groups");
	}
public void clickondatagrpcodes() {
	
	clickElement(driver, test, OCR_HomePage_datagfrpcode, "Click on data group codes");
}
public void clickondatasubgrpcodes() {
	
	clickElement(driver, test, OCR_HomePage_datagrpsbcodes, "Click on data sub group codes");
}
public void clickonstaticdataconfig() {
	
	clickElement(driver, test, OCR_HomePage_statcdatconfig, "Click on static data configuration");
}
//-------------------------------------------Currency-------------------------------------------------------------------//
public void movetocurrency() {
	mouseOver(driver, test, OCR_HomePage_TablesEO, "Mouseover to tables");
	Wait.waitfor(3);
	mouseOver(driver, test, OCR_HomePage_currency, "Mouseover to currency");
	Wait.waitfor(3);
	clickElement(driver, test, OCR_HomePage_currency, "Click on  Currency");
}

public void clickonCurrency() {
	
	clickElement(driver, test, OCR_HomePage_CurrencyInner, "Click on Currency");
}
public void clickonCommercialCurrencyConversionRate() {
	
	clickElement(driver, test, OCR_HomePage_CommericialCurrConvRate, "Click on Commercial Currency Conversion rate");
}
public void clickonCurrencyExchangeRateRules() {
	
	clickElement(driver, test, OCR_HomePage_CurrencyExchangeRateRules, "Click on  Currency Exchange Rules rate");
}
public void clickonCustomCurrencyConversionRate() {
	
	clickElement(driver, test, OCR_HomePage_CustomCurrencyConversionRate, "Click on  Custom Currency Conversion rate");
}
public void clickonCustomCurrencyConversion() {
	
	clickElement(driver, test, OCR_HomePage_CustomCurrencyConversion, "Click on  Custom Currency Conversion");
}

public void clickonCommercialCurrencyConversion() {
	
	clickElement(driver, test, OCR_HomePage_CommercialCurrencyConversion, "Click on  Commercial Currency Conversion");
}
//-------------------------------------------------Currency-----------------------------------------------------------------//
	
	public void movetoClassificationCH() {
		mouseOver(driver, test, OCR_HomePage_TablesEO, "Mouseover to Classification Change History");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePageClassificationCH, "Click on Classification Change History");
	}
	
	public void movetoAuthorizationTransactionTypes() {
		mouseOver(driver, test, OCR_HomePage_TablesEO, "Mouseover to Authorization Transaction Types");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePageAuthorizationTransctionTypes, "Authorization Transaction Types");
	}
	
	public void movetoCommodityType() {
		mouseOver(driver, test, OCR_HomePage_TablesEO, "Mouseover to Commodity Types");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePageCommodityType, "Commodity Type");
	}
	
	public void movetoConfidenceLevel() {
		mouseOver(driver, test, OCR_HomePage_TablesEO, "Mouseover to Confidence Level");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePageConfidenceLevel, "Confidence Level");
	}
	
	public void movetoCountry() {
		mouseOver(driver, test, OCR_HomePage_TablesEO, "Mouseover to Confidence Level");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePageCountry, "Country");
	}
	public void movetoControllingAgency() {
		mouseOver(driver, test, OCR_HomePage_TablesEO, "Mouseover to Controlling agency");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_controllingagency, "Controlling agency");
		Wait.waitfor(1);
		clickElement(driver, test, OCR_HomePage_subcontrollingagency, "Controlling agency");
	}
	
	
//---------------------------------------Home Page--------------------------------------------------------//
	public void returnToGExportHomePage() {
		mouseOver(driver, test, OCR_HomePage_ModuleSelection, "Mouseover to module selection");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, "(//a[contains(text(),'Export Operations')])[2]", "Click on EO module");
	}
	
// Click on Reports
	public void movetoReports() {
		mouseOver(driver, test, OCR_HomePage_Report, "Mouseover to Report");
		clickElement(driver, test, OCR_HomePage_ProductReport, "Click on Product Report: ");
		Wait.waitfor(3);
		clickElement(driver, test, "//label[contains(text(),'Description')]", "Click on label Description: ");
	}

	public void returnToProductReportPage() {
		mouseOver(driver, test, OCR_HomePage_Report, "Mouseover to Report");
		clickElement(driver, test, OCR_HomePage_ProductReport, "Click on Product Report: ");
	}

	


}
