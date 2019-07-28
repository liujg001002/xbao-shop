CREATE DATABASE IF NOT EXISTS `xbao_member`;# Character Set UTF8;
USE  `xbao_member`;
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mb_user
-- ----------------------------
DROP TABLE IF EXISTS `mb_user`;
CREATE TABLE `mb_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(32) NOT NULL COMMENT '密码，加密存储',
  `phone` varchar(20) DEFAULT NULL COMMENT '注册手机号',
  `email` varchar(50) DEFAULT NULL COMMENT '注册邮箱',
  `created` datetime NOT NULL,
  `updated` datetime NOT NULL,
  `openid` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`) USING BTREE,
  UNIQUE KEY `phone` (`phone`) USING BTREE,
  UNIQUE KEY `email` (`email`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of mb_user
-- ----------------------------
INSERT INTO `mb_user` VALUES ('37', 'yushengjun3', 'e10adc3949ba59abbe56e057f20f883e', '18608193682', '12345678911@qq.com', '2015-04-06 17:03:55', '2015-04-06 17:03:55', null);
INSERT INTO `mb_user` VALUES ('42', 'liujianguo', '96E79218965EB72C92A549DD5A330112', '12345678911', '1149159610@qq.com', '2019-07-23 17:45:21', '2019-07-23 17:45:21', null);


CREATE DATABASE IF NOT EXISTS `xbao_pay`;# Character Set UTF8;
USE  `xbao_pay`;
CREATE TABLE `payment_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT ,
  `userid` int(11) DEFAULT NULL COMMENT '用户id',
  `typeid` int(2) DEFAULT NULL,
  `orderid` varchar(50) DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `source` varchar(10) DEFAULT NULL,
  `state` int(2) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  `platformorderid` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;


CREATE DATABASE IF NOT EXISTS `xbao_order`;# Character Set UTF8;
USE  `xbao_order`;

CREATE TABLE `order_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderNumber` varchar(255) DEFAULT NULL COMMENT '订单编号',
  `isPay` int(50) DEFAULT NULL COMMENT '0 未支付，1已支付',
  `payId` varchar(100) DEFAULT NULL,
  `userId` int(50) DEFAULT NULL,
  `created` datetime NOT NULL,
  `updated` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
