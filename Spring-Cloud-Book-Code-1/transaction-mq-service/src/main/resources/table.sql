CREATE TABLE `transaction_message` (
  `id` bigint(64) NOT NULL,
  `message` varchar(1000) NOT NULL COMMENT '消息内容',
  `queue` varchar(50) NOT NULL COMMENT '队列名称',
  `send_system` varchar(20) NOT NULL COMMENT '发送消息的系统',
  `send_count` int(4) NOT NULL DEFAULT '0' COMMENT '重复发送消息次数',
  `c_date` datetime NOT NULL COMMENT '创建时间',
  `send_date` datetime DEFAULT NULL COMMENT '最近发送消息时间',
  `status` int(4) NOT NULL DEFAULT '0' COMMENT '状态：0等待消费  1已消费  2已死亡',
  `die_count` int(4) NOT NULL DEFAULT '0' COMMENT '死亡次数条件，由使用方决定，默认为发送10次还没被消费则标记死亡,人工介入',
  `customer_date` datetime DEFAULT NULL COMMENT '消费时间',
  `customer_system` varchar(50) DEFAULT NULL COMMENT '消费系统',
  `die_date` datetime DEFAULT NULL COMMENT '死亡时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;