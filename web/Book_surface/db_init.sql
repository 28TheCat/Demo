-- 数据库初始化脚本

-- 创建数据库（如果不存在）
CREATE DATABASE IF NOT EXISTS `book_management` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- 使用数据库
USE `book_management`;

-- 创建图书表
CREATE TABLE IF NOT EXISTS `book` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '图书ID',
  `name` VARCHAR(255) NOT NULL COMMENT '图书名称',
  `author` VARCHAR(100) NOT NULL COMMENT '作者',
  `publisher` VARCHAR(255) NOT NULL COMMENT '出版社',
  `publish_date` DATE DEFAULT NULL COMMENT '出版日期',
  `isbn` VARCHAR(50) NOT NULL COMMENT 'ISBN',
  `price` DOUBLE(10,2) NOT NULL COMMENT '价格',
  `stock` INT(11) NOT NULL DEFAULT '0' COMMENT '库存',
  `category` VARCHAR(50) DEFAULT NULL COMMENT '图书分类',
  `cover` VARCHAR(500) DEFAULT NULL COMMENT '图书封面',
  `description` TEXT DEFAULT NULL COMMENT '图书简介',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_isbn` (`isbn`),
  KEY `idx_name` (`name`),
  KEY `idx_author` (`author`),
  KEY `idx_category` (`category`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='图书表';

-- 插入测试数据
INSERT INTO `book` (`name`, `author`, `publisher`, `publish_date`, `isbn`, `price`, `stock`, `category`, `cover`, `description`) VALUES
('Java核心技术', 'Cay S. Horstmann', '机械工业出版社', '2022-01-01', '9787111707386', 128.00, 100, '科技', 'https://img3.doubanio.com/view/subject/l/public/s33847681.jpg', 'Java技术领域最经典的著作之一，全面介绍了Java SE的核心技术。'),
('深入理解计算机系统', 'Randal E. Bryant', '机械工业出版社', '2019-01-01', '9787111611744', 158.00, 80, '科技', 'https://img1.doubanio.com/view/subject/l/public/s33446961.jpg', '计算机科学领域的经典教材，深入讲解计算机系统的工作原理。'),
('活着', '余华', '作家出版社', '2012-08-01', '9787506365437', 20.00, 200, '文学', 'https://img3.doubanio.com/view/subject/l/public/s27270704.jpg', '讲述了农村人福贵悲惨的人生遭遇，展现了生命的顽强与尊严。'),
('百年孤独', '加西亚·马尔克斯', '南海出版公司', '2011-06-01', '9787544253994', 39.50, 150, '文学', 'https://img9.doubanio.com/view/subject/l/public/s6384262.jpg', '魔幻现实主义文学的代表作，讲述了布恩迪亚家族七代人的传奇故事。'),
('人类简史', '尤瓦尔·赫拉利', '中信出版社', '2014-11-01', '9787508647357', 68.00, 120, '历史', 'https://img3.doubanio.com/view/subject/l/public/s27271700.jpg', '从认知革命、农业革命到科学革命，重新解读人类发展史。'),
('原则', '瑞·达利欧', '中信出版社', '2018-01-01', '9787508684031', 88.00, 90, '管理', 'https://img2.doubanio.com/view/subject/l/public/s29167596.jpg', '桥水基金创始人瑞·达利欧分享的生活和工作原则。'),
('小王子', '安托万·德·圣-埃克苏佩里', '人民文学出版社', '2003-08-01', '9787020042494', 22.00, 300, '文学', 'https://img1.doubanio.com/view/subject/l/public/s1083147.jpg', '法国儿童文学短篇小说，讲述了小王子从自己星球出发前往地球的冒险故事。'),
('白夜行', '东野圭吾', '南海出版公司', '2013-01-01', '9787544260696', 39.50, 180, '文学', 'https://img2.doubanio.com/view/subject/l/public/s27182902.jpg', '东野圭吾的代表作，讲述了一对有着悲惨命运的少年少女的故事。'),
('追风筝的人', '卡勒德·胡赛尼', '上海人民出版社', '2006-05-01', '9787208061644', 29.00, 250, '文学', 'https://img3.doubanio.com/view/subject/l/public/s1727890.jpg', '讲述了阿富汗男孩阿米尔与仆人哈桑之间的友情故事。'),
('思考，快与慢', '丹尼尔·卡尼曼', '中信出版社', '2012-07-01', '9787508633558', 69.00, 110, '心理学', 'https://img1.doubanio.com/view/subject/l/public/s25708552.jpg', '诺贝尔经济学奖得主丹尼尔·卡尼曼关于思维与决策的经典著作。');

-- 创建读者表（可选）
-- CREATE TABLE IF NOT EXISTS `reader` (
--   `id` INT(11) NOT NULL AUTO_INCREMENT,
--   `name` VARCHAR(50) NOT NULL,
--   `id_card` VARCHAR(20) NOT NULL,
--   `phone` VARCHAR(20) NOT NULL,
--   `email` VARCHAR(100) DEFAULT NULL,
--   `address` VARCHAR(255) DEFAULT NULL,
--   `register_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
--   PRIMARY KEY (`id`),
--   UNIQUE KEY `idx_id_card` (`id_card`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='读者表';

-- 创建借阅表（可选）
-- CREATE TABLE IF NOT EXISTS `borrow_record` (
--   `id` INT(11) NOT NULL AUTO_INCREMENT,
--   `book_id` INT(11) NOT NULL,
--   `reader_id` INT(11) NOT NULL,
--   `borrow_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
--   `return_time` DATETIME DEFAULT NULL,
--   `status` TINYINT(4) NOT NULL DEFAULT '1' COMMENT '1: 借阅中, 2: 已归还, 3: 逾期',
--   PRIMARY KEY (`id`),
--   KEY `idx_book_id` (`book_id`),
--   KEY `idx_reader_id` (`reader_id`),
--   CONSTRAINT `fk_borrow_book` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`) ON DELETE CASCADE,
--   CONSTRAINT `fk_borrow_reader` FOREIGN KEY (`reader_id`) REFERENCES `reader` (`id`) ON DELETE CASCADE
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='借阅记录表';
