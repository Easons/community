package com.pangpan.service;

import com.pangpan.mapper.BookMapper;
import com.pangpan.mapper.UserMapper;
import com.pangpan.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author pangpan
 * @date 2021-02-17
 */
@SpringBootTest
class BookServiceTest {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private UserMapper userMapper;

    @Test
    void selectById() {

//        userMapper.Sel(1);

        Book book =  bookMapper.SelectById(1);
        System.out.println("打印打印打印打印"+book.toString());

    }
}