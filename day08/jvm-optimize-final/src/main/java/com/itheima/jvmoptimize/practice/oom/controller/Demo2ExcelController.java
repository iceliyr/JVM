package com.itheima.jvmoptimize.practice.oom.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.poi.excel.BigExcelWriter;
import cn.hutool.poi.excel.ExcelUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.itheima.jvmoptimize.practice.oom.pojo.DemoData;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * -XX:+HeapDumpOnOutOfMemoryError
 */
@RestController
@RequestMapping("/excel")
public class Demo2ExcelController {

    @GetMapping("/export")
    public void export(int size, String path) throws IOException {
        // 1 、创建工作薄
        Workbook workbook = new XSSFWorkbook();
        // 2、在工作薄中创建sheet
        Sheet sheet = workbook.createSheet("测试");

        for (int i = 0; i < size; i++) {
            // 3、在sheet中创建行
            Row row0 = sheet.createRow(i);
            // 4、创建单元格并存入数据
            row0.createCell(0).setCellValue(RandomStringUtils.randomAlphabetic(1000));
        }


        // 将文件输出到指定文件
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(path + RandomStringUtils.randomAlphabetic(10) + ".xlsx");
            workbook.write(fileOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (workbook != null) {
                workbook.close();
            }
        }

    }


    //http://www.hutool.cn/docs/#/poi/Excel%E5%A4%A7%E6%95%B0%E6%8D%AE%E7%94%9F%E6%88%90-BigExcelWriter
    @GetMapping("/export_hutool")
    public void export_hutool(int size, String path) throws IOException {


        List<List<?>> rows = new ArrayList<>();
        for (int i = 0; i < size; i++) {
           rows.add( CollUtil.newArrayList(RandomStringUtils.randomAlphabetic(1000)));
        }

        BigExcelWriter writer= ExcelUtil.getBigWriter(path + RandomStringUtils.randomAlphabetic(10) + ".xlsx");
// 一次性写出内容，使用默认样式
        writer.write(rows);
// 关闭writer，释放内存
        writer.close();


    }


    //https://easyexcel.opensource.alibaba.com/docs/current/quickstart/write#%E9%87%8D%E5%A4%8D%E5%A4%9A%E6%AC%A1%E5%86%99%E5%85%A5%E5%86%99%E5%88%B0%E5%8D%95%E4%B8%AA%E6%88%96%E8%80%85%E5%A4%9A%E4%B8%AAsheet
    @GetMapping("/export_easyexcel")
    public void export_easyexcel(int size, String path,int batch) throws IOException {

        // 方法1: 如果写到同一个sheet
        String fileName = path + RandomStringUtils.randomAlphabetic(10) + ".xlsx";
        // 这里注意 如果同一个sheet只要创建一次
        WriteSheet writeSheet = EasyExcel.writerSheet("测试").build();
        // 这里 需要指定写用哪个class去写
        try (ExcelWriter excelWriter = EasyExcel.write(fileName, DemoData.class).build()) {
            // 分100次写入
            for (int i = 0; i < batch; i++) {
                // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
                List<DemoData> datas = new ArrayList<>();
                for (int j = 0; j < size / batch; j++) {
                    DemoData demoData = new DemoData();
                    demoData.setString(RandomStringUtils.randomAlphabetic(1000));
                    datas.add(demoData);
                }
                excelWriter.write(datas, writeSheet);
                //写入之后datas数据就可以释放了
            }
        }

    }
}
