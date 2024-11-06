package crsClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class AgreementReqRebaselineAmendmentPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_Button_ForwardNavigation = "//button[@id='next-btn']"; 
	public static final String OCR_Ques_NotApplicable="	//input[@name='notApplicableQues']"; 
	public static final String OCR_Button_Save="//button[contains(text(),'Save')]";
	

	public  AgreementReqRebaselineAmendmentPage(WebDriver driver, ExtentTest test) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.test = test;
	}
	
	//Click on Forward Button
	public void moveForward() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript ("arguments[0].click();" , driver.findElement(By.xpath(OCR_Button_ForwardNavigation)));
	}
	
	//Click on all not applicable checkbox
		public void notapplicable() {
			List<WebElement> notapplicable= driver.findElements(By.xpath(OCR_Ques_NotApplicable));
		
			for(int i=0; i< notapplicable.size(); i++) {
				//System.out.println(notapplicable.size());
				WebElement checkbox=notapplicable.get(i);
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript ("arguments[0].click();" ,checkbox);
				//nacheckbox.click();		
			}
			Wait.waitfor(3);
	}
		//Click on Save Button
		public void save() {
			clickElement(driver, test, OCR_Button_Save, "Clicking on Save Button: ");	
		}
	   
}


