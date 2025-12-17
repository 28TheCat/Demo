<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书列表</title>
<style type="text/css">
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f5f5f5;
    }
    .container {
        width: 90%;
        margin: 0 auto;
        padding: 20px;
    }
    .header {
        background-color: #4CAF50;
        color: white;
        padding: 15px;
        border-radius: 5px;
        margin-bottom: 20px;
    }
    .header h2 {
        margin: 0;
        display: inline;
    }
    .add-btn {
        float: right;
        background-color: white;
        color: #4CAF50;
        padding: 8px 16px;
        text-decoration: none;
        border-radius: 3px;
        font-weight: bold;
    }
    .add-btn:hover {
        background-color: #f0f0f0;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        background-color: white;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    th, td {
        padding: 12px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }
    th {
        background-color: #f2f2f2;
        font-weight: bold;
    }
    tr:hover {
        background-color: #f5f5f5;
    }
    .action-btn {
        padding: 6px 12px;
        text-decoration: none;
        border-radius: 3px;
        color: white;
        font-size: 14px;
        margin-right: 5px;
    }
    .edit-btn {
        background-color: #2196F3;
    }
    .edit-btn:hover {
        background-color: #0b7dda;
    }
    .delete-btn {
        background-color: #f44336;
    }
    .delete-btn:hover {
        background-color: #da190b;
    }
    .search-form {
        background-color: white;
        padding: 15px;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        margin-bottom: 20px;
    }
    .search-form input {
        padding: 8px;
        border: 1px solid #ddd;
        border-radius: 3px;
        margin-right: 5px;
    }
    .search-form button {
        padding: 8px 16px;
        background-color: #4CAF50;
        color: white;
        border: none;
        border-radius: 3px;
        cursor: pointer;
    }
    .search-form button:hover {
        background-color: #45a049;
    }
    .empty-message {
        text-align: center;
        padding: 50px;
        color: #666;
        font-size: 18px;
    }
</style>
</head>
<body>
    <div class="container">
        <div class="header">
            <h2>图书列表</h2>
            <a href="/book/add" class="add-btn">添加图书</a>
        </div>
        
        <div class="search-form">
            <form action="/book/list" method="get">
                <input type="text" name="name" placeholder="请输入图书名称" />
                <button type="submit">搜索</button>
            </form>
        </div>
        
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>名称</th>
                    <th>作者</th>
                    <th>出版社</th>
                    <th>ISBN</th>
                    <th>价格</th>
                    <th>库存</th>
                    <th>分类</th>
                    <th>创建时间</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
                <c:choose>
                    <c:when test="${not empty bookList}">
                        <c:forEach items="${bookList}" var="book">
                            <tr>
                                <td>${book.id}</td>
                                <td>${book.name}</td>
                                <td>${book.author}</td>
                                <td>${book.publisher}</td>
                                <td>${book.isbn}</td>
                                <td>${book.price}</td>
                                <td>${book.stock}</td>
                                <td>${book.category}</td>
                                <td>${book.createTime}</td>
                                <td>
                                    <a href="/book/edit/${book.id}" class="action-btn edit-btn">编辑</a>
                                    <a href="/book/delete/${book.id}" class="action-btn delete-btn" onclick="return confirm('确定要删除这本书吗？')">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td colspan="10" class="empty-message">暂无图书信息</td>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </tbody>
        </table>
    </div>
</body>
</html>