package smokeTestingGlobalAMScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.LICENSEEXCEPTIONSSUMMARYPage;
import authorizationManagementClasses.SearchLicenseExceptionSummary;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class LicenseExceptionSummary extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("LicenseExceptionSummary", excel);
	}
	
	@Test(dataProvider="getData")
	public void licenseExceptionSummary(String TestCases, String RunMode, String SBU, String SBUCode, String ShipmentWorkStatus, 
			String Exemption, String ExemptionDescription, String DateOfExportFrom, String DateOfExportTo, String ExporterCode, 
			String ExporterName, String shipmentNo, String SalesOrderNo, String ECCNCategory, String UltimateConsignee, 
			String CountrysOfUltDestination, String PartNo) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		SearchLicenseExceptionSummary search = new SearchLicenseExceptionSummary(driver, test);
		LICENSEEXCEPTIONSSUMMARYPage report = new LICENSEEXCEPTIONSSUMMARYPage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.click_AESummaryReports();
					search.searchByAllParameters(SBUCode, ShipmentWorkStatus, Exemption, ExemptionDescription, DateOfExportFrom, 
							DateOfExportTo, ExporterCode, ExporterName, shipmentNo, SalesOrderNo, ECCNCategory, UltimateConsignee, 
							CountrysOfUltDestination, PartNo);
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