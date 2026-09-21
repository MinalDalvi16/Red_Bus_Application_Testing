package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;

public class login_page extends BasePage {

	
	//Constructor 
	public login_page(WebDriver driver) {
		super(driver);
	}
	
	//Locator x path find each element
	@FindBy(xpath="//button[@aria-label=\"Account\"]") WebElement Account_Buttoon;
	@FindBy(xpath="//div[@data-autoid=\"signInPrompt\"]") WebElement Login_window;
	@FindBy(xpath="//button[@aria-label=\"Log in\"]") WebElement Login_Button;
	@FindBy(xpath="//button[@aria-label=\"Log in\"]") WebElement Login_to_get_exciting_offers;
	@FindBy(xpath="//iframe[contains(@id,'gsi_')]")WebElement Sign_in_Frame;
	@FindBy(xpath="//*[@id=\"container-div\"]/div/div[2]/span[1]") WebElement Sign_in_button;
	
	//Google window open 
	@FindBy(xpath="//*[@id=\"identifierId\"]") WebElement Email_Id;
	@FindBy(xpath="//*[@id=\"identifierNext\"]/div/button/span") WebElement Next_button;


	
	
	//Action method 
	
	public void Click_Account_Button() {
		Account_Buttoon.click();
	}
	
	
	 public boolean isLoginWindowDisplayed() {

	 return Login_window.isDisplayed();
	    }

	
	
	public void Click_Login_Button() {
		Login_Button.click();
}
	
	public boolean Login_to_get_exciting_offers_popup() {
		return Login_to_get_exciting_offers.isDisplayed();
			
	}
	
	public void framechange() {
		driver.switchTo().frame(Sign_in_Frame);
	}
	
	public void clicksignin() {
		Sign_in_button.click();
	}

	

	
	
	
	
	

}
