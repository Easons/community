package com.pangpan.service;

import com.pangpan.mapper.BookMapper;
import com.pangpan.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author pangpan
 * @date 2021-02-17
 */
@Service
public class BookService {

    @Autowired
    BookMapper bookMapper;

    public Book SelectById(int id) {
        return bookMapper.SelectById(id);
    }

}
