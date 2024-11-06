package crsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class ForeignTravelWorkQueuePage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_WorkQueuePage_MyQueue = "//select[@name='myQueue']";
	public static final String OCR_WorkQueuePage_Go1 = "(//button[contains(text(),'Go')])[1]";
	public static final String OCR_WorkQueuePage_GenralQueue = "//select[@name='genQueue']";
	public static final String OCR_WorkQueuePage_Go2 = "(//button[contains(text(),'Go')])[2]";
	
	/* ******************************* Constructor ***************************** */
	public ForeignTravelWorkQueuePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	/* *******************************MY QUEUE*********************************** */
	public void myQueue(String MyQueue) {
		selectByVisibleText(driver, test, OCR_WorkQueuePage_MyQueue, "Selecting My Queue From DropDown :", MyQueue);
		clickElement(driver, test, OCR_WorkQueuePage_Go1, "Clicking on Go Button :");
	}
	
	/* **************************GENRAL QUEUE*********************************** */
	public void generalQueue(String MyQueue1) {
		selectByVisibleText(driver, test, OCR_WorkQueuePage_GenralQueue, "Selecting My Queue From DropDown :", MyQueue1);
		clickElement(driver, test, OCR_WorkQueuePage_Go2, "Clicking on Go Button :");
	}

}
