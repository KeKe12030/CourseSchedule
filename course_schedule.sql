-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- 主机： localhost
-- 生成日期： 2020-12-22 22:33:28
-- 服务器版本： 8.0.19
-- PHP 版本： 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 数据库： `course_schedule`
--

-- --------------------------------------------------------

--
-- 表的结构 `courses`
--

CREATE TABLE `courses` (
  `id` tinyint NOT NULL COMMENT '课程id',
  `name` char(6) NOT NULL COMMENT '课程名称',
  `teacher` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '授课老师',
  `sub_course` tinyint(1) NOT NULL COMMENT '是否为副课'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `courses`
--

INSERT INTO `courses` (`id`, `name`, `teacher`, `sub_course`) VALUES
(1, '语文', '语文老师', 1),
(2, '数学', '数学老师', 1),
(3, '外语', '外语老师', 1),
(4, '物理', '物理老师', 0),
(5, '化学', '化学老师', 0),
(6, '生物', '生物老师', 0),
(7, '政治', '政治老师', 0),
(8, '历史', '历史老师', 0),
(9, '地理', '地理老师', 0),
(10, '音乐', '音乐老师', 0),
(11, '美术', '美术老师', 0),
(12, '体育', '体育老师', 0),
(13, '班会', '班主任', 1),
(14, '自习', '无', 0);

-- --------------------------------------------------------

--
-- 表的结构 `timetable`
--

CREATE TABLE `timetable` (
  `cid` tinyint NOT NULL COMMENT '对应课程id',
  `number` tinyint NOT NULL COMMENT '第几节课',
  `week` tinyint(1) NOT NULL COMMENT '课程星期',
  `round` tinyint(1) NOT NULL COMMENT '第几轮周的课'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `timetable`
--

INSERT INTO `timetable` (`cid`, `number`, `week`, `round`) VALUES
(1, 3, 1, 0),
(1, 5, 1, 0),
(1, 1, 2, 0),
(1, 2, 3, 0),
(1, 4, 4, 0),
(1, 5, 4, 0),
(2, 2, 1, 0),
(2, 3, 2, 0),
(2, 1, 3, 0),
(2, 2, 4, 0),
(2, 6, 4, 0),
(2, 2, 5, 0),
(3, 1, 1, 0),
(3, 2, 2, 0),
(3, 4, 3, 0),
(3, 3, 4, 0),
(3, 7, 4, 0),
(3, 7, 5, 0),
(4, 7, 1, 0),
(4, 5, 2, 0),
(4, 1, 5, 0),
(5, 4, 1, 0),
(5, 3, 3, 0),
(5, 3, 5, 0),
(6, 7, 2, 0),
(6, 8, 3, 0),
(6, 9, 3, 0),
(6, 5, 5, 0),
(7, 6, 1, 0),
(7, 5, 3, 0),
(7, 6, 5, 0),
(8, 1, 4, 0),
(9, 6, 2, 0),
(9, 6, 3, 0),
(9, 7, 3, 0),
(9, 4, 5, 0),
(10, 8, 5, 0),
(11, 8, 2, 0),
(12, 8, 1, 0),
(12, 8, 4, 0),
(13, 9, 1, 0),
(14, 4, 2, 0),
(14, 9, 2, 0),
(14, 9, 4, 0),
(3, 10, 1, 0),
(3, 11, 1, 0),
(5, 10, 2, 0),
(1, 11, 2, 0),
(2, 10, 3, 0),
(4, 11, 3, 0),
(9, 10, 4, 0),
(6, 11, 4, 0),
(1, 1, 7, 0),
(1, 2, 7, 0),
(2, 4, 7, 0),
(2, 5, 7, 0),
(3, 6, 7, 1),
(7, 7, 7, 1),
(3, 8, 7, 1),
(2, 9, 7, 1),
(3, 6, 7, 2),
(7, 7, 7, 2),
(3, 8, 7, 2),
(1, 9, 7, 2),
(2, 6, 7, 3),
(7, 7, 7, 3),
(3, 8, 7, 3),
(1, 9, 7, 3),
(10, 11, 7, 0),
(9, 10, 7, 0);

--
-- 转储表的索引
--

--
-- 表的索引 `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`id`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `courses`
--
ALTER TABLE `courses`
  MODIFY `id` tinyint NOT NULL AUTO_INCREMENT COMMENT '课程id', AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
