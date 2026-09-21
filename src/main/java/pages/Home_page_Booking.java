package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class Home_page_Booking extends BasePage {

	public Home_page_Booking(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath="//a[@aria-label=\"Bookings\"]") WebElement Booking;
	
	public void clickonBooking () {
		Booking.click();
	}

	
	

}
