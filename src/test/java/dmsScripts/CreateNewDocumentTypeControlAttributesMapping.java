package dmsScripts;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import dmsClasses.CreateNewDocumentTypeControlAttributesMappingPage;
import dmsClasses.DMSHomePage;
import dmsClasses.SearchDocumentTypeControlAttributesPage;
import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

public class CreateNewDocumentTypeControlAttributesMapping extends SeleniumTestBase {

	@DataProvider
	public Object[][] getData() {
		return Utility.getData("AddDocTypCtrlAttMapping", excel);
	}

	@Test(dataProvider = "getData")
	public void CreateDocTypControlAttribMapping(String Testcase, String RunMode, String SBU, String Module,
			String SetId, String DocType, String ControlAttrib) throws Exception {

		DMSHomePage home = new DMSHomePage(driver, test);
		SearchDocumentTypeControlAttributesPage searchdoc = new SearchDocumentTypeControlAttributesPage(driver, test);
		CreateNewDocumentTypeControlAttributesMappingPage newdocmap = new CreateNewDocumentTypeControlAttributesMappingPage(
				driver, test);

		// **********Test steps execution ***************************
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					home.moveTo_SBUSelection(SBU);
					home.movetoTools();
					home.movetodoctypctrlattrib();
					Wait.waitfor(3);
					searchdoc.add_doctypcontrolattrib();
					newdocmap.add_doctypecontrlattribmapping(Module, SetId, DocType, ControlAttrib);
					Wait.waitfor(5);
					newdocmap.selectall();
					newdocmap.savendreturn();
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
			home.return_ExportHome();
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}

}
