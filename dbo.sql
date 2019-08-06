/*
Navicat SQL Server Data Transfer

Source Server         : 192.168.120.101
Source Server Version : 120000
Source Host           : 192.168.120.101:1433
Source Database       : PF.Log_bak
Source Schema         : dbo

Target Server Type    : SQL Server
Target Server Version : 120000
File Encoding         : 65001

Date: 2019-03-19 11:19:14
*/


-- ----------------------------
-- Table structure for MessageLogs
-- ----------------------------
DROP TABLE [dbo].[MessageLogs]
GO
CREATE TABLE [dbo].[MessageLogs] (
[Id] nvarchar(50) NOT NULL ,
[ReceiveMsgID] nvarchar(500) NULL ,
[ReceiveSenderID] nvarchar(500) NULL ,
[ReceiveTime] datetime NULL ,
[ReceiveContent] nvarchar(MAX) NULL ,
[ReceiveEventName] nvarchar(500) NULL ,
[ReceiveEventNameCN] nvarchar(500) NULL ,
[ReceiveStatus] int NULL ,
[SendEventName] nvarchar(500) NULL ,
[SendEventNameCN] nvarchar(500) NULL ,
[SendContent] nvarchar(MAX) NULL ,
[SendTime] datetime NULL ,
[SendStatus] int NOT NULL ,
[IsReply] int NULL ,
[ErrorMsg] nvarchar(MAX) NULL ,
[StackTrace] nvarchar(MAX) NULL ,
[CreateTime] datetime NOT NULL ,
[SendOrReceive] bit NULL DEFAULT ((0)) ,
[UserId] nvarchar(40) NULL 
)


GO

-- ----------------------------
-- Indexes structure for table MessageLogs
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table MessageLogs
-- ----------------------------
ALTER TABLE [dbo].[MessageLogs] ADD PRIMARY KEY ([Id])
GO
