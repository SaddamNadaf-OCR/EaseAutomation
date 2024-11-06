package RegressionTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.CreatShipmentPage;
import globalExportClasses.CreateNewOrderItemPage;
import globalExportClasses.CreateNewShipmentPage;
import globalExportClasses.EditInvoiceOrderFormPage;
import globalExportClasses.EditShipmentItemsPage;
import globalExportClasses.EditShipmentReviewerDetailsPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.InvoicePage;
import globalExportClasses.ResultInvoiceOrderPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class VerifySearchAndDeleteFunctionalityOfInvOrderUS extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("SearchDeleteInvOrder", excel);
	}

	@Test(dataProvider = "getData")
	public void VerifySearchDeleteOfInvOrder(String Testcase, String RunMode, String SBU, String SBUCode,
			String WorkStatus, String SbuCode, String PartNo, String PartNum, String UnitPrice) {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		InvoicePage Inv = new InvoicePage(driver, test);
		ResultInvoiceOrderPage ResultInv = new ResultInvoiceOrderPage(driver, test);
		EditInvoiceOrderFormPage EditInvoiceOrder = new EditInvoiceOrderFormPage(driver, test);
		CreatShipmentPage CreateShip = new CreatShipmentPage(driver, test);
		CreateNewShipmentPage CreateNewShip = new CreateNewShipmentPage(driver, test);
		EditShipmentItemsPage ShipmentItem = new EditShipmentItemsPage(driver, test);
		CreateNewOrderItemPage Orderitem = new CreateNewOrderItemPage(driver, test);
		EditShipmentReviewerDetailsPage reviewDetails = new EditShipmentReviewerDetailsPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.OCR_HomePage_Invoice_Order();
					Inv.selectSBU(SBUCode);
					Inv.search_WorkStatus(WorkStatus);
					Inv.click_SearchButton();
					ResultInv.resultGridInfo();
					ResultInv.click_NewSearchBtn();
					Inv.criteriaBasedOnInvItem();
					Inv.selectDomesticSBUCode(SbuCode);
					Inv.click_SearchButton();
					ResultInv.resultGridInfo();
					ResultInv.click_NewSearchBtn();
					Inv.criteriaBasedOnInvItem();
					Inv.selectDomesticPartNo(PartNo);
					Inv.click_SearchButton();
					ResultInv.resultGridInfo();
					ResultInv.click_NewSearchBtn();
					Inv.criteriaBasedOnInvItem();
					Inv.selectUnitPricePartNo(PartNum, UnitPrice);

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
