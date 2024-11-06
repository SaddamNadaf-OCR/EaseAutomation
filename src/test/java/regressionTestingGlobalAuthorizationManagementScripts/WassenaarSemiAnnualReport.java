package regressionTestingGlobalAuthorizationManagementScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.SearchWassenaarSemiAnnualReportPage;
import authorizationManagementClasses.WASSENAARSEMIANNUALREPORTPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class WassenaarSemiAnnualReport extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("WassenaarSemiAnnualReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void wassenaarSemiAnnualReport(String TestCases, String RunMode, String SBU, String SBUCode, String ShipmentWorkStatus, 
			String shipmentNo, String ExporterCode, String DateOfExportFrom, String DateOfExportTo, String ECCNCategory, 
			String Exemption, String ProductFamily, String Program, String UltimateConsignee, String CountrysOfUltDestination, 
			String Region, String Site) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		SearchWassenaarSemiAnnualReportPage search = new SearchWassenaarSemiAnnualReportPage(driver, test);
		WASSENAARSEMIANNUALREPORTPage report = new WASSENAARSEMIANNUALREPORTPage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.click_WassenaarReports();
					search.searchByAllParameters(SBUCode, ShipmentWorkStatus, shipmentNo, ExporterCode, DateOfExportFrom, 
							DateOfExportTo, ECCNCategory, Exemption, ProductFamily, Program, UltimateConsignee, 
							CountrysOfUltDestination, Region, Site);
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