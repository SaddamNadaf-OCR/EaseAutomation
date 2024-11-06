package smokeTestingGlobalEOScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import globalExportClasses.CreateNewPackingListPage;
import globalExportClasses.CreatePackingListPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.PackingListPage;
import globalExportClasses.ResultPackingListPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class CreatePackingList extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("CreatePackingList", excel);
	}

	@Test(dataProvider = "getData")
	public void PackingList(String Testcase, String RunMode, String SBU, String PackListNo, String exporterCode,
			String ExporterStatus, String ExporterCountry, String shipmentNo, String UltConsigneeCode,
			String AirCarrierCode) {
		
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		PackingListPage PL = new PackingListPage(driver, test);
		CreatePackingListPage Create_PL = new CreatePackingListPage(driver, test);
		CreateNewPackingListPage Create_NewPL = new CreateNewPackingListPage(driver, test);
		ResultPackingListPage ResultPL = new ResultPackingListPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.OCR_HomePage_PackingList();
					PL.addPackingList();
					Create_PL.create_packingList();
					Create_NewPL.createNewpackingList_GeneralInfo(PackListNo, exporterCode, ExporterStatus,
							ExporterCountry, shipmentNo);
					Create_NewPL.ultimateConsignee(UltConsigneeCode);
					Create_NewPL.airCarrier(AirCarrierCode);
					Create_NewPL.save();
					String PList = Create_NewPL.get_PackingListNo();
					Create_NewPL.saveAndReturn();
					PL.enter_PackingListNo(PList);
					PL.search();
					ResultPL.click_PLNo(PList);
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
