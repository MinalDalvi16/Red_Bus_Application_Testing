package utils;

import java.io.File;
import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "SearchData")
	public String[][] getData() throws IOException {
		
		// Get project root directory
		String projectRoot = System.getProperty("user.dir");
		
		// Use relative path from project root
		String path = projectRoot + File.separator + "testdata" + File.separator + "testdata.xlsx";
		
		System.out.println("Excel file path: " + path);
		
		// Check if file exists
		File file = new File(path);
		if (!file.exists()) {
			System.out.println("❌ File NOT found at: " + path);
			throw new IOException("Excel file not found: " + path);
		}
		System.out.println("✓ File found!");
		
		// Create ExcelUtility object
		ExcelUtility xlutil = new ExcelUtility(path);
		
		// Get total rows and columns
		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1", 0);
		
		System.out.println("Total Rows: " + totalrows + " | Total Columns: " + totalcols);
		
		// Create 2D array to store data
		String[][] searchdata = new String[totalrows][totalcols];
		
		// Read data from Excel and store in array
		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				searchdata[i - 1][j] = xlutil.getCellData("Sheet1", i, j);
				System.out.println("Row " + i + " | Col " + j + ": " + searchdata[i - 1][j]);
			}
		}
		
		System.out.println("✓ Data loaded successfully!");
		return searchdata;
	}
}