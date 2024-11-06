package regressionTestingCommonScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import filesClasses.CreateNewProductFamilyPage;
import filesClasses.HomePage;


import filesClasses.SearchProductFamilyPage;


import initializer.SeleniumTestBase;
import utilities.Utility;

public class CreateNewProductFamily extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("CreateProductFamily", excel);
		
	}
	
	@Test(dataProvider = "getData")
	public void CreateProductFamily(String Testcase, String RunMode, String SBU,String ProductFamilyID, String ProductFamilyName) {
		
		HomePage homepage=new HomePage(driver,test);
		SearchProductFamilyPage searchpage=new SearchProductFamilyPage(driver,test);
		CreateNewProductFamilyPage CreatePage=new CreateNewProductFamilyPage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetoProductFamily();
					searchpage.addProgram();
					CreatePage.enterProductFamilyID(ProductFamilyID,ProductFamilyName);
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
