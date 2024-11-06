package consignees;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class Override_Deny_Consignee extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_Consignee_overrideDenyButton="(//button[@type='button'])[6]";
	public static final String OCR_Consignee_deny="(//button[@type='button'])[4]";
	public static final String OCR_Consignee_GridCheckboxall="//input[@id='cb_grid']";
	public static final String OCR_Consignee_gridSinglecheckboxselect="//input[@id='jqg_grid_2']";
	public static final String OCR_Consignee_denyDataSelect="//input[@value='101']";
	public static final String OCR_Consignee_DenySave="//button[@type='submit']";
	public static final String OCR_Consignee_DenyPopupClose="(//button[@type='button'])[6]";
	public static final String OCR_Consignee_Overridebutton="(//button[@type='button'])[5]";
	public static final String OCR_Consignee_popupremark="//textarea[@name='otherReason']";
		
	/*
	 * ****************************** Constructor *********************************
	 */
	public Override_Deny_Consignee (WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

	}
	/* ******************************* Actions ********************************* */
	// Click on Save Button
		public void Click_Consigneeoverride_deny() {
			Wait.waitfor(3);

			clickElement(driver, test, OCR_Consignee_overrideDenyButton, "Click on override/deny Button");
		
		}
		//click on deny button 
		public void Click_denyButton() {
			Wait.waitfor(3);

			clickElement(driver, test, OCR_Consignee_deny, "Click on deny Button");
		}
		// click on override button
		public void Click_OverrideButton() {
			Wait.waitfor(3);

			clickElement(driver, test, OCR_Consignee_Overridebutton, "Click on deny Button");
			
		}
		
		public void editConsigneeCompliance() {
			clickElement(driver, test, OCR_Consignee_gridSinglecheckboxselect, "");
			Wait.waitfor(3);
			clickElement(driver, test, OCR_Consignee_deny, "Click on deny Button");
			
		}
		public void dataselect(String remark) {
			clickElement(driver, test, OCR_Consignee_GridCheckboxall, "Clicking");
			Wait.waitfor(3);
			clickElement(driver, test, OCR_Consignee_deny, "Click on deny Button");
			try {
				clickElement(driver, test, OCR_Consignee_gridSinglecheckboxselect, "Clicking");
				Wait.waitfor(3);
				scrollToElement(driver, OCR_Consignee_popupremark);
				Wait.waitfor(3);
				typeText(driver, test, OCR_Consignee_popupremark, "typing textbox", remark);
				Wait.waitfor(3);
				clickElement(driver, test, OCR_Consignee_DenySave, "Click on Save Button");
			} catch (Exception e) {
				clickElement(driver, test, OCR_Consignee_DenyPopupClose, "clicking on close popup");
			}
		}
		
		
		
}
