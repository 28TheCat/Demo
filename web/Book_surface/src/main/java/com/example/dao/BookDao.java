package com.example.dao;

import com.example.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 图书数据访问层接口
 */
public interface BookDao {
    
    /**
     * 添加图书
     * @param book 图书对象
     * @return 影响的行数
     */
    int insertBook(Book book);
    
    /**
     * 根据ID删除图书
     * @param id 图书ID
     * @return 影响的行数
     */
    int deleteBookById(@Param("id") Integer id);
    
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
    Book selectBookById(@Param("id") Integer id);
    
    /**
     * 查询所有图书
     * @return 图书列表
     */
    List<Book> selectAllBooks();
    
    /**
     * 根据名称模糊查询图书
     * @param name 图书名称
     * @return 图书列表
     */
    List<Book> selectBooksByName(@Param("name") String name);
    
    /**
     * 根据分类查询图书
     * @param category 图书分类
     * @return 图书列表
     */
    List<Book> selectBooksByCategory(@Param("category") String category);
    
    /**
     * 分页查询图书
     * @param offset 偏移量
     * @param limit 每页数量
     * @return 图书列表
     */
    List<Book> selectBooksByPage(@Param("offset") Integer offset, @Param("limit") Integer limit);
    
    /**
     * 查询图书总数
     * @return 图书总数
     */
    int selectBookCount();
    
    /**
     * 更新图书库存
     * @param id 图书ID
     * @param stock 库存数量
     * @return 影响的行数
     */
    int updateBookStock(@Param("id") Integer id, @Param("stock") Integer stock);
}