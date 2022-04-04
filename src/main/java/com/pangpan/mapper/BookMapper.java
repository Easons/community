package com.pangpan.mapper;

import com.pangpan.model.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author pangpan
 * @date 2021-02-17
 */
@Mapper
public interface BookMapper {

    public Book SelectById(int id);

    List<Book> findAll();

    int addBood(Book book);

    int updateBook(Book book);

    int deleteBook(Integer id);
}
