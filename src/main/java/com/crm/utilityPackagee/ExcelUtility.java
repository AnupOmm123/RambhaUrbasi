package com.crm.utilityPackagee;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author Anupam
 *
 * @param <WorkBook>
 */
public class ExcelUtility {
	/**
	 * to fetch the data from excel sheet
	 * @param sheetName
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public String getDataFromExcel(String sheetName,int rownum,int cellnum) throws EncryptedDocumentException, FileNotFoundException, IOException
	{
		
		Workbook workbook = WorkbookFactory.create(new FileInputStream(IConstants.excelpath));
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		org.apache.poi.ss.usermodel.Cell cell = row.getCell(cellnum);
		DataFormatter format =new DataFormatter();
		String value = format.formatCellValue(cell);
		return value;
		
		
		
	}
	/**
	 * to insa data into excel
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void insertIntoExcel(String sheetName,int rowNum,int cellNum,String data) throws EncryptedDocumentException, FileNotFoundException, IOException
	{
		Workbook workbook =WorkbookFactory.create(new FileInputStream(IConstants.excelpath));
		Sheet sheet=workbook.getSheet(sheetName);
		Row row =sheet.getRow(rowNum);
		org.apache.poi.ss.usermodel.Cell cell = row.createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream fileoutputstrea = new FileOutputStream(IConstants.excelpath);
		workbook.write(fileoutputstrea);
		
	}
	/**
	 * to get the last used row number from excel
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public int getLastrowNumFromExcel(String sheetName) throws EncryptedDocumentException, FileNotFoundException, IOException
	{
		Workbook workbook = WorkbookFactory.create(new FileInputStream(IConstants.excelpath));
		Sheet sheet=workbook.getSheet(sheetName);
		int row = sheet.getLastRowNum();
		return row;
		
	}
	

}
