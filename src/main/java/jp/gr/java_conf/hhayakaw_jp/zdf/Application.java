/**
 * Copyright (c) 2016 Oracle and/or its affiliates
 */
package jp.gr.java_conf.hhayakaw_jp.zdf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("Welcome to Zun-Doco flic !");
    }

}