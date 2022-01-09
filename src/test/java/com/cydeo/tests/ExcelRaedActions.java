package com.cydeo.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.IOException;

public class ExcelRaedActions {

    String filePath="Employees.xlsx";

    @Test
    public void readExcelSheetData() throws IOException {
         // open the Employees.xlsx using Apache POI
        XSSFWorkbook workbook=new XSSFWorkbook(filePath);

        //Go to "data" sheet or go to getSheet(0)

        XSSFSheet dataSheet=workbook.getSheet("data");

        System.out.println("COLUMN NAMES: "+dataSheet.getRow(0).getCell(0));

        for (int i = 0; i <=2; i++) {
            System.out.println(dataSheet.getRow(0).getCell(i));
        }

        int rowsCount=dataSheet.getPhysicalNumberOfRows();
        System.out.println("rowsCount = "+rowsCount);


        for (int i = 1; i <=rowsCount; i++) {
            if (dataSheet.getRow(i).getCell(0).toString().equals("Fahima")){
                for (int j = 0; j <=2 ; j++) {
                    System.out.print(dataSheet.getRow(i).getCell(j)+" ");
                }
            }
            break;
        }

    }
}
