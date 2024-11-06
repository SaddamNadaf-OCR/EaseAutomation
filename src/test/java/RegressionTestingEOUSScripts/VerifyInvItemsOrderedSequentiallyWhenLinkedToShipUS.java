package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.CreatShipmentPage;

import globalExportClasses.CreateNewShipmentPage;
import globalExportClasses.EditEEITransactionsItemsPage;
import globalExportClasses.EditElectronicExportInformationTransactionsPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.OrderConsolidationPage;
import globalExportClasses.ResultShipmentPage;
import globalExportClasses.ShipmentPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class VerifyInvItemsOrderedSequentiallyWhenLinkedToShipUS extends SeleniumTestBase{
	

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("VerifyShipInvItemInSequence", excel);
	}

	@Test(dataProvider = "getData")
	public void OrderConsolidation(String Testcase, String RunMode, String SBU, String shipToLink, String billToLink, String SelectInv,
			String ShipNumber, String ExporterCode) {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		OrderConsolidationPage OrderCons = new OrderConsolidationPage(driver, test);
		CreatShipmentPage Create_Shp = new CreatShipmentPage(driver, test);
		CreateNewShipmentPage Create_NewShp = new CreateNewShipmentPage(driver, test);
		ShipmentPage Shipment = new ShipmentPage(driver, test);
		ResultShipmentPage Result_Shp = new ResultShipmentPage(driver, test);
		EditElectronicExportInformationTransactionsPage EditEEI = new EditElectronicExportInformationTransactionsPage(driver, test);
		EditEEITransactionsItemsPage EditEEIItem = new EditEEITransactionsItemsPage(driver, test);
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					
					HGExport.OCR_HomePage_OrderConsolidation();
					OrderCons.search_ShipToCode(shipToLink);
					OrderCons.search_BillToCode(billToLink);
					OrderCons.searchBtn();
					OrderCons.selectMultiInvoice(SelectInv);
					OrderCons.addShipment();
					Create_Shp.create_Shp();
//					Create_NewShp.shipHeaderInfo(ShipNumber, ExporterCode);
					Create_NewShp.click_SaveBtn();
//					Create_NewShp.InterCompanyTransfer();
					Create_NewShp.click_SaveBtn();
					String ShipNO = Create_NewShp.get_shipmentID();
					Create_NewShp.select_CustomsFilingView();
					EditEEI.NextArrowCustFilingView();
					EditEEIItem.itemOrder();
					
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
			HGExport.return_ExportHome();
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

}
