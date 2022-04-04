package com.pangpan.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pangpan.mapper.BookMapper;
import com.pangpan.model.Book;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pangpan
 * @date 2021-02-17
 */
@Service
@Api(value = "图书管理")
public class BookService {

    @Autowired
    BookMapper bookMapper;

    public Book SelectById(int id) {
        return bookMapper.SelectById(id);
    }

    public List<Book> findAll() {
        return bookMapper.findAll();
    }

    @ApiOperation(value = "查询营业费用项名称", notes = "入参：通过营业费用项编码FEEITEM_CODE查询营业费用项名称")
    public PageInfo<Book> findByPageService(int pageCode, int pageSize) {
        //使用Mybatis分页插件
        PageHelper.startPage(pageCode,pageSize);
        //调用分页查询方法，其实就是查询所有数据，mybatis自动帮我们进行分页计算
        List<Book> classInfos = bookMapper.findAll();
        return new PageInfo<>(classInfos);
    }

    public int addBook(Book book) {
        return bookMapper.addBood(book);
    }

    public int updateBook(Book book) {
        return bookMapper.updateBook(book);
    }

    public int deleteBook(Integer id) {
        return bookMapper.deleteBook(id);
    }
}
