package com.alibaba.dubbo.demo.spring.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.alibaba.dubbo.demo.spring.api.DemoService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

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

        DemoService demoService = context.getBean(DemoService.class);
        String resp = demoService.sayHello("liyilin");
        System.out.println(resp);
    }
}
