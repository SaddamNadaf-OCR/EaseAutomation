package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import globalExportClasses.CreateNewElectronicExportInformationTransactionsPage;
import globalExportClasses.CreateNewShipmentPage;
import globalExportClasses.ElectronicExportInformationTransactionsPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.ResultElectronicExportInformationTransactionsPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class VerifyWorkStatusOfShipmentAndEEIIsSameUS extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ValidateWorkStatusEEIShip", excel);
	}

	@Test(dataProvider = "getData")
	public void VerifyWorkStatusOfEEIAndShipment(String Testcase, String RunMode, String SBU, String SBUCode,
			String ExportCode, String ShipmentWorkStatus, String ShipNumber, String ExportApproved, String ShipmentApproved,
			String FrieghtForwarder, String Shipped) {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ElectronicExportInformationTransactionsPage EEI = new ElectronicExportInformationTransactionsPage(driver, test);
		CreateNewElectronicExportInformationTransactionsPage createEEIT = new CreateNewElectronicExportInformationTransactionsPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);
		ResultElectronicExportInformationTransactionsPage ResultEEI = new ResultElectronicExportInformationTransactionsPage(driver, test);
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.CustomsFiling();
					EEI.searchEEIT(SBUCode, ExportCode, ShipmentWorkStatus, "", "", "", "");
					EEI.shipmentNo(ShipNumber);
					EEI.clickSearch();
					ResultEEI.click_ShipNumber();
					CreateNewShp.getShipNo();
					String shipNo = CreateNewShp.getShipNo();
					CreateNewShp.get_shipmentStatus();
					String shipStatus = CreateNewShp.get_shipmentStatus();
					createEEIT.select_ShipmentDetails();
					createEEIT.changeStatusToExportApproved(ExportApproved);
					Wait.waitfor(20);
					createEEIT.changeStatusToShipmentApproved(ShipmentApproved);
					Wait.waitfor(20);
					createEEIT.changeStatusToFreightForwarder(FrieghtForwarder);
					Wait.waitfor(20);
					createEEIT.changeStatusToShipped(Shipped);
					Wait.waitfor(10);
					CreateNewShp.getShipNo();
					String shipNum = CreateNewShp.getShipNo();
					CreateNewShp.get_shipmentStatus();
					String shipStat = CreateNewShp.get_shipmentStatus();
					CreateNewShp.customFilingView();
					CreateNewShp.getShipNo();
					String shipNumber = CreateNewShp.getShipNo();
					CreateNewShp.get_shipmentStatus();
					String shipmentStatus = CreateNewShp.get_shipmentStatus();

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
