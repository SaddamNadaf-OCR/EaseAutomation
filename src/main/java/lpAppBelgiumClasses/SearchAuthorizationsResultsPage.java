package lpAppBelgiumClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class SearchAuthorizationsResultsPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_SearchAddAuthz = "//td[contains(text(),'In Progress')]";
	public static final String OCR_SearchAuthResultsTitle = "//h3[@class='page-heading']";
	public static final String OCR_SearchAuthResults_CopyIcon = "//i[@class='fa fa-copy']";
	public static final String OCR_SearchAuthResults_NewSearch = "//button[@name='Back']";
	public static final String OCR_SearchAuthResults_DeleteIcon = "//tr[@id='1']//td[12]/i";

	/* ******************** Constructor ***************************** */

	public SearchAuthorizationsResultsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	//Searching the Status in Search Authorizations screen of partical Record is Diaplaying or not
	public void search_AddAuthorization_status(String Status) {
		String SearchAuthResults = "//td[contains(text(),'In Progress')]";
	
		List<WebElement> Inprogress =  driver.findElements(By.xpath(SearchAuthResults));
		
		if(Inprogress == null || Inprogress.size() < 1 ){
			String Information = "//li[contains(text(),'No Records found.')]";
			String element = getText(driver, test, Information, "Get Informations massage : ");
			if(element.contains("No Records found.")){
				test.log(LogStatus.PASS, "Information message : No Records found.");
			}else{
				test.log(LogStatus.FAIL, "Search Authorization Results Fail");
				testFailSshot(driver, test);
				Assert.assertTrue(false);
			}
		}else {
			test.log(LogStatus.PASS, "Search Authorization Results : " +Status);
			getText(driver, test, "//span[@class='resultCount']", "Total no of records found : ");
		}
	}

	//verify the Search Authorization Page is Display or not
	public void searchAuthPageDisplay() {
		String pageTitle = getText(driver, test, OCR_SearchAuthResultsTitle, "Title of the Page : ");
		if(pageTitle.contains("Search Authorization Results")){
			test.log(LogStatus.PASS, "Search Authorization Results Page is Display");
		}else{
			test.log(LogStatus.FAIL, "Search Authorization Results Fail");
			testFailSshot(driver, test);
			Assert.assertTrue(false);
		}		
	}

	//Verify the Reference ID is Displayed in the table or not
	public void displayOfRefID(String RefernceID) {
		try {
			String RefID = "//a[contains(text(),'"+RefernceID+"')]";
			if(isDisplayed(driver, RefID)) {
				test.log(LogStatus.PASS, "Reference ID is Dispalyed : " + RefernceID);	
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Reference ID is not Dispalyed "+ RefernceID);
			testFailSshot(driver, test);
			Assert.assertTrue(false);
		}
	}

	//click on copy button
	public void clickCopybtn() {
		clickElement(driver, test, OCR_SearchAuthResults_CopyIcon, "click on copy icon");		
	}

	//click on New Search button
	public void clickNewSearchBtn() {
		clickElement(driver, test, OCR_SearchAuthResults_NewSearch, "click on New Search Button");
	}

	//click on New Search button
	public void clickDeleteIcon() {
		clickElement(driver, test, OCR_SearchAuthResults_DeleteIcon, "click on Delete Icon");
	}
	
	//Verify Delete icon is Enable or Disable 
	public void delectIconAction(String Status) {
		String delectFlag = "//a[@class='delete-icon']";
		List<WebElement> flags = driver.findElements(By.xpath(delectFlag));		
		if(flags.size() == 0) {
			if(!Status.equalsIgnoreCase("In Progress")) {
				test.log(LogStatus.PASS, "Delect icon Cann't allowing to delete the Records");	
			}else {
				test.log(LogStatus.FAIL, "Delect icon is allowing to delete the Records");	
				testFailSshot(driver, test);
				Assert.assertTrue(false);
			}
		}/*else{
			if(Status.equalsIgnoreCase("In Progress")) {
				test.log(LogStatus.PASS, "Delect icon is allowing to delete the Records");	
			}else {
				test.log(LogStatus.FAIL, "Delect icon Cann't allowing to delete the Records");	
				testFailSshot(driver, test);
				Assert.assertTrue(false);
			}		
		}	*/	
	}
	
}
