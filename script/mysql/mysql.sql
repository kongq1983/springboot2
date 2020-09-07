

-- DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` bigint(20) NOT NULL,
  `username` varchar(32) NOT NULL,
  `phone` varchar(32) DEFAULT NULL,
  `province` varchar(64) DEFAULT NULL,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `username` varchar(32) NOT NULL,
  `phone` varchar(32) DEFAULT NULL,
  `province` varchar(64) DEFAULT NULL,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `person` (
  `id` bigint(20) NOT NULL,
  `username` varchar(32) NOT NULL,
  `phone` varchar(32) DEFAULT NULL,
  `province` varchar(64) DEFAULT NULL,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;