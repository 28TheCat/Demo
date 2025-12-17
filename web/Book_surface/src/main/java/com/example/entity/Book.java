package com.example.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 图书实体类
 */
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    
    // 图书ID
    private Integer id;
    
    // 图书名称
    private String name;
    
    // 作者
    private String author;
    
    // 出版社
    private String publisher;
    
    // 出版日期
    private Date publishDate;
    
    // ISBN
    private String isbn;
    
    // 价格
    private Double price;
    
    // 库存
    private Integer stock;
    
    // 图书分类
    private String category;
    
    // 图书封面
    private String cover;
    
    // 图书简介
    private String description;
    
    // 创建时间
    private Date createTime;
    
    // 更新时间
    private Date updateTime;
    
    // Getter和Setter方法
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public String getPublisher() {
        return publisher;
    }
    
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    public Date getPublishDate() {
        return publishDate;
    }
    
    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public Double getPrice() {
        return price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }
    
    public Integer getStock() {
        return stock;
    }
    
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    public String getCover() {
        return cover;
    }
    
    public void setCover(String cover) {
        this.cover = cover;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Date getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    public Date getUpdateTime() {
        return updateTime;
    }
    
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publishDate=" + publishDate +
                ", isbn='" + isbn + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", category='" + category + '\'' +
                ", cover='" + cover + '\'' +
                ", description='" + description + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}