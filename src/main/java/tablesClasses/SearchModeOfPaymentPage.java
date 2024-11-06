package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchModeOfPaymentPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
//---------------------------------Locators---------------------------------------------//
	public static final String OCR_SearchPage_search = "(//button[@class='primary-btn'][1])";
	public static final String OCR_SearchPage_reset = "//button[@type='reset']";
	public static final String OCR_HomePage_AddModeOfPayment = "//button[@name='addButton']";
	public static final String OCR_Search_page_PaymentCode="//input[@name='sdMethodsOfPaymentValue.paymentCode']";
	public static final String OCR_Search_page_Description="//textarea[@name='sdMethodsOfPaymentValue.description']";
	public static final String OCR_Search_page_Status="//select[@name='sdMethodsOfPaymentValue.status']";
	
//--------------------Constructor------------------------------------//
	
	public SearchModeOfPaymentPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
							
	}

//....................click on search button......................//
	public void searchbutton() {
		clickElement(driver, test, OCR_SearchPage_search, "clicking on search button :");
		}
								
//....................click on reset button......................//
	public void resetbutton() {
		clickElement(driver, test, OCR_SearchPage_reset, "clicking on reset button :");
		}
					
//....................click on Add Mode Of Payment button......................//
	public void AddMOP() {
		clickElement(driver, test, OCR_HomePage_AddModeOfPayment, "clicking on Add button :");
		}
		
//.....................searchParameter...............................//
	public void searchbyParameters(String PaymentCode, String Description, String status) {
		if(PaymentCode.length()>0) {
			typeText(driver, test, OCR_Search_page_PaymentCode, "Entering PaymentCode", PaymentCode);
		}
		if(Description.length()>0) {
			typeText(driver, test, OCR_Search_page_Description, "Entering Description", Description);
		}
		if(status.length()>0) {
			selectByVisibleText(driver, test, OCR_Search_page_Status, "selecting Status by dropdown :", status );
		}

					
						
			}
			
		

}
