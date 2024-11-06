package RegressionTestingEOUSScripts;
/* 
 * Module : Export Operation
 * Author  : Saddam
 * created date : July 2024
 * Descriptions : Verify Late Filling Warning Msg
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
import globalExportClasses.CreateNewShipmentPage;
import globalExportClasses.EditElectronicExportInformationTransactionsPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.ResultShipmentPage;
import globalExportClasses.ShipmentPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class LateFillingWarningMsg extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("LateFillingWarningMsg", excel);
	}

	@Test(dataProvider = "getData")
	public void verifytheinvoicelineitemlevellicensevalidation(String Testcase, String RunMode, String SBU, String shipNum, 
			String ShipWorkStatus, String AES, String AESOption) {

		HomeGExportPage HGExport 		= new HomeGExportPage(driver, test);
		ShipmentPage searchShipment 	= new ShipmentPage(driver, test);
		ResultShipmentPage resultpage	= new ResultShipmentPage(driver, test);
		CreateNewShipmentPage create	= new CreateNewShipmentPage(driver, test);
		EditElectronicExportInformationTransactionsPage customFV = new EditElectronicExportInformationTransactionsPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.featuresShippingTrans();
					HGExport.click_shipments();
					searchShipment.enter_ShpNo(shipNum);
					searchShipment.shipworkStatus(ShipWorkStatus);
					searchShipment.shipment_SearchBtn();
					resultpage.click_ShipmentNo(shipNum);
					create.select_CustomsFilingView();
					customFV.AES(AES);
					customFV.AESOption(AESOption);
					customFV.SaveBtn();
					Wait.waitfor(5);
					customFV.alertAccept();
					Wait.waitfor(5);
					customFV.lateFilingErrorMsgValidation();
					Wait.waitfor(2);
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
