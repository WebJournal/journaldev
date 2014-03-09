package com.journaldev.excel.read;

import java.util.List;

public class JavaExcelTest {

	public static void main(String[] args) {
		List<Country> list = ReadExcelFileToList.readExcelData("Sample.xlsx");
		
		System.out.println("Country List\n"+list);
		
		try {
			WriteListToExcelFile.writeCountryListToFile("Countries.xls", list);
			ReadExcelFormula.readExcelFormula("FormulaMultiply.xlsx");
			WriteExcelWithFormula.writeExcelWithFormula("Formulas.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
