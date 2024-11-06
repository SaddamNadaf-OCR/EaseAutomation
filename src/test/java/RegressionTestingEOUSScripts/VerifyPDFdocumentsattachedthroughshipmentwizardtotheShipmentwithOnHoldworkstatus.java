package RegressionTestingEOUSScripts;
/* 
 * Module : Export Operation
 * Author  : Saddam
 * created date : August 2024
 * Descriptions : Verify PDF documents attached through shipment wizard to the Shipment with On Hold work status page
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil 
 */
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

public class VerifyPDFdocumentsattachedthroughshipmentwizardtotheShipmentwithOnHoldworkstatus extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("PDFDocAttchToOnHoldShipStatus", excel);
	}

	@Test(dataProvider = "getData")
	public void verifyPDFdocumentsattachedthroughshipmentwizardtotheShipmentwithOnHoldworkstatus(String Testcase, String RunMode, String SBU, 
			String ShipmentStatus, String DocType, String DocDesc, String UploadfileName) {

		HomeGExportPage HGExport 		= new HomeGExportPage(driver, test);
		ShipmentWizardPage shipWizard   = new ShipmentWizardPage(driver, test);
		ResultShipmentPage resultPage   = new ResultShipmentPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.featuresShippingTrans();
					HGExport.click_ShipWizard();
					shipWizard.type_SearchBy("", "", "", ShipmentStatus, "", "", "", "");
					shipWizard.click_search();
					resultPage.attachIcon();
					resultPage.add_Document(DocType, DocDesc, UploadfileName);
					resultPage.uploadsuccessmessage();
					HGExport.return_ExportHome();
				} else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		} catch (SkipException s) {
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
