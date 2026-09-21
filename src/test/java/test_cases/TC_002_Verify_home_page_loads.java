package test_cases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.Home_Page;

public class TC_002_Verify_home_page_loads  extends BaseClass{

	
	
	@Test(groups ="Regression")
	
	public void verify_Home_Page() {
		
		
		logger.info("String TC_002_Verify_home_page_loads  ");
		Home_Page hp =new Home_Page(driver);
		
		//To verify banner content
		logger.info("Verify Banner content display");
		hp.isBannerContDisplayed();
		
		//To verify header text
		logger.info("verify header is display");
		hp.isheaderTextDisplayed();
		
		//To verify searchWidget section display
		logger.info("verify searchWidget display");
		hp.issearchWidgetDisplayed();
		
		//To verify search bus button click-able
		logger.info("verify serach bus button clikable");
		hp.searchbuses();
		
		logger.info("Finished test case TC_002");
	}
	
	
	
	
	
	
		
	}

