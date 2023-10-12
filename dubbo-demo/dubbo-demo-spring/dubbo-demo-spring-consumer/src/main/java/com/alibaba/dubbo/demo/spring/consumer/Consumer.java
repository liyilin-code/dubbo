package com.alibaba.dubbo.demo.spring.consumer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.alibaba.dubbo.demo.spring.api.DemoService;

@Configuration
@ComponentScan("com.alibaba.dubbo.demo.spring.consumer")
@EnableDubbo
@PropertySource("classpath:/dubbo.properties")
public class Consumer {

    @Reference
    private DemoService service;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Consumer.class);
        context.start();

        Consumer consumer = context.getBean(Consumer.class);


    }
}
