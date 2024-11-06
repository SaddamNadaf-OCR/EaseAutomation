package productScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import initializer.SeleniumTestBase;
import productClasses.HomePageProduct;
import productClasses.ProductUploadFile;
import utilities.Utility;
import utilities.Wait;

public class ProductUploadFileResult extends SeleniumTestBase{
	
	@Test()
	public void Fileupload() throws Exception {

		ProductUploadFile uploadfile = new ProductUploadFile(driver, test);
		HomePageProduct home = new HomePageProduct(driver,test);

		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
			uploadfile.addFromExcel();
				try {
				uploadfile.excelUploadFile();
				uploadfile.attachFile();
				uploadfile.validateUploadFile();
				Wait.waitfor(3);
				}
				catch(Exception e) {
					uploadfile.click_close();	
				}
				Wait.waitfor(3);
			//	home.returnToSearchProductPage();				
			}
		} catch (SkipException s) {
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
