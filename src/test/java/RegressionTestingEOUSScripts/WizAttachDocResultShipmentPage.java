package RegressionTestingEOUSScripts;


import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.ResultShipmentPage;



import globalExportClasses.ShipmentWizardPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class WizAttachDocResultShipmentPage extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("WizAttachDocResultShipmentPage", excel);
	}

	@Test(dataProvider = "getData")
	public void ShipmentWizard(String Testcase, String RunMode, String SBU, String ShipmentNumber,
			String DocumentType, String UploadfileName, String DocumentLocationPath) throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentWizardPage ShipWiz = new ShipmentWizardPage(driver, test);
			ResultShipmentPage result = new ResultShipmentPage(driver, test);
		
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.featuresShippingTrans();
					HGExport.click_ShipWizard();
					ShipWiz.type_ShipmentByShipmentNo(ShipmentNumber);
					Wait.waitfor(3);
					ShipWiz.click_search();	
					Wait.waitfor(10);
					
					result.attachIcon();
					Wait.waitfor(5);
					result.add_Documentwiz(DocumentType, UploadfileName, DocumentLocationPath);
					
					Wait.waitfor(2);
					HGExport.return_ExportHome();
					
					
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
			e.printStackTrace();
			testFail();
			HGExport.return_ExportHome();
			Assert.assertTrue(false);
		}
	
	}

}
