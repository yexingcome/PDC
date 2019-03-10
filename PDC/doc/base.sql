SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for qrtz_blob_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_blob_triggers`;
CREATE TABLE `qrtz_blob_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `BLOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `SCHED_NAME` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_blob_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_calendars
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_calendars`;
CREATE TABLE `qrtz_calendars` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `CALENDAR_NAME` varchar(200) NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`CALENDAR_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_calendars
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_cron_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_cron_triggers`;
CREATE TABLE `qrtz_cron_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `CRON_EXPRESSION` varchar(120) NOT NULL,
  `TIME_ZONE_ID` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_cron_triggers
-- ----------------------------
INSERT INTO `qrtz_cron_triggers` VALUES ('RenrenScheduler', 'TASK_4', 'DEFAULT', '2 * * * * ?', 'Asia/Shanghai');

-- ----------------------------
-- Table structure for qrtz_fired_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_fired_triggers`;
CREATE TABLE `qrtz_fired_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `ENTRY_ID` varchar(95) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `FIRED_TIME` bigint(13) NOT NULL,
  `SCHED_TIME` bigint(13) NOT NULL,
  `PRIORITY` int(11) NOT NULL,
  `STATE` varchar(16) NOT NULL,
  `JOB_NAME` varchar(200) DEFAULT NULL,
  `JOB_GROUP` varchar(200) DEFAULT NULL,
  `IS_NONCONCURRENT` varchar(1) DEFAULT NULL,
  `REQUESTS_RECOVERY` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`ENTRY_ID`),
  KEY `IDX_QRTZ_FT_TRIG_INST_NAME` (`SCHED_NAME`,`INSTANCE_NAME`),
  KEY `IDX_QRTZ_FT_INST_JOB_REQ_RCVRY` (`SCHED_NAME`,`INSTANCE_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_QRTZ_FT_J_G` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_FT_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_FT_T_G` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_FT_TG` (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_fired_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_job_details
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_job_details`;
CREATE TABLE `qrtz_job_details` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) NOT NULL,
  `IS_DURABLE` varchar(1) NOT NULL,
  `IS_NONCONCURRENT` varchar(1) NOT NULL,
  `IS_UPDATE_DATA` varchar(1) NOT NULL,
  `REQUESTS_RECOVERY` varchar(1) NOT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_J_REQ_RECOVERY` (`SCHED_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_QRTZ_J_GRP` (`SCHED_NAME`,`JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_job_details
-- ----------------------------
INSERT INTO `qrtz_job_details` VALUES ('RenrenScheduler', 'TASK_4', 'DEFAULT', null, 'io.renren.modules.job.utils.ScheduleJob', '0', '0', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B45597400F37B226A6F624964223A342C226265616E4E616D65223A2272657075626C69635265636F72645461736B222C226D6574686F644E616D65223A2272657075626C69635265636F72645461736B222C2263726F6E45787072657373696F6E223A2232202A202A202A202A203F222C22737461747573223A302C2272656D61726B223A22E88EB7E58F96E695B0E68DAEE5BA93E4B8ADE69CAAE58F91E5B883E79A84E5B7A5E58D95EFBC8CE8A681E68C89E785A7E7949FE68890E697B6E997B4E9A1BAE5BA8FE68E92E58897222C2263726561746554696D65223A224465632031382C20323031382031313A33303A343620414D227D7800);

-- ----------------------------
-- Table structure for qrtz_locks
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_locks`;
CREATE TABLE `qrtz_locks` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `LOCK_NAME` varchar(40) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`LOCK_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_locks
-- ----------------------------
INSERT INTO `qrtz_locks` VALUES ('RenrenScheduler', 'STATE_ACCESS');
INSERT INTO `qrtz_locks` VALUES ('RenrenScheduler', 'TRIGGER_ACCESS');

-- ----------------------------
-- Table structure for qrtz_paused_trigger_grps
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;
CREATE TABLE `qrtz_paused_trigger_grps` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_paused_trigger_grps
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_scheduler_state
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_scheduler_state`;
CREATE TABLE `qrtz_scheduler_state` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
  `CHECKIN_INTERVAL` bigint(13) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`INSTANCE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_scheduler_state
-- ----------------------------
INSERT INTO `qrtz_scheduler_state` VALUES ('RenrenScheduler', 'USER-20170804XC1545103727126', '1545104825544', '15000');

-- ----------------------------
-- Table structure for qrtz_simple_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simple_triggers`;
CREATE TABLE `qrtz_simple_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `REPEAT_COUNT` bigint(7) NOT NULL,
  `REPEAT_INTERVAL` bigint(12) NOT NULL,
  `TIMES_TRIGGERED` bigint(10) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_simple_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_simprop_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simprop_triggers`;
CREATE TABLE `qrtz_simprop_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `STR_PROP_1` varchar(512) DEFAULT NULL,
  `STR_PROP_2` varchar(512) DEFAULT NULL,
  `STR_PROP_3` varchar(512) DEFAULT NULL,
  `INT_PROP_1` int(11) DEFAULT NULL,
  `INT_PROP_2` int(11) DEFAULT NULL,
  `LONG_PROP_1` bigint(20) DEFAULT NULL,
  `LONG_PROP_2` bigint(20) DEFAULT NULL,
  `DEC_PROP_1` decimal(13,4) DEFAULT NULL,
  `DEC_PROP_2` decimal(13,4) DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_simprop_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_triggers`;
CREATE TABLE `qrtz_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PREV_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PRIORITY` int(11) DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) NOT NULL,
  `TRIGGER_TYPE` varchar(8) NOT NULL,
  `START_TIME` bigint(13) NOT NULL,
  `END_TIME` bigint(13) DEFAULT NULL,
  `CALENDAR_NAME` varchar(200) DEFAULT NULL,
  `MISFIRE_INSTR` smallint(2) DEFAULT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_T_J` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_T_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_T_C` (`SCHED_NAME`,`CALENDAR_NAME`),
  KEY `IDX_QRTZ_T_G` (`SCHED_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_T_STATE` (`SCHED_NAME`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_N_STATE` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_N_G_STATE` (`SCHED_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_NEXT_FIRE_TIME` (`SCHED_NAME`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_ST` (`SCHED_NAME`,`TRIGGER_STATE`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE_GRP` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `qrtz_job_details` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_triggers
-- ----------------------------
INSERT INTO `qrtz_triggers` VALUES ('RenrenScheduler', 'TASK_4', 'DEFAULT', 'TASK_4', 'DEFAULT', null, '1545103982000', '1545103922000', '5', 'PAUSED', 'CRON', '1545103846000', '0', null, '2', '');

-- ----------------------------
-- Table structure for schedule_job
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job`;
CREATE TABLE `schedule_job` (
  `job_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务id',
  `bean_name` varchar(200) DEFAULT NULL COMMENT 'spring bean名称',
  `method_name` varchar(100) DEFAULT NULL COMMENT '方法名',
  `params` varchar(2000) DEFAULT NULL COMMENT '参数',
  `cron_expression` varchar(100) DEFAULT NULL COMMENT 'cron表达式',
  `status` tinyint(4) DEFAULT NULL COMMENT '任务状态  0：正常  1：暂停',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='定时任务';

-- ----------------------------
-- Records of schedule_job
-- ----------------------------
INSERT INTO `schedule_job` VALUES ('4', 'republicRecordTask', 'republicRecordTask', null, '2 * * * * ?', '1', '获取数据库中未发布的工单，要按照生成时间顺序排列', '2018-12-18 11:30:47');

-- ----------------------------
-- Table structure for schedule_job_log
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job_log`;
CREATE TABLE `schedule_job_log` (
  `log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志id',
  `job_id` bigint(20) NOT NULL COMMENT '任务id',
  `bean_name` varchar(200) DEFAULT NULL COMMENT 'spring bean名称',
  `method_name` varchar(100) DEFAULT NULL COMMENT '方法名',
  `params` varchar(2000) DEFAULT NULL COMMENT '参数',
  `status` tinyint(4) NOT NULL COMMENT '任务状态    0：成功    1：失败',
  `error` varchar(2000) DEFAULT NULL COMMENT '失败信息',
  `times` int(11) NOT NULL COMMENT '耗时(单位：毫秒)',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`log_id`),
  KEY `job_id` (`job_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='定时任务日志';

-- ----------------------------
-- Records of schedule_job_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `key` varchar(50) DEFAULT NULL COMMENT 'key',
  `value` varchar(2000) DEFAULT NULL COMMENT 'value',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态   0：隐藏   1：显示',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `key` (`key`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统配置信息表';

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES ('1', 'CLOUD_STORAGE_CONFIG_KEY', '{\"aliyunAccessKeyId\":\"\",\"aliyunAccessKeySecret\":\"\",\"aliyunBucketName\":\"\",\"aliyunDomain\":\"\",\"aliyunEndPoint\":\"\",\"aliyunPrefix\":\"\",\"qcloudBucketName\":\"\",\"qcloudDomain\":\"\",\"qcloudPrefix\":\"\",\"qcloudSecretId\":\"\",\"qcloudSecretKey\":\"\",\"qiniuAccessKey\":\"NrgMfABZxWLo5B-YYSjoE8-AZ1EISdi1Z3ubLOeZ\",\"qiniuBucketName\":\"ios-app\",\"qiniuDomain\":\"http://7xqbwh.dl1.z0.glb.clouddn.com\",\"qiniuPrefix\":\"upload\",\"qiniuSecretKey\":\"uIwJHevMRWU0VLxFvgy0tAcOdGqasdtVlJkdy6vV\",\"type\":1}', '0', '云存储配置信息');

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) DEFAULT NULL COMMENT '请求参数',
  `time` bigint(20) NOT NULL COMMENT '执行时长(毫秒)',
  `ip` varchar(64) DEFAULT NULL COMMENT 'IP地址',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='系统日志';

-- ----------------------------
-- Records of sys_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8 COMMENT='菜单管理';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '0', '系统管理', null, null, '0', 'fa fa-cog', '9');
INSERT INTO `sys_menu` VALUES ('2', '1', '管理员列表', 'modules/sys/user.html', null, '1', 'fa fa-user', '1');
INSERT INTO `sys_menu` VALUES ('3', '1', '角色管理', 'modules/sys/role.html', null, '1', 'fa fa-user-secret', '2');
INSERT INTO `sys_menu` VALUES ('4', '1', '菜单管理', 'modules/sys/menu.html', null, '1', 'fa fa-th-list', '3');
INSERT INTO `sys_menu` VALUES ('5', '1', 'SQL监控', 'druid/sql.html', null, '1', 'fa fa-bug', '4');
INSERT INTO `sys_menu` VALUES ('6', '1', '定时任务', 'modules/job/schedule.html', null, '1', 'fa fa-tasks', '5');
INSERT INTO `sys_menu` VALUES ('7', '6', '查看', null, 'sys:schedule:list,sys:schedule:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('8', '6', '新增', null, 'sys:schedule:save', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('9', '6', '修改', null, 'sys:schedule:update', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('10', '6', '删除', null, 'sys:schedule:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('11', '6', '暂停', null, 'sys:schedule:pause', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('12', '6', '恢复', null, 'sys:schedule:resume', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('13', '6', '立即执行', null, 'sys:schedule:run', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('14', '6', '日志列表', null, 'sys:schedule:log', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('15', '2', '查看', null, 'sys:user:list,sys:user:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('16', '2', '新增', null, 'sys:user:save,sys:role:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('17', '2', '修改', null, 'sys:user:update,sys:role:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('18', '2', '删除', null, 'sys:user:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('19', '3', '查看', null, 'sys:role:list,sys:role:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('20', '3', '新增', null, 'sys:role:save,sys:menu:list', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('21', '3', '修改', null, 'sys:role:update,sys:menu:list', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('22', '3', '删除', null, 'sys:role:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('23', '4', '查看', null, 'sys:menu:list,sys:menu:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('24', '4', '新增', null, 'sys:menu:save,sys:menu:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('25', '4', '修改', null, 'sys:menu:update,sys:menu:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('26', '4', '删除', null, 'sys:menu:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('27', '1', '参数管理', 'modules/sys/config.html', 'sys:config:list,sys:config:info,sys:config:save,sys:config:update,sys:config:delete', '1', 'fa fa-sun-o', '6');
INSERT INTO `sys_menu` VALUES ('29', '1', '系统日志', 'modules/sys/log.html', 'sys:log:list', '1', 'fa fa-file-text-o', '7');
INSERT INTO `sys_menu` VALUES ('36', '0', '发布记录', 'modules/dds/ddspublicrecord.html', null, '1', 'fa fa-file-code-o', '2');
INSERT INTO `sys_menu` VALUES ('37', '36', '查看', null, 'dds:ddspublicrecord:list,dds:ddspublicrecord:info', '2', null, '2');
INSERT INTO `sys_menu` VALUES ('38', '36', '新增', null, 'dds:ddspublicrecord:save', '2', null, '2');
INSERT INTO `sys_menu` VALUES ('39', '36', '修改', null, 'dds:ddspublicrecord:update', '2', null, '2');
INSERT INTO `sys_menu` VALUES ('40', '36', '删除', null, 'dds:ddspublicrecord:delete', '2', null, '2');
INSERT INTO `sys_menu` VALUES ('41', '0', '路由配置', 'modules/dds/ddsrouteconfig.html', null, '1', 'fa fa-file-code-o', '1');
INSERT INTO `sys_menu` VALUES ('42', '41', '查看', null, 'dds:ddsrouteconfig:list,dds:ddsrouteconfig:info', '2', null, '1');
INSERT INTO `sys_menu` VALUES ('43', '41', '新增', null, 'dds:ddsrouteconfig:save', '2', null, '1');
INSERT INTO `sys_menu` VALUES ('44', '41', '修改', null, 'dds:ddsrouteconfig:update', '2', null, '1');
INSERT INTO `sys_menu` VALUES ('45', '41', '删除', null, 'dds:ddsrouteconfig:delete', '2', null, '1');
INSERT INTO `sys_menu` VALUES ('46', '0', '平台配置', 'modules/dds/ddsplatconfig.html', null, '1', 'fa fa-file-code-o', '0');
INSERT INTO `sys_menu` VALUES ('47', '46', '查看', null, 'dds:ddsplatconfig:list,dds:ddsplatconfig:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('48', '46', '新增', null, 'dds:ddsplatconfig:save', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('49', '46', '修改', null, 'dds:ddsplatconfig:update', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('50', '46', '删除', null, 'dds:ddsplatconfig:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('51', '36', '重新发布', null, 'dds:ddspublicrecord:republish', '2', null, '0');

-- ----------------------------
-- Table structure for sys_oss
-- ----------------------------
DROP TABLE IF EXISTS `sys_oss`;
CREATE TABLE `sys_oss` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(200) DEFAULT NULL COMMENT 'URL地址',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文件上传';

-- ----------------------------
-- Records of sys_oss
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `salt` varchar(20) DEFAULT NULL COMMENT '盐',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '9ec9750e709431dad22365cabc5c625482e574c74adaebba7dd02f1129e4ce1d', 'YzcmCZNvbXocrsz9dm8e', '745235790@qq.com', '17740575421', '1', '1', '2016-11-11 11:11:11');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_token
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_token`;
CREATE TABLE `sys_user_token` (
  `user_id` bigint(20) NOT NULL,
  `token` varchar(100) NOT NULL COMMENT 'token',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `token` (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户Token';

-- ----------------------------
-- Records of sys_user_token
-- ----------------------------
INSERT INTO `sys_user_token` VALUES ('1', 'ce77d6aa4e7927fe06e65e0db52401a3', '2018-12-18 21:33:15', '2018-12-18 09:33:15');

-- ----------------------------
-- Table structure for tb_token
-- ----------------------------
DROP TABLE IF EXISTS `tb_token`;
CREATE TABLE `tb_token` (
  `user_id` bigint(20) NOT NULL,
  `token` varchar(100) NOT NULL COMMENT 'token',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `token` (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户Token';

-- ----------------------------
-- Records of tb_token
-- ----------------------------

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `mobile` varchar(20) NOT NULL COMMENT '手机号',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'mark', '13612345678', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', '2017-03-23 22:37:41');

CREATE TABLE `dds_goods_service` (
  `id` varchar(32) NOT NULL COMMENT '唯一标识，UUID',
  `jsonvalue` varchar(2000) NOT NULL COMMENT '原始json、xml数据',
  `service_type` int(11) NOT NULL COMMENT '业务类型； 1 维护商品 2 删除商品',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `frominterfacepro` varchar(32) NOT NULL DEFAULT '' COMMENT '来自那个平台: BOSS-BO-V1  BOSS-BO-V2',
  PRIMARY KEY (`id`),
  UNIQUE KEY `identify` (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='关于商品类接口';

CREATE TABLE `dds_user_service` (
  `id` varchar(32) NOT NULL COMMENT '唯一标识，UUID',
  `jsonvalue` varchar(2000) NOT NULL COMMENT '原始json、xml数据',
  `service_type` int(11) NOT NULL COMMENT '业务类型； 3 开户 4 修改用户状态 5 销户  9用户分组新增',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `frominterfacepro` varchar(32) NOT NULL COMMENT '来自那个平台: BOSS-BO-V1  BOSS-BO-V2',
  PRIMARY KEY (`id`),
  UNIQUE KEY `identify` (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='关于用户信息类接口';

CREATE TABLE `dds_auth_service` (
  `id` varchar(32) NOT NULL COMMENT '唯一标识，UUID',
  `jsonvalue` varchar(2000) NOT NULL COMMENT '原始json、xml数据',
  `service_type` int(11) NOT NULL COMMENT '业务类型； 6 维护用户商品授权接口 7 删除用户商品授权接口 8 刷新用户及授权接口',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `frominterfacepro` varchar(32) NOT NULL COMMENT '来自那个平台: BOSS-BO-V1  BOSS-BO-V2',
  PRIMARY KEY (`id`),
  UNIQUE KEY `identify` (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='关于授权类接口';

DROP TABLE IF EXISTS `dds_plat_config`;
CREATE TABLE `dds_plat_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `identity` varchar(255) DEFAULT NULL COMMENT '平台标识',
  `name` varchar(255) DEFAULT NULL COMMENT '平台名称',
  `service_url` varchar(255) DEFAULT NULL COMMENT '平台服务地址',
  `maxAccept` varchar(255) DEFAULT NULL COMMENT '内容分发阈值',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='平台配置';

-- ----------------------------
-- Records of dds_plat_config
-- ----------------------------
INSERT INTO `dds_plat_config` VALUES ('2', 'BOSS', '业务运营支撑系统', null, '100', '2018-12-12 16:52:09', '2018-12-21 09:27:30');
INSERT INTO `dds_plat_config` VALUES ('3', 'BO', '互动平台', 'http://172.16.149.212:28080/OssWeb/CMSManageService', '100', '2018-12-12 16:52:36', '2018-12-21 09:27:24');
INSERT INTO `dds_plat_config` VALUES ('4', 'IPVP', 'IP视频平台', 'http://172.31.134.236:7080/XA', '100', '2018-12-17 16:59:36', '2018-12-21 09:27:20');

-- ----------------------------
-- Table structure for dds_public_record
-- ----------------------------
DROP TABLE IF EXISTS `dds_public_record`;
CREATE TABLE `dds_public_record` (
  `id` varchar(40) NOT NULL COMMENT '工单号',
  `route_id` int(11) DEFAULT NULL,
  `business_type` varchar(255) DEFAULT NULL COMMENT '1.商品维护；2.商品删除；3.开户；4.修改用户状态；5.销户；6.维护用户商品授权；7.删除用户商品授权；8.刷新用户及授权;9.互动用户分组;',
  `message` varchar(2000) DEFAULT NULL COMMENT '工单详细',
  `status` int(11) DEFAULT NULL COMMENT '-1：未发布，0:发布中，1：发布失败；2：发布成功',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `public_time` datetime DEFAULT NULL COMMENT '发布时间',
  `replay_time` datetime DEFAULT NULL COMMENT '回复时间',
  `replay_mess` varchar(1000) DEFAULT NULL COMMENT '上报信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='发布记录';

-- ----------------------------
-- Records of dds_public_record
-- ----------------------------

-- ----------------------------
-- Table structure for dds_route_config
-- ----------------------------
DROP TABLE IF EXISTS `dds_route_config`;
CREATE TABLE `dds_route_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `source_plat_id` int(11) DEFAULT NULL COMMENT '源平台',
  `target_plat_id` int(11) DEFAULT NULL,
  `soruce_interfacepro` varchar(255) DEFAULT NULL COMMENT '源平台协议',
  `target_interfacepro` varchar(255) DEFAULT NULL COMMENT '目标平台协议',
  `status` int(11) DEFAULT NULL COMMENT '1.启用；\r\n0，禁用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='路由配置';

-- ----------------------------
-- Records of dds_route_config
-- ----------------------------
INSERT INTO `dds_route_config` VALUES ('1', '2', '3', 'BOSS-BO-V1', 'BOSS-BO-V1', '1', '2018-12-17 17:11:53', '2018-12-13 10:11:10');
INSERT INTO `dds_route_config` VALUES ('2', '2', '4', 'BOSS-BO-V1', 'BOSS-BO-V2', '1', '2018-12-17 17:11:53', '2018-12-21 09:14:35');

INSERT INTO `sys_menu` (`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (NULL, 0, '入库管理', NULL, NULL, 0, 'fa fa-folder-o', 1);
set @parentId = @@identity;
INSERT INTO `sys_menu` (`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (NULL, @parentId, '商品类接口', 'modules/dds/ddsgoodsservice.html', NULL, 1, 'fa fa-file-code-o', 3);
set @parentIdTmp = @@identity;
INSERT INTO `sys_menu` (`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (NULL, @parentIdTmp, '查看', NULL, 'dds:ddsgoodsservice:list,dds:ddsgoodsservice:info', 2, NULL, 6);
INSERT INTO `sys_menu` (`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (NULL, @parentIdTmp, '删除', NULL, 'dds:ddsgoodsservice:delete', 2, NULL, 6);

INSERT INTO `sys_menu` (`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (NULL, @parentId, '用户信息类接口', 'modules/dds/ddsuserservice.html', NULL, 1, 'fa fa-file-code-o', 2);
set @parentIdTmp = @@identity;
INSERT INTO `sys_menu` (`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (NULL, @parentIdTmp, '查看', NULL, 'dds:ddsuserservice:list,dds:ddsuserservice:info', 2, NULL, 6);
INSERT INTO `sys_menu` (`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (NULL, @parentIdTmp, '删除', NULL, 'dds:ddsuserservice:delete', 2, NULL, 6);

INSERT INTO `sys_menu` (`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (NULL, @parentId, '授权类接口', 'modules/dds/ddsauthservice.html', NULL, 1, 'fa fa-file-code-o', 3);
set @parentIdTmp = @@identity;
INSERT INTO `sys_menu` (`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (NULL, @parentIdTmp, '查看', NULL, 'dds:ddsauthservice:list,dds:ddsauthservice:info', 2, NULL, 6);
INSERT INTO `sys_menu` (`menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`) VALUES (NULL, @parentIdTmp, '删除', NULL, 'dds:ddsauthservice:delete', 2, NULL, 6);

INSERT INTO `sys_config` VALUES (NULL, 'ForBossQueryClassInterfaceUrl', 'http://172.16.149.212:28080/OssWeb/CMSManageService', 1, NULL);


CREATE TABLE `dds_area` (
  `ID` varchar(40) NOT NULL,
  `name` varchar(20) DEFAULT NULL COMMENT '名称',
  `start_area` varchar(40) DEFAULT NULL COMMENT '开始区域码',
  `end_area` varchar(40) DEFAULT NULL COMMENT '结束区域码',
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `parent_id` varchar(40) DEFAULT NULL COMMENT '父级区域ID',
  `ids_full_path` varchar(400) DEFAULT NULL,
  `branch_no` varchar(8) DEFAULT NULL COMMENT '业务区标识',
  `branch_name` varchar(50) DEFAULT NULL COMMENT '业务区名称',
  PRIMARY KEY (`ID`),
  KEY `Index_area_1` (`start_area`,`end_area`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='区域';



-- 菜单SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    VALUES ('0', '区域', 'modules/dds/ddsarea.html', NULL, '1', 'fa fa-file-code-o', '6');

-- 按钮父菜单ID
set @parentId = @@identity;

-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @parentId, '查看', null, 'dds:ddsarea:list,dds:ddsarea:info', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @parentId, '新增', null, 'dds:ddsarea:save', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @parentId, '修改', null, 'dds:ddsarea:update', '2', null, '6';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`)
    SELECT @parentId, '删除', null, 'dds:ddsarea:delete', '2', null, '6';

ALTER TABLE `dds_public_record`
MODIFY COLUMN `create_time`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建时间字符串' AFTER `status`;

INSERT INTO `dds_area` (`ID`, `name`, `start_area`, `end_area`, `create_time`, `modify_time`, `parent_id`, `ids_full_path`, `branch_no`, `branch_name`) VALUES ('07b3b5f0-0ff2-11e9-aa78-f87588b3ceb3', '韶关', '2101', '2399', NULL, NULL, NULL, NULL, 'SG', '韶关');
INSERT INTO `dds_area` (`ID`, `name`, `start_area`, `end_area`, `create_time`, `modify_time`, `parent_id`, `ids_full_path`, `branch_no`, `branch_name`) VALUES ('1828da01-0ff2-11e9-aa78-f87588b3ceb3', '湛江', '2401', '2599', NULL, NULL, NULL, NULL, 'ZJ', '湛江');
INSERT INTO `dds_area` (`ID`, `name`, `start_area`, `end_area`, `create_time`, `modify_time`, `parent_id`, `ids_full_path`, `branch_no`, `branch_name`) VALUES ('28244335-0ff2-11e9-aa78-f87588b3ceb3', '肇庆', '2601', '2799', NULL, NULL, NULL, NULL, 'ZQ', '肇庆');
INSERT INTO `dds_area` (`ID`, `name`, `start_area`, `end_area`, `create_time`, `modify_time`, `parent_id`, `ids_full_path`, `branch_no`, `branch_name`) VALUES ('3c073e6f-0ff2-11e9-aa78-f87588b3ceb3', '江门', '2801', '2999', NULL, NULL, NULL, NULL, 'JM', '江门');
INSERT INTO `dds_area` (`ID`, `name`, `start_area`, `end_area`, `create_time`, `modify_time`, `parent_id`, `ids_full_path`, `branch_no`, `branch_name`) VALUES ('49c05f3f-0ff2-11e9-aa78-f87588b3ceb3', '茂名', '3001', '3199', NULL, NULL, NULL, NULL, 'MM', '茂名');
INSERT INTO `dds_area` (`ID`, `name`, `start_area`, `end_area`, `create_time`, `modify_time`, `parent_id`, `ids_full_path`, `branch_no`, `branch_name`) VALUES ('5602f68f-0ff2-11e9-aa78-f87588b3ceb3', '惠州', '3201', '3399', NULL, NULL, NULL, NULL, 'HZ', '惠州');
INSERT INTO `dds_area` (`ID`, `name`, `start_area`, `end_area`, `create_time`, `modify_time`, `parent_id`, `ids_full_path`, `branch_no`, `branch_name`) VALUES ('65c867b6-0ff2-11e9-aa78-f87588b3ceb3', '梅州', '3801', '3999', NULL, NULL, NULL, NULL, 'MZ', '梅州');
INSERT INTO `dds_area` (`ID`, `name`, `start_area`, `end_area`, `create_time`, `modify_time`, `parent_id`, `ids_full_path`, `branch_no`, `branch_name`) VALUES ('73f5d6d3-0ff2-11e9-aa78-f87588b3ceb3', '阳江', '4001', '4199', NULL, NULL, NULL, NULL, 'YJ', '阳江');
INSERT INTO `dds_area` (`ID`, `name`, `start_area`, `end_area`, `create_time`, `modify_time`, `parent_id`, `ids_full_path`, `branch_no`, `branch_name`) VALUES ('80f96738-0ff2-11e9-aa78-f87588b3ceb3', '清远', '4201', '4399', NULL, NULL, NULL, NULL, 'QY', '清远');
INSERT INTO `dds_area` (`ID`, `name`, `start_area`, `end_area`, `create_time`, `modify_time`, `parent_id`, `ids_full_path`, `branch_no`, `branch_name`) VALUES ('8d8cd776-0ff2-11e9-aa78-f87588b3ceb3', '东莞', '4401', '5399', NULL, NULL, NULL, NULL, 'DG', '东莞');
INSERT INTO `dds_area` (`ID`, `name`, `start_area`, `end_area`, `create_time`, `modify_time`, `parent_id`, `ids_full_path`, `branch_no`, `branch_name`) VALUES ('99589c96-0ff2-11e9-aa78-f87588b3ceb3', '中山', '5401', '6399', NULL, NULL, NULL, NULL, 'ZS', '中山');
INSERT INTO `dds_area` (`ID`, `name`, `start_area`, `end_area`, `create_time`, `modify_time`, `parent_id`, `ids_full_path`, `branch_no`, `branch_name`) VALUES ('a622a56b-0ff2-11e9-aa78-f87588b3ceb3', '潮州', '6401', '6599', NULL, NULL, NULL, NULL, 'CZ', '潮州');
INSERT INTO `dds_area` (`ID`, `name`, `start_area`, `end_area`, `create_time`, `modify_time`, `parent_id`, `ids_full_path`, `branch_no`, `branch_name`) VALUES ('b418a5e6-0ff1-11e9-aa78-f87588b3ceb3', '广州', '0101', '0999', NULL, NULL, NULL, NULL, 'GZ', '广州');
INSERT INTO `dds_area` (`ID`, `name`, `start_area`, `end_area`, `create_time`, `modify_time`, `parent_id`, `ids_full_path`, `branch_no`, `branch_name`) VALUES ('b8b38fb1-0ff2-11e9-aa78-f87588b3ceb3', '揭阳', '6601', '6799', NULL, NULL, NULL, NULL, 'JY', '揭阳');
INSERT INTO `dds_area` (`ID`, `name`, `start_area`, `end_area`, `create_time`, `modify_time`, `parent_id`, `ids_full_path`, `branch_no`, `branch_name`) VALUES ('c333b143-0ff1-11e9-aa78-f87588b3ceb3', '深圳', '1001', '1199', NULL, NULL, NULL, NULL, 'SZ', '深圳');
INSERT INTO `dds_area` (`ID`, `name`, `start_area`, `end_area`, `create_time`, `modify_time`, `parent_id`, `ids_full_path`, `branch_no`, `branch_name`) VALUES ('c83a9700-0ff2-11e9-aa78-f87588b3ceb3', '云浮', '6801', '6999', NULL, NULL, NULL, NULL, 'YF', '云浮');
INSERT INTO `dds_area` (`ID`, `name`, `start_area`, `end_area`, `create_time`, `modify_time`, `parent_id`, `ids_full_path`, `branch_no`, `branch_name`) VALUES ('de020bd6-0ff1-11e9-aa78-f87588b3ceb3', '珠海', '1201', '1399', NULL, NULL, NULL, NULL, 'ZH', '珠海');
INSERT INTO `dds_area` (`ID`, `name`, `start_area`, `end_area`, `create_time`, `modify_time`, `parent_id`, `ids_full_path`, `branch_no`, `branch_name`) VALUES ('ec7ab2df-0ff1-11e9-aa78-f87588b3ceb3', '汕头', '1401', '1599', NULL, NULL, NULL, NULL, 'ST', '汕头');
INSERT INTO `dds_area` (`ID`, `name`, `start_area`, `end_area`, `create_time`, `modify_time`, `parent_id`, `ids_full_path`, `branch_no`, `branch_name`) VALUES ('f9c46fc4-0ff1-11e9-aa78-f87588b3ceb3', '佛山', '1601', '2099', NULL, NULL, NULL, NULL, 'FS', '佛山');

drop procedure if exists public_record_date;
-- 创建存储过程(年月日 20190125)
CREATE PROCEDURE public_record_date(in tabetime VARCHAR(50))
BEGIN
    SET @createTbsql = CONCAT(
    'CREATE TABLE ',CONCAT('dds_public_record_',tabetime),' 
    (`id` varchar(40) NOT NULL COMMENT "工单号",
		`route_id` int(11) DEFAULT NULL,
		`business_type` varchar(255) DEFAULT NULL COMMENT "1.商品维护；2.商品删除；3.开户；4.修改用户状态；5.销户；6.维护用户商品授权；7.删除用户商品授权；8.刷新用户及授权;9.互动用户分组;",
		`message` varchar(2000) DEFAULT NULL COMMENT "工单详细",
		`status` int(11) DEFAULT NULL COMMENT "-1：未发布，0:发布中，1：发布失败；2：发布成功",
		`create_time` varchar(40) DEFAULT NULL COMMENT "创建时间",
		`public_time` datetime DEFAULT NULL COMMENT "发布时间",
		`replay_time` datetime DEFAULT NULL COMMENT "回复时间",
		`replay_mess` varchar(1000) DEFAULT NULL COMMENT "上报信息",
        `retry_time` int(2) DEFAULT "0" COMMENT "重试次数",
		PRIMARY KEY (`id`)
	  ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT="发布记录"
    ');

-- 执行动态生成的sql语句
 PREPARE temp FROM @createTbsql;

 EXECUTE temp;

 -- 将数据写入到表中；
 start transaction;

 SET @createcopysql = CONCAT('INSERT INTO ',CONCAT('dds_public_record_',tabetime) ,
' SELECT * FROM dds_public_record WHERE public_time BETWEEN CONCAT(DATE_FORMAT(',tabetime,',"%Y-%m-%d")," 00:00:00") AND CONCAT(DATE_FORMAT(',tabetime,',"%Y-%m-%d")," 23:59:59")');

 PREPARE temp1 FROM @createcopysql;

 EXECUTE temp1;

 -- 数据写完目标表后，删除原始数据
 DELETE FROM dds_public_record WHERE public_time BETWEEN CONCAT(DATE_FORMAT(tabetime,"%Y-%m-%d"),' 00:00:00') AND CONCAT(DATE_FORMAT(tabetime,"%Y-%m-%d"),' 23:59:59');

 commit;
 
END ;




-- 查看定时任务是否开启
SHOW VARIABLES LIKE '%event_sche%';

-- 开启定时任务
SET GLOBAL event_scheduler = 1;

-- ALTER EVENT eventName ON COMPLETION PRESERVE ENABLE;

-- SHOW EVENTS ;
CREATE EVENT `event_call_public_record_date` ON SCHEDULE EVERY 1 DAY STARTS '2019-01-29 03:00:00' ON COMPLETION NOT PRESERVE ENABLE DO CALL public_record_date(DATE_FORMAT(date_sub(curdate(),interval 4 day),"%Y%m%d"));




ALTER TABLE `dds_public_record`
ADD COLUMN `retry_time`  int(2) NULL DEFAULT '0' COMMENT '重试次数' AFTER `replay_mess`;

CREATE  EVENT `event_flushAuth` ON SCHEDULE EVERY 2 MINUTE STARTS '2019-01-31 17:42:09' ON COMPLETION NOT PRESERVE DISABLE DO UPDATE dds_public_record set `status` = '-1' , retry_time=1 WHERE replay_mess LIKE '%用户信息不存在%' 
AND route_id ='1' AND`status`='1' 
AND business_type ='6' AND retry_time =0 limit 200;

