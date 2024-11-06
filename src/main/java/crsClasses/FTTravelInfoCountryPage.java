package crsClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class FTTravelInfoCountryPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_AddCountry="//button[@name='addCountry']";
	public static final String OCR_Select_ThirdCountry ="//select[@id='cntryListIdList']";
	public static final String OCR_AddRight ="//i[@class='fa fa-angle-right']";
	public static final String OCR_Save_Return="//button[contains(text(), 'Save & Return')]";
	public static final String OCR_Button_Next="//button[@id='next-btn']";

	/* ******************** Constructor ***************************** */
	public FTTravelInfoCountryPage(WebDriver driver, ExtentTest test) { 
		this.driver = driver;
		this.test = test;
	}
	//Click on Add Country Button
	public void addcountry() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript ("arguments[0].click();" , driver.findElement(By.xpath(OCR_AddCountry)));		
	}
	//Select Country
	public void selectcountry(String FTCountry) {
		selectByVisibleText(driver, test,  OCR_Select_ThirdCountry,"Selecting Country: ",FTCountry);
	}
	//Move right
	public void addright() {
		clickElement(driver, test, OCR_AddRight, "Click on Right Button");
		Wait.waitfor(3);
	}
	//Click on Save and Return
	public void saveandreturn() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript ("arguments[0].click();" , driver.findElement(By.xpath(OCR_Save_Return)));	
	}
	//Click on Forward button
	public void moveForward() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript ("arguments[0].click();" , driver.findElement(By.xpath(OCR_Button_Next)));	
		
	}
	
	// Click on AdditionalInfo tab
			public void movetoadditionalinfo() {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript ("arguments[0].click();" , driver.findElement(By.xpath("//a[contains(text(),'Additional Info')]")));
			}
			
			//Click on Status lable
			public void statusLabel() {
				clickElement(driver, test, "//span[@class='status']", "Diverting the Focus :");
			}
}
