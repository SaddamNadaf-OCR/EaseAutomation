package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.HomeGExportPage;
import globalExportClasses.SearchAuthorizationInformationReportPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class SearchAuthorizationInformationReportUS extends SeleniumTestBase{
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AuthInfoReport", excel);
	}

	@Test(dataProvider = "getData")
	public void AuthInfoReport(String Testcase, String RunMode, String SBU, String sbu, String AuthNo, String AuthTypeLink, 
			String AuthType, String AuthStatus, String Agency, String Program, String RefNo, String ContractNo, String FromDate, 
			String EndDate, String UltConsingnee, String Country, String EndUser, String SbuCode, String PartNo, String ItemValue, 
			String Description  ) {
		
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SearchAuthorizationInformationReportPage AuthInfoReport = new SearchAuthorizationInformationReportPage(driver,test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.moveToReports();
					HGExport.AuthorizationReport();
					HGExport.AuthInfo();
					AuthInfoReport.selectSBU(sbu);
				//	AuthInfoReport.authNo(AuthNo);   //
				//	AuthInfoReport.enterAuthType(AuthTypeLink, AuthType);  //
				//	AuthInfoReport.authStatus(AuthStatus);                 //
					AuthInfoReport.SearchByParameter(AuthNo,AuthTypeLink,AuthType,AuthStatus,Agency,Program,RefNo,ContractNo,FromDate,EndDate,
							UltConsingnee,Country,EndUser,SbuCode,PartNo,ItemValue,Description);
					AuthInfoReport.SearchBtn();
					AuthInfoReport.validateHeading();
					
				
				} else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			HGExport.return_ExportHome();
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}



	



}
