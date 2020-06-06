package com.qa.hubspot.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	public static FileInputStream file;
	public static Workbook workBook;
	public static Sheet sheet;
	public static String TEST_DATA_PATH = "C://Users//Krithik//TestNGNewFramework//SeleniumAutomation//"
			+ "src//main//java//com//qa//hubspotapp//testdata//HubSpotTestData.xlsx";

	
	public static Object[][] getTestDataFromExcel(String sheetName)
	{
		
	 try {
		file = new FileInputStream(TEST_DATA_PATH);
		 workBook = WorkbookFactory.create(file);
		 sheet = workBook.getSheet(sheetName);
	 		Object data[] [] = new Object[ sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	 		
	 		for(int i = 0; i<sheet.getLastRowNum(); i++)
	 		{
	 			for(int j = 0; j<sheet.getRow(0).getLastCellNum(); j++)
	 			{
	 				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
	 			}
	 		}
	 
	 return data;
	 
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return null;
	}
}
