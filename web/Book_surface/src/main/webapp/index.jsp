<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理系统</title>
<style type="text/css">
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f5f5f5;
    }
    .container {
        width: 80%;
        margin: 0 auto;
        padding: 20px;
    }
    .header {
        background-color: #4CAF50;
        color: white;
        padding: 20px;
        text-align: center;
    }
    .content {
        background-color: white;
        padding: 40px;
        margin-top: 20px;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        text-align: center;
    }
    .btn {
        display: inline-block;
        padding: 12px 24px;
        background-color: #4CAF50;
        color: white;
        text-decoration: none;
        border-radius: 5px;
        font-size: 18px;
        margin: 10px;
        transition: background-color 0.3s;
    }
    .btn:hover {
        background-color: #45a049;
    }
    .btn-primary {
        background-color: #2196F3;
    }
    .btn-primary:hover {
        background-color: #0b7dda;
    }
    .btn-danger {
        background-color: #f44336;
    }
    .btn-danger:hover {
        background-color: #da190b;
    }
    h1 {
        color: #333;
    }
    p {
        font-size: 18px;
        color: #666;
        line-height: 1.6;
    }
</style>
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>欢迎使用图书管理系统</h1>
        </div>
        <div class="content">
            <h1>图书管理系统</h1>
            <p>这是一个基于SSM框架开发的图书管理系统，提供图书的添加、查询、编辑和删除等功能。</p>
            <div>
                <a href="/book/list" class="btn btn-primary">查看图书列表</a>
                <a href="/book/add" class="btn btn-success">添加新图书</a>
            </div>
        </div>
    </div>
</body>
</html>