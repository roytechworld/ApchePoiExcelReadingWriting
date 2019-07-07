package com.royProject.ExcelReadingWriting.Util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ReadExcel {
	
	public static void main(String[] args)
	{
		
		try
		{
		
	   FileInputStream excelFile = new FileInputStream(new File("D:\\new.xlsx"));
	  Workbook workbook = new XSSFWorkbook(excelFile);
		Sheet datatypeSheet = workbook.getSheetAt(0);
         Iterator<Row> iterator = datatypeSheet.iterator();

         while (iterator.hasNext()) {

             Row currentRow = iterator.next();
             Iterator<Cell> cellIterator = currentRow.iterator();

             while (cellIterator.hasNext()) {

                 Cell currentCell = cellIterator.next();
                 //getCellTypeEnum shown as deprecated for version 3.15
                 //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
                 if (currentCell.getCellType() == CellType.STRING) {
                     System.out.print(currentCell.getStringCellValue() + "--");
                 } else if (currentCell.getCellType() == CellType.NUMERIC) {
                     System.out.print(currentCell.getNumericCellValue() + "--");
                 }

             }
             System.out.println();

         }
     } catch (FileNotFoundException e) {
         e.printStackTrace();
     } catch (IOException e) {
         e.printStackTrace();
     }
		
		
	}
	

}
