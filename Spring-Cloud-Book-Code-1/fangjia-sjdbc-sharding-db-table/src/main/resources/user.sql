CREATE DATABASE `cxytiandi_0` CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';
CREATE DATABASE `cxytiandi_1` CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';

CREATE TABLE `user_0`(
	id bigint(64) not null,
	city varchar(20) not null,
	name varchar(20) not null,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user_1`(
	id bigint(64) not null,
	city varchar(20) not null,
	name varchar(20) not null,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;