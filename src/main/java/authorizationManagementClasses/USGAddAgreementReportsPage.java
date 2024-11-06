package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class USGAddAgreementReportsPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	//...................................Locators.......................................//
	public static final String USGAR_AgreementNo="//input[@name='agreementReports.agreementNo']";
	public static final String USGAR_AgreementNoPopUp="//a[contains(text(),'Agreement No')]";
	public static final String USGAR_TransactionID="//input[@name='dosGeneralInfoDTO.transactionId']";
	public static final String USGAR_Select="//button[@name='select']";
	public static final String USGAR_Cancel="//button[@name='cancel']";
	public static final String USGAR_SearchPopUp="//button[@name='Search']";
	public static final String USGAR_SelectPopUp="(//button[contains(text(),'Select')])[2]";
	public static final String USGAR_ClosePopUp="//button[@class='btn-close']";
	
	//.................................Constructor.....................................//
	public USGAddAgreementReportsPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;		
	}
	
	//.........................Click on Cancel Tab................................//
	public void cancel() {
		clickElement(driver, test, USGAR_Cancel, "Cliking on Cancel Tab");
	}
	//.................Getting Agreement Number From Hyperlink...................//
	public void agreementPopUp(String agreementNo) {
		clickElement(driver, test, USGAR_AgreementNoPopUp, "Clicking on Agreement Number PopUp");
		try {
			typeText(driver, test, USGAR_TransactionID, "Entering the transaction ID of Agreement Number : ", agreementNo);
			clickElement(driver, test, USGAR_SearchPopUp, "Clicking on Search PopUp");
			mouseOverAndClick(driver, test, "//td[contains(text(),'"+agreementNo+"')]", "Selecting Number from Table");
			clickElement(driver, test, USGAR_SelectPopUp, "Clicking on Select Tab");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, USGAR_ClosePopUp, "Clicking on ClosePopup");
			e.printStackTrace();
		}
	}
	//...................................Click on Select Tab...................................//
	public void select() {
		clickElement(driver, test, USGAR_Select, "Clicking on Select Tab");
	}
}
