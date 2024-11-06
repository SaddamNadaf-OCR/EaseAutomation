package productClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchReports extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */ 
		public static final String OCR_HomePage_ListScreening = "//ul[@class='nav navbar-nav']/li[2]/a";
		public static final String OCR_ExportOPerationsHomePage = "(//a[contains(text(),'Export Operations')])[1]";
		public static final String OCR_SearchProduct_Files = "//ul[@class='nav navbar-nav']/li[5]/a";
		public static final String OCR_SearchProduct_Product = "(//a[contains(text(),'Products')])[1]";
		public static final String OCR_SearchReportdropdown="//select[@name='reports']"; 
		public static final String OCR_SearchReportGo="//button[@id='mybutton']";
		public static final String OCR_Search="//button[@type='submit']";
		public static final String OCR_SBUCode="//select[@id='searchProductManufacturerReport_product_sbuCode']";
		public static final String OCR_Partno="//input[@id='searchProductManufacturerReport_product_productCode']";
		public static final String OCR_manufacturer="(//a[contains(text(),'Manufacturer')])[6]";
		public static final String OCR_CountryOfOrigin="//input[@id='searchProductManufacturerReport_product_countryOfOrigin1']";
		public static final String OCR_ExportClassification="//a[@id='expClsLnk']";
		public static final String OCR_ImportClassification="//a[@id='htsPopUp']";
		public static final String OCR_manufacturerCode="//input[@id='searchForm_userDTO_userCode']";
		public static final String OCR_popupsearch="//button[@name='Search']";
		public static final String OCR_popupSelect="(//button[@class='primary-btn recordFromPopup'])[1]";
		public static final String OCR_popupClose="(//button[@class='btn-close'])[1]";
		public static final String OCR_ExportCountryOfclass="//input[@id='searchProductExport_countryName']";
		public static final String OCR_ExportECCN="//input[@id='searchForm_productClazz_prodClassification']";
		public static final String OCR_ImpClassountry="//input[@id='resultProductCustomsClassReport_countryName']";
		public static final String OCR_importHScode="//input[@id='hsNo_resultStdHsPopup']";
		public static final String OCR_SBUCodeExp="//select[@id='searchProductExport_product_sbuCode']";
		public static final String OCR_PartnoExp="//input[@id='searchProductExport_product_productCode']";
		public static final String OCR_SBUCodeImp="//select[@id='resultProductCustomsClassReport_product_sbuCode']";
		public static final String OCR_PartnoImp="//input[@id='resultProductCustomsClassReport_product_productCode']";
		
		
		
		
		
		
		/* ******************** Constructor ***************************** */
		public SearchReports(WebDriver driver, ExtentTest test) {

			this.driver = driver;
			this.test = test;
		}

		/* ******************************* Actions ********************************* */
		
		public void ReportSearchdetails(String ReportType) {
			
			selectByVisibleText(driver, test, OCR_SearchReportdropdown, "Select Sbu Code ", ReportType);
			clickElement(driver, test, OCR_SearchReportGo, "click on go");
		}
		public void clickonsearh() {
			clickElement(driver, test, OCR_Search, "click on search");
		}
		
		/* ********************************manufacturer report search******************************* */
		
		public void ReportSearchmanufacturer(String SBUCodeforMan, String PartNoforMan, String ManufacturerCode, String CountryOFOrigin) {
			selectByVisibleText(driver, test, OCR_SBUCode, "Select Sbu Code ", SBUCodeforMan);
			typeText(driver, test, OCR_Partno, "Enter Part No ", PartNoforMan);
			
			if (ManufacturerCode.length() > 0) {
				Wait.waitfor(3);
				clickElement(driver, test, OCR_manufacturer, "Click manufacturer");
				try {
					typeText(driver, test, OCR_manufacturerCode, "Enter manufacturer Code", ManufacturerCode);
					clickElement(driver, test, OCR_popupsearch, "Click Search Button");
					String mancode = "//td[contains(text(),'" + ManufacturerCode + "')]";
					clickElement(driver, test, mancode, "Click Product Code :" + ManufacturerCode);
					clickElement(driver, test, OCR_popupSelect, "Click manufacturer Select button");
				} catch (Exception e) {
					testFailSshot(driver, test);
					test.log(LogStatus.FAIL, "Fail to add the program code");
					clickElement(driver, test, OCR_popupClose, "Close the Pop UP");
				}
			}
		
		typeText(driver, test, OCR_CountryOfOrigin, "Enter country of origin ", CountryOFOrigin);}
		
		/* ********************************Export classification report search******************************* */
		
		
		public void ReportSearchexportClassification(String SBUCodeforExp, String PartNoforExp, String ExportClassification, String ExpClassCountry){
			
			selectByVisibleText(driver, test, OCR_SBUCodeExp, "Select Sbu Code ", SBUCodeforExp);
			typeText(driver, test, OCR_PartnoExp, "Enter Part No ", PartNoforExp);
			 
			if (ExportClassification.length() > 0) {
				Wait.waitfor(3);
				clickElement(driver, test, OCR_ExportClassification, "Click manufacturer");
				try {
					typeText(driver, test, OCR_ExportECCN, "Enter manufacturer Code", ExportClassification);
					clickElement(driver, test, OCR_popupsearch, "Click Search Button");
					String Expcode = "//td[contains(text(),'" + ExportClassification + "')]";
					clickElement(driver, test, Expcode, "Click Product Code :" + ExportClassification);
					clickElement(driver, test, OCR_popupSelect, "Click manufacturer Select button");
				} catch (Exception e) {
					testFailSshot(driver, test);
					test.log(LogStatus.FAIL, "Fail to add the program code");
					clickElement(driver, test, OCR_popupClose, "Close the Pop UP");
				}
			}

			
		typeText(driver, test, OCR_ExportCountryOfclass, "Enter Part No ", ExpClassCountry);}
		
		
		/* ********************************Import classification report search******************************* */
		
		public void ReportSearchImportClassification(String SBUCodeforImp, String PartNoforImp, String ImportClassification) {
			selectByVisibleText(driver, test, OCR_SBUCodeImp, "Select Sbu Code ", SBUCodeforImp);
			typeText(driver, test, OCR_PartnoImp, "Enter Part No ", PartNoforImp);
			
			if (ImportClassification.length() > 0) {
				Wait.waitfor(3);
				clickElement(driver, test, OCR_ImportClassification, "Click manufacturer");
				try {
					typeText(driver, test, OCR_importHScode, "Enter impot HS Code", ImportClassification);
					clickElement(driver, test, OCR_popupsearch, "Click Search Button");
					String impcode = "//td[contains(text(),'" + ImportClassification + "')]";
					clickElement(driver, test, impcode, "Click Product Code :" + ImportClassification);
					clickElement(driver, test, OCR_popupSelect, "Click manufacturer Select button");
				} catch (Exception e) {
					testFailSshot(driver, test);
					test.log(LogStatus.FAIL, "Fail to add the program code");
					clickElement(driver, test, OCR_popupClose, "Close the Pop UP");
				}
			}

			
		typeText(driver, test, OCR_ExportCountryOfclass, "Enter Part No ", OCR_ImpClassountry);
		
		
		
		
}}

