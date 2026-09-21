package test_cases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.Home_page_Booking;

public class TC_003_Verify_Booking_Page extends BaseClass {
	
	

	
	
	@Test(groups ="sanity")
	
	public void verify_booking_page() {
		Home_page_Booking homebooking =new Home_page_Booking(driver);
		homebooking.clickonBooking();
		
		
	}

}
