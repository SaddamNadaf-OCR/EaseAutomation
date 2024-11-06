package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.CreateElectronicExportInformationTransactionsPage;
import globalExportClasses.CreateNewElectronicExportInformationTransactionsPage;
import globalExportClasses.CreateNewOrderItemPage;
import globalExportClasses.CreateNewShipmentPage;
import globalExportClasses.EditElectronicExportInformationTransactionsPage;
import globalExportClasses.EditShipmentItemsPage;
import globalExportClasses.EditShipmentReviewerDetailsPage;
import globalExportClasses.ElectronicExportInformationTransactionsPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.ResultElectronicExportInformationTransactionsPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;
import vmsClasses.LoginPage;

public class ValidateProcessOfAESStatusUS extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("SEDRequestToBeReported", excel);
	}

	@Test(dataProvider = "getData")
	public void VerifyAESStatusToBeReported(String Testcase, String RunMode, String SBU, String SBUCode,
			String ShipmentWorkStatus, String ShipNumber, String ExportApproved, String ShipmentApproved,
			String Cancelled) {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ElectronicExportInformationTransactionsPage EEI = new ElectronicExportInformationTransactionsPage(driver, test);
		CreateElectronicExportInformationTransactionsPage create = new CreateElectronicExportInformationTransactionsPage(
				driver, test);
		CreateNewElectronicExportInformationTransactionsPage createEEIT = new CreateNewElectronicExportInformationTransactionsPage(
				driver, test);
		EditElectronicExportInformationTransactionsPage edit = new EditElectronicExportInformationTransactionsPage(
				driver, test);
		EditShipmentItemsPage itemPage = new EditShipmentItemsPage(driver, test);
		CreateNewOrderItemPage additem = new CreateNewOrderItemPage(driver, test);
		EditShipmentReviewerDetailsPage ReviewerDetails = new EditShipmentReviewerDetailsPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		ResultElectronicExportInformationTransactionsPage ResultEEI = new ResultElectronicExportInformationTransactionsPage(
				driver, test);
		LoginPage login = new LoginPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.CustomsFiling();
//					EEI.searchEEI(SBUCode, "", ShipmentWorkStatus, "", "", "", "");
					EEI.shipmentNo(ShipNumber);
					EEI.clickSearch();
					ResultEEI.click_ShipNumber();
					// CreateNewShp.getShipNo();
					// String shipNo = CreateNewShp.getShipNo();
					// CreateNewShp.get_shipmentStatus();
					// String shipStatus = CreateNewShp.get_shipmentStatus();
					createEEIT.select_ShipmentDetails();
					createEEIT.changeStatusToExportApproved(ExportApproved);
					Wait.waitfor(20);
					createEEIT.changeStatusToShipmentApproved(ShipmentApproved);
					Wait.waitfor(20);
					CreateNewShp.customFilingView();
					createEEIT.changeAES(Cancelled);
					createEEIT.Savebutton();

					Wait.waitfor(3);
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
			testFail();
			e.printStackTrace();
			HGExport.return_ExportHome();
			Assert.assertTrue(false);
		}
	}

}
