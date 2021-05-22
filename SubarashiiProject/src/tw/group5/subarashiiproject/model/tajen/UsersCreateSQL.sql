USE [MyHBN]
GO

drop table if exists [dbo].[users]
GO

CREATE TABLE [dbo].[users](
	[uid] [int] IDENTITY(1,1) PRIMARY KEY,
	[username] [nvarchar](50) NOT NULL,
	[userpsw] [nvarchar](50) NOT NULL,
)
GO

INSERT [dbo].[users] VALUES (N'Okabe', N'ahahahahaha')
GO
INSERT [dbo].[users]  VALUES (N'usada', N'hahaha0112')
GO


