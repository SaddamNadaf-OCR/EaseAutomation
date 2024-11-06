package productClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class EditProductPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
     public static final String OCR_Description="//textarea[@id='editProduct_product_productDesc']";
     public static final String OCR_Button_Save="//button[@name='save.x']";

	/* ******************************* Constructor ****************************** */

	public EditProductPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	
	public void edit_description(String Description) {
	 driver.findElement(By.xpath(OCR_Description)).clear();	 
	 typeText(driver, test, OCR_Description, "Edit Description", Description);
	 Wait.waitfor(3);
	 clickElement(driver, test, OCR_Button_Save,"Clicking on Save Button:");
	}


	//Verify the Page Title is Displayed or not
	public void displayOfTitle() {
		try {				
			if(isDisplayed(driver, "//h3[contains(text(),'Edit Product')]")) {
				test.log(LogStatus.PASS, "Result Edit Product Page is Dispalyed");	
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Result Edit Product Page is not Dispalyed");
			testFailSshot(driver, test);
			Assert.assertTrue(false);
		}
}

}
