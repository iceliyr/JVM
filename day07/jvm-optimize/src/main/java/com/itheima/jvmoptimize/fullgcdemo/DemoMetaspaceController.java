package com.itheima.jvmoptimize.fullgcdemo;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fullgcmeta")
public class DemoMetaspaceController {

    //-XX:MetaspaceSize=512M  -XX:MaxMetaspaceSize=512m
    @GetMapping("/test1")
    public void test1(int size) throws InterruptedException {
        for (int i = 0; i < size; i++) {
            //cglib生成动态代理对象
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(DemoMetaspaceController.class);
            //不使用缓存
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) ->
                    methodProxy.invokeSuper(o, objects));

            enhancer.create();
        }


    }
}
