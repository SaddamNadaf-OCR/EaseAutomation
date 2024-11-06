package crsClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class AgreementTemplatePage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_Button_Select="//button[@name='deny'][1]";
	public static final String OCR_TemplateName="//select[@name='templateName']";
	public static final String OCR_Button_NewRequest="//button[2]";
	public static final String OCR_Button_Cancel="//button[contains(text(),'Cancel')]";
	
	/* ******************** Constructor ***************************** */

	public AgreementTemplatePage(WebDriver driver, ExtentTest test) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.test = test;

	}
	
    //Select Template
	public void select_Template(String Template) {
		selectByVisibleText(driver, test, OCR_TemplateName,"Selecting Template :", Template);
		
	}
	
	//Click on Select Button 
	public void click_Select() {
		clickElement(driver, test, OCR_Button_Select,"Clicking on Select Button :");
	}
	
	//Click on Add New Request Button
	public void click_NewRequest() {
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	executor.executeScript ("arguments[0].click();" , driver.findElement(By.xpath(OCR_Button_NewRequest)));
	}
	
	
}
