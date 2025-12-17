package com.example.service;

import com.example.entity.Book;

import java.util.List;

/**
 * 图书业务逻辑层接口
 */
public interface BookService {
    
    /**
     * 添加图书
     * @param book 图书对象
     * @return 影响的行数
     */
    int addBook(Book book);
    
    /**
     * 根据ID删除图书
     * @param id 图书ID
     * @return 影响的行数
     */
    int deleteBookById(Integer id);
    
    /**
     * 更新图书信息
     * @param book 图书对象
     * @return 影响的行数
     */
    int updateBook(Book book);
    
    /**
     * 根据ID查询图书
     * @param id 图书ID
     * @return 图书对象
     */
    Book getBookById(Integer id);
    
    /**
     * 查询所有图书
     * @return 图书列表
     */
    List<Book> getAllBooks();
    
    /**
     * 根据名称模糊查询图书
     * @param name 图书名称
     * @return 图书列表
     */
    List<Book> getBooksByName(String name);
    
    /**
     * 根据分类查询图书
     * @param category 图书分类
     * @return 图书列表
     */
    List<Book> getBooksByCategory(String category);
    
    /**
     * 分页查询图书
     * @param pageNum 页码
     * @param pageSize 每页数量
     * @return 图书列表
     */
    List<Book> getBooksByPage(Integer pageNum, Integer pageSize);
    
    /**
     * 查询图书总数
     * @return 图书总数
     */
    int getBookCount();
    
    /**
     * 更新图书库存
     * @param id 图书ID
     * @param stock 库存数量
     * @return 影响的行数
     */
    int updateBookStock(Integer id, Integer stock);
}