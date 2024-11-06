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
import utilities.Wait;

public class VerifyPDFfuncForShippedStatusInvUS extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("VerifyPDFForShippedInv", excel);
	}

	@Test(dataProvider = "getData")
	public void VerifyPDFFromShippedInvoiceOrder(String Testcase, String RunMode, String SBU, String InvoiceNo,
			String workStatus, String emailID1, String emailID2, String emailID3) {

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
					Inv.approvedInvoice(InvoiceNo, workStatus);
					Inv.click_SearchButton();
					// ResultInv.clickInvoiceNo();
					ResultInv.clickPdficon();
				//	CreateNewShip.Click_GenerateDocument();
					Wait.waitfor(2);
					ResultInv.deselctAllDoc();
				ResultInv.selectDocs();
				ResultInv.generateDocBtn();
				ResultInv.enterEmailID(emailID1, emailID2, emailID3);
		//	ResultInv.validateDocument(EmailGroup, EmailDocumentTo);
				Wait.waitfor(2);
				//	ResultInv.clickSendEmailWithLink(emailID);
					Wait.waitfor(2);
				//	CreateNewShip.scrollToShip();
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
