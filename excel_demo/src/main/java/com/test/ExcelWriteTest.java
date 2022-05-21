package com.test;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ClassName ExcelWriteTest
 * @Description
 * @Author alms
 * @Data 2022/5/19 18:50
 **/
public class ExcelWriteTest {

    String path = "D:\\Github-alms\\Road_To_Learning\\excel_demo";

    @Test
    public void writeTest03() throws IOException {
        //1.����һ��������
        Workbook workbook = new HSSFWorkbook();
        //2.����һ��������
        Sheet sheet =workbook.createSheet("����ͳ�Ʊ�");
        //3. ����һ����
        Row row = sheet.createRow(0);
        //4.����һ����Ԫ��
        Cell cell11 = row.createCell(0);
        cell11.setCellValue("������������");
        Cell cell12 = row.createCell(1);
        cell12.setCellValue(666);

        Row row2 = sheet.createRow(1);
        Cell cell21 = row2.createCell(0);
        cell21.setCellValue("ͳ��ʱ��");
        Cell cell22 = row2.createCell(1);
        String s = new DateTime().toString("yyyy-MM-dd HH:mm:ss");
        cell22.setCellValue(s);

        FileOutputStream outputStream = new FileOutputStream(path + "03.xls");
        workbook.write(outputStream);
        outputStream.close();

        System.out.println("03excel�������");
    }
}
