package com.pangpan.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pangpan.mapper.BookMapper;
import com.pangpan.mapper.UserMapper;
import com.pangpan.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

    @Test
    void findAll() {
        List<Book> book =  bookMapper.findAll();
        System.out.println("打印打印打印打印"+book.toString());
    }

    @Test
    void findByPageService() {
        //使用Mybatis分页插件
        PageHelper.startPage(1,2);
        //调用分页查询方法，其实就是查询所有数据，mybatis自动帮我们进行分页计算
        List<Book> classInfos = bookMapper.findAll();
//        System.out.println(PageInfo<>(classInfos));
    }

    @Test
    void updateBook() {

        Book book = new Book();
        book.setId(3);
        book.setName("bb");
        book.setAuthor("B语言");
        int result = bookMapper.updateBook(book);
        System.out.println("result:"+result);
    }

    @Test
    void deleteBook() {
        int result = bookMapper.deleteBook(18);
        System.out.println("result="+result);
    }
}