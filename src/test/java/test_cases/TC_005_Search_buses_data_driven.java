package test_cases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pages.Search_Bus;
import utils.DataProviders;

public class TC_005_Search_buses_data_driven extends BaseClass {
	
	private static final Logger logger = LogManager.getLogger(TC_005_Search_buses_data_driven.class);
	
	@BeforeMethod
	public void clearPage() throws InterruptedException {
		logger.info("========================================");
		logger.info("CLEARING PAGE BEFORE TEST");
		logger.info("========================================");
		try {
			//driver.navigate().back();
			driver.navigate().refresh();
			Thread.sleep(1000);
			logger.info("✓ Page cleared successfully");
		} catch (Exception e) {
			logger.error("❌ Error clearing page: " + e.getMessage());
			throw e;
		}
	}
	
	
	@AfterMethod
	public void backpage() {
	driver.navigate().back();
	}
	
	@Test(dataProvider = "SearchData", dataProviderClass = DataProviders.class)	
	public void SearchBus(String fromcity, String tocity) throws InterruptedException {
		
		logger.info("========================================");
		logger.info("TC_005 SEARCH BUS - DATA DRIVEN TEST");
		logger.info("========================================");
		logger.info("FROM CITY: " + fromcity);
		logger.info("TO CITY: " + tocity);
		logger.info("========================================");
		
		try {
			// Create Search_Bus object
			Search_Bus sb = new Search_Bus(driver);
			logger.info("✓ Search_Bus object created");
			
			// Step 1: Enter FROM city
			logger.info("STEP 1: Enter FROM city - " + fromcity);
			sb.enterFrom_city(fromcity);
			logger.info("✓ FROM city entered: " + fromcity);
			Thread.sleep(500);
			
			// Step 2: Click on first dropdown option for FROM
			logger.info("STEP 2: Click first option from FROM dropdown");
			sb.click_on_first_option_from_dropdown();
			logger.info("✓ First option selected from FROM dropdown");
			Thread.sleep(500);
			
			// Step 3: Enter TO city
			logger.info("STEP 3: Enter TO city - " + tocity);
			sb.enterTo_city(tocity);
			logger.info("✓ TO city entered: " + tocity);
			Thread.sleep(500);
			
			// Step 4: Click on first dropdown option for TO
			logger.info("STEP 4: Click first option from TO dropdown");
			sb.clickonTo_bus();
			logger.info("✓ First option selected from TO dropdown");
			Thread.sleep(500);
			
			// Step 5: Click Search button
			logger.info("STEP 5: Click Search Bus button");
			sb.clickonSearchBus();
			logger.info("✓ Search button clicked");
			Thread.sleep(2000);
			
			
			// Step 7: Verify results
			logger.info("STEP 7: Verify bus is displayed");
			boolean isDisplayed = sb.VerifyAfterSearch_Dolphin_Travel_House_display();
			logger.info("Bus displayed: " + isDisplayed);
			Assert.assertTrue(isDisplayed, "Zingbus plus should be displayed");
			
			
			
			
			
		} catch (Exception e) {
			logger.error("========================================");
			logger.error("❌❌❌ TEST FAILED ❌❌❌");
			logger.error("From: " + fromcity + " | To: " + tocity);
			logger.error("Error: " + e.getMessage());
			logger.error("========================================");
			e.printStackTrace();
			throw e;
		}
	}
}