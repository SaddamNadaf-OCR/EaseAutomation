package regressionTestingGlobalProduct;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import productClasses.EditProductPage;
import productClasses.HomePageProduct;
import productClasses.ResultProductSearchPage;
import productClasses.SearchProductPage;
import utilities.Utility;
import utilities.Wait;

public class EditProduct extends SeleniumTestBase {
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("EditProduct", excel);
	}

	@Test(dataProvider = "getData") 

	public void Edit_Product(String Testcase,String RunMode,String SBU, String PartNo, String Description) throws Exception {

		// ******************************** Objects Creation *******************************************

		SearchProductPage productsearch = new SearchProductPage(driver, test);
		ResultProductSearchPage result = new ResultProductSearchPage(driver, test);
		HomePageProduct home = new HomePageProduct(driver,test);
		EditProductPage edit= new EditProductPage(driver,test);

		// ******************************************** Test steps execution ***************************
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel))
			{
				throw new SkipException("Skipping the test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					home.moveTo_SBUSelection(SBU);
					home.movetoFiles();
					productsearch.searchthroughpartno(PartNo);			
					productsearch.click_ProductSearch();
					result.edit_product();
					edit.displayOfTitle();
					edit.edit_description(Description);
					Wait.waitfor(5);
					home.returnToSearchProductPage();
				}else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		}catch(SkipException s) {
			test.log(LogStatus.INFO, Testcase);
			test.log(LogStatus.SKIP,"Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();			
			e.printStackTrace();
			home.returnToSearchProductPage();
			Assert.assertTrue(false);
		}
	}	
}



