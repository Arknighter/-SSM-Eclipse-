/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50013
Source Host           : localhost:3306
Source Database       : new

Target Server Type    : MYSQL
Target Server Version : 50013
File Encoding         : 65001

Date: 2020-04-16 13:05:34
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `article`
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `arid` varchar(10) NOT NULL,
  `caid` int(11) NOT NULL,
  `arnumber` varchar(4) NOT NULL,
  `artitle` varchar(500) NOT NULL,
  `arimage` varchar(500) default NULL,
  `arcontent` varchar(4000) NOT NULL,
  `aruser` varchar(30) NOT NULL,
  `artime` varchar(30) NOT NULL,
  `arstate` varchar(1) NOT NULL,
  `clicks` int(11) default NULL,
  PRIMARY KEY  (`arid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1912061530', '1', '8', '学工', null, '<p>				</p><p><br/></p><p><br/></p><p><br/></p><p style=\"text-align: center;\"><br/></p><p><span style=\"font-size: 24px;\">地球大气圈武都区武都区单位低洼瞧得起我</span></p><p><br/></p><p><br/></p><p><br/></p><p>\r\n			</p>', 'teacher', '2019-12-06', '1', '2');
INSERT INTO `article` VALUES ('1912072057', '17', '12', '我爱学习', null, 'qwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwweeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeqweqweqw', 'lbw', '2019-12-07', '1', '7');
INSERT INTO `article` VALUES ('1912182029', '2', '18', '教学视频推荐', null, '<p>				</p><p><br/></p><p>网站 wwwxxxxxxxxxxx/xx<img src=\"http://img.baidu.com/hi/jx2/j_0002.gif\"/><img src=\"images/img/20191218/1576681589030090334.jpg\" title=\"1576681589030090334.jpg\" alt=\"illust_35687310_20191010_174628.jpg\"/></p><p><br/></p><p>\r\n			</p>', '测试er', '2019-12-18', '1', '65');
INSERT INTO `article` VALUES ('1912191772', '21', '19', '健身的好处', null, '<p>				</p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p style=\"text-align: center;\">wwww<img src=\"http://img.baidu.com/hi/babycat/C_0001.gif\"/></p><p><br/></p><p>wwwwwwwwww<img src=\"http://localhost:8080/Basic01/ueditor/jsp/upload/img/20200410/1586500247613083380.jpg\" title=\"1586500247613083380.jpg\" alt=\"2020.jpg\"/></p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p>\n			</p>', '测试er', '2019-12-19', '1', '13');
INSERT INTO `article` VALUES ('2004109688', '2', '20', '最新文章测试', null, '<p>钱钱<img src=\"http://localhost:8080/Basic01/ueditor/jsp/upload/img/20200410/1586497469353055014.jpg\" title=\"1586497469353055014.jpg\" alt=\"222.jpg\"/>钱钱<strong>钱钱钱钱钱钱钱钱钱钱钱钱嗡嗡嗡嗡嗡嗡嗡嗡嗡嗡嗡嗡嗡嗡嗡</strong></p>', 'er', '2020-04-10', '1', '13');

-- ----------------------------
-- Table structure for `catalog`
-- ----------------------------
DROP TABLE IF EXISTS `catalog`;
CREATE TABLE `catalog` (
  `caid` int(11) NOT NULL auto_increment,
  `caname` varchar(255) default NULL,
  `canumber` varchar(255) default NULL,
  `castate` varchar(2) default NULL,
  PRIMARY KEY  (`caid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of catalog
-- ----------------------------
INSERT INTO `catalog` VALUES ('1', '学工栏目', '8', '1');
INSERT INTO `catalog` VALUES ('2', '教学栏目', '1', '1');
INSERT INTO `catalog` VALUES ('3', '科研栏目', '2', '1');
INSERT INTO `catalog` VALUES ('17', '教师栏目', '3', '1');
INSERT INTO `catalog` VALUES ('19', '社会栏目', '4', '1');
INSERT INTO `catalog` VALUES ('20', '足球栏目', '5', '1');
INSERT INTO `catalog` VALUES ('21', '健身栏目', '6', '1');
INSERT INTO `catalog` VALUES ('22', '其他栏目', '7', '1');
INSERT INTO `catalog` VALUES ('23', '我的栏目', '11', '1');
INSERT INTO `catalog` VALUES ('24', '社会栏目', '9', '1');
INSERT INTO `catalog` VALUES ('30', '图片栏目', '10', '1');
INSERT INTO `catalog` VALUES ('31', '视频栏目new', '12', '2');
INSERT INTO `catalog` VALUES ('165', 'test123', '14', '2');
INSERT INTO `catalog` VALUES ('166', '333', '16', '2');
INSERT INTO `catalog` VALUES ('167', 'test12', '15', '2');
INSERT INTO `catalog` VALUES ('168', 'test2', '13', '1');
INSERT INTO `catalog` VALUES ('169', '2020new', '17', '2');
INSERT INTO `catalog` VALUES ('170', 'qq2021111', '19', '2');
INSERT INTO `catalog` VALUES ('171', '我的new栏目', '18', '1');
INSERT INTO `catalog` VALUES ('172', '测试栏目2', '20', '1');

-- ----------------------------
-- Table structure for `images`
-- ----------------------------
DROP TABLE IF EXISTS `images`;
CREATE TABLE `images` (
  `imid` int(11) NOT NULL auto_increment,
  `imtitle` varchar(30) default NULL,
  `imname` varchar(30) NOT NULL,
  `imdate` varchar(30) NOT NULL,
  `imstate` varchar(1) NOT NULL,
  PRIMARY KEY  (`imid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of images
-- ----------------------------

-- ----------------------------
-- Table structure for `manager`
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `managerid` int(11) NOT NULL auto_increment,
  `managername` varchar(20) NOT NULL,
  `passwd` varchar(15) NOT NULL,
  `mstate` varchar(1) NOT NULL,
  PRIMARY KEY  (`managerid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('20190096', '晏江海', '123', '1');
INSERT INTO `manager` VALUES ('20190097', 'holo', '123', '1');
INSERT INTO `manager` VALUES ('20190143', 'holo123', '123', '2');
INSERT INTO `manager` VALUES ('20190145', 'test1', '1', '1');
