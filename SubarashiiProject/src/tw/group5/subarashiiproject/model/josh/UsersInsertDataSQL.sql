USE [MyHBN]
GO

TRUNCATE TABLE users

SET IDENTITY_INSERT [dbo].[users] ON 
GO
INSERT [dbo].[users] ([uid], [username], [userpsw]) VALUES (1, N'testname', N'testpsw')
GO
SET IDENTITY_INSERT [dbo].[users] OFF
GO
