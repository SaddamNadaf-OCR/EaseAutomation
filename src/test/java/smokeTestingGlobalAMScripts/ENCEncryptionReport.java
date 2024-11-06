package smokeTestingGlobalAMScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.ENCENCRYPTIONREPORTPage;
import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.SearchENCEncryptionReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ENCEncryptionReport extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("ENCEncryptionReport", excel);
	}
	
	@Test(dataProvider="getData")
	public void eNCEncryptionReport(String TestCases, String RunMode, String SBU, String SBUCode, String ShipmentWorkStatus, 
			String shipmentNo, String ExporterCode, String DateOfExportFrom, String DateOfExportTo, String ECCNCategory, 
			String ProductFamily, String Program, String UltimateConsignee, String CountrysOfUltDestination, String Region, 
			String Site, String PartNo) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		SearchENCEncryptionReportPage search = new SearchENCEncryptionReportPage(driver, test);
		ENCENCRYPTIONREPORTPage report = new ENCENCRYPTIONREPORTPage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.click_ENCExceptionReports();
					search.searchByAllParameters(SBUCode, ShipmentWorkStatus, shipmentNo, ExporterCode, DateOfExportFrom,
							DateOfExportTo, ECCNCategory, ProductFamily, Program, UltimateConsignee, CountrysOfUltDestination, Region, Site, PartNo);
					
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