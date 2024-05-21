package com.itheima.springbootclassfile.controller;

import com.itheima.springbootclassfile.common.UserType;
import com.itheima.springbootclassfile.pojo.vo.UserVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    //企业中代码一般通过调用service从数据库查,本案例简化代码
    @GetMapping("/{type}/{id}")
    public UserVO user(@PathVariable("type") Integer type,@PathVariable("id") Integer id){
        //前边有一大堆逻辑，巴拉巴拉
        if(type.equals(UserType.REGULAR.getType())){
            return new UserVO(id,"普通用户无权限查看");
        }

        return new UserVO(id,"这是尊贵的收费用户才能看的秘密!");
    }
}
