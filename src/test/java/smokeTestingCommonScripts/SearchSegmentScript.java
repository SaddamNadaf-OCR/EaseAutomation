package smokeTestingCommonScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import filesClasses.HomePage;
import filesClasses.ResultSegmentPage;
import filesClasses.SearchSegmentPage;
import initializer.SeleniumTestBase;

import utilities.Utility;
import utilities.Wait;

public class SearchSegmentScript extends SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("SearchSegment", excel);
		
	}
	
	@Test(dataProvider = "getData")
	public void SearchSegment(String TestCases, String RunMode, String SBU,String sbu,String Status, 
			String CreatedBy, String SortBy, String direction, String SegmentCode, String SegmentName) {
		
		HomePage homepage=new HomePage(driver,test);
		SearchSegmentPage searchpage=new SearchSegmentPage(driver,test);
		ResultSegmentPage SegmentTitle=new ResultSegmentPage(driver,test);
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetoSegment();
					Wait.waitfor(4);
					searchpage.searchbyParameters(sbu,Status,CreatedBy,SortBy,direction,SegmentCode,SegmentName);
					searchpage.searchbutton();
					SegmentTitle.ResultSegmentIsDisplayed();
					Wait.waitfor(2);
				
					homepage.returnToGExportHomePage();
				} else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		} catch (SkipException s) {
			test.log(LogStatus.INFO, TestCases);
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
