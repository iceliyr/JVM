//package com.itheima.jvmoptimize.practice.demo.listener;
//
//import com.rabbitmq.client.Channel;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//
//@Component
//public class SpringRabbitListener {
//
//    @RabbitListener(queues = "queue1",concurrency = "10")
//    public void listenSimpleQueue(String msg) throws InterruptedException {
//        System.out.println(msg);
//        Thread.sleep(30 * 1000);
//    }
//
//
//}
