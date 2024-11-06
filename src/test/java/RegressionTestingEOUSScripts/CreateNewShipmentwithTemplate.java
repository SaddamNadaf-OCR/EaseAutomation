package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import globalExportClasses.CreatShipmentPage;
import globalExportClasses.CreateNewShipmentPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.ShipmentPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class CreateNewShipmentwithTemplate extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("createShipmentwithTemplate", excel);
	}

	@Test(dataProvider = "getData")
	public void createShipmentwithTemplate(String Testcase, String RunMode, String SBU, String SBUcode,
			String ShipmentTemplate, String ShipmentNo) throws Exception {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentPage Shipment = new ShipmentPage(driver, test);
		CreatShipmentPage CreatShip = new CreatShipmentPage(driver, test);
		CreateNewShipmentPage CreateNewShp = new CreateNewShipmentPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.featuresShippingTrans();
					HGExport.click_shipments();
					Shipment.click_AddShipment();
					CreatShip.selectSBUcode(SBUcode);

					Wait.waitfor(2);
					CreatShip.createshipmentwithtemplate(ShipmentTemplate);
					Wait.waitfor(2);
					CreatShip.create_Shp();
					CreateNewShp.Shipment_NoAdd(ShipmentNo);
					Wait.waitfor(2);
					CreateNewShp.ShipmentSave();
					Wait.waitfor(2);

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
			Assert.assertTrue(false);

		}
	}
	
	
		
			
	}

