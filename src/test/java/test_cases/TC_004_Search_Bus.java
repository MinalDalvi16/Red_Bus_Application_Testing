package test_cases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.Search_Bus;

public class TC_004_Search_Bus extends BaseClass {
	
	
	@BeforeMethod
	public void clearPage() throws InterruptedException {
		logger.info("Clearing page before test...");
		driver.navigate().refresh();  // Refresh page to clear previous data
		Thread.sleep(1000);
	}
	
	@Test(groups="sanity")
	public void SearchBus() throws InterruptedException {
		
		logger.info("TC_004 Search bus Starting");
		
		// Create Search_Bus object
		Search_Bus sb = new Search_Bus(driver);
		
		// Step 1: Enter FROM city
		logger.info("Enter from City: Sion");
		sb.enterFrom_city("sion");
		Thread.sleep(500); // Wait for dropdown to appear
		
		// Step 2: Click on first dropdown option for FROM
		logger.info("Click on first option from FROM dropdown");
		sb.click_on_first_option_from_dropdown();
		Thread.sleep(500);
		
		// Step 3: Enter TO city
		logger.info("Enter to city: Pune");
		sb.enterTo_city("pune");
		Thread.sleep(500); // Wait for dropdown to appear
		
		// Step 4: Click on first dropdown option for TO
		logger.info("Click on first option from TO dropdown");
		sb.clickonTo_bus();
		Thread.sleep(500);
		
		// Step 5: Click Search button
		logger.info("Click on Search Bus button");
		sb.clickonSearchBus();
		Thread.sleep(2000); // Wait for results
		
		// Step 6: Verify results
		logger.info("Verify zingbus_plus is displayed");
		boolean isDisplayed = sb.VerifyAfterSearch_Dolphin_Travel_House_display();
		Assert.assertTrue(isDisplayed, "zingbus plus");
		
		logger.info("Test passed - zingbus plus bus found!");
	}
	
	
	// TEST 1: Validation message when both fields are empty
		@Test(priority = 1)
		public void TestValidationMessage_BothFieldsEmpty() throws InterruptedException {
			
			logger.info("============================================");
			logger.info("TEST 1: Validation message when both fields are empty");
			logger.info("============================================");
			
			Search_Bus sb = new Search_Bus(driver);
			
			logger.info("Step 1: Click Search button WITHOUT entering From and To cities");
			sb.clickonSearchBus();
			Thread.sleep(1000);
			
			logger.info("Step 2: Verify validation message is displayed");
			boolean isValidationShown = sb.isValidationMessageDisplayed();
			Assert.assertTrue(isValidationShown, 
				"Validation message should be displayed when both fields are empty");
			
			logger.info("Step 3: Get and verify validation message text");
			String validationText = sb.getValidationMessageText();
			logger.info("Validation Message: " + validationText);
			Assert.assertEquals(validationText, "Please enter source and destination", 
				"Validation message text should match");
			
			logger.info("✓ Test PASSED - Validation message verified!");
			logger.info("============================================\n");
		}
}