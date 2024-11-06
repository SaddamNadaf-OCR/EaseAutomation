package regressionTestingGlobalAuthorizationManagementScripts;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import authorizationManagementClasses.AddDSP5OffshoreProcurementReportPage;
import authorizationManagementClasses.HomePage_AMPage;
import authorizationManagementClasses.OffshoreProcurementReportsDSP_05Page;
import authorizationManagementClasses.SearchOffshoreProcurementReportDSP_5Page;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class DSP_5OffShoreReport extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("DSP_5OffShoreReportScript", excel);
	}
	
	@Test(dataProvider="getData")
	public void dsp5OffShoreReport(String TestCases,String RunMode,String SBU,String transactionID, String usgOfficer, 
			String usgTitle, String empoweredOfficer, String title, String Exporter, String ddtcCode,String consigneeName, 
			String ReportText, String Remark) {
		
		HomePage_AMPage homePage=new HomePage_AMPage(driver,test);
		SearchOffshoreProcurementReportDSP_5Page search=new SearchOffshoreProcurementReportDSP_5Page(driver,test);
		AddDSP5OffshoreProcurementReportPage addDSP=new AddDSP5OffshoreProcurementReportPage(driver,test);
		OffshoreProcurementReportsDSP_05Page offShore=new OffshoreProcurementReportsDSP_05Page(driver,test);
		
		try {
			if(!Utility.isExecutable(getClass().getSimpleName(), excel)){
				throw new SkipException("Skipping the Test");
			}else {
				if(RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, TestCases);
					homePage.move_to_moduleSelection(SBU);
					homePage.moduleSelection();
					homePage.clickonDSP5Reports();
					search.addshore();
					addDSP.authorizatioNOByTransactionID(transactionID);
					addDSP.createoffShore();
					offShore.offshoredata(usgOfficer, usgTitle, empoweredOfficer, title, Exporter, ddtcCode, 
							consigneeName, ReportText, Remark);
					offShore.save();
				}else {
					testFail();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			testFail();
		}
	}
}
