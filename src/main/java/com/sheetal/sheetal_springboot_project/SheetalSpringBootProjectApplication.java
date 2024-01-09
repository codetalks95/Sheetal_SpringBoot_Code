package com.sheetal.sheetal_springboot_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SheetalSpringBootProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SheetalSpringBootProjectApplication.class, args);
        System.out.println("welcome to session");
        System.out.println("welcome to session1");
        System.out.println("Wlocme to session2");
        System.out.println("welocme to session 3");
        System.out.println("Testing purpose");
        test();
    }

    static void test() {
        System.out.println("Test method");
    }
}

