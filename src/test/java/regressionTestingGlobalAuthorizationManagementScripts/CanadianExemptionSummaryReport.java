package regressionTestingGlobalAuthorizationManagementScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.CANADIANEXEMPTIONSSUMMARYPage;
import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.SearchCanadianExemptionSummaryPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class CanadianExemptionSummaryReport extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("CanadianExemptionSummaryReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void canadianExemptionSummaryReport(String TestCases, String RunMode, String SBU, String SBUCode, 
			String CanadianExemptionNo, String ShipmentWorkStatus, String CountryofUltimateDestination, String CanadianExemptionDescription, 
			String DateOfExportFrom, String DateOfExportTo, String ExporterCode, String ExporterName, String shipmentNo, String SalesOrderNo, 
			String USMLCategory, String UltimateConsignee, String PartNo) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		SearchCanadianExemptionSummaryPage search = new SearchCanadianExemptionSummaryPage(driver, test);
		CANADIANEXEMPTIONSSUMMARYPage report = new CANADIANEXEMPTIONSSUMMARYPage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.click_CanadianExemptionSummaryReports();
					search.searchByAllParameters(SBUCode, CanadianExemptionNo, ShipmentWorkStatus, 
							CountryofUltimateDestination, CanadianExemptionDescription, DateOfExportFrom, 
							DateOfExportTo, ExporterCode, ExporterName, shipmentNo, SalesOrderNo, USMLCategory, UltimateConsignee, PartNo);
					search.search();
					Wait.waitfor(5);
					report.titleIsDisplayed();
					homePage.returnTomoduleSelection();
				}else {
					testFail();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			homePage.returnTomoduleSelection();
			testFail();
		}
	}
}