# Java SSM框架项目

## 项目简介
这是一个基于SSM（Spring + SpringMVC + MyBatis）框架的Java Web项目，用于实现图书管理系统的后端功能。

## 技术栈
- Spring 5.x
- SpringMVC 5.x
- MyBatis 3.x
- Maven 3.x
- MySQL 8.x
- Tomcat 9.x

## 项目结构
```
ssm-book-management/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           ├── controller/       # 控制器层
│   │   │           ├── dao/              # 数据访问层
│   │   │           ├── entity/           # 实体类
│   │   │           ├── service/          # 业务逻辑层
│   │   │           │   └── impl/         # 业务逻辑实现
│   │   │           └── util/             # 工具类
│   │   ├── resources/
│   │   │   ├── mapper/                   # MyBatis映射文件
│   │   │   ├── spring-config.xml         # Spring配置文件
│   │   │   ├── spring-mvc.xml            # SpringMVC配置文件
│   │   │   ├── mybatis-config.xml        # MyBatis配置文件
│   │   │   └── jdbc.properties           # 数据库连接配置
│   │   └── webapp/
│   │       ├── WEB-INF/
│   │       │   └── web.xml               # Web应用配置文件
│   │       └── index.jsp                 # 首页
│   └── test/                             # 测试代码
├── pom.xml                               # Maven依赖配置
└── README.md                             # 项目说明
```

## 功能模块
1. 图书管理
2. 读者管理
3. 借阅管理
4. 系统管理

## 启动说明
1. 配置MySQL数据库
2. 修改jdbc.properties中的数据库连接信息
3. 执行SQL脚本创建数据库表
4. 使用Maven构建项目
5. 部署到Tomcat服务器
6. 访问http://localhost:8080/ssm-book-management

## 开发环境
- JDK 1.8+
- IDE: IntelliJ IDEA 2020+
- Maven 3.6+
- MySQL 8.0+
- Tomcat 9.0+
