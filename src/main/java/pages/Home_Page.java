package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class Home_Page extends BasePage {

	public Home_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Locator x path find each element
		@FindBy(xpath="//*[@id=\"root\"]/main/div/div/div[1]") WebElement Banner_Content;
		@FindBy(xpath="//h1[@id=\"main-content\"]") WebElement headerText;
		@FindBy(xpath="//div[@data-autoid=\"searchWidget\"]") WebElement searchWidget;
		@FindBy(xpath="//div[@data-autoid=\"searchWidget\"]") WebElement women_switch;
		//@FindBy(xpath="//div[@data-autoid=\"searchWidget\"]") WebElement search_buses;
		
		@FindBy(xpath="//input[@id=\"srcinput\"]") WebElement from_date;
		@FindBy(xpath="//input[@id=\"destinput\"]") WebElement to_date;
		@FindBy(xpath="//div[@data-autoid=\"searchWidget\"]") WebElement search_buses;
		

	
		
		 public boolean isBannerContDisplayed() {
			return Banner_Content.isDisplayed();
			  }
		 
		 
		 public boolean isheaderTextDisplayed() {
				return headerText.isDisplayed();
				  }
		 public boolean issearchWidgetDisplayed() {
				return searchWidget.isDisplayed();
				  }
		 
		 
		 public void searchbuses() {
			 search_buses.click(); 
			 //Please enter source and destination
 
				  }
		 
		 

}


