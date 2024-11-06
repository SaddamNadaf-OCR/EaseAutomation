/* 
 * Project : EASE
 * Author  : Maheswara
 * created date : Aug 2018
 * Descriptions : Utilities.
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil
 * Reviewed by : Nil */

package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Utility {
	// Test cases Run mode method
	public static boolean isExecutable(String test_name, excel_reader excel) {

		String sheetName = "testcases";
		for (int rowNum = 2; rowNum <= excel.getRowCount(sheetName); rowNum++) {

			if (excel.getCellData(sheetName, "test_name", rowNum).equals(test_name)) {

				if (excel.getCellData(sheetName, "runmode", rowNum).equalsIgnoreCase("Y"))
					return true;
				else
					return false;
			}
		}
		return false;
	}

	// TestNG Parameterization
	public static Object[][] getData(String sheetName, excel_reader excel) {
		int rows = excel.getRowCount(sheetName) - 1;
		if (rows <= 0) {
			Object[][] testData = new Object[1][0];
			return testData;
		}
		rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		Object data[][] = new Object[rows - 1][cols];

		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			for (int colNum = 0; colNum < cols; colNum++) {				
				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
			}
		}
		return data;
	}
	
	// Get time stamp method
	public static String getTimeStamp() {
		return new SimpleDateFormat("@dd-MM-yyyy hh:mm:ss").format(new Date()).replaceAll("[-: ]", "_");
	}

	// ArchiveExtentReports method
	public static void archiveExtentReports(String path) {

		// verify that path should not be empty
		if (path != "") {

			// file object creation for 'archived' folder present inside extent-reports
			String archiveFolderName = "archived";
			File archiveFolder = new File(path + "\\" + archiveFolderName);

			try {

				// file object creation for extent-reports folder which is root directory for
				// entent reports
				File reportsRootDir = new File(path);

				// verifying root dir (extent-reports) is present in project working directory
				// or not
				if (reportsRootDir.exists()) {

					// get all the files and sub-directory names
					String[] dirListNames = reportsRootDir.list();

					// check with 'archived' sub-directory is present or not in root dir.
					if (!Arrays.asList(dirListNames).contains(archiveFolderName)) {
						try {
							archiveFolder.mkdir(); // create 'archived' folder if not already present
						} catch (Exception e) {
							System.out.println("failed to created archive folder , " + e.getMessage());
						}
					}

					// move all the existing (if any) reports to archived folder
					for (String name : dirListNames) {
						File reportFile = new File(reportsRootDir, name);
						if (reportFile.isFile()) {
							reportFile
							.renameTo(new File(archiveFolder.getAbsolutePath() + "\\" + reportFile.getName()));
						}
					}
				} else {
					System.out.println(reportsRootDir.getName()
							+ " folder is not present in project working directory, it should be created by extent-reports library "
							+ "hence please verify extent-reports statements in testCore.java file.");
				}

			} catch (NullPointerException npe) {
				System.out.println(npe.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		} else {
			System.out.println("Path argument is empty, please pass valid path value.");
		}
	}

}
