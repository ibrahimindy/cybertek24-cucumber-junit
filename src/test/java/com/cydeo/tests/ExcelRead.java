package com.cydeo.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.IOException;

public class ExcelRead {

    @Test
    public void readingFromExcel() throws IOException {
        XSSFWorkbook workbook=new XSSFWorkbook("Employees.xlsx");

        XSSFSheet worksheet=workbook.getSheet("data");

        System.out.println(worksheet.getRow(3).getCell(1));

    }
}
