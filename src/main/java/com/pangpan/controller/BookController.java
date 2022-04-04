package com.pangpan.controller;

import com.github.pagehelper.PageInfo;
import com.pangpan.model.Book;
import com.pangpan.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pangpan
 * @date 2021-02-18
 */
@RestController
@RequestMapping("/book")
@Api(value = "图书管理API")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/getBook")
    @ApiOperation("通过ID查询图书")
    public Book queryBookById(@ApiParam("图书ID") @RequestParam(name = "id") String id){

        System.out.println("id="+id);
        List<Book> list = new ArrayList<>();
        Book book = bookService.SelectById(Integer.valueOf(id));

        list.add(book);
        return book;
    }
    //    public List<Book> queryBookById(@PathVariable("id") String id){

    /**
     * 分页
     */
    @RequestMapping(value = "/pagehelper/{pageCode}/{pageSize}",method = RequestMethod.GET)
    public PageInfo<Book> findByPage(@PathVariable(value = "pageCode") int pageCode, @PathVariable(value = "pageSize") int pageSize) {
        System.out.println(pageCode+"...."+pageSize);
        PageInfo<Book> pageInfo = bookService.findByPageService(pageCode, pageSize);
        return pageInfo;
    }

    @GetMapping("/findAll")
    public List<Book> findAll(){

        List<Book> list = bookService.findAll();
        return list;
    }

//    @RequestMapping(value = "add/{name}/{author}",method = {RequestMethod.GET,RequestMethod.POST})
    @PostMapping(value = "/add")
//    public Object addBook(@PathVariable(value = "name") String name, @PathVariable(value = "author") String author){
    public Object addBook(@RequestBody Book book){

        System.out.println("...."+book.toString());
//        System.out.println(name+"...."+author);
//        Book book = new Book();
//        book.setName(name);
//        book.setAuthor(author);
        int result = bookService.addBook(book);
        if(result == 1){
            return "success";
        }else{
            return "erro";
        }
    }

    @PutMapping("/updateBook")
    public String updateBook(@RequestBody Book book){
        System.out.println("...."+book.toString());

        int result = bookService.updateBook(book);
        if(result == 1){
            return "success";
        }else{
            return "erro";
        }
    }

    @DeleteMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable(value = "id") Integer id){

        int result = bookService.deleteBook(id);

        if(result == 1){
            return "success";
        }else{
            return "erro";
        }
    }
}
