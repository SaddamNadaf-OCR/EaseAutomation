package regressionTestingGlobalProduct;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import productClasses.AddFromExcelPage;
import productClasses.AddFromExcelSearchResult;
import productClasses.HomePageProduct;
import utilities.Utility;
import utilities.Wait;

public class AddFromExcelResult extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("ProductExcelUpload", excel);
	}

	@Test(dataProvider = "getData")

	public void SearchExcelDetails(String Testcase, String RunMode, String FileName, String Status, String SbuCode,
			String UploadedBy, String UploadedDateFrom, String UploadedDateTo, String SortBy, String Direction)
			throws Exception {

		// *************************Objects Creation ******************

		AddFromExcelPage addexcel = new AddFromExcelPage(driver, test);
		AddFromExcelSearchResult adresult= new AddFromExcelSearchResult(driver, test);
		HomePageProduct home = new HomePageProduct(driver, test);

		// ***********Test steps execution *******************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					addexcel.addFromExcel();
					addexcel.searchProductDetails(FileName, Status, SbuCode, UploadedBy, UploadedDateFrom,
							UploadedDateTo, SortBy, Direction);
					addexcel.click_ProductSearch();
					Wait.waitfor(8);
					adresult.displayOfTitle();
					Wait.waitfor(3);
			//		home.returnToSearchProductPage();
					
				} else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		} catch (SkipException s) {
			test.log(LogStatus.INFO, Testcase);
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			home.returnToSearchProductPage();
			Assert.assertTrue(false);
		}
	}
}
