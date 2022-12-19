package com.ecom.spicejet.genericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
  
	FileInputStream fis=null;
	Workbook wb=null;

	/**
	 * This method is used to Fetch the data from excel
	 * @param excelPath
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @return
	 */
	public String getExcelData(String excelPath,String sheetName,int row,int cell)
	{

		try {
			fis = new FileInputStream(excelPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		DataFormatter df=new DataFormatter();
		String data = df.formatCellValue(wb.getSheet(sheetName).getRow(row).getCell(cell));
		return data;
	}

	/**
	 * This method is used to Close the Browser
	 */
	public void closeExcel()
	{
		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is used is used to get the data from excel using key
	 * @param excelPath
	 * @param sheetName
	 * @param testCaseName
	 * @param columnName
	 * @return
	 */
	public String getExcelDataUsingKey(String excelPath, String sheetName,String testCaseName,String columnName )
	{
		String data="";
		try {
			fis=new FileInputStream(excelPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			wb=WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		DataFormatter df = new DataFormatter();

		try
		{
			Sheet sheet = wb.getSheet(sheetName);
			int rowLength = sheet.getLastRowNum();
			int cellLength = sheet.getRow(0).getLastCellNum();
			String expectedTestCasesName = testCaseName;
			String expectedColumnName = columnName;
			for(int i=0; i<=rowLength; i++)
			{
				String actualTestCaseName = sheet.getRow(i).getCell(0).toString(); 
				if( expectedTestCasesName.equals(actualTestCaseName))
				{
					for(int j=1; j<cellLength;j++)
					{
						String actualColumnName = sheet.getRow(i).getCell(j).toString();
						if(expectedColumnName.equals(actualColumnName))
						{
							data=df.formatCellValue(sheet.getRow(i+1).getCell(j));
							break;
						}
					}
					break;
				}
			}	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	/**
	* used to get the last used row number on specified Sheet
	* @param sheetName
	* @return
	* @throws Throwable
	*/
	public int getRowCount(String sheetName) throws Throwable {
	FileInputStream fis = new FileInputStream("./src/test/resources/TestData.Kagilo.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetName);
	wb.close();
	return sh.getLastRowNum();
	}
}
