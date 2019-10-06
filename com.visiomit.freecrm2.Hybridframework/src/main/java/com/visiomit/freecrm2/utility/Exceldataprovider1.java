package com.visiomit.freecrm2.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceldataprovider1 
{
	    static XSSFWorkbook wb;
	    static XSSFSheet sheet;
				
		public Exceldataprovider1() 
		{
			File fs=new File("D:\\vision_IT\\Material\\eclipse-jee-photon-R-win32-x86_64\\eclipse\\com.visiomit.freecrm2.Hybridframework\\TestData\\TestData1.xlsx");
			try {

				FileInputStream fins=new FileInputStream(fs);

				wb=new XSSFWorkbook(fins);
			} 
			catch (Exception e) 
			{
				System.out.println(e.getMessage()+e);
			}
		}
		public  int getNumericCellData(String Sheetname,int row,int col)
		{
			XSSFSheet sheet=wb.getSheet(Sheetname);
			double numeric=sheet.getRow(row).getCell(col).getNumericCellValue();
			return (int) numeric;
		}
		public  int getNumericCellData(int SheetIndex,int row,int col)
		{
			XSSFSheet sheet=wb.getSheetAt(SheetIndex);
			double numeric=sheet.getRow(row).getCell(col).getNumericCellValue();
			return (int) numeric;
		}

		public static String getStringCellData(int SheetIndex,int row,int col)
		{
			XSSFSheet sheet=wb.getSheetAt(SheetIndex);
			String Stringdata=sheet.getRow(row).getCell(col).getStringCellValue();
			return Stringdata;

		}

		public static  String getStringCellData(String Sheetname,int row,int col)
		{
			XSSFSheet sheet=wb.getSheet(Sheetname);
			String Stringdata=sheet.getRow(row).getCell(col).getStringCellValue();
			return Stringdata;

		}

		public Object[][]getExcelData(String Sheetname)
		{
			XSSFSheet sheet = wb.getSheet(Sheetname);
			int rows=sheet.getLastRowNum();
			int cols=sheet.getRow(0).getLastCellNum();
			System.out.println("rows : "+rows);
			System.out.println("Columns : "+cols);
			Object[][]excelData=new Object[rows][cols]; 

			for(int i=0;i<rows;i++)
			{
				for(int j=0;j<cols;j++)
				{
					excelData[i][j]=sheet.getRow(i+1).getCell(j).toString();
				}
			}

			return excelData;
		}
		
		public Object [][]getExcelData(int SheetIndex)
		{
			 XSSFSheet sheet = wb.getSheetAt(SheetIndex);
			int rows=sheet.getLastRowNum();
			int cols=sheet.getRow(0).getLastCellNum();
			Object[][]excelData=new Object[rows][cols]; 

			for(int i=0;i<rows;i++)
			{
				for(int j=0;j<cols;j++)
				{
					excelData[i][j]=sheet.getRow(i+1).getCell(j).toString();
				}
			}

			return excelData;
		}
	}


