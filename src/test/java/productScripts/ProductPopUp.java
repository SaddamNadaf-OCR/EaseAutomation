package productScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import initializer.SeleniumTestBase;
import productClasses.CreateNewProductGeneralInfoPage;
import productClasses.CreateNewProductSubComponentPage;
import productClasses.HomePageProduct;
import productClasses.ProductPopUpPage;
import productClasses.ProductTemplatePage;
import productClasses.SearchProductPage;
import utilities.Utility;
import utilities.Wait;

public class ProductPopUp extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ProductPopup", excel);
	}
	@Test(dataProvider = "getData")		
	public void SearchThroughProductPopup(String Testcase,String RunMode, String ModuleName,String SBU, String Navigation, String Description, 
			String PartNo, String PartNoManuf, String ProdDescription,String ProductName, String CommodityType, String SKUNo, 
			String ModelNo, String NationalStockNo, String ManufPartNo, String Manufacturer, String ImpClassification,
			String StatClassification, String ExpClassification,String Status,String SortBy, String Direction) throws Exception {

		ProductPopUpPage					product      = new ProductPopUpPage(driver, test);
		SearchProductPage					searchPr     = new SearchProductPage(driver, test);
		ProductTemplatePage                 productTemp  = new ProductTemplatePage(driver, test);
		CreateNewProductGeneralInfoPage     generalInfo  = new CreateNewProductGeneralInfoPage(driver, test);		
		HomePageProduct                     home         = new HomePageProduct(driver,test);
		CreateNewProductSubComponentPage    subcomp      = new CreateNewProductSubComponentPage(driver, test);


		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);				
				home.moveTo_SBUSelection(SBU);
					Wait.waitfor(3);
					if(Navigation.contains("Files")) {
						home.movetoFiles();
						Wait.waitfor(3);
						searchPr.clickAddProduct();
						Wait.waitfor(3);
						
						generalInfo.enter_description(Description);
						generalInfo.save();
						Wait.waitfor(5);
						generalInfo.movetosubcomponenttab();
						Wait.waitfor(5);
						subcomp.click_subcomppartno();
						Wait.waitfor(5);
						//subcomp.click_partno();
						//Wait.waitfor(5);
						
						if(PartNo.length()>0) {
							product.enter_PartNo(PartNo);
							product.search();
							Wait.waitfor(3);
							product.addpartnoToResultsGrid(PartNo);
							Wait.waitfor(5);
							product.select();
							Wait.waitfor(3);
						}
					/*	Wait.waitfor(5);
						if(PartNoManuf.length()>0) {
							product.enter_PartNoManuf(PartNoManuf);
							product.search();
							Wait.waitfor(3);
							product.addpartnomanufToResultsGrid(PartNoManuf);
							Wait.waitfor(3);
							product.select();*/
						subcomp.click_partno();
						Wait.waitfor(5);
						}
						if(ProdDescription.length()>0) {
							product.enter_Description(ProdDescription);
							product.search();
							Wait.waitfor(10);
							product.addproddescToResultsGrid(ProdDescription);
							Wait.waitfor(10);
							product.select();
							subcomp.click_partno();
							Wait.waitfor(5);
						}
						if(ProductName.length()>0) {
							product.enter_ProductName(ProductName);
							product.search();
							Wait.waitfor(10);
							product.addprodnameToResultsGrid(ProductName);
							Wait.waitfor(10);
							product.select();
							subcomp.click_partno();
							Wait.waitfor(2);
						}
						if(CommodityType.length()>0) {
							product.select_commoditytype(CommodityType);
							product.search();
							Wait.waitfor(10);
							product.addcommtypeToResultsGrid();
							Wait.waitfor(10);
							product.select();
							subcomp.click_partno();
							Wait.waitfor(2);
						}
						if(SKUNo.length()>0) {
							product.enter_SKUNo(SKUNo);
							product.search();
							Wait.waitfor(10);
							product.addskunoToResultsGrid();
							Wait.waitfor(10);
							product.select();
							subcomp.click_partno();
							Wait.waitfor(2);
						}
						if(ModelNo.length()>0) {
							product.enter_ModelNo(ModelNo);
							product.search();
							Wait.waitfor(10);
							product.addmodelnoToResultsGrid();
							Wait.waitfor(10);
							product.select();
							subcomp.click_partno();
							Wait.waitfor(2);
						}
						if(NationalStockNo.length()>0) {
							product.enter_NationalStockNo(NationalStockNo);
							product.search();
							Wait.waitfor(10);
							product.addnationalstocknoToResultsGrid();
							Wait.waitfor(10);
							product.select();
							subcomp.click_partno();
							Wait.waitfor(2);
						}
						if(ManufPartNo.length()>0) {
							product.enter_ManufPartNo(ManufPartNo);
							product.search();
							Wait.waitfor(10);
							product.addmanufpartnoToResultsGrid(ManufPartNo);
							Wait.waitfor(10);
							product.select();
							subcomp.click_partno();
							Wait.waitfor(2);
						}
						if(Manufacturer.length()>0) {
							product.enter_ManufPartNo(Manufacturer);
							product.search();
							Wait.waitfor(10);
							product.addmanufToResultsGrid();
							Wait.waitfor(10);
							product.select();
							subcomp.click_partno();
							Wait.waitfor(2);
						}
						if(ImpClassification.length()>0) {
							product.enter_ImportClassif(ImpClassification);
							product.search();
							Wait.waitfor(10);
							product.addimpclassifToResultsGrid();
							Wait.waitfor(10);
							product.select();
							subcomp.click_partno();
							Wait.waitfor(2);
						}
						if(StatClassification.length()>0) {
							product.enter_StatClassif(StatClassification);
							Wait.waitfor(10);
							product.search();
							Wait.waitfor(10);
							product.addstatclassifToResultsGrid();
							Wait.waitfor(5);
							product.select();
							subcomp.click_partno();
							Wait.waitfor(2);
						}
						if(ExpClassification.length()>0) {
							product.enter_ExpClassif(ExpClassification);
							Wait.waitfor(10);
							product.search();
							Wait.waitfor(10);
							product.addexpclassifToResultsGrid();
							Wait.waitfor(5);
							product.select();
							subcomp.click_partno();
							Wait.waitfor(2);
						}

						if(Status.length()>0) {
							product.select_Status(Status);
							product.search();
							Wait.waitfor(10);
							product.addstatusToResultsGrid();
							Wait.waitfor(10);
							product.select();
							subcomp.click_partno();
							Wait.waitfor(2);
						}
						if(SortBy.length()>0) {
							product.select_SortBy(SortBy);
							product.search();
							Wait.waitfor(10);
							product.addsortbyToResultsGrid();
							Wait.waitfor(10);
							product.select();	
							subcomp.click_partno();
							Wait.waitfor(2);
						}
						if(Direction.length()>0) {
							product.select_Direction(Direction);
							product.search();
							Wait.waitfor(10);
							product.adddirectionToResultsGrid();
							Wait.waitfor(10);
							product.select();	
						}
						home.returnToSearchProductPage();
					}else {
						System.out.println("Navigation is not Files");
					}
				}
			
		}catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			home.returnToSearchProductPage();
			Assert.assertTrue(false);
		}
	}
}

