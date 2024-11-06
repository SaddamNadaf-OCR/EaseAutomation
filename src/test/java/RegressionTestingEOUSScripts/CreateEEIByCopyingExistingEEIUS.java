package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import globalExportClasses.CreateEEITransactionsTemplatePage;
import globalExportClasses.CreateElectronicExportInformationTransactionsPage;
import globalExportClasses.CreateNewEEITransactionsTemplatePage;
import globalExportClasses.CreateNewElectronicExportInformationTransactionsPage;
import globalExportClasses.CreateNewOrderItemPage;
import globalExportClasses.EEITemplatePage;
import globalExportClasses.EditElectronicExportInformationTransactionsPage;
import globalExportClasses.EditShipmentItemsPage;
import globalExportClasses.ElectronicExportInformationTransactionsPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.ResultElectronicExportInformationTransactionsPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class CreateEEIByCopyingExistingEEIUS extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("CopyEEI", excel);
	}

	@Test(dataProvider = "getData")
	public void CreateEEITemplate(String Testcase, String RunMode, String SBU, String ShipNumber, String ShipmentNo) {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		ElectronicExportInformationTransactionsPage EEI = new ElectronicExportInformationTransactionsPage(driver, test);
		CreateElectronicExportInformationTransactionsPage create = new CreateElectronicExportInformationTransactionsPage(driver, test);
		CreateNewElectronicExportInformationTransactionsPage createEEIT = new CreateNewElectronicExportInformationTransactionsPage(driver, test);
		EditElectronicExportInformationTransactionsPage edit = new EditElectronicExportInformationTransactionsPage(driver, test);
		EditShipmentItemsPage itemPage = new EditShipmentItemsPage(driver, test);
		CreateNewOrderItemPage additem = new CreateNewOrderItemPage(driver, test);
		ResultElectronicExportInformationTransactionsPage ResultEEI = new ResultElectronicExportInformationTransactionsPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.EEI();
				EEI.shipmentNo(ShipNumber);
				EEI.clickSearch();
				ResultEEI.click_Copy();
				createEEIT.Savebutton();
				createEEIT.UltCons_EndUserType();
				createEEIT.getEEINo() ;
				 String EEINo = createEEIT.getEEINo();
				
				 edit.additionalTransactionDetails();
					edit.selectItem();
					itemPage.click_OrderNo(EEINo);
					additem.click_Close();
					itemPage.click_EEIForm();
					createEEIT.click_validationStatus();
					 createEEIT.cancelbutton();
//					 ResultEEI.NewSearchBtn();
					 EEI.shipmentNo(EEINo);
					 EEI.clickSearch();
					 ResultEEI.click_EEINo(EEINo);
					 createEEIT.validateHeading();
					 
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