<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加图书</title>
<style type="text/css">
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f5f5f5;
    }
    .container {
        width: 60%;
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
    }
    .form-container {
        background-color: white;
        padding: 30px;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    .form-group {
        margin-bottom: 20px;
    }
    .form-group label {
        display: block;
        margin-bottom: 5px;
        font-weight: bold;
        color: #333;
    }
    .form-group input,
    .form-group select,
    .form-group textarea {
        width: 100%;
        padding: 10px;
        border: 1px solid #ddd;
        border-radius: 3px;
        font-size: 16px;
    }
    .form-group textarea {
        height: 100px;
        resize: vertical;
    }
    .btn {
        padding: 12px 24px;
        background-color: #4CAF50;
        color: white;
        border: none;
        border-radius: 3px;
        font-size: 16px;
        cursor: pointer;
        margin-right: 10px;
    }
    .btn:hover {
        background-color: #45a049;
    }
    .btn-secondary {
        background-color: #6c757d;
    }
    .btn-secondary:hover {
        background-color: #5a6268;
    }
    .back-link {
        display: inline-block;
        margin-top: 20px;
        color: #2196F3;
        text-decoration: none;
    }
    .back-link:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>
    <div class="container">
        <div class="header">
            <h2>添加图书</h2>
        </div>
        
        <div class="form-container">
            <form action="/book/add" method="post">
                <div class="form-group">
                    <label for="name">图书名称</label>
                    <input type="text" id="name" name="name" required />
                </div>
                
                <div class="form-group">
                    <label for="author">作者</label>
                    <input type="text" id="author" name="author" required />
                </div>
                
                <div class="form-group">
                    <label for="publisher">出版社</label>
                    <input type="text" id="publisher" name="publisher" required />
                </div>
                
                <div class="form-group">
                    <label for="publishDate">出版日期</label>
                    <input type="date" id="publishDate" name="publishDate" required />
                </div>
                
                <div class="form-group">
                    <label for="isbn">ISBN</label>
                    <input type="text" id="isbn" name="isbn" required />
                </div>
                
                <div class="form-group">
                    <label for="price">价格</label>
                    <input type="number" id="price" name="price" step="0.01" min="0" required />
                </div>
                
                <div class="form-group">
                    <label for="stock">库存</label>
                    <input type="number" id="stock" name="stock" min="0" required />
                </div>
                
                <div class="form-group">
                    <label for="category">分类</label>
                    <select id="category" name="category" required>
                        <option value="">请选择分类</option>
                        <option value="文学">文学</option>
                        <option value="科技">科技</option>
                        <option value="教育">教育</option>
                        <option value="艺术">艺术</option>
                        <option value="生活">生活</option>
                        <option value="历史">历史</option>
                        <option value="哲学">哲学</option>
                        <option value="其他">其他</option>
                    </select>
                </div>
                
                <div class="form-group">
                    <label for="cover">封面</label>
                    <input type="text" id="cover" name="cover" placeholder="请输入封面图片URL" />
                </div>
                
                <div class="form-group">
                    <label for="description">简介</label>
                    <textarea id="description" name="description" placeholder="请输入图书简介"></textarea>
                </div>
                
                <div>
                    <button type="submit" class="btn">添加</button>
                    <button type="reset" class="btn btn-secondary">重置</button>
                </div>
            </form>
            
            <a href="/book/list" class="back-link">返回图书列表</a>
        </div>
    </div>
</body>
</html>