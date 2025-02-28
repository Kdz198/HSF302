package org.gr1fpt.hsfpe;

import org.gr1fpt.hsfpe.service.BookCategoryService;
import org.gr1fpt.hsfpe.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HsfpeApplication implements CommandLineRunner {

    @Autowired
    BookService bookService;
    @Autowired
    BookCategoryService bookCategoryService;

    public static void main(String[] args) {
        SpringApplication.run(HsfpeApplication.class, args);
        System.out.println("Hello FPT");
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println(bookCategoryService.getAll().toString());
    }
}
