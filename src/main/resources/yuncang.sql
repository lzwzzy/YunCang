/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50623
Source Host           : localhost:3306
Source Database       : yuncang

Target Server Type    : MYSQL
Target Server Version : 50623
File Encoding         : 65001

Date: 2017-09-05 18:14:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for goodsbill
-- ----------------------------
DROP TABLE IF EXISTS `goodsbill`;
CREATE TABLE `goodsbill` (
  `goods_id` bigint(20) NOT NULL COMMENT '商品id',
  `goods_name` varchar(100) NOT NULL COMMENT '商品名称',
  `goods_price` double NOT NULL COMMENT '商品价格',
  `goods_stock` mediumtext NOT NULL COMMENT '商品库存',
  `proffered_id` bigint(20) NOT NULL COMMENT '供货商id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '入库时间',
  `remarks` varchar(100) DEFAULT NULL COMMENT '备注',
  `goods_type` tinyint(5) NOT NULL DEFAULT '0' COMMENT '商品分类：默认0->其他，1->手机数码，2->百货,3->图书',
  `state` tinyint(4) NOT NULL DEFAULT '1',
  `isdelete` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';

-- ----------------------------
-- Records of goodsbill
-- ----------------------------
INSERT INTO `goodsbill` VALUES ('123123', '哈哈', '123', '123', '800002', '2017-07-27 10:58:16', '123', '1', '1', '1');
INSERT INTO `goodsbill` VALUES ('201705110001', 'xiaomi2', '1000', '26', '800001', '2017-05-12 08:09:49', null, '1', '1', '1');
INSERT INTO `goodsbill` VALUES ('201705110002', 'iphone7', '4999', '100', '800001', '2017-05-12 15:57:54', null, '1', '1', '1');
INSERT INTO `goodsbill` VALUES ('201705110003', 'iphone7Plus', '5999', '100', '800001', '2017-05-12 15:57:54', null, '1', '1', '1');
INSERT INTO `goodsbill` VALUES ('201705110004', '坚果手机2', '1999', '10059', '800001', '2017-05-12 15:57:54', null, '1', '1', '1');
INSERT INTO `goodsbill` VALUES ('201705110005', '魅蓝6', '1499', '80', '800001', '2017-05-12 15:57:54', null, '1', '1', '1');
INSERT INTO `goodsbill` VALUES ('201705110006', '魅族Pro7', '2999', '80', '800001', '2017-05-12 15:57:54', null, '1', '1', '1');
INSERT INTO `goodsbill` VALUES ('201705110007', '一加手机4', '2999', '201', '800001', '2017-05-12 15:57:54', null, '1', '1', '1');
INSERT INTO `goodsbill` VALUES ('201705110008', '华为P10', '3999', '100', '800002', '2017-05-12 15:57:54', null, '1', '1', '1');
INSERT INTO `goodsbill` VALUES ('201705110009', 'MacBookAir', '6999', '100', '800002', '2017-05-12 15:57:54', null, '1', '1', '1');
INSERT INTO `goodsbill` VALUES ('201705110010', 'MacBookPro', '9999', '100', '800002', '2017-05-12 15:57:54', null, '1', '1', '1');
INSERT INTO `goodsbill` VALUES ('201705110011', '华为荣耀7', '1599', '100', '800002', '2017-05-12 15:57:54', '', '1', '1', '1');
INSERT INTO `goodsbill` VALUES ('201705110012', '360手机4', '2599', '100', '800002', '2017-05-12 15:57:54', null, '1', '1', '1');
INSERT INTO `goodsbill` VALUES ('201705110013', '锤子手机3', '2999', '100', '800002', '2017-05-12 15:57:54', null, '1', '1', '1');
INSERT INTO `goodsbill` VALUES ('201705110014', '达尔优机械键盘', '499', '100', '800002', '2017-05-12 15:57:54', null, '1', '1', '1');
INSERT INTO `goodsbill` VALUES ('201705110015', '雷蛇机械键盘', '899', '100', '800002', '2017-05-12 15:57:54', null, '1', '1', '1');
INSERT INTO `goodsbill` VALUES ('201705140099', '牧马人鼠标2', '189', '1000', '800002', '2017-05-14 13:09:40', '123', '1', '1', '1');
INSERT INTO `goodsbill` VALUES ('201705140100', '华为P9', '2999', '160', '800002', '2017-05-14 23:28:33', '1', '1', '1', '1');
INSERT INTO `goodsbill` VALUES ('201705150001', '第一行代码', '59', '100', '800002', '2017-05-15 08:55:43', '郭霖著', '3', '1', '1');
INSERT INTO `goodsbill` VALUES ('201705150002', '物联网与嵌入式系统开发', '25', '100', '800001', '2017-05-15 09:01:45', '123', '3', '1', '1');
INSERT INTO `goodsbill` VALUES ('201705150003', '计算机组成原理', '29', '100', '800001', '2017-05-15 09:16:21', '1234', '1', '1', '1');
INSERT INTO `goodsbill` VALUES ('201705150004', '第二行代码', '60', '150', '800001', '2017-05-15 10:45:56', '1', '3', '1', '1');
INSERT INTO `goodsbill` VALUES ('201705150005', '小米平板3', '1999', '88', '800001', '2017-05-15 10:47:19', '123', '1', '1', '1');
INSERT INTO `goodsbill` VALUES ('201705150006', 'java艺术', '25', '15', '800002', '2017-05-15 11:22:49', '1', '3', '1', '1');
INSERT INTO `goodsbill` VALUES ('201705150007', '华硕U305X', '5999', '100', '800002', '2017-05-15 11:27:39', '1', '1', '1', '1');
INSERT INTO `goodsbill` VALUES ('201705150008', '500ml水杯', '49', '200', '800001', '2017-05-15 11:33:17', '123', '2', '1', '1');
INSERT INTO `goodsbill` VALUES ('201705150010', '小米笔记本', '4999', '100', '800002', '2017-05-15 11:41:08', '', '1', '1', '1');
INSERT INTO `goodsbill` VALUES ('201705150015', 'web开发技术1', '39', '200', '800002', '2017-05-15 19:11:18', '', '3', '1', '1');
INSERT INTO `goodsbill` VALUES ('201705200001', '123', '12', '12', '800001', '2017-05-20 17:07:00', '', '2', '1', '0');
INSERT INTO `goodsbill` VALUES ('201705210001', '123', '123', '123', '800001', '2017-05-21 21:53:30', '', '1', '1', '0');
INSERT INTO `goodsbill` VALUES ('201705210002', '123', '123', '123', '800001', '2017-05-21 21:54:42', '', '1', '1', '0');
INSERT INTO `goodsbill` VALUES ('201705210003', '123', '12', '12', '800001', '2017-05-21 21:56:57', '1', '1', '1', '0');
INSERT INTO `goodsbill` VALUES ('201705310001', '惠普P17', '6999', '105', '800003', '2017-05-31 13:48:39', '新品上架', '1', '0', '1');

-- ----------------------------
-- Table structure for importbill
-- ----------------------------
DROP TABLE IF EXISTS `importbill`;
CREATE TABLE `importbill` (
  `import_id` bigint(30) NOT NULL COMMENT '进货单号',
  `goods_id` bigint(20) NOT NULL COMMENT '商品id',
  `proffered_id` bigint(20) NOT NULL COMMENT '供货商号',
  `import_price` double NOT NULL COMMENT '进货单价',
  `import_count` int(11) NOT NULL COMMENT '进货数量',
  `import_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '进货时间',
  `remarks` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`import_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='进货表';

-- ----------------------------
-- Records of importbill
-- ----------------------------
INSERT INTO `importbill` VALUES ('20170521000001', '201705110001', '800001', '1500', '1000', '2017-05-21 20:42:03', '');
INSERT INTO `importbill` VALUES ('20170521000002', '201705140100', '800002', '2000', '10', '2017-05-21 22:07:01', '');
INSERT INTO `importbill` VALUES ('20170522000001', '201705110001', '800001', '100', '100', '2017-05-22 15:50:43', '');
INSERT INTO `importbill` VALUES ('20170522000002', '201705110007', '800001', '1800', '101', '2017-05-22 22:50:49', '');
INSERT INTO `importbill` VALUES ('20170524000001', '201705110001', '800001', '1800', '10', '2017-05-24 17:11:48', '');
INSERT INTO `importbill` VALUES ('20170524000002', '201705110001', '800001', '1000', '2', '2017-05-24 23:40:14', '');
INSERT INTO `importbill` VALUES ('20170525000001', '201705110001', '800001', '1200', '10', '2017-05-25 22:18:57', '');
INSERT INTO `importbill` VALUES ('20170526000001', '201705110001', '800001', '1200', '12', '2017-05-26 10:38:08', '');
INSERT INTO `importbill` VALUES ('20170527000001', '201705110001', '800001', '2000', '2', '2017-05-27 22:47:46', '');
INSERT INTO `importbill` VALUES ('20170528000001', '201705110005', '800001', '1800', '10', '2017-05-28 22:09:11', '');
INSERT INTO `importbill` VALUES ('20170531000001', '201705150008', '800001', '15', '100', '2017-05-31 13:47:15', '销量火爆，');
INSERT INTO `importbill` VALUES ('20170531000002', '201705310001', '800003', '5999', '5', '2017-05-31 13:49:33', '新品，慎进');

-- ----------------------------
-- Table structure for profferbill
-- ----------------------------
DROP TABLE IF EXISTS `profferbill`;
CREATE TABLE `profferbill` (
  `proffered_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '供货商id',
  `proffered_name` varchar(100) NOT NULL COMMENT '供货商名称',
  `main_business` varchar(50) DEFAULT NULL COMMENT '主营业务',
  `contact_phone` varchar(12) NOT NULL COMMENT '联系电话',
  `contact_person` varchar(8) NOT NULL COMMENT '联系人',
  `proffered_fax` varchar(20) DEFAULT NULL COMMENT '供货商传真',
  `proffered_address` varchar(100) NOT NULL COMMENT '供货商地址',
  `remarks` varchar(100) DEFAULT NULL COMMENT '备注',
  `isdelete` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`proffered_id`)
) ENGINE=InnoDB AUTO_INCREMENT=800006 DEFAULT CHARSET=utf8 COMMENT='供货商表';

-- ----------------------------
-- Records of profferbill
-- ----------------------------
INSERT INTO `profferbill` VALUES ('800001', '辽宁大连供货商', '数码，手机', '17600575454', '诸葛亮', '0521-123411', '大连市甘井子区红凌路19号', '重要', '1');
INSERT INTO `profferbill` VALUES ('800002', '北京供货商', '数码，手机，电脑', '18941135757', '邹瑜', '0100-456733', '北京市通州区小堡工业区26号', null, '1');
INSERT INTO `profferbill` VALUES ('800003', '沈阳供货商', '食品', '1523456789', '那个谁', '0521-67456723', '沈阳开发区-', null, '1');
INSERT INTO `profferbill` VALUES ('800005', '蒙牛大连区供货商', '奶制品', '18934556778', '郭靖', '0531-3455678', '大连市高新区数码路53号', '重要客户', '1');

-- ----------------------------
-- Table structure for salebill
-- ----------------------------
DROP TABLE IF EXISTS `salebill`;
CREATE TABLE `salebill` (
  `sale_id` bigint(20) NOT NULL COMMENT '销售单号',
  `goods_id` bigint(20) NOT NULL COMMENT '商品编号',
  `sale_count` int(11) NOT NULL COMMENT '销售数量',
  `sale_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '销售时间',
  `remarks` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`sale_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='销售表';

-- ----------------------------
-- Records of salebill
-- ----------------------------
INSERT INTO `salebill` VALUES ('20170524000001', '201705110001', '10', '2017-05-24 23:30:26', '');
INSERT INTO `salebill` VALUES ('20170524000002', '201705110006', '10', '2017-05-24 23:34:41', '');
INSERT INTO `salebill` VALUES ('20170524000003', '201705110001', '10', '2017-05-24 23:39:12', '');
INSERT INTO `salebill` VALUES ('20170524000005', '201705110001', '10', '2017-05-24 23:49:11', '');
INSERT INTO `salebill` VALUES ('20170525000001', '201705110001', '12', '2017-05-25 16:11:07', '');
INSERT INTO `salebill` VALUES ('20170525000002', '201705150005', '12', '2017-05-25 17:03:14', '');
INSERT INTO `salebill` VALUES ('20170525000003', '201705110001', '12', '2017-05-25 17:03:22', '');
INSERT INTO `salebill` VALUES ('20170525000004', '201705110001', '12', '2017-05-25 17:03:28', '');
INSERT INTO `salebill` VALUES ('20170525000005', '201705110001', '1900', '2017-05-25 17:03:53', '');
INSERT INTO `salebill` VALUES ('20170525000006', '201705110001', '10', '2017-05-25 17:04:04', '');
INSERT INTO `salebill` VALUES ('20170525000007', '201705110001', '12', '2017-05-25 17:05:13', '');
INSERT INTO `salebill` VALUES ('20170526000001', '201705110001', '10', '2017-05-26 15:01:59', '');
INSERT INTO `salebill` VALUES ('20170526000002', '201705110006', '10', '2017-05-26 15:02:49', '');
INSERT INTO `salebill` VALUES ('20170527000001', '201705110001', '10', '2017-05-27 22:47:09', '');
INSERT INTO `salebill` VALUES ('20170528000001', '201705110001', '10', '2017-05-28 22:08:20', '');
INSERT INTO `salebill` VALUES ('20170605000001', '201705110005', '10', '2017-06-05 10:14:19', '123');
INSERT INTO `salebill` VALUES ('20170606000001', '201705110004', '12', '2017-06-06 23:26:18', '');
INSERT INTO `salebill` VALUES ('20170607000001', '201705110005', '10', '2017-06-07 13:58:41', '');
INSERT INTO `salebill` VALUES ('20170622000001', '201705110005', '10', '2017-06-22 14:47:27', '12121');
INSERT INTO `salebill` VALUES ('20170708000001', '201705110004', '30', '2017-07-08 16:47:20', '');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(18) NOT NULL COMMENT '用户密码',
  `phone` bigint(11) NOT NULL COMMENT '用户手机号码',
  `sex` varchar(10) DEFAULT NULL COMMENT '用户性别',
  `email` varchar(20) DEFAULT NULL,
  `introduce` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `user_username_uindex` (`username`),
  UNIQUE KEY `user_userid_uindex` (`userid`),
  UNIQUE KEY `user_email_uindex` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2', 'blackboy123', 'lzwzzy', '18943212345', '', '', null);
INSERT INTO `user` VALUES ('4', 'blackboy1', '123', '18921212121', '女', '1129459766@qq.com', null);
INSERT INTO `user` VALUES ('5', 'kdifdasd', '123456', '18941168787', null, null, null);
INSERT INTO `user` VALUES ('6', 'sdasdadad', '123456', '18922323232', null, null, null);
INSERT INTO `user` VALUES ('7', 'blackboy123456', 'lzwzzy0602', '18923233434', '男', '1083330334@qq.com', null);
INSERT INTO `user` VALUES ('8', 'qwerqwer', '123456', '18923453434', '女', '1128456999@qq.com', null);
INSERT INTO `user` VALUES ('9', 'blackboy', 'lzwzzy0602', '18840810474', null, null, null);
