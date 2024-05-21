package com.itheima.springboot3nativedemo.practice.controller;

import com.itheima.springboot3nativedemo.practice.vo.UserVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/memory")
public class MemoryController {

    private List list = new ArrayList();
    int count = 0;

    @GetMapping
    public List<UserVO> memory() throws InterruptedException {
        while (true){
            System.out.println(count++);
            list.add(new byte[1024 * 1024 * 100]);
            Thread.sleep(1000L);
        }
    }

}
