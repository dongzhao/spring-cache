package com.dzhao.exams.spring.ehcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by dzhao on 25/04/2016.
 */
@SpringBootApplication
public class EHCacheApp {

    public static void main(String[] args){
        SpringApplication.run(EHCacheApp.class, args);
    }
}
