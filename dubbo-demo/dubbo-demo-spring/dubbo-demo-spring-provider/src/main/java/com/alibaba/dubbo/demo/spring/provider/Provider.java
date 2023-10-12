package com.alibaba.dubbo.demo.spring.provider;

import java.io.IOException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

@Configuration
@EnableDubbo(scanBasePackages = "com.alibaba.dubbo.demo.spring.provider.impl")
@PropertySource("classpath:/dubbo.properties")
public class Provider {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Provider.class);
        context.start();
        System.in.read();
    }
}
