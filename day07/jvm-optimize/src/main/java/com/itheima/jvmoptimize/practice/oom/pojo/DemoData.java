package com.itheima.jvmoptimize.practice.oom.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class DemoData {
    @ExcelProperty("测试")
    private String string;

}