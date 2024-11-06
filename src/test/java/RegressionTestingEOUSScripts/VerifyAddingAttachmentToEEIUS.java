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

public class VerifyAddingAttachmentToEEIUS extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ValidateAttachmentEEI", excel);
	}

	@Test(dataProvider = "getData")
	public void AESDirectSubmission(String Testcase, String RunMode, String SBU, String SBUCode, String ExportCode,
			String ShipmentWorkStatus, String ShipNumber, String DocumentType, String UploadfileName,
			String DocumentLocationPath, String DocumentType1, String UploadfileName1, String DocumentLocationPath1) {

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

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.CustomsFiling();
//					EEI.searchEEI(SBUCode, ExportCode, ShipmentWorkStatus, "", "", "", "");
					EEI.shipmentNo(ShipNumber);
					EEI.clickSearch();

//					ResultEEI.click_Attachment();
//					ResultEEI.select_Doc(DocumentType, UploadfileName, DocumentLocationPath);
					ResultEEI.click_ShipNumber();
					edit.uploadFileAttachment();
					edit.validate_attachment(DocumentType);
					edit.select_Doc(DocumentType1, UploadfileName1, DocumentLocationPath1);

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
