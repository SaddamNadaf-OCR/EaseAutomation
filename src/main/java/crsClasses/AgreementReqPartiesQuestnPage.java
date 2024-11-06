package crsClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class AgreementReqPartiesQuestnPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_Button_ForwardNavigation = "//button[@id='next-btn']"; 

	public  AgreementReqPartiesQuestnPage(WebDriver driver, ExtentTest test) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.test = test;
	}
	
	//Click on Forward Button
	public void moveForward() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript ("arguments[0].click();" , driver.findElement(By.xpath(OCR_Button_ForwardNavigation)));
	}
}


