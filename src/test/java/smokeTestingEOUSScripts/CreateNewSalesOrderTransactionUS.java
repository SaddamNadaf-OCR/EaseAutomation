package smokeTestingEOUSScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import globalExportClasses.CreateNewSalesOrderPage;
import globalExportClasses.CreateSalesOrderPage;
import globalExportClasses.EditSalesOrderItemsPage;
import globalExportClasses.HomeGExportPage;
import globalExportClasses.ResultSalesOrderPage;
import globalExportClasses.SalesCreateNewOrderItemPage;
import globalExportClasses.SalesOrderItemHazmatDetailsPage;
import globalExportClasses.SalesOrderItemSubComponentPage;
import globalExportClasses.SalesOrderPage;
import initializer.SeleniumTestBase;
import utilities.Utility;

public class CreateNewSalesOrderTransactionUS extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("CreateNewSalesOrder", excel);
	}

	@Test(dataProvider = "getData")
	public void SalesOrder(String Testcase, String RunMode, String SBU, String SBUCode, String orderNo, String ultDest,
			String ModeOfTransport, String Program, String EntityType, String entityCode, String Status,
			String ContainerID, String DimensionUOM, String LenghtWidthHight, String WeightUOM, String GrossNet,
			String ProductDesc, String COO, String CustInvQty, String UOM, String UnitPrice,String ControllingAgency,
			String ExportClassification, String HTS, String PrimaryUOM, String AuthNo,
			String AuthItemNo, String AuthType, String AuthTxnType, String AuthExpiryDate, String AdditionalAuthNo,
			String AdditionalAuthItemNo, String HUContainerID, String BatchNo, String BatchCOO, String hazmatID,
			String SubCompNo, String ProdID) {

		HomeGExportPage HGExport = new HomeGExportPage(driver, test);
		SalesOrderPage SalesOrder = new SalesOrderPage(driver, test);
		CreateSalesOrderPage Create_SO = new CreateSalesOrderPage(driver, test);
		CreateNewSalesOrderPage Create_New_SO = new CreateNewSalesOrderPage(driver, test);
		EditSalesOrderItemsPage Edit_SOItems = new EditSalesOrderItemsPage(driver, test);
		SalesCreateNewOrderItemPage SalesCreate_NO_Item = new SalesCreateNewOrderItemPage(driver, test);
		SalesOrderItemHazmatDetailsPage HazmatDetails = new SalesOrderItemHazmatDetailsPage(driver, test);
		SalesOrderItemSubComponentPage SubCompDetails = new SalesOrderItemSubComponentPage(driver, test);
		ResultSalesOrderPage ResultSO = new ResultSalesOrderPage(driver, test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					HGExport.moveTo_SBUSelection(SBU);
					HGExport.OCR_HomePage_Orders_Deliveries();
					SalesOrder.click_AddSalesOrderBtn();
					Create_SO.select_SBUCode(SBUCode);
					Create_New_SO.sales_Order_Details(orderNo, ultDest, ModeOfTransport);
					Create_New_SO.addprogram(Program);
					Create_New_SO.addPartiesToTheTransaction(EntityType, entityCode, Status);
					Create_New_SO.containerDetails(ContainerID, DimensionUOM, LenghtWidthHight, WeightUOM, GrossNet);
					String salesNo = Create_New_SO.gettingSalesOrderNo();
					Create_New_SO.select_Items();
					Edit_SOItems.addOrder_Items();
					SalesCreate_NO_Item.generalInformation(ProductDesc, COO);
					SalesCreate_NO_Item.qytPricingInfo(CustInvQty, UOM, UnitPrice);
					SalesCreate_NO_Item.saveBtn();
					SalesCreate_NO_Item.classificationInfoUS(ControllingAgency, ExportClassification, HTS, PrimaryUOM);
					SalesCreate_NO_Item.classificationInfoSaveBtn();
					SalesCreate_NO_Item.exportAuthInfoUS(AuthNo, AuthItemNo, AuthType, AuthTxnType, AuthExpiryDate);
				//	SalesCreate_NO_Item.additionalAuthInfoUS(AdditionalAuthNo, AdditionalAuthItemNo);
				//	SalesCreate_NO_Item.saveBtn();
					SalesCreate_NO_Item.packingInfo(HUContainerID);
					SalesCreate_NO_Item.batchInfo(BatchNo, BatchCOO);
					SalesCreate_NO_Item.saveBtn();
					SalesCreate_NO_Item.hazmatDetails();
					HazmatDetails.hazmatInfo(hazmatID);
					HazmatDetails.hazmatSaveBtn();
					HazmatDetails.subComponentDetails();
					SubCompDetails.addSubCompBtn();
					SubCompDetails.addOrderItemSubCompUS(SubCompNo, HUContainerID, ProdID);
					SubCompDetails.closeSubCompBtn();
					Edit_SOItems.closeBtn();
					HGExport.return_ExportHome();
					HGExport.OCR_HomePage_Orders_Deliveries();
					SalesOrder.enter_SalesOrderNo(salesNo);
					SalesOrder.click_SearchButton();
					ResultSO.click_SalesOrderNo(salesNo);
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
