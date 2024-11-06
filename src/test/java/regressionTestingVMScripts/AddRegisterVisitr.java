package regressionTestingVMScripts;



import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

import initializer.SeleniumTestBase;
import utilities.Utility;
import utilities.Wait;

import vmsClasses.AddRegisterVisitorPage;
import vmsClasses.HomePage;
import vmsClasses.SearchVisitorRequestPage;

public class AddRegisterVisitr extends SeleniumTestBase{
	

	@Test(dataProvider = "getData")
	public void repidRegtn(String Testcase, String RunMode, String SBU, String Title, String FirstName , String MiddleName, String LastName, String Email, String PhoneNumber, String Country, 
			String State, String Zip, String City, String Address, String TypeOfPerson, String VisitorCategory, String COC, String OCOC, 
			String DateOfBirth, String PlaceOfBirth, String CountryOfBirth, String IdentifyingDocument, String DocumentNumber, String IssCountry,
			String IssState, String ExpirationDate) throws Exception {
		
		// ************* Objects Creation ******************************
		HomePage homePage = new HomePage(driver, test);
		SearchVisitorRequestPage searchVR = new SearchVisitorRequestPage(driver, test);
		AddRegisterVisitorPage ARvisitor = new AddRegisterVisitorPage(driver, test);
		
		try {
			if (!Utility.isExecutable(getClass().getSimpleName(), excel)) {
				throw new SkipException("Skipping the test");
			} else {
				if (RunMode.equalsIgnoreCase("y")) {
					test.log(LogStatus.INFO, Testcase);
					homePage.moveTo_SBUSelection(SBU);
					homePage.click_VisitorManagemtn();
					searchVR.moveTo_Files();
					ARvisitor.select_RegisterVisitor();
					ARvisitor.Click_AddRegisterVisitor();
					Wait.waitfor(2);
					ARvisitor.Add_Individual(Title, FirstName, MiddleName, LastName, Email, PhoneNumber);
					Wait.waitfor(2);
					ARvisitor.Add_AddressDetails(IssCountry, IssState, Zip, City, Address);
					Wait.waitfor(5);
					ARvisitor.Add_CitizenShip(TypeOfPerson, VisitorCategory, COC, OCOC);
					Wait.waitfor(5);
					ARvisitor.Add_AdditionalDetails(DateOfBirth, PlaceOfBirth, CountryOfBirth);
					Wait.waitfor(2);
					ARvisitor.Add_IdentifyingDocument(IdentifyingDocument, DocumentNumber);
					Wait.waitfor(3);
					ARvisitor.Add_IssCountry(IssCountry);
					Wait.waitfor(2);
					ARvisitor.Add_IssState(IssState);
					Wait.waitfor(3);
					ARvisitor.select_ExpirationDate(ExpirationDate);
			
					Wait.waitfor(3);
					ARvisitor.Add_AddID();
					Wait.waitfor(3);
					ARvisitor.Click_Save();
					ARvisitor.Click_SaveAndReturn();
					
				} else {
					test.log(LogStatus.SKIP, "Please check the run mode");
					throw new SkipException("Skipping the test");
				}
			}
		} catch (SkipException s) {
			// s.printStackTrace();
			test.log(LogStatus.INFO, Testcase);
			test.log(LogStatus.SKIP, "Please check the run mode");
			throw s;
		} catch (Exception e) {
			testFail();
			e.printStackTrace();
			Wait.waitfor(3);
			homePage.returnPage();
			Assert.assertTrue(false);
		}
	}		
	
		@DataProvider
		public Object[][] getData() {
			return Utility.getData("AddRegisterVisitr", excel);
}

}


