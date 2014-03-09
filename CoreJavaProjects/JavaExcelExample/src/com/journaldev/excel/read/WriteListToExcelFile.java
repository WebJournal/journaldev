package com.journaldev.excel.read;

import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteListToExcelFile {

	public static void writeCountryListToFile(String fileName, List<Country> countryList) throws Exception{
		Workbook workbook = null;
		
		if(fileName.endsWith("xlsx")){
			workbook = new XSSFWorkbook();
		}else if(fileName.endsWith("xls")){
			workbook = new HSSFWorkbook();
		}else{
			throw new Exception("invalid file name, should be xls or xlsx");
		}
		
		Sheet sheet = workbook.createSheet("Countries");
		
		Iterator<Country> iterator = countryList.iterator();
		
		int rowIndex = 0;
		while(iterator.hasNext()){
			Country country = iterator.next();
			Row row = sheet.createRow(rowIndex++);
			Cell cell0 = row.createCell(0);
			cell0.setCellValue(country.getName());
			Cell cell1 = row.createCell(1);
			cell1.setCellValue(country.getShortCode());
		}
		
		//lets write the excel data to file now
		FileOutputStream fos = new FileOutputStream(fileName);
		workbook.write(fos);
		fos.close();
		System.out.println(fileName + " written successfully");
	}
	
	public static void main(String args[]) throws Exception{
		List<Country> list = ReadExcelFileToList.readExcelData("Sample.xlsx");
		WriteListToExcelFile.writeCountryListToFile("Countries.xls", list);
	}
}
