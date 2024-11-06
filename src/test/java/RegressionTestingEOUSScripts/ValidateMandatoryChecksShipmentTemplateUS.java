package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.CreateNewShipmentTemplatePage;
import globalExportClasses.CreateShipmentTemplatePage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.ShipmentTemplatePage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class ValidateMandatoryChecksShipmentTemplateUS extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ValidateMandatoryChecksShipTemp", excel);
	}

	@Test(dataProvider = "getData")
	public void ValidatemandatoryChecksShipmentTemplate(String Testcase, String RunMode, String SBU, String SBUCode) {
		
		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ShipmentTemplatePage ShipTemp = new ShipmentTemplatePage(driver, test);
		CreateShipmentTemplatePage CreateShipTemp = new CreateShipmentTemplatePage(driver, test);
		CreateNewShipmentTemplatePage CreateNewShipTemp = new CreateNewShipmentTemplatePage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.Shipment();
					ShipTemp.addShipmentTemplateBtn();
					CreateShipTemp.select_SBUCode(SBUCode);
					CreateShipTemp.createShipTemplate();
					
					CreateNewShipTemp.click_SaveBtn();
					CreateNewShipTemp.validateMandatoryChecks();

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
	
	
	
	


