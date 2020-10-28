package com.why.studentmanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.why.studentmanager.mapper")
@EnableTransactionManagement
public class StudentmanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentmanagerApplication.class, args);
    }

}
