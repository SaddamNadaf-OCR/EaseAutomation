package smokeTestingCommonScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import filesClasses.HomePage;

import filesClasses.SearchSegmentPage;
import filesClasses.createNewSegmentPage;
import initializer.SeleniumTestBase;


import utilities.Utility;

public class createNewSegment extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("createSegment", excel);
		
	}
	
	@Test(dataProvider = "getData")
	public void createSegment(String Testcase, String RunMode, String SBU, String SegmentCode, String SegmentName) {
		
		HomePage homepage=new HomePage(driver,test);
		SearchSegmentPage searchpage=new SearchSegmentPage(driver,test);
		createNewSegmentPage CreatePage=new createNewSegmentPage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetoSegment();
					searchpage.addProgram();
					CreatePage.enterSegmentCode(SegmentCode,SegmentName);
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
