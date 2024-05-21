package com.itheima.jvmoptimize.practice.oom.utils;

import org.springframework.stereotype.Component;

@Component
public class AliyunUtil {

    //阿里云审核接口调用
    public void verify(String content){
        try {
            /**
             *  调用第三方接口审核数据，但是此时网络出现问题，
             * 第三方接口长时间没有响应，此处使用休眠来模拟30秒
             */
            Thread.sleep(30 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
