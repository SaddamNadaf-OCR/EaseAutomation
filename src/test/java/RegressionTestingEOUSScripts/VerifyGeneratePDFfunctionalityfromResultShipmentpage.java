package RegressionTestingEOUSScripts;
/* 
 * Module : Export Operation
 * Author  : Saddam
 * created date : August 2024
 * Descriptions : Verify Generate PDF functionality from Result Shipment page
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
import utilities.Wait;

public class VerifyGeneratePDFfunctionalityfromResultShipmentpage extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("GeneratePDFFunctionality", excel);
	}

	@Test(dataProvider = "getData")
	public void verifyGeneratePDFfunctionalityfromResultShipmentpage(String Testcase, String RunMode, String SBU, String ShipmentNumber) {

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
					shipWizard.type_ShipmentByShipmentNo(ShipmentNumber);
					shipWizard.click_search();
					resultPage.pdfIcon();
					resultPage.generatePopupValidation();
					resultPage.cvinCheckedorNot();
					resultPage.commericialInvoiceEmailIcon();
					resultPage.packingListCheckedorNot();
					resultPage.packinglistEmailIcon();
					resultPage.shipperletterofInstCheckedorNot();
					Wait.waitfor(3);
					resultPage.shipperLetterofInstructionEmailIcon();
					resultPage.straightBillOfladdingCheckedorNot();
					resultPage.straightBillOfLadingEmailIcon();	
					resultPage.pdfclosePopupIcon();
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
