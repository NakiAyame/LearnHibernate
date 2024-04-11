USE master
GO
DROP DATABASE IF EXISTS Test_hibernate
GO
CREATE DATABASE Test_hibernate
GO
USE Test_hibernate
GO

CREATE TABLE [Group] (
	id TINYINT PRIMARY KEY IDENTITY(1,1) NOT NULL
	,[name] [nvarchar](50) NOT NULL
)
GO

-- Insert records
INSERT INTO [Group]	([name])
VALUES							('Java'),
								('Java Web'),
								('ReactJs'),
								('PHP')
GO