package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.HomeGExportPage;
import globalExportClasses.SearchProductMassControlAuditPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class SearchProductMassControlAuditReportUS extends SeleniumTestBase {

	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ProdMassControlAudit", excel);
	}

	@Test(dataProvider = "getData")
	public void ProdMassCntrllAudit(String Testcase, String RunMode, String SBU, String sbuCode, String Status, 
			String ProductLine, String Country,String NewExpClass, String CurrentExpClass, String ImportClass, String ChangedBy  ) {
		
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SearchProductMassControlAuditPage ProdMassCtrl = new SearchProductMassControlAuditPage(driver,test);
		
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.moveToReports();
					HGExport.auditReports();
					HGExport.CommodityClfChange();
					ProdMassCtrl.serachbyparameter(sbuCode, Status, ProductLine, Country, NewExpClass, CurrentExpClass, ImportClass, ChangedBy);
					ProdMassCtrl.SearchBtn();
					ProdMassCtrl.validateHeading();
					
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
