package productClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ProductPopUpPage extends GenericMethods{

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_PartNo = "//input[@id='searchForm_product_productCode']";
	public static final String OCR_PartNoManuf = "//input[@id='searchForm_partNoManuPartNoNSNModel']";
	public static final String OCR_Description = "//textarea[@id='searchForm_product_productDesc']";
	public static final String OCR_ProductName = "//textarea[@id='searchForm_product_productName']";
	public static final String OCR_CommodityType = "//select[@id='searchForm_product_productType']";
	public static final String OCR_SKUNo ="//input[@id='searchForm_product_skuNo']";
	public static final String OCR_ModelNo = "//input[@id='searchForm_product_modelNo']";
	public static final String OCR_NationalStockNo ="//input[@id='searchForm_product_nationalStockNumber']";
	public static final String OCR_ManufPartNo ="//input[@id='searchForm_manufPartNum']";
	public static final String OCR_Manufacturer ="//input[@id='searchForm_product_manufacturer']";
	//public static final String OCR_ImportClassif ="//a[@id='htsCodePopup']";
	public static final String OCR_ImportClassif="//input[@id='searchForm_product_htsNo']";
	public static final String OCR_Search="//button[contains(text(),'Search')]";
	public static final String OCR_Select ="//button[contains(text(),'Select')]";
	public static final String OCR_StatClassif="//a[@id='schedulebLinkPopup']";
	public static final String OCR_StatClassifHS="//input[@id='searchForm_schbhtsNo']";
	public static final String OCR_ExpClassif ="//a[@id='eccnProductPopup']";
	public static final String OCR_ExpClassifECCN ="//input[@id='searchForm_product_productClassification']";
	public static final String OCR_Status = "(//select[@class='form-control'])[2]";
	public static final String OCR_SortBy = "(//select[@class='form-control'])[3]";
	public static final String OCR_Direction = "(//select[@class='form-control'])[4]";
	public static final String OCR_HomePage_ListScreening = "//ul[@class='nav navbar-nav']/li[2]/a";
	public static final String OCR_HomePage_Files= "html/body/header/div/div/nav/div[2]/ul[1]/li[5]/a";	
	public static final String OCR_HomePageProduct ="(//a[contains(text(),'Product')])[4]";
		
	
	/* ******************** Constructor ***************************** */
	public ProductPopUpPage(WebDriver driver, ExtentTest test) { 
		this.driver = driver;
		this.test = test;
	}
	
	public void enter_PartNo(String PartNo) {
		typeText(driver, test, OCR_PartNo, "Enter Part No", PartNo);
	}
	
	public void enter_PartNoManuf(String PartNoManuf) {
		typeText(driver, test, OCR_PartNoManuf, "Enter Part No Manufacturer", PartNoManuf);
	}
	
	public void enter_Description(String Description) {
		typeText(driver, test, OCR_Description, "Enter Description", Description);
	}
	
	public void enter_ProductName(String ProductName) {
		typeText(driver, test, OCR_ProductName, "Enter Product Name",ProductName);
	}
	
	public void select_commoditytype(String CommodityType) {
		selectByVisibleText(driver, test, OCR_CommodityType,"Select Commodity Type", CommodityType);
	}
	
	public void enter_SKUNo(String SKUNo) {
		typeText(driver, test, OCR_SKUNo, "Enter SKU No",SKUNo);
	}
	
	public void enter_ModelNo(String ModelNo) {
		typeText(driver, test, OCR_ModelNo, "Enter Model No", ModelNo);
	}
	
	public void enter_NationalStockNo(String NationalStockNo) {
		typeText(driver, test, OCR_NationalStockNo, "Enter SKU No", NationalStockNo);
	}
	
	public void enter_ManufPartNo(String ManufPartNo) {
		typeText(driver, test, OCR_ManufPartNo, "Enter SKU No",ManufPartNo);
	}
	
	public void enter_Manufacturer(String Manufacturer) {
		typeText(driver, test, OCR_Manufacturer, "Enter SKU No", Manufacturer);
	}
	
	public void select_Status(String Status) {
		selectByVisibleText(driver, test, OCR_Status,"Select Status", Status);
	}
	
	public void select_SortBy(String SortBy) {
		selectByVisibleText(driver, test, OCR_SortBy,"Select SortBy", SortBy);
	}
	
	public void select_Direction(String Direction) {
		selectByVisibleText(driver, test, OCR_Direction,"Select Direction", Direction);
	}
	
	// Move to watch list screening
		public void moveTo_ListScreening() {
			mouseOver(driver, test, OCR_HomePage_ListScreening, "Mouse over on Watch List Screening");
		}
		//Select Module
		public void select_Module(String ModuleName) {
			//Wait.waitfor(3);
			String addsmodulename = "//li[2]/ul/li/a[contains(text(),'"+ ModuleName +"')]";
			try {
				if (isDisplayed(driver,addsmodulename)) {
					clickElement(driver, test, addsmodulename, "Click on search record");
					test.log(LogStatus.PASS, "Add Module Name in add to result grid table : " + ModuleName);
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Add Module Name in result grid table : " +  ModuleName);
			}
			
		}
		//Select Files
		public void movetoFiles() {			
			mouseOver(driver, test, OCR_HomePage_Files, "Mouseover to Files");
			clickElement(driver, test, OCR_HomePageProduct, "Click on Product");
				}

		public void search() {
			clickElement(driver, test, OCR_Search, "Clicking on Search Button: ");			
		}
		
		public void select() {
			clickElement(driver, test, OCR_Select, "Clicking on Select Button: ");			
		}
		// Add Part No is Added to the Result grid or not
		public void addpartnoToResultsGrid(String PartNo) {
			Wait.waitfor(3);
			String addspartno = "//table[@id='gridPopup']/tbody/tr/td[contains(text(),'" +PartNo + "')]";
			try {
				if (isDisplayed(driver, addspartno)) {
					clickElement(driver, test, addspartno, "Click on search record");
					test.log(LogStatus.PASS, "Add Part No in add to result grid table : " + PartNo);
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Add PartNo in result grid table : " +  PartNo);
			}
		}
		// Add Part No is Added to the Result grid or not
		public void addpartnomanufToResultsGrid(String partNoManuf) {
			String addspartnomanuf = "//table[@id='gridPopup']/tbody/tr/td[contains(text(),'" +partNoManuf + "')]";
			try {
				if (isDisplayed(driver, addspartnomanuf)) {
					clickElement(driver, test, addspartnomanuf, "Click on search record");
					test.log(LogStatus.PASS, "Add Part No Manufacturer in to result grid table : " + partNoManuf);
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Add PartNo in result grid table : " +  partNoManuf);
			}
			
		}

		public void addproddescToResultsGrid(String ProdDescription) {
			String addsproddesc = "//table[@id='gridPopup']/tbody/tr/td[contains(text(),'" +ProdDescription + "')]";
			try {
				if (isDisplayed(driver, addsproddesc)) {
					clickElement(driver, test, addsproddesc, "Click on search record");
					test.log(LogStatus.PASS, "Add Prod Description in to result grid table : " + ProdDescription);
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Add Prod Description in result grid table : " +  ProdDescription);
			}
			
		}

		public void addprodnameToResultsGrid(String ProductName) {
			String addsprodname = "//table[@id='gridPopup']/tbody/tr/td[contains(text(),'" +ProductName + "')]";
			try {
				if (isDisplayed(driver, addsprodname)) {
					clickElement(driver, test, addsprodname, "Click on search record");
					test.log(LogStatus.PASS, "Add Product Name in to result grid table : " + ProductName);
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Add Product Name in result grid table : " +  ProductName);
			}
			
		}

		public void addcommtypeToResultsGrid() {
			Wait.waitfor(3);
			String addscommtype = "//table[@id='gridPopup']/tbody/tr[2]/td[1]";
			try {
				if (isDisplayed(driver, addscommtype)) {
					clickElement(driver, test, addscommtype, "Click on search record");
					test.log(LogStatus.PASS, "Add Commodity Type in to result grid table : ");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Add Commodity Type in result grid table : ");
			}
		}

		public void addskunoToResultsGrid() {
			Wait.waitfor(3);
			String addskuno = "//table[@id='gridPopup']/tbody/tr[2]/td[1]";
			try {
				if (isDisplayed(driver, addskuno)) {
					clickElement(driver, test, addskuno, "Click on search record");
					test.log(LogStatus.PASS, "Add SKU No in to result grid table : ");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Add SKU No in result grid table : ");
			}			
		}

		public void addmodelnoToResultsGrid() {
			Wait.waitfor(3);
			String addmodelno = "//table[@id='gridPopup']/tbody/tr[2]/td[1]";
			try {
				if (isDisplayed(driver, addmodelno)) {
					clickElement(driver, test, addmodelno, "Click on search record");
					test.log(LogStatus.PASS, "Add Model No in to result grid table : ");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Add Model No in result grid table : ");
			}			
		}

		public void addnationalstocknoToResultsGrid() {
			Wait.waitfor(3);
			String addnationalstockno = "//table[@id='gridPopup']/tbody/tr[2]/td[1]";
			try {
				if (isDisplayed(driver, addnationalstockno)) {
					clickElement(driver, test, addnationalstockno, "Click on search record");
					test.log(LogStatus.PASS, "Add National Stock  No in to result grid table : ");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Add National Stock No in result grid table : ");
			}	
		}

		public void addmanufpartnoToResultsGrid(String ManufPartNo) {			
			Wait.waitfor(3);
			String addmanufpartno = "//table[@id='gridPopup']/tbody/tr/td[contains(text(),'" + ManufPartNo + "')]";
			try {
				if (isDisplayed(driver, addmanufpartno)) {
					clickElement(driver, test, addmanufpartno, "Click on search record");
					test.log(LogStatus.PASS, "Add Manufacturer Part  No in to result grid table : " +ManufPartNo);
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Add Manufacturer Part No in result grid table : " +ManufPartNo);
			}		
		}

		public void addmanufToResultsGrid() {
			Wait.waitfor(3);
			String addmanuf = "//table[@id='gridPopup']/tbody/tr[2]/td[1]";
			try {
				if (isDisplayed(driver, addmanuf)) {
					clickElement(driver, test, addmanuf, "Click on search record");
					test.log(LogStatus.PASS, "Add Manufacturer in to result grid table : ");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Add Manufacturer in result grid table : ");
			}
			
		}

		public void addstatusToResultsGrid() {
			Wait.waitfor(3);
			String addstatus = "//table[@id='gridPopup']/tbody/tr[2]/td[1]";
			try {
				if (isDisplayed(driver, addstatus)) {
					clickElement(driver, test, addstatus, "Click on search record");
					test.log(LogStatus.PASS, "Add Status in to result grid table : ");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Add status in result grid table : ");
			}
			
		}

		public void addsortbyToResultsGrid() {
			Wait.waitfor(3);
			String addsortby = "//table[@id='gridPopup']/tbody/tr[2]/td[1]";
			try {
				if (isDisplayed(driver, addsortby)) {
					clickElement(driver, test, addsortby, "Click on search record");
					test.log(LogStatus.PASS, "Add Sort By in to result grid table : ");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Add Sort By in result grid table : ");
			}
			
		}

		public void adddirectionToResultsGrid() {
			Wait.waitfor(3);
			String adddir = "//table[@id='gridPopup']/tbody/tr[2]/td[1]";
			try {
				if (isDisplayed(driver, adddir)) {
					clickElement(driver, test, adddir, "Click on search record");
					test.log(LogStatus.PASS, "Add Direction in to result grid table : ");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Add Direction in result grid table : ");
			}
		}	
		
		
		public void enter_ImportClassif(String ImpClassification) {
			typeText(driver, test, OCR_ImportClassif, "Enter Import Classification", ImpClassification);
		}

		public void addimpclassifToResultsGrid() {
			Wait.waitfor(3);
			String addimpclassif = "//table[@id='gridPopup']/tbody/tr[2]/td[1]";
			try {
				if (isDisplayed(driver, addimpclassif)) {
					clickElement(driver, test, addimpclassif, "Click on search record");
					test.log(LogStatus.PASS, "Add Import Classification in to result grid table : ");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Add Import Classification in result grid table : ");
			}
			
		}
		
		public void enter_StatClassif(String StatClassification) {
			clickElement(driver, test, OCR_StatClassif, "Click on Statistical Classification");
			Wait.waitfor(3);
			String parentWindowHandle = driver.getWindowHandle();
			System.out.println("Parent window's handle -> " + parentWindowHandle);
			Wait.waitfor(3);
			typeText(driver, test, OCR_StatClassifHS, "Enter Stat HS Classification", StatClassification);
			Wait.waitfor(3);
			clickElement(driver, test, OCR_Search, "Click on Search Button");
			Wait.waitfor(3);
			String addstatclassif = "//table[@id='gridPopup']/tbody/tr[2]/td[1]";
			try {
				if (isDisplayed(driver, addstatclassif)) {
					clickElement(driver, test, addstatclassif, "Click on search record");
					test.log(LogStatus.PASS, "Add Statistical HS Code in to result grid table : ");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Add Statistical HS Code in result grid table : ");
			}
			clickElement(driver, test, OCR_Select, "Click on Select Button");
		}

		public void addstatclassifToResultsGrid() {			
			String addstatclassif = "//table[@id='gridPopup']/tbody/tr[2]/td[1]";
			try {
				if (isDisplayed(driver, addstatclassif)) {
					clickElement(driver, test, addstatclassif, "Click on search record");
					test.log(LogStatus.PASS, "Add Statistical Classification in to result grid table : ");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Add Statistical Classification in result grid table : ");
			}
			
		}
		public void enter_ExpClassif(String ExpClassification) {
		//	clickElement(driver, test, OCR_ExpClassif, "Click on Statistical Classification");
		//	Wait.waitfor(3);
		//	String parentWindowHandle = driver.getWindowHandle();
			//System.out.println("Parent window's handle -> " + parentWindowHandle);
		//	Wait.waitfor(3);
			typeText(driver, test, OCR_ExpClassifECCN, "Enter Export Classification ECCN ", ExpClassification);
		//	Wait.waitfor(3);
			//clickElement(driver, test, OCR_Search, "Click on Search Button");
			Wait.waitfor(3);
		//	String addexpclassif = "//table[@id='gridPopup']/tbody/tr[2]/td[1]";
		//	try {
		//		if (isDisplayed(driver, addexpclassif)) {
		//			clickElement(driver, test, addexpclassif, "Click on search record");
		//			test.log(LogStatus.PASS, "Add Statistical HS Code in to result grid table : ");
		//		}
		//	} catch (Exception e) {
		//		testFailSshot(driver, test);
		//		test.log(LogStatus.FAIL, "Fail to Add Statistical HS Code in result grid table : ");
			//}
			//clickElement(driver, test, OCR_Select, "Click on Select Button");
		}
		
		public void addexpclassifToResultsGrid() {
			Wait.waitfor(3);
			String addexclassif = "//table[@id='gridPopup']/tbody/tr[2]/td[1]";
			try {
				if (isDisplayed(driver, addexclassif)) {
					clickElement(driver, test, addexclassif, "Click on search record");
					test.log(LogStatus.PASS, "Add Export Classification in to result grid table : ");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Add Export Classification in result grid table : ");
			}
}
}
		

