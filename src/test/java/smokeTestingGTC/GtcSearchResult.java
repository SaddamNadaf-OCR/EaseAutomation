package smokeTestingGTC;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

import globalTradeControlClasses.GtcHomePage;
import globalTradeControlClasses.ResultTradeCotrolPage;
import globalTradeControlClasses.SearchTradeControlScreeningPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class GtcSearchResult extends SeleniumTestBase{

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("GtcSearch", excel);
	}

	@Test(dataProvider = "getData") 

	public void searchpage(String Testcase,String RunMode,String SBUCode, String ReferenceNo, 
			String ClientReferenceNo, String CountryofExport, String CountryofImport, String Status, String CreatedDateFrom, 
			String CreatedDateTo, String Reviewer, String Manager, String EntityName, String EntityAddress, String PartNo,
			String HSNo, String RecordswithWLShits, String ExportLicenseRequired, String ExemptionRequired, 
			String ReportingRequired, String SortBy, String Direction) throws Exception {

		// ******************************** Objects Creation *******************************************

		GtcHomePage gtchome = new GtcHomePage(driver, test);			
		SearchTradeControlScreeningPage	search = new SearchTradeControlScreeningPage(driver, test);			
		ResultTradeCotrolPage	result = new ResultTradeCotrolPage(driver, test);			

		// ******************************************** Test steps execution ***************************
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel))
			{
				throw new SkipException("Skipping the test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					gtchome.moveTo_GtcListScreening();
					gtchome.clickTo_TradeControlsScreening();
					search.enter_SearchDetails(SBUCode, ReferenceNo, ClientReferenceNo, CountryofExport,
							CountryofImport, Status, CreatedDateFrom, CreatedDateTo, Reviewer, Manager,
							EntityName, EntityAddress, PartNo, HSNo, RecordswithWLShits, ExportLicenseRequired,
							ExemptionRequired, ReportingRequired, SortBy, Direction);
					search.click_GtcSearch();
					result.displayOfTitle();
					gtchome.GtcreturnPage();
					Wait.waitfor(3);
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
			gtchome.GtcreturnPage();
			Assert.assertTrue(false);
		}
	}	
}
