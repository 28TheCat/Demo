package com.example.service.impl;

import com.example.dao.BookDao;
import com.example.entity.Book;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 图书业务逻辑层实现类
 */
@Service("bookService")
@Transactional
public class BookServiceImpl implements BookService {
    
    @Autowired
    private BookDao bookDao;
    
    @Override
    public int addBook(Book book) {
        return bookDao.insertBook(book);
    }
    
    @Override
    public int deleteBookById(Integer id) {
        return bookDao.deleteBookById(id);
    }
    
    @Override
    public int updateBook(Book book) {
        return bookDao.updateBook(book);
    }
    
    @Override
    public Book getBookById(Integer id) {
        return bookDao.selectBookById(id);
    }
    
    @Override
    public List<Book> getAllBooks() {
        return bookDao.selectAllBooks();
    }
    
    @Override
    public List<Book> getBooksByName(String name) {
        return bookDao.selectBooksByName(name);
    }
    
    @Override
    public List<Book> getBooksByCategory(String category) {
        return bookDao.selectBooksByCategory(category);
    }
    
    @Override
    public List<Book> getBooksByPage(Integer pageNum, Integer pageSize) {
        // 计算偏移量
        int offset = (pageNum - 1) * pageSize;
        return bookDao.selectBooksByPage(offset, pageSize);
    }
    
    @Override
    public int getBookCount() {
        return bookDao.selectBookCount();
    }
    
    @Override
    public int updateBookStock(Integer id, Integer stock) {
        return bookDao.updateBookStock(id, stock);
    }
}