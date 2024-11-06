package smokeTestingGlobalAMScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.IMPORTSUNDERITAREXEMPTIONSNOTREEXPORTEDPage;
import authorizationManagementClasses.ImportsUnderITARExemptionNotReExportedPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class ImportsUnderITARExemptionNotReExported extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData(){
		return Utility.getData("ImportsUnderITARExempNotReExp", excel);
	}
	
	@Test(dataProvider="getData")
	public void importsUnderITARExemptionNotReExported(String TestCases, String RunMode, String SBU, 
			String importShipmentNo, String ImportDateFrom, String ImportDateTo, String shipperName, 
			String shipperCountryCode, String importLicense, String importItarExemptionNo) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver, test);
		ImportsUnderITARExemptionNotReExportedPage search = new ImportsUnderITARExemptionNotReExportedPage(driver, test);
		IMPORTSUNDERITAREXEMPTIONSNOTREEXPORTEDPage report = new IMPORTSUNDERITAREXEMPTIONSNOTREEXPORTEDPage(driver, test);
				
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.click_ExportsnotReexportedReports();
					search.searchByParameters(importShipmentNo, ImportDateFrom, ImportDateTo, shipperName, 
							shipperCountryCode, importLicense, importItarExemptionNo);
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