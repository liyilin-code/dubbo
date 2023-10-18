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

        // 当前Dubbo版本不支持如下操作
        // 原因是引入的服务代理对象仅仅注入了属性中
        // 并没有添加到Spring容器中
        //DemoService demoService = context.getBean(DemoService.class);
        //String resp = demoService.sayHello("liyilin");
        Consumer consumer = context.getBean(Consumer.class);
        String resp = consumer.service.sayHello("liyilin");
        System.out.println(resp);
    }
}
