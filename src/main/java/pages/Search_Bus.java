package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;

public class Search_Bus extends BasePage {

	public Search_Bus(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	
	@FindBy(xpath="//input[@id='srcinput']") WebElement From_Bus;
	
	//enter 1st value from auto suggestion
	@FindBy(xpath="//div[@id=\"suggestion-0\"]") WebElement From_Bus_dropdown_click;
	

	@FindBy(xpath="//input[@id='destinput']") WebElement To_Bus;
	
	@FindBy(xpath="//*[@id=\"suggestion-0\"]") WebElement To_bus_dropdown_click;
	
	@FindBy(xpath="//button[@aria-label=\"Search buses\"]") WebElement Serach_Bus_Button;
	@FindBy(xpath="//*[@id=\"19254762\"]/div[3]/div[3]/div/div[2]") WebElement zingbus_plus;
	
	
	@FindBy(xpath="//div[contains(text(), 'Please enter source and destination')]")
	WebElement Validation_Message;
	
	
	//How many bus are showing after click search bus
	@FindBy(xpath="//body/div[@id='root']/div[@id='searchContentWrap']/div[@class='searchMain__ind-search-styles-module-scss-6skQC']/div[@class='searchWrap__ind-search-styles-module-scss-yEyjH']/div[6]/div[1]") WebElement countofBus;

	
	public void enterFrom_city(String fromcity) {
		
		From_Bus.sendKeys(fromcity);
		
	}
	
	public void enterTo_city(String tocity) {
		To_Bus.sendKeys(tocity);
		
	}
	
	public  void clickonSearchBus() {
		Serach_Bus_Button.click();
	}

	public boolean VerifyAfterSearch_Dolphin_Travel_House_display() {
		return zingbus_plus.isDisplayed();
	}
	
public void click_on_first_option_from_dropdown() {
	From_Bus_dropdown_click.click();
}
	public void clickonTo_bus() {
		To_bus_dropdown_click.click();
	}
	// NEW: Method to check validation message
		public boolean isValidationMessageDisplayed() {
			try {
				wait.until(ExpectedConditions.visibilityOf(Validation_Message));
				return Validation_Message.isDisplayed();
			} catch (Exception e) {
				return false;
			}
		}
		
		// NEW: Get validation message text
		public String getValidationMessageText() {
			try {
				wait.until(ExpectedConditions.visibilityOf(Validation_Message));
				return Validation_Message.getText();
			} catch (Exception e) {
				return "";
			}
			
			}
	
}

