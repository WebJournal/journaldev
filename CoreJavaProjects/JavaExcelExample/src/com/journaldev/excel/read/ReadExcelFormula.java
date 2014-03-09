package com.journaldev.excel.read;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFormula {

	public static void readExcelFormula(String fileName) throws IOException{
		
		FileInputStream fis = new FileInputStream(fileName);
		
		//assuming xlsx file
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) 
        {
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
            
            while (cellIterator.hasNext()) 
            {
            	Cell cell = cellIterator.next();
            	switch(cell.getCellType()){
            	case Cell.CELL_TYPE_NUMERIC:
            		System.out.println(cell.getNumericCellValue());
            		break;
            	case Cell.CELL_TYPE_FORMULA:
            		System.out.println("Cell Formula="+cell.getCellFormula());
            		System.out.println("Cell Formula Result Type="+cell.getCachedFormulaResultType());
            		if(cell.getCachedFormulaResultType() == Cell.CELL_TYPE_NUMERIC){
            			System.out.println("Formula Value="+cell.getNumericCellValue());
            		}
            	}
            }
        }
	}
	
	public static void main(String args[]) throws IOException {
		readExcelFormula("FormulaMultiply.xlsx");
	}
}
