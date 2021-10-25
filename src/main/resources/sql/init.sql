
CREATE DATABASE IF NOT EXISTS `my_system` ;
USE `my_system`;

 DROP TABLE IF EXISTS `board`;
CREATE TABLE IF NOT EXISTS `board` (
  `board_idx` bigint(20) NOT NULL AUTO_INCREMENT,
  `board_type` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `content` varchar(255) NOT NULL,
  `parent_category_idx` bigint(20) NOT NULL,
  `child__category_idx` bigint(20) NOT NULL,
  `create_by` varchar(255) NOT NULL,
  `create_date` datetime NOT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  PRIMARY KEY (`board_idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

 DROP TABLE IF EXISTS `child_category`;
CREATE TABLE IF NOT EXISTS `child_category` (
  `child_category_idx` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) NOT NULL,
  `create_by` varchar(255) NOT NULL,
  `create_date` datetime NOT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `use_yn` varchar(1) NOT NULL,
  PRIMARY KEY (`child_category_idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `file`;
CREATE TABLE IF NOT EXISTS `file` (
  `file_idx` bigint(20) NOT NULL AUTO_INCREMENT,
  `table_name` varchar(255) NOT NULL,
  `board_idx` bigint(20) NOT NULL,
  `uuid` varchar(255) NOT NULL,
  `original_file_name` varchar(255) NOT NULL,
  `upload_path` varchar(255) NOT NULL,
  `extension` varchar(255) NOT NULL,
  `create_by` varchar(255) NOT NULL,
  `create_date` datetime NOT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  PRIMARY KEY (`file_idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `parent_category`;
CREATE TABLE IF NOT EXISTS `parent_category` (
  `parent_category_idx` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) NOT NULL,
  `create_by` varchar(255) NOT NULL,
  `create_date` datetime NOT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `use_yn` varchar(1) NOT NULL,
  PRIMARY KEY (`parent_category_idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into parent_category(category_name, create_by, create_date) values('이모티콘About me', 'system', now(), 'Y');
insert into parent_category(category_name, create_by, create_date) values('망치그림 skill', 'system', now(), 'Y');
insert into parent_category(category_name, create_by, create_date) values('노트북그림 work experience & project', 'system', now(), 'Y');
insert into parent_category(category_name, create_by, create_date) values('자전거그림 personal experience & project', 'system', now(), 'Y');
insert into parent_category(category_name, create_by, create_date) values('학교그림 education & 자격증', 'system', now(), 'Y');

insert into child_category(category_name, create_by, create_date) values('Introduction', 'system', now(), 'Y');
insert into child_category(category_name, create_by, create_date) values('Concat & Channel', 'system', now(), 'Y');
insert into child_category(category_name, create_by, create_date) values('backend', 'system', now(), 'Y');
insert into child_category(category_name, create_by, create_date) values('devops', 'system', now(), 'Y');
insert into child_category(category_name, create_by, create_date) values('frontend', 'system', now(), 'Y');
insert into child_category(category_name, create_by, create_date) values('collaboration', 'system', now(), 'Y');
