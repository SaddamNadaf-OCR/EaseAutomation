package smokeTestingCommonScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;


import filesClasses.CreateNewProductLinesPage;
import filesClasses.HomePage;


import filesClasses.SearchProductLinesPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class CreateNewProductLines extends SeleniumTestBase{
	
	

	@DataProvider
	public Object[][] getData(){
		return Utility.getData("CreateNewProductLine", excel);
		
	}
	
	@Test(dataProvider = "getData")
	public void CreateNewProductLine(String Testcase, String RunMode, String SBU,String ProductLineID, String ProductFamilyID, String ProductLineName, String Category,String ECCN_USML) {
		
		HomePage homepage=new HomePage(driver,test);
		SearchProductLinesPage searchpage=new SearchProductLinesPage(driver,test);
		CreateNewProductLinesPage CreatePage=new CreateNewProductLinesPage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetoProductLines();
					searchpage.addProductLines();
					CreatePage.enterProductLineID(ProductLineID, ProductFamilyID, ProductLineName, Category, ECCN_USML);
					CreatePage.saveandReturn();
					homepage.returnToGExportHomePage();
					
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
