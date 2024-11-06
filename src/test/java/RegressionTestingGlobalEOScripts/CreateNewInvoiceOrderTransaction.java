package RegressionTestingGlobalEOScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import globalExportClasses.CreateInvoicePage;
import globalExportClasses.CreateNewInvoicePage;
import globalExportClasses.EditInvoiceItemsPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.InvoiceCreateNewOrderItemPage;
import globalExportClasses.InvoiceOrderItemHazmatDetailsPage;
import globalExportClasses.InvoiceOrderItemSubComponentPage;
import globalExportClasses.InvoicePage;
import globalExportClasses.ResultInvoiceOrderPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class CreateNewInvoiceOrderTransaction extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("CreateNewInvoiceOrder", excel);
	}

	@Test(dataProvider = "getData")
	public void InvoiceOrder(String Testcase, String RunMode, String SBU, String SBUCode, String orderNo,
			String ultDest, String ModeOfTransport, String EntityType, String entityCode, String Status,
			String containerID, String DimensionUOM, String LenghtWidthHight, String WeightUOM, String GrossNet,
			String ProductDesc, String COO, String CustInvQty, String UOM, String UnitPrice,
			String ExportClassification, String HTS, String PrimaryUOM, String USExport, String AuthNo,
			String AuthItemNo, String AuthType, String AuthTxnType, String AuthExpiryDate, String AdditionalAuthNo,
			String AdditionalAuthItemNo, String HUContainerID, String BatchNo, String BatchCOO, String hazmatID,
			String SubCompNo, String ParentProdID) {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		InvoicePage Inv = new InvoicePage(driver, test);
		CreateInvoicePage Create_Inv = new CreateInvoicePage(driver, test);
		CreateNewInvoicePage Create_NInv = new CreateNewInvoicePage(driver, test);
		EditInvoiceItemsPage Edit_InvItem = new EditInvoiceItemsPage(driver, test);
		InvoiceCreateNewOrderItemPage Invoice_Create_NO_Item = new InvoiceCreateNewOrderItemPage(driver, test);
		InvoiceOrderItemHazmatDetailsPage HazmatDetails = new InvoiceOrderItemHazmatDetailsPage(driver, test);
		InvoiceOrderItemSubComponentPage SubCompDetails = new InvoiceOrderItemSubComponentPage(driver, test);
		ResultInvoiceOrderPage ResultIO = new ResultInvoiceOrderPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.OCR_HomePage_Invoice_Order();
					Inv.click_AddInvoiceBtn();
					Create_Inv.select_SBUCode(SBUCode);
					Create_NInv.invoice_Details(orderNo, ultDest, ModeOfTransport);
					Create_NInv.addPartiesToTheTransaction(EntityType, entityCode, Status);
					Create_NInv.containerDetails(containerID, DimensionUOM, LenghtWidthHight, WeightUOM, GrossNet);
					String InvOrderNo = Create_NInv.gettingInvoiceOrderNo();
					Create_NInv.saveBtn();
					Create_NInv.select_Items();
					Edit_InvItem.addOrder_Items();
					Invoice_Create_NO_Item.generalInformation(ProductDesc, COO);
					Invoice_Create_NO_Item.qytPricingInfo(CustInvQty, UOM, UnitPrice);
					Invoice_Create_NO_Item.classificationInfo(ExportClassification, HTS, PrimaryUOM, USExport);
					Invoice_Create_NO_Item.classificationInfoSaveBtn();
					Invoice_Create_NO_Item.exportAuthInfo(AuthNo, AuthItemNo, AuthType, AuthTxnType, AuthExpiryDate);
					Invoice_Create_NO_Item.additionalAuthInfo(AdditionalAuthNo, AdditionalAuthItemNo);
					Invoice_Create_NO_Item.packingInfo(HUContainerID);
					Invoice_Create_NO_Item.batchInfo(BatchNo, BatchCOO);
					Invoice_Create_NO_Item.saveBtn();
					Invoice_Create_NO_Item.hazmatDetails();
					HazmatDetails.hazmatInfo(hazmatID);
					HazmatDetails.hazmatSaveBtn();
					HazmatDetails.subComponentDetails();
					SubCompDetails.addSubCompBtn();
					SubCompDetails.addOrderItemSubComp(SubCompNo, ParentProdID);
					SubCompDetails.closeSubCompBtn();
					Edit_InvItem.closeBtn();
					HGExport.return_ExportHome();
					HGExport.OCR_HomePage_Invoice_Order();
					Inv.enter_InvoiceOrderNo(InvOrderNo);
					Inv.click_SearchButton();
					ResultIO.click_InvoiceOrderNo(InvOrderNo);
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
