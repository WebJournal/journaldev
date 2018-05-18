package com.journaldev.excel.read;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelWithFormula {

	public static void writeExcelWithFormula(String fileName) throws IOException{
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Numbers");
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue(10);
		row.createCell(1).setCellValue(20);
		row.createCell(2).setCellValue(30);
		//set formula cell
		row.createCell(3).setCellFormula("A1*B1*C1");
		
		//lets write to file
		FileOutputStream fos = new FileOutputStream(fileName);
		workbook.write(fos);
		fos.close();
		System.out.println(fileName + " written successfully");
	}
	
	public static void main(String[] args) throws IOException {
		writeExcelWithFormula("Formulas.xlsx");
	}
}
