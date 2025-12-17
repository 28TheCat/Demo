# Java SSM框架图书管理系统

## 项目简介
这是一个基于SSM（Spring + SpringMVC + MyBatis）框架开发的图书管理系统，提供图书的添加、查询、编辑和删除等功能。

## 技术栈
- **后端框架**: Spring 5.3.23 + SpringMVC 5.3.23 + MyBatis 3.5.10
- **数据库**: MySQL 8.0.30
- **连接池**: Druid 1.2.15
- **前端**: JSP + JSTL + CSS
- **构建工具**: Maven 3.6+

## 项目结构
```
ssm-book-management/
├── src/
│   ├── main/
│   │   ├── java/                  # Java源代码
│   │   │   └── com/example/
│   │   │       ├── controller/    # 控制器层
│   │   │       ├── dao/           # 数据访问层
│   │   │       ├── entity/        # 实体类
│   │   │       ├── service/       # 业务逻辑层
│   │   │       │   └── impl/      # 业务逻辑实现
│   │   │       └── util/          # 工具类
│   │   ├── resources/             # 资源文件
│   │   │   ├── mapper/            # MyBatis映射文件
│   │   │   ├── spring-config.xml  # Spring配置文件
│   │   │   ├── spring-mvc.xml     # SpringMVC配置文件
│   │   │   ├── mybatis-config.xml # MyBatis配置文件
│   │   │   └── jdbc.properties    # 数据库连接配置
│   │   └── webapp/                # Web应用文件
│   │       ├── WEB-INF/
│   │       │   ├── views/         # JSP视图文件
│   │       │   │   ├── book/      # 图书相关视图
│   │       │   │   └── error/     # 错误页面
│   │       │   └── web.xml        # Web应用配置
│   │       └── index.jsp          # 首页
│   └── test/                      # 测试代码
├── db_init.sql                    # 数据库初始化脚本
├── pom.xml                        # Maven依赖配置
└── README.md                      # 项目说明
```

## 功能模块
1. **图书管理**
   - 图书列表展示
   - 图书添加
   - 图书编辑
   - 图书删除
   - 图书搜索

## 环境要求
- JDK 1.8+
- MySQL 8.0+
- Maven 3.6+
- Tomcat 9.0+

## 部署步骤

### 1. 数据库配置
1. 安装MySQL数据库
2. 创建数据库和表结构，执行`db_init.sql`脚本
3. 修改`src/main/resources/jdbc.properties`文件中的数据库连接信息

### 2. 项目构建
1. 使用Maven构建项目：`mvn clean package`
2. 生成的WAR文件位于`target/ssm-book-management.war`

### 3. 部署到Tomcat
1. 将WAR文件复制到Tomcat的`webapps`目录下
2. 启动Tomcat服务器
3. 访问`http://localhost:8080/ssm-book-management`

## 访问路径
- 首页: `http://localhost:8080/ssm-book-management/`
- 图书列表: `http://localhost:8080/ssm-book-management/book/list`
- 添加图书: `http://localhost:8080/ssm-book-management/book/add`
- RESTful API: `http://localhost:8080/ssm-book-management/book/api/`

## RESTful API接口

### 1. 获取图书列表
```
GET /book/api/list
```

### 2. 根据ID获取图书
```
GET /book/api/{id}
```

### 3. 分页获取图书
```
GET /book/api/page?pageNum=1&pageSize=10
```

### 4. 搜索图书
```
GET /book/api/search?name=Java
```

## 数据库表结构

### book表
| 字段名 | 数据类型 | 描述 |
| --- | --- | --- |
| id | INT(11) | 图书ID，主键 |
| name | VARCHAR(255) | 图书名称 |
| author | VARCHAR(100) | 作者 |
| publisher | VARCHAR(255) | 出版社 |
| publish_date | DATE | 出版日期 |
| isbn | VARCHAR(50) | ISBN |
| price | DOUBLE(10,2) | 价格 |
| stock | INT(11) | 库存 |
| category | VARCHAR(50) | 图书分类 |
| cover | VARCHAR(500) | 图书封面 |
| description | TEXT | 图书简介 |
| create_time | DATETIME | 创建时间 |
| update_time | DATETIME | 更新时间 |

## 注意事项
1. 确保MySQL数据库服务正在运行
2. 根据实际情况修改数据库连接配置
3. 首次运行时请执行数据库初始化脚本
4. Tomcat默认端口为8080，如被占用请修改端口号

## 开发工具
- IDE: IntelliJ IDEA 2020+
- JDK: 1.8+
- MySQL: 8.0+
- Maven: 3.6+

## 许可证
MIT License