package com.itheima.javaagent.enhancer;

import net.bytebuddy.asm.Advice;

public class MyAdvice {

    //方法进入时，打印所有参数，返回开始时间
    @Advice.OnMethodEnter
    static long enter(@Advice.AllArguments Object[] ary){
        if(ary != null){
            for (int i = 0; i < ary.length; i++) {
                System.out.println("参数:" + i + " 内容:" + ary[i]);
            }
        }

        return System.nanoTime();
    }

    //方法退出时候，统计方法执行耗时
    @Advice.OnMethodExit
    static void exit(@Advice.Enter long value){
        System.out.println("耗时为: " + (System.nanoTime() - value) + "纳秒");
    }
}
