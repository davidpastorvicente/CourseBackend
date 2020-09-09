package com.backend.course;

import com.backend.course.services.TemarioStorage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseManagerApplication implements CommandLineRunner {
    TemarioStorage temarioStorage;

    public static void main(String[] args) {
        SpringApplication.run(CourseManagerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        temarioStorage.deleteAll();
        temarioStorage.init();
    }
}
