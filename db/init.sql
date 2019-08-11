
DROP DATABASE IF EXISTS `springmvc`;

CREATE DATABASE  `springmvc` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;


USE `springmvc`;

-- ----------------------------
--  Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_name` varchar(60) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(40) NOT NULL DEFAULT '' COMMENT '加密后的密码',
  `phone` varchar(13) NOT NULL DEFAULT '' COMMENT '手机号',
  `mail` varchar(20) NOT NULL DEFAULT '' COMMENT '邮箱',
  `avatar` varchar(255) NULL DEFAULT NULL COMMENT '头像',
  `dept_id` int(11) NOT NULL DEFAULT '0' COMMENT '部门的id',
  `status` char(1) NOT NULL DEFAULT '1' COMMENT '状态，1：正常，0：冻结状态，2：删除',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `operator` varchar(20) NOT NULL DEFAULT '' COMMENT '操作者',
  `operate_ip` varchar(20) NOT NULL DEFAULT '' COMMENT '最后一次更新者的ip地址',
  `wx_openid` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '微信openid',
  `qq_openid` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'QQ openid',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4  ROW_FORMAT=DYNAMIC COMMENT='用户表';

-- -------------------------sys_user---
--  Records of `sys_user`
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES (1, 'admin', '123456','18612344321', 'admin@qq.com',null,'0',1,'超级管理员', null,null, 'system', '127.0.0.1', '','');
COMMIT;




















