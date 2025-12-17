package com.example.controller;

import com.example.entity.Book;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 图书控制器类
 */
@Controller
@RequestMapping("/book")
public class BookController {
    
    @Autowired
    private BookService bookService;
    
    /**
     * 跳转到图书列表页面
     * @return 图书列表页面
     */
    @GetMapping("/list")
    public String bookList(Model model) {
        List<Book> bookList = bookService.getAllBooks();
        model.addAttribute("bookList", bookList);
        return "book/list";
    }
    
    /**
     * 跳转到添加图书页面
     * @return 添加图书页面
     */
    @GetMapping("/add")
    public String addBookPage() {
        return "book/add";
    }
    
    /**
     * 添加图书
     * @param book 图书对象
     * @return 重定向到图书列表页面
     */
    @PostMapping("/add")
    public String addBook(Book book) {
        bookService.addBook(book);
        return "redirect:/book/list";
    }
    
    /**
     * 跳转到编辑图书页面
     * @param id 图书ID
     * @param model 模型
     * @return 编辑图书页面
     */
    @GetMapping("/edit/{id}")
    public String editBookPage(@PathVariable("id") Integer id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "book/edit";
    }
    
    /**
     * 更新图书信息
     * @param book 图书对象
     * @return 重定向到图书列表页面
     */
    @PostMapping("/update")
    public String updateBook(Book book) {
        bookService.updateBook(book);
        return "redirect:/book/list";
    }
    
    /**
     * 删除图书
     * @param id 图书ID
     * @return 重定向到图书列表页面
     */
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Integer id) {
        bookService.deleteBookById(id);
        return "redirect:/book/list";
    }
    
    /**
     * 根据ID查询图书（RESTful API）
     * @param id 图书ID
     * @return 图书对象
     */
    @GetMapping("/api/{id}")
    @ResponseBody
    public ResponseEntity<Book> getBookById(@PathVariable("id") Integer id) {
        Book book = bookService.getBookById(id);
        if (book != null) {
            return new ResponseEntity<>(book, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    /**
     * 查询所有图书（RESTful API）
     * @return 图书列表
     */
    @GetMapping("/api/list")
    @ResponseBody
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> bookList = bookService.getAllBooks();
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }
    
    /**
     * 分页查询图书（RESTful API）
     * @param pageNum 页码
     * @param pageSize 每页数量
     * @return 图书列表
     */
    @GetMapping("/api/page")
    @ResponseBody
    public ResponseEntity<List<Book>> getBooksByPage(@RequestParam("pageNum") Integer pageNum, 
                                                    @RequestParam("pageSize") Integer pageSize) {
        if (pageNum == null || pageNum <= 0) {
            pageNum = 1;
        }
        if (pageSize == null || pageSize <= 0) {
            pageSize = 10;
        }
        List<Book> bookList = bookService.getBooksByPage(pageNum, pageSize);
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }
    
    /**
     * 根据名称搜索图书（RESTful API）
     * @param name 图书名称
     * @return 图书列表
     */
    @GetMapping("/api/search")
    @ResponseBody
    public ResponseEntity<List<Book>> searchBooksByName(@RequestParam("name") String name) {
        List<Book> bookList = bookService.getBooksByName(name);
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }
}