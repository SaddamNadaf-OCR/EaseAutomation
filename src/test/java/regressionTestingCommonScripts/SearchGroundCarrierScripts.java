package regressionTestingCommonScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import filesClasses.HomePage;

import filesClasses.ResultGroundCarrierPage;
import filesClasses.SearchGroundCarrierPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

@Test
public class SearchGroundCarrierScripts extends  SeleniumTestBase {
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("SearchGroundCarrier", excel);
		
	}
	
	@Test(dataProvider = "getData")
	public void SearchProgram(String Testcase, String RunMode, String SBU, String sbu, String Code, String Name, String status, String Createdby, String SortBy, String direction) {
		HomePage homepage=new HomePage(driver,test);
		SearchGroundCarrierPage searchpage=new SearchGroundCarrierPage(driver,test);
		ResultGroundCarrierPage GroundCarrierTitle=new ResultGroundCarrierPage(driver,test);
		
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homepage.moveTo_SBUSelectionEO(SBU);
					homepage.movetoGroundCarrier();
					Wait.waitfor(4);
					searchpage.searchbyParameters(sbu, Code, Name, status, Createdby, SortBy, direction);
					searchpage.searchbutton();
					GroundCarrierTitle.ResultGroundCarrierTableIsDisplayed();
					Wait.waitfor(2);
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


