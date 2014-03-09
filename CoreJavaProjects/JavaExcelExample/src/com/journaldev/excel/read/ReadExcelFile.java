package com.journaldev.excel.read;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	public static void main(String[] args) throws IOException {
		Map<String,String> countryMap = new HashMap<String, String>();
		List<String> countryShortCodes = new ArrayList<String>();
		List<String> countryNames = new ArrayList<String>();
		
		FileInputStream file = new FileInputStream(new File(
				"ISOCountryCodes.xlsx"));

		// Create Workbook instance holding reference to .xlsx file
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		// Get first/desired sheet from the workbook
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		//Iterate through each rows one by one
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) 
        {
        	String key="";
    		String value="";
            Row row = rowIterator.next();
            //For each row, iterate through all the columns
            Iterator<Cell> cellIterator = row.cellIterator();
             
            while (cellIterator.hasNext()) 
            {
                Cell cell = cellIterator.next();
                //Check the cell type and format accordingly
                switch (cell.getCellType()) 
                {
                    case Cell.CELL_TYPE_STRING:
                        if(key.equals("")){
                        	key = cell.getStringCellValue().trim();
                        }else{
                        	value = cell.getStringCellValue().trim();
                        }
                        break;
                }
            }
            countryMap.put(value, key);
            countryNames.add(value);
            countryShortCodes.add(key);
            //System.out.println("");
        }
        file.close();
    
        //System.out.println(countryMap);
        //System.out.println(countryNames);
        //System.out.println(countryShortCodes);
        
        Collections.sort(countryNames);
        for(String name : countryNames){
        	System.out.print(name.trim()+":"+countryMap.get(name)+"|");
        }

	}

}
