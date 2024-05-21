package com.itheima.jvmoptimize.practice.demo.pojo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Data
public class DemoData {
    @ExcelProperty("测试")
    private String string;

}