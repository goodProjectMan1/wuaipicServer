/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : wuaipic

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 11/11/2019 15:30:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for blog_t
-- ----------------------------
DROP TABLE IF EXISTS `blog_t`;
CREATE TABLE `blog_t`  (
  `blog_id` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `blog_title` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `blog_label` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `be_top` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `blog_content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `blog_status` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`blog_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_t
-- ----------------------------
INSERT INTO `blog_t` VALUES ('21bbc36b62624ed7bb9eeaf17e28c049', '1111', '0', NULL, '111111', '1', '2019-11-01 11:55:12', NULL);
INSERT INTO `blog_t` VALUES ('cdefb95cea13461db42c51bf5072120f', 'Nginx初学（一）安装与运行', '1', NULL, '<p>（注：本文章的操作在centOS下完成）</p><p>1、下载nginx安装包 nginx-1.6.3.tar.gz并复制安装包到 /usr/local/software中</p><p>2、安装依赖包，命令如下(安装期间出现选择项，一路选择 “y”)：</p><div class=\"cnblogs_code\"><div class=\"cnblogs_code_toolbar\"><span class=\"cnblogs_code_copy\"><a title=\"复制代码\"><img src=\"https://common.cnblogs.com/images/copycode.gif\" alt=\"复制代码\"></a></span></div><pre><span>yum -y install gcc-c++</span>（需要等待几分钟）</pre><pre><span>yum install pcre  （需要等待几分钟）\n\nyum install pcre-devel  （需要等待几分钟）\n\nyum install zlib  （需要等待几分钟）\n\nyum install zlib-devel   （需要等待几分钟）</span></pre><div class=\"cnblogs_code_toolbar\"><span class=\"cnblogs_code_copy\"><a title=\"复制代码\"><img src=\"https://common.cnblogs.com/images/copycode.gif\" alt=\"复制代码\"></a></span></div></div><p>3、解压安装包&nbsp;</p><div class=\"cnblogs_code\"><pre>tar -zxvf nginx-<span>1.6</span>.<span>3</span>.tar.gz -C /usr/local/</pre></div><p>4、在&nbsp;/usr/local/下输入代码进行配置 ：</p><div class=\"cnblogs_code\"><pre>cd nginx-<span>1.6</span>.<span>3</span> &amp;&amp; ./configure --prefix=/usr/local/nginx</pre></div><p>5、<span class=\"md-plain\">运行 make&amp;&amp;make install 编译安装</span></p><p class=\"md-end-block md-p md-focus\"><span class=\"md-plain\">&nbsp; &nbsp;然后我们看见 /usr/local/下有nginx文件夹了，进入之后是这个样子的（conf是配置文件目录、html是root目录（网页文件）、logs是日志文件目录、sbin是主要二进制程序目录）</span></p><p class=\"md-end-block md-p md-focus\"><span class=\"md-plain\"><img src=\"https://img2018.cnblogs.com/blog/1709112/201910/1709112-20191029000231834-1618794328.png\" alt=\"\"></span></p><p>&nbsp;</p><p>&nbsp;6、接下来我们启动nginx ：</p><div class=\"cnblogs_code\"><pre>/usr/local/nginx/sbin/nginx</pre></div><p>7、我们运行如下命令进行检测，查看nginx是否启动</p><div class=\"cnblogs_code\"><pre>ps -ef|grep nginx</pre></div><p>如果是下图这个样子的，那就是启动成功了</p><p><img src=\"https://img2018.cnblogs.com/blog/1709112/201910/1709112-20191029000438169-981588757.png\" alt=\"\"></p><p>&nbsp;</p><p>&nbsp;8、<span class=\"md-plain\">然后我们打开浏览器访问一下虚拟机的地址会出现如下界面，到此nginx的安装与启动就完成了。</span></p><p><span class=\"md-plain\"><img src=\"https://img2018.cnblogs.com/blog/1709112/201910/1709112-20191029000502300-1404973098.png\" alt=\"\"></span></p><p>&nbsp;</p><p><strong>&nbsp;如果没有访问成功（浏览器转圈圈），请试着运行以下命令</strong></p><p class=\"md-end-block md-p md-focus\">&nbsp;</p><div class=\"cnblogs_code\"><pre>firewall-cmd --state  看防火墙状态（可省）</pre></div><p>如果结果是running请运行如下命令</p><div class=\"cnblogs_code\"><pre>firewall-cmd --permanent --zone=public --add-port=8080/tcp 添加开放端口</pre></div><p>然后重新加载</p><div class=\"cnblogs_code\"><pre>firewall-cmd --reload</pre></div><p>nginx的其他语句如下</p><div class=\"cnblogs_code\"><pre><span>/usr/local/nginx/sbin/nginx -s stop    停止<br>\n/usr/local/nginx/sbin/nginx -s reload    重启</span></pre></div>', '1', '2019-11-01 11:56:11', NULL);

-- ----------------------------
-- Table structure for ip_count_t
-- ----------------------------
DROP TABLE IF EXISTS `ip_count_t`;
CREATE TABLE `ip_count_t`  (
  `ip_id` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `access_ip` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`ip_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for picture_t
-- ----------------------------
DROP TABLE IF EXISTS `picture_t`;
CREATE TABLE `picture_t`  (
  `pic_id` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pic_sname` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pic_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pic_status` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `outer_id` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pic_type` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`pic_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
