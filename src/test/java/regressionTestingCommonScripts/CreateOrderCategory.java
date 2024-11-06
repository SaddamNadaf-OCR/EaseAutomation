package regressionTestingCommonScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import filesClasses.CreateNewOrderCategoryPage;
import filesClasses.HomePage;


import filesClasses.SearchOrderCategoryPage;

import initializer.SeleniumTestBase;
import utilities.Utility;

public class CreateOrderCategory extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("AddOrderCategory", excel);
		
	}
	
	@Test(dataProvider = "getData")
	public void AddOrderCategory(String Testcase, String RunMode, String SBU,String OrderCategoryType, String OrderCategoryName) {
		
		HomePage homepage=new HomePage(driver,test);
		SearchOrderCategoryPage searchpage=new SearchOrderCategoryPage(driver,test);
		CreateNewOrderCategoryPage CreatePage=new CreateNewOrderCategoryPage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetoOrderCategory();
					searchpage.addOrderCategoryType();
					CreatePage.enterOrderCategoryType(OrderCategoryType,OrderCategoryName);
					CreatePage.saveandReturn();
					
				} else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		} catch (SkipException s) {
			test.log(LogStatus.INFO, Testcase);
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			homepage.returnToGExportHomePage();
			Assert.assertTrue(false);
		}
	}


}
