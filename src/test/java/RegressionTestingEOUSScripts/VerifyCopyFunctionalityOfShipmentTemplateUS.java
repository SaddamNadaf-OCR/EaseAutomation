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

public class VerifyCopyFunctionalityOfShipmentTemplateUS extends SeleniumTestBase{
	
	@DataProvider
	public Object[][] getData() {
		return Utility.getData("CopyShipmentTemplate", excel);
	}

	@Test(dataProvider = "getData")
	public void VerifyCopyFunctionalityOfShipmentTemplate(String Testcase, String RunMode, String SBU, String TemplateName,
			String UltDest, String templateIDLink, String ExporterCode, String ConsigneeId, String FFCode) {
		
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
					ShipTemp.copyTemplate();
					CreateNewShipTemp.enter_TemplateName(TemplateName);
//					CreateNewShipTemp.enter_Destination(UltDest);
//					CreateNewShipTemp.select_TemplateIDLink(templateIDLink);
//					CreateNewShipTemp.PartiesToTheTransaction(ExporterCode, ConsigneeId, FFCode);
					CreateNewShipTemp.click_SaveBtn();
					CreateNewShipTemp.getShipMentTemplateID();
					String shipmentID = CreateNewShipTemp.getShipMentTemplateID();
					CreateNewShipTemp.closeBtn();
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
	

