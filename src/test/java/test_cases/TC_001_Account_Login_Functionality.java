package test_cases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.login_page;

public class TC_001_Account_Login_Functionality extends BaseClass {
	
	
	
	@Test(groups ="sanity")
	public void verify_Account_Login() {
		
		
		
		
		logger.info("Starting TC_001_Account_Login_Functionality");
		try {
		login_page loginpage = new login_page(driver);
		
		logger.info("Click Account Button");
		loginpage.Click_Account_Button();
		
		logger.info("Login section open");
		loginpage.Click_Login_Button();
		logger.info("Click on Log in button");
		
		// Assert that login window is displayed
		Assert.assertTrue(loginpage.isLoginWindowDisplayed(), "Login window not displayed");
		
		
		
		// Assert that login popup is displayed
		Assert.assertTrue(loginpage.Login_to_get_exciting_offers_popup(), "Login popup not displayed");
	
		loginpage.framechange();
		
		loginpage.clicksignin();
		} catch(Exception e){
			logger.error("Test Fail");
			logger.debug("Debug logs");
			Assert.fail();
		}
	
		logger.info("Finished test case TC_001");
	}
}